package bo.com.bga.certificacion.gananet.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ActualizacionClavePage {

    public static final Target TXT_CLAVE_ACTUAL = Target.the("label de la clave actual")
            .locatedBy("//input[@formcontrolname='claveActual']");

    public static final Target TXT_NUEVA_CLAVE = Target.the("label de la clave nueva")
            .locatedBy("//input[@formcontrolname='claveNueva']");

    public static final Target TXT_CONFIRMAR_CLAVE = Target.the("label de confirmacion de la clave nueva")
            .locatedBy("//input[@formcontrolname='claveConfirmacion']");


    public static final Target BUTON_CONTINUAR = Target.the("boton de continuar")
            .locatedBy("//button[text()='Continuar']");

    public static final Target BOTON_OK = Target.the("boton de ok")
            .locatedBy("//Button[@class='swal2-confirm swal2-styled']");




}
