package bo.com.bga.certificacion.gananet.stepdefinitions.configuracion_y_seguridad;

import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ActualizacionDeDatosModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.actualizacion_de_datos.ActualizarDatosPersonales;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.MENSAJE_CAMBIO_DE_DATOS;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ActualizacionDeDatosStepDefinition {
    @When("actualiza sus datos personales")
    public void actualizaSusDatosPersonales(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZACION_DATOS_USUARIO,"resultado","GANADERO").Comentario("SE restablece los datos del usuario en DB"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZACION_DATOS_USUARIO_PREFERIDOS2,"resultado","GANADERO").Comentario("Se restablece los datos del referido 1 en BD"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZACION_DATOS_USUARIO_PREFERIDOS1,"resultado","GANADERO").Comentario("Se restablece los datos del referido 2 en BD")
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                ActualizarDatosPersonales.go(ActualizacionDeDatosModel.setData(dataTable).get(0),"HappyPath")
        );
    }

    @Then("Deberia poder ver {string} de cambio exitoso y los datos actualizados en base de datos")
    public void deberiaPoderVerDeCambioExitosoYLosDatosActualizadosEnBaseDeDatos(String mensaje,DataTable dataTable) {
        ActualizacionDeDatosModel actualizacionDeDatosModel = ActualizacionDeDatosModel.setData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de la actualizacion de datos exitosa", ValidacionString.esCorrecta(mensaje,"mensajeActualizacion")

                )
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el apartamento  en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getApartamento(),"APARTAMENTO","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el barrio en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getBarrio(),"BARRIOZONA","resultadoDatosPersonales")

                ),
                seeThat("Se verifica la calle en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getCalle(),"CALLE","resultadoDatosPersonales")

                ),
                seeThat("Se verifica la ciudad en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getCiudad(),"CIUDAD","resultadoDatosPersonales")

                ),
                seeThat("Se verificael celular en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getCelular(),"CELULAR","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el email en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getEmail(),"EMAIL","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el piso en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getPiso(),"PISO","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el UV en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getUv(),"UV","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el MZA en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getMza(),"MANZANO","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el telefono en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getTelefono(),"TELEFONOS","resultadoDatosPersonales")

                ),
                seeThat("Se verifica el  nombre del referido 1 en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getNombreRef1(),"NOMBRE","resultadoDatosReferidos1")

                ),
                seeThat("Se verifica el nombre del referido 2 en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getNombreRef2(),"NOMBRE","resultadoDatosReferidos2")

                ),
                seeThat("Se verificael telefono del referido 1 en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getTelefonoRef1(),"TELEFONOS","resultadoDatosReferidos1")

                ),
                seeThat("Se verifica telefono del referido 2 en base de datos", ValidacionBaseDeDatos.esCorrecta(actualizacionDeDatosModel.getTelefonoRef2(),"TELEFONOS","resultadoDatosReferidos2")

                )
        );

    }
}
