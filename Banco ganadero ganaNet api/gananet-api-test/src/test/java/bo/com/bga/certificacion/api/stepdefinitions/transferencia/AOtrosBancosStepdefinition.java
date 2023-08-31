package bo.com.bga.certificacion.api.stepdefinitions.transferencia;

import bo.com.bga.certificacion.api.models.transferencia.AOtrosBancosModel;
import bo.com.bga.certificacion.api.questions.transferencia.VerificarOtrosBancos;
import bo.com.bga.certificacion.api.tasks.transferencia.EjecuarTransferencia;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_EXISTIR_DATOS_DE_LA_TRANSACCIÓN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AOtrosBancosStepdefinition {

    @When("Llama al endpoint realizar transacción a otros bancos")
    public void llamaAlEndpointRealizarTransacciónAOtrosBancos(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().remember("idOrigen", filas.get(0).get("pIntJtsOidOrigen"));
        theActorInTheSpotlight().attemptsTo(
                EjecuarTransferencia.otrosBancos(AOtrosBancosModel.setData(dataTable), "IMPORTEPÍGNORADO")
        );
    }

    @When("Llama al endpoint realizar transacción a otros bancos no afiliados")
    public void llamaAlEndpointRealizarTransacciónAOtrosBancosNoAfiliados(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().remember("idOrigen", filas.get(0).get("pIntJtsOidOrigen"));
        theActorInTheSpotlight().attemptsTo(
                EjecuarTransferencia.otrosBancos(AOtrosBancosModel.setData(dataTable), "CUENTANOAFILIADA")
        );
    }
    @Then("Debería ver la respuesta del saldo pignorado en la base de datos")
    public void deberíaVerLaRespuestaDelSaldoPignoradoEnLaBaseDeDatos() {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_EXISTIR_DATOS_DE_LA_TRANSACCIÓN, VerificarOtrosBancos.verificar()
        ));
    }

}
