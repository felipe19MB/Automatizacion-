package com.bg.gnt.definitions.transferencias;

import java.util.List;

import com.bg.gnt.steps.transferencias.CtaExteriorStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import javax.xml.crypto.Data;

public class CtaExteriorDefinition {

	@Steps
	CtaExteriorStep ctaTercerosStep;
	
	@And("Acepto los terminos y condiciones")
	public void acepto_los_terminos_y_condiciones() {
		ctaTercerosStep.aceptarTerminos();
	}
	
	@And("^Ingreso los cargos$")
	public void ingreso_los_cargos(DataTable datosCargos) {
		List<String> listDatosCargos = datosCargos.row(0);
		ctaTercerosStep.ingresarCargos(listDatosCargos);
	}
	
	@And("^Ingreso el ordenante$")
	public void ingreso_el_ordenante(DataTable pTblDatosOrdenante) {
		List<String> lLstDatosOrdenante = pTblDatosOrdenante.row(0);
		ctaTercerosStep.ingresarOrdenante(lLstDatosOrdenante);
	}
	
	@And("^Selecciono el beneficiario$")
	public void selecciono_el_beneficiario(DataTable pTblDatosBeneficiario) {
		List<String> lLstDatosBeneficiario = pTblDatosBeneficiario.row(0);
		ctaTercerosStep.seleccionarBeneficiario(lLstDatosBeneficiario);
	}
	
	@And("^Ingreso la descripcion$")
	public void ingreso_la_descripcion(DataTable pTblDatosDescripcion) {
		List<String> lLstDatosDescripcion = pTblDatosDescripcion.row(0);
		ctaTercerosStep.ingresarDescripcion(lLstDatosDescripcion);
	}
	
	@And("Finalizo la transferencia {}")
	public void finalizo_la_transferencia(String ganapin) {
		ctaTercerosStep.finalizarTransferencia();
		ctaTercerosStep.ingresarGanapin(ganapin);
	}

	@And("^Obtengo un comprobante de giro al exterior$")
	public void obtengo_un_comprobante_de_giro_al_exterior(DataTable datos) {
		List<String> datosComprobante = datos.row(0);
		ctaTercerosStep.ordenanteCorrecto(datosComprobante);
		//ctaTercerosStep.importeCorrecto(datosComprobante);

	}
	
	
	
}
