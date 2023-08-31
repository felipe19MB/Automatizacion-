package bo.com.bga.certificacion.gananet.tasks.pago_planillas;

import bo.com.bga.certificacion.gananet.models.pago_planillas.ConsultaACHyChequesModel;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ACHyChequesPage;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ACHyChequesPage.SCROLL_BAJAR;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class LlenarInformacionACHyCheques implements Task {
    ConsultaACHyChequesModel consultaACHyChequesModel;

    public LlenarInformacionACHyCheques(ConsultaACHyChequesModel consultaACHyChequesModel) {
        this.consultaACHyChequesModel = consultaACHyChequesModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                byVisibleText(consultaACHyChequesModel.getServicio()).from(ACHyChequesPage.SELECT_SERVICIO),
                byVisibleText(consultaACHyChequesModel.getTipoDeReporte()).from(ACHyChequesPage.SELECT_TIPO_REPORTE),
                JavaScriptClick.on(ACHyChequesPage.CHECKBOX_BUSCAR_POR.of(consultaACHyChequesModel.getBusqueda())),
                Enter.theValue(consultaACHyChequesModel.getNumeroPlanilla()).into(ACHyChequesPage.TXT_PLANILLA),
                JavaScriptClick.on(ACHyChequesPage.BOTON_BUSCAR),
                WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(SCROLL_BAJAR)


        );

    }
    public static LlenarInformacionACHyCheques go(ConsultaACHyChequesModel consultaACHyChequesModel){
        return Tasks.instrumented(LlenarInformacionACHyCheques.class, consultaACHyChequesModel);

    }

}
