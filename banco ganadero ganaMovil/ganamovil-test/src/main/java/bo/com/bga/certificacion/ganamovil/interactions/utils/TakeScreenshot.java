package bo.com.bga.certificacion.ganamovil.interactions.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class TakeScreenshot implements Interaction {

    public TakeScreenshot() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.takeScreenshot();
    }

    public static TakeScreenshot asEvidence() {
        return (TakeScreenshot) Tasks.instrumented(TakeScreenshot.class, new Object[0]);
    }
}
