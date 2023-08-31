package com.bg.gnt.definitions;

import java.util.List;
import com.bg.gnt.steps.TarjetasCreditoStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TarjetasCreditoDefinition {

	@Steps
	TarjetasCreditoStep tarjetasCreditoStep;
	
	@And("^Ingreso los datos para el bloqueo$")
	public void ingreso_los_datos_para_el_bloqueo(List<String> pLstDatosBloqueo) {
		tarjetasCreditoStep.ingresoDatosBloqueo(pLstDatosBloqueo);
	}
	
	@When("^Finalizo el bloqueo (\\d+)$")
	public void finalizo_el_bloqueo(int pIntGanapin) {
		tarjetasCreditoStep.finalizarBloqueo(pIntGanapin);
	}
	
	@Then("^Verifico si el bloqueo fue exitoso$")
	public void verificarMensaje(List<String> pLstDatosMensaje) {
		tarjetasCreditoStep.verificarMensaje(pLstDatosMensaje);
	}
	
	
	
}
