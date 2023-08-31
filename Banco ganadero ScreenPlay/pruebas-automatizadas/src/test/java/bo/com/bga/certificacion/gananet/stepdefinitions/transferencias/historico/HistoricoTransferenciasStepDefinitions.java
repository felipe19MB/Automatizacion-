package bo.com.bga.certificacion.gananet.stepdefinitions.transferencias.historico;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosHistoricos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionVariosCampos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionVariosCamposDe;
import bo.com.bga.certificacion.gananet.tasks.transferencias.historico.LlenarHistoricoCuentasExterior;
import bo.com.bga.certificacion.gananet.tasks.transferencias.historico.LlenarHistoricoCuentasOtrosBancos;
import bo.com.bga.certificacion.gananet.tasks.transferencias.historico.LlenarHistoricoCuentasPropias;
import bo.com.bga.certificacion.gananet.tasks.transferencias.historico.LlenarHistoricoCuentasTerceros;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.HistoricoPage;
import bo.com.bga.certificacion.gananet.utils.VerificarCamposNulos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.Collection;

import static bo.com.bga.certificacion.gananet.userinterfaces.transferencias.HistoricoPage.VALIDACIONES;
import static bo.com.bga.certificacion.gananet.utils.DataTableConverter.convert;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HistoricoTransferenciasStepDefinitions {


    @When("Ingresa los campos para generar el historico de cuentas propias")
    public void ingresaLosCamposParaGenerarElHistoricoDeCuentasPropias(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarHistoricoCuentasPropias.go("HappyPath",DatosHistoricos.setData(dataTable).get(0))
        );
    }

    @When("Ingresa los campos para generar el historico de cuentas para terceros")
    public void ingresaLosCamposParaGenerarElHistoricoDeCuentasDeTerceros(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarHistoricoCuentasTerceros.go("HappyPath",DatosHistoricos.setData(dataTable).get(0))
        );
    }
    @When("Ingresa los campos para generar el historico de cuentas de otros bancos")
    public void ingresaLosCamposParaGenerarElHistoricoDeCuentasDeOtrosBancos(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarHistoricoCuentasOtrosBancos.go("HappyPath",DatosHistoricos.setData(dataTable).get(0))
        );
    }

    @Then("Deberia ver el registro generado por la consulta del historico para el siguiente numero de transaccion: {string}")
    public void deberiaVerElRegistroGeneradoPorLaConsultaDelHistoricoParaElSiguiente(String numeroTransaccion,DataTable dataTable) {
        Collection<String> datos = convert(dataTable.rows(1));
        VerificarCamposNulos.getCollection(datos);
        System.out.println(datos);
        OnStage.theActorInTheSpotlight().should(
                seeThat("reviso que todos los campos correspondan a la consulta generada", ValidacionVariosCamposDe.go(datos,HistoricoPage.VALIDACIONES,numeroTransaccion), Matchers.is(true))
        );
    }
    @When("Ingresa los campos para generar el historico de cuentas del exterior")
    public void ingresaLosCamposParaGenerarElHistoricoDeCuentasDelExterior(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarHistoricoCuentasExterior.go("HappyPath",DatosHistoricos.setData(dataTable).get(0))
        );
    }

}

