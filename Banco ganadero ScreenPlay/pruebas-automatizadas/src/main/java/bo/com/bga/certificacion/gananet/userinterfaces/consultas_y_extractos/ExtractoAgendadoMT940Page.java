package bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos;

import net.serenitybdd.screenplay.targets.Target;

public class ExtractoAgendadoMT940Page {

    public static final Target BOTON_AGREGAR_CUEENTA= Target.the("agregar nueva cuenta MT940")
            .locatedBy("//strong[contains(text(),'Agregar Cuenta MT940 +')]");

    public static final Target NUMERO_DE_CUENTA= Target.the("el numero de cuenta")
            .locatedBy("//label[contains(text(),'Nro. de Cuenta ')]/following-sibling::select");

    public static final Target BANCO= Target.the("el banco")
            .locatedBy("//label[contains(text(),'Seleccionar Codigo Swift')]/following-sibling::div/input");

    public static final Target CODIGO_SWIFT= Target.the("el codigo swift")
            .locatedBy("//div[normalize-space()='{0}']");

    public static final Target BOTON_GUARDAR= Target.the("el boton guardar")
            .locatedBy("//button[normalize-space()='Guardar']");
    public static final Target MENSAJE_CUENTA_CREADA= Target.the("el mensaje de solicitud creada")
            .locatedBy("//div[@id='swal2-content']");


}
