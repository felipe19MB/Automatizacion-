package com.bg.gmv.steps.solicitudCreditos;

import com.bg.gmv.pageobjects.dashboard.DashBoardPage;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxDB;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import com.bg.gmv.steps.dashboard.DashBoardStep;
import com.bg.gmv.util.Constants.SolicitudConsumaxConstants;
import com.bg.gmv.util.Messages.SolicitudConsumaxMessages;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
import org.junit.Assert;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class SolicitudConsumaxStep {

    SolicitudConsumaxPage solicitudConsumaxPage;
    DashBoardPage dashBoardPage;
    SolicitudConsumaxDB consumaxIntegration = new SolicitudConsumaxDB();

    @Step
    public void ingresarIniciarSolicitud() {
        solicitudConsumaxPage.clickIniciarSolicitud();
        assertEquals(solicitudConsumaxPage.getMensajeNoEsAsalariado(), solicitudConsumaxPage.getNoEsAsalariadoText());

    }

    @Step
    public void indicarNoSoyAsalariado() {
        solicitudConsumaxPage.clickNoSoyAsalariado();
    }

    @Step
    public void verificarMensajeNoPuedeSolicitarCredito(List<String> mensajes) {
        assertEquals(mensajes.get(SolicitudConsumaxConstants.getFirstPosition()), solicitudConsumaxPage.getNoSoyAsalariadoErrorMessage());
    }

    @Step
    public void iniciarSolicitudEsAsalariado() {
        solicitudConsumaxPage.clickConfirmarSolicitudCredito();
    }

    @Step
    public void confirmarTerminosCondiciones() {
        solicitudConsumaxPage.clickConfirmarTerminosCondiciones();
    }

    @Step
    public void seleccionarEstadoCivil() {
        solicitudConsumaxPage.clickEstadoCivilDropDown();
        solicitudConsumaxPage.selectSolteroOption();
    }

    @Step
    public void seleccionarResidencia() {
        solicitudConsumaxPage.clickResidenciaDropDown();
        solicitudConsumaxPage.selectBeniOption();
    }

    @Step
    public void llenarSueldoLiquido(List<String> sueldosLiquidos) {
        solicitudConsumaxPage.populateSueldoLiquidoTitularUSD(sueldosLiquidos.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void llenarConfirmacionCorreoTitular(List<String> textos) {
        solicitudConsumaxPage.populateCampo(textos, solicitudConsumaxPage.getEmailTitular());
    }

    @Step
    public void llenarCorreoElectronicoTitular() {
        solicitudConsumaxPage.populateCorreoElectronicoTitular();
    }

    @Step
    public void llenarTelefonoCelular(List<String> telefonos) {
        solicitudConsumaxPage.populateTelefonoTitular(telefonos.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void confirmarDatos() {
        solicitudConsumaxPage.clickConfirmarDatosSolicitados();
    }

    @Step
    public void llenarMontoASolicitar(List<String> montos) {
        solicitudConsumaxPage.populateMontoASolicitar(montos.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void seleccionarDiaPagar() {
        int DIA = 5;
        solicitudConsumaxPage.clickSeleccionaDiaDropDown();
        solicitudConsumaxPage.clickDiaOption(DIA);

    }

    @Step
    public void confirmarDatosMonto() {
        solicitudConsumaxPage.clickConfirmarMonto();
    }

    @Step
    public void seleccionarNivelEducacion() {
        solicitudConsumaxPage.clickNivelEducacionDropDown();
        solicitudConsumaxPage.clickProfesionalOption();
    }

    @Step
    public void llenarProfesion(List<String> profesiones) {
        solicitudConsumaxPage.populateProfesion(profesiones.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void seleccionarCargo() {
        solicitudConsumaxPage.clickCargoDropDown();
        solicitudConsumaxPage.clickJefeOption();
    }

    @Step
    public void seleccionarIngreso() {
        solicitudConsumaxPage.clickNivelIngresoDropDown();
        solicitudConsumaxPage.clickThirdOption();
    }

    @Step
    public void seleccionarViviendaCantidadHijosNombreEmpresa(List<String> empresas) {
        solicitudConsumaxPage.clickTipoViviendaDropDown();
        solicitudConsumaxPage.clickFamiliarOption();
        solicitudConsumaxPage.clicCantidadHijosDropDown();
        solicitudConsumaxPage.clickZeroHijosOption();
        solicitudConsumaxPage.populateNombreEmpresa(empresas.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void llenarFechaIngresoTrabajo(List<String> dia) {
        solicitudConsumaxPage.populateCampo(dia, solicitudConsumaxPage.getDia());
        solicitudConsumaxPage.populateMes(solicitudConsumaxPage.getMes());
        solicitudConsumaxPage.populateAnho(solicitudConsumaxPage.getAnho());
    }

    @Step
    public void cancelarSolicitud() {
        solicitudConsumaxPage.clickCancelar();
    }

    @Step
    public void confirmarSeleccion() {
        solicitudConsumaxPage.clickSi();
    }

    @Step
    public void cancelarSolicitudConsumax() {
        solicitudConsumaxPage.clickCancelarSolicitud();
    }

    @Step
    public void verificarMensajeDesestimadoCorrectamente(List<String> mensajes) {
        assertEquals(solicitudConsumaxPage.getSolicitudDesestimadaSuccessMessage(), mensajes.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void confirmarDatosActividadEconomica() {
        solicitudConsumaxPage.clickConfirmar();
    }

    @Step
    public void aceptarMensajeDireccionDomicilio() {
        solicitudConsumaxPage.clickAceptar();
    }

    @Step
    public void usarMapaMientrasAppEnUso() {
        solicitudConsumaxPage.clickPermitirUbicacion();
    }

    @Step
    public void llenarDatosDireccion(List<String> datosDireccion) {
        solicitudConsumaxPage.populateBarrio(datosDireccion.get(SolicitudConsumaxConstants.getFirstPosition()));
        solicitudConsumaxPage.populateCalle(datosDireccion.get(SolicitudConsumaxConstants.getSecondPosition()));
        solicitudConsumaxPage.clickZonaDropDown();
        solicitudConsumaxPage.clickCentroOption();
        solicitudConsumaxPage.populateNumero(datosDireccion.get(SolicitudConsumaxConstants.getThirdPosition()));
        solicitudConsumaxPage.populateManzana(datosDireccion.get(SolicitudConsumaxConstants.getFourthPosition()));
        solicitudConsumaxPage.populateReferencia(datosDireccion.get(SolicitudConsumaxConstants.getFifthPosition()));
    }

    @Step
    public void confirmarDatosDireccionDomicilio() {
        solicitudConsumaxPage.clickConfirmar();
    }

    @Step
    public void seleccionarDepartamentoLaboral() {
        solicitudConsumaxPage.clickDepartamentoDropDown();
        solicitudConsumaxPage.clickChuquisacaOption();
    }

    @Step
    public void seleccionarZonaLaboral() {
        solicitudConsumaxPage.clickZonaLaboralDropDown();
        solicitudConsumaxPage.clickNorteOption();
    }

    @Step
    public void llenarBarrioLaboral(List<String> datosDireccionLaboral) {
        solicitudConsumaxPage.populateBarrioLaboral(datosDireccionLaboral.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void llenarCalleLaboral(List<String> datosDireccionLaboral) {
        solicitudConsumaxPage.populateCalleLaboral(datosDireccionLaboral.get(SolicitudConsumaxConstants.getSecondPosition()));
    }

    @Step
    public void llenarNumeroLaboral(List<String> datosDireccionLaboral) {
        solicitudConsumaxPage.populateNumeroLaboral(datosDireccionLaboral.get(SolicitudConsumaxConstants.getThirdPosition()));
    }

    @Step
    public void llenarManzanaLaboral(List<String> datosDireccionLaboral) {
        solicitudConsumaxPage.populateManzanaLaboral(datosDireccionLaboral.get(SolicitudConsumaxConstants.getFourthPosition()));
    }

    @Step
    public void confirmarDatosDireccionLaboral() {
        solicitudConsumaxPage.clickConfirmar();
    }

    @Step
    public void verificarOpcionNoIntegroVinculacionEconomica() {
        assertEquals(solicitudConsumaxPage.getNoIntegro(), solicitudConsumaxPage.textNoIntegro());
    }

    @Step
    public void confirmarDatosVinculacionEconomica() {
        solicitudConsumaxPage.clickConfirmar();
    }

    @Step
    public void llenarValorMueblesEnseres(List<String> datosDDJJ) {
        solicitudConsumaxPage.populateValorMueblesEnseres(datosDDJJ.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void confirmarDatosDDJJ() {
        solicitudConsumaxPage.clickConfirmar();
    }

    @Step
    public void firmarSolicitud() {
        solicitudConsumaxPage.escribirFirma();
        solicitudConsumaxPage.clickConfirmar();
        solicitudConsumaxPage.clickAceptar();
    }

    @Step
    public void confirmarDocumentacionAdjuntada() {
        solicitudConsumaxPage.clickConfirmar();
    }

    @Step
    public void verificarPantallaInicioSolicitud() {
        assertEquals(solicitudConsumaxPage.getIniciarUnaSolicitud(),solicitudConsumaxPage.textIniciarSolicitudButton());
        assertEquals(solicitudConsumaxPage.getIniciarUnaSolicitudTitle(),solicitudConsumaxPage.textSolicitudConsumaxTitle());

    }

    @Step
    public void verificarBotonInicioSolicitud() {
        solicitudConsumaxPage.clickIniciarSolicitud();
        assertEquals(solicitudConsumaxPage.getEspecificacionesRequisitos(),solicitudConsumaxPage.textEspecificacionesYRequisitos());
    }

    @Step
    public void seleccionarFirma() {
        List<String> opciones = Arrays.asList("FIRMA");
        dashBoardPage.ingresarOpcion(opciones);
    }

    @Step
    public void llenarPeso(List<String> datosDdjjSalud) {
        solicitudConsumaxPage.populatePeso(datosDdjjSalud.get(SolicitudConsumaxConstants.getFirstPosition()));
    }

    @Step
    public void llenarAltura(List<String> datosDdjjSalud) {
        solicitudConsumaxPage.populateAltura(datosDdjjSalud.get(SolicitudConsumaxConstants.getSecondPosition()));
    }

    @Step
    public void llenarDdjjDeSalud() {
        solicitudConsumaxPage.clickSeEncuentraSanoYesOption();
        solicitudConsumaxPage.clickEnfermedadDiagnosticadaNoOption();
        solicitudConsumaxPage.clickHivNoOption();
        solicitudConsumaxPage.clickDeporteRiesgoNoOption();
    }
    @Step
    public void scrollDown() {
        //List<String> opciones = Arrays.asList("Si alguna de sus respuestas (de la N°2 a la N°7) es afirmativa , favor brindar detalles: (Colocar fecha aproximada del evento para los casos de la pregunta 5, 6 y 7)");
        //dashBoardPage.ingresarOpcion(opciones);
        solicitudConsumaxPage.escribirFirma();
    }

    @Step
    public void llenarDdjjDeSaludParteDos() {
        solicitudConsumaxPage.clickTratamientoMedicoNoOption();
        solicitudConsumaxPage.clickMedicamentosNoOption();
        solicitudConsumaxPage.clickIntervencionesQuirurgicasNoOption();
    }

    @Step
    public void verificarSolicitudEnElFlujo(List<String> personas) {
        Assert.assertThat(solicitudConsumaxPage.textSolicitudExitosa(), CoreMatchers.containsString(SolicitudConsumaxMessages.getSolicitudExitosa()));
    }

    @Step
    public void insertarRegistroAntispoofing(List<String> personas) {
        String query = "INSERT INTO GANADERO.CAS_CRE_ANTISPOOFING " +
                "(IDENTIFICADOR, COD_PERSONA, PDF_SEGIP, NRO_SOLICITUD_ASOCIADA, ESTADO, SEGIPID, RESP_SEGIP, TIPOLOGIA_SOL, AZUREID, RESP_AZURE, MOVIMIENTOS) " +
                "VALUES((SELECT MAX(IDENTIFICADOR) FROM GANADERO.CAS_CRE_ANTISPOOFING cca)+1, "+ personas.get(SolicitudConsumaxConstants.getFirstPosition())+", NULL, NULL, 'V', NULL, NULL, '"+personas.get(SolicitudConsumaxConstants.getSecondPosition())+"', NULL, NULL, NULL)";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

    @Step
    public void quitarRequisitosDocumentacion() {
        String query = "UPDATE GANADERO.CAS_PAR_DOCUMENTACION " +
                "SET CANTIDAD_MINIMA=0 " +
                "WHERE IDENTIFICADOR IN (1,14,3,17, 4,12, 7,8,11,13,85,87,89,93,86,88,91,95)";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

    @Step
    public void habilitarRequisitosDocumentacionExtractoAFP() {
        String query = "UPDATE GANADERO.CAS_PAR_DOCUMENTACION " +
                "SET CANTIDAD_MINIMA=2 " +
                "WHERE IDENTIFICADOR IN (3,17)";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

    @Step
    public void habilitarRequisitosDocumentacionBoletasPago() {
        String query = "UPDATE GANADERO.CAS_PAR_DOCUMENTACION " +
                "SET CANTIDAD_MINIMA=3 " +
                "WHERE IDENTIFICADOR IN (4,12)";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

    @Step
    public void habilitarRequisitosDocumentacionCarnetSelfie() {
        String query = "UPDATE GANADERO.CAS_PAR_DOCUMENTACION " +
                "SET CANTIDAD_MINIMA=1 " +
                "WHERE IDENTIFICADOR IN (1,14,7,8,11,13,85,87,89,93,86,88,91,95)";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

    @Step
    public void desestimarSolicitudIngresada(List<String> personas) {
        String query = "UPDATE GANADERO.CAS_CRE_SOLICITUD " +
                "SET ESTADO='D' " +
                "WHERE COD_PERSONA = "+personas.get(SolicitudConsumaxConstants.getFirstPosition())+" AND ESTADO NOT IN ('D')";
        int result = 0;
        result = consumaxIntegration.updateQuery(query);
    }

}
