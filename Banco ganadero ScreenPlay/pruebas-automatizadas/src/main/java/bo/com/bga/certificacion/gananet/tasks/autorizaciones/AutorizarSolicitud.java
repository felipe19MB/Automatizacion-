package bo.com.bga.certificacion.gananet.tasks.autorizaciones;

import bo.com.bga.certificacion.gananet.interactions.shared.IngresaGanaPin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;

import static bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones.AutorizacionSolicitudPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudChequeraPage.MENSAJE_SOLICITUD_CREADA;

public class AutorizarSolicitud implements Task {


    String scenario;


    public AutorizarSolicitud(String scenario) {
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
                        IngresaGanaPin.paraConfirmarProceso()

                );
                String mensaje = actor.asksFor(Text.of(MENSAJE_SOLICITUD_CREADA));
                System.out.println(mensaje);
                actor.remember("mensajeAutorizacion",mensaje);
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_OK)
                );
                break;
        }

    }
    public static AutorizarSolicitud go(String scenario){
        return Tasks.instrumented(AutorizarSolicitud.class,scenario);

    }

}
