package co.com.questions;

import co.com.userInterfaces.TrackerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionEditarHoraDia implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return TrackerUI.TXT_VALIDAR_EDITAR_HORA_DIA.resolveFor(actor).isVisible();
    }

    public static Question validarEditarHoraDia() {
        return new ValidacionEditarHoraDia();
    }

}
