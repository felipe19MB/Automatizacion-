package bo.com.bga.certificacion.gananet.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target PERFIL_LISTA = Target.the("elemento para desplegar la lista de productos asociados al cliente")
            .locatedBy("(//i[contains(@class,'fa fa-caret-down')])[1]");

    public static final Target PERFIL_CHOOSE = Target.the("se escoge el perfil")
            .locatedBy("(//a[contains(text(),'{0}')])[1]");

    public static final Target MODULO = Target.the("se escoge el modulo")
            .locatedBy("(//section[@class='sidebar']//span[contains(text(),'{0}')])[1]");

    public static final Target FUNCIONALIDAD = Target.the("funcionalidad a escoger")
            .locatedBy("//ul[@style='display: block;']/li/a[normalize-space()='{0}']");

    public static final Target CIRCULO_CARGA= Target.the("circulo de carga")
            .locatedBy("//div[contains(@class,'col-12')]//grafico-cuenta//div[contains(@class,'box')]//ngx-loading//div//div//div[contains(@class,'spinner-circle-swish')]");

    public static final Target CIRCULO_CARGA_PANTALLA_COMPLETA= Target.the("circulo de carga pantalla completa")
            .located(By.xpath("/html/body/app-root/app-paginas/div/ngx-loading/div/div[2]/div"));

    public static final Target CHECK_TRANSACCION_EXITOSA= Target.the("check que permite verificar la transacción éxitosa")
            .located(By.xpath("/html/body/div[3]/div/div[1]/div[5]/div[2]"));

    public static final Target NOMBRE_USUARIO= Target.the("nombre del usuario")
            .locatedBy("//li[@class=\"user-profile treeview\"]/a/div/span/strong");

    public static final Target INPUT_GANAPIN= Target.the("input para diligenciar el ganapin")
            .located(By.xpath("(//form[contains(@class, 'ng-valid')]//input[@name='token'])[1]"));

    public static final Target INPUT_GANAPIN2= Target.the("input para diligenciar el ganapin")
            .located(By.xpath("(//form[contains(@class, 'ng-valid')]//input[@name='token'])[2]"));

    public static final Target INPUT_CLAVE= Target.the("input para diligenciar el ganapin")
            .located(By.xpath("//input[@name='token']"));
    public static final Target INPUT_GANAPIN_1= Target.the("input para diligenciar el ganapin")
            .located(By.xpath("//form[@class='ng-untouched ng-pristine ng-valid']//input[@name='token']"));

    public static final Target BUTTON_TOP_HEADER= Target.the("Botón para desplegar la lista de cuentas del usuario")
            .located(By.xpath("/html/body/app-root/app-paginas/div/seccion-header/seccion-navbar/header/nav/seccion-seleccion-sesion/div/div/li/a"));

    public static final Target NEXT_BUTTONS= Target.the("Botón {0}")
            .locatedBy("//button[contains(text(),'{0}')]");

    public static final Target LOADER_TRANSVERSAL = Target.the("Loader de carga, mientras se procesa las transacciones de GanaNet")
            .located(By.xpath("/html/body/app-root/app-paginas/div/ngx-loading/div/div[1]"));

    public static final Target BUTTON_PROCESAR= Target.the("Botón para procesar GanaPin")
            .located(By.xpath("(//form[contains(@class, 'ng-valid')]//button[@type='submit'])[1]"));

    public static final Target BUTTON_PROCESAR2= Target.the("Botón para procesar GanaPin")
            .located(By.xpath("(//button[@type='submit'][normalize-space()='Procesar'])[2]"));

    public static final Target BUTTON_PROCESAR_1= Target.the("Botón para procesar GanaPin")
            .located(By.xpath("//form[@class='ng-valid ng-dirty ng-touched']//button[@type='submit']"));
    public static final Target BUTTON_PROCESAR_2= Target.the("Botón para procesar GanaPin")
            .located(By.xpath("(//form[contains(@class, 'ng-valid')]//button[@type='submit'])[2]"));

    public static final Target COMPROBANTE_CUENTA_ORIGEN = Target.the("Valida que la cuenta {0} haya quedado como origen")
            .locatedBy("//div[strong[contains(., 'Cuenta Origen:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_CUENTA_DESTINO= Target.the("Valida que la cuenta {0} haya quedado como destino")
            .locatedBy("//div[strong[contains(., 'Cuenta Destino:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_IMPORTE_DEBITADO= Target.the("Importe debitado impreso en el comprobante")
            .locatedBy("//div[strong[contains(., 'Importe Debitado:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_IMPORTE_ABONADO= Target.the("Importe abonado impreso en el comprobante")
            .locatedBy("//div[strong[contains(., 'Importe abonado:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_MOTIVO_DEBITO_PROPIA= Target.the("Motivo del debito")
            .locatedBy("//div[strong[contains(., 'Motivo del Débito:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target COMPROBANTE_MOTIVO_CREDITO_PROPIA= Target.the("Motivo del credito")
            .locatedBy("//div[strong[contains(., 'Motivo del Crédito:')]]/following-sibling::div[contains(., '{0}')]");
}
