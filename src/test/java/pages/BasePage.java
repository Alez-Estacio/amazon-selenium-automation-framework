package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.java.tlh.latlh; se coloca asi porque queda alertada
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando
     * el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();

        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como
     * argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get("https://www.amazon.com/-/es");
        driver.manage().addCookie(new Cookie("lc-main", "en_US"));
        driver.navigate().refresh();
    }

    // Método ir y dar clinck a un texto que linque a otro lado.
    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        ;
    }

    // Método agregado para que funcione
    public String textFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    // Método estático para cerrar la instancia del driver.
    public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    /**
     * Click an element
     */
    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Click an element twice
     */
    public void clickElementTwice(By locator) {
        for (int i = 0; i < 2; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
    }

    /**
     * Select an option from a dropdown by clicking the dropdown and then the
     * option.
     */
    public void selectFromDropdown(By dropdownLocator, By optionLocator) {
        clickElement(dropdownLocator); // Open the dropdown
        clickElement(optionLocator); // Select the desired option
    }

    /*
     * Escribe texto en el campo indicado por el locator.
     * 
     * @param locator Ruta del elemento de entrada.
     * 
     * @param keysToSend Texto que se desea ingresar.
     */
    public void write(String locator, String keysToSend) {
        // Limpiar el campo antes de escribir
        Find(locator).clear();
        // Enviar las teclas al elemento
        Find(locator).sendKeys(keysToSend);
    }

    /*
     * Selecciona una opción de un dropdown por su valor "value".
     * 
     * @param locator Ruta del elemento <select>.
     * 
     * @param value Valor de la opción a seleccionar.
     */
    public void selectFromDropdownByValue(String locator, String value) {
        // Crear objeto Select para manejar <select> HTML
        Select dropdown = new Select(Find(locator));
        // Seleccionar la opción cuyo atributo "value" coincida

        dropdown.selectByValue(value);
    }

    /*
     * Selecciona una opción de un dropdown por su índice.
     * 
     * @param locator Ruta del elemento <select>.
     * 
     * @param index Índice (basado en 0) de la opción a seleccionar.
     */
    public void selectFromDropdownByIndex(String locator, Integer index) {
        // Crear objeto Select para manejar <select> HTML
        Select dropdown = new Select(Find(locator));
        // Seleccionar la opción en la posición indicada
        dropdown.selectByIndex(index);
    }

    /*
     * Retorna el número de opciones disponibles en un dropdown.
     * 
     * @param locator Ruta del elemento <select>.
     * 
     * @return Cantidad de <option> dentro del dropdown.
     */
    public int dropdownSize(String locator) {
        // Crear objeto Select para manejar <select> HTML
        Select dropdown = new Select(Find(locator));
        // Obtener todas las opciones
        List<WebElement> dropdownOptions = dropdown.getOptions();
        // Devolver la cantidad de opciones
        return dropdownOptions.size();
    }

    /*
     * Obtiene los textos de todas las opciones dentro de un dropdown.
     * 
     * @param locator Ruta del elemento <select>.
     * 
     * @return Lista de cadenas con el texto de cada opción.
     */
    public List<String> getDropdownValues(String locator) {
        // Crear objeto Select para manejar <select> HTML
        Select dropdown = new Select(Find(locator));
        // Obtener todas las opciones
        List<WebElement> dropdownOptions = dropdown.getOptions();
        // Listado donde guardaremos los textos
        List<String> values = new ArrayList<>();
        // Recorrer cada opción y extraer su texto
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        // Retornar lista de textos
        return values;

    }

}
