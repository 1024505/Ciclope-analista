package co.com.questions;

import co.com.userInterfaces.TrackerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionEliminarHoraDia implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return TrackerUI.TXT_VALIDAR_ELIMINAR_HORA_DIA.resolveFor(actor).isVisible();
    }

    public static Question validarEliminarHoraDia() {
        return new ValidacionEliminarHoraDia();
    }

}
