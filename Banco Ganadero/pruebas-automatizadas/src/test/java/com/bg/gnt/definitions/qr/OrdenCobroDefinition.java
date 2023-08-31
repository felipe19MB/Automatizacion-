package com.bg.gnt.definitions.qr;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import com.bg.gnt.steps.qr.OrdenCobroStep;
import java.util.List;

public class OrdenCobroDefinition {
    @Steps
    OrdenCobroStep ordenCobroStep;

    @And("^Genero orden de cobro$")
    public void genero_orden_de_cobro(DataTable tableDatosQR){
        List<String> datosQR = tableDatosQR.row(0);
        String nroCuenta = datosQR.get(0);
        String tipoCobro = datosQR.get(1);
        String fechaVencimiento = datosQR.get(2);
        String moneda = datosQR.get(3);
        String monto = datosQR.get(4);
        String descripcion = datosQR.get(5);
        String ganapin = datosQR.get(6);
        ordenCobroStep.seleccionarCtaOrigen(nroCuenta);
        ordenCobroStep.seleccionarTipoCobro(tipoCobro);
        ordenCobroStep.seleccionarFechaVencimiento(fechaVencimiento);
        ordenCobroStep.seleccionarMoneda(moneda);
        ordenCobroStep.ingresarMonto(monto);
        ordenCobroStep.ingresarDescripcion(descripcion);
        ordenCobroStep.generarQR(ganapin);
    }

    @Then("^Se genera un QR con los datos del cobro.$")
    public void se_genero_un_qr_con_los_datos_del_cobro(DataTable tableDatosQR){
        List<String> datosQR = tableDatosQR.row(0);
        ordenCobroStep.verificarDatosQR(datosQR);
        ordenCobroStep.cerrarQR();
    }
}
