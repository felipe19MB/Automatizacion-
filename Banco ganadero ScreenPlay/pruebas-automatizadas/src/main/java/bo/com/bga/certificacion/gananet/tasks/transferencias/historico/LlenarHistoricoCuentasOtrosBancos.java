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


public class LlenarHistoricoCuentasOtrosBancos implements Task {
    DatosHistoricos datosHistoricos;
    String scenario;

    public LlenarHistoricoCuentasOtrosBancos(String scenario,DatosHistoricos datosHistoricos) {
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
                        byVisibleText(datosHistoricos.getBancoDestino()).from(TXT_BANCO_DESTINO),
                        byVisibleText(datosHistoricos.getCuentaDestino()).from(TXT_CUENTA_DESTINO),
                        byVisibleText(datosHistoricos.getTipoTransferencia()).from(TXT_TIPO_TRANSFERENCIA),
                        byVisibleText(datosHistoricos.getEstado()).from(TXT_ESTADO),
                        Enter.theValue(datosHistoricos.getDesde()).into(FECHA_DESDE),
                        Enter.theValue(datosHistoricos.getHasta()).into(FECHA_HASTA),
                        JavaScriptClick.on(BOTON_GENERAR_HISTORICO_OTROS),
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds()
                );
            break;
        }
    }

    public static LlenarHistoricoCuentasOtrosBancos go(String scenario, DatosHistoricos datosHistoricos){
        return Tasks.instrumented(LlenarHistoricoCuentasOtrosBancos.class,scenario,datosHistoricos);

    }



}
