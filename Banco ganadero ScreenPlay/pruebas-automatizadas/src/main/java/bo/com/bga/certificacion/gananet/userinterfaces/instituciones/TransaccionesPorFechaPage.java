package bo.com.bga.certificacion.gananet.userinterfaces.instituciones;

import net.serenitybdd.screenplay.targets.Target;

public class TransaccionesPorFechaPage {

    public static final Target LABEL_INSTITUCIONES= Target.the(" el label  de la institucion")
            .locatedBy("//label[contains(text(),'Institución')]/following-sibling::select");

    public static final Target LABEL_AÑO_GESTION= Target.the(" el label  del año de la gestion")
            .locatedBy("//label[contains(text(),'Gestión')]/following-sibling::select");

    public static final Target LABEL_FECHA_INICIAL= Target.the(" el label de la fecha incial")
            .locatedBy("//label[contains(text(),'Fecha Inicial')]/following-sibling::div/input");

    public static final Target LABEL_FECHA_FINAL= Target.the(" el label de la fecha final")
            .locatedBy("//label[contains(text(),'Fecha Final')]/following-sibling::div/input");

    public static final Target CHECK_BOX_AGRUPACION= Target.the(" el check box de la agrupacion")
            .locatedBy("//label[normalize-space()='{0}']");

    public static final Target BUTTON_GENERAR= Target.the(" el boton generar")
            .locatedBy("//button[normalize-space()='Generar']");

    public static final Target TIPO_TRANSACION_INSTITUCION = Target.the("ingresa a sub funcionalidad de historico")
            .locatedBy("//a[contains(text(),'Reporte de Instituciones')]/following-sibling::ul//a[contains(text(),'{0}')]");

    public static final Target VALIDACION_TRANSACCIONES_FECHA = Target.the("validacion numero de transaccion")
            .locatedBy("//table/tbody/tr/td[text()='{0}']");

}
