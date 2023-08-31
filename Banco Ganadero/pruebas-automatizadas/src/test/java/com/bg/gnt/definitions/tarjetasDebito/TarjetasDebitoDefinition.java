package com.bg.gnt.definitions.tarjetasDebito;

import com.bg.gnt.steps.tarjetas_debito.BloqueoTarjetaStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class TarjetasDebitoDefinition {
    @Steps
    BloqueoTarjetaStep bloqueoTarjetaStep;

    @And("^Ingreso el motivo para el bloqueo$")
    public void ingreso_los_datos_para_el_bloqueo() {
        bloqueoTarjetaStep.ingresarMotivo();
    }

    @When("^Finalizo el bloqueo ingreso GanaPin (\\d+)$$")
    public void finalizo_el_bloqueo_TD(int pIntGanapin) {
        bloqueoTarjetaStep.ingresarGanapin(pIntGanapin);
    }

    @Then("^Verifico si el bloqueo de tarjeta fue exitoso$")
    public void verificarMensaje(DataTable userTable) {
        String schemaDB = "AUTOSRV";
        List<String> lUserTable = userTable.row(0);
        String nroPersona = lUserTable.get(1);
        bloqueoTarjetaStep.verificarMensaje(lUserTable);
        bloqueoTarjetaStep.habilitarTarjeta(nroPersona,schemaDB);
    }
}
