package bo.com.bga.certificacion.ganamovil.utils.utils;

import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.Dimension;

public class DeviceScreen {
    private final Dimension dim;

    public DeviceScreen(Actor actor) {
        this.dim = GetDriver.as(actor).appiumDriver().manage().window().getSize();
    }

    public static DeviceScreen as(Actor actor) {
        return new DeviceScreen(actor);
    }

    public int getWidth() {
        return this.dim.getWidth();
    }

    public int getHeight() {
        return this.dim.getHeight();
    }

    public int getMiddleHeight() {
        return this.dim.getHeight() / 2;
    }

    public int getMiddleWidth() {
        return this.dim.getWidth() / 2;
    }
}