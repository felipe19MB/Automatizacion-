package com.bg.gmv.steps.habilitacion;

import com.bg.gmv.pageobjects.dashboard.DashBoardPage;
import com.bg.gmv.pageobjects.habilitacion.HabilitacionPage;
import com.bg.gmv.pageobjects.puntosAtencion.PuntosAtencionPage;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxDB;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import com.bg.gmv.util.Constants.SolicitudConsumaxConstants;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HabilitacionStep {
    HabilitacionPage habilitacionPage;
    SolicitudConsumaxDB consumaxIntegration = new SolicitudConsumaxDB();


    @Step
    public void confirmarRegistrarGanamovil() {
        habilitacionPage.clickSi();
    }

    @Step
    public void verificarRegistroExitoso() {
        assertEquals(habilitacionPage.getRegistroExitosoText(), habilitacionPage.obtenerTextoRegistroExitoso());
    }

    @Step
    public void verificarMenuPrincipal(List<String> mensajes) {
        assertEquals(mensajes.get(SolicitudConsumaxConstants.getFirstPosition()), habilitacionPage.obtenerTextoBienvenido());
    }

    @Step
    public void aceptarRegistroExitoso() {
        habilitacionPage.clickAceptar();
    }

    @Step
    public void habilitarDispositivo(List<String> personas) {
        String query = "update GANANET.CAS_USUARIOXCANAL set estado = 'A' where estado = 'P' and codusuario = '"+personas.get(SolicitudConsumaxConstants.getFirstPosition())+"'";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

    @Step
    public void eliminarDispositivosPorPersona(List<String> personas) {
        String query = "DELETE FROM GANANET.CAS_USUARIOXCANAL WHERE CODUSUARIO = '"+personas.get(SolicitudConsumaxConstants.getFirstPosition())+"'";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

}
