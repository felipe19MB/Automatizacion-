package com.bg.gmv.steps.prestamos;

import com.bg.gmv.pageobjects.prestamo.PrestamoPage;
import com.bg.gmv.pageobjects.transferencia.TransferenciaPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class PagosRecientesPrestamoStep  {

    PrestamoPage prestamoPage;
    @Step
    public void seleccionarCuentaOrigen(List<String> datosPrestamos){
        String nroCuenta = datosPrestamos.get(0);
        prestamoPage.seleccionarCuenta(nroCuenta);
    }
    @Step
    public void seleccionarPagosRecientesPrestamo(){
        String textAction="Pagos Recientes Préstamo";
        prestamoPage.seleccionarAccion(textAction);
    }
    @Step
    public void verificarPagosRecientesPrestamo(List<String> datosPrestamosRec){

        String montoDelPago = datosPrestamosRec.get(1);
        String mesDelPago = datosPrestamosRec.get(0);
        assertThat(prestamoPage.getMontoDelPago(mesDelPago),containsString(montoDelPago));


    }

}
