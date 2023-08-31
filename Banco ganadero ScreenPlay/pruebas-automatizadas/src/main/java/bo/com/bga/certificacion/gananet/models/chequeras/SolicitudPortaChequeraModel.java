package bo.com.bga.certificacion.gananet.models.chequeras;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolicitudPortaChequeraModel {

    private String cuentaOrigen;
    private String monedaCuenta;
    private String tipoPortaChequera;
    private String costoSolicitud;
    private String tipoRetiro;
    private String oficinaEntrega;
    private String comentarios;
    private String mensajeComprobante;

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getMonedaCuenta() {
        return monedaCuenta;
    }

    public void setMonedaCuenta(String monedaCuenta) {
        this.monedaCuenta = monedaCuenta;
    }

    public String getTipoPortaChequera() {
        return tipoPortaChequera;
    }

    public void setTipoPortaChequera(String tipoPortaChequera) {
        this.tipoPortaChequera = tipoPortaChequera;
    }

    public String getCostoSolicitud() {
        return costoSolicitud;
    }

    public void setCostoSolicitud(String costoSolicitud) {
        this.costoSolicitud = costoSolicitud;
    }

    public String getTipoRetiro() {
        return tipoRetiro;
    }

    public void setTipoRetiro(String tipoRetiro) {
        this.tipoRetiro = tipoRetiro;
    }

    public String getOficinaEntrega() {
        return oficinaEntrega;
    }

    public void setOficinaEntrega(String oficinaEntrega) {
        this.oficinaEntrega = oficinaEntrega;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getMensajeComprobante() {
        return mensajeComprobante;
    }

    public void setMensajeComprobante(String mensajeComprobante) {
        this.mensajeComprobante = mensajeComprobante;
    }

    public static List<SolicitudPortaChequeraModel> setData(DataTable dataTable) {
        List<SolicitudPortaChequeraModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,SolicitudPortaChequeraModel.class));
        }
        return dates;
    }
}
