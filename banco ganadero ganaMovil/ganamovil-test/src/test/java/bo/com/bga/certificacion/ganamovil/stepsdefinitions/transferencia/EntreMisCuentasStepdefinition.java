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

import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSACCIÓN;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSFERENCIA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EntreMisCuentasStepdefinition {

    @When("^selecciona los datos de transferencia Entre mis cuentas$")
    public void seleccionaLosDatosDeTransferencia(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Transferencia.diligenciarEntreMisCuentas(TransferenciaModel.setData(dataTable).get(0))
        );
    }

    @Then("^válida la transferencia (.*) (.*)$")
    public void validaLaTransferencia(String mensaje, int saldo) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_EL_LABEL_DE_LA_TRANSFERENCIA_EXITOSA, ValidarTextos.textosDelFrontEnd(LBL_TRANSFERENCIA, mensaje))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarTransferencia.validarMovimientoInterno(LBL_TRANSACCIÓN))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_DESCUENTO_DE_LA_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarReducciónSaldo.saldo(saldo))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }
}
