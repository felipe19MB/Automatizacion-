package bo.com.bga.certificacion.gananet.userinterfaces.transferencias;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class TransferenciasPage {
    public static final Target CUENTA_ORIGEN = Target.the("Selecciona la cuenta {0} como origen")
            .locatedBy("//h4[contains(text(),'{0}')]");
    public static final Target CUENTA_DESTINO= Target.the("Selecciona la cuenta {0} como destino")
            .locatedBy("//div/small[contains(text(),'{0}')]");
    public static final Target IMPORTE= Target.the("monto a transferir")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/*[self::transferencia-terceros or self::transferencia-otros-bancos or self::transferencia-propia]/control-wizard-step/control-wizard-container[2]/app-monto-descripcion/div/div[2]/div/div/div[2]/div/div[1]/control-input-monto/div/input\n"));
    public static final Target MOTIVO_DEBITO= Target.the("el motivo del debito")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/*[self::transferencia-terceros or self::transferencia-propia or self::transferencia-otros-bancos]/control-wizard-step/control-wizard-container[2]/app-monto-descripcion/div/div[2]/div/div/div[2]/div/div[2]/control-input-textarea/div/textarea"));
    public static final Target MOTIVO_CREDITO= Target.the("el motivo del crédito")
            .locatedBy("/html/body/app-root/app-paginas/div/div/*[self::transferencia-terceros or self::transferencia-otros-bancos or self::transferencia-propia]/control-wizard-step/control-wizard-container[2]/app-monto-descripcion/div/div[2]/div/div/div[2]/div/div[3]/control-input-textarea/div/textarea");
    public static final Target TIPO_MONEDA_OPCION= Target.the("Selecciona opción {0}")
            .locatedBy("//div/a[contains(text(),'{0}')]");
    public static final Target COMPROBANTE_TITULO= Target.the("Titúlo del comprobante según transferencia '{0}'")
            .locatedBy("/html/body/app-root/app-paginas/div/div/*[self::transferencia-terceros or self::transferencia-otros-bancos or self::transferencia-propia]/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/h3");
    public static final Target COMPROBANTE_ID= Target.the("Id de la transferencia")
            .locatedBy("/html/body/app-root/app-paginas/div/div/*[self::transferencia-terceros or self::transferencia-otros-bancos or self::transferencia-propia]/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div[3]/strong");

}
