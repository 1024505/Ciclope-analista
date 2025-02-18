package co.com.interactions;

import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AbrirNavegador implements Interaction {

    public static ArrayList<Map<String, String>> leerExcel = new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("Data/DatosCiclopePerfilAnalista.xlsx","Url");
            String url = leerExcel.get(0).get("Url");

            actor.attemptsTo(
                    Open.url(url)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static AbrirNavegador abrir () {
        return Tasks.instrumented(AbrirNavegador.class);

    }
}
