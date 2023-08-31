package bo.com.bga.certificacion.api.stepdefinitions.acceso;

import bo.com.bga.certificacion.api.models.acceso.HabilitarDispositivoModel;
import bo.com.bga.certificacion.api.questions.compartida.ValidarMensajeRespuesta;
import bo.com.bga.certificacion.api.tasks.habilitarDispositivo.EjecutarHabilitarDispositivo;
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

public class habilitarDispositivoStepdefinition {

    @When("Llama al endpoint iniciar solicitud Enrolamiento")
    public void llamaAlEndpointIniciarSolicitudEnrolamiento(DataTable dataTable) {
        Map<String, Object> condiciones = new HashMap<>();
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        condiciones.put("codusuario",filas.get(0).get("pStrNombreUsuario"));
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.Eliminar("CAS_USUARIOXCANAL", condiciones, "GANADERO"),
                EjecutarHabilitarDispositivo.habilitar(HabilitarDispositivoModel.setData(dataTable))
        );
    }
    @Then("Debería ver la respuesta del endpoint Iniciar Solicitud Enrolamiento {string}")
    public void deberíaVerLaRespuestaDelEndpointIniciarSolicitudEnrolamiento(String mensaje) {
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_MENSAJE_EN_LA_RESPUESTA, ValidarMensajeRespuesta.expected(mensaje, theActorInTheSpotlight().recall("IniciarSolicitudEnrolamientostrMensaje"))
        ));

    }

}
