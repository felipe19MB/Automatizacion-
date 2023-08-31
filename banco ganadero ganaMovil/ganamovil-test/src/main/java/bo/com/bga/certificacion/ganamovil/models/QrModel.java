package bo.com.bga.certificacion.ganamovil.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QrModel {

    private String cuentaorigen;
    private String tipomoneda;
    private String tiempoduracion;
    private String descripcion;
    private String saldo;
    private Boolean usounico;

    public String getCuentaorigen() {
        return cuentaorigen;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public String getTiempoduracion() {
        return tiempoduracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSaldo() {
        return saldo;
    }

    public Boolean getUsounico() {
        return usounico;
    }

    public static List<QrModel> setData(DataTable dataTable) {
        List<QrModel> datos = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            datos.add(new ObjectMapper().convertValue(map, QrModel.class));
        }
        return datos;
    }
}
