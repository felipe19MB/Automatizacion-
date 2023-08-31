package bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad;

import net.serenitybdd.screenplay.targets.Target;

public class ActualizacionDeDatosPage {

    public static final Target LABEL_DEPARTAMENTO = Target.the("el departamento")
            .locatedBy("//label[contains(text(),'Dpto/Prov/Est ')]/following-sibling::select");

    public static final Target LABEL_CIUDAD = Target.the("la ciudad")
            .locatedBy("//label[contains(text(),'Ciudad')]/following-sibling::select");

    public static final Target LABEL_ZONA = Target.the("la zona")
            .locatedBy("//label[contains(text(),'Zona')]/following-sibling::select");

    public static final Target LABEL_UV = Target.the("el UV")
            .locatedBy("//label[contains(text(),'UV')]/following-sibling::input");

    public static final Target LABEL_MZA = Target.the("el MZA")
            .locatedBy("//label[contains(text(),'MZA')]/following-sibling::input");

    public static final Target LABEL_BARRIO = Target.the("el barrio")
            .locatedBy("//label[contains(text(),'Barrio')]/following-sibling::input");

    public static final Target LABEL_CALLE = Target.the("la calle")
            .locatedBy("//label[contains(text(),'Calle/Avenida')]/following-sibling::input");

    public static final Target LABEL_NRO_PUERTA = Target.the("el numero de puerta")
            .locatedBy("//label[contains(text(),'Nro de puerta')]/following-sibling::input");

    public static final Target LABEL_PISO = Target.the("la calle")
            .locatedBy("//label[contains(text(),'Piso')]/following-sibling::input");

    public static final Target LABEL_APARTAMENTO = Target.the("el apartamento")
            .locatedBy("//label[contains(text(),'Apartamento')]/following-sibling::input");

    public static final Target LABEL_EMAIL = Target.the("el email")
            .locatedBy("//label[contains(text(),'Email')]/following-sibling::input");

    public static final Target LABEL_TELEFONO = Target.the("el telefono")
            .locatedBy("//label[contains(text(),'Teléfono Domicilio')]/following-sibling::input");

    public static final Target LABEL_CELULAR = Target.the("el celular")
            .locatedBy("//label[contains(text(),'Celular')]/following-sibling::input");

    public static final Target BOTON_CONTINUAR = Target.the("el boton continuar")
            .locatedBy("(//button[@type='button'][normalize-space()='Continuar'])[2]");

    public static final Target LABEL_DOMICILIO = Target.the("el domicilio")
            .locatedBy("//label[contains(text(),'Dirección preferida para correspondencia')]/following-sibling::select");

    public static final Target LABEL_REFERENCIA_1 = Target.the("los nombres y apellidos de la refencia 1")
            .locatedBy("(//label[contains(text(),'Nombre(s) y Apellido(s)')]/following-sibling::input)[1]");

    public static final Target LABEL_REFERENCIA_2 = Target.the("los nombres y apellidos de la refencia 2")
            .locatedBy("(//label[contains(text(),'Nombre(s) y Apellido(s)')]/following-sibling::input)[2]");

    public static final Target LABEL_TELEFONO_REFERENCIA_1 = Target.the("el telefono de la referencia 1")
            .locatedBy("(//label[contains(text(),'Teléfono')]/following-sibling::input)[1]");

    public static final Target LABEL_TELEFONO_REFERENCIA_2 = Target.the("el telefono de la referencia 2")
            .locatedBy("(//label[contains(text(),'Teléfono')]/following-sibling::input)[2]");

    public static final Target LABEL_RELACION_1 = Target.the("la relacion 1")
            .locatedBy("(//label[contains(text(),'Relación')]/following-sibling::select)[1]");

    public static final Target LABEL_RELACION_2 = Target.the("la relacion 2")
            .locatedBy("(//label[contains(text(),'Relación')]/following-sibling::select)[2]");

    public static final Target BOTON_CONFIRMAR = Target.the("el boton confimar")
            .locatedBy("//button[@type='button'][normalize-space()='Confirmar']");

    public static final Target MENSAJE_CAMBIO_DE_DATOS= Target.the("el mensaje de cambio dew datos exitoso")
            .locatedBy("//div[@id='swal2-content']");

    public static final Target BOTON_OK= Target.the("el boton ok")
            .locatedBy("//button[normalize-space()='OK']");
}
