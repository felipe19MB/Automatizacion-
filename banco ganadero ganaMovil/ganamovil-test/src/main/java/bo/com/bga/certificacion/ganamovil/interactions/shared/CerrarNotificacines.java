package bo.com.bga.certificacion.ganamovil.interactions.shared;

import bo.com.bga.certificacion.ganamovil.userinterfaces.acceso.UiIniciarSesion;
import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Title;

import java.util.logging.Logger;

import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class CerrarNotificacines implements Interaction {

    @Title("Se cierra la notificación")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            if (isiOS(actor)){
                do {
                    if (UiIniciarSesion.BTN_NO_PERMITIR_IOS.resolveFor(actor).isVisible()) {
                        actor.attemptsTo(Tap.on(UiIniciarSesion.BTN_NO_PERMITIR_IOS));
                        Logger.getAnonymousLogger().info("Modal cerrado");
                        break;
                    } else {
                        break;
                    }
                } while (!UiIniciarSesion.BTN_NO_PERMITIR_IOS.resolveFor(actor).isVisible());
            }
        }catch (RuntimeException ex){
            throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_CERRARMODAL), ex);
        }
    }

    public static CerrarNotificacines iOS() {
        return Instrumented.instanceOf(CerrarNotificacines.class).withProperties();
    }
}
