package bo.com.bga.certificacion.gananet.models.boletas_garantía;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoletasGarantíaModel {
    private String personaTitular;
    private String cuentaOrigen;
    private String monto;
    private String tipoImporte;
    private String nroTestimonio;
    private String tipoSolicitud;
    private String tipoBoleta;
    private String ordenDe;
    private String plazo;
    private String enGarantiaDe;
    private String ciudad;
    private String oficina;
    private String emailNotificacion;
    private String nombre;
    private String documento;
    private String comisionEmision;
    private String nombreFacturacion;
    private String nit;
    private String modalInicio;
    private String modalFinal;

    public String getModalInicio() {
        return modalInicio;
    }

    public void setModalInicio(String modalInicio) {
        this.modalInicio = modalInicio;
    }

    public String getModalFinal() {
        return modalFinal;
    }

    public void setModalFinal(String modalFinal) {
        this.modalFinal = modalFinal;
    }

    public String getMensajeDeclaracion() {
        return mensajeDeclaracion;
    }

    public void setMensajeDeclaracion(String mensajeDeclaracion) {
        this.mensajeDeclaracion = mensajeDeclaracion;
    }

    private String mensajeDeclaracion;

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getTipoImporte() {
        return tipoImporte;
    }

    public void setTipoImporte(String tipoImporte) {
        this.tipoImporte = tipoImporte;
    }

    public String getNroTestimonio() {
        return nroTestimonio;
    }

    public void setNroTestimonio(String nroTestimonio) {
        this.nroTestimonio = nroTestimonio;
    }

    public String getTipoBoleta() {
        return tipoBoleta;
    }

    public void setTipoBoleta(String tipoBoleta) {
        this.tipoBoleta = tipoBoleta;
    }

    public String getOrdenDe() {
        return ordenDe;
    }

    public void setOrdenDe(String ordenDe) {
        this.ordenDe = ordenDe;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getEnGarantiaDe() {
        return enGarantiaDe;
    }

    public void setEnGarantiaDe(String enGarantiaDe) {
        this.enGarantiaDe = enGarantiaDe;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getEmailNotificacion() {
        return emailNotificacion;
    }

    public void setEmailNotificacion(String emailNotificacion) {
        this.emailNotificacion = emailNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getComisionEmision() {
        return comisionEmision;
    }

    public void setComisionEmision(String comisionEmision) {
        this.comisionEmision = comisionEmision;
    }

    public String getNombreFacturacion() {
        return nombreFacturacion;
    }

    public void setNombreFacturacion(String nombreFacturacion) {
        this.nombreFacturacion = nombreFacturacion;
    }

    public String getNit() {
        return nit;
    }
    public String getPersonaTitular() {
        return personaTitular;
    }

    public void setPersonaTitular(String personaTitular) {
        this.personaTitular = personaTitular;
    }


    public void setNit(String nit) {
        this.nit = nit;
    }
    public static List<BoletasGarantíaModel> setData(DataTable dataTable) {
        List<BoletasGarantíaModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, BoletasGarantíaModel.class));
        }
        return dates;
    }

}
