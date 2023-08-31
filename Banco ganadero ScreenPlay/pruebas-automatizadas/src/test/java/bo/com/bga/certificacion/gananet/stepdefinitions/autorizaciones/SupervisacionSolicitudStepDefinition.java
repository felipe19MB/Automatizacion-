package bo.com.bga.certificacion.gananet.stepdefinitions.autorizaciones;

import bo.com.bga.certificacion.gananet.interactions.shared.Utilidades;
import bo.com.bga.certificacion.gananet.models.autorizaciones.AutorizacionSolicitudModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.autorizaciones.AutorizarSolicitud;
import bo.com.bga.certificacion.gananet.tasks.autorizaciones.SupervisarSolicitud;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones.AutorizacionSolicitudPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones.AutorizacionSolicitudPage.COMPROBANTE_CANTIDAD_CHEQUES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SupervisacionSolicitudStepDefinition {
    @When("supervisar la solicitud de chequera")
    public void supervisarLaSolicitudDeChequera() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SupervisarSolicitud.go("chequera")
        );
    }
    @Then("deberia ver mensaje para la supervision aprobada")
    public void deberiaVerMensajeParaLasupervisionAprobada(DataTable dataTable) {
        AutorizacionSolicitudModel autorizacionSolicitudModel = AutorizacionSolicitudModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de la autorizacion de la chequera", ValidacionString.esCorrecta(autorizacionSolicitudModel.getMensaje(),"mensajeComprobante")
                ),
                seeThat("Se verifica el mensaje de la autorizacion de la chequera", ValidacionString.esCorrecta(autorizacionSolicitudModel.getMensajeSupervision(),"mensajeAutorizacion")
                )


        );

    }
}
