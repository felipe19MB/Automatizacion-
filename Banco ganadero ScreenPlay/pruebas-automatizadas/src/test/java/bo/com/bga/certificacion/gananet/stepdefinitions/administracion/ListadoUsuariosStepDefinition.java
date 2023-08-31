package bo.com.bga.certificacion.gananet.stepdefinitions.administracion;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.models.administracion.DatosListadoUsuarios;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.administracion.listado_usuarios.EliminarUsuario;
import bo.com.bga.certificacion.gananet.tasks.administracion.listado_usuarios.RegistrarUsuario;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;
import static bo.com.bga.certificacion.gananet.userinterfaces.administracion.ListadoUsuariosPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_ADMINISTRACION_CUENTA_RELACIONADA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ListadoUsuariosStepDefinition {
    @When("Registra un usuario que es {string}")
    public void registraUnUsuarioQueEs(String tipoCliente, DataTable dataTable) {
        DatosListadoUsuarios datosListadoUsuarios = DatosListadoUsuarios.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ADMINISTRACION_CUENTA_RELACIONADA+ "'"+datosListadoUsuarios.getCodigo()+"'"+" AND NRO_PERSONA_RELACIONADA = "+"'"+datosListadoUsuarios.getUsuario()+"'","resultadosObtenidos","AUTOSRV")
                        .Comentario("Se ejecuta el query para eliminar un registro si existiera.")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarUsuario.go(tipoCliente,DatosListadoUsuarios.setData(dataTable).get(0))
        );
    }
    @Then("Deberia ver un mensaje de usuario agregado correctamente")
    public void deberiaVerUnMensajeDeUsuarioAgregadoCorrectamente(DataTable dataTable) {
        DatosListadoUsuarios datosListadoUsuarios = DatosListadoUsuarios.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(datosListadoUsuarios.getMensaje(), MODAL_CONFIRMACION)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarModal.go()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el codigo de persona agregado",
                        WebElementQuestion.the(ASSERT_CODIGO.of(datosListadoUsuarios.getCodigo())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver nombre agregado",
                        WebElementQuestion.the(ASSERT_NOMBRE.of(datosListadoUsuarios.getCodigo())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver tipo de usuario agregado",
                        WebElementQuestion.the(ASSERT_TIPO_USUARIO.of(datosListadoUsuarios.getCodigo())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el tipo de perfil agregado",
                        WebElementQuestion.the(ASSERT_PERFIL.of(datosListadoUsuarios.getCodigo())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el estado agregado",
                        WebElementQuestion.the(ASSERT_ESTADO.of(datosListadoUsuarios.getCodigo())), isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarUsuario.go(DatosListadoUsuarios.setData(dataTable).get(0))
        );
    }
}
