package bo.com.bga.certificacion.ganamovil.utils.utils.swipe;

import bo.com.bga.certificacion.ganamovil.interactions.utils.SwipeByCoordinates;
import bo.com.bga.certificacion.ganamovil.utils.utils.DeviceScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;

public class SwipeBuilderTo {
    private final int inicialX;
    private final int inicialY;
    private final Actor actor;

    public SwipeBuilderTo(int inicialX, int inicialY, Actor actor) {
        this.inicialX = inicialX;
        this.inicialY = inicialY;
        this.actor = actor;
    }

    public SwipeByCoordinates to(int endX, int endY) {
        return (SwipeByCoordinates) Tasks.instrumented(SwipeByCoordinates.class, new Object[]{this.inicialX, this.inicialY, endX, endY});
    }

    public SwipeByCoordinates toLeft() {
        return (SwipeByCoordinates)Tasks.instrumented(SwipeByCoordinates.class, new Object[]{this.inicialX, this.inicialY, 1, DeviceScreen.as(this.actor).getMiddleHeight()});
    }

    public SwipeByCoordinates toRight() {
        return (SwipeByCoordinates)Tasks.instrumented(SwipeByCoordinates.class, new Object[]{this.inicialX, this.inicialY, DeviceScreen.as(this.actor).getWidth() - 1, DeviceScreen.as(this.actor).getMiddleHeight()});
    }

    public SwipeByCoordinates toBottom() {
        return (SwipeByCoordinates)Tasks.instrumented(SwipeByCoordinates.class, new Object[]{this.inicialX, this.inicialY, DeviceScreen.as(this.actor).getMiddleWidth(), DeviceScreen.as(this.actor).getHeight() - 1});
    }

    public SwipeByCoordinates toTop() {
        return (SwipeByCoordinates)Tasks.instrumented(SwipeByCoordinates.class, new Object[]{this.inicialX, this.inicialY, DeviceScreen.as(this.actor).getMiddleWidth(), 1});
    }
}

