package bo.com.bga.certificacion.gananet.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class InicioSesionPage {

    public static final Target USUARIO = Target.the("label de ingreso de usuario")
            .locatedBy("//input");
    public static final Target IFRAME = Target.the("frame ")
            .locatedBy("//iframe[@id='iframe_Browser']");
    public static final Target BUTTON_INGRESAR = Target.the("botón de ingreso")
            .locatedBy("//button[@class='btn btn-success btn-block margin-top-10']");
    public static final Target PASSWORD = Target.the("label de ingreso de contraseña")
            .locatedBy("//input[@formcontrolname='password']");
    public static final Target BUTTON_OLVIDE_USUARIO = Target.the("Boton olvide mi usuario")
            .locatedBy("//a[contains(text(),'Olvidé mi usuario')]");
    public static final Target EMAIL = Target.the("campo de ingreso de email")
            .locatedBy("//label[contains(text(),'Email ')]/following-sibling::input");
    public static final Target GANAPIN = Target.the("campo de ingreso de Ganapin")
            .locatedBy("//seguridad-login[1]//control-input-text[2]//input[1]");
    public static final Target BUTTON_ENVIAR = Target.the("boton de envio")
            .locatedBy("//seguridad-dialog-envio-usuario[1]//button[contains(text(),'Enviar')]");
    public static final Target BUTTON_OLVIDE_CONTRASENA = Target.the("Boton olvide mi contraseña")
            .locatedBy("//a[contains(text(),' Olvidé mi contraseña')]");
    public static final Target GANAPIN_CONTRASEÑA = Target.the("campo de ingreso de Ganapin")
            .locatedBy("//seguridad-login[1]/seguridad-dialog-reimpresion-clave[1]//input[1]");
    public static final Target MODAL_CONFIRMACION = Target.the("modal de confirmacion")
            .locatedBy("//div[@id='swal2-content']");
    public static final Target BUTTON_ENVIAR_PASSWORD = Target.the("boton de envio")
            .locatedBy("//seguridad-dialog-reimpresion-clave[1]//button[contains(text(),'Enviar')]");
}
