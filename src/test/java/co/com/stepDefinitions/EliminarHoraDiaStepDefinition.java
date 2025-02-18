package co.com.stepDefinitions;

import co.com.questions.ValidacionEliminarHoraDia;
import co.com.tasks.EliminarHoraDiaTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarHoraDiaStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Cuando("el usuario realiza los pasos para eliminar una hora dia")
    public void elUsuarioRealizaLosPasosParaEliminarUnaHoraDia() {

        theActorInTheSpotlight().attemptsTo(EliminarHoraDiaTask.eliminarHoraDia());

    }
    @Entonces("se visualiza un mensaje en el modulo de tracker confirmando la eliminacion exitosa de la hora dia")
    public void seVisualizaUnMensajeEnElModuloDeTrackerConfirmandoLaEliminacionExitosaDeLaHoraDia() {

        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionEliminarHoraDia.validarEliminarHoraDia(), Matchers.equalTo(true)
                )
        );

    }

}
