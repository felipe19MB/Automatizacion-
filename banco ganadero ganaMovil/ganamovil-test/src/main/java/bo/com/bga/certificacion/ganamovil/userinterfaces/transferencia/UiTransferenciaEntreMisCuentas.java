package bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiTransferenciaEntreMisCuentas {

    /*
    Targets Modulo Entre mis cuentas
    */
    public static final Target BNT_CUENTA_ORIGEN = Target.the("Boton cuenta origen")
            .locatedForAndroid(MobileBy.xpath("//android.view.ViewGroup[android.widget.TextView[@text='Transferir desde']]//child::android.view.ViewGroup//child::android.widget.TextView"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeStaticText[@label='Transferir desde']//following::XCUIElementTypeOther//child::XCUIElementTypeOther[@name='flexArrowDown'])[1]"));

    public static final Target ITEM_CUENTA_ANDROID = Target.the("Item cuenta")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target ITEM_CUENTA_IOS = Target.the("Item cuenta")
            .locatedBy("//XCUIElementTypeStaticText[@value='{0}']");

    public static final Target BNT_CUENTA_DESTINO = Target.the("Boton cuenta destino")
            .locatedForAndroid(MobileBy.xpath("//android.view.ViewGroup[android.widget.TextView[@text='Enviar a']]//child::android.view.ViewGroup//child::android.widget.TextView"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@label='Enviar a']//following::XCUIElementTypeOther//child::XCUIElementTypeOther[@name='flexArrowDown']"));

    public static final Target TXT_DESCRIPCION = Target.the("Input descripcion")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Escribe una descripción']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@value='Escribe una descripción']"));

    public static final Target BTN_CONTINUAR = Target.the("Boton continuar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Continuar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnContinuar']"));

    public static final Target BTN_TRANSFERIR = Target.the("Boton transferir")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Transferir']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnConfirmar']"));

    public static final Target LBL_TRANSFERENCIA = Target.the("Label transferencia")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[2]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='lblTitle']"));

    public static final Target LBL_TRANSACCIÓN_MIS_CUENTAS = Target.the("Label transacción")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[12]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeStaticText)[10]"));

    public static final Target LBL_TRANSACCIÓN_ACH = Target.the("Label transacción")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[16]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeStaticText)[10]"));

    public static final Target LBL_TRANSACCIÓN = Target.the("Label transacción")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView)[12]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeStaticText)[10]"));

    public static final Target TXT_SALDO = Target.the("Input saldo")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@name='txtAmount']"));



}
