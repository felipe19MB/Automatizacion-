package bo.com.bga.certificacion.gananet.stepdefinitions.atencion_al_cliente;

import bo.com.bga.certificacion.gananet.interactions.shared.FechaActual;
import bo.com.bga.certificacion.gananet.models.atencion_al_cliente.RegistrarReclamoModel;
import bo.com.bga.certificacion.gananet.models.shared.DatosRutaFuncionalidad;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.atencion_al_cliente.registrar_reclamo.RegistrarReclamo;
import bo.com.bga.certificacion.gananet.tasks.atencion_al_cliente.estado_reclamo.RevisarEstadoReclamo;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresarAFuncionalidad;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente.RegistrarReclamoPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class RegistrarReclamoStepDefinition {

    @When("registra un reclamo")
    public void registraUnReclamo(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarReclamo.go(RegistrarReclamoModel.setData(dataTable).get(0),"HappyPath")
        );
    }


    @And("visualiza el estado del reclamo por el tipo {string}")
    public void visualizaElEstadoDelReclamoPorElTipo(String tipo,DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAFuncionalidad.go(DatosRutaFuncionalidad.setData(dataTable).get(0))
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                RevisarEstadoReclamo.go(tipo,"HappyPath")

        );

    }

    @Then("deberia ver el reclamo listado en estado de reclamos")
    public void deberiaVerElReclamoListadoEnEstadoDeReclamos(DataTable dataTable) {
        RegistrarReclamoModel registrarReclamoModel= RegistrarReclamoModel.setData(dataTable).get(0);
        String numeroReclamo = OnStage.theActorInTheSpotlight().recall("numeroReclamo");
        String claveUnica = OnStage.theActorInTheSpotlight().recall("claveUnica");
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de creacion del registro del reclamo", ValidacionString.esCorrecta(registrarReclamoModel.getMensaje(),"mensajeReclamo")

                ),
                seeThat("Se verifica la fecha del registro del reclamo", VerificarConfirmaciones.go(FechaActual.obtenerFechaActual(),VALIDACIONES.of(FechaActual.obtenerFechaActual()))

                ),
                seeThat("Se verifica el tipo de registro del reclamo", VerificarConfirmaciones.go(registrarReclamoModel.getTipoReclamo(),VALIDACIONES.of(registrarReclamoModel.getTipoReclamo()))

                ),
                seeThat("Se verifica el monto del registro del reclamo", VerificarConfirmaciones.go(registrarReclamoModel.getMonto(),VALIDACION_MONTO)

                ),
                seeThat("Se verifica la moneda del registro del reclamo",VerificarConfirmaciones.go(registrarReclamoModel.getMoneda(),VALIDACION_MONEDA)

                ),
                seeThat("Se verifica el numero del registro del reclamo en base de datos", ValidacionBaseDeDatos.esCorrecta(numeroReclamo,"NRO_RECLAMO_ASFI","resultadoBDRegistrarReclamo")

                ),
                seeThat("Se verifica el estado  del reclamo en base de datos", ValidacionBaseDeDatos.esCorrecta("ATENCION","ESTADO_RECLAMO_DESC","resultadoBDRegistrarReclamo")

                ),
                seeThat("Se verifica la descripcion  del reclamo en base de datos", ValidacionBaseDeDatos.esCorrecta(registrarReclamoModel.getDescripcion()+claveUnica,"DESCRIPCION","resultadoBDRegistrarReclamo")

                )



        );
    }
}
