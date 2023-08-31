package bo.com.bga.certificacion.gananet.models.consultas_y_extractos;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractoAgendadoMT940Model {

    private  String nroCuenta;
    private  String banco;
    private String  codigoSwift;

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public String getCodigoSwift() {
        return codigoSwift;
    }

    public static List<ExtractoAgendadoMT940Model> setData(DataTable dataTable) {
        List<ExtractoAgendadoMT940Model> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,ExtractoAgendadoMT940Model.class));
        }
        return dates;
    }
}
