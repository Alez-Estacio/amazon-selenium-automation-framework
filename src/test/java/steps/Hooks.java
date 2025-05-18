package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import pages.BasePage;

// Clase Hooks para manejar acciones antes y después de cada escenario y paso en Cucumber
public class Hooks extends BasePage {
    /**
     * Constructor que llama al constructor de la clase BasePage para inicializar el
     * driver
     */
    public Hooks() {
        super(driver);
    }

    /*
     * Método que se ejecuta después de cada escenario (@After)
     * - Registra un mensaje en el log del escenario
     * - Captura una captura de pantalla del estado final
     * - Adjunta la imagen al reporte del escenario
     * 
     * @param scenario Escenario actual de Cucumber
     */
    @After
    public void tearDown(Scenario scenario) {
        // Agregar mensaje personalizado al log del escenario
        scenario.log("Scenario failing, please refer to the image attached to this report");
        // Capturar pantalla como bytes
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        // Adjuntar la captura de pantalla al reporte (tipo image/png)
        scenario.attach(screenshot, "image/png", "screenshot ofe the error");
    }

    /*
     * Método que se ejecuta después de cada paso (@AfterStep)
     * - Captura una captura de pantalla tras cada paso
     * - Adjunta la imagen al reporte del escenario
     * - Usa try-catch para no interrumpir el flujo si falla la captura
     * 
     * @param scenario Escenario actual de Cucumber
     */
    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        try {
            // Capturar pantalla tras el paso actual
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Adjuntar la captura al reporte con nombre descriptivo
            scenario.attach(screenshot, "image/png", "screenshot step");
        } catch (Exception e) {
            // Ignorar errores de screenshot para no interrumpir la ejecución
        }
    }

}
