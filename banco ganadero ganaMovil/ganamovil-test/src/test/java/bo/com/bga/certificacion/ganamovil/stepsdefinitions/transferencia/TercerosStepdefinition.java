package bo.com.bga.certificacion.ganamovil.stepsdefinitions.transferencia;

import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.models.TransferenciaModel;

import bo.com.bga.certificacion.ganamovil.questions.shared.ValidarTextos;
import bo.com.bga.certificacion.ganamovil.questions.transferencia.ValidarTransferencia;
import bo.com.bga.certificacion.ganamovil.tasks.transacciones.Transferencia;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferencia.LBL_TRANSFERENCIA_OTROS_BANCOS;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSACCIÓN_MIS_CUENTAS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TercerosStepdefinition {

    @When("^realiza la transferencia a terceros$")
    public void realizaLaTransferenciaATerceros(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Transferencia.diligenciarTerceros(TransferenciaModel.setData(dataTable).get(0))
        );
    }

    @Then("deberia ver un comprobante de transferencia a terceros {string} {int}")
    public void deberiaVerUnComprobanteDeTransferenciaATercerosOperaciónExitosa(String response, int saldo) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_EL_LABEL_DE_LA_TRANSFERENCIA_EXITOSA, ValidarTextos.textosDelFrontEnd(LBL_TRANSFERENCIA_OTROS_BANCOS, response))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarTransferencia.validarMovimientoInterno(LBL_TRANSACCIÓN_MIS_CUENTAS))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }
}
