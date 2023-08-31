package com.bg.gnt.definitions.configuracionSeguridad;

import com.bg.gnt.steps.configuracionSeguridad.ActualizacionDatosStep;
import com.bg.gnt.steps.transferencias.afiliacion.AfiOtrosBancosStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ActualizacionDatosDefinition {

	@Steps
	ActualizacionDatosStep actualizacionDatosStep;
	

	@And("^Ingresa datos personales$")
	public void ingresa_datos_personales(DataTable datosPersonales) {
		List<String> personalData = datosPersonales.row(0);
		actualizacionDatosStep.ingresarUV(personalData);
		actualizacionDatosStep.ingresarManzana(personalData);
		actualizacionDatosStep.ingresarBarrio(personalData);
		actualizacionDatosStep.ingresarCalle(personalData);
		actualizacionDatosStep.ingresarNroPuerta(personalData);
		actualizacionDatosStep.ingresarPiso(personalData);
		actualizacionDatosStep.ingresarApartamento(personalData);
		actualizacionDatosStep.ingresarEmail(personalData);
		actualizacionDatosStep.ingresarTelefono(personalData);
		actualizacionDatosStep.ingresarCelular(personalData);
		actualizacionDatosStep.continuar();
	}
	@And("^Selecciona direccion preferida de correspondencia$")
	public void selecciona_direccion_preferida_correspondencia(DataTable direccionPreferida) {
		List<String> preferredAdress = direccionPreferida.row(0);
		actualizacionDatosStep.verificarDireccionPreferidaStep();
		actualizacionDatosStep.seleccionarDireccionPreferidaCorrespondencia(preferredAdress);
		actualizacionDatosStep.continuarDireccionCorrespondencia();
	}
	@And("^Ingresa datos de referencias personales$")
	public void ingresa_datos_de_referencias_personales(DataTable referenciasPersonales) {
		List<String> personalReferences = referenciasPersonales.row(0);
		actualizacionDatosStep.verificarReferenciasPersonalesStep();
		actualizacionDatosStep.ingresarNombresPrimeraReferencia(personalReferences);
		actualizacionDatosStep.ingresarTelefonoPrimeraReferencia(personalReferences);
		actualizacionDatosStep.seleccionarRelacionPrimeraReferencia(personalReferences);
		actualizacionDatosStep.ingresarNombresSegundaReferencia(personalReferences);
		actualizacionDatosStep.ingresarTelefonoSegundaReferencia(personalReferences);
		actualizacionDatosStep.seleccionarRelacionSegundaReferencia(personalReferences);
		actualizacionDatosStep.continuarReferenciasPersonales();
	}
	@When("^Verifica y confirma el resumen de los datos actualizados$")
	public void verifica_y_confirma_el_resumen_de_los_datos_actualizados(DataTable datosActualizados) {
		List<String> updatedData = datosActualizados.row(0);
		actualizacionDatosStep.verificarResumenStep(updatedData);
		actualizacionDatosStep.continuarResumen();
		actualizacionDatosStep.ingresarToken(updatedData);
		actualizacionDatosStep.procesarToken();

	}
	@Then("^Sus datos se actualizan correctamente$")
	public void sus_datos_se_actualizan_correctamente(DataTable mensajeExito) {
		List<String> mensajes = mensajeExito.row(0);
		actualizacionDatosStep.verificarMensajeDatosActualizados(mensajes);
		actualizacionDatosStep.confirmar();
	}
}
