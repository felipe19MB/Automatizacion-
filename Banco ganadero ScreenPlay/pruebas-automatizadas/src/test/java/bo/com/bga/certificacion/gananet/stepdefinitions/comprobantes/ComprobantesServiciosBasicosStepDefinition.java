package bo.com.bga.certificacion.gananet.stepdefinitions.comprobantes;

import bo.com.bga.certificacion.gananet.models.comprobantes.ServiciosBasicosModel;
import bo.com.bga.certificacion.gananet.tasks.comprobantes.servicios_basicos.BuscarComprobante;
import bo.com.bga.certificacion.gananet.userinterfaces.comprobantes.ServiciosBasicosPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ComprobantesServiciosBasicosStepDefinition {
    @When("Consulta un comprobante de servicio basico")
    public void consultaUnComprobanteDeServicioBasico(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarComprobante.go(ServiciosBasicosModel.setData(dataTable).get(0),"HappyPath")
        );
    }
    @Then("Deberia ver un comprobante con los datos del servicio pagado")
    public void deberiaVerUnMensajeDeAfiliacionExitosa(DataTable dataTable) {
        ServiciosBasicosModel serviciosBasicosModel = ServiciosBasicosModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de transaccion del pago de servicio",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_NUMERO_TRANSACCION.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la fecha de transaccion del pago de servicio",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_FECHA.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el tipo de transaccion del pago de servicio",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_TIPO.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre del servicio de la transaccion",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_SERVICIO.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la cuenta utilizada en la transaccion del pago de servicio",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_CUENTA.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver importe de la transaccion del pago de servicio",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_IMPORTE.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la moneda de la transaccion del pago de servicio",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_MONEDA.of(serviciosBasicosModel.getNroTransaccion())), isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ServiciosBasicosPage.BOTON_VER.of(serviciosBasicosModel.getNroTransaccion()), isPresent()).forNoMoreThan(25).seconds(),
                JavaScriptClick.on(ServiciosBasicosPage.BOTON_VER.of(serviciosBasicosModel.getNroTransaccion())),
                WaitUntil.the(ServiciosBasicosPage.BOTON_DESCARGAR.of(serviciosBasicosModel.getNroTransaccion()), isClickable()).forNoMoreThan(25).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver la fecha de transaccion del pago de servicio en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_FECHA), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la hora de transaccion del pago de servicio en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_HORA), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la cuenta origen de transaccion en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_CUENTA_ORIGEN), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre del cliente en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_NOMBRE_CLIENTE), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el importe de transaccion del pago de servicio en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_IMPORTE), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre del servicio del pago de servicio en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_NOMBRE_SERVICIO), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre completo del cliente en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_NOMBRE_CLIENTE_PAGO), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la descripcion del pago en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_DESCRIPCION), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver la nota de pie en el comprobante",
                        WebElementQuestion.the(ServiciosBasicosPage.ASSERT_COMPROBANTE_NOTA), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el boton descargar habilitado",
                        WebElementQuestion.the(ServiciosBasicosPage.BOTON_DESCARGAR), isCurrentlyEnabled()
                ),
                GivenWhenThen.seeThat("Debería ver el boton imprimir habilitado",
                        WebElementQuestion.the(ServiciosBasicosPage.BOTON_IMPRIMIER), isCurrentlyEnabled()
                ),
                GivenWhenThen.seeThat("Debería ver el boton cerrar habilitado",
                        WebElementQuestion.the(ServiciosBasicosPage.BOTON_CERRAR), isCurrentlyEnabled()
                )
        );
    }
}
