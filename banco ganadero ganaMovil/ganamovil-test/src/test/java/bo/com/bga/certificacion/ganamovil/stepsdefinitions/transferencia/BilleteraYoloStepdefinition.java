package bo.com.bga.certificacion.ganamovil.stepsdefinitions.transferencia;

import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.models.TransferenciaModel;
import bo.com.bga.certificacion.ganamovil.questions.shared.ValidarTextos;
import bo.com.bga.certificacion.ganamovil.questions.transferencia.ValidarReducciónSaldo;
import bo.com.bga.certificacion.ganamovil.questions.transferencia.ValidarTransferencia;
import bo.com.bga.certificacion.ganamovil.tasks.transacciones.Transferencia;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSACCIÓN_MIS_CUENTAS;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSFERENCIA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BilleteraYoloStepdefinition {
    @When("^realiza la transferencia a la billetera$")
    public void realizaLaTransferenciaALaBilletera(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Transferencia.diligenciarBilletera(TransferenciaModel.setData(dataTable).get(0))
        );
    }


    @Then("^deberia ver un comprobante de transferencia a la billetera (.*) (.*)$")
    public void deberiaVerUnComprobanteDeTransferenciaALaBilleteraTransferenciaExitosa(String mensaje, int saldo) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_EL_LABEL_DE_LA_TRANSFERENCIA_EXITOSA, ValidarTextos.textosDelFrontEnd(LBL_TRANSFERENCIA, mensaje))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarTransferencia.validarMovimientoInterno(LBL_TRANSACCIÓN_MIS_CUENTAS))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_DESCUENTO_DE_LA_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarReducciónSaldo.saldo(saldo))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }
}
