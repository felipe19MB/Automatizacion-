package com.bg.gnt.steps.configuracionSeguridad;

import com.bg.gnt.pageobjects.configuracionSeguridad.ActualizacionDatosPage;
import com.bg.gnt.pageobjects.configuracionSeguridad.ActualizacionDatosResumenPage;
import com.bg.gnt.pageobjects.transferencias.CtaOtrosBancosPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ActualizacionDatosStep {

	ActualizacionDatosPage actualizacionDatosPage;
	ActualizacionDatosResumenPage actualizacionDatosResumenPage;
	
	@Step
	public void ingresarUV(List<String> personalData) {
		actualizacionDatosPage.ingresarUV(personalData.get(0));
	}
	@Step
	public void ingresarManzana(List<String> personalData) {
		actualizacionDatosPage.ingresarManzana(personalData.get(1));
	}
	@Step
	public void ingresarBarrio(List<String> personalData) {
		actualizacionDatosPage.ingresarBarrio(personalData.get(2));
	}
	@Step
	public void ingresarCalle(List<String> personalData) {
		actualizacionDatosPage.ingresarCalle(personalData.get(3));
	}
	@Step
	public void ingresarNroPuerta(List<String> personalData) {
		actualizacionDatosPage.ingresarNroPuerta(personalData.get(4));
	}
	@Step
	public void ingresarPiso(List<String> personalData) {
		actualizacionDatosPage.ingresarPiso(personalData.get(5));
	}
	@Step
	public void ingresarApartamento(List<String> personalData) {
		actualizacionDatosPage.ingresarApartamento(personalData.get(6));
	}
	@Step
	public void ingresarEmail(List<String> personalData) {
		actualizacionDatosPage.ingresarEmail(personalData.get(7));
	}
	@Step
	public void ingresarTelefono(List<String> personalData) {
		actualizacionDatosPage.ingresarTelefono(personalData.get(8));
	}
	@Step
	public void ingresarCelular(List<String> personalData) {
		actualizacionDatosPage.ingresarCelular(personalData.get(8));
	}
	@Step
	public void continuar(){
		actualizacionDatosPage.continuar();
	}
	@Step
	public void continuarDireccionCorrespondencia(){
		actualizacionDatosPage.continuarDireccionCorrespondencia();
	}
	@Step
	public void verificarDireccionPreferidaStep() {
		Assert.assertEquals(actualizacionDatosPage.getActualizacionDatosTextToAssert(),actualizacionDatosPage.getActualizacionDeDatosText());
		Assert.assertEquals(actualizacionDatosPage.getDireccionPreferenciaCorrespondenciaTextToAssert(),actualizacionDatosPage.getDireccionPreferenciaCorrespondenciaText());
	}
	@Step
	public void seleccionarDireccionPreferidaCorrespondencia(List<String> personalData) {
		actualizacionDatosPage.seleccionarDireccionPreferidaCorrespondencia(personalData.get(0));
	}
	@Step
	public void verificarReferenciasPersonalesStep() {
		Assert.assertEquals(actualizacionDatosPage.getActualizacionDatosTextToAssert(),actualizacionDatosPage.getActualizacionDeDatosText());
		Assert.assertEquals(actualizacionDatosPage.getReferenciasTextToAssert(),actualizacionDatosPage.getReferenciasText());
	}
	@Step
	public void ingresarNombresPrimeraReferencia(List<String> referenciasPersonales) {
		actualizacionDatosPage.ingresarNombresPrimeraReferencia(referenciasPersonales.get(0));
	}
	@Step
	public void ingresarTelefonoPrimeraReferencia(List<String> referenciasPersonales) {
		actualizacionDatosPage.ingresarTelefonoPrimeraReferencia(referenciasPersonales.get(1));
	}
	@Step
	public void seleccionarRelacionPrimeraReferencia(List<String> referenciasPersonales) {
		actualizacionDatosPage.seleccionarRelacionPrimeraReferencia(referenciasPersonales.get(2));
	}
	@Step
	public void ingresarNombresSegundaReferencia(List<String> referenciasPersonales) {
		actualizacionDatosPage.ingresarNombresSegundaReferencia(referenciasPersonales.get(3));
	}
	@Step
	public void ingresarTelefonoSegundaReferencia(List<String> referenciasPersonales) {
		actualizacionDatosPage.ingresarTelefonoSegundaReferencia(referenciasPersonales.get(4));
	}
	@Step
	public void seleccionarRelacionSegundaReferencia(List<String> referenciasPersonales) {
		actualizacionDatosPage.seleccionarRelacionSegundaReferencia(referenciasPersonales.get(5));
	}
	@Step
	public void continuarReferenciasPersonales(){
		actualizacionDatosPage.continuarReferenciasPersonales();
	}
	@Step
	public void verificarResumenStep(List<String> updatedData){
		Assert.assertEquals(updatedData.get(0),actualizacionDatosResumenPage.getUvText());
		Assert.assertEquals(updatedData.get(1),actualizacionDatosResumenPage.getManzanaText());
		Assert.assertEquals(updatedData.get(2),actualizacionDatosResumenPage.getBarrioText());
		Assert.assertEquals(updatedData.get(3),actualizacionDatosResumenPage.getCalleText());
		Assert.assertEquals(updatedData.get(4),actualizacionDatosResumenPage.getNroPuertaText());
		Assert.assertEquals(updatedData.get(5),actualizacionDatosResumenPage.getPisoText());
		Assert.assertEquals(updatedData.get(6),actualizacionDatosResumenPage.getApartamentoText());
		Assert.assertEquals(updatedData.get(7),actualizacionDatosResumenPage.getEmailText());
		Assert.assertEquals(updatedData.get(8),actualizacionDatosResumenPage.getTelefonoDomicilioText());
		Assert.assertEquals(updatedData.get(9),actualizacionDatosResumenPage.getDireccionPreferidaText());
		Assert.assertEquals(updatedData.get(10),actualizacionDatosResumenPage.getNombresPrimeraReferenciaResumen());
		Assert.assertEquals(updatedData.get(11),actualizacionDatosResumenPage.getTelefonoPrimeraReferenciaResumen());
		Assert.assertEquals(updatedData.get(12),actualizacionDatosResumenPage.getRelacionPrimeraReferenciaResumen());
		Assert.assertEquals(updatedData.get(15),actualizacionDatosResumenPage.getRelacionSegundaReferenciaResumen());
	}
	@Step
	public void continuarResumen(){
		actualizacionDatosPage.continuarResumen();
	}
	@Step
	public void ingresarToken(List<String> updatedData){
		actualizacionDatosResumenPage.ingresarToken(updatedData.get(16));
	}
	@Step
	public void procesarToken(){
		actualizacionDatosResumenPage.procesarToken();
	}
	@Step
	public void verificarMensajeDatosActualizados(List<String> updatedData){
		Assert.assertEquals(updatedData.get(0),actualizacionDatosResumenPage.obtenerMensajeExitoText());
	}
	@Step
	public void confirmar(){
		actualizacionDatosResumenPage.confirmar();
	}
}
