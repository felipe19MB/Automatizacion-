package bo.com.bga.certificacion.ganamovil.userinterfaces.util;


import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class BotonesiOS {

    public static final Target BTN_DONE = Target.the("Botón Done teclado")
            .located(MobileBy.id("Done"));

    public static final Target BTN_OK = Target.the("Botón OK teclado")
            .located(MobileBy.id("OK"));

    private BotonesiOS() {
        throw new IllegalStateException("Error en BotonesiOS");
    }

}