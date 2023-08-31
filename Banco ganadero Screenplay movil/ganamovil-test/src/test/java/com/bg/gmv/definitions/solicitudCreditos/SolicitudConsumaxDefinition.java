package com.bg.gmv.definitions.solicitudCreditos;

import com.bg.gmv.steps.solicitudCreditos.SolicitudConsumaxStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class SolicitudConsumaxDefinition {

    @Steps
    SolicitudConsumaxStep solicitudConsumaxStep;

    @When("^Cliente indica que No es Asalariado$")
    public void cliente_indica_que_no_es_asalariado() {
        solicitudConsumaxStep.ingresarIniciarSolicitud();
        solicitudConsumaxStep.indicarNoSoyAsalariado();
    }

    @Then("^mensaje informativo indicando que no puede solicitar el credito$")
    public void mensaje_informativo_indicando_que_no_puede_solicitar_el_credito(List<String> mensajes) {
        solicitudConsumaxStep.verificarMensajeNoPuedeSolicitarCredito(mensajes);
    }

    @And("^Indica iniciar la solicitud$")
    public void indica_iniciar_la_solicitud() {
        solicitudConsumaxStep.ingresarIniciarSolicitud();
    }

    @And("^Se desactiva antispoofing$")
    public void se_desactiva_antispoofing(List<String> personas) {
        solicitudConsumaxStep.insertarRegistroAntispoofing(personas);
    }

    @And("^Indica iniciar la solicitud porque es asalariado$")
    public void indica_iniciar_la_solicitud_porque_es_asalariado() {
        solicitudConsumaxStep.iniciarSolicitudEsAsalariado();
    }

    @And("^Confirma Terminos y Condiciones$")
    public void confirma_terminos_y_condiciones() {
        solicitudConsumaxStep.confirmarTerminosCondiciones();
    }

    @And("^selecciona y llena Estado civil, Residencia y Sueldo Liquido USD$")
    public void selecciona_y_llena_estado_civil_residencia_y_sueldo_liquido_USD(List<String> sueldosLiquidos) {
        solicitudConsumaxStep.seleccionarEstadoCivil();
        solicitudConsumaxStep.seleccionarResidencia();
        solicitudConsumaxStep.llenarSueldoLiquido(sueldosLiquidos);
    }

    @And("^llena confirmacion de correo electronico del titular$")
    public void llena_confirmacion_de_correo_electronico_del_titular(List<String> textos) {
        solicitudConsumaxStep.llenarConfirmacionCorreoTitular(textos);
    }

    @And("^llena correo electronico del titular$")
    public void llena_correo_electronico_del_titular() {
        solicitudConsumaxStep.llenarCorreoElectronicoTitular();
    }

    @And("^llena telefono celular y confirma los datos$")
    public void llena_telefono_celular_y_confirma_los_datos(List<String> telefonos) {
        solicitudConsumaxStep.llenarTelefonoCelular(telefonos);
        solicitudConsumaxStep.confirmarDatos();
    }

    @And("^indica el monto a solicitar$")
    public void indica_el_monto_a_solicitar(List<String> montos) {
        solicitudConsumaxStep.llenarMontoASolicitar(montos);
    }

    @And("^selecciona el dia que desea pagar$")
    public void selecciona_el_dia_que_desea_pagar() {
        solicitudConsumaxStep.seleccionarDiaPagar();
    }

    @And("^confirma datos del monto a solicitar$")
    public void confirma_datos_del_monto_a_solicitar() {
        solicitudConsumaxStep.confirmarDatosMonto();
    }

    @And("^selecciona nivel de educacion, profesion, cargo, nivel ingreso$")
    public void selecciona_nivel_educacion_profesion_cargo_nivel_ingresos(List<String> profesiones) {
        solicitudConsumaxStep.seleccionarNivelEducacion();
        solicitudConsumaxStep.llenarProfesion(profesiones);
        solicitudConsumaxStep.seleccionarCargo();
        solicitudConsumaxStep.seleccionarIngreso();
    }

    @And("^selecciona tipo vivienda y cantidad de hijos y nombre empresa$")
    public void selecciona_tipo_vivienda_y_cantidad_de_hijos_y_nombre_empresa(List<String> empresas) {
        solicitudConsumaxStep.seleccionarViviendaCantidadHijosNombreEmpresa(empresas);
    }

    @And("^llena fecha de ingreso al trabajo$")
    public void llena_fecha_ingreso_trabajo(List<String> textos) {
        solicitudConsumaxStep.llenarFechaIngresoTrabajo(textos);
    }

    @And("^Selecciona cancelar la solicitud consumax soltero$")
    public void selecciona_cancelar_la_solicitud_consumax_soltero() {
        solicitudConsumaxStep.cancelarSolicitud();
    }

    @And("^Selecciona Si para ser redirigido a la pantalla principal de la solicitud consumax soltero$")
    public void selecciona_si_para_ser_redirigido_a_la_pantalla_principal_de_la_solicitud_consumax_soltero() {
        solicitudConsumaxStep.confirmarSeleccion();
    }

    @And("^Selecciona Cancelar Solicitud consumax soltero$")
    public void selecciona_cancelar_solicitud_Consumax_soltero() {
        solicitudConsumaxStep.cancelarSolicitudConsumax();
    }

    @And("^Indica que esta seguro de cancelar la solicitud consumax soltero$")
    public void indica_que_esta_seguro_de_cancelar_la_solicitud_consumax_soltero() {
        solicitudConsumaxStep.confirmarSeleccion();
    }

    @Then("^Visualiza que la solicitud se desestimo correctamente$")
    public void visualiza_que_la_solicitud_se_desestimo_correctamente(List<String> mensajes) {
        solicitudConsumaxStep.verificarMensajeDesestimadoCorrectamente(mensajes);
    }

    @And("^confirma datos de actividad economica$")
    public void confirma_datos_de_actividad_economica() {
        solicitudConsumaxStep.confirmarDatosActividadEconomica();
    }

    @And("^acepta mensaje informativo acerca de la direccion de domicilio$")
    public void acepta_mensaje_informativo_acerca_de_la_direccion_de_domicilio() {
        solicitudConsumaxStep.aceptarMensajeDireccionDomicilio();
    }

    @And("^indica usar mapas mientras la app este en uso$")
    public void indica_usar_mapas_mientras_app_este_en_uso() {
        solicitudConsumaxStep.usarMapaMientrasAppEnUso();
    }

    @And("^llena barrio, calle, numero, manzana y referencia y selecciona zona$")
    public void llena_barrio_calle_numero_manzana_referencia_selecciona_zona(List<String> datosDireccion) {
        solicitudConsumaxStep.llenarDatosDireccion(datosDireccion);
    }

    @And("^confirma datos de direccion de domicilio$")
    public void confirma_datos_de_direccion_de_domicilio() {
        solicitudConsumaxStep.confirmarDatosDireccionDomicilio();
    }

    @And("^selecciona ciudad y zona, llena barrio, calle, numero y manzana$")
    public void selecciona_ciudad_zona_llena_barrio_calle_numero_manzana(List<String> datosDireccionLaboral) {
        solicitudConsumaxStep.seleccionarDepartamentoLaboral();
        solicitudConsumaxStep.seleccionarZonaLaboral();
        solicitudConsumaxStep.llenarBarrioLaboral(datosDireccionLaboral);
        solicitudConsumaxStep.llenarCalleLaboral(datosDireccionLaboral);
        solicitudConsumaxStep.llenarNumeroLaboral(datosDireccionLaboral);
        solicitudConsumaxStep.llenarManzanaLaboral(datosDireccionLaboral);
    }

    @And("^confirma datos de direccion laboral$")
    public void confirma_datos_direccion_laboral() {
        solicitudConsumaxStep.confirmarDatosDireccionLaboral();
    }

    @And("^confirma vinculacion economica$")
    public void confirma_vinculacion_economica() {
        solicitudConsumaxStep.confirmarDatosVinculacionEconomica();
    }

    @And("^confirma declaracion jurada de bienes$")
    public void confirma_declaracion_jurada_bienes(List<String> datosDDJJ) {
        solicitudConsumaxStep.llenarValorMueblesEnseres(datosDDJJ);
        solicitudConsumaxStep.quitarRequisitosDocumentacion();
        solicitudConsumaxStep.confirmarDatosDDJJ();
    }

    @And("^adjunta documentacion requerida$")
    public void adjunta_documentacion_requerida() {
        solicitudConsumaxStep.seleccionarFirma();
        solicitudConsumaxStep.firmarSolicitud();
    }

    @And("^confirma documentacion requerida adjuntada$")
    public void confirma_documentacion_requerida_adjuntada() {
        solicitudConsumaxStep.confirmarDocumentacionAdjuntada();
    }

    @Then("^Puedo ver la pantalla de inicio de la solicitud$")
    public void puedo_ver_la_pantalla_de_inicio_de_la_solicitud() {
        solicitudConsumaxStep.verificarPantallaInicioSolicitud();
    }

    @And("^Puedo ingresar la solicitud a traves del boton de Inicio de Solicitud$")
    public void puedo_ingresar_la_solicitud_a_traves_boton_de_inicio_solicitud() {
        solicitudConsumaxStep.verificarBotonInicioSolicitud();
    }

    @And("^llena ddjj de salud$")
    public void llena_ddjj_de_salud(List<String> datosDdjjSalud) {
        solicitudConsumaxStep.llenarPeso(datosDdjjSalud);
        solicitudConsumaxStep.llenarAltura(datosDdjjSalud);
        solicitudConsumaxStep.llenarDdjjDeSalud();
        solicitudConsumaxStep.llenarDdjjDeSaludParteDos();
    }

    @And("^confirma ddjj de salud$")
    public void confirma_ddjj_de_salud() {
        solicitudConsumaxStep.confirmarDatosDDJJ();
    }

    @Then("^solicitud ingresa correctamente al flujo$")
    public void solicitud_ingresa_correctamente_al_flujo(List<String> personas) {
        solicitudConsumaxStep.verificarSolicitudEnElFlujo(personas);
        solicitudConsumaxStep.desestimarSolicitudIngresada(personas);
        solicitudConsumaxStep.habilitarRequisitosDocumentacionExtractoAFP();
        solicitudConsumaxStep.habilitarRequisitosDocumentacionBoletasPago();
        solicitudConsumaxStep.habilitarRequisitosDocumentacionCarnetSelfie();
    }
}
