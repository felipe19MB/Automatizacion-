package bo.com.bga.certificacion.gananet.tasks.chequeras.solicitud_porta_chequera;


import bo.com.bga.certificacion.gananet.models.chequeras.SolicitudPortaChequeraModel;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.UUID;

import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudChequeraPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudPortaChequeraPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.transferencias.TransferenciasPage.CUENTA_ORIGEN;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SolicitarPortaChequera implements Task {

    SolicitudPortaChequeraModel solicitudPortaChequeraModel;
    String scenario;


    public SolicitarPortaChequera(SolicitudPortaChequeraModel solicitudPortaChequeraModel, String scenario) {
        this.solicitudPortaChequeraModel = solicitudPortaChequeraModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
                actor.attemptsTo(
                        WaitUntil.the(CUENTA_ORIGEN.of(solicitudPortaChequeraModel.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                        JavaScriptClick.on(CUENTA_ORIGEN.of(solicitudPortaChequeraModel.getCuentaOrigen())),
                        byVisibleText(solicitudPortaChequeraModel.getTipoPortaChequera()).from(TIPO_PORTA_CHEQUERA),
                        JavaScriptClick.on(BOTON_SIGUIENTE),
                        JavaScriptClick.on(HomePage.NEXT_BUTTONS.of("Atrás"))
                );
                actor.remember("COSTO_PORTA_CHEQUERA",actor.asksFor(Text.of(COSTO_PORTA_CHEQUERA)));
                actor.remember("IMPORTE_A_DEBITAR",actor.asksFor(Text.of(IMPORTE_A_DEBITAR_PORTA_CHEQUERA)));
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_SIGUIENTE),
                        WaitUntil.the(COMENTARIOS_PORTA_CHEQUERA, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        byVisibleText(solicitudPortaChequeraModel.getTipoRetiro()).from(TIPO_RETIRO_PORTA_CHEQUERA),
                        byVisibleText(solicitudPortaChequeraModel.getOficinaEntrega()).from(OFICINA_ENTREGA_PORTA_CHEQUERA),
                        Enter.theValue(solicitudPortaChequeraModel.getComentarios()+uuid.substring(0, 6)).into(COMENTARIOS_PORTA_CHEQUERA),
                        JavaScriptClick.on(BOTON_FINALIZAR),
                        IngresaGanaPin.paraConfirmarTransaccion()
                        );
                actor.remember("COMENTARIO PORTA CHEQUERA",solicitudPortaChequeraModel.getComentarios()+uuid.substring(0, 6));
                String comprobante = BrowseTheWeb.as(actor).findFirst(ID_COMPROBANTE_PORTA_CHEQUERA.getCssOrXPathSelector()).get().getAttribute("innerText").substring(3);
                actor.remember("ID COMPROBANTE", comprobante);
                actor.remember("FECHA COMPROBANTE", Text.of(FECHA_COMPROBANTE_PORTA_CHEQUERA).answeredBy(actor));
                actor.remember("HORA COMPROBANTE", Text.of(HORA_COMPROBANTE_PORTA_CHEQUERA).answeredBy(actor));
                break;
        }


    }
    public static SolicitarPortaChequera go(SolicitudPortaChequeraModel solicitudPortaChequeraModel, String scenario){
        return Tasks.instrumented(SolicitarPortaChequera.class,solicitudPortaChequeraModel,scenario);

    }
}
