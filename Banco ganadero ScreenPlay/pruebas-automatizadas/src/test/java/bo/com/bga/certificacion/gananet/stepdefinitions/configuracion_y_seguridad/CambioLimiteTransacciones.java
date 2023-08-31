package bo.com.bga.certificacion.gananet.stepdefinitions.configuracion_y_seguridad;

import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ActualizacionDeDatosModel;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.CambioLimiteTransaccionesModel;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ConfigurarPerfilModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.cambio_limite_transacciones.CambiarLimiteTransacciones;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CambioLimiteTransacciones {


    @When("cambia el limite de transacciones")
    public void cambiaElLimiteDeTransacciones(DataTable dataTable) {
       CambioLimiteTransaccionesModel cambioLimiteTransaccionesModel = CambioLimiteTransaccionesModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                CambiarLimiteTransacciones.go(CambioLimiteTransaccionesModel.setData(dataTable).get(0),"HappyPath")

        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_LIMITE_TRANSACCIONES+cambioLimiteTransaccionesModel.getUsuario()+" AND IDENTIFICADOR= 22572","resultadoDatosCambioLimite","GANADERO").Comentario("Se ejecuta el query para optener el limite de transacciones permitidas"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZAR_LIMITE_TRANSACCIONES  ,"resultado","GANADERO").Comentario("Se restablece el limite de transacciones")
        );
    }

    @Then("Deberia poder ver {string} de cambio de limite exitoso y los datos actualizados en base de datos")
    public void deberiaPoderVerDeCambioDeLimiteExitosoYLosDatosActualizadosEnBaseDeDatos(String mensaje,DataTable dataTable) {
        CambioLimiteTransaccionesModel cambioLimiteTransaccionesModel= CambioLimiteTransaccionesModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de cambio de limite de transaccion exitoso", ValidacionString.esCorrecta(mensaje,"mensajeCambioLimite")
                ),
                seeThat("Se verifica el limite el base de datos", ValidacionBaseDeDatos.esCorrecta(cambioLimiteTransaccionesModel.getNroTransacciones(),"TRANS_DIA_PERMITIDO","resultadoDatosCambioLimite")
                )
        );
    }


}
