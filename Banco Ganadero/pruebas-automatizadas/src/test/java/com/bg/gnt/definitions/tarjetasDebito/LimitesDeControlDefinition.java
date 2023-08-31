package com.bg.gnt.definitions.tarjetasDebito;

import com.bg.gnt.steps.tarjetas_debito.LimitesDeControlStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class LimitesDeControlDefinition {
    @Steps
    LimitesDeControlStep limitesDeControlStep;

    @And("^Cambio el limite de control$")
    public void cambio_el_limite_de_control(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        String importe = lUserTable.get(0);
        String cantidad = lUserTable.get(1);
        String fechaVencimiento = lUserTable.get(2);
        limitesDeControlStep.cambiarLimiteControl(importe, cantidad, fechaVencimiento);
    }
    @When("^Finalizo el Cambio Limite Control ingresando GanaPin (\\d+)$$")
    public void finalizo_el_bloqueo_TD(int pIntGanapin) {
        limitesDeControlStep.ingresarGanapin(pIntGanapin);
    }

    @Then("^Verifico si el cambio Limite Control fue exitoso fue exitoso$")
    public void verificarMensaje(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        limitesDeControlStep.verificarMensaje(lUserTable);
    }

}
