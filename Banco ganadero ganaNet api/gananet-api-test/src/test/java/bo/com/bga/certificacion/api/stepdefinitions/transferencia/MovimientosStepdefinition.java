package bo.com.bga.certificacion.api.stepdefinitions.transferencia;

import bo.com.bga.certificacion.api.models.transferencia.MovimientosModel;
import bo.com.bga.certificacion.api.questions.transferencia.VerificarMovimientos;
import bo.com.bga.certificacion.api.tasks.transferencia.movimientos.MovimientosTransaccionales;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_VALIDAR_LOS_DATOS_DE_LA_RESPUESTA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosStepdefinition {

    @When("Llama al endpoint historial de transferencias con una fecha que solo tiene un registro")
    public void llamaAlEndpointHistorialDeTransferenciasConUnaFechaQueSoloTieneUnRegistro(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                MovimientosTransaccionales.movimientos(MovimientosModel.setData(dataTable))
        );
    }

    @Then("Debería validar la respuesta del endpoint")
    public void deberíaValidarLaRespuestaDelEndpoint() {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_LOS_DATOS_DE_LA_RESPUESTA, VerificarMovimientos.verificar())
        );
    }
}
