package bo.com.bga.certificacion.ganamovil.userinterfaces.acceso;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;


public class UiIniciarSesion {

    public static final Target TXT_CODIGO_DE_PERSONA = Target.the("Text Box Email")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeSecureTextField[@name='txtField'])[1]"));

    public static final Target BTN_INGRESAR = Target.the("Boton iniciar sesión")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Iniciar sesión']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnLogin']"));

    public static Target BTN_NO_PERMITIR_IOS = Target.the("Boton no permitir notificaciones")
            .locatedForAndroid(MobileBy.xpath(""))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='No permitir']"));


    public static final Target TXT_CLAVE_DE_PERSONA = Target.the("Text Box Email")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeSecureTextField[@name='txtField'])[2]"));

    public static final Target BTN_CERRAR_MODAL = Target.the("Boton modal")
            .locatedForAndroid(MobileBy.id("android:id/button2"))
            .locatedForIOS(MobileBy.id("android:id/button2"));

    public static final Target LBL_PERSONA = Target.the("Label persona")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[2]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblUsuarioNombre']"));

    public static final Target BTN_ACEPTAR_HABILITACION = Target.the("Boton modal aceptar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Aceptar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnPrimary']"));

    public static final Target BTN_MODAL_ENTENDIDO = Target.the("Boton modal entendido")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Entendido']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnPrimary']"));

    public static final Target LBL_MODAL_HABILITACION = Target.the("Label registro habilitación")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Registro Exitoso']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblTitle']"));

    public static final Target LBL_MODAL_DATOS_INVALIDOS = Target.the("Label datos invalidos")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[10]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblTitle']"));

    public static final Target LBL_NUMERO_CUENTA = Target.the("Label numero de cuenta")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[8]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblTipoNroCuenta']"));

    public static final Target LBL_SALDO_CUENTA = Target.the("Label numero de cuenta")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[5]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblSaldoDisponible']"));



}
