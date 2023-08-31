package bo.com.bga.certificacion.api.models.transferencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ATercerosModel {

    private String pIntJtsOidOrigen;
    private String pIntJtsOidDestino;
    private String pBlnTerceros;
    private String pBoolControlUIF;
    private String pDblImporte;
    private String pStrCanal;
    private String pIntMoneda;
    private String pStrGlosa;

    private String pstrIdioma;
    private String pStrCper;
    private String pStrNroCuenta;

    public String getpIntJtsOidOrigen() {
        return pIntJtsOidOrigen;
    }

    public String getpIntJtsOidDestino() {
        return pIntJtsOidDestino;
    }

    public String getpBlnTerceros() {
        return pBlnTerceros;
    }

    public String getpBoolControlUIF() {
        return pBoolControlUIF;
    }

    public String getpDblImporte() {
        return pDblImporte;
    }

    public String getpStrCanal() {
        return pStrCanal;
    }

    public String getpIntMoneda() {
        return pIntMoneda;
    }

    public String getpStrGlosa() {
        return pStrGlosa;
    }

    public String getPstrIdioma() {
        return pstrIdioma;
    }

    public String getpStrCper() {
        return pStrCper;
    }

    public String getpStrNroCuenta() {
        return pStrNroCuenta;
    }

    public static String setDataId(DataTable dataTable) {
        List<ATercerosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pIntJtsOidOrigen", "pIntJtsOidDestino", "pBlnTerceros", "pBoolControlUIF","pDblImporte","pIntMoneda","pStrGlosa","pStrCanal").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ATercerosModel.class));
        }
        return toJsonStringId(dates);
    }

    public static String setData(DataTable dataTable) {
        List<ATercerosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pIntJtsOidOrigen", "pIntJtsOidDestino", "pBlnTerceros", "pBoolControlUIF","pDblImporte","pIntMoneda","pStrGlosa","pStrCanal").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ATercerosModel.class));
        }
        return toJsonString(dates);
    }

    public static String setDataEliminar(DataTable dataTable) {
        List<ATercerosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pstrIdioma", "pStrCper", "pStrNroCuenta").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ATercerosModel.class));
        }
        return toJsonStringEliminar(dates);
    }


    public static String toJsonString(List<ATercerosModel> lista) {
        JsonObject json = new JsonObject();
        List<Map<String, Object>> recall = theActorInTheSpotlight().recall("pIntJtsOid");
        json.addProperty("pIntJtsOidOrigen", recall.get(0).get("JTS_OID").toString());
        json.addProperty("pIntJtsOidDestino", recall.get(1).get("JTS_OID").toString());
        json.addProperty("pBlnTerceros", lista.get(0).getpBlnTerceros());
        json.addProperty("pBoolControlUIF", lista.get(0).getpBoolControlUIF());
        json.addProperty("pDblImporte", lista.get(0).getpDblImporte());
        json.addProperty("pStrNroSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        json.addProperty("pIntMoneda", lista.get(0).getpIntMoneda());
        json.addProperty("pStrGlosa", lista.get(0).getpStrGlosa());
        json.addProperty("pStrCanal", lista.get(0).getpStrCanal());
        return json.toString();
    }

    public static String toJsonStringId(List<ATercerosModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("pIntJtsOidOrigen", lista.get(0).getpIntJtsOidOrigen());
        json.addProperty("pIntJtsOidDestino", lista.get(0).getpIntJtsOidDestino());
        json.addProperty("pBlnTerceros", lista.get(0).getpBlnTerceros());
        json.addProperty("pBoolControlUIF", lista.get(0).getpBoolControlUIF());
        json.addProperty("pDblImporte", lista.get(0).getpDblImporte());
        json.addProperty("pStrNroSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        json.addProperty("pIntMoneda", lista.get(0).getpIntMoneda());
        json.addProperty("pStrGlosa", lista.get(0).getpStrGlosa());
        json.addProperty("pStrCanal", lista.get(0).getpStrCanal());
        return json.toString();
    }

    public static String toJsonStringEliminar(List<ATercerosModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("pstrIdioma", lista.get(0).getPstrIdioma());
        json.addProperty("pStrCper", lista.get(0).getpStrCper());
        json.addProperty("pStrNroCuenta", lista.get(0).getpStrNroCuenta());
        json.addProperty("pstrNroSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        return json.toString();
    }

}
