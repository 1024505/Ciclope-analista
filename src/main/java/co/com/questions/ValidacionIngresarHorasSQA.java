package co.com.questions;

import co.com.userInterfaces.HojaTiempoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionIngresarHorasSQA implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return HojaTiempoUI.TXT_VALIDAR_INGRESO_HORAS_SQA.resolveFor(actor).isVisible();
    }

    public static Question validarIngresarHorasSQA() {
        return new ValidacionIngresarHorasSQA();
    }

}
