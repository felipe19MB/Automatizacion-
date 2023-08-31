package com.bg.gmv.steps.seguroMultiHogar;

import com.bg.gmv.pageobjects.dashboard.DashBoardPage;
import com.bg.gmv.pageobjects.seguroMultiHogar.SeguroMultiHogarPage;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxDB;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import com.bg.gmv.pageobjects.solicitudTC.SolicitudTCPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeguroMultiHogarStep {
    SeguroMultiHogarPage seguroMultiHogarPage;

    @Step
    public void verificarPantallaSeleccionaTuPlan() {
        assertEquals(seguroMultiHogarPage.getSeleccionaTuPlanTextToAssert(),seguroMultiHogarPage.getSeleccionaTuPlan());
    }
    @Step
    public void solicitar() {
        seguroMultiHogarPage.solicitar();
    }
    @Step
    public void verificarPantallaSeleccionaNumeroCuentaTipoPago() {
        assertEquals(seguroMultiHogarPage.getSeleccionaElNumeroDeCuentaTipoDePagoTextToAssert(),seguroMultiHogarPage.getSeleccionaElNumeroDeCuentaTipoDePago());
    }
    @Step
    public void seleccionarCuenta(List<String> numeroCuenta) {
        seguroMultiHogarPage.seleccionarCuenta(numeroCuenta.get(0));
    }
    @Step
    public void seleccionarTipoPago() {
        seguroMultiHogarPage.seleccionarTipoPagoAnual();
    }
    @Step
    public void continuar() {
        seguroMultiHogarPage.continuar();
    }
    @Step
    public void verificarPantallaDatosTomador() {
        assertEquals(seguroMultiHogarPage.getDatosDelTomadorTextToAssert(),seguroMultiHogarPage.getDatosDelTomador());
    }
    @Step
    public void ingresarCorreoElectronicoParaEnviarPoliza(List<String> datosTomador) {
        seguroMultiHogarPage.ingresarCorreoElectronicoParaEnviarPoliza(datosTomador.get(0));
    }
    @Step
    public void ingresarConfirmarCorreoElectronico(List<String> datosTomador) {
        seguroMultiHogarPage.ingresarConfirmacionCorreoElectronico(datosTomador.get(1));
    }
    @Step
    public void ingresarTelefonoDomicilio(List<String> datosTomador) {
        seguroMultiHogarPage.ingresarTelefonoDomicilio(datosTomador.get(2));
    }
    @Step
    public void ingresarCelular(List<String> datosTomador) {
        seguroMultiHogarPage.ingresarCelular(datosTomador.get(3));
    }
    @Step
    public void verificarDireccionDomicilio() {
        assertEquals(seguroMultiHogarPage.getDireccionDomicilioTextToAssert(),seguroMultiHogarPage.getDireccionDomicilio());
    }
    @Step
    public void seleccionarDepartamento(List<String> direccionDomicilio) {
        seguroMultiHogarPage.seleccionarDepartamento(direccionDomicilio.get(0));
    }
    @Step
    public void seleccionarCiudad(List<String> direccionDomicilio) {
        seguroMultiHogarPage.seleccionarCiudad(direccionDomicilio.get(1));
    }
    @Step
    public void ingresarBarrio(List<String> direccionDomicilio) {
        seguroMultiHogarPage.ingresarBarrio(direccionDomicilio.get(2));
    }
    @Step
    public void ingresarCalle(List<String> direccionDomicilio) {
        seguroMultiHogarPage.ingresarCalle(direccionDomicilio.get(3));
    }
    @Step
    public void ingresarNumero(List<String> direccionDomicilio) {
        seguroMultiHogarPage.ingresarNumero(direccionDomicilio.get(4));
    }
    @Step
    public void ingresarReferencia(List<String> direccionDomicilio) {
        seguroMultiHogarPage.ingresarReferencia(direccionDomicilio.get(5));
    }
    @Step
    public void verificarDeclaracionJurada() {
        assertEquals(seguroMultiHogarPage.getDeclaracionJuradaTextToAssert(),seguroMultiHogarPage.getDeclaracionJurada());
    }
    @Step
    public void aceptarDeclaracion() {
        seguroMultiHogarPage.aceptarDeclaracion();
    }
    @Step
    public void verificarPantallaResumen() {
        assertEquals(seguroMultiHogarPage.getResumenInformacionTextToAssert(),seguroMultiHogarPage.getResumenInformacion());
    }
    @Step
    public void confirmar() {
        seguroMultiHogarPage.confirmar();
    }
    @Step
    public void finalizar() {
        seguroMultiHogarPage.finalizar();
    }
    @Step
    public void verificarMensajeExito() {
        assertEquals(seguroMultiHogarPage.getMensajeExitoTextToAssert(),seguroMultiHogarPage.getMensajeExito());
    }
    @Step
    public void verificarDetalleMensajeExito() {
        assertEquals(seguroMultiHogarPage.getDetalleMensajeExitoTextToAssert(),seguroMultiHogarPage.getDetalleMensajeExito());
    }
    @Step
    public void verificarPantallaPrincipal() {
        assertEquals(seguroMultiHogarPage.getPantallaPrincipalTextToAssert(),seguroMultiHogarPage.getPantallaPrincipal());
    }
}
