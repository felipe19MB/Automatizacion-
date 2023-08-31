package com.bg.gmv.definitions.solicitudTC;

import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import com.bg.gmv.steps.habilitacion.HabilitacionStep;
import com.bg.gmv.steps.solicitudCreditos.SolicitudConsumaxStep;
import com.bg.gmv.steps.solicitudTCStep.SolicitudTCStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class    SolicitudTCDefinition {
    @Steps
    SolicitudTCStep solicitudTCStep;
    SolicitudConsumaxStep solicitudConsumaxStep = new SolicitudConsumaxStep();

    @And("^Indica su situacion laboral como asalariado y con AFP$")
    public void indica_su_situacion_laboral_como_asalariado_y_con_AFP() {
        solicitudTCStep.seleccionarSituacionLaboral();
        solicitudTCStep.confirmarDatos();
    }
    @And("^Llena la calculadora financiera$")
    public void llena_calculadora_financiera(List<String> ingresosYGastos) {
        solicitudTCStep.ingresarIngresos(ingresosYGastos);
        solicitudTCStep.ingresarGastosFamiliares(ingresosYGastos);
        solicitudTCStep.calcular();
        solicitudTCStep.aceptar();
    }
    @And("^Llena sus datos solicitados$")
    public void llena_sus_datos_solicitados(List<String> datosCliente) {
        solicitudTCStep.seleccionarEstadoCivil(datosCliente);
        solicitudTCStep.seleccionarResidencia(datosCliente);
        solicitudTCStep.seleccionarAgenciaPreferida(datosCliente);
        solicitudTCStep.verificarTextoTelefonoTitular(datosCliente);
        solicitudTCStep.llenarSueldoLiquido(datosCliente);
        solicitudTCStep.llenarConfirmacionCorreoElectronico(datosCliente);
        solicitudTCStep.llenarCorreoElectronico(datosCliente);
        solicitudTCStep.llenarTelefono(datosCliente);
        solicitudTCStep.confirmarDatos();
    }
    @And("^Llena datos del monto a solicitar$")
    public void llena_datos_del_monto_a_solicitar(List<String> datosCliente) {
        solicitudTCStep.ingresarMontoASolicitar(datosCliente);
        solicitudTCStep.seleccionarDireccionCorrespondencia(datosCliente);
        solicitudTCStep.confirmarDatos();
    }
    @And("^Llena actividad economica$")
    public void llena_actividad_economica(List<String> datosCliente) {
        solicitudTCStep.ingresarProfesion(datosCliente);
        solicitudTCStep.seleccionarNivelEducacion(datosCliente);
        solicitudTCStep.seleccionarCargo(datosCliente);
        solicitudTCStep.seleccionarNivelIngreso(datosCliente);
        solicitudTCStep.seleccionarTipoVivienda(datosCliente);
        solicitudTCStep.seleccionarCantidadHijos(datosCliente);
        solicitudTCStep.ingresarNombreEmpresa(datosCliente);
        solicitudTCStep.llenarDiaIngreso(datosCliente);
        solicitudTCStep.llenarMesIngreso(datosCliente);
        solicitudTCStep.llenarAnhoIngreso(datosCliente);
        solicitudTCStep.confirmarDatos();
    }
    @And("^Llena declaracion jurada de solicitud de TC$")
    public void llena_declaracion_jurada_solicitud_tc(List<String> datosCliente) {
        solicitudTCStep.llenarValorInmueble(datosCliente);
        solicitudTCStep.confirmarDatos();
        solicitudTCStep.aceptar();
    }
    @And("^Ingresa direccion de su domicilio para solicitud de TC$")
    public void ingresa_direccion_domicilio_solicitud_tc(List<String> datosCliente) {
        solicitudTCStep.ingresarBarrio(datosCliente);
        solicitudTCStep.ingresarCalle(datosCliente);
        solicitudTCStep.seleccionarZona(datosCliente);
        solicitudTCStep.ingresarNumero(datosCliente);
        solicitudTCStep.ingresarManzana(datosCliente);
        solicitudTCStep.ingresarReferencia(datosCliente);
        solicitudTCStep.confirmarDatos();
    }
    @And("^Ingresa direccion laboral para solicitud de TC$")
    public void ingresa_direccion_laboral_solicitud_tc(List<String> datosCliente) {
        solicitudTCStep.seleccionarDepartamentoLaboral(datosCliente);
        solicitudTCStep.ingresarBarrioLaboral(datosCliente);
        solicitudTCStep.ingresarCalleLaboral(datosCliente);
        solicitudTCStep.seleccionarZonaLaboral(datosCliente);
        solicitudTCStep.ingresarNumeroLaboral(datosCliente);
        solicitudTCStep.ingresarManzanaLaboral(datosCliente);
        solicitudTCStep.confirmarDatos();
    }
    @And("^Selecciona vinculacion economica para solciitud de TC$")
    public void selecciona_vinculacion_economica_solicitud_TC() {
        solicitudTCStep.confirmarDatos();
    }
    @And("^Llena declaracion jurada de salud para solicitud de TC$")
    public void llena_declaracion_jurada_salud_solicitud_tc(List<String> datosCliente) {
        solicitudTCStep.ingresarPeso(datosCliente);
        solicitudTCStep.ingresarAltura(datosCliente);
        solicitudTCStep.llenarDDJJSalud();
        solicitudConsumaxStep.quitarRequisitosDocumentacion();
        solicitudTCStep.llenarDDJJSalud2();
        solicitudTCStep.confirmarDatos();
    }
    @And("^Adjunta documentos necesarios y firma para la solicitud TC$")
    public void adjunta_documentos_necesarios_firma_para_solicitud_tc() {
        solicitudTCStep.seleccionarFirma();
        solicitudTCStep.firmarSolicitud();
    }
    @When("^Confirma los documentos y la firma$")
    public void confirma_documentos_y_la_firma() {
        solicitudTCStep.confirmarDatos();
    }
    @Then("^Solicitud ingresa correctamente al workflow$")
    public void solicitud_ingresa_correctamente_workflow(List<String> datosCliente) {
        solicitudTCStep.verificarSolicitudEnElFlujo(datosCliente);
        solicitudTCStep.aceptar();
        solicitudConsumaxStep.desestimarSolicitudIngresada(datosCliente);
        solicitudConsumaxStep.habilitarRequisitosDocumentacionExtractoAFP();
        solicitudConsumaxStep.habilitarRequisitosDocumentacionBoletasPago();
        solicitudConsumaxStep.habilitarRequisitosDocumentacionCarnetSelfie();
    }
    @And("^Selecciona cancelar solicitud tc y vuelve a la pantalla principal de la solicitud$")
    public void selecciona_cancelar_solicitud_tc_vuelve_a_la_pantalla_principal_a_la_solicitud() {
        solicitudTCStep.cancelar();
        solicitudTCStep.confirmarConSi();
    }
    @When("^Selecciona Cancelar Solicitud y confirma que esta seguro de cancelarla$")
    public void selecciona_cancelar_solicitud_confirma_que_esta_seguro_de_cancelarla() {
        solicitudTCStep.cancelarSolicitud();
        solicitudTCStep.confirmarConSi();
    }
    @Then("^Puedo ver la pantalla de inicio de la solicitud de TC$")
    public void puedo_ver_la_pantalla_de_inicio_de_la_solicitud_de_tc() {
        solicitudTCStep.verificarPantallaInicioSolicitudTC();
    }
    @And("^Puedo ingresar la solicitud a traves del boton de Inicio de Solicitud TC$")
    public void puedo_ingresar_la_solicitud_a_traves_del_boton_de_inicio_de_solicitud_tc() {
        solicitudTCStep.iniciarSolicitud();
        solicitudTCStep.verificarTextoEspecificacionesRequisitos();
    }
}
