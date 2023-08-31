package bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class FormularioCuentaBancoBeneficiario implements Interaction {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public FormularioCuentaBancoBeneficiario(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript(
                "return document.evaluate(\"//button[@href='#modal-banco-beneficiario']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
        jse.executeScript("arguments[0].click();", element);
        element = (WebElement) jse.executeScript(
                "return document.evaluate(\"(//label[contains(text(),'Tipo de Codigo')]/following-sibling::div/select[contains(@class, 'ng-untouched')])[1]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
        jse.executeScript("arguments[0].click();", element);
        actor.attemptsTo(
//                Espera.aTime(3000),
                Scroll.to(AfiliacionesPage.SELECT_TIPO_CODIGO),
                Enter.theValue(datosAfiliacionCuentas.getCodigoBanco()).into(AfiliacionesPage.TXT_CODIGO_BANCO),
                byVisibleText(datosAfiliacionCuentas.getTipoCodigo()).from(AfiliacionesPage.SELECT_TIPO_CODIGO),
                Enter.theValue(datosAfiliacionCuentas.getNombreBanco()).into(AfiliacionesPage.TXT_NOMBRE_BANCO),
                byVisibleText(datosAfiliacionCuentas.getPaisBanco()).from(AfiliacionesPage.SELECT_PAIS_BANCO),
                Enter.theValue(datosAfiliacionCuentas.getCiudadBanco()).into(AfiliacionesPage.TXT_CIUDAD_BANCO),
                WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds(),
                JavaScriptClick.on(AfiliacionesPage.BUTTON_GUARDAR_2),
                JavaScriptClick.on(AfiliacionesPage.BUTTON_GUARDAR_1)
        );
    }
    public static FormularioCuentaBancoBeneficiario go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Instrumented.instanceOf(FormularioCuentaBancoBeneficiario.class).withProperties(datosAfiliacionCuentas);
    }
}
