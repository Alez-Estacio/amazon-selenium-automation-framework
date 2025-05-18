package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Directorio de archivos .feature
                glue = "steps", // Paquete con las definiciones de steps
                plugin = { "pretty", "html:target/cucumber-reports" }, // Plugins para reporte
                monochrome = true, // Salida legible en consola
                tags = "@Cart" // Ejecutar solo escenarios con este tag
)

public class runner {
        /**
         * Método que se ejecuta una vez después de todas las pruebas.
         * Se encarga de cerrar el navegador y liberar recursos.
         */
        @AfterClass
        public static void cleanDriver() {
                // Invoca al método de BasePage que cierra el navegador
                BasePage.closeBrowser();
        }

}