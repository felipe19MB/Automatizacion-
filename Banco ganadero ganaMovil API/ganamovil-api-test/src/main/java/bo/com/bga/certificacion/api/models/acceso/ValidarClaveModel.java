package bo.com.bga.certificacion.api.models.acceso;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

public class ValidarClaveModel {

    private String pStrNombreUsuario;
    private String pStrClave;
    private String pStrCanal;
    private String pStrImei;
    private String pStrModelo;
    private String pStrSistemaOperativo;
    private String did;
    private String rsid;
    private String version;
    private String didbga;
    private String pStrKsBga;

    public String getpStrNombreUsuario() {
        return pStrNombreUsuario;
    }

    public String getpStrClave() {
        return pStrClave;
    }

    public String getpStrCanal() {
        return pStrCanal;
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

    public String getDid() {
        return did;
    }

    public String getRsid() {
        return rsid;
    }

    public String getVersion() {
        return version;
    }

    public String getDidbga() {
        return didbga;
    }

    public String getpStrKsBga() {
        return pStrKsBga;
    }

    public static String setData(DataTable dataTable) {
        List<ValidarClaveModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pStrNombreUsuario", "pStrClave", "pStrCanal", "pStrImei","pStrModelo","pStrSistemaOperativo","did","rsid","version","didbga","pStrKsBga").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ValidarClaveModel.class));
        }
        return toJsonString(dates);
    }

    public static String toJsonString(List<ValidarClaveModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("pStrNombreUsuario", lista.get(0).getpStrNombreUsuario());
        json.addProperty("pStrClave", lista.get(0).getpStrClave());
        json.addProperty("pStrCanal", lista.get(0).getpStrCanal());
        json.addProperty("pStrImei", lista.get(0).getpStrImei());
        json.addProperty("pStrModelo", lista.get(0).getpStrModelo());
        json.addProperty("pStrSistemaOperativo", lista.get(0).getpStrSistemaOperativo());
        json.addProperty("did", lista.get(0).getDid());
        json.addProperty("rsid", lista.get(0).getRsid());
        json.addProperty("version", lista.get(0).getVersion());
        json.addProperty("didbga", lista.get(0).getDidbga());
        json.addProperty("pStrKsBga", lista.get(0).getpStrKsBga());
        return json.toString();
    }

}
