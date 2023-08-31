package bo.com.bga.certificacion.api.stepdefinitions.compartida;

import bo.com.bga.certificacion.api.models.acceso.HabilitarDispositivoModel;
import bo.com.bga.certificacion.api.models.acceso.ValidarClaveModel;
import bo.com.bga.certificacion.api.questions.compartida.ValidarSchema;
import bo.com.bga.certificacion.api.questions.compartida.VerificarCampos;
import bo.com.bga.certificacion.api.tasks.acceso.EjecutarAcceso;
import bo.com.bga.certificacion.api.tasks.habilitarDispositivo.EjecutarHabilitarDispositivo;
import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_VALIDAR_EL_ESQUEMA_DE_LA_RESPUESTA;
import static bo.com.bga.certificacion.api.utils.constants.Constantes.DEBERÍA_VALIDAR_LOS_DATOS_DE_LA_RESPUESTA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SharedStepdefinition {

    @Given("Que {string} inicio sesión en GanaNet Api")
    public void queInicioSesiónEnGanaNetApi(String actor, DataTable dataTable) {
        theActorCalled(actor).wasAbleTo(
                EjecutarAcceso.validarClave(ValidarClaveModel.setData(dataTable))
        );
    }
    @Then("Debería ser igual el esquema al de la respuesta {string}")
    public void ValidoElEsquemaDeLaRespuesta (String schema){
        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_EL_ESQUEMA_DE_LA_RESPUESTA, ValidarSchema.esperado(schema))
        );
    }


    @Then("Debería los datos de la respuesta")
    public void ValidoLosDatosDeLaRespuesta(DataTable dataTable){
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        List<String> response = new ArrayList<>();
        List<String> feature = new ArrayList<>();
        response.add(theActorInTheSpotlight().recall("strTipoCambioDeb").toString());
        response.add(theActorInTheSpotlight().recall("strMontoEquivDeb"));
        response.add(theActorInTheSpotlight().recall("strImporteDeb"));
        feature.add(filas.get(0).get("strTipoCambioDeb"));
        feature.add(filas.get(0).get("strMontoEquivDeb"));
        feature.add(filas.get(0).get("strImporteDeb"));

        theActorInTheSpotlight().should(seeThat(
                DEBERÍA_VALIDAR_LOS_DATOS_DE_LA_RESPUESTA, VerificarCampos.items(feature, response)
        ));

    }
}
