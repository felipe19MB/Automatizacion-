package com.bg.gnt.steps.transferencias;

import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.bg.gnt.pageobjects.transferencias.CtaExteriorPage;

import net.thucydides.core.annotations.Step;

public class CtaExteriorStep {
	
	CtaExteriorPage ctaExteriorPage;
	
	@Step
	public void aceptarTerminos() {
		ctaExteriorPage.aceptarTerminos();
		ctaExteriorPage.siguiente();
	}
	
	@Step
	public void ingresarCargos(List<String> pLstDatosCargos) {
		String lStrNroCuenta 	= pLstDatosCargos.get(0);
		String lStrMonto 		= pLstDatosCargos.get(1);
		String lStrMoneda		= pLstDatosCargos.get(2);
		String lStrTipoCargo	= pLstDatosCargos.get(3);
		String lStrNombreFact	= pLstDatosCargos.get(4);
		String lStrNit			= pLstDatosCargos.get(5);
		ctaExteriorPage.seleccionarCtaOrigen(lStrNroCuenta);
		ctaExteriorPage.seleccionarMoneda(lStrMoneda);
		ctaExteriorPage.ingresarMonto(lStrMonto);
		ctaExteriorPage.ingresarNombreFact(lStrNombreFact);
		ctaExteriorPage.ingresarNroFact(lStrNit);
		ctaExteriorPage.seleccionarCargo(lStrTipoCargo);
		ctaExteriorPage.siguiente();
	}
	
	@Step
	public void ingresarOrdenante(List<String> pLstDatosOrdenante) {
		String lStrMail 		= pLstDatosOrdenante.get(0);
		String lStrTelefono		= pLstDatosOrdenante.get(1);
		
		ctaExteriorPage.ingresarMail(lStrMail);
		ctaExteriorPage.ingresarTelefono(lStrTelefono);
		ctaExteriorPage.siguiente();
	}
	@Step
	public void seleccionarBeneficiario(List<String> pLstDatosBeneficiario ) {
		String lStrBeneficiario	= pLstDatosBeneficiario.get(0);
		ctaExteriorPage.seleccionarBeneficiario(lStrBeneficiario);
		ctaExteriorPage.siguiente();
	}
	
	@Step
	public void ingresarDescripcion(List<String> pLstDatosDescripcion) {
		String lStrCodASFI		= pLstDatosDescripcion.get(0);
		String lStrTipoDoc		= pLstDatosDescripcion.get(1);
		String lStrArchivo		= pLstDatosDescripcion.get(2);
		String lStrMotivo		= pLstDatosDescripcion.get(3);
		String lStrAgencia		= pLstDatosDescripcion.get(4);
		
		ctaExteriorPage.ingresarCodASFI(lStrCodASFI);
		//ctaExteriorPage.ingresarTipoDoc(lStrTipoDoc);
		//ctaExteriorPage.seleccionarArchivo(lStrArchivo);
		ctaExteriorPage.ingresarMotivo(lStrMotivo);
		ctaExteriorPage.ingresarAgencia(lStrAgencia);	
		ctaExteriorPage.siguiente();
	}
	

	
	@Step
	public void finalizarTransferencia() {
		ctaExteriorPage.finalizar();
	}
	
	
	@Step
	public void ingresarGanapin(String ganapin) {
		ctaExteriorPage.ingresarSegFactor(ganapin);
		ctaExteriorPage.clickButton("Procesar");
	}
	
	@Step
	public void ordenanteCorrecto(List<String> datosComprobante) {
		String importeUSD = datosComprobante.get(4);
		String cargoUSD = datosComprobante.get(5);
		String itfcomisionUSD = datosComprobante.get(6);
		String itfCapitalUSD = datosComprobante.get(7);
		String cargoCorresponsal = datosComprobante.get(8);
		String total = datosComprobante.get(9);
		assertThat(ctaExteriorPage.getValor("MONTO A ENVIAR"), containsString(importeUSD));
		assertThat(ctaExteriorPage.getValor("CARGO POR TRANSFERENCIA"), containsString(cargoUSD));
		assertThat(ctaExteriorPage.getValor("RETENCION DE ITF COMISION"), containsString(itfcomisionUSD));
		assertThat(ctaExteriorPage.getValor("RETENCION DE ITF CAPITAL"), containsString(itfCapitalUSD));
		assertThat(ctaExteriorPage.getValor("CARGO POR CORRESPONSAL"), containsString(cargoCorresponsal));
		assertThat(ctaExteriorPage.getValor("Total"), containsString(total));
	}
	
}
