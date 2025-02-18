package co.com.tasks;

import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.userInterfaces.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            boolean visible = BTN_Coockies.resolveFor(actor).isCurrentlyVisible();

            if (visible) {
                BTN_Coockies.resolveFor(actor).click();
            }
        } catch (Exception ignored) {
        }
        try {
            boolean visible = BTN_Popup.resolveFor(actor).isCurrentlyVisible();

            if (visible) {
                BTN_Popup.resolveFor(actor).click();
            }
        } catch (Exception ignored) {
        }
        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx", "DatosLogin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(leerExcel.get(0).get("Usuario")).into(TXT_USUARIO),
                Enter.theValue(leerExcel.get(0).get("Clave")).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)
        );

    }

    public static Login inicioSesion() {
        return instrumented(Login.class);
    }
}
