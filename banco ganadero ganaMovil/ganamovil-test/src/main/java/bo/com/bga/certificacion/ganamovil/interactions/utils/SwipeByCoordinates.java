package bo.com.bga.certificacion.ganamovil.interactions.utils;

import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class SwipeByCoordinates implements Interaction {
    private final int inicialX;
    private final int inicialY;
    private final int endX;
    private final int endY;

    public SwipeByCoordinates(int inicialX, int inicialY, int endX, int endY) {
        this.inicialX = inicialX;
        this.inicialY = inicialY;
        this.endX = endX;
        this.endY = endY;
    }

    @Step("{0} swiped from (#inicialX, #inicialY) to (#endX, #endY)")
    public <T extends Actor> void performAs(T actor) {
        (new TouchAction((PerformsTouchActions) GetDriver.as(actor).appiumDriver())).longPress((new PointOption()).withCoordinates(this.inicialX, this.inicialY)).moveTo((new PointOption()).withCoordinates(this.endX, this.endY)).release().perform();
    }
}
