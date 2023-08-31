package bo.com.bga.certificacion.gananet.stepdefinitions.orden_cobro_simple;

import bo.com.bga.certificacion.gananet.models.comprobantes.DatosConsultaComprobanteCredito;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.OrdenDeCobroModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.orden_cobro_simple.orden_de_cobro.GenerarOrdenDeCobro;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ServiciosBasicosPage;
import bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.OrdenDeCobroPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_ORDEN_DE_COBRO_SIMPLE;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class OrdenDeCobroStepDefinition {
    @When("genera la orden de cobro")
    public void generaLaOrdenDeCobro(DataTable dataTable) {
        OrdenDeCobroModel ordenDeCobroModel = OrdenDeCobroModel.setData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                GenerarOrdenDeCobro.go(OrdenDeCobroModel.setData(dataTable).get(0),"HappyPath")
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_ORDEN_DE_COBRO_SIMPLE +" '"+
                        ordenDeCobroModel.getNroCuenta()+"'"+" AND CODIGO_PERSONA = "+" '"+ ordenDeCobroModel.getUsuario()+"'"+" AND ESTADO = '2') subquery WHERE rn = 1",
                        "resultadoOrdenDeCobro","GANADERO").Comentario("se ejecuta el query para optener el los datos de la orden de cobro")
        );

    }

    @Then("Deberia ver el codigo qr generado correctamente")
    public void deberiaVerElCodigoQrGeneradoCorrectamente( DataTable dataTable) {
        String claveUnica = OnStage.theActorInTheSpotlight().recall("claveUnicaOrdenDeCobro");
        OrdenDeCobroModel ordenDeCobroModel = OrdenDeCobroModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica la creacion del qr", WebElementQuestion.the(OrdenDeCobroPage.VALIDACION_IMAGEN_QR), isCurrentlyVisible()
                ),
                seeThat("Se verifica el numero de cuenta en base de datos", ValidacionBaseDeDatos.esCorrecta(ordenDeCobroModel.getNroCuenta(),"NRO_CUENTA","resultadoOrdenDeCobro")
                ),
                seeThat("Se verifica el monto  en base de datos", ValidacionBaseDeDatos.esCorrecta(ordenDeCobroModel.getMonto(),"MONTO","resultadoOrdenDeCobro")
                ),
                seeThat("Se verifica la referencia en base de datos", ValidacionBaseDeDatos.esCorrecta(claveUnica,"REFERENCIA","resultadoOrdenDeCobro")
                )
        );

    }


}
