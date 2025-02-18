package co.com.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.concurrent.TimeUnit;

public class EsperaImplicita implements Interaction {

    private int segundos;
    public EsperaImplicita(int segundos) {
        this.segundos = segundos;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }
    public static Performable enSegundos(int segundos){
        return Instrumented.instanceOf(EsperaImplicita.class).withProperties(segundos);
    }
}
