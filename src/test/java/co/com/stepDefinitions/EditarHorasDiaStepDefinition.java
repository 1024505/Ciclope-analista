package co.com.stepDefinitions;

import co.com.questions.ValidacionEditarHoraDia;
import co.com.tasks.EditarHorasDiaTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EditarHorasDiaStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario comienza a editar la informacion de una hora dia seleccionada")
    public void elUsuarioComienzaAEditarLaInformacionDeUnaHoraDiaSeleccionada() {

        theActorInTheSpotlight().attemptsTo(EditarHorasDiaTask.editarHoraDia());

    }
    @Entonces("se visualiza un mensaje en el modulo de tracker confirmando la realizacion de los cambios se realizaron exitosamente")
    public void seVisualizaUnMensajeEnElModuloDeTrackerConfirmandoLaRealizacionDeLosCambiosSeRealizaronExitosamente() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionEditarHoraDia.validarEditarHoraDia(), Matchers.equalTo(true)
                )
        );

    }

}
