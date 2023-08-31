package com.bg.gnt.definitions.tarjetasDebito;

import com.bg.gnt.steps.tarjetas_debito.ComprasPorInternetStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ComprasPorInternetDefinition {

    @Steps
    ComprasPorInternetStep comprasPorInternetStep;

    @And("^Selecciono rango hoy con un importe (\\d+)$$")
    public void selecciono_rango_hoy_con_un_importe(String importe) {
        comprasPorInternetStep.habilitarComprasHoy(importe);
    }

    @And("^Selecciono rango temporal con un importe$")
    public void selecciono_rango_temporal_con_un_importe(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        String importe = lUserTable.get(0);
        String fechaDesde = lUserTable.get(1);
        String fechaHasta = lUserTable.get(2);
        comprasPorInternetStep.habilitarComprasRangos(importe, fechaDesde, fechaHasta);
    }
    @When("^Finalizo el Cambio Compra Hoy ingresando GanaPin (\\d+)$$")
    public void finalizo_el_bloqueo_TD(int pIntGanapin) {
        comprasPorInternetStep.ingresarGanapin(pIntGanapin);
    }

    @Then("^Verifico si el cambio fue exitoso fue exitoso$")
    public void verificarMensaje(DataTable userTable) {
        String schemaDB = "GANADERO";
        List<String> lUserTable = userTable.row(0);
        String nroPersona = lUserTable.get(1);
        comprasPorInternetStep.verificarMensaje(lUserTable);
        comprasPorInternetStep.habilitarTarjeta(nroPersona,schemaDB);
    }
}
