package bo.com.bga.certificacion.api.models.qr;

import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CobroModel {

    private String pStrRazonSocial;
    private String pStrNroCuentaP;
    private String pStrMoneda;
    private String pIntMonto;
    private String pStrReferencia;
    private String pStrFechaVcto;
    private String pIntUnicoUso;
    private String pIntCodigoServicio;
    private String pStrCampoLibre;
    private String pStrNroSerie;
    private String pStrCodigoPersona;
    private String pStrCanal;
    private String pStrUsuarioRegistrado;
    private String pNroSesion;

    public String getpStrRazonSocial() {
        return pStrRazonSocial;
    }

    public String getpStrNroCuentaP() {
        return pStrNroCuentaP;
    }

    public String getpStrMoneda() {
        return pStrMoneda;
    }

    public String getpIntMonto() {
        return pIntMonto;
    }

    public String getpStrReferencia() {
        return pStrReferencia;
    }

    public String getpStrFechaVcto() {
        return pStrFechaVcto;
    }

    public String getpIntUnicoUso() {
        return pIntUnicoUso;
    }

    public String getpIntCodigoServicio() {
        return pIntCodigoServicio;
    }

    public String getpStrCampoLibre() {
        return pStrCampoLibre;
    }

    public String getpStrNroSerie() {
        return pStrNroSerie;
    }

    public String getpStrCodigoPersona() {
        return pStrCodigoPersona;
    }

    public String getpStrCanal() {
        return pStrCanal;
    }

    public String getpStrUsuarioRegistrado() {
        return pStrUsuarioRegistrado;
    }

    public String getpNroSesion() {
        return pNroSesion;
    }

    public static String setData(DataTable dataTable) {
        List<CobroModel> dates = new ArrayList<>();
        List<java.util.Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, CobroModel.class));
        }
        return toJsonString(dates);
    }

    public static String toJsonString(List<CobroModel> lista) {
        JsonObject json = new JsonObject();
        json.addProperty("pStrRazonSocial", lista.get(0).pStrRazonSocial);
        json.addProperty("pStrNroCuentaP", lista.get(0).getpStrNroCuentaP());
        json.addProperty("pStrMoneda", lista.get(0).getpStrMoneda());
        json.addProperty("pIntMonto", lista.get(0).getpIntMonto());
        json.addProperty("pStrReferencia", lista.get(0).getpStrReferencia());
        json.addProperty("pStrFechaVcto", lista.get(0).getpStrFechaVcto());
        json.addProperty("pIntUnicoUso", lista.get(0).getpIntUnicoUso());
        json.addProperty("pIntCodigoServicio", lista.get(0).getpIntCodigoServicio());
        json.addProperty("pStrCampoLibre", lista.get(0).getpStrCampoLibre());
        json.addProperty("pStrNroSerie", lista.get(0).getpStrNroSerie());
        json.addProperty("pStrCodigoPersona", lista.get(0).getpStrCodigoPersona());
        json.addProperty("pStrCanal", lista.get(0).pStrCanal);
        json.addProperty("pStrUsuarioRegistrado", lista.get(0).pStrUsuarioRegistrado);
        json.addProperty("pNroSesion", (String) theActorInTheSpotlight().recall("NumeroSesion"));
        return json.toString();
    }
}
