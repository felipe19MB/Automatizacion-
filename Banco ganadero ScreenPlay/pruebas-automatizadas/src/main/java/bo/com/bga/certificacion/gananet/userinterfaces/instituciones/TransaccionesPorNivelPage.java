package bo.com.bga.certificacion.gananet.userinterfaces.instituciones;

import net.serenitybdd.screenplay.targets.Target;

public class TransaccionesPorNivelPage {

    public static final Target LABEL_INSTITUCIONES= Target.the(" el label  de la institucion")
            .locatedBy("//label[contains(text(),'Institución')]/following-sibling::select");

    public static final Target LABEL_AÑO_GESTION= Target.the(" el label  del año de la gestion")
            .locatedBy("//label[contains(text(),'Gestión')]/following-sibling::select");

    public static final Target LABEL_NIVEL= Target.the(" el label del nivel")
            .locatedBy("//label[contains(text(),'Nivel')]/following-sibling::select");


    public static final Target BUTTON_GENERAR= Target.the(" el boton generar")
            .locatedBy("//button[normalize-space()='Generar']");

    public static final Target TIPO_TRANSACION_INSTITUCION = Target.the("ingresa a sub funcionalidad de historico")
            .locatedBy("//a[contains(text(),'Reporte de Instituciones')]/following-sibling::ul//a[contains(text(),'{0}')]");

    public static final Target VALIDACION_TRANS_NIVEL_CABEZA = Target.the("validacion cabeza del formato")
            .locatedBy("//div[@id='transaccionNivel']//div[@class='row']/div/h5[contains(text(),'{0}')]");

    public static final Target VALIDACION_TRANSACCIONES_NIVEL = Target.the("validacion informacion transacciones")
            .locatedBy("//table/tbody/tr/td[normalize-space()='{0}']");

    public static final Target VALIDACION_TRANSACCIONES_NIVEL_2 = Target.the("validacion informacion transacciones")
            .locatedBy("//table/tbody/tr/td[text()='{0}']");


}
