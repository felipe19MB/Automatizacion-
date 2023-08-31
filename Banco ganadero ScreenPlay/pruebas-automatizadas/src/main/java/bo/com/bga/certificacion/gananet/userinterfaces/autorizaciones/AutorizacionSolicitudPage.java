package bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones;

import net.serenitybdd.screenplay.targets.Target;

public class AutorizacionSolicitudPage {

    public static final Target BOTON_OPCIONES = Target.the("el opciones de la solicitud")
            .locatedBy("//table/tbody/tr[td/p[text()='{0}']]/td/div/a/i");

    public static final Target BOTON_APROBAR = Target.the("el boton aprobar")
            .locatedBy("//button[normalize-space()='Aprobar']");

    public static final Target BOTON_OK = Target.the("el boton ok")
            .locatedBy("//button[normalize-space()='OK']");

    public static final Target MENSAJE = Target.the("el mensase de confirmacion")
            .locatedBy("//div[@id='swal2-content']");

    public static final Target VALIDACIONES_DATALLE = Target.the("las validaciones del datalle")
            .locatedBy("//div[@class='col-12 text-center']//following-sibling::h6[contains(., ' {0}')]");

    public static final Target COMPROBANTE_CUENTA_ORIGEN= Target.the("Valida que la cuenta {0} haya quedado como origen")
            .locatedBy("//div[strong[contains(., 'Cuenta Origen:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_IMPORTE_DEBITADO= Target.the("Valida el importe debitado")
            .locatedBy("//div[strong[contains(., 'Importe Debitado:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_FORMATO= Target.the("Valida el formato")
            .locatedBy("//div[strong[contains(., 'Formato:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_CANTIDAD_CHEQUERAS= Target.the("Valida la cantidad de chequeras")
            .locatedBy("//div[strong[contains(., 'Cantidad De Chequeras:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_CANTIDAD_CHEQUES= Target.the("Valida la cantidad de cheques")
            .locatedBy("//div[strong[contains(., 'Cantidad De Cheques:')]]/following-sibling::div[contains(., '{0}')]");

}
