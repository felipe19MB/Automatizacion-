package bo.com.bga.certificacion.gananet.userinterfaces.chequeras;

        import net.serenitybdd.screenplay.targets.Target;

public class SolicitudChequeraPage {


    public static final Target CHECK_BOX_CUENta_ORIGEN = Target.the("EL checK de la cuenta origen")
            .locatedBy("//h4[contains(text(),' [CC]{0}')]");

    public static final Target LABEL_FORMATO = Target.the("el formato")
            .locatedBy("//label[contains(text(),'Formato')]/following-sibling::div/select");

    public static final Target TALONARIO_DE= Target.the("el talonario")
            .locatedBy("//label[contains(text(),' Talonarios de ')]/following-sibling::div/select");

    public static final Target CANTIDAD_TALONARIO= Target.the("la cantidad de talonarios")
            .locatedBy("//label[contains(text(),'Cant. Talonarios')]/following-sibling::input");

    public static final Target SELLO_INTRANSFERIBLE= Target.the("el sello de intranferibilidad")
            .locatedBy("//label[contains(text(),' Con sello de intransferible ')]/following-sibling::div/select");

    public static final Target PORTA_CHEQUERA= Target.the("el porta chequera")
            .locatedBy("//label[contains(text(),' Porta Chequera ')]/following-sibling::div/select");

    public static final Target BOTON_SIGUIENTE= Target.the("el boton siguiente")
            .locatedBy("//button[normalize-space()='Siguiente']");

    public static final Target RETIRO_CHEQUERA= Target.the("el lugar de retiro de la chequera")
            .locatedBy("//label[contains(text(),'Retira la chequera ')]/following-sibling::select");

    public static final Target OFICINA_ENTREGA= Target.the("la oficina de entrega")
            .locatedBy("//label[contains(text(),'Oficina Entrega ')]/following-sibling::select");

    public static final Target BOTON_FINALIZAR= Target.the("el boton finalizar")
            .locatedBy("//button[normalize-space()='Finalizar']");

    public static final Target MENSAJE_SOLICITUD_CREADA= Target.the("el mensaje de solicitud creada")
            .locatedBy("//div[@id='swal2-content']");

    public static final Target BOTON_ACEPTAR= Target.the("el boton ok")
            .locatedBy("//button[normalize-space()='Aceptar']");

}
