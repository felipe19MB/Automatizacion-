package com.bg.gnt.definitions.tarjetasDebito;

import com.bg.gnt.steps.tarjetas_debito.CuentasRelacionadasStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class CuentasRelacionadasDefinition {
    @Steps
    CuentasRelacionadasStep cuentasRelacionadasStep;

    @And("^Asignar cuenta a TD$")
    public void cambio_el_limite_de_control(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        String cuenta = lUserTable.get(0);
        cuentasRelacionadasStep.agregarCuenta(cuenta);
    }

    @When("^Finalizo la asignacion de cuenta ingresando GanaPin (\\d+)$$")
    public void finalizo_el_bloqueo_TD(int pIntGanapin) {
        cuentasRelacionadasStep.ingresarGanapin(pIntGanapin);
    }

    @Then("^Verifico la asignacion fue exitoso$")
    public void verificarMensaje(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        cuentasRelacionadasStep.verificarMensaje(lUserTable);
    }
}
