package bo.com.bga.certificacion.ganamovil.interactions.utils.scroll;

import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

public class ScrollTo implements Interaction {
    private final String atributo;
    private final String selector;

    public ScrollTo(String selector, String atributo) {
        this.selector = selector;
        this.atributo = atributo;
    }

    @Step("{0} scrolled to (#atributo)")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Tap.on(GetDriver.as(actor).appiumDriver().findElement(AppiumBy.androidUIAutomator(String.format(this.selector, this.atributo))))});
    }
}
