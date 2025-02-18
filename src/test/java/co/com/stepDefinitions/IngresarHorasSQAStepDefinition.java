package co.com.stepDefinitions;

import co.com.questions.ValidacionIngresarHorasSQA;
import co.com.tasks.IngresarHorasSQATask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IngresarHorasSQAStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario ingresa la información necesaria y obligatoria para realizar el ingreso de horas SQA")
    public void elUsuarioIngresaLaInformaciónNecesariaYObligatoriaParaRealizarElIngresoDeHorasSQA() {

        theActorInTheSpotlight().attemptsTo(IngresarHorasSQATask.ingresarHorasSQA());

    }
    @Entonces("el ingreso de horas SQA se realiza correctamente y se muestra un mensaje de confirmacion")
    public void elIngresoDeHorasSQASeRealizaCorrectamenteYSeMuestraUnMensajeDeConfirmacion() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionIngresarHorasSQA.validarIngresarHorasSQA(), Matchers.equalTo(true)
                )
        );

    }

}
