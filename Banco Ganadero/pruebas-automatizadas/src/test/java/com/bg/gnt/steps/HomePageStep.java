package com.bg.gnt.steps;

import java.util.List;

import com.bg.gnt.integrations.transferencias.HomePageIntegration;
import com.bg.gnt.integrations.transferencias.acceso.IniciarSesionIntegration;
import com.bg.gnt.pageobjects.HomePage;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class HomePageStep {

	HomePage homePage;
	HomePageIntegration homePageIntegration = new HomePageIntegration();
	@Step
	public void verificarSaldoDisponible(List<String> datosCuenta) {
		homePage.verificarSaldoDisponible(datosCuenta);
	}
	
	@Step
	public void seleccionarMenu(List<String> menuList) {
		homePage.seleccionarMenu(menuList);
	}
	@Step
	public void cerrarModalesEmergentes(){
		homePage.cerrarModalesEmergentes();
	}
	
	@Step
	public void cambiarPerfil(List<String> pLstDatosEmpresa) {
		homePage.cambiarPerfil(pLstDatosEmpresa);
		
	}

}
