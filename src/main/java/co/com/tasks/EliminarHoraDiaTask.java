package co.com.tasks;

import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.userInterfaces.HojaTiempoUI.*;
import static co.com.userInterfaces.TrackerUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarHoraDiaTask implements Task {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx", "EliminarHoraDia");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(

                Click.on(BTN_TRACKER),
                Enter.theValue(leerExcel.get(0).get("FechaDesde")).into(TXT_FECHA_DESDE),
                Enter.theValue(leerExcel.get(0).get("FechaHasta")).into(TXT_FECHA_HASTA),
                SelectFromOptions.byVisibleText(leerExcel.get(0).get("SubTipoHoraBuscar")).from(LST_SUB_TIPO_HORA_BUSCAR),
                Click.on(BTN_FILTRO),
                Click.on(BTN_ELIMINAR_HORA_DIA),
                Click.on(BTN_SI_ELIMINAR_HORA_DIA)
        );

    }

    public static EliminarHoraDiaTask eliminarHoraDia() {
        return instrumented(EliminarHoraDiaTask.class);
    }


}
