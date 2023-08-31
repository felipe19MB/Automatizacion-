package bo.com.bga.certificacion.ganamovil.interactions.utils.tap;

import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TapByCoordinates implements Interaction {
    private final int x;
    private final int y;

    public TapByCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Step("{0} taps on coordinate (#x, #y)")
    public <T extends Actor> void performAs(T actor) {
        (new Actions(GetDriver.as(actor).appiumDriver())).click((WebElement)(new TapOptions()).withPosition((new PointOption()).withCoordinates(this.x, this.y))).perform();
    }
}
