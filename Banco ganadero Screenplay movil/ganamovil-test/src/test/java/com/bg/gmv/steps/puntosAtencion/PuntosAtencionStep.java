package com.bg.gmv.steps.puntosAtencion;

import com.bg.gmv.pageobjects.puntosAtencion.PuntosAtencionPage;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertEquals;

public class PuntosAtencionStep {
    PuntosAtencionPage puntosAtencionPage;
    SolicitudConsumaxPage solicitudConsumaxPage;

    @Step
    public void verificarOpcionesPuntosAtencion() {
        solicitudConsumaxPage.clickPermitirUbicacion();
        assertEquals(puntosAtencionPage.getAgenciaText(), puntosAtencionPage.obtenerTextoAgencia());
        assertEquals(puntosAtencionPage.getAutoServicioText(), puntosAtencionPage.obtenerTextoAutoServicio());
        assertEquals(puntosAtencionPage.getMasCercanosText(), puntosAtencionPage.obtenerTextoMasCercanos());
        assertEquals(puntosAtencionPage.getAutoCiudadesText(), puntosAtencionPage.obtenerTextoCiudades());
    }

    @Step
    public void seleccionarAgencias() {
        puntosAtencionPage.clickAgencias();
    }

    @Step
    public void seleccionarAutoservicio() {
        puntosAtencionPage.clickAutoservicio();
    }

    @Step
    public void ingresarPuntosDeAtencion() {
        puntosAtencionPage.clickPuntosDeAtencion();
    }

    @Step
    public void ingresarOpcionMasCercanos() {
        puntosAtencionPage.clickMasCercanos();
    }

    @Step
    public void verificarAgenciasPuntosAtencion() {
        assertEquals(puntosAtencionPage.getAgenciaBlacuttText(), puntosAtencionPage.obtenerTextoAgenciaBlaccut());
        assertEquals(puntosAtencionPage.getAgenciaViedmaText(), puntosAtencionPage.obtenerTextoAgenciaViedma());
        assertEquals(puntosAtencionPage.getAgenciaElCristoText(), puntosAtencionPage.obtenerTextoAgenciaElCristo());
    }

    @Step
    public void verificarAutoservicioPuntosAtencion() {
        assertEquals(puntosAtencionPage.getAutoservicioKioskoSmartOficinaCentralText(), puntosAtencionPage.obtenerTextoAutoservicioKioskoSmartOficinaCentral());
    }

}
