package bo.com.bga.certificacion.gananet.tasks.pago_planillas;

import bo.com.bga.certificacion.gananet.models.pago_planillas.DatosHistoricoPagoPlanillas;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SeleccionarPlanilla implements Task {
    DatosHistoricoPagoPlanillas datosHistoricoPagoPlanillas;
    public SeleccionarPlanilla(DatosHistoricoPagoPlanillas datosHistoricoPagoPlanillas) {
        this.datosHistoricoPagoPlanillas = datosHistoricoPagoPlanillas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String numeroPlanilla = datosHistoricoPagoPlanillas.getNroPlanilla();
        actor.attemptsTo(
                WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(500).seconds()
        );
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript(
                "return document.evaluate(\"//p[contains(text(),'"+numeroPlanilla+"')]/parent::td/following-sibling::td[7]//a\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
        jse.executeScript("arguments[0].click();", element);
        actor.attemptsTo(WaitUntil.the(HistoricoPagoPlanillas.MODAL_HISTORICO, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                Scroll.to(HistoricoPagoPlanillas.VALIDACIONES_CLIENTES));
    }
    public static SeleccionarPlanilla go(DatosHistoricoPagoPlanillas datosHistoricoPagoPlanillas){
        return Tasks.instrumented(SeleccionarPlanilla.class,datosHistoricoPagoPlanillas);
    }
}
