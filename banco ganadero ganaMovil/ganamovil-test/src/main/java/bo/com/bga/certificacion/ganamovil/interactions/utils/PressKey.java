package bo.com.bga.certificacion.ganamovil.interactions.utils;

import bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities;
import bo.com.bga.certificacion.ganamovil.utils.utils.GetDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class PressKey implements Interaction {
    public PressKey() {
    }

    public static PressKey enter() {
        return new PressKey();
    }

    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isAndroid(actor)) {
            GetDriver.as(actor).androidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        }

    }
}
