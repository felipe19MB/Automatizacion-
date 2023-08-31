package bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
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

public class EliminarCuentasAfiliadas implements Task {
    DatosAfiliacionCuentas datosAfiliacionCuentas;

    public EliminarCuentasAfiliadas(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String submodulo = datosAfiliacionCuentas.getSubFuncionalidad();
        String numeroCuenta = datosAfiliacionCuentas.getNroCuenta();
        WebElement element;
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        switch (submodulo) {
            case "Cuentas de terceros":
                element = (WebElement) jse.executeScript(
                        "return document.evaluate(\"//small[contains(text(),'"+numeroCuenta+"')]/parent::div/following-sibling::div[4]/a\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
                jse.executeScript("arguments[0].click();", element);
                break;
            case "Cuentas de billetera":
                numeroCuenta = datosAfiliacionCuentas.getTelefono();
                element = (WebElement) jse.executeScript(
                        "return document.evaluate(\"//small[contains(text(),'"+numeroCuenta+"')]/parent::div/following-sibling::div[3]/a\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
                jse.executeScript("arguments[0].click();", element);
                break;
            case "Cuentas del exterior":
                numeroCuenta = datosAfiliacionCuentas.getNombreAfiliado();
                element = (WebElement) jse.executeScript(
                        "return document.evaluate(\"//small[contains(text(),'"+numeroCuenta+"')]/parent::div/following-sibling::div[2]/a[@title='Quitar']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
                jse.executeScript("arguments[0].click();", element);
                break;
            case "Cuentas de otros bancos":
                element = (WebElement) jse.executeScript(
                        "return document.evaluate(\"//small[contains(text(),'"+numeroCuenta+"')]/parent::div/following-sibling::div[3]/a\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
                jse.executeScript("arguments[0].click();", element);
                break;
            default:
                break;
        }
        actor.attemptsTo(
                Enter.theValue("1234").into(HomePage.INPUT_GANAPIN_1),
                JavaScriptClick.on(AfiliacionesPage.BUTTON_PROCESAR),
                WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(10).seconds()
        );
    }
    public static EliminarCuentasAfiliadas go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Tasks.instrumented(EliminarCuentasAfiliadas.class,datosAfiliacionCuentas);
    }
}
