package com.bg.gmv.steps.acceso;





import java.util.List;

import com.bg.gmv.pageobjects.acceso.AccesoPage;

import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxDB;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
public class IniciarSesionStep {

	AccesoPage AccesoPage;

	SolicitudConsumaxDB consumaxIntegration = new SolicitudConsumaxDB();

	@Step
	public void ingresarCodigo(List<String> pListUsuario) {
		
		AccesoPage.ingresarCodigo(pListUsuario.get(0));
		AccesoPage.clicVerificar();
	}
	
	@Step
	public void ingresarClave(List<String> pListClave) {
		AccesoPage.ingresarClave(pListClave.get(0));
		AccesoPage.clicIngresar();
	}

	@Step
	public void abrirApp() {
		AccesoPage.clickCancelDebugMode();
	}
	@Step
	public void ingresarPassword(List<String> pListClave) {
		AccesoPage.ingresarClave(pListClave.get(1));
		AccesoPage.clicIngresar();
	}



}
