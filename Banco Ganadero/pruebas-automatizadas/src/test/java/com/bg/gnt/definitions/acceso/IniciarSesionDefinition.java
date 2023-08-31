package com.bg.gnt.definitions.acceso;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.bg.gnt.steps.acceso.IniciarSesionStep;
import com.bg.gnt.util.database.UtilsDB;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class IniciarSesionDefinition {



	
	@Steps
	IniciarSesionStep iniciarSesionStep;
	UtilsDB UtilsDB = new UtilsDB();


	
	@Given("Me autentique con un usuario habilitado")
	public void me_autentique_con_un_usuario_habilitado(DataTable userTable) {

		String schemaDB = "AUTOSRV";
		List<String> lUserTable = userTable.row(0);
		iniciarSesionStep.cargarURL();
		String nroPersona = lUserTable.get(1);
		iniciarSesionStep.resetearClaveAcceso(nroPersona,schemaDB);
		iniciarSesionStep.resetearClaveTransaccional(nroPersona,schemaDB);
		iniciarSesionStep.deshabilitarVentanaImagenSeguridad(nroPersona,schemaDB);
		iniciarSesionStep.deshabilitarVentanaCambioClabe(nroPersona,schemaDB);
		iniciarSesionStep.deshabilitarVentanaCambioClaveTrans(nroPersona,schemaDB);
		iniciarSesionStep.iniciarSesion(lUserTable);
		iniciarSesionStep.aceptarContratoSiAparece();
		//iniciarSesionStep.cerrarModalesEmergentes();
		iniciarSesionStep.quitarVentanPersonalizacionUsuario(schemaDB,nroPersona);
	}

	@Then("^El sistema debe mostrarme mis datos$")
	public void el_sistema_debe_mostrarme_mis_datos(List<String> pLstUserData) {
		iniciarSesionStep.verificarDatos(pLstUserData);
	}
	
	@Then("Finalizo la sesion")
	public void finalizo_la_sesion() {
		iniciarSesionStep.finalizarSesion();
	}
	
	@When("Acepto el contrato")
	public void acepto_elcontrato() {
		iniciarSesionStep.aceptarContrato();
	}
	
	@And("Selecciono la imagen de seguridad")
	public void selecciono_la_imagen_de_seguridad() {
		iniciarSesionStep.seleccionarImagen();
	}
	
	@Then("Se muestra un mensaje de actualizacion de datos")
	public void se_muestra_un_mensaje_de_actualizacion_de_datos() {
		iniciarSesionStep.cerrarMsjActualizacion();
	}
	
	@And("Se muestra un mensaje de personalizacion de usuario")
	public void se_muestra_un_mensaje_de_personalizacion_de_usuario() {
		iniciarSesionStep.cerrarMsjPersonalizacion();
	}
	
	
	@And("^Ingreso mi clave actual y la nueva$")
	public void ingreso_mi_clave_actual_y_la_nueva(List<String> pLstClaves) {
		iniciarSesionStep.ingresarClaves(pLstClaves);
	}
	
	@And("^Verifico si se muestra el mensaje correcto$")
	public void verifico_si_se_muestra_el_mensaje_correcto(List<String> pLstDatosMsj) {
		iniciarSesionStep.verificarMensaje(pLstDatosMsj);
	}
	
	@And("^Se muestra un mensaje de alerta$")
	public void se_muestra_un_mensaje_de_alerta(List<String> pLstDatosMensaje) {
		iniciarSesionStep.verificarMensaje(pLstDatosMensaje);
	}
	
	

	
	

}