package bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrarSugerenciaPage {

    public static final Target INPUT_CORREO_SUGERENCIAS= Target.the("Campo para escribir el correo electrónico del cliente")
            .locatedBy("/html/body/app-root/app-paginas/div/div/app-sugerencias/control-contenedor-paginas/section/div/div/div/control-box/div/div[2]/form/div[1]/div/control-input-text/div/input");

    public static final Target INPUT_DESCRIPCION_SUGERENCIAS= Target.the("Campo para escribir la descripción de la sugerencia")
            .locatedBy("/html/body/app-root/app-paginas/div/div/app-sugerencias/control-contenedor-paginas/section/div/div/div/control-box/div/div[2]/form/div[2]/div/control-input-textarea/div/textarea");

    public static final Target MESSAGE_SUGERENCIAS= Target.the("Mensaje informativo antes de enviar la sugerencia")
            .locatedBy("/html/body/app-root/app-paginas/div/div/app-sugerencias/control-contenedor-paginas/section/div/div/div/control-box/div/div[2]/form/div[4]/div");
}
