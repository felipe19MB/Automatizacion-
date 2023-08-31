package com.bg.gmv.steps.solicitudTCStep;

import com.bg.gmv.pageobjects.dashboard.DashBoardPage;
import com.bg.gmv.pageobjects.habilitacion.HabilitacionPage;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxDB;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import com.bg.gmv.pageobjects.solicitudTC.SolicitudTCPage;
import com.bg.gmv.util.Constants.SolicitudConsumaxConstants;
import com.bg.gmv.util.Messages.SolicitudConsumaxMessages;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolicitudTCStep {
    SolicitudTCPage solicitudTCPage;
    SolicitudConsumaxPage solicitudConsumaxPage;
    SolicitudConsumaxDB consumaxIntegration = new SolicitudConsumaxDB();
    DashBoardPage dashBoardPage;

    @Step
    public void seleccionarSituacionLaboral() {
        solicitudTCPage.seleccionarSituacionLaboral();
    }
    @Step
    public void confirmarDatos() {
        solicitudTCPage.confirmarDatos();
    }
    @Step
    public void ingresarIngresos(List<String> ingresosYGastos) {
        solicitudTCPage.ingresarIngresos(ingresosYGastos.get(SolicitudConsumaxConstants.getFirstPosition()));
    }
    @Step
    public void ingresarGastosFamiliares(List<String> ingresosYGastos) {
        solicitudTCPage.ingresarGastosFamiliares(ingresosYGastos.get(SolicitudConsumaxConstants.getSecondPosition()));
    }
    @Step
    public void calcular() {
        solicitudTCPage.calcular();
    }
    @Step
    public void aceptar() {
        solicitudTCPage.aceptar();
    }
    @Step
    public void seleccionarEstadoCivil(List<String> datos) {
        solicitudTCPage.seleccionarEstadoCivil(datos.get(0));
    }
    @Step
    public void seleccionarResidencia(List<String> datos) {
        solicitudTCPage.seleccionarResidencia(datos.get(1));
    }
    @Step
    public void verificarTextoTelefonoTitular(List<String> datosCliente) {
        List<String> datos = new ArrayList<String>();
        datos.add(datosCliente.get(2));
        assertTrue(solicitudTCPage.textExists(datos));
    }
    @Step
    public void seleccionarAgenciaPreferida(List<String> datos) {
        solicitudTCPage.seleccionarAgencia(datos.get(3));
    }
    @Step
    public void llenarConfirmacionCorreoElectronico(List<String> datosCliente) {
        List<String> datos = new ArrayList<String>();
        datos.add(datosCliente.get(5));
        solicitudTCPage.populateCampo(datos, datosCliente.get(8));
    }
    @Step
    public void llenarSueldoLiquido(List<String> datosCliente) {
        solicitudTCPage.ingresarSueldoLiquido(datosCliente.get(4));
    }
    @Step
    public void llenarTelefono(List<String> datosCliente) {
        solicitudTCPage.ingresarTelefono(datosCliente.get(6));
    }
    @Step
    public void llenarCorreoElectronico(List<String> datosCliente) {
        solicitudTCPage.ingresarCorreoElectronico(datosCliente.get(7));
    }
    @Step
    public void ingresarMontoASolicitar(List<String> datosCliente) {
        solicitudTCPage.ingresarMontoASolicitar(datosCliente.get(0));
    }
    @Step
    public void seleccionarDireccionCorrespondencia(List<String> datos) {
        solicitudTCPage.seleccionarDireccionCorrespondencia(datos.get(1));
    }
    @Step
    public void seleccionarNivelEducacion(List<String> datos) {
        solicitudTCPage.seleccionarNivelEducacion(datos.get(0));
    }
    @Step
    public void ingresarProfesion(List<String> datosCliente) {
        solicitudTCPage.ingresarProfesion(datosCliente.get(1));
    }
    @Step
    public void seleccionarCargo(List<String> datos) {
        solicitudTCPage.seleccionarCargo(datos.get(2));
    }
    @Step
    public void seleccionarNivelIngreso(List<String> datos) {
        solicitudTCPage.seleccionarNivelIngreso(datos.get(3));
    }
    public void seleccionarTipoVivienda(List<String> datos) {
        solicitudTCPage.seleccionarTipoVivienda(datos.get(4));
    }
    public void seleccionarCantidadHijos(List<String> datos) {
        solicitudTCPage.seleccionarCantidadHijos(datos.get(5));
    }
    @Step
    public void ingresarNombreEmpresa(List<String> datosCliente) {
        solicitudTCPage.ingresarNombreEmpresa(datosCliente.get(6));
    }
    @Step
    public void llenarDiaIngreso(List<String> datosCliente) {
        List<String> textToFind = new ArrayList<String>();
        textToFind.add(datosCliente.get(7));
        solicitudTCPage.populateCampo(textToFind, datosCliente.get(10));
    }
    @Step
    public void llenarMesIngreso(List<String> datosCliente) {
        List<String> textToFind = new ArrayList<String>();
        textToFind.add(datosCliente.get(8));
        solicitudTCPage.populateCampo(textToFind, datosCliente.get(11));
    }
    @Step
    public void llenarAnhoIngreso(List<String> datosCliente) {
        List<String> textToFind = new ArrayList<String>();
        textToFind.add(datosCliente.get(9));
        solicitudTCPage.populateCampo(textToFind, datosCliente.get(12));
    }
    @Step
    public void ingresarMueblesEnseres(List<String> datosCliente) {
        solicitudConsumaxPage.escribirFirma();
        solicitudTCPage.ingresarMueblesEnseres(datosCliente.get(0));
    }
    @Step
    public void ingresarBarrio(List<String> datosCliente) {
        solicitudTCPage.ingresarBarrio(datosCliente.get(0));
    }
    @Step
    public void ingresarCalle(List<String> datosCliente) {
        solicitudTCPage.ingresarCalle(datosCliente.get(1));
    }
    @Step
    public void seleccionarZona(List<String> datosCliente) {
        solicitudTCPage.seleccionarZona(datosCliente.get(2));
    }
    @Step
    public void ingresarNumero(List<String> datosCliente) {
        solicitudTCPage.ingresarNumero(datosCliente.get(3));
    }
    @Step
    public void ingresarManzana(List<String> datosCliente) {
        solicitudTCPage.ingresarManzana(datosCliente.get(4));
    }
    @Step
    public void ingresarReferencia(List<String> datosCliente) {
        solicitudTCPage.ingresarReferencia(datosCliente.get(5));
    }
    @Step
    public void seleccionarDepartamentoLaboral(List<String> datosCliente) {
        solicitudTCPage.seleccionarDepartamentoLaboral(datosCliente.get(0));
    }
    @Step
    public void ingresarBarrioLaboral(List<String> datosCliente) {
        solicitudTCPage.ingresarBarrioLaboral(datosCliente.get(1));
    }
    @Step
    public void ingresarCalleLaboral(List<String> datosCliente) {
        solicitudTCPage.ingresarCalleLaboral(datosCliente.get(2));
    }
    @Step
    public void seleccionarZonaLaboral(List<String> datosCliente) {
        solicitudTCPage.seleccionarZonaLaboral(datosCliente.get(3));
    }
    @Step
    public void ingresarNumeroLaboral(List<String> datosCliente) {
        solicitudTCPage.ingresarNumeroLaboral(datosCliente.get(4));
    }
    @Step
    public void ingresarManzanaLaboral(List<String> datosCliente) {
        solicitudTCPage.ingresarManzanaLaboral(datosCliente.get(5));
    }
    @Step
    public void ingresarPeso(List<String> datosCliente) {
        solicitudConsumaxPage.populatePeso(datosCliente.get(0));
    }
    @Step
    public void ingresarAltura(List<String> datosCliente) {
        solicitudConsumaxPage.populateAltura(datosCliente.get(1));
    }
    @Step
    public void llenarDDJJSalud() {
        solicitudConsumaxPage.clickSeEncuentraSanoYesOption();
        solicitudConsumaxPage.clickEnfermedadDiagnosticadaNoOption();
        solicitudConsumaxPage.clickHivNoOption();
        solicitudConsumaxPage.clickDeporteRiesgoNoOption();
    }
    @Step
    public void llenarDDJJSalud2() {
        solicitudConsumaxPage.clickTratamientoMedicoNoOption();
        solicitudConsumaxPage.clickMedicamentosNoOption();
        solicitudConsumaxPage.clickIntervencionesQuirurgicasNoOption();
    }
    @Step
    public void llenarValorInmueble(List<String> datosCliente) {
        solicitudTCPage.seleccionarCantidadInmueble();
        solicitudTCPage.llenarValorInmueble(datosCliente.get(0));
    }
    @Step
    public void seleccionarFirma() {
        List<String> opciones = Arrays.asList("FIRMA");
        dashBoardPage.ingresarOpcion(opciones);
    }
    @Step
    public void firmarSolicitud() {
        solicitudConsumaxPage.escribirFirma();
        solicitudConsumaxPage.clickConfirmar();
        solicitudConsumaxPage.clickAceptar();
    }
    @Step
    public void verificarSolicitudEnElFlujo(List<String> personas) {
        Assert.assertThat(solicitudConsumaxPage.textSolicitudExitosa(), CoreMatchers.containsString(SolicitudConsumaxMessages.getSolicitudExitosa()));
    }
    @Step
    public void cancelar() {
        solicitudTCPage.cancelar();
    }
    @Step
    public void confirmarConSi() {
        solicitudTCPage.confirmarConSi();
    }
    @Step
    public void cancelarSolicitud() {
        solicitudTCPage.cancelarSolicitud();
    }
    @Step
    public void verificarPantallaInicioSolicitudTC() {
        assertTrue(solicitudTCPage.existeIniciarSolicitud());
    }
    @Step
    public void iniciarSolicitud() {
        solicitudTCPage.iniciarSolicitud();
    }
    @Step
    public void verificarTextoEspecificacionesRequisitos() {
        assertEquals(solicitudTCPage.getEspecificacionesRequisitosToAssert(),solicitudTCPage.getTextEspecificacionesRequisitosActual());
    }
    @Step
    public void quitarRequisitoDocumentacion() {
        String query = "UPDATE GANADERO.CAS_PAR_DOCUMENTACION " +
                "SET CANTIDAD_MINIMA=0 " +
                "WHERE IDENTIFICADOR IN (3,17, 4,12, 7,8,11,13,85,87,89,93,86,88,91,95)";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }
}
