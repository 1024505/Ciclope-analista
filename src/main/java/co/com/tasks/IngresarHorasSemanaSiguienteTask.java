package co.com.tasks;

import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.userInterfaces.HojaTiempoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarHorasSemanaSiguienteTask implements Task {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx", "HorasSemanaSiguiente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(

                Click.on(BTN_HOJA_TIEMPO),
                Click.on(BTN_SIGUIENTE_SEMANA),
                Click.on(BTN_AGREGAR_REGISTRO_HORAS),
                Enter.theValue(leerExcel.get(0).get("Fecha")).into(TXT_INGRESAR_FECHA),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("TotalHoras")).from(LST_INGRESAR_TOTAL_HORAS),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("Cliente")).from(LST_INGRESAR_CLIENTE),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("Proyecto")).from(LST_INGRESAR_PROYECTO),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("SubProyecto")).from(LST_INGRESAR_SUBPROYECTO),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("Tarea")).from(LST_INGRESAR_TAREA),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("TipoHora")).from(LST_INGRESAR_TIPO_HORA),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("SubTipoHora")).from(LST_INGRESAR_SUB_TIPO_HORA)
        );

        //validar si se aparece el elemento y realiza la accion que correponda
        boolean documentoSoporte = FUL_CARGAR_DOCUMENTO_SOPORTE.resolveFor(actor).isVisible();
        boolean justificacion = TXT_INGRESAR_JUSTIFICACION.resolveFor(actor).isVisible();

        if (documentoSoporte) {

            WebElement documento = BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("(//input[@type='file'])[1]"));

            // Path del archivo que deseas subir
            File file = new File("C:\\Users\\JhonyAndresCuaspaIru\\IdeaProjects\\Ciclope-Perfil-Analista\\PruebaQA0101.pdf");

            // Si estás utilizando RemoteWebDriver, habilita la detección de archivos locales
            if (BrowseTheWeb.as(actor).getDriver() instanceof RemoteWebDriver) {
                ((RemoteWebDriver) BrowseTheWeb.as(actor).getDriver()).setFileDetector(new LocalFileDetector());
            }

            // Usa Actions para simular el arrastrar y soltar
            Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
            actions.moveToElement(documento).click().perform();

            // Encuentra el input file y sube el archivo
            WebElement inputFile = BrowseTheWeb.as(actor).getDriver().findElement(By.cssSelector("input[type='file']"));
            inputFile.sendKeys(file.getAbsolutePath());

            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Presionar la tecla Esc
            robot.keyPress(KeyEvent.VK_ESCAPE);
            // Liberar la tecla Esc
            robot.keyRelease(KeyEvent.VK_ESCAPE);

        } else if (justificacion) {

            actor.attemptsTo(

                    Enter.theValue(leerExcel.get(0).get("Justificacion")).into(TXT_INGRESAR_JUSTIFICACION)

            );

        }

        actor.attemptsTo(

                Enter.theValue(leerExcel.get(0).get("Observaciones")).into(TXT_INGRESAR_OBSERVACIONES),
                Click.on(BTN_GUARDAR_REGISTRO_HORAS)

        );

    }


    public static IngresarHorasSemanaSiguienteTask ingresarHorasSemanaSiguiente() {
        return instrumented(IngresarHorasSemanaSiguienteTask.class);
    }

}
