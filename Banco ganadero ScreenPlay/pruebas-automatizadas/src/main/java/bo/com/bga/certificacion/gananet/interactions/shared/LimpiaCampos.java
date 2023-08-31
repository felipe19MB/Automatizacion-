package bo.com.bga.certificacion.gananet.interactions.shared;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LimpiaCampos implements Interaction {

    private Target elementoWeb;

    public LimpiaCampos(Target elementoWeb) {
        this.elementoWeb = elementoWeb;
    }

    public static LimpiaCampos paraEscribir(Target elementoWeb) {
        return Tasks.instrumented(LimpiaCampos.class, elementoWeb);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jse.executeScript(
                "return document.evaluate(\""+elementoWeb.getCssOrXPathSelector()+"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"+
                        "element.scrollIntoView();");
        element.clear();
    }
}
