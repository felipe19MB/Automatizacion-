package com.bg.gmv.steps.transferencia;

import com.bg.gmv.integrations.transferencia.TransferenciaIntegration;
import com.bg.gmv.pageobjects.transferencia.TransferenciaPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class TransferenciaStep {

    TransferenciaPage transferenciaPage;
    TransferenciaIntegration TransferenciaIntegration = new TransferenciaIntegration();
    @Step
    public void seleccionarCuentaOrigen(List<String> datosTransferencia){
        String nroCuenta = datosTransferencia.get(0);
        transferenciaPage.seleccionarCuenta(nroCuenta);
    }
    @Step
    public void seleccionarTipoTransferencia(List<String> datosTransferencia){
        String tipoTransferencia = datosTransferencia.get(0);
        transferenciaPage.seleccionarTipoTransferencia(tipoTransferencia);
    }
    @Step
    public void seleccionarCuentaDestino(List<String> datosTransferencia){
        String nroCuenta = datosTransferencia.get(0);
        transferenciaPage.seleccionarCuentaDestino(nroCuenta);
    }
    @Step
    public void seleccionarMoneda(List<String> datosTransferencia){
        String moneda = datosTransferencia.get(0);
        transferenciaPage.seleccionarMoneda(moneda);
    }
    @Step
    public void ingresarDatosTransferencia(List<String> datosTransferencia){
        String monto = datosTransferencia.get(0);
        String descripcion = datosTransferencia.get(1);
        transferenciaPage.ingresarMonto(monto);
        transferenciaPage.ingresarDescripcion(descripcion);
        transferenciaPage.clicButton("Continuar");
    }
    @Step
    public void finalizarTransferencia(){
        transferenciaPage.clicButton("Transferir");
    }
    @Step
    public void verificarDatosComprobante(List<String> datosTransferencia){
        String nroCuentaOrigen=datosTransferencia.get(0);
        String nroCuentaDestino=datosTransferencia.get(1);
        String importe =datosTransferencia.get(2);
        String moneda =datosTransferencia.get(3);
        String descripcion=datosTransferencia.get(4);
        assertThat(transferenciaPage.getNroCuentaOrigenComprobante(),containsString(nroCuentaOrigen));
       // assertThat(transferenciaPage.getNroCuentaDestinoComprobante(), containsString(nroCuentaDestino));
       //assertThat(transferenciaPage.getImporteDebitoComprobante(), containsString(importe));
        //assertThat(transferenciaPage.getValorComprobante("Importe"),containsString(importe));
    }

    @Step
    public void verificarDatosResumen(List<String> datosTransferencia){
        String nroCuentaOrigen = datosTransferencia.get(0);
        String nroCuentaDestino = datosTransferencia.get(1);
        String importe = datosTransferencia.get(2);
        String descripcion = datosTransferencia.get(4);
        //assertThat(transferenciaPage.getNroCuentaOrigenResumen(),containsString(nroCuentaOrigen));
        //assertThat(transferenciaPage.getNroCuentaDestinoResumen(),containsString(nroCuentaDestino));
        assertThat(transferenciaPage.getImporteResumen(),containsString(importe));
        assertThat(transferenciaPage.getDescripcionResumen(),containsString(descripcion));

    }

    @Step
    public void resetearTransDiaRegistrado(String nroPersona, String schemaDB){
        String query="UPDATE GANANET.GNT_USUARIOS SET EBUSRTXRD = 0 WHERE EBUSRCUSR = '"+nroPersona+"'";
        updateQuery(query,schemaDB);
    }

    @Step
    public void updateQuery(String query,String schemaDB) {
        int result = 0;
        result = TransferenciaIntegration.updateQuery(query,schemaDB);
        assertThat(result, greaterThan(0));

    }
}
