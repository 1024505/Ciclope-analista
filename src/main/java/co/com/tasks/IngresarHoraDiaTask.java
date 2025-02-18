package co.com.tasks;

import co.com.exceptions.NoRegistrarHoraDiaMayor24Horas;
import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.userInterfaces.HojaTiempoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarHoraDiaTask implements Task {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx", "IngresarHoraDia");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(

                        Click.on(BTN_HOJA_TIEMPO),
                        Click.on(BTN_AGREGAR_REGISTRO_HORAS),
                        Enter.theValue(leerExcel.get(0).get("Fecha")).into(TXT_INGRESAR_FECHA),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("TotalHoras")).from(LST_INGRESAR_TOTAL_HORAS),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("Cliente")).from(LST_INGRESAR_CLIENTE),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("Proyecto")).from(LST_INGRESAR_PROYECTO),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("SubProyecto")).from(LST_INGRESAR_SUBPROYECTO),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("Tarea")).from(LST_INGRESAR_TAREA),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("TipoHora")).from(LST_INGRESAR_TIPO_HORA),
                        SelectFromOptions.byVisibleText(leerExcel.get(0).get("SubTipoHora")).from(LST_INGRESAR_SUB_TIPO_HORA),
                        Enter.theValue(leerExcel.get(0).get("Observaciones")).into(TXT_INGRESAR_OBSERVACIONES),
                        Click.on(BTN_GUARDAR_REGISTRO_HORAS)
        );

        boolean mensajeErrorHorasDia = TXT_ALERTA_INGRESO_HORAS_DIA_MAYOR_24_HORAS.resolveFor(actor).isVisible();


        if (mensajeErrorHorasDia) {

            throw new NoRegistrarHoraDiaMayor24Horas(NoRegistrarHoraDiaMayor24Horas.HoraDiaMayor24Horas);

        }

        // Hacer scroll horizontal en la tabla
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement tablaContainer = BrowseTheWeb.as(actor).find(By.xpath("(//div[@class='table-responsive'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 1000;", tablaContainer);

    }

    public static IngresarHoraDiaTask ingresarHoraDia() {
        return instrumented(IngresarHoraDiaTask.class);
    }

}
