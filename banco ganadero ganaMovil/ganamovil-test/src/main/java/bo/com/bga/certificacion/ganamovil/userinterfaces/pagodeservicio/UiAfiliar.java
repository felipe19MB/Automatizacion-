package bo.com.bga.certificacion.ganamovil.userinterfaces.pagodeservicio;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiAfiliar {

    public static final Target BTN_AFILIAR = Target.the("Boton afiliar")
            .locatedBy("//android.widget.TextView[@text='{0}']");
    public static final Target BTN_AFILIAR_IOS = Target.the("Boton menu ios")
            .locatedBy("//XCUIElementTypeStaticText[@label = '{0}']");
    public static final Target BTN_MENU = Target.the("Boton menu")
            .locatedBy("//android.widget.TextView[@text='{0}']");
    public static final Target BTN_MENU_IOS = Target.the("Boton menu ios")
            .locatedBy("//XCUIElementTypeStaticText[@label = '{0}']");
    public static final Target BTN_TIPO = Target.the("item tipo")
            .locatedBy("//android.widget.TextView[@text='{0}']");
    public static final Target BTN_TIPO_IOS = Target.the("item tipo")
            .locatedBy("//XCUIElementTypeStaticText[@label = '{0}']");
    public static final Target BTN_CODIGO = Target.the("Boton codigo")
            .locatedForAndroid(MobileBy.xpath("//android.view.ViewGroup[android.widget.TextView[@text='Identificador de Código']]//child::android.view.ViewGroup//child::android.widget.TextView"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@label='Identificador de Código']//following::XCUIElementTypeOther//child::XCUIElementTypeOther//child::XCUIElementTypeImage"));

    public static final Target TXT_CUENTA = Target.the("Input cuenta")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa Cuenta']"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeTextField[@name='txtCriterio'])[1]"));
    public static final Target TXT_REFERENCIA = Target.the("Input referencia")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa la Referencia']"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeTextField[@name='txtCriterio'])[2]"));
    public static final Target BTN_BUSCAR = Target.the("Boton buscar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Buscar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnAgregar']"));
    public static final Target BTN_GUARDAR = Target.the("Boton guardar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Guardar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnAgregar']"));
    public static final Target LBL_ALERTA_RESPONSE = Target.the("Boton guardar")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[12]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeScrollView[@name='lblDescription']"));







}
