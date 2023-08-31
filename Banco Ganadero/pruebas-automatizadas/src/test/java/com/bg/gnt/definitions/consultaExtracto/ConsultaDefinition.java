package com.bg.gnt.definitions.consultaExtracto;
import com.bg.gnt.steps.consultaExtracto.ConsultaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ConsultaDefinition {
    @Steps
    ConsultaStep consultaStep;

    @And("^Selecciono detalle de cuenta$")
    public void selecciono_detalle_cuenta(String cuenta){
        consultaStep.consultaDetalleStep(cuenta);
    }

    @Then("^Verifico detalle de cuenta$")
    public void verifico_detalle_de_cuenta(DataTable datosDetalleCuenta){
        List<String> datosDetalle=datosDetalleCuenta.row(0);
        consultaStep.verificaDetalleCuentaStep(datosDetalle.get(0),
                datosDetalle.get(1),datosDetalle.get(2),datosDetalle.get(3));
    }
}
