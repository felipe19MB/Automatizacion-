package com.bg.gnt.steps.qr;

import com.bg.gnt.pageobjects.qr.OrdenCobroPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class OrdenCobroStep {


    OrdenCobroPage ordenCobroPage;

    @Step
    public void seleccionarCtaOrigen(String ctaOrigen){
        ordenCobroPage.seleccionarCtaOrigen(ctaOrigen);
    }
    @Step
    public void seleccionarTipoCobro(String tipoCobro){
        ordenCobroPage.seleccionarTipoCobro(tipoCobro);
    }
    @Step
    public void seleccionarFechaVencimiento(String fechaVencimiento){
        ordenCobroPage.seleccionarFechaVencimiento(fechaVencimiento);
    }
    @Step
    public void seleccionarMoneda(String moneda){
        ordenCobroPage.seleccionarMoneda(moneda);
    }
    @Step
    public void ingresarMonto(String monto){
        ordenCobroPage.ingresarMonto(monto);
    }
    @Step
    public void ingresarDescripcion(String descripcion){
        ordenCobroPage.ingresarDescripcion(descripcion);
    }

    @Step
    public void generarQR(String ganapin){
        ordenCobroPage.clicGenerar();
        ordenCobroPage.ingresarSegundoFactor(ganapin);
        ordenCobroPage.clicProcesar();
    }
    @Step
    public void verificarDatosQR(List<String> datosQR){

    }
    @Step
    public void cerrarQR(){
        ordenCobroPage.cerrarQR();
    }
}
