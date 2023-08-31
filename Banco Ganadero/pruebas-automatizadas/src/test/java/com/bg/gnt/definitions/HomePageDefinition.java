package com.bg.gnt.definitions;

import java.util.List;

import com.bg.gnt.steps.HomePageStep;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HomePageDefinition {
	
	@Steps
	HomePageStep homePageStep;

	@And("^El saldo disponible en mi cuenta es positivo$")
	public void el_saldo_disponible_en_mi_cuenta_es_positivo(List<String> listCuentas) {
		homePageStep.verificarSaldoDisponible(listCuentas);
	}
	
	@When("^Selecciono el menu$")
	public void selecciono_el_menu(DataTable menuList) {
		List<String> lMenuLista = menuList.row(0);
		//homePageStep.cerrarModalesEmergentes();
		homePageStep.seleccionarMenu(lMenuLista);
	}
	
	@And("^Ingrese con el perfil$")
	public void soy_operador_en_la_empresa(List<String> pDatosEmpresa) {
		homePageStep.cambiarPerfil(pDatosEmpresa);
	}
	

}
