package bo.com.bga.certificacion.ganamovil.utils.utils.swipe;


import bo.com.bga.certificacion.ganamovil.utils.utils.DeviceScreen;
import net.serenitybdd.screenplay.Actor;

public class SwipeBuilderFrom {
    private final Actor actor;

    public SwipeBuilderFrom(Actor actor) {
        this.actor = actor;
    }

    public SwipeBuilderTo from(int inicialX, int inicialY) {
        return new SwipeBuilderTo(inicialX, inicialY, this.actor);
    }

    public SwipeBuilderTo fromRight() {
        return new SwipeBuilderTo(DeviceScreen.as(this.actor).getWidth() - 1, DeviceScreen.as(this.actor).getMiddleHeight(), this.actor);
    }

    public SwipeBuilderTo fromLeft() {
        return new SwipeBuilderTo(DeviceScreen.as(this.actor).getMiddleWidth(), DeviceScreen.as(this.actor).getMiddleHeight(), this.actor);
    }

    public SwipeBuilderTo fromTop() {
        return new SwipeBuilderTo(DeviceScreen.as(this.actor).getMiddleWidth(), DeviceScreen.as(this.actor).getMiddleHeight(), this.actor);
    }

    public SwipeBuilderTo fromBottom() {
        return new SwipeBuilderTo(DeviceScreen.as(this.actor).getMiddleWidth(), DeviceScreen.as(this.actor).getMiddleHeight(), this.actor);
    }
}