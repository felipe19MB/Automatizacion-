package com.bg.gnt.steps.tarjetas_debito;

import com.bg.gnt.integrations.transferencias.acceso.IniciarSesionIntegration;
import com.bg.gnt.pageobjects.HomePage;
import com.bg.gnt.pageobjects.NotificacionesPage;
import com.bg.gnt.pageobjects.tarjetas_debito.BloqueoTarjetaTDPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
public class BloqueoTarjetaStep {
    BloqueoTarjetaTDPage bloqueoTarjetaTDPage;
    HomePage homePage;
    NotificacionesPage notificacionesPage;
    IniciarSesionIntegration iniciarSesionIntegration = new IniciarSesionIntegration();
    @Step
    public void updateQueryWithoutAssertion(String query,String schemaDB){
        int result = 0;
        result = iniciarSesionIntegration.updateQuery(query,schemaDB);
    }
    @Step
    public void ingresarMotivo(){
        bloqueoTarjetaTDPage.bloquearTarjetaTD();
    }

    @Step
    public void ingresarGanapin(int ganapin){
        homePage.confirmarOperacionGanapin(ganapin);
    }

    @Step
    public void verificarMensaje(List<String> pLstDatosMensaje) {
        String datoTarjeta 		= pLstDatosMensaje.get(0);
        notificacionesPage.verificarMensaje(datoTarjeta);
    }
    @Step
    public void habilitarTarjeta(String nroPersona,String schemaDB){
        String query="UPDATE TJD_TARJETAS SET ESTADO = 'A' WHERE NRO_PERSONA="+nroPersona+"";
        updateQueryWithoutAssertion(query,schemaDB);
    }
}
