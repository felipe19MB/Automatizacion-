package bo.com.bga.certificacion.gananet.tasks.orden_cobro_simple.administracion_qr;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.DatosAdministracionQr;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class EliminarCuenta implements Task {
    DatosAdministracionQr datosAdministracionQr;
    public EliminarCuenta(DatosAdministracionQr datosAdministracionQr) {
        this.datosAdministracionQr = datosAdministracionQr;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String numeroCuenta = datosAdministracionQr.getNroCuenta();
        WebElement element;
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        element = (WebElement) jse.executeScript(
                "return document.evaluate(\"//control-tabla-v2//h4[contains(text(),'"+numeroCuenta+"')]/parent::div/following-sibling::div[5]//a[@title='Eliminar']/i\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
        jse.executeScript("arguments[0].click();", element);
        actor.attemptsTo(
                Enter.theValue("1234").into(HomePage.INPUT_GANAPIN_1),
                JavaScriptClick.on(HomePage.BUTTON_PROCESAR_2),
                WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(10).seconds(),
                CerrarModal.go()
        );

    }
    public static EliminarCuenta go(DatosAdministracionQr datosAdministracionQr){
        return Tasks.instrumented(EliminarCuenta.class,datosAdministracionQr);
    }
}
