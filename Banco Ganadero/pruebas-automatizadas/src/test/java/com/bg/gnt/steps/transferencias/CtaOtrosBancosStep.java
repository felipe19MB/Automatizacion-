package com.bg.gnt.steps.transferencias;

import java.util.List;

import com.bg.gnt.pageobjects.transferencias.CtaOtrosBancosPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CtaOtrosBancosStep {

	CtaOtrosBancosPage ctaOtrosBancosPage;
	
	@Step
	public void ingresarDatosTransferencia(List<String> datosTrans) {
		ctaOtrosBancosPage.seleccionarCtaOrigen(datosTrans.get(0));
		ctaOtrosBancosPage.seleccionarCtaDestino(datosTrans.get(1));
		ctaOtrosBancosPage.continuarTransferencia();
		ctaOtrosBancosPage.ingresarMonto(datosTrans.get(2));
		ctaOtrosBancosPage.seleccionarMoneda(datosTrans.get(3));
		ctaOtrosBancosPage.ingresarGlosas(datosTrans.get(4),datosTrans.get(5));
	}
	
	
	@Step
	public void finalizarTransferencia(String ganapin) {
		ctaOtrosBancosPage.finalizarTransferencia();
		ctaOtrosBancosPage.ingresarGanapin(ganapin);
		ctaOtrosBancosPage.procesarTransferencia();
	}
	
	@Step
	public void verificarComprobanteOtrosBancos(List<String> datosTransferencia){
		String cuentaOrigen = datosTransferencia.get(0);
		String monto = datosTransferencia.get(1);
		assertThat(ctaOtrosBancosPage.getCuentaOrigenComprobante(),containsString(cuentaOrigen));
		assertThat(ctaOtrosBancosPage.getImporteDebitoComprobante(),containsString(monto));
	}
	
}
