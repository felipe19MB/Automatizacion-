package bo.com.bga.certificacion.api.models.acceso;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

public class ValidarClaveModel {

    private String strUsuario;
    private String strClave;
    private String strTipoUsuario;
    private String intCodAplicacion;
    private String intCodIdioma;

    public String getStrUsuario() {
        return strUsuario;
    }

    public String getStrClave() {
        return strClave;
    }

    public String getStrTipoUsuario() {
        return strTipoUsuario;
    }

    public String getIntCodAplicacion() {
        return intCodAplicacion;
    }

    public String getIntCodIdioma() {
        return intCodIdioma;
    }

    public static String setData(DataTable dataTable) {
        List<ValidarClaveModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("strUsuario", "strClave", "strTipoUsuario", "intCodAplicacion","intCodIdioma").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ValidarClaveModel.class));
        }
        return toJsonString(dates);
    }

    public static String toJsonString(List<ValidarClaveModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("strUsuario", lista.get(0).getStrUsuario());
        json.addProperty("strClave", lista.get(0).getStrClave());
        json.addProperty("strTipoUsuario", lista.get(0).getStrTipoUsuario());
        json.addProperty("intCodAplicacion", lista.get(0).getIntCodAplicacion());
        json.addProperty("intCodIdioma", lista.get(0).getIntCodIdioma());
        System.out.println(lista.get(0).getIntCodIdioma());

        return json.toString();
    }

}
