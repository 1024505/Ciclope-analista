package co.com.stepDefinitions;

import co.com.questions.ValidacionIngresarHorasSemanaSiguiente;
import co.com.tasks.IngresarHorasSemanaSiguienteTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IngresarHorasSemanaSiguienteStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario ingresa la información necesaria y obligatoria para realizar el ingreso de horas a la semana siguiente")
    public void elUsuarioIngresaLaInformaciónNecesariaYObligatoriaParaRealizarElIngresoDeHorasALaSemanaSiguiente() {

        theActorInTheSpotlight().attemptsTo(IngresarHorasSemanaSiguienteTask.ingresarHorasSemanaSiguiente());

    }
    @Entonces("el ingreso de horas a la semana siguiente se realiza correctamente y se muestra un mensaje de confirmacion")
    public void elIngresoDeHorasALaSemanaSiguienteSeRealizaCorrectamenteYSeMuestraUnMensajeDeConfirmacion() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionIngresarHorasSemanaSiguiente.validarIngresarHorasSemanaSiguiente(), Matchers.equalTo(true)
                )
        );

    }

}
