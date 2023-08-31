package com.bg.gnt.steps.acceso;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.bg.gnt.integrations.transferencias.acceso.IniciarSesionIntegration;
import com.bg.gnt.pageobjects.HomePage;
import com.bg.gnt.pageobjects.acceso.IniciarSesionPage;
import com.bg.gnt.util.database.UtilsDB;


import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;


public class IniciarSesionStep {
	
	IniciarSesionPage iniciarSesionPage;
	HomePage homePage;
	
	UtilsDB UtilsDB = new UtilsDB();
	IniciarSesionIntegration iniciarSesionIntegration = new IniciarSesionIntegration();

	
	@Step
	public void cargarURL() {
		
		iniciarSesionPage.open();
	}
	@Step
	public void updateQuery(String query,String schemaDB) {
		int result = 0;
		result = iniciarSesionIntegration.updateQuery(query,schemaDB);
		MatcherAssert.assertThat(result, greaterThan(0));

	}
	@Step
	public void updateQueryWithoutAssertion(String query,String schemaDB){
		int result = 0;
		result = iniciarSesionIntegration.updateQuery(query,schemaDB);
	}
	
	@Step
	public void iniciarSesion(List<String> userTable) {
		iniciarSesionPage.autenticar(userTable);
	}
	
	@Step
	public void verificarDatos(List<String> pLstUserData) {
		homePage.verificarDatos(pLstUserData);
	}
	
	@Step
	public void finalizarSesion() {
		homePage.finalizarSesion();
	}
	
	@Step
	public void aceptarContrato() {
		iniciarSesionPage.aceptarContrato();
	}
	
	@Step 
	public void seleccionarImagen() {
		iniciarSesionPage.seleccionarImagen();
	}
	
	
	@Step
	public void cerrarMsjActualizacion() {
		homePage.cerrarMsjActualizacion();
	}
	
	
	@Step
	public void cerrarMsjPersonalizacion() {
		homePage.cerrarMsjPersonalizar();
	}
	
	
	@Step
	public void ingresarClaves(List<String> pLstClaves) {
		String lStrClaveActual 		= pLstClaves.get(0);
		String lStrClaveNueva 		= pLstClaves.get(1);
		iniciarSesionPage.ingresarClaveActual(lStrClaveActual);
		iniciarSesionPage.ingresarClaveNueva(lStrClaveNueva);
		iniciarSesionPage.confirmarClave(lStrClaveNueva);
		iniciarSesionPage.continuar();
	}
	
	@Step
	public void verificarMensaje(List<String>pLstDatosMsj) {
		String lStrMensaje	=	pLstDatosMsj.get(0);
		iniciarSesionPage.verificarMensaje(lStrMensaje);
	}
	
	@Step
	public void cerrarModalesEmergentes(){
		iniciarSesionPage.cerrarModalesEmergentes();

	}

	@Step
	public void resetearClaveAcceso(String nroPersona,String schemaDB){
		String query="UPDATE AUT_USUARIOS SET CLAVE_ACCESO='D44559F602EAB6FD62AC7680DACBFAADD13630335E951F97AF390E9DE176B6DB28512F2E0B9D4FBA5133E8B1C6E8DF59DB3A8AB9D60BE4B97CC9E81DB' WHERE NRO_PERSONA="+nroPersona+"";
		updateQueryWithoutAssertion(query,schemaDB);
	}

	@Step
	public void resetearClaveTransaccional(String nroPersona, String schemaDB){
		String query="UPDATE AUT_USUARIOS SET CLAVE_TRANSACCIONAL='D44559F602EAB6FD62AC7680DACBFAADD13630335E951F97AF390E9DE176B6DB28512F2E0B9D4FBA5133E8B1C6E8DF59DB3A8AB9D60BE4B97CC9E81DB' WHERE NRO_PERSONA="+nroPersona+" AND CLAVE_TRANSACCIONAL IS NOT NULL";
		updateQueryWithoutAssertion(query,schemaDB);
	}
	@Step
	public void deshabilitarVentanaImagenSeguridad(String nroPersona, String schemaDB){
		String query="UPDATE AUT_USUARIOS SET COD_IMAGEN_SEGURIDAD = 5 WHERE NRO_PERSONA = "+nroPersona+" AND COD_IMAGEN_SEGURIDAD = 0";
		updateQueryWithoutAssertion(query,schemaDB);
	}

	@Step
	public void deshabilitarVentanaCambioClabe(String nroPersona,String schemaDB){
		String query="UPDATE AUT_USUARIOS SET REQ_CAMBIO_CLAVE = 'N' WHERE NRO_PERSONA = "+nroPersona+"";
		updateQueryWithoutAssertion(query,schemaDB);
	}
	@Step
	public void deshabilitarVentanaCambioClaveTrans(String nroPersona,String schemaDB){
		String query="UPDATE AUT_USUARIOS SET REQ_CAMBIO_CLAVE_TRANS = 'N' WHERE NRO_PERSONA = "+nroPersona+"";
		updateQueryWithoutAssertion(query,schemaDB);
	}

	@Step
	public void aceptarContratoSiAparece(){
		iniciarSesionPage.aceptarContratoSiAparece();
	}
	@Step
	public void quitarVentanPersonalizacionUsuario(String schemaDB, String nroPersona){
		String query="UPDATE AUT_APROBACION_DOCUMENTOS SET TZ_LOCK=3100000000000000 WHERE COD_DOCUMENTO= 2 AND COD_PERSONA_ROL = (SELECT IDENTIFICADOR FROM AUT_PERSONA_ROLES WHERE NRO_PERSONA="+nroPersona+" ORDER BY IDENTIFICADOR ASC FETCH NEXT 1 ROW ONLY)";
		updateQueryWithoutAssertion(query,schemaDB);
	}
}