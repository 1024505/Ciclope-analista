package co.com.exceptions;

public class NoRegistrarHoraDiaMayor24Horas extends AssertionError{

    public static final String HoraDiaMayor24Horas = "No se debe de reportar horas en el dia que superen o se han mayor a las 24 horas";

    public NoRegistrarHoraDiaMayor24Horas(String message) {
        super(message);
    }

    public NoRegistrarHoraDiaMayor24Horas(String message, Throwable cause) {
        super(message, cause);
    }
}
