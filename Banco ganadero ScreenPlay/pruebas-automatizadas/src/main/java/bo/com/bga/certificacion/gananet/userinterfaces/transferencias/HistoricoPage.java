package bo.com.bga.certificacion.gananet.userinterfaces.transferencias;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosHistoricos;
import io.cucumber.java.it.Dato;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HistoricoPage {


    public static final Target TIPO_CUENTA_HISTORICO = Target.the("ingresa a sub funcionalidad de historico")
            .locatedBy("//a[contains(text(),'Históricos')]/following-sibling::ul//a[contains(text(),'{0}')]");
    public static final Target TXT_CUENTAS_PROPIAS = Target.the("cuentas propias")
            .locatedBy("//label[contains(text(),'Cuenta propia')]/following-sibling::select");

    public static final Target TXT_ESTADO_TRANFERENCIA = Target.the("estado de la transferencia")
            .locatedBy("//label[contains(text(),'Estado de la transferencia')]/following-sibling::select");

    public static final Target FECHA_DESDE = Target.the(" la fecha desde")
            .locatedBy("//label[contains(text(),'Desde')]/following-sibling::div/input");

    public static final Target FECHA_HASTA = Target.the("la fecha hasta")
            .locatedBy("//label[contains(text(),'Hasta')]/following-sibling::div/input");

    public static final Target BOTON_GENERAR_HISTORICO = Target.the("generar historico")
            .locatedBy("//a[normalize-space()='Generar historico']");

    public static final Target VALIDACIONES = Target.the("Todas la validaciones")
            .locatedBy("//table/tbody/tr[td/p[text()='{0}']]/td/p");

    public static final Target TXT_CUENTAS_TERCEROS = Target.the("la cuentas de terceros")
            .locatedBy("//label[contains(text(),'Cuenta tercero')]/following-sibling::select");

    public static final Target TXT_TIPO_TRANSFERENCIA = Target.the("el tipo de tranferencia")
            .locatedBy("//label[contains(text(),'Tipo transferencia')]/following-sibling::select");

    public static final Target TXT_BANCO_DESTINO = Target.the("el banco destino")
            .locatedBy("//label[contains(text(),'Banco destino')]/following-sibling::select");

    public static final Target TXT_CUENTA_DESTINO = Target.the("la cuenta destino")
            .locatedBy("//label[contains(text(),'Cuenta destino')]/following-sibling::select");

    public static final Target TXT_ESTADO = Target.the("el estado")
            .locatedBy("//label[contains(text(),'Estado')]/following-sibling::select");

    public static final Target TXT_NUMERO_TRANFERENCIA = Target.the("ingresa el estado")
            .locatedBy("//label[contains(text(),'Número de transferencia')]/following-sibling::input");


    public static final Target TXT_ALIAS_BENEFICIARIO = Target.the("el alias del beneficiario")
            .locatedBy("//label[contains(text(),'Alias del beneficiario')]/following-sibling::select");


    public static final Target TXT_PAIS_BENEFICIARIO = Target.the("el pais del beneficiario")
            .locatedBy("//label[contains(text(),'País del beneficiario')]/following-sibling::select");

    public static final Target BOTON_GENERAR_HISTORICO_TERCEROS= Target.the("boton de generar historico")
            .locatedBy("(//button[normalize-space()='Generar Historico'])");


    public static final Target BOTON_GENERAR_HISTORICO_OTROS= Target.the("boton de generar historico")
            .locatedBy("(//button[normalize-space()='Generar histórico'])");

    public static final Target BOTON_GENERAR_HISTORICO_EXTERIOR= Target.the("boton de generar historico")
            .locatedBy("//button[normalize-space()='Aplicar filtro']");


    public static final Target SCROLL_VALIDACION= Target.the("voy a validaciones")
            .locatedBy("//p[normalize-space()='{0}']");
}
