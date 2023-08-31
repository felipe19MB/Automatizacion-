package com.bg.gnt.steps.pago_servicios;

import com.bg.gnt.integrations.transferencias.acceso.IniciarSesionIntegration;
import com.bg.gnt.pageobjects.HomePage;
import com.bg.gnt.pageobjects.NotificacionesPage;
import com.bg.gnt.pageobjects.pago_servicios.AfiliacionPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class AfiliacionStep {
    AfiliacionPage afiliacionPage;
    HomePage homePage;
    NotificacionesPage notificacionesPage;
    IniciarSesionIntegration iniciarSesionIntegration = new IniciarSesionIntegration();
    @Step
    public void deleteQueryWithoutAssertion(String query,String schemaDB){
        int result = 0;
        result = iniciarSesionIntegration.updateQuery(query,schemaDB);
    }
    @Step
    public void afiliarServicio(String opcionTipo, String opcionSubTipo, String opcionCiudad, String opcionServicio){
        afiliacionPage.afiliarServicio(opcionTipo, opcionSubTipo, opcionCiudad, opcionServicio);
    }
    @Step
    public void llenarDatos(String servicio, String criterioBusqueda, String criterioBusqueda1, String criterioBusqueda2, String referencia){
        afiliacionPage.llenarDatosCriterioBusqueda(servicio, criterioBusqueda, criterioBusqueda1, criterioBusqueda2, referencia);
    }
    @Step
    public void ingresarGanapin(String ganapin){
        //homePage.confirmarOperacionGanapin(ganapin);
        afiliacionPage.ingresarGanaPin(ganapin);
    }

    @Step
    public void verificarMensaje(List<String> pLstDatosMensaje) {
        String mensajeExitoso 		= pLstDatosMensaje.get(0);
        notificacionesPage.verificarMensaje(mensajeExitoso);
    }
    @Step
    public void eliminarAfiliacion(String nroPersona,String schemaDB){
        String query="DELETE GANADERO.SRV_AFILIACIONES WHERE COD_PERSONAFISICA = '"+nroPersona+"'";
        deleteQueryWithoutAssertion(query,schemaDB);
    }
}
