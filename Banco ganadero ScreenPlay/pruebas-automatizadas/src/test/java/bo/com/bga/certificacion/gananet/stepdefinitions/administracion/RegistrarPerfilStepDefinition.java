package bo.com.bga.certificacion.gananet.stepdefinitions.administracion;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.models.administracion.ListadoPerfilesModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.administracion.listado_perfiles.EliminarPerfil;
import bo.com.bga.certificacion.gananet.tasks.administracion.listado_perfiles.RegistrarPerfil;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;

public class RegistrarPerfilStepDefinition {

    @When("Registra un nuevo perfil")
    public void registraUnNuevoPerfil(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarPerfil.go(ListadoPerfilesModel.setData(dataTable).get(0))
                       );
            }

    @Then("Deberia ver un mensaje de confirmacion de creacion de perfil")
    public void deberiaVerUnMensajeDeConfirmacionDeCreacionDePerfil(DataTable dataTable) {
        ListadoPerfilesModel listadoPerfilesModel = ListadoPerfilesModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", ValidacionString.esCorrecta(listadoPerfilesModel.getMensaje(),"mensajeConfirmacionRegistroPefil")),
                GivenWhenThen.seeThat("Verificar Registro en BD", ValidacionBaseDeDatos.esCorrecta(listadoPerfilesModel.getNombrePerfil(),"NOMBRE","validarRegistroPerfil"))
        );
    }
}


