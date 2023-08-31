package bo.com.bga.certificacion.gananet.tasks.transferencias;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.interactions.shared.ConvierteMonto;
import bo.com.bga.certificacion.gananet.interactions.shared.LimpiaCampos;
import bo.com.bga.certificacion.gananet.models.transferencias.TransferenciasModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.NEXT_BUTTONS;
import static bo.com.bga.certificacion.gananet.userinterfaces.transferencias.TransferenciasPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_ORDEN_TRANSFERENCIA_OTROS_BANCOS;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_TRANSFERENCIAS_MOVIMIENTOS_CONTABLES;
import static bo.com.bga.certificacion.gananet.utils.GeneralConstants.TRANSFERENCIAS_OTROS_BANCOS_COMPROBANTE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferirCuentasOtrosBancos implements Task {
    private TransferenciasModel transferenciasModel;
    private final String scenario;
    private final String cuentaOrigen;
    private final String cuentaDestino;
    private final String monto;
    private final String tipoImporte;

    public TransferirCuentasOtrosBancos(TransferenciasModel transferenciasModel, String cuentaOrigen, String cuentaDestino, String monto, String tipoImporte, String scenario) {
        this.transferenciasModel = transferenciasModel;
        this.scenario = scenario;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.tipoImporte = tipoImporte;
    }

    public static TransferirCuentasOtrosBancos EntreCuentas(TransferenciasModel transferenciasModel, String cuentaOrigen, String cuentaDestino, String monto, String tipoImporte, String scenario) {
        return Tasks.instrumented(TransferirCuentasOtrosBancos.class, transferenciasModel,cuentaOrigen,cuentaDestino,monto,tipoImporte, scenario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(WebElementQuestion.the(AfiliacionesPage.BOTON_OK),isClickable()).andIfSo(
                        JavaScriptClick.on(AfiliacionesPage.BOTON_OK)
                        )
        );
        switch (scenario){
            case ("HappyPath"):
                actor.attemptsTo(
                        WaitUntil.the(CUENTA_ORIGEN.of(cuentaOrigen), isClickable()).forNoMoreThan(25).seconds(),
                        JavaScriptClick.on(CUENTA_ORIGEN.of(cuentaOrigen)),
                        JavaScriptClick.on(CUENTA_DESTINO.of(cuentaDestino)),
                        WaitUntil.the(NEXT_BUTTONS.of("Siguiente"),isClickable()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguiente")),
                        JavaScriptClick.on(TIPO_MONEDA_OPCION.of(tipoImporte)),
                        Enter.theValue(monto).into(IMPORTE),
                        Enter.theValue(transferenciasModel.getGlosaDebito()).into(MOTIVO_DEBITO),
                        LimpiaCampos.paraEscribir(MOTIVO_CREDITO),
                        Enter.theValue(transferenciasModel.getGlosaCredito()).into(MOTIVO_CREDITO),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Finalizar")),
                        IngresaGanaPin.paraConfirmarTransaccion(),
                        WaitUntil.the(HomePage.LOADER_TRANSVERSAL,isNotCurrentlyVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(COMPROBANTE_ID,isPresent()).forNoMoreThan(20).seconds()
                );
                OnStage.theActorInTheSpotlight().remember("ID COMPROBANTE",COMPROBANTE_ID.resolveFor(actor).getTextContent());
                //Se obtiene el id del asiento contable:
                Integer idComprobante = Integer.parseInt(COMPROBANTE_ID.resolveFor(actor).getTextContent().substring(3));
                //Se obtiene el Monto en entero o en decimal, según sea el caso
                double montoInt = ConvierteMonto.enDecimalOEntero(monto);
                //Se ejecuta la querie en base de datos para comprobar que si se generó la transferencia.
                actor.attemptsTo(
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_ORDEN_TRANSFERENCIA_OTROS_BANCOS+" TRANSORIGEN="+idComprobante+" AND NUMEROCUENTA_ORI= '"+cuentaOrigen+"' AND NRO_CUENTA_DES='"+cuentaDestino+"' AND IMPORTE="+montoInt+" AND GLOSA='"+ transferenciasModel.getGlosaDebito()+"'","resultadosBDACH","GANADERO").
                                //Se realiza el comentario para que en el reporte se entienda el paso realizado
                                        Comentario("Se ejecuta el query para obtener el registro del débito: "+QUERY_CONSULTAR_ORDEN_TRANSFERENCIA_OTROS_BANCOS+" TRANSORIGEN="+idComprobante+" AND NUMEROCUENTA_ORI= '"+cuentaOrigen+"' AND NRO_CUENTA_DES='"+cuentaDestino+"' AND IMPORTE="+montoInt+" AND GLOSA='"+ transferenciasModel.getGlosaDebito()+"'")
                );
                System.out.println("El query es: "+QUERY_CONSULTAR_ORDEN_TRANSFERENCIA_OTROS_BANCOS+" TRANSORIGEN="+idComprobante+" AND NUMEROCUENTA_ORI= '"+cuentaOrigen+"' AND NRO_CUENTA_DES='"+cuentaDestino+"' AND IMPORTE="+montoInt+" AND GLOSA='"+ transferenciasModel.getGlosaDebito()+"'");
                OnStage.theActorInTheSpotlight().remember("MONTO DEBITADO ESPERADO",monto+" "+ transferenciasModel.getMontoSufijoComprobante());
                OnStage.theActorInTheSpotlight().remember("MENSAJE COMPROBANTE", TRANSFERENCIAS_OTROS_BANCOS_COMPROBANTE);
                break;
        }
    }
}
