package com.bg.gnt.definitions.transferencias.afiliacion;

import java.util.List;

import com.bg.gnt.steps.transferencias.afiliacion.AfiOtrosBancosStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
public class AfiOtrosBancosDefinition {

	@Steps
	AfiOtrosBancosStep afiOtrosBancosStep;
	
	@When("Busco el afiliado ACH y hago clic en eliminar$")
	public  void busco_el_afiliado_ach_y_hago_clic_en_eliminar(List<String> pListDatosCuenta ) {
		afiOtrosBancosStep.eliminarCtaAfiliada(pListDatosCuenta);
	}
	
	@When("Registro los datos del beneficiario ACH$")
	public void registro_los_datos_del_beneficiario_ach(List<String> pListDatosBenef) {
		afiOtrosBancosStep.regDatosBeneficario(pListDatosBenef);
	}
	
}
