# Proyecto de Automatización de Pruebas: Amazon Search & Cart

## Descripción

Este proyecto implementa la automatización de pruebas funcionales para la búsqueda y agregado de productos al carrito en Amazon, utilizando **Java**, **Selenium WebDriver**, **Cucumber** (BDD) y **JUnit**. El objetivo es validar que un usuario puede buscar productos, navegar entre páginas de resultados, seleccionar un producto y añadirlo al carrito correctamente.

## Tecnologías, Herramientas y Versiones

- **Lenguaje:** Java 17
- **Automatización Web:** Selenium WebDriver `4.15.0`
- **Framework BDD:** Cucumber Java `7.14.1`
- **Ejecución de pruebas:** JUnit Jupiter `5.9.1`
- **Gestión de dependencias:** Gradle `8.1`
- **Gestión de drivers:** WebDriverManager `5.6.2`
- **Reportes:** Cucumber HTML Reports
- **Navegador soportado:** Google Chrome

## Manejador de Dependencias

Este proyecto utiliza **Gradle** como manejador de dependencias y automatizador de tareas. No es necesario instalarlo manualmente, ya que se incluye el wrapper (`gradlew`).

## Estructura del Proyecto

```
├── src
│   ├── main
│   └── test
│       ├── java
│       │   ├── pages         # Page Objects (AmazonSearchPage, BasePage)
│       │   ├── steps         # Step Definitions y Hooks
│       │   └── runner        # Clase runner para ejecución
│       └── resources
│           └── features      # Archivos .feature en Gherkin
├── build.gradle              # Configuración de dependencias y plugins
├── gradlew / gradlew.bat     # Gradle Wrapper
├── run_tests.bat             # Script para ejecutar pruebas en Windows
├── README.md                 # Este archivo
```

## Instalación y Requisitos

- **Java 11** o superior instalado
- **Google Chrome** instalado
- No es necesario instalar Gradle, se usa el wrapper incluido (`gradlew`)

## Ejecución de las Pruebas

### Comando principal de ejecución

```sh
./gradlew test
```

O en Windows:

```bat
run_tests.bat
```

### Opción 2: Desde un IDE (IntelliJ, Eclipse, VSCode)

- Ejecuta la clase `runner` ubicada en `src/test/java/runner/runner.java` como JUnit Test.

## Reportes

- Al finalizar la ejecución, se genera un reporte HTML en:
  - `build/reports/tests/test/index.html`
  - También se genera un reporte de Cucumber en `target/cucumber-reports/`
- Los screenshots de cada paso y de los fallos se adjuntan automáticamente al reporte.

## Estructura de los Features

- Los escenarios están escritos en Gherkin, con ejemplos parametrizados para distintos productos.
- Los pasos están documentados y son independientes, facilitando la reutilización y el mantenimiento.

## Buenas Prácticas Implementadas

- **Page Object Model:** Separación de lógica de interacción y lógica de pruebas.
- **Independencia de pasos:** Cada step valida su contexto antes de ejecutar acciones.
- **Captura de evidencias:** Screenshots automáticos por paso y por fallo.
- **Comentarios claros:** Todo el código y los features están documentados en español.

## Personalización

- Puedes modificar el archivo `AmazonSearch.feature` para probar otros productos o flujos.
- Los selectores y lógica de los Page Objects pueden adaptarse fácilmente a cambios en la web de Amazon.

---

**¡Gracias por usar este proyecto de automatización!**
