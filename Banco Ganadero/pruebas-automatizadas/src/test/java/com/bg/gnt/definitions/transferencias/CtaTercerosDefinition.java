package com.bg.gnt.definitions.transferencias;

import java.util.List;

import com.bg.gnt.steps.transferencias.CtaTercerosStep;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import javax.xml.crypto.Data;

public class CtaTercerosDefinition {
	
	@Steps
	CtaTercerosStep ctaTercerosStep;

	
	@Before("@TIIII")
	public void beforeTransTerceros() {
		//Consulta para habilitar todas las cuentas antes de ejecutar las pruebas
		String	query	=	"UPDATE AUTOSRV.AUT_PERSONA_ROLES SET TRANS_DIA_REGISTRADO = 0 WHERE NRO_PERSONA = 38133";
		//ctaTercerosStep.updateQuery(query);
	}
	
	@After("@TIII")
	public void afterTransTerceros() {
		//Consulta para resetear la cantidad de transacciones por dia a 0 luego de ejecutar las pruebas de trasnferencia
		//String	query	=	"";
		//ctaTercerosStep.updateQuery(query);
	}
	
	@And("^Ingreso los datos para la transferencia$")
	public void ingreso_los_datos_para_la_transferencia(DataTable tableDatosTrans) {
		String schemaDB = "GANADERO";
		List<String> datosTrans = tableDatosTrans.row(0);
		String nroPersona = datosTrans.get(6);
		ctaTercerosStep.resetearTransDiaRegistrado(nroPersona,schemaDB);
		ctaTercerosStep.ingresarDatosTransferencia(datosTrans);
	}

	@When("^Finalizo la transferencia	(\\d+)$")
	public void finalizo_la_transferencia(String ganapin) {
		ctaTercerosStep.finalizarTransferencia(ganapin);
	}
	
	@When("^Ingreso datos UIF$")
	public void ingreso_uif(List<String> datosUIF) {
		ctaTercerosStep.ingresarUIF(datosUIF);
	}
	
	@Then("^Verifico los datos de la transferencia en el comprobante$")
	public void verifico_los_datos_de_la_transferencia_en_el_comprobante(DataTable tableDatosTrans) {
		List<String> datosTrans = tableDatosTrans.row(0);
		ctaTercerosStep.verificarComprobante(datosTrans);
		ctaTercerosStep.verificarAsiento(datosTrans);
	}
	
	@Then("^Verifico el mensaje de solicitud de supervision$")
	public void verifico_el_mensaje_de_solicitud_de_supervision(List<String> pLstDatosMensaje) {
		ctaTercerosStep.verificarMensaje(pLstDatosMensaje);
	}
	

	
}
