package bo.com.bga.certificacion.api.models.transferencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ATercerosModel {

    private String intJtsOidOrigen;
    private String intJtsOidDestino;
    private String dblImporteTransaccion;
    private String intMonedaTran;
    private String strDescripcion;
    private String strGlosaDestino;
    private String strNroCuentaOrigen;
    private String strNroCuentaDestino;

    private String strTokenSegundoFactor;
    private String strSesion;
    private String intCodIdioma;

    private String intPersonaRol;
    private String intNroMenu;
    private  String strConsolidado;

    public String getIntJtsOidOrigen() {
        return intJtsOidOrigen;
    }

    public String getIntJtsOidDestino() {
        return intJtsOidDestino;
    }

    public String getDblImporteTransaccion() {
        return dblImporteTransaccion;
    }

    public String getIntMonedaTran() {
        return intMonedaTran;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public String getStrGlosaDestino() {
        return strGlosaDestino;
    }

    public String getStrNroCuentaOrigen() {
        return strNroCuentaOrigen;
    }

    public String getStrNroCuentaDestino() {
        return strNroCuentaDestino;
    }

    public String getStrTokenSegundoFactor() {
        return strTokenSegundoFactor;
    }

    public String getStrSesion() {
        return strSesion;
    }

    public String getIntCodIdioma() {
        return intCodIdioma;
    }

    public String getIntPersonaRol() {
        return intPersonaRol;
    }

    public String getIntNroMenu() {
        return intNroMenu;
    }

    public String getStrConsolidado() {
        return strConsolidado;
    }

    public static String setDataId(DataTable dataTable) {
        List<ATercerosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            Map<String, String> filteredMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (Arrays.asList("intJtsOidOrigen", "intJtsOidDestino", "dblImporteTransaccion", "intMonedaTran","strDescripcion","strGlosaDestino","strNroCuentaOrigen","strNroCuentaDestino","strTokenSegundoFactor","intCodIdioma","intPersonaRol","intNroMenu","strConsolidado").contains(key)) {
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
                if (Arrays.asList("intJtsCuentaOrigen", "intJtsCuentaDestino", "dblImporteTransaccion", "intMonedaTran","strDescripcion","strGlosaDestino","strNroCuentaOrigen","strNroCuentaDestino","strTokenSegundoFactor","intCodIdioma","intPersonaRol","intNroMenu","strConsolidado").contains(key)) {
                    filteredMap.put(key, value);
                }
            }
            dates.add(new ObjectMapper().convertValue(filteredMap, ATercerosModel.class));
        }
        return toJsonString(dates);
    }

/*  public static String setDataEliminar(DataTable dataTable) {
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
    }*/


    public static String toJsonString(List<ATercerosModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("intJtsCuentaOrigen", lista.get(0).getIntJtsOidOrigen());
        json.addProperty("intJtsCuentaDestino", lista.get(0).getIntJtsOidDestino());
        json.addProperty("dblImporteTransaccion", lista.get(0).getDblImporteTransaccion());
        json.addProperty("intMonedaTran", lista.get(0).getIntMonedaTran());
        json.addProperty("strDescripcion", lista.get(0).getStrDescripcion());
        json.addProperty("strGlosaDestino", lista.get(0).getStrGlosaDestino());
        json.addProperty("strNroCuentaOrigen", lista.get(0).getStrNroCuentaOrigen());
        json.addProperty("strNroCuentaDestino", lista.get(0).getStrNroCuentaDestino());
        json.addProperty("strTokenSegundoFactor", lista.get(0).getStrTokenSegundoFactor());
        json.addProperty("strSesion", (String) theActorInTheSpotlight().recall("sesionPagina"));
        json.addProperty("intCodIdioma", lista.get(0).getIntCodIdioma());
        json.addProperty("intPersonaRol", lista.get(0).getIntPersonaRol());
        json.addProperty("intNroMenu", lista.get(0).getIntNroMenu());
        json.addProperty("strConsolidado", lista.get(0).getStrConsolidado());
        return json.toString();
    }

    public static String toJsonStringId(List<ATercerosModel> lista) {
        System.out.println(theActorInTheSpotlight().recall("sesionPagina").toString());
        JsonObject json = new JsonObject();
        json.addProperty("intJtsCuentaOrigen", lista.get(0).getIntJtsOidOrigen());
        json.addProperty("intJtsCuentaDestino", lista.get(0).getIntJtsOidDestino());
        json.addProperty("dblImporteTransaccion", lista.get(0).getDblImporteTransaccion());
        json.addProperty("intMonedaTran", lista.get(0).getIntMonedaTran());
        json.addProperty("strDescripcion", lista.get(0).getStrDescripcion());
        json.addProperty("strGlosaDestino", lista.get(0).getStrGlosaDestino());
        json.addProperty("strNroCuentaOrigen", lista.get(0).getStrNroCuentaOrigen());
        json.addProperty("strNroCuentaDestino", lista.get(0).getStrNroCuentaDestino());
        json.addProperty("strTokenSegundoFactor", lista.get(0).getStrTokenSegundoFactor());
        json.addProperty("strSesion", (String) theActorInTheSpotlight().recall("sesionPagina"));
        json.addProperty("intCodIdioma", lista.get(0).getIntCodIdioma());
        json.addProperty("intPersonaRol", lista.get(0).getIntPersonaRol());
        json.addProperty("intNroMenu", lista.get(0).getIntNroMenu());
        json.addProperty("strConsolidado", lista.get(0).getStrConsolidado());

        return json.toString();
    }

/*   public static String toJsonStringEliminar(List<ATercerosModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("pstrIdioma", lista.get(0).getPstrIdioma());
        json.addProperty("pStrCper", lista.get(0).getpStrCper());
        json.addProperty("pStrNroCuenta", lista.get(0).getpStrNroCuenta());
        json.addProperty("pstrNroSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        return json.toString();
    }*/

}
