package bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas;

import net.serenitybdd.screenplay.targets.Target;

public class HistoricoPagoPlanillas {
    public static final Target SELECT_CONVENIO= Target.the("selecionar convenio")
            .locatedBy("//label[contains(text(),'Convenio ')]/following-sibling::select");
    public static final Target FECHA_PERIODO_DEL= Target.the("selecionar fecha desde")
            .locatedBy("//label[contains(text(),'Periodo del ')]/following-sibling::div/input");
    public static final Target FECHA_PERIODO_AL= Target.the("selecionar fecha hasta")
            .locatedBy("//label[contains(text(),'al')]/following-sibling::div/input");
    public static final Target BOTON_BUSCAR= Target.the("boton para buscar")
            .locatedBy("//button[contains(text(),'Buscar')]");
    public static final Target CIRCULO_CARGA= Target.the("circulo de carga")
            .locatedBy("//ngx-loading[1]//div[@class='spinner-circle-swish full-screen ng-star-inserted']");
    public static final Target ABRIR_PLANILLA= Target.the("Abrir Planilla")
            .locatedBy("//p[contains(text(),'{0}')]/parent::td/following-sibling::td[7]//a");
    public static final Target VALIDACIONES= Target.the("Todas la validaciones")
            .locatedBy("//div[@class='form-group mb-20']/p");
    public static final Target MODAL_HISTORICO= Target.the("Modal")
            .locatedBy("//h3[contains(text(),'Histórico de Pago Planillas')]");
    public static final Target VALIDACIONES_CLIENTES= Target.the("Todas la validaciones")
            .locatedBy("//div[@class='modal-content my-auto']//tr[@class='ng-star-inserted']/td/p[@class=' m-0 small']");

}