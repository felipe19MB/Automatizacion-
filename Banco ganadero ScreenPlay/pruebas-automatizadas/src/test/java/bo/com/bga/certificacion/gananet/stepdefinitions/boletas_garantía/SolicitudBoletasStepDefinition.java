package bo.com.bga.certificacion.gananet.stepdefinitions.boletas_garantía;

import bo.com.bga.certificacion.gananet.interactions.shared.ConvierteMonto;
import bo.com.bga.certificacion.gananet.interactions.shared.Utilidades;
import bo.com.bga.certificacion.gananet.models.boletas_garantía.BoletasGarantíaModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.questions.shared.ValidarComprobante;
import bo.com.bga.certificacion.gananet.tasks.boletas_garantía.SolicitarBoletas;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;


import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_SOLICITUD_BOLETAS_GARANTIA;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_SOLICITUD_BOLETAS_GARANTIA_PARAMETROS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SolicitudBoletasStepDefinition {

    @When("Solicita una boleta de garantía prepagada")
    public void diligenciaTodaLaInformaciónParaSolicitarLa(DataTable dataTable) {
        BoletasGarantíaModel boletasGarantíaModel = BoletasGarantíaModel.setData(dataTable).get(0);
        double monto = ConvierteMonto.enDecimalOEntero(boletasGarantíaModel.getMonto());
        OnStage.theActorInTheSpotlight().attemptsTo(
                SolicitarBoletas.deGarantía(BoletasGarantíaModel.setData(dataTable).get(0),"HappyPath")
                );
        String idComprobante = OnStage.theActorInTheSpotlight().recall("ID COMPROBANTE");
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_SOLICITUD_BOLETAS_GARANTIA+" AND IDENTIFICADOR="+idComprobante+" AND IMPORTE="+monto+" AND NOMBRE_FACTURA='"+boletasGarantíaModel.getNombreFacturacion().toUpperCase()+"' AND NUMERO_FACTURA='"+boletasGarantíaModel.getNit()+"' AND NRO_PERSONA_TITULAR="+boletasGarantíaModel.getPersonaTitular()+" AND NRO_TESTIMONIO='"+boletasGarantíaModel.getNroTestimonio()+"' AND BENEFICIARIO='"+boletasGarantíaModel.getOrdenDe().toUpperCase()+"' AND PLAZO="+boletasGarantíaModel.getPlazo()+" AND GARANTIA='"+boletasGarantíaModel.getEnGarantiaDe().toUpperCase()+"' AND EMAIL='"+boletasGarantíaModel.getEmailNotificacion().toUpperCase()+"' AND NOMBRE_MENSAJERO='"+boletasGarantíaModel.getNombre().toUpperCase()+"' AND DOCUMENTO_MENSAJERO='"+boletasGarantíaModel.getDocumento()+"'",
                                "BOLETAS AUT_BOG_SOLICITUD","GANADERO")
                        .Comentario("Se ejecuta el querie en base de datos para validar la existencia del registro en la tabla AUT_BOG_SOLICITUD"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_SOLICITUD_BOLETAS_GARANTIA_PARAMETROS+" NRO_TRANSACCION="+idComprobante,
                                "BOLETAS AUT_PARAMETROS_TOPAZ","AUTOSRV")
                        .Comentario("Se ejecuta el querie en base de datos para validar la existencia del registro en la tabla AUT_PARAMETROS_TOPAZ")
        );
    }
    @Then("Debería ver un comprobante de boleta de garantia prepagada")
    public void deberíaValidarLaGeneraciónExitosaDeLaSolicitud(DataTable dataTable) {
        BoletasGarantíaModel boletasGarantiaModel = BoletasGarantíaModel.setData(dataTable).get(0);
        String fechaComprobante = OnStage.theActorInTheSpotlight().recall("FECHA COMPROBANTE");
        String horaComprobante = OnStage.theActorInTheSpotlight().recall("HORA COMPROBANTE");
        String idComprobante = OnStage.theActorInTheSpotlight().recall("ID COMPROBANTE");
        OnStage.theActorInTheSpotlight().should(
                seeThat("Verifica el texto de la modal inicial",
                        ValidacionString.esCorrecta(boletasGarantiaModel.getModalInicio(),"MODAL INICIO SOLICITUD")),
                seeThat("Verifica el correcto calcúlo de la comisión + el importe",
                        ValidacionString.esCorrecta(Utilidades.sumarDosStrings(boletasGarantiaModel.getMonto(),boletasGarantiaModel.getComisionEmision()),"TOTAL CARGOS CALCULADOS")),
                seeThat("Verifica que se calcule correctamente la fecha final según el plazo",
                        ValidacionString.esCorrecta(Utilidades.adicionarDiasAFechaActual(Integer.parseInt(boletasGarantiaModel.getPlazo())),"FECHA VENCIMIENTO CACULADA")),
                seeThat("Verifica que el mensaje de declaración y aceptación sea el correcto ",
                        ValidacionString.esCorrecta(boletasGarantiaModel.getMensajeDeclaracion(),"DECLARACIÓN Y ACEPTACIÓN")),
                seeThat("Verifica que la alerta final para confirmar la solicitud tenga la información correcta",
                        ValidacionString.esCorrecta(boletasGarantiaModel.getModalFinal(),"MODAL FINALIZACIÓN SOLICITUD")),
                seeThat("Verifica que la solicitud sea generada correctamente",
                        ValidacionString.esCorrecta("Solicitud procesada con éxito.","MODAL SOLICITUD EXITOSA")),
                seeThat("Verifica que el comprobante se genere con éxito",
                        ValidarComprobante.conDatos(fechaComprobante,horaComprobante, idComprobante)),
                seeThat("Validar el registro en la tabla AUT_BOG_SOLICITUD de base de datos",
                        ValidacionBaseDeDatos.esCorrecta(boletasGarantiaModel.getNit(),"NUMERO_FACTURA","BOLETAS AUT_BOG_SOLICITUD")),
                seeThat("Validar el registro en la tabla AUT_PARAMETROS_TOPAZ de base de datos",
                        ValidacionBaseDeDatos.esCorrecta("2","RECUENTO","BOLETAS AUT_PARAMETROS_TOPAZ"))
        );
    }



}
