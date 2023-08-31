package bo.com.bga.certificacion.gananet.models.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosRutaFuncionalidad {

     private String perfil;
     private String modulo;
     private String funcionalidad;

    public String getPerfil() {
        return perfil;
    }

    public String getModulo() {
        return modulo;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public static List<DatosRutaFuncionalidad> setData(DataTable dataTable) {
        List<DatosRutaFuncionalidad> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, DatosRutaFuncionalidad.class));
        }
        return dates;
    }
}
