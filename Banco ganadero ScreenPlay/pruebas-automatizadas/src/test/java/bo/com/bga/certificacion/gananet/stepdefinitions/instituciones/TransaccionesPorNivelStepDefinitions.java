package bo.com.bga.certificacion.gananet.stepdefinitions.instituciones;

import bo.com.bga.certificacion.gananet.models.instituciones.TransaccionesPorFechaModel;
import bo.com.bga.certificacion.gananet.models.instituciones.TransaccionesPorNivelModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidarTarget;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.instituciones.reporte_de_instituciones.GenerarTransaccionesPorFecha;
import bo.com.bga.certificacion.gananet.tasks.instituciones.reporte_de_instituciones.GenerarTransaccionesPorNivel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.boletas_garantía.BoletasProcesadasPage.VALIDACIONES_BOLETAS;
import static bo.com.bga.certificacion.gananet.userinterfaces.instituciones.TransaccionesPorFechaPage.VALIDACION_TRANSACCIONES_FECHA;
import static bo.com.bga.certificacion.gananet.userinterfaces.instituciones.TransaccionesPorNivelPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransaccionesPorNivelStepDefinitions {

    @When("Genera las transacciones agrupadas por nivel")
    public void generaLasTransaccionesAgrupadasPorNivel(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GenerarTransaccionesPorNivel.go(TransaccionesPorNivelModel.setData(dataTable).get(0),"HappyPath")
        );

    }


    @Then("Deberia ver el registro generado para el nivel seleccionado")
    public void deberiaVerElRegistroGeneradoParaElNivelSeleccionado( DataTable dataTable) {
        TransaccionesPorNivelModel transaccionesPorNivelModel= TransaccionesPorNivelModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(

                seeThat("Debería ver el año de gestion de la transaciones por nivel",
                        WebElementQuestion.the(VALIDACION_TRANS_NIVEL_CABEZA.of(transaccionesPorNivelModel.getGestion())), isCurrentlyVisible()
                ),
                seeThat("Debería ver el nivel de la transaciones por nivel",
                        WebElementQuestion.the(VALIDACION_TRANS_NIVEL_CABEZA.of(transaccionesPorNivelModel.getNivel())), isCurrentlyVisible()
                ),
                seeThat("Debería ver el codigo de una transacion por nivel",
                        WebElementQuestion.the(VALIDACION_TRANSACCIONES_NIVEL_2.of(transaccionesPorNivelModel.getCodigo())), WebElementStateMatchers.isEnabled()
                ),
                seeThat("Debería el nombre de la persona que realiza la transaccion",
                        WebElementQuestion.the(VALIDACION_TRANSACCIONES_NIVEL_2.of(transaccionesPorNivelModel.getNombre())), WebElementStateMatchers.isEnabled()
                ),

                seeThat(
                        VerificarConfirmaciones.go(transaccionesPorNivelModel.getImporteTotal(),VALIDACION_TRANSACCIONES_NIVEL.of(transaccionesPorNivelModel.getImporteTotal()))
                )

        );
    }
}
