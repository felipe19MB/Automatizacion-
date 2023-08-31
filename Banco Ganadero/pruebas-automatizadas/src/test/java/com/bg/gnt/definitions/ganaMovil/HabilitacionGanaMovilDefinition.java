package com.bg.gnt.definitions.ganaMovil;

import com.bg.gnt.steps.configuracionSeguridad.ActualizacionDatosStep;
import com.bg.gnt.steps.ganaMovil.HabilitacionGanaMovilStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class HabilitacionGanaMovilDefinition {

	@Steps
	HabilitacionGanaMovilStep habilitacionGanaMovilStep;
	@And("^Registro mi dispositivo desde ganamovil$")
	public void registro_mi_dispositivo_desde_ganamovil(DataTable usuarios) {
		List<String> usersData = usuarios.row(0);
		String codigoUsuario = usersData.get(0);
		String estadoDispositivo = usersData.get(1);
		String dbSchema = "GANANET";
		habilitacionGanaMovilStep.quitarDispositivos(codigoUsuario,  dbSchema);
		habilitacionGanaMovilStep.insertarDispositivoPendiente(codigoUsuario,estadoDispositivo,  dbSchema);
	}

	@And("^Selecciono el dispositivo a habilitar$")
	public void selecciono_el_dispositivo_a_habilitar(DataTable estados) {
		List<String> status = estados.row(0);
		habilitacionGanaMovilStep.verificarPantallaHabilitacionDispositivo();
		habilitacionGanaMovilStep.seleccionarDispositivo(status.get(0));
	}
	@When("^Confirmo la habilitacion del dispositivo$")
	public void confirmo_habilitacion_dispositivo(DataTable datosPersonales){
		List<String> personalData = datosPersonales.row(0);
		habilitacionGanaMovilStep.ingresarNumeroTelefono(personalData.get(0));
		habilitacionGanaMovilStep.continuar();
		habilitacionGanaMovilStep.ingresarToken(personalData.get(1));
		habilitacionGanaMovilStep.confirmar();
	}
	@Then("^Mi dispositivo se habilita correctamente$")
	public void mi_dispositivo_habilita_correctamente(DataTable datosPersonales){
		List<String> personalData = datosPersonales.row(0);
		habilitacionGanaMovilStep.verificarHabilitacionExitosa(personalData.get(0));
		habilitacionGanaMovilStep.indicarOK();
		habilitacionGanaMovilStep.verificarCambioDeEstado(personalData.get(1));
	}
	@And("^Selecciono el dispositivo a bloquear$")
	public void selecciono_dispositivo_a_bloquear() {
		//habilitacionGanaMovilStep.seleccionarDispositivo();
	}
	@When("^Confirmo que mi dispositivo se bloquee$")
	public void confirmo_que_mi_dispositivo_se_bloquee(DataTable datosPersonales) {
		List<String> personalData = datosPersonales.row(0);

	}
	@Then("^Mi dispositivo fue bloqueado correctamente$")
	public void mi_dispositivo_fue_bloqueado_correctamente(DataTable datosPersonales) {
		List<String> personalData = datosPersonales.row(0);

	}
}
