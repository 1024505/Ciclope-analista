package co.com.tasks;

//import co.com.questions.ValidacionElementosVisibles;
import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.userInterfaces.HojaTiempoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarHorasNovedadesTask implements Task {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx", "IngresarHoraNovedades");
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
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("SubTipoHora")).from(LST_INGRESAR_SUB_TIPO_HORA)

        );

        //validar si se aparece el elemento y realiza la accion que correponda
        boolean justificacion = TXT_INGRESAR_JUSTIFICACION.resolveFor(actor).isVisible();

        if (justificacion){
            actor.attemptsTo(

                    Enter.theValue(leerExcel.get(0).get("Justificacion")).into(TXT_INGRESAR_JUSTIFICACION)

            );
        }

        //validar si es visible el mansaje de aprobar por el GS
        boolean mensajeA = TXT_VALIDAR_MENSAJE_APROBAR_HORAS_NOVEDADES_GS.resolveFor(actor).isVisible();

        if (mensajeA){
            actor.should(
                   // GivenWhenThen.seeThat("El Mensaje Aprobar por Gerente Servicio es Visible", ValidacionElementosVisibles.esVisibleMensajeAprobarGerenteServicio())
            );
        }

        actor.attemptsTo(

                Enter.theValue(leerExcel.get(0).get("Observaciones")).into(TXT_INGRESAR_OBSERVACIONES),
                Click.on(BTN_GUARDAR_REGISTRO_HORAS)
        );
    }

    public static IngresarHorasNovedadesTask ingresarHorasNovedades() {
        return instrumented(IngresarHorasNovedadesTask.class);
    }


}
