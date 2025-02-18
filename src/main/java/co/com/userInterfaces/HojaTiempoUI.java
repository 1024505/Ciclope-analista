package co.com.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HojaTiempoUI{

    //------------------------------------Ingresar Hora Dia--------------------------------------//

    public static final Target BTN_HOJA_TIEMPO = Target.the("Boton de hoja de tiempo")
            .located(org.openqa.selenium.By.xpath("//a[@href='https://mandy.sqasa.co/timesheet']"));
    public static final Target BTN_AGREGAR_REGISTRO_HORAS = Target.the("Boton de añadir el registro de horas")
            .located(org.openqa.selenium.By.xpath("//a[@data-bs-target='#createOrUpdateTimetrackerModal']"));
    public static final Target TXT_INGRESAR_FECHA = Target.the("Ingresar la fecha del dia actual")
            .located(org.openqa.selenium.By.xpath("//input[@id='fecha']"));
    public static final Target LST_INGRESAR_TOTAL_HORAS = Target.the("Seleccionar el total de horas a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='totalHours']"));
    public static final Target LST_INGRESAR_CLIENTE = Target.the("Seleccionar el cliente a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='client']"));
    public static final Target LST_INGRESAR_PROYECTO = Target.the("Seleccionar el proyecto a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='project_id']"));
    public static final Target LST_INGRESAR_SUBPROYECTO = Target.the("Seleccionar el subproyecto a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='subproject_id']"));
    public static final Target LST_INGRESAR_TAREA = Target.the("Seleccionar la tarea a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='task_id']"));
    public static final Target LST_INGRESAR_TIPO_HORA = Target.the("Seleccionar el tipo de hora a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='type_hour_id']"));
    public static final Target LST_INGRESAR_SUB_TIPO_HORA = Target.the("Seleccionar el sub tipo de hora a registrar")
            .located(org.openqa.selenium.By.xpath("//select[@id='sub_type_hour_id']"));
    public static final Target TXT_INGRESAR_OBSERVACIONES = Target.the("Ingresar las observaciones")
            .located(org.openqa.selenium.By.xpath("//textarea[@id='name']"));
    public static final Target BTN_GUARDAR_REGISTRO_HORAS = Target.the("Boton de guardar el registro de la informacion ingresada")
            .located(org.openqa.selenium.By.xpath("//button[@id='buttonSave']"));
    public static final Target TXT_VALIDAR_INGRESO_HORAS_DIA = Target.the("Validar el ingreso horas dia")
            .located(org.openqa.selenium.By.xpath("//div[text()='Ingreso de hora incluida correctamente']"));

    //------------------------------------Ingresar Horas Dia mayor de 24 horas--------------------------------------//
    public static final Target TXT_ALERTA_INGRESO_HORAS_DIA_MAYOR_24_HORAS = Target.the("Se visualiza un mensaje de error de no se puede ingresar mas de 24 horas en un dia ")
            .located(org.openqa.selenium.By.xpath("//div[text()='No puedes reportar más de 24 horas en un día']"));

    //------------------------------------Ingresar Horas SQA--------------------------------------//

    public static final Target TXT_VALIDAR_INGRESO_HORAS_SQA = Target.the("Validar el ingreso horas SQA")
            .located(org.openqa.selenium.By.xpath("//div[text()='Ingreso de hora incluida correctamente']"));

    //------------------------------------Ingresar Horas Novedades--------------------------------------//

    public static final Target TXT_VALIDAR_INGRESO_HORAS_NOVEDADES = Target.the("Validar el ingreso horas novedades")
            .located(org.openqa.selenium.By.xpath("//div[text()='Ingreso de hora incluida correctamente']"));
    public static final Target TXT_VALIDAR_MENSAJE_APROBAR_HORAS_NOVEDADES_GS = Target.the("Validar que aparezca el mensaje de aprobar la hora novedad por el GS")
            .located(org.openqa.selenium.By.xpath("//b[text()='El sistema solicitará aprobación de esta novedad a tu gerente de servicio asignado.']"));


    //------------------------------------Ingresar Horas Semana Siguiente--------------------------------------//

    public static final Target BTN_SIGUIENTE_SEMANA = Target.the("Boton para ir a la siguiente semana")
            .located(org.openqa.selenium.By.xpath("(//button[@class='btn btn-primary btn-lg'])[2]"));
    public static final Target FUL_CARGAR_DOCUMENTO_SOPORTE = Target.the("Cargar el documento de soporte")
            .located(org.openqa.selenium.By.xpath("(//input[@type='file'])[1]"));
    public static final Target TXT_INGRESAR_JUSTIFICACION = Target.the("Ingresar la justificacion")
            .located(org.openqa.selenium.By.xpath("//textarea[@id='justification']"));
    public static final Target TXT_VALIDAR_INGRESO_HORAS_SEMANA_SIGUIENTE = Target.the("Validar el ingreso horas a la semana siguiente")
            .located(org.openqa.selenium.By.xpath("//div[text()='Ingreso de hora incluida correctamente']"));

   //----------------------------------------Ingresar Horas Extra-----------------------------------------------------//

    public static final Target CHK_ES_HORA_EXTRA = Target.the("Seleccionar si es una hora extra")
            .located(org.openqa.selenium.By.xpath("//input[@id='checkboxIsExtraHour']"));
    public static final Target LST_INGRESAR_HORA_EXTRA = Target.the("Ingresar la hora extra")
            .located(org.openqa.selenium.By.xpath("//select[@id='extra_hour_id']"));
    public static final Target TXT_VALIDAR_INGRESO_HORA_EXTRA = Target.the("Validar el ingreso de las horas extra")
            .located(org.openqa.selenium.By.xpath("//div[text()='Ingreso de hora incluida correctamente']"));

   //----------------------------------------Ingresar Horas Superior a las Horas Extra Permitida a la Semana-----------------------------------------------------//

    public static final Target TXT_ALERTA_INGRESO_SUPERIOR_HORA_EXTRA_SEMANA = Target.the("Validar si aparece la alerta al ingreso superior de las horas extra permitidas a la semana")
            .located(org.openqa.selenium.By.xpath("//div[contains(text(),'Ha superado el número máximo de horas extras permitidas por semana, las cuales son')]"));

    //----------------------------------------Ingresar Horas Superior a las Horas Extra Permitida al Mes-----------------------------------------------------//

    public static final Target TXT_ALERTA_INGRESO_SUPERIOR_HORA_EXTRA_MES = Target.the("Validar si aparece la alerta al ingreso superior de las horas extra permitidas a la semana")
            .located(org.openqa.selenium.By.xpath("//div[contains(text(),'Ha superado el número máximo de horas extras permitidas por mes, las cuales son')]"));






































}
