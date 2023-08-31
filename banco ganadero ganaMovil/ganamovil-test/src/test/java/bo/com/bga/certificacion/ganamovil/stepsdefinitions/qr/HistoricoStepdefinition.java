package bo.com.bga.certificacion.ganamovil.stepsdefinitions.qr;

import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.questions.shared.ElementoVisible;
import bo.com.bga.certificacion.ganamovil.tasks.qr.Historico;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.qr.UiCobrar.GRUPO_GISTORICO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HistoricoStepdefinition {
    @When("^selecciona el módulo histórico$")
    public void seleccionaElMóduloHistórico() {
        theActorInTheSpotlight().attemptsTo(
                Historico.seleccionar()
        );
    }


    @Then("^válida que el sistema genera un histórico (.*)$")
    public void válidaQueElSistemaGeneraUnHistórico(String cuentaorigen) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_HISTORIAL_QR, ElementoVisible.validar(GRUPO_GISTORICO))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }
}
