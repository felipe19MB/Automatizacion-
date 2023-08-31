package com.bg.gnt.steps.consultaExtracto;

import com.bg.gnt.pageobjects.consultaExtracto.ConsultaPage;
import net.thucydides.core.annotations.Step;

public class ConsultaStep {
    ConsultaPage consultaPage;
    @Step
    public void consultaDetalleStep(String cuenta){
        consultaPage.seleccionarDetalleCuenta(cuenta);
    }
    public void verificaDetalleCuentaStep(String cuenta,String tipoCuenta, String producto, String moneda){
       consultaPage.verificaDetalleCuentaPage(cuenta,tipoCuenta,producto,moneda);

    }
}
