package com.bg.gnt.steps.ganaMovil;

import com.bg.gnt.integrations.transferencias.ganaMovil.GanaMovilIntegration;
import com.bg.gnt.pageobjects.ganaMovil.HabilitacionGanaMovilPage;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class HabilitacionGanaMovilStep {

	HabilitacionGanaMovilPage habilitacionGanaMovilPage;
	GanaMovilIntegration ganaMovilIntegration = new GanaMovilIntegration();
	
	@Step
	public void seleccionarDispositivo(String estado) {
		habilitacionGanaMovilPage.seleccionarDispositivo(estado);
	}

	@Step
	public void verificarPantallaHabilitacionDispositivo(){
		Assert.assertEquals(habilitacionGanaMovilPage.getHabilitacionDispositivoTextToAssert(),habilitacionGanaMovilPage.getHabilitacionDispositivoText());
	}
	@Step
	public void ingresarNumeroTelefono(String numeroTelefono){
		habilitacionGanaMovilPage.ingresarNumeroTelefono(numeroTelefono);
	}
	@Step
	public void ingresarToken(String token){
		habilitacionGanaMovilPage.ingresarToken(token);
	}
	@Step
	public void confirmar(){
		habilitacionGanaMovilPage.procesarToken();
	}
	@Step
	public void continuar(){
		habilitacionGanaMovilPage.continuar();
	}
	@Step
	public void indicarOK(){
		habilitacionGanaMovilPage.confirmar();
	}
	@Step
	public void verificarHabilitacionExitosa(String mensaje){
		String mensajeText = habilitacionGanaMovilPage.obtenerMensajeExitoText();
		String imei = habilitacionGanaMovilPage.getImeiMac();
		assertThat(mensajeText).contains(mensaje);
		assertThat(mensajeText).contains(imei);
	}
	@Step
	public void verificarCambioDeEstado(String estadoEsperado){
		String estadoText = habilitacionGanaMovilPage.obtenerEstadoDispositivo();
		Assert.assertEquals(estadoEsperado,estadoText);
	}
	@Step
	public void deleteQueryWithoutAssertion(String query,String schemaDB){
		int result = 0;
		result = ganaMovilIntegration.deleteQuery(query,schemaDB);
	}
	@Step
	public void insertQueryWithoutAssertion(String query,String schemaDB){
		int result = 0;
		result = ganaMovilIntegration.insertQuery(query,schemaDB);
	}
	@Step
	public void quitarDispositivos(String codigoUsuario,String dbSchema){
		String query="DELETE FROM GANANET.CAS_USUARIOXCANAL cu WHERE CODUSUARIO = "+codigoUsuario+"";
		deleteQueryWithoutAssertion(query, dbSchema);
	}
	@Step
	public void insertarDispositivoPendiente(String codigoUsuario,String estadoDispositivo, String dbSchema){
		String query="INSERT INTO GANANET.CAS_USUARIOXCANAL "+
		"(COD_USUARIOXCANAL, CODUSUARIO, ESTADO, FECHA_ULTCONEXION, CANAL, IDENTIFICADORDISPOSITIVO, INTENTOS_FALLIDOS, HORA_ULTCONEXION, FECHA_ULTEVENTO, HORA_ULTEVENTO, TZ_LOCK, NROSESION, FECHA_ALTA, MODELO, SISTEMA_OPERATIVO, TELEFONO, USUARIO_CREACION, FECHA_CREACION, USUARIO__MODIFICACION, FECHA_MODIFICACION) "+
		"VALUES((SELECT MAX(COD_USUARIOXCANAL) FROM GANANET.CAS_USUARIOXCANAL)+1, "+"'"+codigoUsuario+"'"+", "+"'"+estadoDispositivo+"'"+", SYSDATE, '1', 'dd7902b8543646e4', NULL, '13:21', SYSDATE, '13:18', 0, '01072022131712dd7902b8543646e4', SYSDATE, 'Redmi Note 8', 'ANDROID', '0', 'BKM', SYSDATE, NULL, NULL)";
		insertQueryWithoutAssertion(query, dbSchema);
	}
}
