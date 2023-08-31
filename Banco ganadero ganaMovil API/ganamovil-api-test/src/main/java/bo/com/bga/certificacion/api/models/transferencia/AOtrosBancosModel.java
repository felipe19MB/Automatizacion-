package bo.com.bga.certificacion.api.models.transferencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AOtrosBancosModel {

    private String pIntJtsOidOrigen;
    private String pIntLstOtrosBancos;
    private String pBlnControlUIF;
    private String pDblImporte;
    private String pIntMoneda;
    private String pStrDescripcionTrans;
    private String pStrCanal;


    public String getpIntJtsOidOrigen() {
        return pIntJtsOidOrigen;
    }

    public String getpIntLstOtrosBancos() {
        return pIntLstOtrosBancos;
    }

    public String getpBlnControlUIF() {
        return pBlnControlUIF;
    }

    public String getpDblImporte() {
        return pDblImporte;
    }

    public String getpIntMoneda() {
        return pIntMoneda;
    }

    public String getpStrDescripcionTrans() {
        return pStrDescripcionTrans;
    }

    public String getpStrCanal() {
        return pStrCanal;
    }


    public static String setData(DataTable dataTable) {
        List<AOtrosBancosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pIntJtsOidOrigen", "pIntLstOtrosBancos", "pBlnControlUIF", "pDblImporte","pIntMoneda","pStrDescripcionTrans","pStrCanal").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, AOtrosBancosModel.class));
        }
        return toJsonString(dates);
    }

    public static String toJsonString(List<AOtrosBancosModel> lista) {
        JsonObject json = new JsonObject();
        List<Map<String, Object>> recall = theActorInTheSpotlight().recall("pIntJtsOid");
        json.addProperty("pIntJtsOidOrigen", lista.get(0).getpIntJtsOidOrigen());
        json.addProperty("pIntLstOtrosBancos", lista.get(0).getpIntLstOtrosBancos());
        json.addProperty("pBlnControlUIF", lista.get(0).getpBlnControlUIF());
        json.addProperty("pDblImporte", lista.get(0).getpDblImporte());
        json.addProperty("pStrNroSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        json.addProperty("pIntMoneda", lista.get(0).getpIntMoneda());
        json.addProperty("pStrDescripcionTrans", lista.get(0).getpStrDescripcionTrans());
        json.addProperty("pStrCanal", lista.get(0).getpStrCanal());
        return json.toString();
    }
}

