package bo.com.bga.certificacion.gananet.models.autorizaciones;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutorizacionSolicitudModel {

    private  String mensaje;
    private  String mensajeSupervision;
    private String tipoAutorizacion;
    private String cuentaOrigen;
    private String  usuario;

    private String formato;

    private String talonario;

    private String cantidadTalonarios;

    public String getFormato() {
        return formato;
    }

    public String getMensajeSupervision() {
        return mensajeSupervision;
    }

    public String getTalonario() {
        return talonario;
    }

    public String getCantidadTalonarios() {
        return cantidadTalonarios;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTipoAutorizacion() {
        return tipoAutorizacion;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public String getUsuario() {
        return usuario;
    }

    public static List<AutorizacionSolicitudModel> setData(DataTable dataTable) {
        List<AutorizacionSolicitudModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, AutorizacionSolicitudModel.class));
        }
        return dates;
    }
}
