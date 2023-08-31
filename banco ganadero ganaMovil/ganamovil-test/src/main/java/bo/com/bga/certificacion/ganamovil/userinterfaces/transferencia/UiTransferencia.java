package bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiTransferencia {

    public static final Target TXT_BUSCAR_CONTACTO = Target.the("Input buscar contacto")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@name='txtField']"));

    public static final Target BTN_CONTACTO = Target.the("Botton contacto")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target BTN_CONTACTO_YOLO = Target.the("Botton contacto")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='PERSONA NATURAL']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@value='PERSONA NATURAL']"));

    public static final Target BTN_CONTACTO_IOS = Target.the("Botton contacto iOS")
            .locatedBy("//XCUIElementTypeStaticText[@value='{0}']");

    public static final Target BNT_CUENTA_ORIGEN_OTROS_BANCOS = Target.the("Boton cuenta origen")
            .locatedForAndroid(MobileBy.xpath("//android.view.ViewGroup[android.widget.TextView[@text='Transferir desde']]//child::android.view.ViewGroup//child::android.widget.TextView"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@label='Transferir desde']//following::XCUIElementTypeOther//child::XCUIElementTypeOther[@name='flexArrowDown']"));

    public static final Target ITEM_CUENTA_ANDROID_OTROS_BANCOS = Target.the("Item cuenta")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target ITEM_CUENTA_IOS_OTROS_BANCOS = Target.the("Item cuenta")
            .locatedBy("//XCUIElementTypeStaticText[@value='{0}']");

    public static final Target TXT_DESCRIPCION_OTROS_BANCOS = Target.the("Input descripcion")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Escribe una descripción']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@value='Escribe una descripción']"));

    public static final Target BTN_TRANSFERIR_OTROS_BANCOS = Target.the("Boton transferir")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Transferir']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnConfirmar']"));


    public static final Target BTN_CONTINUAR_OTROS_BANCOS = Target.the("Boton continuar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Continuar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnContinuar']"));

    public static final Target IMG_BUSCAR = Target.the("Boton buscar")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.ImageView)[7]"))
            .locatedForIOS(MobileBy.xpath("(//android.widget.ImageView)[6]"));

    public static final Target LBL_TRANSFERENCIA_OTROS_BANCOS = Target.the("Label transferencia")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[2]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblTitle']"));


}
