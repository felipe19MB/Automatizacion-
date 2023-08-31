package bo.com.bga.certificacion.ganamovil.utils.utils;

import bo.com.bga.certificacion.ganamovil.interactions.utils.tap.TapByCoordinates;
import bo.com.bga.certificacion.ganamovil.interactions.utils.tap.TapByElement;
import bo.com.bga.certificacion.ganamovil.interactions.utils.tap.TapByTarget;
import bo.com.bga.certificacion.ganamovil.interactions.utils.tap.TapOnVisibleObject;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Tap {
    private Tap() {
        throw new IllegalStateException("Error en Tap");
    }

    public static TapByTarget on(Target target) {
        return (TapByTarget) Tasks.instrumented(TapByTarget.class, new Object[]{target});
    }

    public static TapByCoordinates on(int x, int y) {
        return (TapByCoordinates)Tasks.instrumented(TapByCoordinates.class, new Object[]{x, y});
    }

    public static TapByElement on(WebElement element) {
        return (TapByElement)Tasks.instrumented(TapByElement.class, new Object[]{element});
    }

    public static TapOnVisibleObject siElElementoEsVisible(Target target) {
        return (TapOnVisibleObject)Tasks.instrumented(TapOnVisibleObject.class, new Object[]{target});
    }
}
