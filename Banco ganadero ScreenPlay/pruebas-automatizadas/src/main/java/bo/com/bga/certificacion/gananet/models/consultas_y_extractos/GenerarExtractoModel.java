package bo.com.bga.certificacion.gananet.models.consultas_y_extractos;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerarExtractoModel {

    private String cuenta;

    private String periodoFiltro;

    private String desde;

    private String hasta;

    private String descripcion;

    private String importeDebitado;

    private String saldoDisponible;

    public String getDesde() {
        return desde;
    }

    public String getHasta() {
        return hasta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImporteDebitado() {
        return importeDebitado;
    }

    public String getSaldoDisponible() {
        return saldoDisponible;
    }

    public String getPeriodoFiltro() {
        return periodoFiltro;
    }

    public String getCuenta() {
        return cuenta;
    }

    public static List<GenerarExtractoModel> setData(DataTable dataTable) {
        List<GenerarExtractoModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,GenerarExtractoModel.class));
        }
        return dates;
    }
}
