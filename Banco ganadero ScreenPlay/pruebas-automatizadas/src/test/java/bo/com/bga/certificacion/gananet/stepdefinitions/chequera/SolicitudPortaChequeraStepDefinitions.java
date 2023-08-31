package bo.com.bga.certificacion.gananet.stepdefinitions.chequera;

import bo.com.bga.certificacion.gananet.interactions.database.EjecutarQueryPersonalizado;
import bo.com.bga.certificacion.gananet.interactions.shared.ConvierteMonto;
import bo.com.bga.certificacion.gananet.models.chequeras.SolicitudPortaChequeraModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.ValidarComprobante;
import bo.com.bga.certificacion.gananet.questions.shared.ValidarTarget;
import bo.com.bga.certificacion.gananet.tasks.chequeras.solicitud_porta_chequera.SolicitarPortaChequera;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.COMPROBANTE_CUENTA_ORIGEN;
import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.COMPROBANTE_IMPORTE_DEBITADO;
import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.SolicitudPortaChequeraPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_SOLICITUD_PORTA_CHEQUERA;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_TRANSFERENCIAS_MOVIMIENTOS_CONTABLES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SolicitudPortaChequeraStepDefinitions {
    @When("diligencia los campos de solicitud de porta chequera")
    public void diligenciaLosCamposDeSolicitudDePortaChequera(DataTable dataTable) {
        SolicitudPortaChequeraModel solicitudPortaChequeraModel = SolicitudPortaChequeraModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                SolicitarPortaChequera.go(SolicitudPortaChequeraModel.setData(dataTable).get(0),"HappyPath")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_SOLICITUD_PORTA_CHEQUERA+" COMENTARIOS ='"+OnStage.theActorInTheSpotlight().recall("COMENTARIO PORTA CHEQUERA")+"'","PORTA_CHEQUERA","GANADERO")
                .Comentario("Ejecutar consulta en base de datos en la tabla GANADERO.CHE_PORTACHEQUERA")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_TRANSFERENCIAS_MOVIMIENTOS_CONTABLES+"DEBITOCREDITO='D' AND CUENTA="+solicitudPortaChequeraModel.getCuentaOrigen()+" AND CONCEPTO='VENTA DE PORTACHEQUERA PERSONAL'","MOVIMIENTOS_CONTABLES_PORTA_CHEQUERA","GANADERO")
                        .Comentario("Ejecutar consulta en base de datos en la tabla MOVIMIENTOS_CONTABLES")
        );
    }
    @Then("Deberia poder ver el comprobante de la solicitud generado con exito")
    public void deberiaPoderVerElComprobanteDeLaSolicitudGeneradoConExito(DataTable dataTable) {
        String fechaComprobante = OnStage.theActorInTheSpotlight().recall("FECHA COMPROBANTE");
        String horaComprobante = OnStage.theActorInTheSpotlight().recall("HORA COMPROBANTE");
        String idComprobante = OnStage.theActorInTheSpotlight().recall("ID COMPROBANTE");
        SolicitudPortaChequeraModel solicitudPortaChequeraModel = SolicitudPortaChequeraModel.setData(dataTable).get(0);
        String montoDebitado = solicitudPortaChequeraModel.getCostoSolicitud()+" "+solicitudPortaChequeraModel.getMonedaCuenta();
        int montoInt = (int) ConvierteMonto.enDecimalOEntero(solicitudPortaChequeraModel.getCostoSolicitud());
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Validar la cuenta de origen del cobro de la porta chequera",
                        WebElementQuestion.the(COMPROBANTE_CUENTA_ORIGEN.of(solicitudPortaChequeraModel.getCuentaOrigen())), isCurrentlyVisible()),
                GivenWhenThen.seeThat("Validar el monto debitado corresponda al costo de la porta chequera",
                        WebElementQuestion.the(COMPROBANTE_IMPORTE_DEBITADO.of(montoDebitado)),isCurrentlyVisible()),
                GivenWhenThen.seeThat("Validar que el tipo de chequera impreso en el comprobante sea igual al solicitado",
                        WebElementQuestion.the(COMPROBANTE_TIPO_PORTA_CHEQUERA.of(solicitudPortaChequeraModel.getTipoPortaChequera())),isCurrentlyVisible()),
                GivenWhenThen.seeThat("Validar que la oficina impresa en el comprobante sea igual al de la solicitud",
                        WebElementQuestion.the(COMPROBANTE_OFICINA.of(solicitudPortaChequeraModel.getOficinaEntrega())),isCurrentlyVisible()),
                GivenWhenThen.seeThat("Validar que la NOTA impresa en el comprobante sea la correcta",
                        ValidarTarget.go(solicitudPortaChequeraModel.getMensajeComprobante(),NOTA_COMPROBANTE_PORTA_CHEQUERA)),
                GivenWhenThen.seeThat("Validar el almacenamiento en la tabla GANADERO.CHE_PORTACHEQUERA de base de datos ",
                        ValidacionBaseDeDatos.esCorrecta(solicitudPortaChequeraModel.getCuentaOrigen(),"JTS_CUENTA","PORTA_CHEQUERA")),
                GivenWhenThen.seeThat("Validar el almacenamiento en la tabla MOVIMIENTOS_CONTABLES de base de datos ",
                        ValidacionBaseDeDatos.esCorrecta(String.valueOf(montoInt),"CAPITALREALIZADO","MOVIMIENTOS_CONTABLES_PORTA_CHEQUERA"))

        );
    }
}
