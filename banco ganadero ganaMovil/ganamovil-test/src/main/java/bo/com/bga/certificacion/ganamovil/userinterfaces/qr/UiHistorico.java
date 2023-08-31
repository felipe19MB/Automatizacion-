package bo.com.bga.certificacion.ganamovil.userinterfaces.qr;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiHistorico {

    public static final Target BTN_HISTORICO = Target.the("Boton cobrar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Historial']"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeOther[@name=\"btnRight\"])[1]"));
}
