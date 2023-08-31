package bo.com.bga.certificacion.api.stepdefinitions.qr;

import bo.com.bga.certificacion.api.models.qr.CobroModel;
import bo.com.bga.certificacion.api.questions.qr.VerificarCobro;
import bo.com.bga.certificacion.api.tasks.qr.QrModulo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OrdenDeCobro {
    @When("Llama al endpoint realizar transacción cobro qr")
    public void llamaAlEndpointRealizarTransacciónCobroQr(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                QrModulo.ordenDeCobro(CobroModel.setData(dataTable))
        );
    }
    @Then("Debería ver la respuesta del endpoint realizar cobro qr {string}")
    public void deberíaVerLaRespuestaDelEndpointRealizarCobroQr(String pStrCodigoPersona) {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA, VerificarCobro.cobroQR(pStrCodigoPersona)
        ));
    }
}
