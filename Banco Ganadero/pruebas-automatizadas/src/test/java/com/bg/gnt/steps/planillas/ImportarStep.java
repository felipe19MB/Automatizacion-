package com.bg.gnt.steps.planillas;

import java.util.List;

import com.bg.gnt.pageobjects.planillas.ImportarPage;

import net.thucydides.core.annotations.Step;

public class ImportarStep {

	ImportarPage importarPage;
	
	@Step
	public void seleccionarFormaPago(List<String> datosPlanilla) {
		String lStrFormaPago	= datosPlanilla.get(0);
		importarPage.seleccionarFormaPago(lStrFormaPago);
	}
	
	public void seleccionarConvenio(List<String> datosPlanilla) {
		String lStrNombreConvenio  	= datosPlanilla.get(0);
		String lStrConvenio 		= datosPlanilla.get(1);
		importarPage.seleccionarTipoServicio(lStrConvenio);
	}
	
	public void clickSiguiente(List<String> datosPlanilla) {
		String lStrButton  	= datosPlanilla.get(1);
		importarPage.clickButton(lStrButton);
	}
}
