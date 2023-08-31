package bo.com.bga.certificacion.gananet.tasks.comprobantes.servicios_basicos;

import bo.com.bga.certificacion.gananet.models.comprobantes.ServiciosBasicosModel;
import bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ServiciosBasicosPage;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
public class BuscarComprobante implements Task {
    ServiciosBasicosModel serviciosBasicosModel;
    private String escenario;
    public BuscarComprobante(ServiciosBasicosModel serviciosBasicosModel, String escenario) {
        this.serviciosBasicosModel = serviciosBasicosModel;
        this.escenario = escenario;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (escenario) {
            case "HappyPath":
                actor.attemptsTo(
                        WaitUntil.the(ServiciosBasicosPage.BOTON_CONSULTAR, isClickable()).forNoMoreThan(25).seconds(),
                        Enter.theValue(serviciosBasicosModel.getFechaDesde()).into(ServiciosBasicosPage.TXT_FECHA_DESDE),
                        Enter.theValue(serviciosBasicosModel.getFechaHasta()).into(ServiciosBasicosPage.TXT_FECHA_HASTA),
                        JavaScriptClick.on(ServiciosBasicosPage.BOTON_CONSULTAR)
                );
                break;
            default:
                break;
        }
        WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(10).seconds();
    }
    public static BuscarComprobante go(ServiciosBasicosModel serviciosBasicosModel, String escenario){
        return Tasks.instrumented(BuscarComprobante.class,serviciosBasicosModel, escenario);
    }
}
