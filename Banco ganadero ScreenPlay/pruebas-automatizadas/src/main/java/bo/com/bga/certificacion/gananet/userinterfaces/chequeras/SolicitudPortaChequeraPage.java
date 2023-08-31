package bo.com.bga.certificacion.gananet.userinterfaces.chequeras;

import net.serenitybdd.screenplay.targets.Target;

public class SolicitudPortaChequeraPage {
    public static final Target TIPO_PORTA_CHEQUERA = Target.the("Select para escoger el tipo de porta chequera").
            locatedBy("//label[contains(., 'Tipos Porta Chequera')]/following-sibling::div/select");
    public static final Target COSTO_PORTA_CHEQUERA = Target.the("Costo de la solicitud de la porta chequera").
            locatedBy("//div[div/strong[contains(., 'Cargo porta chequera:')]]/div[2]");
    public static final Target IMPORTE_A_DEBITAR_PORTA_CHEQUERA = Target.the("Valor del importe a debitar a la cuenta del clietne").
            locatedBy("//div[div/strong[contains(., 'Importe a debitar:')]]/div[4]");
    public static final Target TIPO_RETIRO_PORTA_CHEQUERA = Target.the("Select para escoger el tipo de retiro de la porta chequera").
            locatedBy("//label[contains(., 'Retira la chequera')]/following-sibling::div/select");
    public static final Target OFICINA_ENTREGA_PORTA_CHEQUERA = Target.the("Select para escoger la oficina en la que se entregará la porta chequera").
            locatedBy("//label[contains(., 'Oficina Entrega')]/following-sibling::select");
    public static final Target COMENTARIOS_PORTA_CHEQUERA = Target.the("Select para escoger la oficina en la que se entregará la porta chequera").
            locatedBy("//label[contains(., 'Comentarios')]/following-sibling::textarea");
    public static final Target NOTA_COMPROBANTE = Target.the("Mensaje que se genera en el comprobante como alerta").
            locatedBy("//*[@id=\"contentPDFComprobante\"]/div/div[2]/div[2]/div[15]/strong");
    public static final Target FECHA_COMPROBANTE_PORTA_CHEQUERA = Target.the("Fecha generada en el comprobante de porta chequera").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-solicitud-porta-chequera/app-dialog-comprobante/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div[1]");
    public static final Target HORA_COMPROBANTE_PORTA_CHEQUERA = Target.the("Hora generada en el comprobante de porta chequera").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-solicitud-porta-chequera/app-dialog-comprobante/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]");
    public static final Target ID_COMPROBANTE_PORTA_CHEQUERA = Target.the("ID generado en el comprobante de porta chequera").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-solicitud-porta-chequera/app-dialog-comprobante/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div[3]/strong");
    public static final Target COMPROBANTE_TIPO_PORTA_CHEQUERA= Target.the("Tipo porta chequera impreso en el comprobante")
            .locatedBy("//div[strong[contains(., 'Tipo:')]]/following-sibling::div[contains(., '{0}')]");
    public static final Target COMPROBANTE_OFICINA= Target.the("Oficina impresa en el comprobante")
            .locatedBy("//div[strong[contains(., 'Oficina:')]]/following-sibling::div[contains(., '{0}')]");
    public static final Target NOTA_COMPROBANTE_PORTA_CHEQUERA= Target.the("Nota de alerta impresa en el comprobante")
            .locatedBy("/html/body/app-root/app-paginas/div/div/app-solicitud-porta-chequera/app-dialog-comprobante/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div[15]/strong");
}
