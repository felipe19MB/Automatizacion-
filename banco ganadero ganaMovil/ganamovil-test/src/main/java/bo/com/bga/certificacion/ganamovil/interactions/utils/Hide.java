package bo.com.bga.certificacion.ganamovil.interactions.utils;

import bo.com.bga.certificacion.ganamovil.userinterfaces.util.BotonesiOS;
import bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities;
import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.conditions.Check;

public class Hide implements Interaction {
    public Hide() {
    }

    public static Hide keyboard() {
        return new Hide();
    }

    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isiOS(actor)) {
            actor.attemptsTo(new Performable[]{Check.whether(BotonesiOS.BTN_DONE.resolveFor(actor).isCurrentlyVisible()).andIfSo(new Performable[]{Tap.on(BotonesiOS.BTN_DONE)}).otherwise(new Performable[]{Tap.on(BotonesiOS.BTN_OK)})});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            GetDriver.as(actor).androidDriver().hideKeyboard();
        }

    }
}
