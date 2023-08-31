package com.bg.gmv.definitions.sinSesionHabilitacionGanamovil;

import com.bg.gmv.steps.sinSesionHabilitacionGanamovil.SinSesionHabilitacionGanamovilStep;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class SinSesionHabilitacionGanamovilDefinition {
    @Steps
    SinSesionHabilitacionGanamovilStep sinSesionHabilitacionGanamovilStep;

    @And("^Ingresa sus datos personales para registar su dispositivo$")
    public void ingresa_sus_datos_personales_para_registar_su_dispositivo(List<String> datosPersonales) {
        sinSesionHabilitacionGanamovilStep.ingresarHabilitacionGanamovil();
        sinSesionHabilitacionGanamovilStep.escribirCI(datosPersonales);
        sinSesionHabilitacionGanamovilStep.seleccionarExtension(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirDiaNacimiento(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirMesNacimiento(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirAnoNacimiento(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirCelular(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirNroTarjeta(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirMesExpiracion(datosPersonales);
        sinSesionHabilitacionGanamovilStep.escribirAnoExpiracion(datosPersonales);
        sinSesionHabilitacionGanamovilStep.navegarAtras();
        sinSesionHabilitacionGanamovilStep.continuar();

    }
    @And("^Sistema verifica el dispositivo en poder del cliente$")
    public void sistema_verifica_dipositivo_poder_cliente() {
        sinSesionHabilitacionGanamovilStep.verificarTextoCorreoElectronico();

    }

}
