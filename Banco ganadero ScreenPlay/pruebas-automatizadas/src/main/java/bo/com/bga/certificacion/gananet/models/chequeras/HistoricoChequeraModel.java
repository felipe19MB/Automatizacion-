package bo.com.bga.certificacion.gananet.models.chequeras;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoricoChequeraModel {
    private String cuentaOrigen;
    private String periodoInicio;
    private String periodoFin;
    private String mensajeComprobante;

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public String getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(String periodoFin) {
        this.periodoFin = periodoFin;
    }

    public String getMensajeComprobante() {
        return mensajeComprobante;
    }

    public void setMensajeComprobante(String mensajeComprobante) {
        this.mensajeComprobante = mensajeComprobante;
    }

    public static List<HistoricoChequeraModel> setData(DataTable dataTable) {
        List<HistoricoChequeraModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, HistoricoChequeraModel.class));
        }
        return dates;
    }
}
