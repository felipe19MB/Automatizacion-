package com.bg.gmv.definitions.seguroMultiHogar;

import com.bg.gmv.steps.seguroMultiHogar.SeguroMultiHogarStep;
import com.bg.gmv.steps.solicitudCreditos.SolicitudConsumaxStep;
import com.bg.gmv.steps.solicitudTCStep.SolicitudTCStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class SeguroMultiHogarDefinition {
    @Steps
    SeguroMultiHogarStep seguroMultiHogarStep;

    @And("^selecciona su plan multihogar$")
    public void selecciona_su_plan_multihogar() {
        seguroMultiHogarStep.verificarPantallaSeleccionaTuPlan();
        seguroMultiHogarStep.solicitar();
    }

    @And("^selecciona su cuenta y tipo de pago$")
    public void selecciona_su_cuenta_y_tipo_de_pago(List<String> numeroCuenta) {
        seguroMultiHogarStep.verificarPantallaSeleccionaNumeroCuentaTipoPago();
        seguroMultiHogarStep.seleccionarCuenta(numeroCuenta);
        seguroMultiHogarStep.seleccionarTipoPago();
        seguroMultiHogarStep.continuar();
    }

    @And("^llena los datos del tomador del seguro$")
    public void llena_los_datos_del_tomador_del_seguro(List<String> datosTomador) {
        seguroMultiHogarStep.verificarPantallaDatosTomador();
        seguroMultiHogarStep.ingresarCorreoElectronicoParaEnviarPoliza(datosTomador);
        seguroMultiHogarStep.ingresarConfirmarCorreoElectronico(datosTomador);
        seguroMultiHogarStep.ingresarTelefonoDomicilio(datosTomador);
        seguroMultiHogarStep.ingresarCelular(datosTomador);
        seguroMultiHogarStep.continuar();
    }

    @And("^llena direccion del domicilio$")
    public void llena_direccion_del_domicilio(List<String> direccionDomicilio) {
        seguroMultiHogarStep.verificarDireccionDomicilio();
        seguroMultiHogarStep.seleccionarDepartamento(direccionDomicilio);
        seguroMultiHogarStep.seleccionarCiudad(direccionDomicilio);
        seguroMultiHogarStep.ingresarBarrio(direccionDomicilio);
        seguroMultiHogarStep.ingresarCalle(direccionDomicilio);
        seguroMultiHogarStep.ingresarNumero(direccionDomicilio);
        seguroMultiHogarStep.ingresarReferencia(direccionDomicilio);
        seguroMultiHogarStep.continuar();
    }

    @When("^confirma declaracion jurada y resumen de la informacion para el seguro Multihogar$")
    public void confirma_ddjj_y_resumen_de_la_informacion_para_el_seguro_multihogar() {
        seguroMultiHogarStep.verificarDeclaracionJurada();
        seguroMultiHogarStep.aceptarDeclaracion();
    }

    @Then("^cliente cuenta con seguro Multihogar$")
    public void cliente_cuenta_con_seguro_multihogar() {
        seguroMultiHogarStep.verificarPantallaResumen();
        seguroMultiHogarStep.confirmar();
        seguroMultiHogarStep.verificarMensajeExito();
        seguroMultiHogarStep.verificarDetalleMensajeExito();
        seguroMultiHogarStep.finalizar();
        seguroMultiHogarStep.verificarPantallaPrincipal();
    }

}
