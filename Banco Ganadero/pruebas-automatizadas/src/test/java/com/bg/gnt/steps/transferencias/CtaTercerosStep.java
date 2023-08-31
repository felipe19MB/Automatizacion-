package com.bg.gnt.steps.transferencias;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

import com.bg.gnt.pageobjects.transferencias.CtaTercerosPage;
import com.bg.gnt.integrations.transferencias.CtaTercerosIntegration;

import net.thucydides.core.annotations.Step;

public class CtaTercerosStep {

	CtaTercerosPage ctaTercerosPage;
	
	CtaTercerosIntegration CtaTercerosIntegration = new CtaTercerosIntegration();

	
	@Step
	public void updateQuery(String query,String schemaDB) {
		int result = 0;
		result = CtaTercerosIntegration.updateQuery(query,schemaDB);
		assertThat(result, greaterThan(0));

	}
	
	
	
	@Step
	public void ingresarDatosTransferencia(List<String> datosTrans) {
		ctaTercerosPage.seleccionarCtaOrigen(datosTrans.get(0));
		ctaTercerosPage.seleccionarCtaDestino(datosTrans.get(1));
		ctaTercerosPage.continuarTransferencia();
		ctaTercerosPage.ingresarMonto(datosTrans.get(2));
		ctaTercerosPage.seleccionarMoneda(datosTrans.get(3));
		ctaTercerosPage.ingresarGlosas(datosTrans.get(4),datosTrans.get(5));
	}
	
	@Step
	public void finalizarTransferencia(String ganapin) {
		ctaTercerosPage.finalizarTransferencia();
		ctaTercerosPage.ingresarGanapin(ganapin);
		ctaTercerosPage.procesarTransferencia();
	}
	
	@Step
	public void ingresarUIF(List<String> datosUIF) {
		String lStrOrigenUIF	= datosUIF.get(0);
		String lStrDestinoUIF	= datosUIF.get(1);
		String lStrMotivoUIF	= datosUIF.get(2);
		ctaTercerosPage.ingresarUIF(lStrOrigenUIF, lStrDestinoUIF, lStrMotivoUIF);
	}
	
	@Step
	public void verificarComprobante(List<String> datosTrans) {
		ctaTercerosPage.verificarComprobante(datosTrans);

	}
	
	@Step
	public void verificarAsiento(List<String> datosTrans) {
		
		String lTextCtaOrigen	=	datosTrans.get(0);
		
		String lTextNroAsiento=ctaTercerosPage.getTextNroAsiento();
		
		String lTextImpDebito = CtaTercerosIntegration.getField("SELECT CAPITALREALIZADO FROM MOVIMIENTOS_CONTABLES "
				+ "WHERE ASIENTO="+lTextNroAsiento+" AND FECHAPROCESO= TRUNC(SYSDATE) AND CUENTA="+lTextCtaOrigen+"");
		
		String lTextImpDebitoComprobante=ctaTercerosPage.getTextImpDebito();
		
		assertThat(lTextImpDebitoComprobante,containsString(lTextImpDebito));
	}
	
	@Step
	public void verificarMensaje(List<String> pLstDatosMensaje) {
		ctaTercerosPage.verificarMensaje(pLstDatosMensaje);
	}

	@Step
	public void resetearTransDiaRegistrado(String nroPersona, String schemaDB){
		String query="UPDATE AUTOSRV.AUT_PERSONA_ROLES SET TRANS_DIA_REGISTRADO = 0 WHERE NRO_PERSONA = "+nroPersona+"";
		updateQuery(query,schemaDB);
	}
	
}
