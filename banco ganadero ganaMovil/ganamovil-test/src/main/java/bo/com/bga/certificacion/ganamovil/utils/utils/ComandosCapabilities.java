package bo.com.bga.certificacion.ganamovil.utils.utils;

import net.serenitybdd.screenplay.Actor;

public class ComandosCapabilities {
    private ComandosCapabilities() {
        throw new IllegalStateException("Error en ComandosCapabilities");
    }

    public static String getPlatformName(Actor actor) {
        return GetDriver.as(actor).appiumDriver().getCapabilities().getCapability("platformName").toString();
    }

    public static boolean isiOS(Actor actor) {
        return getPlatformName(actor).equals("IOS");
    }

    public static boolean isAndroid(Actor actor) {
        return getPlatformName(actor).equals("ANDROID");
    }
}
