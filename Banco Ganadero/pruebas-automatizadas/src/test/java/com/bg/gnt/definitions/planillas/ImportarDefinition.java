package com.bg.gnt.definitions.planillas;

import java.util.List;

import com.bg.gnt.steps.planillas.ImportarStep;


import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class ImportarDefinition {
	
	@Steps
	ImportarStep importarStep;

	@And("^Selecciono forma de pago$")
	public void selecciono_forma_de_pago(List<String> datosPlanilla) {
		importarStep.seleccionarFormaPago(datosPlanilla);
		importarStep.clickSiguiente(datosPlanilla);
	}

	@And("^Verifico que el convenio SFTP no se muestre en la lista$")
	public void verifico_que_el_convenio_SFTP_no_se_muestre_en_la_lista(List<String> datosPlanilla) {
		importarStep.seleccionarConvenio(datosPlanilla);
	}
	
	
}
