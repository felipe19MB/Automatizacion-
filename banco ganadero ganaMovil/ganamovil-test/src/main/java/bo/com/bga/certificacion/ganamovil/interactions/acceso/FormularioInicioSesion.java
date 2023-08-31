package bo.com.bga.certificacion.ganamovil.interactions.acceso;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.interactions.utils.TakeScreenshot;
import bo.com.bga.certificacion.ganamovil.models.UsuarioModel;
import bo.com.bga.certificacion.ganamovil.userinterfaces.acceso.UiIniciarSesion;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import java.util.logging.Logger;
public class FormularioInicioSesion implements Interaction {

    private UsuarioModel usuarioModel;

    public FormularioInicioSesion(UsuarioModel usuarioModel){
        this.usuarioModel = usuarioModel;
    }

    @Title("Se Diligencia el formulario de inicio de sesión")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.remember("usuario", usuarioModel.getUsuario());
            actor.attemptsTo(
                            WaitUntil.the(UiIniciarSesion.TXT_CODIGO_DE_PERSONA, WebElementStateMatchers.isVisible()).forNoMoreThan(40).seconds(),
                            Enter.theValue(usuarioModel.getUsuario()).into(UiIniciarSesion.TXT_CODIGO_DE_PERSONA),
                            WaitUntil.the(UiIniciarSesion.TXT_CLAVE_DE_PERSONA, WebElementStateMatchers.isVisible()).forNoMoreThan(40).seconds(),
                            Enter.theValue(usuarioModel.getContrasena()).into(UiIniciarSesion.TXT_CLAVE_DE_PERSONA),
                            WaitUntil.the(UiIniciarSesion.BTN_INGRESAR, WebElementStateMatchers.isVisible()).forNoMoreThan(40).seconds(),
                            TakeScreenshot.asEvidence(),
                            Tap.on(UiIniciarSesion.BTN_INGRESAR)
            );
            Logger.getAnonymousLogger().info("Formulario inicior sesión completado");
        }catch (RuntimeException ex){
            throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_INICIO_SESION), ex);
        }
    }

    public static FormularioInicioSesion go(UsuarioModel usuarioModel){
        return Instrumented.instanceOf(FormularioInicioSesion.class).withProperties(usuarioModel);
    }

}
