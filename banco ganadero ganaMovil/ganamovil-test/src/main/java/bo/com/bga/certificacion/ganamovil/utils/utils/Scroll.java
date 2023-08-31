package bo.com.bga.certificacion.ganamovil.utils.utils;

import bo.com.bga.certificacion.ganamovil.interactions.utils.scroll.ScrollElement;
import bo.com.bga.certificacion.ganamovil.interactions.utils.scroll.ScrollTarget;
import bo.com.bga.certificacion.ganamovil.interactions.utils.scroll.ScrollText;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Scroll {
    private Scroll() {
        throw new IllegalStateException("Error en Scroll");
    }

    public static ScrollTarget on(Target target) {
        return (ScrollTarget) Tasks.instrumented(ScrollTarget.class, new Object[]{target});
    }

    public static ScrollElement on(WebElement element) {
        return (ScrollElement)Tasks.instrumented(ScrollElement.class, new Object[]{element});
    }

    public static ScrollText on(String selector, String text) {
        return (ScrollText)Tasks.instrumented(ScrollText.class, new Object[]{selector, text});
    }
}
