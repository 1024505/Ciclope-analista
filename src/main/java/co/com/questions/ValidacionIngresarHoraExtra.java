package co.com.questions;

import co.com.userInterfaces.HojaTiempoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionIngresarHoraExtra implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return HojaTiempoUI.TXT_VALIDAR_INGRESO_HORA_EXTRA.resolveFor(actor).isVisible();
    }

    public static Question validarIngresarHoraExtra() {
        return new ValidacionIngresarHoraExtra();
    }

}
