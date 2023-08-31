package bo.com.bga.certificacion.gananet.stepdefinitions.configuracion_y_seguridad;


import bo.com.bga.certificacion.gananet.models.autorizaciones.AutorizacionSolicitudModel;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ActualizacionDeDatosModel;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ConfigurarPerfilModel;
import bo.com.bga.certificacion.gananet.models.shared.DatosIngreso;
import bo.com.bga.certificacion.gananet.models.shared.DatosRutaFuncionalidad;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.actualizacion_de_datos.ActualizarDatosPersonales;
import bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.configurar_perfil.ConfigurarPerfil;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ConfigurarPerfilStepDefinition {
    @When("Configura el perfil")
    public void configuraElPerfil(DataTable dataTable) {
        ConfigurarPerfilModel configurarPerfilModel = ConfigurarPerfilModel.setData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfigurarPerfil.go(ConfigurarPerfilModel.setData(dataTable).get(0),"HappyPath")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_CONFIGURAR_PERFIL+configurarPerfilModel.getUsuario(),"resultadoDatosConfiguracion","GANADERO").Comentario("Se ejecuta el query para obtener el alias de la consulta"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZAR_ALIAS_CONFIGURAR_PERFIL +configurarPerfilModel.getUsuario() ,"resultado","GANADERO").Comentario("Se restablece el alias del usuario"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZAR_IMAGEN_CONFIGURAR_PERFIL +configurarPerfilModel.getUsuario(),"resultado","GANADERO").Comentario("Se restablece la imagen del usuario")
        );

    }

    @Then("Deberia poder ver {string} de cambio exitoso de los datos y el {string} de alias disponible")
    public void deberiaPoderVerDeCambioExitosoDeLosDatosYElDeAliasDisponible(String mensaje, String texto) {
        String alias = OnStage.theActorInTheSpotlight().recall("alias").toString();
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de cambio de datos exitosa", ValidacionString.esCorrecta(mensaje,"mensajeCambioDatos")
                ),
                seeThat("Se el texto de alias disponible", ValidacionString.esCorrecta(texto,"mensajeAlias")
                )

        );
    }
}
