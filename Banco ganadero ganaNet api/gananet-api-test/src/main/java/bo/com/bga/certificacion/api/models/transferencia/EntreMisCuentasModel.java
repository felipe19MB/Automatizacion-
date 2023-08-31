package bo.com.bga.certificacion.api.models.transferencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EntreMisCuentasModel {

    private String pIntJtsOidOrigen;
    private String pIntJtsOidDestino;
    private String pBlnTerceros;
    private String pBoolControlUIF;
    private String pDblImporte;
    private String pStrCanal;
    private String pIntMoneda;
    private String pStrGlosa;

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

    public static String setData(DataTable dataTable) {
        List<EntreMisCuentasModel> dates = new ArrayList<>();
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
            dates.add(new ObjectMapper().convertValue(filteredMap, EntreMisCuentasModel.class));
        }
        return toJsonString(dates);
    }


    public static String toJsonString(List<EntreMisCuentasModel> lista) {
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

}
