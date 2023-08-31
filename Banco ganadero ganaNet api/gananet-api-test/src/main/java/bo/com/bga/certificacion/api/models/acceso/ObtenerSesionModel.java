package bo.com.bga.certificacion.api.models.acceso;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

public class ObtenerSesionModel {

    private String serviceID;
    private String pStrNombreUsuario;
    private String rsid;
    private String did;
    private String pStrKsBga;
    private String version;
    private String pStrModelo;
    private String pStrSistemaOperativo;

    public String getServiceID() {
        return serviceID;
    }

    public String getpStrNombreUsuario() {
        return pStrNombreUsuario;
    }

    public String getRsid() {
        return rsid;
    }

    public String getDid() {
        return did;
    }

    public String getpStrKsBga() {
        return pStrKsBga;
    }

    public String getVersion() {
        return version;
    }

    public String getpStrModelo() {
        return pStrModelo;
    }

    public String getpStrSistemaOperativo() {
        return pStrSistemaOperativo;
    }

    public static String setData(DataTable dataTable) {
        List<ObtenerSesionModel> dates = new ArrayList<>();
        List<java.util.Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("serviceID", "pStrNombreUsuario", "rsid", "did","pStrKsBga", "version", "pStrModelo", "pStrSistemaOperativo").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ObtenerSesionModel.class));
        }
        return toJsonString(dates);
    }

    public static String toJsonString(List<ObtenerSesionModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("serviceID", lista.get(0).getServiceID());
        json.addProperty("pStrNombreUsuario", lista.get(0).getpStrNombreUsuario());
        json.addProperty("rsid", lista.get(0).getRsid());
        json.addProperty("did", lista.get(0).getDid());
        json.addProperty("pStrKsBga", lista.get(0).getpStrKsBga());
        json.addProperty("version", lista.get(0).getVersion());
        json.addProperty("pStrModelo", lista.get(0).getpStrModelo());
        json.addProperty("pStrSistemaOperativo", lista.get(0).getpStrSistemaOperativo());
        return json.toString();
    }

}
