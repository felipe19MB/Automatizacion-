package bo.com.bga.certificacion.gananet.tasks.chequeras.solicitud_chequera;

import bo.com.bga.certificacion.gananet.interactions.shared.Utilidades;
import bo.com.bga.certificacion.gananet.interactions.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.models.chequeras.SolicitudChequeraModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudChequeraPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_SOLICITUD_CHEQUERA;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LlenarSolicitudChequera implements Task {
    SolicitudChequeraModel solicitudChequeraModel;

    String scenario;


    public LlenarSolicitudChequera(SolicitudChequeraModel solicitudChequeraModel, String scenario) {
        this.solicitudChequeraModel = solicitudChequeraModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds(),
                        JavaScriptClick.on(CHECK_BOX_CUENta_ORIGEN.of(solicitudChequeraModel.getCuentaOrigen())),
                        byVisibleText(solicitudChequeraModel.getFormato()).from(LABEL_FORMATO),
                        Enter.theValue(solicitudChequeraModel.getCantidadTalonarios()).into(CANTIDAD_TALONARIO),
                        byVisibleText(solicitudChequeraModel.getSello()).from(SELLO_INTRANSFERIBLE),
                        byVisibleText(solicitudChequeraModel.getPortaChequera()).from(PORTA_CHEQUERA),
                        byVisibleText(solicitudChequeraModel.getTalonario()).from(TALONARIO_DE),
                        JavaScriptClick.on(BOTON_SIGUIENTE),
                        byVisibleText(solicitudChequeraModel.getRetiroChequera()).from(RETIRO_CHEQUERA),
                        byVisibleText(solicitudChequeraModel.getOficinaEntrega()).from(OFICINA_ENTREGA),
                        JavaScriptClick.on(BOTON_FINALIZAR),
                        IngresaGanaPin.paraConfirmarProceso()
                        );

                String mensaje = actor.asksFor(Text.of(MENSAJE_SOLICITUD_CREADA));
                String mensajeComprobante= Utilidades.removeNumericValues(mensaje);
                Integer numeroTransaccion = Utilidades.extraerNumero(mensaje);
                actor.remember("numeroTransaccion",numeroTransaccion);
                actor.remember("mensajeComprobante",mensajeComprobante);
                actor.attemptsTo(
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_SOLICITUD_CHEQUERA+numeroTransaccion,"resultadoBDSolicitudChequera","GANADERO"),
                        WaitUntil.the(BOTON_ACEPTAR, isVisible()).forNoMoreThan(60).seconds(),
                        JavaScriptClick.on(BOTON_ACEPTAR)
                );
                break;
        }


    }
    public static LlenarSolicitudChequera go(SolicitudChequeraModel solicitudChequeraModel, String scenario){
        return Tasks.instrumented(LlenarSolicitudChequera.class,solicitudChequeraModel,scenario);

    }

}
