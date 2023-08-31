package bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad;

import net.serenitybdd.screenplay.targets.Target;

public class CambioLimiteTransaccionesPage {

    public static final Target LABEL_NRO_TRANSACCIONES= Target.the("el label numero de transacciones")
            .locatedBy("//label[contains(text(),'Transacciones por día permitido ')]/following-sibling::control-input-text/div/input");

    public static final Target BOTON_ACTUALIZAR_LIMITE= Target.the("boton actualizar")
            .locatedBy("(//button[@class='btn btn-info btn-inline pull-right mb-20 text-white'][normalize-space()='Actualizar'])[2]");
    public static final Target VALIDACION_MENSAJE= Target.the("Vvalidacion limite transacciones")
            .locatedBy("//div[@id='swal2-content']");

}
