package bo.com.bga.certificacion.gananet.stepdefinitions.autorizaciones;

import bo.com.bga.certificacion.gananet.interactions.shared.Utilidades;
import bo.com.bga.certificacion.gananet.models.autorizaciones.AutorizacionSolicitudModel;
import bo.com.bga.certificacion.gananet.models.chequeras.SolicitudChequeraModel;
import bo.com.bga.certificacion.gananet.models.shared.DatosIngreso;
import bo.com.bga.certificacion.gananet.models.shared.DatosRutaFuncionalidad;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.autorizaciones.AutorizarSolicitud;
import bo.com.bga.certificacion.gananet.tasks.chequeras.solicitud_chequera.LlenarSolicitudChequera;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresarAFuncionalidad;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresarAGananet;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones.AutorizacionSolicitudPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.autorizaciones.AutorizacionSolicitudPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.GenerarExtractosPage.VALIDAR_DESCRIPCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class AutorizacionSolicitudStepDefinition {

    @Given("empresa genera una solicitud de chequera pendiente de autorización")
    public void empresaGeneraUnaSolicitudDeChequeraPendienteDeAutorización(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://devganamovil.bg.com.bo/apps/GanaNet/#_Site")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAGananet.withCredentials(DatosIngreso.setData(dataTable.columns(0,2)).get(0))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAFuncionalidad.go(DatosRutaFuncionalidad.setData(dataTable.columns(2,5)).get(0))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarSolicitudChequera.go(SolicitudChequeraModel.setData(dataTable.columns(5,13)).get(0),"HappyPath")
        );
    }

    @When("autoriza la solicitud de chequera")
    public void autorizaLaSolicitudDeChequera() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AutorizarSolicitud.go("chequera")
        );
    }


    @Then("deberia ver un comprobante de pago de chequera")
    public void deberiaVerUnComprobanteDePagoDeChequera(DataTable dataTable) {
        AutorizacionSolicitudModel autorizacionSolicitudModel = AutorizacionSolicitudModel.setData(dataTable).get(0);
        int cantidadCheques= Integer.parseInt(autorizacionSolicitudModel.getCantidadTalonarios()) * Utilidades.extraerNumero(autorizacionSolicitudModel.getTalonario());
        System.out.println(cantidadCheques);
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de la autorizacion de la chequera", ValidacionString.esCorrecta(autorizacionSolicitudModel.getMensaje(),"mensajeAutorizacion")

                ),
                seeThat("Se verifica la cuenta de origen del comprobante de la chequera",WebElementQuestion.the(COMPROBANTE_CUENTA_ORIGEN.of(autorizacionSolicitudModel.getCuentaOrigen())),isCurrentlyVisible()

                ),
                seeThat("Se verifica la cantidad de chequeras del comprobante de la chequera", WebElementQuestion.the(COMPROBANTE_CANTIDAD_CHEQUERAS.of(autorizacionSolicitudModel.getCantidadTalonarios())),isCurrentlyVisible()

                ),
                seeThat("Se verifica el formato del comprobante de la chequera", WebElementQuestion.the(COMPROBANTE_FORMATO.of(autorizacionSolicitudModel.getFormato())),isCurrentlyVisible()

                ),
                seeThat("Se verifica la cantidad de cheques del comprobante de la chequera",WebElementQuestion.the(COMPROBANTE_CANTIDAD_CHEQUES.of(String.valueOf(cantidadCheques))),isCurrentlyVisible()


                )


        );

    }

}
