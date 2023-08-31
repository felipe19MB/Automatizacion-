package bo.com.bga.certificacion.api.stepdefinitions.acceso;

import bo.com.bga.certificacion.api.models.acceso.ObtenerSesionModel;
import bo.com.bga.certificacion.api.questions.compartida.ValidarMensajeRespuesta;
import bo.com.bga.certificacion.api.tasks.acceso.EjecutarAcceso;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UsuarioInvalidoStepdefinition {

    @When("Llama al endpoint Obtener Sesión")
    public void llamaAlMetodoObtenerSesion(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                EjecutarAcceso.obtenerSesion(ObtenerSesionModel.setData(dataTable))
        );
    }
    @Then("Debería ver la respuesta del endpoint obtener sesión {string}")
    public void deberiaVerLaRespuestaDelEndpoint(String mensaje) {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA, ValidarMensajeRespuesta.expected(mensaje, theActorInTheSpotlight().recall("ObtenerSesionStrTitulo"))
        ));
    }
}
