package bo.com.bga.certificacion.gananet.tasks.autorizaciones;

import bo.com.bga.certificacion.gananet.interactions.shared.IngresaClaveTransaccional;
import bo.com.bga.certificacion.gananet.interactions.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.interactions.shared.Utilidades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;

import static bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones.AutorizacionSolicitudPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudChequeraPage.MENSAJE_SOLICITUD_CREADA;

public class SupervisarSolicitud implements Task {


    String scenario;


    public SupervisarSolicitud(String scenario) {
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("chequera"):
               String numeroTransaccion= actor.recall("numeroTransaccion").toString();
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_OPCIONES.of(numeroTransaccion)),
                        JavaScriptClick.on(BOTON_APROBAR),
                        IngresaClaveTransaccional.paraConfirmarProceso()
                );
                String mensaje = actor.asksFor(Text.of(MENSAJE_SOLICITUD_CREADA));
                String mensajeCompro = Utilidades.removeNumericValues(mensaje);
                String mensajeComprobante = Utilidades.quitarUltimoEspacio(mensajeCompro);
                actor.remember("mensajeAutorizacion",mensajeComprobante);
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_OK)
                );
                break;
        }

    }
    public static SupervisarSolicitud go(String scenario){
        return Tasks.instrumented(SupervisarSolicitud.class,scenario);

    }

}
