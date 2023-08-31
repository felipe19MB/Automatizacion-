package bo.com.bga.certificacion.gananet.userinterfaces.chequeras;

import net.serenitybdd.screenplay.targets.Target;

public class ConciliacionChequeraPage {

    public static final Target CUENTA_DE_ORIGEN_CHECK= Target.the("la cuenta de origen").
            locatedBy("//div[normalize-space()='{0}']/h4");

    public static final Target PERIODO= Target.the("el periodo a buscar").
            locatedBy("//label[normalize-space()='{0}']");


    public static final Target LABEL_FECHA_DESDE= Target.the(" el label de la fecha final")
            .locatedBy("//label[contains(text(),'Desde')]/following-sibling::div/input");

    public static final Target LABEL_FECHA_HASTA= Target.the(" el label de la fecha final")
            .locatedBy("//label[contains(text(),'Hasta')]/following-sibling::div/input");

    public static final Target BOTON_SIGUIENTE= Target.the(" el boton generar")
            .locatedBy("//button[normalize-space()='Siguiente']");

    public static final Target BOTON_BUSCAR= Target.the(" el boton generar")
            .locatedBy("//button[normalize-space()='Buscar']");

    public static final Target VALIDACIONES_CONCILIACION= Target.the("validaciones")
            .locatedBy("//tr[contains(@class,'ng-star-inserted')]/td//p[normalize-space()='{0}']");


}
