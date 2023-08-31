package bo.com.bga.certificacion.ganamovil.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServicioModel {
    private String tipo;
    private String codigo;
    private String cuenta;
    private String referencia;

    public String getTipo() {
        return tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getReferencia() {
        return referencia;
    }

    public static List<ServicioModel> setData(DataTable dataTable) {
        List<ServicioModel> datos = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            datos.add(new ObjectMapper().convertValue(map, ServicioModel.class));
        }
        return datos;
    }
}
