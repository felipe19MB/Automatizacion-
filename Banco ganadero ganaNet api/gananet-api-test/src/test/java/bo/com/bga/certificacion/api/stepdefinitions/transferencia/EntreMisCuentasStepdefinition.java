package bo.com.bga.certificacion.api.stepdefinitions.transferencia;

import bo.com.bga.certificacion.api.models.transferencia.EntreMisCuentasModel;
import bo.com.bga.certificacion.api.questions.compartida.ValidarMensajeRespuesta;
import bo.com.bga.certificacion.api.questions.compartida.VerificarCodigo;
import bo.com.bga.certificacion.api.questions.transferencia.VerificarTipoCambio;
import bo.com.bga.certificacion.api.tasks.transferencia.EjecuarTransferencia;
import bo.com.bga.certificacion.api.tasks.transferencia.preCondicion.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static bo.com.bga.certificacion.api.utils.constants.Constantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EntreMisCuentasStepdefinition {

    @When("Llama al endpoint realizar transacción a cuentas cuentas con tipo de cambio")
    public void llamaAlEndpointRealizarTransaccionCuentas(DataTable dataTable){
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(
                EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable))
        );
    }

    @When("Llama al endpoint realizar transacción con la cuenta origen bloqueada")
    public void llamaAlEndpointRealizarTransaccionConLaCuentaOrigenBloqueada(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(BloquearODesbloquearCuenta.bloquearODesbloquearCuenta(filas.get(0).get("pIntJtsOidOrigen"), "B"),
        ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable)));
        theActorInTheSpotlight().attemptsTo(BloquearODesbloquearCuenta.bloquearODesbloquearCuenta(filas.get(0).get("pIntJtsOidOrigen"), " "));
    }

    @When("Llama al endpoint realizar transacción con la cuenta destino bloqueadas")
    public void llamaAlEndpointRealizarTransaccionConlaCuentaDestinoBloqueada(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(BloquearODesbloquearCuenta.bloquearODesbloquearCuenta(filas.get(0).get("pIntJtsOidDestino"), "B"),
        ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable)));
        theActorInTheSpotlight().attemptsTo(BloquearODesbloquearCuenta.bloquearODesbloquearCuenta(filas.get(0).get("pIntJtsOidDestino"), " "));
    }

    @When("Llama al endpoint realizar transacción con cuenta sin saldo suficiente")
    public void llamaAlEndpointRealizarTransaccionCuentasSinSaldoSuficiente(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(AdministrarDineroCuenta.administrarDineroCuenta(filas.get(0).get("pIntJtsOidOrigen"),"0"),
        ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable)));
        theActorInTheSpotlight().attemptsTo(AdministrarDineroCuenta.administrarDineroCuenta(filas.get(0).get("pIntJtsOidOrigen"), "10000"));
    }

    @When("Llama al endpoint realizar transacción con transacciones maximas permitidas")
    public void llamaAlEndpointRealizarTransaccionesMaximasPermitidas(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(TransaccionesMaximasPorDia.transaccionesMaximasPorDia(filas.get(0).get("pIntJtsOidOrigen")),
        ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable)));
    }

    @When("Llama al endpoint realizar transacciones con límite de importe")
    public void llamaAlEndpointRealizarTransaccionesConLimiteDeImporte(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(TransaccionesLimiteImporteDiario.transaccionesLimiteImporteDiario(filas.get(0).get("pIntJtsOidOrigen")),
        ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable)));
    }

    @When("Llama al endpoint realizar transacciones con límite de importe por firma")
    public void llamaAlEndpointRealizarTransaccionesConLimitePorFirma(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(LimiteDeImportePorFirma.limiteDeImportePorFirma(filas.get(0).get("pIntJtsOidOrigen")),
        ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino")));
        theActorInTheSpotlight().attemptsTo(EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable)));
    }

    @When("Llama al endpoint realizar transacciones con la cuenta que requiere dos personas para la firma")
    public void llamaAlEndpointRealizarTransaccionesConLaCuentaQueRequiereDosPersonasParaLaFirma(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(
                RequiereDosPersonasParaLaFirma.requiereDosPersonasParaLaFirma(theActorInTheSpotlight().recall("pStrNombreUsuario"), filas.get(0).get("pIntJtsOidOrigen")),
                AdministrarDineroCuenta.administrarDineroCuenta(filas.get(0).get("pIntJtsOidOrigen"), "10000"),
                ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino"))
        );
        theActorInTheSpotlight().attemptsTo(
                EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable))
        );
    }

    @When("Llama al endpoint realizar transacción con límite de importe diario por periodo permitido para la cuenta origen")
    public void llamaAlEndpointRealizarTransaccionConLimiteDeImporteDiarioPorPeriodoPermitidoParaLaCuentaOrigen(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(
                PeriodoDiarioPermitido.periodoDiarioPermitido(filas.get(0).get("pIntJtsOidOrigen")),
                AdministrarDineroCuenta.administrarDineroCuenta(filas.get(0).get("pIntJtsOidOrigen"), "10000"),
                ConsultarIdCuentas.consultarIdCuentas(filas.get(0).get("pIntJtsOidOrigen"),filas.get(0).get("pIntJtsOidDestino"))
        );
        theActorInTheSpotlight().attemptsTo(
                EjecuarTransferencia.transferencia(EntreMisCuentasModel.setData(dataTable))
        );
    }

    @Then("Debería ver la respuesta del endpoint {string}")
    public void deberiaVerLaRespuesta(String mensaje) {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA, ValidarMensajeRespuesta.expected(mensaje, theActorInTheSpotlight().recall("mensajeCuentaNoDisponible").toString())
        ));
    }

    @Then("Debería ver la respuesta {string} y {string}")
    public void deberiaVerLaRespuestaY(String mensaje, String mensajedos) {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA, ValidarMensajeRespuesta.expecteddos(mensaje,mensajedos, theActorInTheSpotlight().recall("strMensaje").toString())
        ));
    }


    @Then("Debería ver el estado del endpoint al realizar transacción {int}")
    public void DeberíaVerElEstadoDelEndpointRealizarTransacción (int codigo) {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_CÓDIGO_DE_ESTADO_DE_LA_RESPUESTA, VerificarCodigo.esperado(codigo, "TransaccionStatusCode")
        ));
    }

    @Then("Debería existir los datos de la transacción en la base de datos")
    public void deberiaExistirLosDatosDeLaTransaccionEnLaBaseDeDatos() {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_EXISTIR_DATOS_DE_LA_TRANSACCIÓN, VerificarTipoCambio.verificar()
        ));
    }

}
