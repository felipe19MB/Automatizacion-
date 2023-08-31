package bo.com.bga.certificacion.ganamovil.stepsdefinitions.shared;

import bo.com.bga.certificacion.ganamovil.interactions.database.EliminarRegistro;
import bo.com.bga.certificacion.ganamovil.interactions.utils.EsperaExplicita;
import bo.com.bga.certificacion.ganamovil.models.UsuarioModel;
import bo.com.bga.certificacion.ganamovil.tasks.shared.AbreLaApp;
import bo.com.bga.certificacion.ganamovil.tasks.acceso.HabilitarMovil;
import bo.com.bga.certificacion.ganamovil.tasks.acceso.InicioSesion;
import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import bo.com.bga.certificacion.ganamovil.tasks.shared.Navegar;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class sharedStepdefinition {

    @Given("^el (.*) inicia Sesión en GanaMovil$")
    public void elUsuarioIniciaSesionEnGanaMovil(String actor, DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);
        Map<String, Object> condicionesDelete = new HashMap<>();
        Map<String, Object> valores = new HashMap<>();
        Map<String, Object> condiciones = new HashMap<>();
        condicionesDelete.put("codusuario", filas.get(0).get("usuario"));
        valores.put("ESTADO", "A");
        condiciones.put("ESTADO", "P");
        condiciones.put("CODUSUARIO", filas.get(0).get("usuario"));
        theActorCalled(actor).wasAbleTo(
                EliminarRegistro.deTabla("CAS_USUARIOXCANAL", condicionesDelete, "GANADERO"),
                AbreLaApp.exitosamente(),
                InicioSesion.go(UsuarioModel.setData(dataTable).get(0)),
                HabilitarMovil.happy(),
                EsperaExplicita.empleada(10000),
                EjecutarBaseDeDatos.Actualizar("CAS_USUARIOXCANAL",condiciones,valores,"GANADERO"),
                InicioSesion.go(UsuarioModel.setData(dataTable).get(0))
        );
    }

    @Given("^navega hasta el módulo$")
    public void navegoHastaElModuloTransferir(DataTable dataTable) {
        List<List<String>> userDataList = dataTable.asLists(String.class);
        theActorInTheSpotlight().wasAbleTo(
                Navegar.menu(userDataList.get(0))
        );
    }
}
