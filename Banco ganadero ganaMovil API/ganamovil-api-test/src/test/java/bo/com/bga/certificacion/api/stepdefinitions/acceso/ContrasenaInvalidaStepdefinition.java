package bo.com.bga.certificacion.api.stepdefinitions.acceso;

import bo.com.bga.certificacion.api.models.acceso.ValidarClaveModel;
import bo.com.bga.certificacion.api.questions.compartida.ValidarMensajeRespuesta;
import bo.com.bga.certificacion.api.tasks.acceso.EjecutarAcceso;
import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ContrasenaInvalidaStepdefinition {
    @When("Llama al endpoint Validar Clave")
    public void llamoElMetodoValidarClave(DataTable dataTable) {
        Map<String, Object> condicionesUpdate = new HashMap<>();
        Map<String, Object> valoresUpdate1 = new HashMap<>();
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        condicionesUpdate.put("CODUSUARIO", filas.get(0).get("pStrNombreUsuario") );
        condicionesUpdate.put("CANAL", 1 );
        valoresUpdate1.put("ESTADO", "A");
        valoresUpdate1.put("NROINTENTOS", "0");
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.Actualizar("CAS_CONTROLESXCANAL",condicionesUpdate,valoresUpdate1,"GANANET")
        );
        theActorInTheSpotlight().attemptsTo(
                EjecutarAcceso.validarClave(ValidarClaveModel.setData(dataTable))
        );
    }
    @Then("Debería ver la respuesta del endpoint validar clave {string}")
    public void deberiaVerLaRespuestaDelEndpoint(String mensaje) {
        System.out.println(theActorInTheSpotlight().recall("ValidarClaveStrMensaje").toString() + " "+  mensaje);
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA, ValidarMensajeRespuesta.expected(mensaje, theActorInTheSpotlight().recall("ValidarClaveStrMensaje"))
        ));
    }
}
