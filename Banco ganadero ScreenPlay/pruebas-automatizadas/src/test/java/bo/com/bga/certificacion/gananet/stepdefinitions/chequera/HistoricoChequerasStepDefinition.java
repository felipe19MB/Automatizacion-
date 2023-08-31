package bo.com.bga.certificacion.gananet.stepdefinitions.chequera;

import bo.com.bga.certificacion.gananet.models.chequeras.HistoricoChequeraModel;
import bo.com.bga.certificacion.gananet.models.pago_planillas.ConsultaACHyChequesModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatosInterfaz;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.chequeras.historico_chequeras.ConsultarHistoricoChequeras;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.chequeras.ConciliacionChequeraPage;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ACHyChequesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.HistoricoChequeraPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_HISTORICO_CHEQUERAS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class HistoricoChequerasStepDefinition {

    @When("ingresa la cuenta y el periodo para el historico")
    public void ingresaLaCuentaYElPeriodoParaElHistorico(DataTable dataTable) {
        HistoricoChequeraModel historicoChequeraModel= HistoricoChequeraModel.setData(dataTable).get(0);
        System.out.println(QUERY_CONSULTAR_HISTORICO_CHEQUERAS+historicoChequeraModel.getCuentaOrigen()+
                        "AND FECHAINGRESO BETWEEN TO_DATE('"+historicoChequeraModel.getPeriodoInicio()+"', 'DD/MM/YYYY') AND TO_DATE('"+historicoChequeraModel.getPeriodoFin()+"', 'DD/MM/YYYY') ORDER BY NROSOLICITUD ASC");
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_HISTORICO_CHEQUERAS+historicoChequeraModel.getCuentaOrigen()+
                        "AND FECHAINGRESO BETWEEN TO_DATE('"+historicoChequeraModel.getPeriodoInicio()+"', 'DD/MM/YYYY') AND TO_DATE('"+historicoChequeraModel.getPeriodoFin()+"', 'DD/MM/YYYY') ORDER BY NROSOLICITUD ASC",
                        "HISTORICOCHEQUERAS","AUTOSRV").
                        Comentario("Se ejecuta query para obtener la información de" +
                        "las solicitudes en base de datos para la tabla CHE_CHEQSOLICITUD")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConsultarHistoricoChequeras.go(HistoricoChequeraModel.setData(dataTable).get(0),"HappyPath")
        );
    }
    @Then("Deberia poder ver el historico según el periodo seleccionado")
    public void deberiaPoderVerElHistoricoSegúnElPeriodoSeleccionado(DataTable dataTable) {
        HistoricoChequeraModel historicoChequeraModel= HistoricoChequeraModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "se verifica la cuenta del registro ", VerificarConfirmaciones.go(historicoChequeraModel.getCuentaOrigen(),VALIDACIONES_HISTORICO_CHQUES.of(historicoChequeraModel.getCuentaOrigen()))
                )

        );

    }

}

