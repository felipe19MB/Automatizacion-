package bo.com.bga.certificacion.ganamovil.utils.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.WebElement;

public class EncuentraElElemento {
    Actor actor;

    private EncuentraElElemento() {
        throw new IllegalStateException("Error en EncuentraElElemento");
    }

    public EncuentraElElemento(Actor actor) {
        this.actor = actor;
    }

    public static EncuentraElElemento as(Actor actor) {
        return new EncuentraElElemento(actor);
    }

    public WebElement conTextoEnAndroid(String selector, String atributo) {
        return GetDriver.as(this.actor).androidDriver().findElement(AppiumBy.androidUIAutomator(String.format(selector, atributo)));
    }

    public WebElement conTextoEniOS(String atributo) {
        IOSDriver var10000 = GetDriver.as(this.actor).iosDriver();
        Object[] var10002 = new Object[]{atributo};
        return var10000.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' && " + String.format("value CONTAINS '%s'", var10002)));
    }
}
