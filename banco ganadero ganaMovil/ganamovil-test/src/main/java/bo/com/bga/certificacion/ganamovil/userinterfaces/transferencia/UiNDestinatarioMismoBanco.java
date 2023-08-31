package bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiNDestinatarioMismoBanco {

    public static final Target BTN_SELECCIONA_INSTITUCION = Target.the("Boton selecciona institucion")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Selecciona una institución']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@name='flexArrowDown']"));

    public static final Target BTN_ITEM_INSTITUCION = Target.the("Item institucion")
            .locatedBy("//android.widget.TextView[@text='{0}']");

    public static final Target BTN_ITEM_INSTITUCION_IOS = Target.the("Item institucion iOS")
            .locatedBy("//XCUIElementTypeStaticText[@label='{0}']");

    public static final Target TXT_NUMERO_CUENTA = Target.the("Input numero de cuenta")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa el número de cuenta']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@value='Ingresa el número de cuenta']"));

    public static final Target TXT_NOMBRE_TITULAR = Target.the("Input Nombre del titular")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa el nombre del titular']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@value='Ingresa el nombre del titular']"));

    public static final Target TXT_NOMBRE_CONTACTO = Target.the("Input Nombre del contacto")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa el nombre del contacto']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@value='Ingresa el nombre del contacto']"));

    public static final Target TXT_NOMBRE_CONTACTO_BUG = Target.the("Input Nombre del contacto")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[3]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeTextField[@name='txtField'])[3]"));

    public static final Target BTN_BUSCAR= Target.the("Botton buscar")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Buscar']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='Buscar']"));
    public static final Target BTN_GUARDAR_CONTACTO = Target.the("Botton guardar contacto")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Guardar contacto']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnGuardar']"));
    public static final Target BTN_TRANSFERIR= Target.the("Botton transferir")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Transferir']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeButton[@name='btnPrimary']"));
    public static final Target BTN_OK_DESTINATARIO = Target.the("Boton listo")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.ImageView)[5]"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@name='flexDone']"));
    public static final Target TXT_REFERENCIA = Target.the("Input referencia")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa la referencia']"))
            .locatedForIOS(MobileBy.xpath(""));

    public static final Target TXT_NUMERO_TELEFONO = Target.the("Input numero de telefono")
            .locatedForAndroid(MobileBy.xpath("//android.widget.EditText[@text='Ingresa el número de telefono']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextField[@value='Ingresa el número de telefono']"));

    public static final Target BTN_SUCURSAL = Target.the("Boton selecciona una sucursal")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Selecciona una sucursal']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@value='Selecciona una sucursal']"));

    public static final Target BTN_TIPO_CUENTA = Target.the("Boton tipo de cuenta")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Selecciona un tipo de cuenta']"))
            .locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@value='Selecciona un tipo de cuenta']"));
    public static final Target TXT_INSTITUCIÓN = Target.the("Input institución")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[4]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeTextField[@name='txtField'])[4]"));

    public static final Target IMG_BUSCAR= Target.the("Boton buscar")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.ImageView)[4]"))
            .locatedForIOS(MobileBy.xpath("(//XCUIElementTypeTextField[@name='txtField'])[4]"));



}
