package bo.com.bga.certificacion.ganamovil.interactions.utils.tap;

import bo.com.bga.certificacion.ganamovil.exceptions.ObjetosException;
import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import bo.com.bga.certificacion.ganamovil.utils.utils.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Actions;

public class TapByTarget implements Interaction {
    private final Target target;

    public TapByTarget(Target target) {
        this.target = target;
    }

    @Step("{0} taps on #target")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Scroll.on(this.target)});

        try {
            (new Actions(GetDriver.as(actor).appiumDriver())).click(this.target.resolveFor(actor).getElement()).perform();
        } catch (RuntimeException var3) {
            String var10002 = ObjetosException.errorSeleccionandoObjeto();
            throw new ObjetosException(var10002 + this.target.toString());
        }
    }
}
