package co.com.stepDefinitions;


import co.com.questions.ValidacionIngresarHoraExtra;
import co.com.tasks.IngresarHorasExtraTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IngresarHorasExtraStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario ingresa la información necesaria y obligatoria para realizar el ingreso de horas extra")
    public void elUsuarioIngresaLaInformaciónNecesariaYObligatoriaParaRealizarElIngresoDeHorasExtra() {

        theActorInTheSpotlight().attemptsTo(IngresarHorasExtraTask.ingresarHoraExtra());

    }

    @Entonces("el ingreso de horas extra se realiza correctamente y se muestra un mensaje de confirmacion")
    public void elIngresoDeHorasExtraSeRealizaCorrectamenteYSeMuestraUnMensajeDeConfirmacion() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionIngresarHoraExtra.validarIngresarHoraExtra(), Matchers.equalTo(true)
                )
        );

    }

}
