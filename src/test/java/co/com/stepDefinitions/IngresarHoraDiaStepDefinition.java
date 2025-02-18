package co.com.stepDefinitions;

import co.com.questions.ValidacionIngresarHoraDia;
import co.com.tasks.IngresarHoraDiaTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IngresarHoraDiaStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario ingresa la información necesaria y obligatoria para realizar el ingreso de hora del dia")
    public void elUsuarioIngresaLaInformaciónNecesariaYObligatoriaParaRealizarElIngresoDeHoraDelDia() {

        theActorInTheSpotlight().attemptsTo(IngresarHoraDiaTask.ingresarHoraDia());

    }
    @Entonces("el ingreso de hora del dia se realiza correctamente y se muestra un mensaje de confirmacion")
    public void elIngresoDeHoraDelDiaSeRealizaCorrectamenteYSeMuestraUnMensajeDeConfirmacion() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionIngresarHoraDia.validarIngresarHoraDia(), Matchers.equalTo(true)
                )
        );
    }


}
