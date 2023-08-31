package bo.com.bga.certificacion.gananet.stepdefinitions.chequera;

import bo.com.bga.certificacion.gananet.models.chequeras.ConciliacionChequeraModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.chequeras.conciliacion_chequera.RevisarConciliacionChequera;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.chequeras.ConciliacionChequeraPage;
import bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.OrdenDeCobroPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_CONCILIACION_CHEQUERA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class ConciliacionChequesStepDefinition {


    @When("ingresa la cuenta y el periodo de la conciliacion")
    public void ingresaLaCuentaYElPeriodoDeLaConciliacion(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RevisarConciliacionChequera.go(ConciliacionChequeraModel.setData(dataTable).get(0),"HappyPath")

        );


    }

    @Then("Deberia poder ver la conciliaciones de las chequeras")
    public void deberiaPoderVerLaConciliacionesDeLasChequeras(DataTable dataTable) {
        ConciliacionChequeraModel conciliacionChequeraModel= ConciliacionChequeraModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_CONCILIACION_CHEQUERA+conciliacionChequeraModel.getCuentaOrigen()+" AND NUMEROCHEQUE= "+ conciliacionChequeraModel.getNroCheque(),"resultadoConciliacionCheques","GANADERO").
                        Comentario("Se realiza la consulta de la conciliacion de cheques emitidos")
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica la confimracion en linea", WebElementQuestion.the(ConciliacionChequeraPage.VALIDACIONES_CONCILIACION.of(conciliacionChequeraModel.getConfirmacion())), isCurrentlyVisible()
                ),
                seeThat("Se verifica el numero de cuenta en base de datos", ValidacionBaseDeDatos.esCorrecta(conciliacionChequeraModel.getCuentaOrigen(), "CUENTA","resultadoConciliacionCheques")
                ),
                seeThat("Se verifica el numero de cheque en base de datos", ValidacionBaseDeDatos.esCorrecta(conciliacionChequeraModel.getNroCheque(), "NUMEROCHEQUE","resultadoConciliacionCheques")
                ),
                seeThat("Se verifica el monto  en base de datos", ValidacionBaseDeDatos.esCorrecta(conciliacionChequeraModel.getMonto(), "IMPORTE","resultadoConciliacionCheques")
                ),
                seeThat("Se verifica la referencia en base de datos", ValidacionBaseDeDatos.esCorrecta(conciliacionChequeraModel.getEstado(), "ESTADO","resultadoConciliacionCheques")
                )
        );

    }
}
