package bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigurarPerfilModel {
    private  String alias;
    private  String correo;

    private String preferido;

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public String getPreferido() {
        return preferido;
    }

    public String getAlias() {
        return alias;
    }

    public String getCorreo() {
        return correo;
    }
    public static List<ConfigurarPerfilModel> setData(DataTable dataTable) {
        List<ConfigurarPerfilModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,ConfigurarPerfilModel.class));
        }
        return dates;
    }
}
