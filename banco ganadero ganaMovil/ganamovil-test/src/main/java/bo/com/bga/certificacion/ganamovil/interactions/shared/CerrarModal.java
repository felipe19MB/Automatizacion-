package bo.com.bga.certificacion.ganamovil.interactions.shared;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Title;
import java.util.logging.Logger;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.acceso.UiIniciarSesion.BTN_CERRAR_MODAL;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class CerrarModal implements Interaction {

    @Title("Se cierra el modal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            if (!isiOS(actor)){
                do {
                    if (BTN_CERRAR_MODAL.resolveFor(actor).isVisible()){

                        actor.attemptsTo(
                                Click.on(BTN_CERRAR_MODAL)
                        );
                        Logger.getAnonymousLogger().info("Modal cerrado");
                        break;
                    }else{
                        break;
                    }
                }while (!BTN_CERRAR_MODAL.resolveFor(actor).isVisible());
            }
        }catch (RuntimeException ex){
            throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_CERRARMODAL), ex);
        }
    }

    public static CerrarModal go(){
        return Instrumented.instanceOf(CerrarModal.class).withProperties();
    }

}
