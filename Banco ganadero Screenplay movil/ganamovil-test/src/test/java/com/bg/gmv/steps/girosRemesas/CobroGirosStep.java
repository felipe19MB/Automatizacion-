package com.bg.gmv.steps.girosRemesas;

import com.bg.gmv.integrations.remesas.RemesasIntegration;
import com.bg.gmv.pageobjects.girosRemesas.CobroGirosPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CobroGirosStep {
    CobroGirosPage cobroGirosPage;
    RemesasIntegration remesasIntegration = new RemesasIntegration();
    @Step
    public void updateQuery(String query,String schemaDB) {
        int result = 0;
        result = remesasIntegration.updateQuery(query,schemaDB);
    }

    @Step
    public void ingresarReferenciaRemesa(List<String> referenciasRemesas) {
        cobroGirosPage.ingresarReferenciaRemesa(referenciasRemesas.get(0));
    }

    @Step
    public void buscarReferenciaRemesa() {
        cobroGirosPage.buscarReferencia();
    }

    @Step
    public void confirmarMontoCobrar(String importe) {
        assertEquals(importe, cobroGirosPage.importeRecibidoP1Text());
        cobroGirosPage.confirmar();
    }

    @Step
    public void confirmarResumenGiro(String importe) {
        assertEquals(importe, cobroGirosPage.importeRecibidoP2Text());
        cobroGirosPage.confirmar();
    }

    @Step
    public  void finalizarComprobanteRemesa(String importe) {
        assertEquals(importe, cobroGirosPage.importeRecibidoP3Text());
        cobroGirosPage.finalizarComprobanteDeposito();
    }

    @Step
    public void resetearEstadoRemesa(String nroReferencia, String schemaDB){
        String query="UPDATE GANADERO.TRF_ORDENES SET ESTADO = 2 WHERE  CLAVE = '"+nroReferencia+"'";
        updateQuery(query,schemaDB);
    }

}
