package bo.com.bga.certificacion.gananet.userinterfaces.comprobantes;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosBasicosPage {
    public static final Target TXT_FECHA_DESDE= Target.the("ingresa fecha desde")
            .locatedBy("//label[contains(text(),'Desde')]/following-sibling::div//input");
    public static final Target TXT_FECHA_HASTA= Target.the("ingresa fecha hasta")
            .locatedBy("//label[contains(text(),'Hasta')]/following-sibling::div//input");
    public static final Target BOTON_CONSULTAR= Target.the("consultar")
            .locatedBy("//button[contains(text(),'Consultar')]");
    public static final Target ASSERT_NUMERO_TRANSACCION= Target.the("validacion numero de transaccion")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]");
    public static final Target ASSERT_FECHA= Target.the("validacion fecha de transaccion")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[1]/p");
    public static final Target ASSERT_TIPO= Target.the("validacion tipo de transaccion")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[2]/p");
    public static final Target ASSERT_SERVICIO= Target.the("validacion servicio")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[3]/p");
    public static final Target ASSERT_CUENTA= Target.the("validacion cuenta")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[4]/p");
    public static final Target ASSERT_IMPORTE= Target.the("validacion importe de transaccion")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[5]/p");
    public static final Target ASSERT_MONEDA= Target.the("validacion modena de transaccion")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[6]/p");
    public static final Target BOTON_VER= Target.the("ver comprobante")
            .locatedBy("//control-tabla//p[contains(text(),'{0}')]/parent::td/following-sibling::td[7]/a[@title='Ver']/i");
    public static final Target ASSERT_COMPROBANTE_FECHA= Target.the("validacion fecha de transaccion")
            .locatedBy("//strong[contains(text(),'Fecha:')]");
    public static final Target ASSERT_COMPROBANTE_HORA= Target.the("validacion hora de transaccion")
            .locatedBy("//strong[contains(text(),'Hora:')]");
    public static final Target ASSERT_COMPROBANTE_NRO_TRANSACCION= Target.the("validacion numero de transaccion")
            .locatedBy("//div[@id='modal-comprobante']//strong[contains(text(),'{0}')]");
    public static final Target ASSERT_COMPROBANTE_CUENTA_ORIGEN= Target.the("validacion cuenta origen de transaccion")
            .locatedBy("//strong[contains(text(),'Cuenta Origen:')]/parent::div/following-sibling::div[1]");
    public static final Target ASSERT_COMPROBANTE_NOMBRE_CLIENTE= Target.the("validacion nombre cliente")
            .locatedBy("//strong[contains(text(),'Nombre del Cliente:')]/parent::div/following-sibling::div[1]");
    public static final Target ASSERT_COMPROBANTE_IMPORTE= Target.the("validacion importe de transaccion")
            .locatedBy("//strong[contains(text(),'Importe Debitado:')]/parent::div/following-sibling::div[1]");
    public static final Target ASSERT_COMPROBANTE_NOMBRE_SERVICIO= Target.the("validacion nombre del servicio")
            .locatedBy("//strong[contains(text(),'Nombre servicio:')]/parent::div/following-sibling::div[1]");
    public static final Target ASSERT_COMPROBANTE_NOMBRE_CLIENTE_PAGO= Target.the("validacion nombre cliente")
            .locatedBy("//strong[contains(text(),'Nombre:')]/parent::div/following-sibling::div[1]");
    public static final Target ASSERT_COMPROBANTE_DESCRIPCION= Target.the("validacion descripcion del pago")
            .locatedBy("//strong[contains(text(),'Descripción:')]/parent::div/following-sibling::div[1]");
    public static final Target ASSERT_COMPROBANTE_NOTA= Target.the("validacion nota")
            .locatedBy("//strong[contains(text(),'*Comprobante No válido para Crédito Fiscal.')]");
    public static final Target BOTON_DESCARGAR= Target.the("ver comprobante")
            .locatedBy("//button[contains(text(),'Descargar Factura')]");
    public static final Target BOTON_IMPRIMIER= Target.the("ver comprobante")
            .locatedBy("//button[contains(text(),'Imprimir')]");
    public static final Target BOTON_CERRAR= Target.the("ver comprobante")
            .locatedBy("//app-dialog-comprobante//button[contains(text(),'Cerrar')]");
}
