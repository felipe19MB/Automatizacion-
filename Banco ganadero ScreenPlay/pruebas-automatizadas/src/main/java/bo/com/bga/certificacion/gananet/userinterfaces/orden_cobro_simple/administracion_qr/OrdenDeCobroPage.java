package bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr;

import net.serenitybdd.screenplay.targets.Target;

public class OrdenDeCobroPage {

    public static final Target CUENTA_ORIGEN= Target.the("check box de la cuenta de origen")
            .locatedBy("//h4[contains(text(),'{0}')]");

    public static final Target LABEL_TIPO_COBRO= Target.the("label tipo de cobro")
            .locatedBy("//label[contains(text(),'Tipo de cobro')]/following-sibling::select");

    public static final Target LABEL_FECHA_VENCIMIENTO= Target.the(" el label  de la fecha vencimiento")
            .locatedBy("//label[contains(text(),'Fecha de vencimiento')]/following-sibling::select");

    public static final Target LABEL_MONEDA= Target.the("el label de la moneda")
            .locatedBy("//label[contains(text(),'Moneda ')]/following-sibling::select");

    public static final Target LABEL_MONTO= Target.the("el label del monto")
            .locatedBy("//label[contains(text(),'Monto')]/following-sibling::control-input-monto/div/input");

    public static final Target LABEL_DESCRIPCION= Target.the("el label descripcion")
            .locatedBy("//label[contains(text(),'Descripción ')]/following-sibling::input");

    public static final Target BOTON_GENERAR= Target.the("el boton generar")
            .locatedBy("//button[normalize-space()='Generar']");

    public static final Target VALIDACION_IMAGEN_QR= Target.the("validacion del QR")
            .locatedBy("//img[@alt='QR no encontrado.']");


}
