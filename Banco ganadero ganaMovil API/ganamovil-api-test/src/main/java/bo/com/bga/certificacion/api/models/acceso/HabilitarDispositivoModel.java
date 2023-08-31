package bo.com.bga.certificacion.api.models.acceso;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import java.util.*;

public class HabilitarDispositivoModel {

    private String pStrNombreUsuario;
    private String pStrImei;
    private String pStrModelo;
    private String pStrSistemaOperativo;

    public String getpStrNombreUsuario() {
        return pStrNombreUsuario;
    }

    public String getpStrImei() {
        return pStrImei;
    }

    public String getpStrModelo() {
        return pStrModelo;
    }

    public String getpStrSistemaOperativo() {
        return pStrSistemaOperativo;
    }

    public static String setData(DataTable dataTable) {
        List<HabilitarDispositivoModel> dates = new ArrayList<>();
        List<java.util.Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pStrSistemaOperativo", "pStrImei", "pStrNombreUsuario", "pStrModelo").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, HabilitarDispositivoModel.class));
        }
        return toJsonString(dates);
    }

    public static String toJsonString(List<HabilitarDispositivoModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("pStrNombreUsuario", lista.get(0).getpStrNombreUsuario());
        json.addProperty("pStrImei", lista.get(0).getpStrImei());
        json.addProperty("pStrModelo", lista.get(0).getpStrModelo());
        json.addProperty("pStrSistemaOperativo", lista.get(0).getpStrSistemaOperativo());
        return json.toString();
    }
}
