package co.com.tasks;


//import co.com.exceptions.NoIngresarHorasExtraSuperiorPermitidasMes;
import co.com.exceptions.NoIngresarHorasExtraSuperiorPermitidasSemana;
import co.com.exceptions.NoRegistrarHoraDiaMayor24Horas;
import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SetCheckbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.userInterfaces.HojaTiempoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarHorasExtraTask implements Task {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx", "HorasExtra");
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
                SetCheckbox.of(CHK_ES_HORA_EXTRA).toTrue(),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("HoraExtra")).from(LST_INGRESAR_HORA_EXTRA),
                Enter.theValue(leerExcel.get(0).get("Observaciones")).into(TXT_INGRESAR_OBSERVACIONES),
                Click.on(BTN_GUARDAR_REGISTRO_HORAS)
        );

        boolean alertaErrorHoraExtraSemana = TXT_ALERTA_INGRESO_SUPERIOR_HORA_EXTRA_SEMANA.resolveFor(actor).isVisible();

        boolean alertaErrorHoraExtraMes = TXT_ALERTA_INGRESO_SUPERIOR_HORA_EXTRA_MES.resolveFor(actor).isVisible();


        if (alertaErrorHoraExtraSemana) {

            throw new NoIngresarHorasExtraSuperiorPermitidasSemana(NoIngresarHorasExtraSuperiorPermitidasSemana.HorasExtraSuperiorSemana);

        } else if (alertaErrorHoraExtraMes) {

            //throw new NoIngresarHorasExtraSuperiorPermitidasMes(NoIngresarHorasExtraSuperiorPermitidasMes.HorasExtraSuperiorMes);
        }

    }

    public static IngresarHorasExtraTask ingresarHoraExtra() {
        return instrumented(IngresarHorasExtraTask.class);
    }


}
