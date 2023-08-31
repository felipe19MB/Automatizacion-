package bo.com.bga.certificacion.gananet.tasks.transferencias.historico;


import bo.com.bga.certificacion.gananet.models.transferencias.DatosHistoricos;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.HistoricoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.transferencias.HistoricoPage.*;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class LlenarHistoricoCuentasPropias implements Task {
    DatosHistoricos datosHistoricos;
    String scenario;

    public LlenarHistoricoCuentasPropias(String scenario,DatosHistoricos datosHistoricos) {
        this.datosHistoricos = datosHistoricos;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        Scroll.to(HistoricoPage.TIPO_CUENTA_HISTORICO.of(datosHistoricos.getSubFuncionalidad())),
                        JavaScriptClick.on(HistoricoPage.TIPO_CUENTA_HISTORICO.of(datosHistoricos.getSubFuncionalidad())),
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds(),
                        byVisibleText(datosHistoricos.getCuentaPropia()).from(TXT_CUENTAS_PROPIAS),
                        byVisibleText(datosHistoricos.getEstadoTransferencia()).from(TXT_ESTADO_TRANFERENCIA),
                        Enter.theValue(datosHistoricos.getDesde()).into(FECHA_DESDE),
                        Enter.theValue(datosHistoricos.getHasta()).into(FECHA_HASTA),
                        JavaScriptClick.on(BOTON_GENERAR_HISTORICO),
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds()

                );
                break;
        }
    }

    public static LlenarHistoricoCuentasPropias go(String scenario, DatosHistoricos datosHistoricos){
        return Tasks.instrumented(LlenarHistoricoCuentasPropias.class,scenario,datosHistoricos);

    }



}
