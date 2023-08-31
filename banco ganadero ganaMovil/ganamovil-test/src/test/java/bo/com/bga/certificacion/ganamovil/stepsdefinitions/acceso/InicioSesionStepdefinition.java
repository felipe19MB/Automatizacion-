package bo.com.bga.certificacion.ganamovil.stepsdefinitions.acceso;

import bo.com.bga.certificacion.ganamovil.interactions.utils.EsperaExplicita;
import bo.com.bga.certificacion.ganamovil.models.UsuarioModel;
import bo.com.bga.certificacion.ganamovil.questions.home.ValidarSaldo;
import bo.com.bga.certificacion.ganamovil.tasks.shared.AbreLaApp;
import bo.com.bga.certificacion.ganamovil.tasks.acceso.HabilitarMovil;
import bo.com.bga.certificacion.ganamovil.tasks.acceso.InicioSesion;
import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import bo.com.bga.certificacion.ganamovil.userinterfaces.acceso.UiIniciarSesion;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import bo.com.bga.certificacion.ganamovil.interactions.database.EliminarRegistro;
import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.questions.shared.ValidarTextos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionStepdefinition {

    private String ESTADO = "ESTADO";


    @Given("^el (.*) abre la app GanaMovil$")
    public void elUsuarioAbreLaAppGanaMovil(String actor) {
        theActorCalled(actor).wasAbleTo(
                AbreLaApp.exitosamente()
        );
    }

    @When("^realiza el login con sus credenciales$")
    public void realizaElLoginConSusCredenciales(DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        Map<String, Object> condicionesEliminar = new HashMap<>();
        Map<String, Object> condicionesDesbloquear = new HashMap<>();
        Map<String, Object> valores = new HashMap<>();
        condicionesEliminar.put("codusuario", filas.get(0).get("usuario"));
        condicionesDesbloquear.put("CANAL", 1);
        condicionesDesbloquear.put("CANAL", 1);
        condicionesDesbloquear.put("CODUSUARIO",filas.get(0).get("usuario"));
        valores.put(ESTADO, "A");
        theActorInTheSpotlight().attemptsTo(
               EliminarRegistro.deTabla("CAS_USUARIOXCANAL", condicionesEliminar, "GANADERO"),
                EjecutarBaseDeDatos.Actualizar("GANANET.CAS_CONTROLESXCANAL",condicionesDesbloquear,valores,"GANADERO"),
                InicioSesion.go(UsuarioModel.setData(dataTable).get(0))
        );
    }

    @When("^realiza nuevamente el login con sus credenciales$")
    public void realizaNuevamenteElLoginConSusCredenciales(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                InicioSesion.go(UsuarioModel.setData(dataTable).get(0)),
                EsperaExplicita.empleada(10000)
        );
    }

    @When("^se habilita el dispositivo internamente (.*)$")
    public void realizaElLoginConCredenciales(String usuario) {
        Map<String, Object> valores = new HashMap<>();
        Map<String, Object> condiciones = new HashMap<>();
        valores.put(ESTADO, "A");
        condiciones.put(ESTADO, "P");
        condiciones.put("CODUSUARIO", usuario);
        theActorInTheSpotlight().attemptsTo(
                HabilitarMovil.happy(),
                EsperaExplicita.empleada(10000),
                EjecutarBaseDeDatos.Actualizar("GANANET.CAS_USUARIOXCANAL",condiciones,valores,"GANADERO")
        );
    }

    @When("^acepta solicitud de habilitación$")
    public void aceptaSolicitudDeHabilitación() {
       theActorInTheSpotlight().attemptsTo(
               HabilitarMovil.go()
       );
    }

    @Given("^se desbloquea el usuario (.*)$")
    public void seDesbloqueaElUsuario(String usuario) {
        Map<String, Object> condicionesUpdate = new HashMap<>();
        Map<String, Object> valoresUpdate1 = new HashMap<>();
        condicionesUpdate.put("CODUSUARIO", usuario );
        condicionesUpdate.put("CANAL", 1 );
        valoresUpdate1.put("ESTADO", "A");
        valoresUpdate1.put("NROINTENTOS", "0");
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.Actualizar("CAS_CONTROLESXCANAL",condicionesUpdate,valoresUpdate1,"GANANET")
        );
    }

    @Then("^debería ver el nombre de usuario (.*)$")
    public void deberiaVerElNombreDelUsuario(String nombre) {
        theActorInTheSpotlight().should(seeThat(Questions.VALIDAR_INICIO_DE_SESION,ValidarTextos.textosDelFrontEnd(UiIniciarSesion.LBL_PERSONA, nombre))
                .orComplainWith(Errors.class, Errors.sinVerificarIngreso()));
    }

    @Then("^debería ver el siguiente texto (.*)$")
    public void deberiaVerElSiguienteTexto(String title) {
        theActorInTheSpotlight().should(seeThat(Questions.VALIDAR_ALERTA_DE_DATOS_ERRADOS,ValidarTextos.textosDelFrontEnd(UiIniciarSesion.LBL_MODAL_DATOS_INVALIDOS, title))
                .orComplainWith(Errors.class, Errors.sinVerificarError()));
    }

    @Then("^debería ver la alerta de confirmación (.*)$")
    public void deberiaVerLaAlertaDeConfirmacion(String texto) {
        theActorInTheSpotlight().should(seeThat(Questions.VALIDAR_MODAL_HABILITAR_CELULAR, ValidarTextos.textosDelFrontEnd(UiIniciarSesion.LBL_MODAL_HABILITACION, texto))
                .orComplainWith(Errors.class, Errors.sinVerificarHabilitacion()));
    }

    @Then("^debería ver la cantidad del saldo (\\d+)$")
    public void deberíaVerLaCantidadDelSaldo(String saldo) {
        theActorInTheSpotlight().should(seeThat(Questions.VALIDAR_EL_SALDO_CORRESPONDIENTE, ValidarSaldo.enBaseDeDatos(saldo))
                .orComplainWith(Errors.class, Errors.sinVerificarSaldo()));
    }

    @Then("^debería ver el mensaje de error (.*)$")
    public void deberíaVerElMensajeDeErrorDatosInválidos(String title) {
        theActorInTheSpotlight().attemptsTo(EsperaExplicita.empleada(18000));
        theActorInTheSpotlight().should(seeThat(Questions.VALIDAR_ALERTA_DE_DATOS_ERRADOS,ValidarTextos.textosDelFrontEnd(UiIniciarSesion.LBL_MODAL_DATOS_INVALIDOS, title))
                .orComplainWith(Errors.class, Errors.sinVerificarError()));
    }


}
