package bo.com.bga.certificacion.gananet.stepdefinitions.instituciones;

import bo.com.bga.certificacion.gananet.models.instituciones.TransaccionesPorFechaModel;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.instituciones.reporte_de_instituciones.GenerarTransaccionesPorFecha;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.userinterfaces.instituciones.TransaccionesPorFechaPage.VALIDACION_TRANSACCIONES_FECHA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class TransaccionesPorFechaStepDefinitions {

    @When("Genera las transacciones agrupadas por fecha")
    public void generaLasTransaccionesAgrupadasPorFecha(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GenerarTransaccionesPorFecha.go(TransaccionesPorFechaModel.setData(dataTable).get(0),"HappyPath")
        );

    }

    @Then("Deberia ver el registro generado para la fecha seleccionada")
    public void deberiaVerElRegistroGeneradoParaLaFechaSeleccionada(DataTable dataTable) {
        TransaccionesPorFechaModel transaccionesPorFechaModel= TransaccionesPorFechaModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getNumeroTransaccion(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getNumeroTransaccion()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getUsr(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getUsr()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getCurso(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getCurso()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getConcepto(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getConcepto()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getCodigo(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getCodigo()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getNombre(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getNombre()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getCuota(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getCuota()))
                ),
                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorFechaModel.getMonto(),VALIDACION_TRANSACCIONES_FECHA.of(transaccionesPorFechaModel.getMonto()))
                )


        );
    }
}
