package bo.com.bga.certificacion.gananet.tasks.comprobantes.consulta;

import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.models.comprobantes.DatosConsultaComprobanteCredito;
import bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ConsultaComprobanteCreditoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.LOADER_TRANSVERSAL;
import static bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ConsultaComprobanteCreditoPage.SELECT_CUENTA;
import static bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ConsultaComprobanteCreditoPage.SELECT_TIPO_MOVIMIENTO;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.LABEL_CIUDAD;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;

public class LlenarInformacionConsultaComprobanteCredito implements Task {
    DatosConsultaComprobanteCredito datosConsultaComprobanteCredito;

    public LlenarInformacionConsultaComprobanteCredito(DatosConsultaComprobanteCredito datosConsultaComprobanteCredito) {
        this.datosConsultaComprobanteCredito = datosConsultaComprobanteCredito;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                byVisibleText(datosConsultaComprobanteCredito.getTipoDeMovimiento()).from(SELECT_TIPO_MOVIMIENTO),
                byVisibleText(datosConsultaComprobanteCredito.getCuenta()).from(SELECT_CUENTA),
                Enter.theValue(datosConsultaComprobanteCredito.getDesde()).into(ConsultaComprobanteCreditoPage.SELECT_DESDE),
                Enter.theValue(datosConsultaComprobanteCredito.getHasta()).into(ConsultaComprobanteCreditoPage.SELECT_HASTA),
                JavaScriptClick.on(ConsultaComprobanteCreditoPage.BOTON_CONSULTAR),
                JavaScriptClick.on(ConsultaComprobanteCreditoPage.BOTON_VER),
                WaitUntil.the(LOADER_TRANSVERSAL, isNotCurrentlyVisible()).forNoMoreThan(35).seconds()

                );

    }
    public static LlenarInformacionConsultaComprobanteCredito go(DatosConsultaComprobanteCredito datosConsultaComprobanteCredito){
        return Tasks.instrumented(LlenarInformacionConsultaComprobanteCredito.class,datosConsultaComprobanteCredito);

    }

}
