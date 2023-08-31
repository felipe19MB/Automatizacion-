package com.bg.gmv.definitions.habilitacion;

import com.bg.gmv.steps.habilitacion.HabilitacionStep;
import com.bg.gmv.steps.puntosAtencion.PuntosAtencionStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class HabilitacionDefinition {
    @Steps
    HabilitacionStep habilitacionStep;

    @And("^Indica que quiero registrar ganamovil$")
    public void indica_que_quiero_registrar_ganamovil() {
        habilitacionStep.confirmarRegistrarGanamovil();
    }
    @And("^Elimina internamente dispositivo de la persona$")
    public void eliminar_internamente_dispositivo_persona(List<String> personas) {
        habilitacionStep.eliminarDispositivosPorPersona(personas);
    }

    @And("^Verifica registro exitoso$")
    public void verifica_registro_exitoso() {
        habilitacionStep.verificarRegistroExitoso();
    }

    @And("^Acepta registro exitoso$")
    public void acepta_registro_exitoso() {
        habilitacionStep.aceptarRegistroExitoso();
    }

    @And("^Habilitar dispositivo para el usuario internamente$")
    public void habilitar_dispositivo_para_usuario_internamente(List<String> personas) {
        habilitacionStep.habilitarDispositivo(personas);
    }

    @Then("^Deberia mostrarse el menu principal$")
    public void deberia_mostrarse_el_menu_principal(List<String> mensajes) {
        habilitacionStep.verificarMenuPrincipal(mensajes);
    }

    @And("^Se enrola al usuario$")
    public void se_enrola_al_usuario(List<String> usuarios) {
        habilitacionStep.confirmarRegistrarGanamovil();
        habilitacionStep.verificarRegistroExitoso();
        habilitacionStep.aceptarRegistroExitoso();
        habilitacionStep.habilitarDispositivo(usuarios);
    }

}
