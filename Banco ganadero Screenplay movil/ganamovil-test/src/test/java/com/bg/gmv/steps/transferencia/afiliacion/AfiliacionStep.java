package com.bg.gmv.steps.transferencia.afiliacion;

import com.bg.gmv.integrations.transferencia.afiliacion.AfiliacionIntegration;
import com.bg.gmv.pageobjects.transferencia.afiliacion.AfiliacionPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class AfiliacionStep {

    AfiliacionPage afiliacionPage;
    AfiliacionIntegration afiliacionIntegration = new AfiliacionIntegration();

    @Step
    public void SeleccionarAdicionaCuentas(){
        afiliacionPage.clicAdicionaCuentas();

    }

    @Step
    public void ingresarDatosAfiliacion(List<String> datosAfiliacion){
        String nroCuentaDestino = datosAfiliacion.get(0);
        String nombre = datosAfiliacion.get(1);
        String referencia = datosAfiliacion.get(2);
        afiliacionPage.ingresarNroCuenta(nroCuentaDestino);
        afiliacionPage.ingresarNombre(nombre);
        afiliacionPage.ingresarReferencia(referencia);
        afiliacionPage.clicButton("Buscar");
    }

    @Step
    public void finalizarRegistro(){
        afiliacionPage.clicButton("Agregar");
    }

    @Step
    public void verificarMensaje(List<String> datosAfiliacion){
        String mensaje=datosAfiliacion.get(0);
        assertThat(afiliacionPage.getMensaje(),containsString(mensaje));
        afiliacionPage.clicButton("Aceptar");
    }
    @Step
    public  void eliminarCuentaAfiliada(List<String> datosAfiliacion){
        String cuentaAfiliada=datosAfiliacion.get(0);
        afiliacionPage.eliminarAfiliado(cuentaAfiliada);
        afiliacionPage.clicButton("Si");
    }
    @Step
    public void deleteQuery(String query,String schemaDB) {
        int result = 0;
        result = afiliacionIntegration.deleteQuery(query,schemaDB);
        assertThat(result, greaterThan(0));

    }

}
