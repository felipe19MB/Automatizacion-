package com.bg.gmv.steps.girosRemesas;

import com.bg.gmv.integrations.remesas.RemesasIntegration;
import com.bg.gmv.pageobjects.girosRemesas.CobroGirosSinSessionPage;
import net.thucydides.core.annotations.Step;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CobroGirosSinSessionStep {
    CobroGirosSinSessionPage cobroGirosSinSessionPage;
    RemesasIntegration remesasIntegration = new RemesasIntegration();

    @Step
    public void updateQuery(String query,String schemaDB) {
        int result = 0;
        result = remesasIntegration.updateQuery(query,schemaDB);
    }

    @Step
    public void ingresarDocumentoIdentidadStep(List<String> documentoIdentidad){
        cobroGirosSinSessionPage.ingresarDocumentoIdentidadPage(documentoIdentidad.get(0),documentoIdentidad.get(1));
    }

    @Step
    public void confirmarDatosIdentificacion(){
        cobroGirosSinSessionPage.confirmarIdentidad();
    }

    @Step
    public void ingresarDatosCobrosRemesasStep(List<String> datosCobroRemesa){
        cobroGirosSinSessionPage.ingresarDatosCobroRemesasPage(
                datosCobroRemesa.get(0), //claveReferencia
                datosCobroRemesa.get(1), //montoEnvio
                datosCobroRemesa.get(2), //moneda
                datosCobroRemesa.get(3), //nombreApellidoRemitente
                datosCobroRemesa.get(4));//nroCuenta
    }

    @Step
    public void confirmarDatosRemesaStep(){
        cobroGirosSinSessionPage.confirmarDatosRemesaPage();
    }

    @Step
    public void confirmarResumnenGiroRemesaStep(List<String> montoCuentaMoneda){

        String monto = montoCuentaMoneda.get(0);
        String moneda = montoCuentaMoneda.get(2);
        if(moneda.equals("BOLIVIANOS")){
            monto=monto+" Bs.";
        }
        else if(moneda.equals("DOLARES AMERICANOS")){
            monto=monto+" $us.";
        } else {
            monto=monto+" EUR.";
        }
        String cuentaVista = cobroGirosSinSessionPage.obtenerNroCuentaText();

        String[] partes = cuentaVista.split(" ");
        String soloNroCuenta = partes[0]; // obtiene solo nroCuenta

        String montoVista=cobroGirosSinSessionPage.obtenerMontoRecibidoText();
        montoVista=montoVista.replace(",","");

        assertEquals(monto,montoVista);
        assertEquals(montoCuentaMoneda.get(1), soloNroCuenta);
        cobroGirosSinSessionPage.confirmarResumnenGiroRemesaPage();
    }

    @Step
    public void finalizarComprobanteGiroRemesaStep(List<String> montoMoneda){
        String monto =montoMoneda.get(0);
        String moneda =montoMoneda.get(1);

        if(moneda.equals("BOLIVIANOS")){
            monto=monto+" Bs.";
        }
        else if(moneda.equals("DOLARES AMERICANOS")){
            monto=monto+" $us.";
        } else {
            monto=monto+" EUR.";
        }
        String montoVista = cobroGirosSinSessionPage.obtenerMontoMonedaFinalizar();
        montoVista = montoVista.replace(",","");
        System.out.println(montoVista);

        assertEquals(monto, montoVista);
        cobroGirosSinSessionPage.finalizamosComprobanteGiroRemesaPage();

    }
    @Step
    public void resetearEstadoRemesaCodUsuario(String nroReferencia, String schemaDB){
        String query="UPDATE GANADERO.TRF_ORDENES SET ESTADO = 2, NRO_PERS_DESTIN=0 WHERE  CLAVE = '"+nroReferencia+"'";
        updateQuery(query,schemaDB);
    }

}
