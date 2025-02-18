package co.com.exceptions;

public class NoIngresarHorasExtraSuperiorPermitidasSemana extends AssertionError{

    public static final String HorasExtraSuperiorSemana = "No se permite ingresar horas extra superior a las permitidas en la semana";

    public NoIngresarHorasExtraSuperiorPermitidasSemana(String message) {
        super(message);
    }

}
