package bo.com.bga.certificacion.gananet.tasks.administracion;

import bo.com.bga.certificacion.gananet.models.administracion.DatosNuevoPerfil;
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
public class EliminarPerfil implements Task {
    DatosNuevoPerfil datosNuevoPerfil;

    public EliminarPerfil(DatosNuevoPerfil datosNuevoPerfil) {
        this.datosNuevoPerfil = datosNuevoPerfil;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        String nombrePerfil = datosNuevoPerfil.getNombrePerfil();
        WebElement element;
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        element = (WebElement) jse.executeScript(
                "return document.evaluate(\"//h4[contains(text(),'" + nombrePerfil + "')]/parent::div/following-sibling::div[2]//a[@title='Eliminar']/i\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
        jse.executeScript("arguments[0].click();", element);

        actor.attemptsTo(
                Enter.theValue("1234").into(HomePage.INPUT_GANAPIN_1),
                JavaScriptClick.on(AfiliacionesPage.BUTTON_PROCESAR),
                WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(10).seconds()
        );
    }
    public static EliminarPerfil go(DatosNuevoPerfil datosNuevoPerfil) {
        return Tasks.instrumented(EliminarPerfil.class, datosNuevoPerfil);

    }

}
