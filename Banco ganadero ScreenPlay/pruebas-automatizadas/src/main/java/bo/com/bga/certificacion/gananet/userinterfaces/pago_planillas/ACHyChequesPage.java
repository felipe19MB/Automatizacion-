package bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas;

import net.serenitybdd.screenplay.targets.Target;

public class ACHyChequesPage {


    public static final Target SELECT_SERVICIO= Target.the("En el label de servicio")
            .locatedBy("//label[contains(text(),'Servicio')]/following-sibling::select");

    public static final Target SELECT_TIPO_REPORTE= Target.the("En el label de tipo reporte")
            .locatedBy("//label[contains(text(),'Tipo de Reporte')]/following-sibling::select");

    public static final Target CHECKBOX_BUSCAR_POR= Target.the("checkbox para buscar por planilla")
            .locatedBy("//label[contains(text(),'{0}')]");

    public static final Target TXT_PLANILLA= Target.the("numero de planilla")
            .locatedBy("(//input[@type='text'])[1]");

    public static final Target BOTON_BUSCAR= Target.the("boton para buscar")
            .locatedBy("//a[normalize-space()='Buscar']");

    public static final Target VALIDACION_CONVENIO= Target.the("validacion convenio")
            .locatedBy("(//td[@class='p-10 text-right']/p)[1]");


    public static final Target VALIDACION_LOTE= Target.the("validacion lote")
            .locatedBy("(//td[@class='p-10']/p)[1]");


    public static final Target VALIDACION_NRO_PLANILLA= Target.the("validacion numero planilla")
            .locatedBy("(//td[@class='p-10 text-left']/p)[1]");

    public static final Target VALIDACION_NRO_IDENTIFICACION= Target.the("validacion numero identificacion")
            .locatedBy("(//td[@class='p-10 text-left']/p)[5]");

    public static final Target SCROLL_BAJAR= Target.the("scroll")
            .locatedBy("//div[@class='box-body bg-box-body']//a[@class='btn btn-paginador mr-1 btn-paginador-seleccionado ng-star-inserted'][normalize-space()='1']");





}
