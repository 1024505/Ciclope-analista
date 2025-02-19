package co.com.stepDefinitions;


import co.com.interactions.AbrirNavegador;
import co.com.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentre en la pagina web")
    public void queElUsuarioSeEncuentreEnLaPaginaWeb() {

     //   theActorCalled("Admin").wasAbleTo(AbrirNavegador.abrir());
    }

    @Cuando("ingrese el usuario con la clave")
    public void ingreseElUsuarioConLaClave()  {

    //    theActorInTheSpotlight().attemptsTo(Login.inicioSesion());
    }

    @Entonces("el usuario visualizara un mensaje de login exitoso")
    public void elUsuarioVisualizaraUnMensajeDeLoginExitoso() {
       /* theActorInTheSpotlight().should(seeThat(ValidacionLogin.validarLogin(),
                Matchers.equalTo(true)).orComplainWith(ResultadoNoEsperado.class,ResultadoNoEsperado.INICIO_SESION_FALLO));*/

    }
}
