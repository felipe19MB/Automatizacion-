package com.bg.gmv.definitions.acceso;

import com.bg.gmv.steps.acceso.IniciarSesionStep;
import com.bg.gmv.steps.solicitudCreditos.SolicitudConsumaxStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class IniciarSesionDefinition {

    @Steps
    IniciarSesionStep IniciarSesionStep;

    @Given("^Abri la aplicacion$")
    public void abri_la_aplicacion() {

    }

    @Given("^Cliente abre aplicacion$")
    public void cliente_abre_aplicacion() {
        IniciarSesionStep.abrirApp();
    }

    @And("^Ingreso mi usuario$")
    public void ingreso_mi_usuario(List<String> pListClave) {
        IniciarSesionStep.ingresarCodigo(pListClave);
    }

    @And("^Ingresa su usuario$")
    public void ingresa_su_usuario(List<String> pListClave) {
        IniciarSesionStep.ingresarCodigo(pListClave);
    }

    @And("^Ingreso mi password$")
    public void ingreso_mi_password(List<String> pListClave) {
        IniciarSesionStep.ingresarClave(pListClave);
    }

    @And("^Ingresa su password$")
    public void ingresa_su_password(List<String> pListClave) {
        IniciarSesionStep.ingresarClave(pListClave);
    }

    @And("^Inicio sesion$")
    public void inicio_sesion(List<String> credenciales) {
        IniciarSesionStep.ingresarCodigo(credenciales);
        IniciarSesionStep.ingresarPassword(credenciales);
    }

}
