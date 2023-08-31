package com.bg.gmv.definitions.transferencia;

import com.bg.gmv.steps.transferencia.TransferenciaStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class TransferenciaDefinition {

    @Steps
    TransferenciaStep transferenciaStep;

    @When("^Selecciono la cuenta origen$")
    public void selecciono_la_cuenta_de_origen(List<String> datosTransferencia) {
        String schemaDB = "GANANET";
        String nroPersona = datosTransferencia.get(1);
        transferenciaStep.resetearTransDiaRegistrado(nroPersona,schemaDB);
        transferenciaStep.seleccionarCuentaOrigen(datosTransferencia);
    }

    @And("^Selecciono el tipo de transferencia$")
    public void selecciono_el_tipo_de_transferencia(List<String> datosTransferencia) {
        transferenciaStep.seleccionarTipoTransferencia(datosTransferencia);
    }

    @And("^Selecciono la cuenta destino$")
    public void selecciono_la_cuenta_destino(List<String> datosTransferencia) {
        transferenciaStep.seleccionarCuentaDestino(datosTransferencia);
    }

    @And("^Selecciono la moneda$")
    public void selecciono_la_moneda(List<String> datosTransferencia) {
        transferenciaStep.seleccionarMoneda(datosTransferencia);
    }

    @And("^Ingreso el importe y descripcion$")
    public void ingreso_el_importe_y_descripcion(List<String> datosTransferencia) {
        transferenciaStep.ingresarDatosTransferencia(datosTransferencia);
    }

    @And("^Finalizo la transferencia$")
    public void finalizo_la_transferencia() {
        transferenciaStep.finalizarTransferencia();
    }

    @And("^Verifico los datos del Resumen$")
    public void verifico_los_datos_del_resumen(List<String> datosTransferencia){
        transferenciaStep.verificarDatosResumen(datosTransferencia);
    }

    @Then("^Obtengo un comprobante de transferencia a terceros con los datos de la transferencia$")
    public void obtengo_un_comprobante_de_transferencia_a_terceros_con_los_datos_de_la_transferencia(List<String> datosTransferencia){
        transferenciaStep.verificarDatosComprobante(datosTransferencia);
    }
    @Then("^Obtengo un comprobante de transferencia a otros bancos con los datos de la transferencia$")
    public void obtengo_un_comprobante_de_transferencia_a_otros_bancos_con_los_datos_de_la_transferencia(List<String> datosTransferencia){
        transferenciaStep.verificarDatosComprobante(datosTransferencia);
    }

    @Then("^Obtengo un comprobante de transferencia a cuentas propias con los datos de la transferencia$")
    public void obtengo_un_comprobante_de_transferencia_a_cuentas_propias_con_los_datos_de_la_transferencia(List<String> datosTransferencia){
        transferenciaStep.verificarDatosComprobante(datosTransferencia);
    }
}
