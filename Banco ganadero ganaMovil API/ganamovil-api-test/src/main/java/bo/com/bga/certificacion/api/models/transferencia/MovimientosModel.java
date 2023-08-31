package bo.com.bga.certificacion.api.models.transferencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosModel {
    private String pIntNroPersona;
    private String pIntCodUsuarioXcanal;
    private String pFechaInicial;
    private String pFechaFinal;

    public String getpIntNroPersona() {
        return pIntNroPersona;
    }

    public String getpIntCodUsuarioXcanal() {
        return pIntCodUsuarioXcanal;
    }

    public String getpFechaInicial() {
        return pFechaInicial;
    }

    public String getpFechaFinal() {
        return pFechaFinal;
    }


    public static String setData(DataTable dataTable) {
        List<MovimientosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("pIntNroPersona", "pIntCodUsuarioXcanal", "pFechaInicial", "pFechaFinal").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, MovimientosModel.class));
        }
        return toJsonString(dates);
    }


    public static String toJsonString(List<MovimientosModel> lista) {
        JsonObject json = new JsonObject();
        List<Map<String, Object>> recall = theActorInTheSpotlight().recall("pIntJtsOid");
        json.addProperty("pIntNroPersona", lista.get(0).getpIntNroPersona());
        json.addProperty("pIntCodUsuarioXcanal", lista.get(0).getpIntCodUsuarioXcanal());
        json.addProperty("pFechaInicial", lista.get(0).getpFechaInicial());
        json.addProperty("pFechaFinal", lista.get(0).getpFechaFinal());
        json.addProperty("pStrSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        return json.toString();
    }
}
