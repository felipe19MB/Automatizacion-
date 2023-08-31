package com.bg.gmv.steps.cuentas;

import com.bg.gmv.pageobjects.cuentas.ExtractoPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExtractoStep {

    ExtractoPage extractoPage;
    @Step
    public void seleccionarCuenta(String nroCuenta){
        extractoPage.seleccionarCuenta(nroCuenta);
    }

    @Step
    public void seleccionarOpcion(String opcion){
        extractoPage.seleccionarOpcion(opcion);
    }

    @Step
    public void seleccionarPeriodoOtrosMeses(String periodo){
        extractoPage.clicBotonPeriodo();
        extractoPage.seleccionarOpcion("Otros Meses");
        extractoPage.seleccionarPeriodoOtrosMeses(periodo);
    }
    @Step
    public void verificarExtracto(String descripcion, String importe){
        String importeExtracto = extractoPage.obtenerImporteExtracto(descripcion);
        assertThat(importeExtracto,containsString(importe));
    }
}
