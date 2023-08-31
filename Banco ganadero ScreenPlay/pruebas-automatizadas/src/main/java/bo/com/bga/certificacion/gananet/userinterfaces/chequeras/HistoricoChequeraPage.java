package bo.com.bga.certificacion.gananet.userinterfaces.chequeras;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HistoricoChequeraPage {
    public static final Target CUENTAS_SELECTOR = Target.the("Select para escoger la cuenta a consultar historico").
            locatedBy("//label[contains(text(),'Cuentas ')]/following-sibling::select");
    public static final Target FECHA_INICIO_HISTORICO_CHEQUERAS = Target.the("Input para diligenciar la fecha inicio del historico").
            locatedBy("//label[contains(text(),'Periodo del ')]/following-sibling::div/input");
    public static final Target FECHA_FIN_HISTORICO_CHEQUERAS = Target.the("Input para diligenciar la fecha inicio del historico").
            locatedBy("//label[contains(text(),'al ')]/following-sibling::div/input");
    public static final Target BOTON_BUSCAR_HISTORICO_CHEQUERAS = Target.the("Botón para buscar según los datos ingresados").
            locatedBy("//a[contains(text(),'Buscar')]");
    public static final Target CAMPO_CUENTA_HISTORICO_CHEQUERA = Target.the("Campo cuenta en la tabla del historico").
            locatedBy("//tr[2]/td[2]/p");
    public static final Target CAMPO_MONTO_HISTORICO_CHEQUERA = Target.the("Campo monto en la tabla del historico").
            locatedBy("//tr[2]/td[3]/p");
    public static final Target CAMPO_MONEDA_HISTORICO_CHEQUERA = Target.the("Campo moneda en la tabla del historico").
            locatedBy("//tr[2]/td[4]/p");
    public static final Target CAMPO_CHEQUES_HISTORICO_CHEQUERA = Target.the("Campo cheques disponibles en la tabla del historico").
            locatedBy("//tr[2]/td[5]/p");
    public static final Target BOTON_DETALLE_HISTORICO_CHEQUERA = Target.the("Campo cheques disponibles en la tabla del historico").
            locatedBy("//tr[2]/td[6]/div");
    public static final Target NOTA_HISTORICO_SOLICITUD_CHEQUERA = Target.the("Campo cheques disponibles en la tabla del historico").
            locatedBy("//*[@id=\"contentPDFComprobante\"]/div/div[2]/div[2]/div[21]/strong");

    public static final Target VALIDACIONES_HISTORICO_CHQUES = Target.the("Todas la validaciones")
            .locatedBy("//table/tbody/tr[td/p[text()='{0}']]");

}