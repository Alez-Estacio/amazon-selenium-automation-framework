# language: en
@Amazon
# Funcionalidad: Prueba de la funcionalidad de búsqueda y agregado al carrito en Amazon
Feature: Test Amazon Search Functionality

    @Cart
    # Esquema del escenario: describe el flujo general usando ejemplos parametrizados
    Scenario Outline: Scenario Outline name: As a Customer  when I search for Alexa, I want to see if the third option on the second page is available for purchase and can be added to the cart.
        # Paso Dado: abre el navegador y navega a la URL de Amazon
        Given the user navigates to www.amazon.com
        # Paso Y: ingresa el término de búsqueda y ejecuta la búsqueda
        And searches for <Product>
        # Paso Y: va a la página de resultados indicada
        And navigates to the page number 2
        # Paso Y: selecciona el tercer elemento de la lista de resultados
        And selects the third item
        # Paso Entonces: comprueba que sea posible añadir el artículo al carrito
        Then the user is able to add it to the cart
        # Sección de ejemplos que define los valores para el parámetro <Producto>

        Examples:
            | Product     |
            | Alexa       |
            | playstation |

