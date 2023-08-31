package com.bg.gmv.definitions.girosRemesas;

import com.bg.gmv.steps.girosRemesas.CobroGirosStep;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class CobroGirosDefinition {
    @Steps
    CobroGirosStep cobroGirosStep;

    @And("^Ingreso el numero de referencia del giro abonado$")
    public void ingreso_numero_referencia_giro_abonado(List<String> referenciasGiros) {
        String schemaDB = "GANADERO";
        String nroReferencia = referenciasGiros.get(0);
        cobroGirosStep.resetearEstadoRemesa(nroReferencia,schemaDB);
        cobroGirosStep.ingresarReferenciaRemesa(referenciasGiros);
    }

    @And("^Busca el giro a abonar$")
    public void busca_el_giro_a_abonar(){
        cobroGirosStep.buscarReferenciaRemesa();
    }

    @And("^Confirmar el monto a Cobrar$")
    public void confirmar_el_monto_a_cobrar(List<String> importe){
        cobroGirosStep.confirmarMontoCobrar(importe.get(0));
    }

    @And("^Confirmar resumen de giro$")
    public void confirmar_resumen_de_giro(List<String> importe){
        cobroGirosStep.confirmarResumenGiro(importe.get(0));
    }

    @And("^Finalizamos comprobante de deposito de giro$")
    public void finalizamos_comprobante_de_deposito_giro(List<String> importe){
        cobroGirosStep.finalizarComprobanteRemesa(importe.get(0));
    }
}
