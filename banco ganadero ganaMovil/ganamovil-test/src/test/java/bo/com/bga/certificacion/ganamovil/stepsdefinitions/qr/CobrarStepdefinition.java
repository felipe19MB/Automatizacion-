package bo.com.bga.certificacion.ganamovil.stepsdefinitions.qr;

import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.models.QrModel;
import bo.com.bga.certificacion.ganamovil.questions.shared.ElementoVisible;
import bo.com.bga.certificacion.ganamovil.tasks.qr.Cobrar;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static bo.com.bga.certificacion.ganamovil.userinterfaces.qr.UiCobrar.IMG_QR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CobrarStepdefinition {

    @When("^selecciona la información necesaria para generar el código QR$")
    public void seleccionaLaInformaciónNecesariaParaGenerarElCódigoQR(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Cobrar.cobrar(QrModel.setData(dataTable).get(0))
        );
    }

    @Then("^válida que el sistema genera un código QR válido$")
    public void válidaQueElSistemaGeneraUnCódigoQRVálido() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_QR_EXITOSO, ElementoVisible.validar(IMG_QR))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }
}
