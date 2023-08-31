package bo.com.bga.certificacion.ganamovil.userinterfaces.shared;

import net.serenitybdd.screenplay.targets.Target;

public class UiMenu {

    public static final Target BTN_MENU_ANDROID = Target.the("Boton menu android")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target BTN_SUBMENU_ANDROID = Target.the("Boton sub menu android")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target BTN_MENU_IOS = Target.the("Boton menu ios")
            .locatedBy("//XCUIElementTypeStaticText[@label = '{0}']");

    public static final Target BTN_SUBMENU_IOS = Target.the("Boton sub menu ios")
            .locatedBy("//XCUIElementTypeOther[XCUIElementTypeStaticText[@value='{0}']]//following::XCUIElementTypeOther");

}
