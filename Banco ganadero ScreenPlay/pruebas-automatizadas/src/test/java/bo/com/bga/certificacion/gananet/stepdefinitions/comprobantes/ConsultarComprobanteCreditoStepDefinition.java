package bo.com.bga.certificacion.gananet.stepdefinitions.comprobantes;


import bo.com.bga.certificacion.gananet.interactions.shared.FechaActual;
import bo.com.bga.certificacion.gananet.models.comprobantes.DatosConsultaComprobanteCredito;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.comprobantes.consulta.LlenarInformacionConsultaComprobanteCredito;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ConsultaComprobanteCreditoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.interactions.shared.Utilidades.extraerFecha;
import static bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente.RegistrarReclamoPage.VALIDACIONES;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ConsultarComprobanteCreditoStepDefinition {

    @When("Consulta un comprobante de credito")
    public void consultaUnComprobanteDeCredito (DataTable dataTable) {
        DatosConsultaComprobanteCredito datosConsultaComprobanteCredito = DatosConsultaComprobanteCredito.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarInformacionConsultaComprobanteCredito.go(DatosConsultaComprobanteCredito.setData(dataTable).get(0))
                );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_COMPROBANTE_CREDITO+datosConsultaComprobanteCredito.getNroCuenta()+" AND ASIENTO = "+datosConsultaComprobanteCredito.getNroAsiento(),"resultadoComprobanteCredito","GANADERO").Comentario(
                        "Se ejecuta el query para obtener la consulta del comprobante de credito")
        );
    }

    @Then("Deberia ver un comprobante con los datos del credito realizado")
    public void deberiaVerUnComprobanteConLosDatosDelCreditoRealizado(DataTable dataTable) {
        DatosConsultaComprobanteCredito datosConsultaComprobanteCredito = DatosConsultaComprobanteCredito.setData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica la descripcion del proceso en base de datos", ValidacionBaseDeDatos.esCorrecta(datosConsultaComprobanteCredito.getGlosa(),"CONCEPTO","resultadoComprobanteCredito")
                ),

                seeThat("Se verifica el asiento del proceso en base de datos", ValidacionBaseDeDatos.esCorrecta(datosConsultaComprobanteCredito.getNroAsiento(),"ASIENTO","resultadoComprobanteCredito")
                ),

                seeThat("Se verifica la cuenta del proceso en base de datos", ValidacionBaseDeDatos.esCorrecta(datosConsultaComprobanteCredito.getNroCuenta(),"CUENTA","resultadoComprobanteCredito")
                ),

                seeThat("Se verifica el importe del proceso en base de datos", ValidacionBaseDeDatos.esCorrecta(datosConsultaComprobanteCredito.getImporte(),"CAPITALREALIZADO","resultadoComprobanteCredito")
                ),

                seeThat("Debería ver cuenta de origen",
                        WebElementQuestion.the(ConsultaComprobanteCreditoPage.ASSERT_CUENTA_ORIGEN),isCurrentlyVisible()
                )

        );

    }
}


