package com.bg.gnt.steps.tarjetas_debito;

import com.bg.gnt.integrations.transferencias.acceso.IniciarSesionIntegration;
import com.bg.gnt.pageobjects.HomePage;
import com.bg.gnt.pageobjects.NotificacionesPage;
import com.bg.gnt.pageobjects.tarjetas_debito.ComprasInternetTDPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
public class ComprasPorInternetStep {

    ComprasInternetTDPage comprasInternetTDPage;
    HomePage homePage;
    NotificacionesPage notificacionesPage;
    IniciarSesionIntegration iniciarSesionIntegration = new IniciarSesionIntegration();
    @Step
    public void updateQueryWithoutAssertion(String query,String schemaDB){
        int result = 0;
        result = iniciarSesionIntegration.updateQuery(query,schemaDB);
    }
    @Step
    public void habilitarComprasHoy(String importe){
        comprasInternetTDPage.habilitarComprasHoy(importe);
    }

    @Step
    public void habilitarComprasRangos(String importe, String fechaDesde, String fechaHasta){
        comprasInternetTDPage.habilitarComprasRangos(importe, fechaDesde, fechaHasta);
    }

    @Step
    public void ingresarGanapin(int ganapin){
        homePage.confirmarOperacionGanapin(ganapin);
    }

    @Step
    public void verificarMensaje(List<String> pLstDatosMensaje) {
        String mensajeExitoso 		= pLstDatosMensaje.get(0);
        notificacionesPage.verificarMensaje(mensajeExitoso);
    }
    @Step
    public void habilitarTarjeta(String nroPersona,String schemaDB){
        String query="UPDATE TJD_LIM_INTERNET_TD SET ESTADO = 'B' WHERE NRO_TARJETA IN (SELECT ID_TARJETA FROM TJD_TARJETAS WHERE NRO_PERSONA = '"+nroPersona+"')";
        updateQueryWithoutAssertion(query,schemaDB);
    }
}
