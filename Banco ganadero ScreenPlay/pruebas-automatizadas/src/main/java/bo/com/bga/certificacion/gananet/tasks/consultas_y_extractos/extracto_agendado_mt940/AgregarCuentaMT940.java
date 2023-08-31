package bo.com.bga.certificacion.gananet.tasks.consultas_y_extractos.extracto_agendado_mt940;

import bo.com.bga.certificacion.gananet.interactions.shared.IngresaClaveTransaccional;
import bo.com.bga.certificacion.gananet.interactions.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.ExtractoAgendadoMT940Model;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.OrdenDeCobroModel;
import bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.ExtractoAgendadoMT940Page;
import bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.GenerarExtractosPage;
import bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.OrdenDeCobroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;

import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudChequeraPage.MENSAJE_SOLICITUD_CREADA;
import static bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.ExtractoAgendadoMT940Page.MENSAJE_CUENTA_CREADA;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class AgregarCuentaMT940 implements Task {

    String scenario;
    ExtractoAgendadoMT940Model extractoAgendadoMT940Model;

    public AgregarCuentaMT940(ExtractoAgendadoMT940Model extractoAgendadoMT940Model,String scenario) {
        this.scenario = scenario;
        this.extractoAgendadoMT940Model = extractoAgendadoMT940Model;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        JavaScriptClick.on(ExtractoAgendadoMT940Page.BOTON_AGREGAR_CUEENTA),
                        byVisibleText(extractoAgendadoMT940Model.getNroCuenta()).from(ExtractoAgendadoMT940Page.NUMERO_DE_CUENTA),
                        Enter.theValue(extractoAgendadoMT940Model.getBanco()).into(ExtractoAgendadoMT940Page.BANCO),
                        JavaScriptClick.on(ExtractoAgendadoMT940Page.CODIGO_SWIFT.of(extractoAgendadoMT940Model.getCodigoSwift())),
                        JavaScriptClick.on(ExtractoAgendadoMT940Page.BOTON_GUARDAR),
                        IngresaGanaPin.paraConfirmarProceso()


                );
                String mensajeCuentaAgregada = actor.asksFor(Text.of(MENSAJE_CUENTA_CREADA));
                actor.remember("mensajeCuentaCreada",mensajeCuentaAgregada);


                break;
        }

    }
    public static AgregarCuentaMT940 go(ExtractoAgendadoMT940Model extractoAgendadoMT940Model, String scenario){
        return Tasks.instrumented(AgregarCuentaMT940.class,extractoAgendadoMT940Model,scenario);

    }

}
