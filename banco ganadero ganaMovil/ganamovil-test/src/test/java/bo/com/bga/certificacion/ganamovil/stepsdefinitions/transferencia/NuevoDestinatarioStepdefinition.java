package bo.com.bga.certificacion.ganamovil.stepsdefinitions.transferencia;

import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.models.TransferenciaModel;
import bo.com.bga.certificacion.ganamovil.questions.shared.ValidarTextos;
import bo.com.bga.certificacion.ganamovil.questions.transferencia.ValidarTransferencia;
import bo.com.bga.certificacion.ganamovil.tasks.transacciones.NuevoDestinatario;
import bo.com.bga.certificacion.ganamovil.tasks.transacciones.Transferencia;
import bo.com.bga.certificacion.ganamovil.tasks.transacciones.preCondicion.DesabilitarCuenta;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSACCIÓN_MIS_CUENTAS;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSFERENCIA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NuevoDestinatarioStepdefinition {

    @When("^agrega al nuevo destinatario del mismo banco$")
    public void agregaAlNuevoDestinatarioDelMismoBanco(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                DesabilitarCuenta.terceros(theActorInTheSpotlight().recall("usuario")),
                NuevoDestinatario.mismoBanco(TransferenciaModel.setData(dataTable).get(0))
        );
    }

    @When("^selecciona los datos de transferencia del mismo banco$")
    public void seleccionaLosDatosDeTransferenciaDelMismoBanco(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Transferencia.nuevoDestinatario(TransferenciaModel.setData(dataTable).get(0))
        );
    }

    @When("^agrega al nuevo destinatario banco yolo$")
    public void agregaAlNuevoDestinatarioBancoYolo(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                DesabilitarCuenta.yolo(theActorInTheSpotlight().recall("usuario")),
                NuevoDestinatario.bancoYolo(TransferenciaModel.setData(dataTable).get(0))
        );
    }


    @When("^selecciona los datos de transferencia del banco yolo$")
    public void seleccionaLosDatosDeTransferenciaDelBancoYolo(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Transferencia.nuevoDestinatario(TransferenciaModel.setData(dataTable).get(0))
        );
    }


    @When("^agrega al nuevo destinatario del banco externo$")
    public void agregaAlNuevoDestinatarioDelBancoExterno(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                DesabilitarCuenta.otrosBancos(theActorInTheSpotlight().recall("usuario")),
                NuevoDestinatario.bancoExterno(TransferenciaModel.setData(dataTable).get(0))
        );
    }


    @When("^selecciona los datos de transferencia del banco externo$")
    public void seleccionaLosDatosDeTransferenciaDelBancoExterno(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Transferencia.nuevoDestinatario(TransferenciaModel.setData(dataTable).get(0))
        );
    }

    @Then("^deberia ver un comprobante de la transferencia del nuevo destinatario (.*)$")
    public void deberiaVerUnComprobanteDeLaTransferenciaDelNuevoDestinatario(String mensaje) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_EL_LABEL_DE_LA_TRANSFERENCIA_EXITOSA, ValidarTextos.textosDelFrontEnd(LBL_TRANSFERENCIA, mensaje))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarTransferencia.validarMovimientoInterno(LBL_TRANSACCIÓN_MIS_CUENTAS))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }

    @Then("^deberia ver un comprobante de la transferencia ach del nuevo destinatario (.*)$")
    public void deberiaVerUnComprobanteDeLaTransferenciaAchDelNuevoDestinatarioTransferenciaExitosa(String mensaje) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_EL_LABEL_DE_LA_TRANSFERENCIA_EXITOSA, ValidarTextos.textosDelFrontEnd(LBL_TRANSFERENCIA, mensaje))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_TRANSACCION_REALIZADA_EN_BASE_DE_DATOS, ValidarTransferencia.validarACH(LBL_TRANSACCIÓN_MIS_CUENTAS))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }
}
