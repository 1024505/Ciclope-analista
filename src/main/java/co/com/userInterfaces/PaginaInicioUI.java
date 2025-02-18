package co.com.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicioUI {


    public static final Target BTN_Coockies = Target.the( "btn Popup" )
            .located( By.xpath("//button[@id='c-p-bn' and contains(@class, 'c-bn')]"));

    public static final Target BTN_Popup= Target.the( "btn Popup" )
            .located( By.xpath("//a[@class='phpdebugbar-close-btn']"));
    public static final Target TXT_USUARIO= Target.the( "usuario" )
            .located( By.xpath("//input[@id='email']"));

    public static final Target TXT_CLAVE= Target.the( "ingresar clave" )
            .located( By.xpath("//input[@id='password']"));

    public static final Target BTN_INGRESAR= Target.the( "boton ingresar" )
            .located( By.xpath("//button[@id='login_button']"));
}
