package com.bg.gmv.definitions.cuentas;

import com.bg.gmv.steps.cuentas.ExtractoStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ExtractoDefinition {
    @Steps
    ExtractoStep extractoStep;

    @When("^Consulto extracto de la cuenta$")
    public void consulto_extracto_de_la_cuenta(List<String> datosExtracto){
        extractoStep.seleccionarCuenta(datosExtracto.get(0));
        extractoStep.seleccionarOpcion("Extractos");
        extractoStep.seleccionarPeriodoOtrosMeses(datosExtracto.get(1)); //Obtiene la columna (mes) de la tabla datosExtracto
    }

    @Then("^Obtengo un resumen del debito o credito realizado en el mes seleccionado$")
    public void obtengo_un_resumen_del_debito_o_credito_realizado_en_el_mes_seleccionado(List<String> datosExtracto){
        extractoStep.verificarExtracto(datosExtracto.get(0),datosExtracto.get(1)); //La posicion 0 es la descripcion y la poscicion 1 es el importe
    }

}
