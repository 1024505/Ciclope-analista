package co.com.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TrackerUI {

    //------------------------------------Editar Hora Dia--------------------------------------//

    public static final Target BTN_TRACKER = Target.the("Boton de tracker")
            .located(org.openqa.selenium.By.xpath("(//a[@href='https://mandy.sqasa.co/time-tracker'])[1]"));
    public static final Target TXT_FECHA_DESDE = Target.the("Ingresar para buscar fecha desde en tracker")
            .located(org.openqa.selenium.By.xpath("//input[@name='start_time']"));
    public static final Target TXT_FECHA_HASTA = Target.the("Ingresar para buscar fecha hasta en tracker")
            .located(org.openqa.selenium.By.xpath("//input[@name='end_time']"));
    public static final Target LST_SUB_TIPO_HORA_BUSCAR = Target.the("Seleccionar de la lista de sub tipo de horas para poder buscar")
            .located(org.openqa.selenium.By.xpath("(//select[@name='type_hour_id'])[2]"));
    public static final Target BTN_FILTRO = Target.the("Seleccionar de la lista de sub tipo de horas para poder buscar")
            .located(org.openqa.selenium.By.xpath("//button[@title='Tooltip text for Filter button']"));
    public static final Target BTN_EDITAR_HORA_DIA = Target.the("Boton de editar hora dia")
            .located(org.openqa.selenium.By.xpath("(//a[@data-bs-target='#createOrUpdateTimetrackerModal'])[1]"));
    public static final Target TXT_VALIDAR_EDITAR_HORA_DIA = Target.the("Validacion de editar hora dia")
            .located(org.openqa.selenium.By.xpath("//div[text()='Tiempo actualizado con éxito']"));


    //------------------------------------Ver Hora Aprobada GS---------------------------------------------------//

    public static final Target BTN_VER_HORA_APROBADA = Target.the("Boton de ver y no editar hora dia")
            .located(org.openqa.selenium.By.xpath("(//a[@data-bs-target='#showTimeTrackerModal'])[1]"));
    public static final Target BTN_CERRAR_VER_HORA_APROBADA = Target.the("Boton de cerrar ver hora dia")
            .located(org.openqa.selenium.By.xpath("(//button[text()='Cerrar'])[2]"));
    public static final Target TBL_VALIDAR_VER_HORA_APROBADA = Target.the("Validacion de ver hora aprobada")
            .located(org.openqa.selenium.By.xpath("//table[@class='table table-striped']//tbody"));

    //------------------------------------Eliminar Hora Dia---------------------------------------------------//

    public static final Target BTN_ELIMINAR_HORA_DIA = Target.the("Boton de eliminar hora dia")
            .located(org.openqa.selenium.By.xpath("(//a[@title='Suprimir '])[1]"));
    public static final Target BTN_SI_ELIMINAR_HORA_DIA = Target.the("Boton de si eliminar hora dia")
            .located(org.openqa.selenium.By.xpath("//button[text()='¡Sí, borrarlo!']"));
    public static final Target TXT_VALIDAR_ELIMINAR_HORA_DIA = Target.the("Validacion de eliminar hora dia")
            .located(org.openqa.selenium.By.xpath("//div[text()='Tiempo eliminado con éxito']"));


}
