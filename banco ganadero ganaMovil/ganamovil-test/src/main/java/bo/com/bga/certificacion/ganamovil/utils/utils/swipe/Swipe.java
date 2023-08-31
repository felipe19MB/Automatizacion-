package bo.com.bga.certificacion.ganamovil.utils.utils.swipe;

import net.serenitybdd.screenplay.Actor;

public class Swipe {
    private Swipe() {
        throw new IllegalStateException("Error en Swipe");
    }

    public static SwipeBuilderFrom as(Actor actor) {
        return new SwipeBuilderFrom(actor);
    }
}
