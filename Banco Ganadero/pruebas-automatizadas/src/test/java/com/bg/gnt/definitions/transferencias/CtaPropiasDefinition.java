package com.bg.gnt.definitions.transferencias;

import com.bg.gnt.steps.transferencias.CtaPropiasStep;

import com.bg.gnt.steps.transferencias.CtaTercerosStep;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class CtaPropiasDefinition {
	@Steps
	CtaPropiasStep ctaPropiasStep;
	@Steps
	CtaTercerosStep ctaTercerosStep;

	@And("^Realizo una transferencia a cuentas propias$")
	public void realizo_una_transferencia_a_cuentas_propias(DataTable datosTransferencia){
		String schemaDB = "GANADERO";
		List<String> datosTrans = datosTransferencia.row(0);
		String nroPersona = datosTrans.get(6);
		ctaTercerosStep.resetearTransDiaRegistrado(nroPersona,schemaDB);
		ctaPropiasStep.ingresarDatosTransferencia(datosTrans);
		String ganapin = datosTrans.get(7);
		ctaPropiasStep.finalizarTransferencia(ganapin);
	}

	@Then("^Obtengo un comprobante de transferencia a cuentas propias$")
	public void obtengo_un_comprobante_de_transferencia_a_cuentas_propias(DataTable datosTransferencia){
		List<String> datosTrans = datosTransferencia.row(0);
		ctaPropiasStep.verificarComprobanteCtaPropias(datosTrans);
	}
}
