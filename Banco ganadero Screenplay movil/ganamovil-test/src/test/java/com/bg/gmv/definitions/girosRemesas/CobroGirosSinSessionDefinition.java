package com.bg.gmv.definitions.girosRemesas;

import com.bg.gmv.steps.girosRemesas.CobroGirosSinSessionStep;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import java.util.List;

public class CobroGirosSinSessionDefinition {

    @Steps
    CobroGirosSinSessionStep cobroGirosSinSessionStep;

    @And("^Ingreso Documento de Identificacion$")
    public void ingreso_documento_de_identificacion(List<String> documentoIdentidad){
        cobroGirosSinSessionStep.ingresarDocumentoIdentidadStep(documentoIdentidad);
    }

    @And("^Confirmo datos de identificacion$")
    public void confirmar_datos_de_identificacion(){
        cobroGirosSinSessionStep.confirmarDatosIdentificacion();

    }

    @And("^Ingreso datos de cobro remesa$")
    public void ingreso_datos_de_cobro_remesa(List<String> datosCobroRemesa){
        String schemaDB = "GANADERO";
        String nroReferencia = datosCobroRemesa.get(0);
        cobroGirosSinSessionStep.resetearEstadoRemesaCodUsuario(nroReferencia,schemaDB);
        cobroGirosSinSessionStep.ingresarDatosCobrosRemesasStep(datosCobroRemesa);
    }

    @And("^Confirmar datos de cobro remesa$")
    public void confirmar_datos_de_cobro_remesa(){
        cobroGirosSinSessionStep.confirmarDatosRemesaStep();

    }


    @And("^Confirmar Resumen de Giro Remesa$")
    public void confirmar_resumen_de_giro_remesa(List<String> montoCuentaMoneda){
        cobroGirosSinSessionStep.confirmarResumnenGiroRemesaStep(montoCuentaMoneda);

    }

    @And("^Finalizamos Comprobante Giro Remesa$")
    public void finalizamos_comprobante_giro_remesa(List<String> montoMoneda){
        cobroGirosSinSessionStep.finalizarComprobanteGiroRemesaStep(montoMoneda);

    }

}
