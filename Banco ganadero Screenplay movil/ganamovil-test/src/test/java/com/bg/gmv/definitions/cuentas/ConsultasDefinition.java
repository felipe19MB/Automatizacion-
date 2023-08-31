package com.bg.gmv.definitions.cuentas;

import com.bg.gmv.steps.cuentas.ConsultasStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ConsultasDefinition {
    @Steps
    ConsultasStep consultasStep;


    @When("^Consulto la cuenta$")
    public void consulto_la_cuenta(List<String> datosCuentas){
        String nroCuenta = datosCuentas.get(0);
        String saldo = datosCuentas.get(1);
        String schemaDB = "GANADERO";
        consultasStep.actualizarSaldoCuenta(nroCuenta, saldo, schemaDB);
        consultasStep.seleccionarCuenta(datosCuentas.get(0));
    }

    @Then("^Obtengo el saldo y el estado de la cuenta$")
    public void obtengo_el_saldo_y_el_estado_de_la_cuenta(List<String> datosCuentas){
        consultasStep.verificarSaldoEstadoCuenta(datosCuentas);
    }
}
