package com.bg.gnt.definitions.transferencias.afiliacion;

import java.util.List;

import com.bg.gnt.steps.transferencias.afiliacion.AfiTercerosStep;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AfiTercerosDefinition {

	@Steps
	AfiTercerosStep afiTercerosStep;
	
	@When("Busco el afiliado y hago clic en eliminar$")
	public  void busco_el_afiliado_y_hago_clic_en_eliminar(List<String> pListDatosCuenta ) {
		afiTercerosStep.eliminarCtaAfiliada(pListDatosCuenta);
	}
	
	@When("^Ingreso segundo factor para afiliar	(\\d+)$")
	public void ingreso_segundo_factor_para_afiliar(String Ganapin) {
		afiTercerosStep.ingresarSegundoFactor(Ganapin);
	}
	
	@When("^Ingreso segundo factor para eliminar	(\\d+)$")
	public void ingreso_segundo_factor_para_eliminar(int pIntGanapin) {
		afiTercerosStep.ingresarSegundoFactor2(pIntGanapin);
	}
	
	@Then("Obtengo un mensaje de afiliacion exitosa y la cuenta aparece en la lista$")
	public void obtengo_un_mensaje_de_afiliacion_exitosa_y_la_cuenta_aparece_en_la_lista(DataTable tableDatosAfiliacion) {
		List<String> datosAfiliacion = tableDatosAfiliacion.row(0);
		String mensaje = datosAfiliacion.get(0);
		afiTercerosStep.verificarMensaje(mensaje);
		String alias = datosAfiliacion.get(1);
		afiTercerosStep.buscarCuenta(alias);
		afiTercerosStep.verificarCuentaAfiliada(datosAfiliacion);
	}

	@And("^Registro los datos de la cuenta de terceros y finalizo la afiliacion$")
	public void registro_los_datos_de_la_cuenta_de_terceros_y_finalizo_la_afiliacion(DataTable tableDatosAfiliacion){
		List<String> datosAfiliacion = tableDatosAfiliacion.row(0);
		String ctaDestino = datosAfiliacion.get(0);
		String nroPersona = datosAfiliacion.get(5);
		String alias = datosAfiliacion.get(3);
		String estadoCuenta = " ";
		afiTercerosStep.eliminarCuentaAfiliada(ctaDestino,nroPersona,alias,"AUTOSRV");
		afiTercerosStep.modificarEstadpCuenta(estadoCuenta,ctaDestino,"GANADERO");
		afiTercerosStep.clicAgregar();
		afiTercerosStep.regDatosBeneficario(datosAfiliacion);
		String ganapin = datosAfiliacion.get(4);
		afiTercerosStep.ingresarSegundoFactor(ganapin);
	}
}
