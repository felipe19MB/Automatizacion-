package com.bg.gmv.steps.sinSesionHabilitacionGanamovil;

import com.bg.gmv.pageobjects.sinSesionHabilitacionGanamovil.SinSesionHabilitacionGanamovilPage;
import net.thucydides.core.annotations.Step;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SinSesionHabilitacionGanamovilStep {
    SinSesionHabilitacionGanamovilPage sinSesionHabilitacionGanamovilPage;

    @Step
    public void ingresarHabilitacionGanamovil() {
        sinSesionHabilitacionGanamovilPage.ingresarHabilitacionGanamovil();
    }

   @Step
    public void escribirCI(List<String> datosPersonales) {
        sinSesionHabilitacionGanamovilPage.escribirCI(datosPersonales.get(0));
    }

    @Step
    public void seleccionarExtension(List<String> datosPersonales) {
        sinSesionHabilitacionGanamovilPage.seleccionarExtension(datosPersonales.get(1));
    }

    @Step
    public void escribirDiaNacimiento(List<String> datosPersonales) {
        sinSesionHabilitacionGanamovilPage.escribirDiaNacimiento(datosPersonales.get(2));
    }

    @Step
    public void escribirMesNacimiento(List<String> datosPersonales) {
        sinSesionHabilitacionGanamovilPage.escribirMesNacimiento(datosPersonales.get(3));
    }

    @Step
    public void escribirAnoNacimiento(List<String> datosPersonales){
        sinSesionHabilitacionGanamovilPage.escribirAnoNacimiento(datosPersonales.get(4));
    }

    @Step
    public void escribirCelular(List<String> datosPersonales){
        sinSesionHabilitacionGanamovilPage.escribirCelular(datosPersonales.get(5));
    }

    @Step
    public void escribirNroTarjeta(List<String> datosPersonales){
        sinSesionHabilitacionGanamovilPage.escribirNroTarjeta(datosPersonales.get(6));
    }

    @Step
    public void escribirMesExpiracion(List<String> datosPersonales){
        sinSesionHabilitacionGanamovilPage.escribirMesExpiracion(datosPersonales.get(7));
    }

    @Step
    public void escribirAnoExpiracion(List<String> datosPersonales){
        sinSesionHabilitacionGanamovilPage.escribirAnoExpiracion(datosPersonales.get(8));
    }


    @Step
    public void continuar() {
        sinSesionHabilitacionGanamovilPage.clicButton("Continuar");
    }

    @Step
    public void verificarTextoCorreoElectronico() {
        assertEquals( sinSesionHabilitacionGanamovilPage.getCorreoElectronicoResultadoEsperado(),sinSesionHabilitacionGanamovilPage.getTextCorreoElectronico() );
    }

    @Step
    public void navegarAtras() {
        sinSesionHabilitacionGanamovilPage.navegarAtras();
    }

}
