package bo.com.bga.certificacion.gananet.tasks.pago_planillas;

import bo.com.bga.certificacion.gananet.models.pago_planillas.DatosHistoricoPagoPlanillas;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas.BOTON_BUSCAR;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class BuscarPlanilla implements Task {
    DatosHistoricoPagoPlanillas datosHistoricoPagoPlanillas;
    public BuscarPlanilla(DatosHistoricoPagoPlanillas datosHistoricoPagoPlanillas) {
        this.datosHistoricoPagoPlanillas = datosHistoricoPagoPlanillas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds(),
                byVisibleText(datosHistoricoPagoPlanillas.getConvenio()).from(SELECT_CONVENIO),
                Enter.theValue(datosHistoricoPagoPlanillas.getPeriodoDel()).into(FECHA_PERIODO_DEL),
                Enter.theValue(datosHistoricoPagoPlanillas.getPeriodoAl()).into(FECHA_PERIODO_AL),
                JavaScriptClick.on(BOTON_BUSCAR)

        );
    }
    public static BuscarPlanilla go(DatosHistoricoPagoPlanillas datosHistoricoPagoPlanillas){
        return Tasks.instrumented(BuscarPlanilla.class,datosHistoricoPagoPlanillas);
    }
}
