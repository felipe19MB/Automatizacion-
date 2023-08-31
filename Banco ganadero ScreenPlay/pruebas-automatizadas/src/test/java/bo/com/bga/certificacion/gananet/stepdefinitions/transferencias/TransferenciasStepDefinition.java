package bo.com.bga.certificacion.gananet.stepdefinitions.transferencias;

import bo.com.bga.certificacion.gananet.models.transferencias.TransferenciasModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.transferencias.TransferirCuentasOtrosBancos;
import bo.com.bga.certificacion.gananet.tasks.transferencias.TransferirCuentasPropias;
import bo.com.bga.certificacion.gananet.tasks.transferencias.TransferirCuentasTerceros;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;


import static bo.com.bga.certificacion.gananet.userinterfaces.transferencias.TransferenciasPage.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TransferenciasStepDefinition {
    @When("realiza la transferencia {string} desde su cuenta de origen {string} por el importe de {string} a su cuenta destino {string} en {string}")
    public void realizaLaTransferenciaACuentaEnMonedaDesdeSuCuentaDeOrigenEnMonedaPorElMonto(String tipoTransferencia, String cuentaOrigen, String importe, String cuentaDestino, String tipoImporte, DataTable dataTable) {
        switch (tipoTransferencia) {
            case "A Cuentas Propias":
                OnStage.theActorInTheSpotlight().attemptsTo(
                        TransferirCuentasPropias.EntreCuentas(TransferenciasModel.setData(dataTable).get(0),cuentaOrigen,cuentaDestino,importe,tipoImporte, "HappyPath")
                );
                break;
            case "A Cuentas de Terceros":
                OnStage.theActorInTheSpotlight().attemptsTo(
                        TransferirCuentasTerceros.EntreCuentas(TransferenciasModel.setData(dataTable).get(0),cuentaOrigen,cuentaDestino,importe,tipoImporte, "HappyPath")
                );
                break;
            case "A Otros Bancos":
                OnStage.theActorInTheSpotlight().attemptsTo(
                        TransferirCuentasOtrosBancos.EntreCuentas(TransferenciasModel.setData(dataTable).get(0),cuentaOrigen,cuentaDestino,importe,tipoImporte, "HappyPath")
                );
                break;
        }
    }
    @Then("debería confirmar la transferencia de fondos {string}")
    public void deberíaConfirmarLaTransferenciaDeFondosEntreCuentasConElMensajeEnLaVentana(String tipoTransferencia,DataTable dataTable) {
        TransferenciasModel transferenciasModel = TransferenciasModel.setData(dataTable).get(0);
        String mensajeComprobante = OnStage.theActorInTheSpotlight().recall("MENSAJE COMPROBANTE").toString();
        String montoDebitado = OnStage.theActorInTheSpotlight().recall("MONTO DEBITADO ESPERADO").toString();
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "Se verifica el titulo del comprobante corresponda",VerificarConfirmaciones.go(mensajeComprobante,COMPROBANTE_TITULO)
                ),
                seeThat(
                        "Se verifica que el monto debitado sea el correspondiente",WebElementQuestion.the(HomePage.COMPROBANTE_IMPORTE_DEBITADO.of(montoDebitado)),isCurrentlyVisible()
                ),
                seeThat(
                        "Se verifica que el monto abonado sea el correspondiente",WebElementQuestion.the(HomePage.COMPROBANTE_IMPORTE_ABONADO.of(montoDebitado)),isCurrentlyVisible()
                ),
                seeThat(
                        "Se verifica que el motivo del debito corresponda a lo diligenciado",WebElementQuestion.the(HomePage.COMPROBANTE_MOTIVO_DEBITO_PROPIA.of(transferenciasModel.getGlosaDebito())),isCurrentlyVisible()
                ),
                seeThat(
                        "Se verifica que el motivo del credito corresponda a lo diligenciado",WebElementQuestion.the(HomePage.COMPROBANTE_MOTIVO_CREDITO_PROPIA.of(transferenciasModel.getGlosaCredito())),isCurrentlyVisible()
                ),
                seeThat(
                        "Se verifica que la cuenta origen sea la correcta", WebElementQuestion.the(HomePage.COMPROBANTE_CUENTA_ORIGEN.of(transferenciasModel.getCuentaOrigen())),isCurrentlyVisible()
                ),
                seeThat(
                        "Se verifica que la cuenta destino sea la correcta",WebElementQuestion.the(HomePage.COMPROBANTE_CUENTA_DESTINO.of(transferenciasModel.getCuentaDestino())),isCurrentlyVisible()
                )
        );
        switch (tipoTransferencia) {
            case "A Cuentas Propias":
            case "A Cuentas de Terceros":
                OnStage.theActorInTheSpotlight().should(
                        seeThat(
                                "Se verifica que el registro de débito esté en base de datos", ValidacionBaseDeDatos.esCorrecta(transferenciasModel.getCuentaOrigen(),"CUENTA","resultadosBDDebito")
                        ),
                        seeThat(
                                "Se verifica que el registro de crédito esté en base de datos", ValidacionBaseDeDatos.esCorrecta(transferenciasModel.getCuentaDestino(),"CUENTA","resultadosBDCredito")
                        )
                );
                break;
            case "A Otros Bancos":
                OnStage.theActorInTheSpotlight().should(
                        seeThat(
                                "Se verifica que el registro ACH esté en base de datos", ValidacionBaseDeDatos.esCorrecta(transferenciasModel.getCuentaOrigen(),"NUMEROCUENTA_ORI","resultadosBDACH")
                        ));
                break;
        }
    }
}
