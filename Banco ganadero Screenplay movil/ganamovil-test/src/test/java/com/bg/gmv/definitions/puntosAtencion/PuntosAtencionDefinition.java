package com.bg.gmv.definitions.puntosAtencion;

import com.bg.gmv.steps.puntosAtencion.PuntosAtencionStep;
import com.bg.gmv.steps.solicitudCreditos.SolicitudConsumaxStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class PuntosAtencionDefinition {
    @Steps
    PuntosAtencionStep puntosAtencionStep;

    @And("^Ingreso a la opcion puntos de atencion$")
    public void ingreso_opcion_puntos_de_atencion() {
        puntosAtencionStep.ingresarPuntosDeAtencion();
    }

    @Then("^Cliente puede visualizar el mapa con las opciones disponibles$")
    public void cliente_puede_visualizar_mapa_con_opciones_disponibles() {
        puntosAtencionStep.verificarOpcionesPuntosAtencion();
    }

    @And("^Cliente selecciona la opcion Agencias$")
    public void cliente_selecciona_opcion_agencias() {
        puntosAtencionStep.seleccionarAgencias();
    }

    @Then("^Cliente puede filtrar agencias mas cercanas disponibles$")
    public void cliente_puede_filtrar_agencias_mas_cercanas_disponibles() {
        puntosAtencionStep.ingresarOpcionMasCercanos();
        puntosAtencionStep.verificarAgenciasPuntosAtencion();
    }

    @And("^Cliente selecciona la opcion Autoservicio$")
    public void cliente_selecciona_opcion_autoservicio() {
        puntosAtencionStep.seleccionarAutoservicio();
    }

    @Then("^Cliente puede filtrar puntos autoservicio disponibles$")
    public void cliente_puede_filtrar_puntos_autoservicio_disponibles() {
        puntosAtencionStep.ingresarOpcionMasCercanos();
        puntosAtencionStep.verificarAutoservicioPuntosAtencion();
    }

}
