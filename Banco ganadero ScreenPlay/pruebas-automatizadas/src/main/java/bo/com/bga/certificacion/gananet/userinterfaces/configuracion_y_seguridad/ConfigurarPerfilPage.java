package bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad;

import net.serenitybdd.screenplay.targets.Target;

public class ConfigurarPerfilPage {

    public static final Target LABEL_ALIAS = Target.the("el alias")
            .locatedBy("//label[contains(text(),'Tu alias')]/following-sibling::div/input");

    public static final Target LABEL_CORREO = Target.the("el correo")
            .locatedBy("//label[contains(text(),'Email registrado')]/following-sibling::input");

    public static final Target LABEL_NRO_PREFERIDO = Target.the("el numero preferido")
            .locatedBy("//label[contains(text(),'Nro. Preferido')]/following-sibling::input");


    public static final Target BOTON_BUSCAR = Target.the("el boton buscar")
            .locatedBy("//button[@class='btn btn-success']");

    public static final Target BOTON_CAMBIAR_IMAGEN = Target.the("el boton cambiar imagen")
            .locatedBy("//button[@class='btn btn-secondary btn-inline']");

    public static final Target IMAGEN = Target.the("la imagen del balon")
            .locatedBy("(//img[@class='pl-2 pr-2 pt-2 ng-star-inserted'])[11]");

    public static final Target BOTON_CAMBIAR_I = Target.the("el boton cambiar")
            .locatedBy("//button[normalize-space()='Cambiar']");

    public static final Target BOTON_ACTUALIZAR = Target.the("el boton actualizar")
            .locatedBy("(//button[@class='btn btn-info btn-inline pull-right mb-20 text-white'][normalize-space()='Actualizar'])[1]");

    public static final Target TEXTO_USUARIO_DISPONIBLE = Target.the("texto de usuario disponible")
            .locatedBy("div[class='form-group mb-20'] span");

}
