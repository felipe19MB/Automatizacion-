package bo.com.bga.certificacion.gananet.stepdefinitions.atencion_al_cliente;

import bo.com.bga.certificacion.gananet.models.atencion_al_cliente.RegistroSugerenciaModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.atencion_al_cliente.registrar_sugerencia.RegistrarSugerencia;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.notNullValue;

public class RegistroSugerenciasStepDefinition {
    @When("registra una sugerencia")
    public void registraUnaSugerencia(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarSugerencia.go(RegistroSugerenciaModel.setData(dataTable).get(0),"HappyPath")
        );
    }
    @Then("Debería visualizar el mensaje de confirmación de recibida y su correcto almacenamiento en base de datos")
    public void deberíaVisualizarElMensajeDeConfirmaciónDeRecibidaYSuCorrectoAlmacenamientoEnBaseDeDatos(DataTable dataTable) {
        RegistroSugerenciaModel registrarSugerencia= RegistroSugerenciaModel.setData(dataTable).get(0);
        String sugerenciaValueBD = OnStage.theActorInTheSpotlight().recall("REGISTROS_SUGERENCIAS").toString();
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje informativo que se expone antes de enviar la sugerencia",
                        ValidacionString.esCorrecta(registrarSugerencia.getMensajeInformativo(),"MENSAJE INFORMATIVO - SUGERENCIAS")
                ),
                seeThat("Se verifica que la modal del envío de la solicitud contenga el mensaje esperado",
                        ValidacionString.esCorrecta(registrarSugerencia.getMensajeConfirmacion(),"MENSAJE CONFIRMACIÓN - SUGERENCIAS")
                ),
                seeThat("Verifica el almacenamiento exitoso en base de datos",
                                actor -> sugerenciaValueBD,
                                notNullValue()
                )
        );
    }
}
