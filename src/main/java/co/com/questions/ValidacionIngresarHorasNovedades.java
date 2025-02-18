package co.com.questions;

import co.com.userInterfaces.HojaTiempoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionIngresarHorasNovedades implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return HojaTiempoUI.TXT_VALIDAR_INGRESO_HORAS_NOVEDADES.resolveFor(actor).isVisible();
    }

    public static Question validarIngresarHorasNovedades() {
        return new ValidacionIngresarHorasNovedades();
    }

}
