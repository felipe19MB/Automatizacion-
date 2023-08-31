package com.bg.gmv.steps.pagoServicios;

import com.bg.gmv.integrations.pagoServicios.PagoServiciosIntegration;
import com.bg.gmv.pageobjects.pagoServicios.PagoServiciosPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class PagoServiciosStep {
    PagoServiciosPage pagoServiciosPage;
    PagoServiciosIntegration pagoServiciosIntegration = new PagoServiciosIntegration();

    @Step
    public void ingresarDatosPago(List<String> datosPago){
        String nroCuenta = datosPago.get(0);
        String compania = datosPago.get(1);
        String afiliado = datosPago.get(2);
        String deuda = datosPago.get(3);
        pagoServiciosPage.clicOpcion("Cuenta de Pago");
        pagoServiciosPage.seleccionarCuenta(nroCuenta);
        pagoServiciosPage.clicOpcion("Compañía");
        pagoServiciosPage.seleccionarCompania(compania);
        pagoServiciosPage.clicOpcion("Servicio Afiliado");
        pagoServiciosPage.seleccionarAfiliado(afiliado);
        pagoServiciosPage.clicOpcion("Deuda a Pagar");
        pagoServiciosPage.seleccionarDeuda(deuda);
    }

    @Step
    public void finalizarPago(){
        pagoServiciosPage.clicButton("Continuar");
        pagoServiciosPage.clicButton("Pagar");
    }
    @Step
    public void verificarComprobante(List<String> datosPago){
        String nroCuenta = datosPago.get(0);
        String afiliado = datosPago.get(2);
        String importe = datosPago.get(4);

        assertThat(pagoServiciosPage.getValorComprobante("Cuenta"), containsString(importe));
        assertThat(pagoServiciosPage.getValorComprobante("Código"),containsString(afiliado));
        assertThat(pagoServiciosPage.getValorComprobante("Importe"),containsString(nroCuenta));

    }

    @Step
    public void habilitarDeudaColegio(String codigo, String nroDeuda, String convenio, String gestion, String schemaDB){
        String query="UPDATE GANADERO.RCT_RECAUDACIONES SET IMPORTE_COBRADO = 0, FECHA_EFECTIVA_COBRO=NULL, ESTADO =0, ASIENTO =0, SUCURSAL_ASIENTO =0 WHERE  SERVICIO_REFERENCIA='"+codigo+"' AND REFERENCIA="+nroDeuda+" AND ID_CONVENIO="+convenio+" AND TZ_LOCK=0 AND GESTION="+gestion+"";
        updateQuery(query,schemaDB);
    }

    @Step
    public void updateQuery(String query,String schemaDB) {
        int result = 0;
        result = pagoServiciosIntegration.updateQuery(query,schemaDB);
        assertThat(result, greaterThan(0));

    }


}
