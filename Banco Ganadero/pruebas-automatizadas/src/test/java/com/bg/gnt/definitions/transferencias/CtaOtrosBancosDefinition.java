package com.bg.gnt.definitions.transferencias;


import java.util.List;

import com.bg.gnt.steps.transferencias.CtaOtrosBancosStep;

import com.bg.gnt.steps.transferencias.CtaTercerosStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CtaOtrosBancosDefinition {

	@Steps
	CtaOtrosBancosStep ctaOtrosBancosStep;
	@Steps
	CtaTercerosStep ctaTercerosStep;

	@And("^Realizo una transferencia a cuentas de otros bancos$")
	public void realizo_una_transferencia_a_otros_bancos(DataTable datosTransferencia){
		String schemaDB = "GANADERO";
		List<String> datosTrans = datosTransferencia.row(0);
		String nroPersona = datosTrans.get(6);
		ctaTercerosStep.resetearTransDiaRegistrado(nroPersona,schemaDB);
		ctaOtrosBancosStep.ingresarDatosTransferencia(datosTrans);
		String ganapin = datosTrans.get(7);
		ctaOtrosBancosStep.finalizarTransferencia(ganapin);
	}

	@Then("^Obtengo un comprobante de transferencia a otros bancos$")
	public void obtengo_un_comprobante_de_transferencia_a_otros_bancos(DataTable datosTransferencia){
		List<String> datosTrans = datosTransferencia.row(0);
		ctaOtrosBancosStep.verificarComprobanteOtrosBancos(datosTrans);

	}


}
