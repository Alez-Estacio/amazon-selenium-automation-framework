package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie;
import java.time.Duration;

// Clase que representa la página de búsqueda de Amazon y sus acciones
public class AmazonSearchPage extends BasePage {

    // Localizador del cuadro de búsqueda
    private String searchBox = "//input[@id='twotabsearchtextbox']";
    // Localizador del botón de búsqueda
    private String searchButton = "//input[@id='nav-search-submit-button']";
    // Localizador de la tercera imagen en los resultados (XPath absoluto)
    private String thirdResult = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/a[1]/div[1]/img[1]";
    // Localizador del menú desplegable de cantidad
    private final By quantityDropdown = By.xpath("//span[@class='a-dropdown-prompt']");
    // Localizador de la opción "3" dentro del desplegable de cantidad
    private final By quantity3Option = By.xpath("//li[@aria-labelledby='quantity_2']//a");
    // Localizador del botón "Añadir al carrito"
    private final By addToCartButton = By.id("add-to-cart-button");
    // Localizador del mensaje que confirma la adición al carrito
    private String addedMessageText = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']";

    // Constructor que hereda driver desde BasePage
    public AmazonSearchPage() {
        super(driver);
    }

    // Navega a la URL de Amazon y fuerza la región a España
    public void navigateToAmazon() {
        navigateTo("htt s://www.amazon.com/-/es"); // Ir a la página de Amazon en español
        // Añadir cookie para forzar idioma/región
        driver.manage().addCookie(new Cookie("lc-main", "en_ES"));
        driver.navigate().refresh();// Refrescar para aplicar la cookie
    }

    // Introduce el texto de búsqueda en el cuadro y presiona Enter
    public void enterSearchCriteria(String criteria) {
        write(searchBox, criteria);
    }

    // Hace clic en el botón de búsqueda
    public void clickSearch() {
        clickElement(searchButton);
    }

    // Navega a la página indicada en los resultados (usa el texto del enlace)
    public void goToPage(String pageNumber) {
        goToLinkText(pageNumber);
    }

    // Selecciona el tercer resultado usando XPath absoluto
    public void pick3rdItem() {
        clickElement(thirdResult);
    }

    // Selecciona cantidad = 3 y añade al carrito
    public void addToCart() {
        // Abrir menú desplegable de cantidades
        wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown)).click();
        // Seleccionar la opción 3
        wait.until(ExpectedConditions.elementToBeClickable(quantity3Option)).click();
        // Finalmente, añadir al carrito

        clickElement(addToCartButton);
    }

    // Recupera el mensaje de confirmación tras añadir al carrito
    public String addedToCartMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(addedMessageText)));
        return confirmation.getText();// Devolver el texto del mensaje
    }

    // Método alternativo que agrupa selección de cantidad y añadir al carrito
    public void selectQuantityAndAddToCart() {
        // Selecciona la cantidad 3 con un método genérico
        selectFromDropdown(quantityDropdown, quantity3Option);
        // Hacer clic en "Añadir al carrito"
        clickElement(addToCartButton);
    }

}
