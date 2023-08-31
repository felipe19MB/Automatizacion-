package com.bg.gnt.steps.transferencias.afiliacion;

import java.util.List;

import com.bg.gnt.integrations.transferencias.afiliacion.AfiTercerosIntegration;
import com.bg.gnt.pageobjects.transferencias.afiliacion.AfiTercerosPage;

import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class AfiTercerosStep {

	AfiTercerosPage afiTercerosPage;
	AfiTercerosIntegration afiTercerosIntegration = new AfiTercerosIntegration();

	@Step
	public void updateQuery(String query,String schemaDB){
		int result=0;
		result = afiTercerosIntegration.updateQuery(query,schemaDB);

	}
	@Step
	public void eliminarCtaAfiliada(List<String> pListDatosCuenta) {
		afiTercerosPage.eliminarCuenta(pListDatosCuenta);
	}
	
	@Step
	public void verificarMensaje(String mensaje) {
		assertThat(afiTercerosPage.getMensaje(),containsString(mensaje));
		afiTercerosPage.cerrarMensaje();
	}
	
	@Step
	public void ingresarSegundoFactor(String pIntGanapin) {
		afiTercerosPage.ingresarSegundoFactor(pIntGanapin);
		afiTercerosPage.procesar();
	}
	
	@Step
	public void ingresarSegundoFactor2(int pIntGanapin) {
		afiTercerosPage.ingresarSegundoFactor2(pIntGanapin);
		afiTercerosPage.procesar2();
	}

	@Step
	public void buscarCuenta(String alias){
		afiTercerosPage.buscarCuenta(alias);
	}

	@Step
	public void verificarCuentaAfiliada(List<String> datosAfiliacion){
		String alias = datosAfiliacion.get(1);
		String nroCuenta = datosAfiliacion.get(2);
		String titular = datosAfiliacion.get(3);

		assertThat(afiTercerosPage.getAliasRegistrado(),containsString(alias));
		assertThat(afiTercerosPage.getNroCuentaRegistrado(),containsString(nroCuenta));
		assertThat(afiTercerosPage.getTitularRegistrado(),containsString(titular));
	}

	@Step
	public void clicAgregar() {
		afiTercerosPage.clicAgregar();
	}

	@Step
	public void regDatosBeneficario(List<String> pListDatosBenef) {
		afiTercerosPage.regDatosBenef(pListDatosBenef);
	}
	@Step
	public void eliminarCuentaAfiliada(String ctaDestino, String nroPersona, String alias,String schemaDB){
		String query="UPDATE AUTOSRV.AUT_AFILIACION_CUENTAS SET HABILITADO = 'N' WHERE NRO_PERSONA="+nroPersona+" AND HABILITADO='S' AND REFERENCIA ='"+alias+"' AND NRO_CUENTA_DESTINO ='"+ctaDestino+"'";
		updateQuery(query,schemaDB);
	}
	@Step
	public void modificarEstadpCuenta(String estado, String nroCuenta,String schemaDB){
		String query="UPDATE SALDOS SET C1679='"+estado+"' WHERE CUENTA="+nroCuenta+"";
		updateQuery(query,schemaDB);
	}
}
