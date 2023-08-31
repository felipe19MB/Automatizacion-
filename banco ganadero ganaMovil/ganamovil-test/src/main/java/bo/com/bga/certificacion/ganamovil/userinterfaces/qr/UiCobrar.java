package bo.com.bga.certificacion.ganamovil.userinterfaces.qr;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiCobrar {

    public static final Target BTN_COBRAR = Target.the("Boton cobrar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Cobrar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@name='btnLeft']"));

    public static final Target BTN_PAGAR = Target.the("Boton cobrar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Pagar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@name='btnMiddle']"));

    public static final Target BTN_CUENTA_ORIGEN = Target.the("Boton cuenta origen")
            .locatedForAndroid(MobileBy.xpath("(//android.view.ViewGroup[android.widget.TextView[@text='Cuenta que recibirá el pago']]//child::android.view.ViewGroup//child::android.widget.ImageView)[2]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeOther[@name='flexArrowDown'])[1]"));

    public static final Target ITEM_CUENTA_ANDROID = Target.the("Item cuenta")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target ITEM_CUENTA_IOS = Target.the("Item cuenta")
            .locatedBy("//XCUIElementTypeStaticText[@value='{0}']");

    public static final Target BTN_MONEDA = Target.the("Boton tipo de moneda")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target BTN_TIEMPO_DE_DURACION = Target.the("Boton tiempo de duración")
            .locatedForAndroid(MobileBy.xpath("(//android.view.ViewGroup[android.widget.TextView[@text='Tiempo de duración']]//child::android.view.ViewGroup//child::android.widget.ImageView)"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeOther[@name='flexArrowDown'])[2]"));

    public static final Target TXT_DESCRIPCION = Target.the("Input descripcion")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa una descripción']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@name='txtField']"));

    public static final Target CHECKBOX_USO = Target.the("Checkbox uso unico")
            .locatedForAndroid(MobileBy.xpath("(//android.view.ViewGroup)[35]"))
            .locatedForIOS(MobileBy.xpath(""));

    public static final Target BTN_GENERAR = Target.the("Boton generar QR")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Generar QR']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnPrimaryAction']"));

    public static final Target TXT_SALDO = Target.the("Saldo")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@name='txtAmount']"));

    public static final Target BTN_NOTIFICACION = Target.the("Notificación")
            .locatedForAndroid(MobileBy.id("com.android.permissioncontroller:id/permission_deny_button"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='No permitir']"));

    public static final Target LBL_QR = Target.the("QR Exitiso")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Empleado Banco']"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeStaticText[@name='lblUserName'])[1]"));

    public static final Target IMG_QR = Target.the("Imagen QR Exitiso")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.ImageView)[2]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeImage[@name='imgQR'])[1]"));

    public static final Target GRUPO_GISTORICO = Target.the("Imagen QR Exitiso")
            .locatedForAndroid(MobileBy.xpath("(//android.view.ViewGroup)[31]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@name=\"qrOrdenCobro0\"]"));















}
