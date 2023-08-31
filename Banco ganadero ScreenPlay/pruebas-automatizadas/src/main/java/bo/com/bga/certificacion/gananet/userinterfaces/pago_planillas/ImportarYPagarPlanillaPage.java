package bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ImportarYPagarPlanillaPage {
    public static final Target SELECT_PAGO= Target.the("selecionar tipo y forma de pago")
            .locatedBy("//label[contains(text(),'{0}')]");
    public static final Target SELECT_AUTORIZACION= Target.the("Selector para elegir el tipo de autorización que se le dará a la planilla")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[3]/app-cargar-archivo/control-box/div/div[2]/div/div[1]/div[2]/control-combobox/div/select"));
    public static final Target SELECT_CONVENIO= Target.the("Selector para elegir el tipo de convenio que se usará para pagar la planilla")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[3]/app-cargar-archivo/control-box/div/div[2]/div/div[2]/div/control-combobox/div/select"));
   public static final Target NOMBRE_PLANILLA= Target.the("Input para asignarle el nombre a la planilla")
            .locatedBy("/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[3]/app-cargar-archivo/control-box/div/div[2]/div/div[3]/div[1]/control-input-text/div/input");
    public static final Target GLOSA_ADICIONAL= Target.the("Input que permite adicionar una glosa")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[3]/app-cargar-archivo/control-box/div/div[2]/div/div[3]/div[3]/control-input-text/div/input"));
  public static final Target UPLOAD_FILE= Target.the("Input que permite subir planilla para posterior realizar el pago")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[3]/app-cargar-archivo/control-box/div/div[2]/div/div[1]/div[1]/div/label/input[1]"));
    public static final Target ESTADO_TRANSACCION= Target.the("Texto que contiene el estado de la transacción")
            .located(By.xpath("/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[4]/app-resumen/div/div[2]/control-box/div/div[2]/div/div/div/div[6]/div[2]/h6"));

    public static final Target NOTIFICACION= Target.the("Texto que contiene el estado de la transacción")
            .located(By.xpath("//button[contains(text(),'Permitir')]"));

}