package bo.com.bga.certificacion.ganamovil.interactions.utils.tap;

import bo.com.bga.certificacion.ganamovil.exceptions.ObjetosException;
import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import bo.com.bga.certificacion.ganamovil.utils.utils.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TapByElement implements Interaction {
    WebElement element;

    public TapByElement(WebElement element) {
        this.element = element;
    }

    @Step("{0} taps on element #atributo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Scroll.on(this.element)});

        try {
            (new Actions(GetDriver.as(actor).appiumDriver())).click(this.element).perform();
        } catch (RuntimeException var3) {
            String var10002 = ObjetosException.errorSeleccionandoObjeto();
            throw new ObjetosException(var10002 + this.element.toString());
        }
    }
}
