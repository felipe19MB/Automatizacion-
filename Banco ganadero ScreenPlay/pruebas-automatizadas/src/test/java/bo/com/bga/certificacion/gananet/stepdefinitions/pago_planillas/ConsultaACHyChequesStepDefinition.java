package bo.com.bga.certificacion.gananet.stepdefinitions.pago_planillas;

import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.GenerarExtractoModel;
import bo.com.bga.certificacion.gananet.models.pago_planillas.ConsultaACHyChequesModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionVariosCampos;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.pago_planillas.LlenarInformacionACHyCheques;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ACHyChequesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.Collection;

import static bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.GenerarExtractosPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_PLANILLA_ESTADO_RECHAZADO;
import static bo.com.bga.certificacion.gananet.utils.DataTableConverter.convert;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ConsultaACHyChequesStepDefinition {

    @When("Ingresa los campos para la consulta ACH y cheques")
    public void ingresaLosCamposParaLaConsultaACHYCheques(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_PLANILLA_ESTADO_RECHAZADO,"resultadosObtenidos", "GANADERO")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarInformacionACHyCheques.go(ConsultaACHyChequesModel.setData(dataTable).get(0))
        );
    }

    @Then("Deberia ver el registro generado de la consulta")
    public void deberiaVerElRegistroGeneradoDeLaConsulta(DataTable dataTable) {
        ConsultaACHyChequesModel consultaACHyChequesModel = ConsultaACHyChequesModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "se verifica el convenio de la consulta ", VerificarConfirmaciones.go(consultaACHyChequesModel.getConvenio(),ACHyChequesPage.VALIDACION_CONVENIO)
                ),
                seeThat(
                        "se verifica el lote de la consulta", VerificarConfirmaciones.go(consultaACHyChequesModel.getLote(),ACHyChequesPage.VALIDACION_LOTE)
                ),
                seeThat(
                        "se verifica el numero de planilla de la consulta", VerificarConfirmaciones.go(consultaACHyChequesModel.getNroPlanilla(),ACHyChequesPage.VALIDACION_NRO_PLANILLA)

                ),
                seeThat(
                        "se verifica el numero de identificacion de la consulta", VerificarConfirmaciones.go(consultaACHyChequesModel.getNroIdentificacion(),ACHyChequesPage.VALIDACION_NRO_IDENTIFICACION)

                )
                );
    }
}
