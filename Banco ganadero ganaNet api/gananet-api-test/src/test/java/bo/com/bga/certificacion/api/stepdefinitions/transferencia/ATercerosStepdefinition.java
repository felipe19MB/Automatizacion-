package bo.com.bga.certificacion.api.stepdefinitions.transferencia;

import bo.com.bga.certificacion.api.models.transferencia.ATercerosModel;
import bo.com.bga.certificacion.api.tasks.transferencia.ATerceros.ServicioEliminarTercero;
import bo.com.bga.certificacion.api.tasks.transferencia.EjecuarTransferencia;
import bo.com.bga.certificacion.api.tasks.transferencia.preCondicion.InsertarCuenta;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ATercerosStepdefinition {

    @When("Llama al endpoint realizar transacción a tercero con cuenta no afiliada")
    public void llamaAlEndpointRealizarTransaccionATerceroConCuentaNoAfiliada(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                EjecuarTransferencia.transferencia(ATercerosModel.setDataId(dataTable))
        );

    }

/*    @When("Llama al endpoint eliminar cuenta de tercero con un numero de cuenta que ya esta registrado")
    public void llamaAlEndpointEliminarCuentaDeTerceroConUnNumeroDeCuentaQueYaEstaRegistrado(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                InsertarCuenta.cuentaTercero(),
            ServicioEliminarTercero.service(ATercerosModel.setDataEliminar(dataTable))
        );
    }*/
}
