package bo.com.bga.certificacion.ganamovil.userinterfaces.util;

import net.serenitybdd.screenplay.targets.Target;

public class TransversalUI {

    public static final Target LBL_TEXT_ANDROID = Target.the("Busca el texto \"{0}\" ")
            .locatedBy("//android.widget.TextView[contains(@text,'{0}')]");

    public static final Target LBL_TEXTO_IOS = Target.the("Busca el texto \"{0}\" ")
            .locatedBy("//XCUIElementTypeStaticText[contains(@name,'{0}')]");

}