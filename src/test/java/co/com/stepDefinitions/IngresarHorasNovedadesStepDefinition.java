package co.com.stepDefinitions;

import co.com.questions.ValidacionIngresarHorasNovedades;
import co.com.tasks.IngresarHorasNovedadesTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IngresarHorasNovedadesStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario ingresa la información necesaria y obligatoria para realizar el ingreso de horas novedades")
    public void elUsuarioIngresaLaInformaciónNecesariaYObligatoriaParaRealizarElIngresoDeHorasNovedades() {

        theActorInTheSpotlight().attemptsTo(IngresarHorasNovedadesTask.ingresarHorasNovedades());

    }
    @Entonces("el ingreso de horas novedades se realiza correctamente y se muestra un mensaje de confirmacion")
    public void elIngresoDeHorasNovedadesSeRealizaCorrectamenteYSeMuestraUnMensajeDeConfirmacion() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionIngresarHorasNovedades.validarIngresarHorasNovedades(), Matchers.equalTo(true)
                )
        );

    }

}
