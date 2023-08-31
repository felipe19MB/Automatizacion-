package com.bg.gmv.definitions.dashboard;

import com.bg.gmv.steps.dashboard.DashBoardStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class DashBoardDefinition {

    @Steps
    DashBoardStep DashBoardStep;

    @And("^Ingreso a la opcion$")
    public void ingreso_a_la_opcion(List<String> pLstOpciones) {
        DashBoardStep.ingresarOpcion(pLstOpciones);
    }

    @And("^Ingresa a la opcion$")
    public void ingresa_a_la_opcion(List<String> pLstOpciones) {
        DashBoardStep.ingresarOpcion(pLstOpciones);
    }

    @Then("^Deberia mostrarse el nombre del usuario$")
    public void deberia_mostrarse_el_nombre_del_usuario(List<String> pListNombre) {
        DashBoardStep.verificarUsuario(pListNombre);
    }

    @And("^Cierro sesion$")
    public void cierro_sesion(List<String> pListMensaje) {
        DashBoardStep.cerrarSesion(pListMensaje);
    }

}
