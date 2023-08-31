package com.bg.gmv.definitions.pagoServicios;

import com.bg.gmv.steps.pagoServicios.PagoServiciosStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class PagoServiciosDefinition {

    @Steps
    PagoServiciosStep pagoServiciosStep;

    @And("^Ingreso los datos para pago del servicio$")
    public void ingreso_los_datos_para_pago_del_servicio(List<String> datosPago) {
        String schemaDB = "GANADERO";
        String codigo = datosPago.get(4);
        String nroDeuda = datosPago.get(5);
        String convenio = datosPago.get(6);
        String gestion = datosPago.get(7);
        pagoServiciosStep.habilitarDeudaColegio(codigo,nroDeuda,convenio,gestion,schemaDB);
        pagoServiciosStep.ingresarDatosPago(datosPago);
    }
    @And("^Proceso el pago del servicio$")
    public void proceso_el_pago_del_servicio() {
        pagoServiciosStep.finalizarPago();
    }

    @Then("^Obtengo un comprobante de pago del servicio$")
    public void obtengo_un_comprobante_de_pago_del_servicio(List<String> datosPago) {
        pagoServiciosStep.verificarComprobante(datosPago);
    }

}
