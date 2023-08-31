package bo.com.bga.certificacion.ganamovil.interactions.utils.tap;

import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class TapOnVisibleObject implements Interaction {
    private final Target target;

    public TapOnVisibleObject(Target target) {
        this.target = target;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Check.whether(this.target.resolveFor(actor).isCurrentlyVisible()).andIfSo(new Performable[]{Tap.on(this.target)})});
    }
}
