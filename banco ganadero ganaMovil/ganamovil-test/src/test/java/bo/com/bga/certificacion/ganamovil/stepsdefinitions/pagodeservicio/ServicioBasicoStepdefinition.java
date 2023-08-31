package bo.com.bga.certificacion.ganamovil.stepsdefinitions.pagodeservicio;

import bo.com.bga.certificacion.ganamovil.errors.Errors;
import bo.com.bga.certificacion.ganamovil.models.ServicioModel;
import bo.com.bga.certificacion.ganamovil.questions.shared.ValidarTextos;
import bo.com.bga.certificacion.ganamovil.tasks.pagodeservicio.DiligencioServicio;
import bo.com.bga.certificacion.ganamovil.tasks.pagodeservicio.MenuServicio;
import bo.com.bga.certificacion.ganamovil.tasks.pagodeservicio.PreCondicion.DesactivarServicio;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Questions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import java.util.List;

import static bo.com.bga.certificacion.ganamovil.userinterfaces.pagodeservicio.UiAfiliar.LBL_ALERTA_RESPONSE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ServicioBasicoStepdefinition {

    @When("^selecciona el tipo de servicio$")
    public void seleccionaElTipoDeServicio(DataTable dataTable) {
        List<List<String>> userDataList = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(
               MenuServicio.menu(userDataList.get(0), "Afiliar servicio")
        );
        String usuario = theActorInTheSpotlight().recall("usuario");
        theActorInTheSpotlight().attemptsTo(
                DesactivarServicio.desactivar(usuario)
        );
    }

    @When("^diligencia los datos del servicio$")
    public void diligenciaLosDatosDelServicio(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                DiligencioServicio.afiliar(ServicioModel.setData(dataTable).get(0))
        );
    }

    @Then("^válida el registro del servicio (.*)$")
    public void válidoElRegistroDelServicio(String response) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( Questions.VALIDAR_EL_LABEL_DE_LA_AFILIACION_DE_SERVICIO, ValidarTextos.textosDelFrontEnd(LBL_ALERTA_RESPONSE, response))
                        .orComplainWith(Errors.class, Errors.sinVerificarTransaccion())
        );
    }

}
