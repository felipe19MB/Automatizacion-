package bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos;

import net.serenitybdd.screenplay.targets.Target;

public class GenerarExtractosPage {


    public static final Target CHECK_BOX_CUENTA = Target.the("EL checK de la cuenta")
            .locatedBy("//td[p=' {0} ']/following-sibling::td/div");

    public static final Target BOTON_SIGUIENTE = Target.the("el boton siguiente")
            .locatedBy("//button[normalize-space()='Siguiente']");

    public static final Target CHECK_FILTRO= Target.the("el check del filtro")
            .locatedBy("(//label[contains(text(),'{0}')])[1]");

    public static final Target FECHA_DESDE= Target.the("la fecha desde")
            .locatedBy("(//label[contains(text(),'Desde')]/following-sibling::div/input)[1]");

    public static final Target FECHA_HASTA= Target.the("la fecha hasta")
            .locatedBy("(//label[contains(text(),'Hasta')]/following-sibling::div/input)[1]");

    public static final Target BOTON_BUSCAR= Target.the("el boton buscar")
            .locatedBy("//button[normalize-space()='buscar']");

    public static final Target VALIDAR_NUMERO_TRANSACCION= Target.the("el numero de transaccion")
            .locatedBy("//p[normalize-space()='1007228']");

    public static final Target VALIDAR_DESCRIPCION= Target.the("la descripcion")
            .locatedBy("(//table/tbody/tr[td/p[text()='1007228']]/td/p)[5]");

    public static final Target VALIDAR_DEBITO= Target.the("el debito")
            .locatedBy("(//table/tbody/tr[td/p[text()='1007228']]/td/p)[6]");

    public static final Target VALIDAR_SALDO_DISPONIBLE= Target.the("el saldo disponible")
            .locatedBy("(//table/tbody/tr[td/p[text()='1007228']]/td/p)[8]");
}
