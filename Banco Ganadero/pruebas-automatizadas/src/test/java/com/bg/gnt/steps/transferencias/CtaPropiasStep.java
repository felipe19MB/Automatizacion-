package com.bg.gnt.steps.transferencias;
import java.util.List;
import com.bg.gnt.pageobjects.transferencias.CtaPropiasPage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;



public class CtaPropiasStep {
	CtaPropiasPage ctaPropiasPage;

	@Step
	public void ingresarDatosTransferencia(List<String> datosTrans) {
		ctaPropiasPage.seleccionarCtaOrigen(datosTrans.get(0));
		ctaPropiasPage.seleccionarCtaDestino(datosTrans.get(1));
		ctaPropiasPage.continuarTransferencia();
		ctaPropiasPage.ingresarMonto(datosTrans.get(2));
		ctaPropiasPage.seleccionarMoneda(datosTrans.get(3));
		ctaPropiasPage.ingresarGlosas(datosTrans.get(4),datosTrans.get(5));
	}

	@Step
	public void finalizarTransferencia(String ganapin) {
		ctaPropiasPage.finalizarTransferencia();
		ctaPropiasPage.ingresarGanapin(ganapin);
		ctaPropiasPage.procesarTransferencia();
	}


	@Step
	public void verificarComprobanteCtaPropias(List<String> datosTransferencia){
		String cuentaOrigen = datosTransferencia.get(0);
		String monto = datosTransferencia.get(1);
		assertThat(ctaPropiasPage.getCuentaOrigenComprobante(),containsString(cuentaOrigen));
		assertThat(ctaPropiasPage.getImporteDebitoComprobante(),containsString(monto));
	}

}
