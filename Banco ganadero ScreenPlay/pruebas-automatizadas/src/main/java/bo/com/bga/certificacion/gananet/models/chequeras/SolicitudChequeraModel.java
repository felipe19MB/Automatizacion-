package bo.com.bga.certificacion.gananet.models.chequeras;

import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.GenerarExtractoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolicitudChequeraModel {

    private String  cuentaOrigen;
    private String formato;
    private String talonario;

    private String retiroChequera;

    private String oficinaEntrega;

    private String cantidadTalonarios;

    private String portaChequera;

    private String sello;

    public String getCantidadTalonarios() {
        return cantidadTalonarios;
    }

    public String getPortaChequera() {
        return portaChequera;
    }

    public String getSello() {
        return sello;
    }

    public String getRetiroChequera() {
        return retiroChequera;
    }

    public String getOficinaEntrega() {
        return oficinaEntrega;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public String getFormato() {
        return formato;
    }

    public String getTalonario() {
        return talonario;
    }

    public static List<SolicitudChequeraModel> setData(DataTable dataTable) {
        List<SolicitudChequeraModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,SolicitudChequeraModel.class));
        }
        return dates;
    }

}
