package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.AmazonSearchPage;

// Clase de pasos (step definitions) para el flujo de búsqueda y agregación de productos en Amazon
public class AmazonSearchSteps {
    // Instancia del Page Object que encapsula las acciones en la página de Amazon
    AmazonSearchPage amazon = new AmazonSearchPage();

    /**
     * Paso Given: Navegar a Amazon
     * Llama al método que abre el navegador y va a la URL configurable en
     * AmazonSearchPage
     */
    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon() {
        amazon.navigateToAmazon();// Abre Amazon y ajusta la región/idioma
    }

    /*
     * Paso And: Ingresar criterio de búsqueda y hacer clic en Buscar
     * 
     * @param criteria Producto a buscar (Alexa, playstation, etc.)
     */
    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria) {
        amazon.enterSearchCriteria(criteria); // Escribe en el campo de búsqueda
        amazon.clickSearch(); // Hace clic en el botón de búsqueda
    }

    /*
     * Paso And: Navegar a una página específica de resultados
     * 
     * @param pageNumber Número de página ("2" para la segunda página)
     */
    @And("^navigates to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber) {
        amazon.goToPage(pageNumber);// Selecciona el link de la página indicada
    }

    /**
     * Paso And: Seleccionar el tercer elemento de la lista de resultados
     */
    @And("^selects the third item$")
    public void selectsThirdItem() {
        amazon.pick3rdItem();// Hace clic en la imagen/enlace del tercer resultado
    }

    /**
     * Paso Then: Añadir el producto al carrito y verificar mensaje de confirmación
     */
    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToTheCart() {
        amazon.addToCart();// Ejecuta la lógica de selección de cantidad y clic en "Añadir al carrito"
        // Verificar que el mensaje mostrado coincide con lo esperado
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
}
