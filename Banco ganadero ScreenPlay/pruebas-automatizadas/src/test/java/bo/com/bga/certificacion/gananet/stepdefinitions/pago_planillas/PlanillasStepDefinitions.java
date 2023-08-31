package bo.com.bga.certificacion.gananet.stepdefinitions.pago_planillas;



import bo.com.bga.certificacion.gananet.interactions.shared.AlertasInteraciones;
import bo.com.bga.certificacion.gananet.models.shared.DatosIngreso;
import bo.com.bga.certificacion.gananet.models.shared.DatosRutaFuncionalidad;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.models.pago_planillas.DatosHistoricoPagoPlanillas;
import bo.com.bga.certificacion.gananet.questions.pago_planillas.ValidacionHistoricoPagos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionDescargaArchivo;

import bo.com.bga.certificacion.gananet.tasks.pago_planillas.BuscarPlanilla;
import bo.com.bga.certificacion.gananet.tasks.pago_planillas.PagaPlanilla;
import bo.com.bga.certificacion.gananet.tasks.pago_planillas.SeleccionarPlanilla;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresarAFuncionalidad;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresarAGananet;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.Map;

import static bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas.VALIDACIONES;
import static bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas.VALIDACIONES_CLIENTES;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static bo.com.bga.certificacion.gananet.utils.DataTableConverter.convert;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.CHECK_TRANSACCION_EXITOSA;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.hamcrest.Matchers.equalTo;


public class PlanillasStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("actor");
    }

    @Given("El cliente ingresa a la pagina de gananet")
    public void elClienteIngresaALaPaginaDeGananet(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://devganamovil.bg.com.bo/apps/GanaNet/#_Site")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAGananet.withCredentials(DatosIngreso.setData(dataTable).get(0))
        );
    }

    @Given("Ingresa al perfil,modulo y funcionalidad correspondiente")
    public void ingresaAlPerfilModuloYFuncionalidadCorrespondiente(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAFuncionalidad.go(DatosRutaFuncionalidad.setData(dataTable).get(0))
        );
    }


    @When("importa la planilla de manera {string} para pagar a los {string} aprobando el {string}")
    public void importaLaPlanillaDeManeraParaPagarALosAprobandoEl(String formaPago, String tipoPago, String tipoAutotizacion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PagaPlanilla.conDatos(formaPago, tipoPago, tipoAutotizacion)
        );
        String conceptoPlanilla = OnStage.theActorInTheSpotlight().recall("Concepto Planilla");
        System.out.println(conceptoPlanilla);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_PLANILLA_OBTENER_LOTE_POR_CONCEPTO+ "'"+conceptoPlanilla+"'","resultadosObtenidos","GANADERO")
                        .Comentario("Se ejecuta el query para obtener el lote de la planilla según el concepto.")
        );
        Map<String, Object> recall = OnStage.theActorInTheSpotlight().recall("resultadosObtenidos");

        if(formaPago == "Automática") {
            String lote = recall.get("LOTE").toString();
            OnStage.theActorInTheSpotlight().attemptsTo(
                    EjecutaBaseDeDatos.QueryPersonalizado(QUERY_PLANILLA_OBTENER_DETALLE_PAGO_POR_LOTE + lote, "resultadosObtenidos", "GANADERO")
                            .Comentario("Se ejecuta el query para obtener el detalle del pago de la planilla")
            );
        }






    }

    @Then("debería confirmar el comprobante del pago de la planilla por {string} desde la cuenta {string}")
    public void deberíaConfirmarElComprobanteDelPagoDeLaPlanilla(String importe,String cuenta) {
        String estadoTransaccion = OnStage.theActorInTheSpotlight().recall("Estado Transacción");
        OnStage.theActorInTheSpotlight().should(
                seeThat("El estado de la transacción",
                        actor -> estadoTransaccion,
                        equalTo("Aceptado")
                )
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver la modal de transacción éxitosa",
                        WebElementQuestion.the(CHECK_TRANSACCION_EXITOSA),isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería confirmar en base de datos el valor del importe",
                        ValidacionBaseDeDatos.esCorrecta(importe,"IMPORTE","resultadosObtenidos")
                ),
                GivenWhenThen.seeThat("Debería confirmar en base de datos el número de cuenta correcto",
                        ValidacionBaseDeDatos.esCorrecta(cuenta,"CUENTAOB","resultadosObtenidos")
                )
        );
    }
    @Then("debería confirmar el comprobante del pago de la planilla y la descarga de los archivos correspondientes")
    public void deberíaConfirmarElComprobanteDelPagoDeLaPlanillaYLaDescargaDeLosArchivosCorrespondientes() {
        String estadoTransaccion = OnStage.theActorInTheSpotlight().recall("Estado Transacción");
        String conceptoPlanilla = OnStage.theActorInTheSpotlight().recall("Concepto Planilla");
        OnStage.theActorInTheSpotlight().should(
                seeThat("El estado de la transacción",
                        actor -> estadoTransaccion,
                        equalTo("Aceptado")
                )
        );
        OnStage.theActorInTheSpotlight().should(
               GivenWhenThen.seeThat("Debería confirmar en la descarga del archivo .t",
                       ValidacionDescargaArchivo.exitosamente(conceptoPlanilla+".t")
               )
        );

    }
    @When("Ingreso los campos para buscar una planilla")
    public void ingresoLosCamposParaLaBuscarPlanilla(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarPlanilla.go(DatosHistoricoPagoPlanillas.setData(dataTable).get(0))
        );
    }
    @And("Selecciono una Planilla")
    public void seleccionoPanilla(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarPlanilla.go(DatosHistoricoPagoPlanillas.setData(dataTable).get(0))
        );
    }

    @Then("Deberia ver los datos de la Planilla")
    public void deberiVerDatosPlanilla(DataTable dataTable) {
        Collection<String> datos = convert(dataTable.rows(1));
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionHistoricoPagos.go(datos, VALIDACIONES), Matchers.is(true))
        );
    }
    @Then("Deberia ver los datos de los empleados en la planilla")
    public void deberiVerDatosEmpleadoPlanilla(DataTable dataTable) {
        Collection<String> datos = convert(dataTable.rows(1,6));
        System.out.println(datos);
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionHistoricoPagos.go(datos, VALIDACIONES_CLIENTES), Matchers.is(true))
        );
    }
}


