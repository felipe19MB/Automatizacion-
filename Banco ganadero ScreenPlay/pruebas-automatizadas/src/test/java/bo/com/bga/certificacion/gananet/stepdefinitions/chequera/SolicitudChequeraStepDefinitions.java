package bo.com.bga.certificacion.gananet.stepdefinitions.chequera;

import bo.com.bga.certificacion.gananet.models.chequeras.SolicitudChequeraModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.chequeras.solicitud_chequera.LlenarSolicitudChequera;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SolicitudChequeraStepDefinitions {


    @When("ingresa los campos para la solicitud de la chequera")
    public void ingresaLosCamposParaLaSolicitudDeLaChequera(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarSolicitudChequera.go(SolicitudChequeraModel.setData(dataTable).get(0),"HappyPath")
        );

    }

    @Then("Deberia poder ver el {string} de la solicitud creada con su respectivo numero de transaccion")
    public void deberiaPoderVerElMensajeDeLaSolicitudCreadaConSuRespectivoNumeroDeTransaccion(String mensaje) {
        String numeroTransaccionSolicitud = OnStage.theActorInTheSpotlight().recall("numeroTransaccion").toString();
            OnStage.theActorInTheSpotlight().should(
                    seeThat("Se verifica el mensaje de la creacion de la solicitud de la chequera", ValidacionString.esCorrecta(mensaje,"mensajeComprobante")


                    ),
                    seeThat(
                            "se verifica que el numero de transaccion de la solicitud se cree en base de datos",ValidacionBaseDeDatos.esCorrecta(numeroTransaccionSolicitud,"NRO_TRANSACCION","resultadoBDSolicitudChequera")
                    )


            );



    }

}
