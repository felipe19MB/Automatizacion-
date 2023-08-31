package bo.com.bga.certificacion.api.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ejemplo_de_un_modelo_complejo {

    private String codigoServicio;
    private String nombreReferencia;
    private String gestion;
    private String abreviaturaCriterioBusqueda;
    private String codigoAplicacion;
    private String identificador;
    private String nroPersona;
    private String sesion;
    private String usuario;
    private String codigo;
    private String codigovalor;


    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreReferencia() {
        return nombreReferencia;
    }

    public void setNombreReferencia(String nombreReferencia) {
        this.nombreReferencia = nombreReferencia;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getAbreviaturaCriterioBusqueda() {
        return abreviaturaCriterioBusqueda;
    }

    public void setAbreviaturaCriterioBusqueda(String abreviaturaCriterioBusqueda) {
        this.abreviaturaCriterioBusqueda = abreviaturaCriterioBusqueda;
    }

    public String getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(String codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNroPersona() {
        return nroPersona;
    }

    public void setNroPersona(String nroPersona) {
        this.nroPersona = nroPersona;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigovalor() {
        return codigovalor;
    }

    public void setCodigovalor(String codigovalor) {
        this.codigovalor = codigovalor;
    }

    public static String setData(DataTable dataTable) {
        List<Ejemplo_de_un_modelo_complejo> dates = new ArrayList<>();
        List<java.util.Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, Ejemplo_de_un_modelo_complejo.class));
        }
        return toJsonString(dates);
    }

    public static String toJson(List<Ejemplo_de_un_modelo_complejo> lista) {
        Ejemplo_de_un_modelo_complejo afiliacion = lista.get(0);
        return String.format("{\n" +
                        "    \"CodigoServicio\": \"%s\",\n" +
                        "    \"NombreReferencia\": \"%s\",\n" +
                        "    \"Gestion\": \"%s\",\n" +
                        "    \"AbreviaturaCriterioBusqueda\": \"%s\",\n" +
                        "    \"Detalle\": {\n" +
                        "        \"CodigoAplicacion\": \"%s\",\n" +
                        "        \"IdentificadorLog\": \"%s\",\n" +
                        "        \"NroPersona\": \"%s\",\n" +
                        "        \"Sesion\": \"%s\",\n" +
                        "        \"Usuario\": \"%s\"\n" +
                        "    },\n" +
                        "    \"Lista\": [\n" +
                        "        {\n" +
                        "            \"Codigo\": \"%s\",\n" +
                        "            \"Valor\": \"%s\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}",
                afiliacion.getCodigoServicio(),
                afiliacion.getNombreReferencia(),
                afiliacion.getGestion(),
                afiliacion.getAbreviaturaCriterioBusqueda(),
                afiliacion.getCodigoAplicacion(),
                afiliacion.getIdentificador(),
                afiliacion.getNroPersona(),
                afiliacion.getSesion(),
                afiliacion.getUsuario(),
                afiliacion.getCodigo(),
                afiliacion.getCodigovalor());
    }

    public static String toJsonString(List<Ejemplo_de_un_modelo_complejo> lista) {
        JsonObject json = new JsonObject();
        JsonObject jsonDetalle = new JsonObject();
        JsonObject jsonLista = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        json.addProperty("CodigoServicio", lista.get(0).getCodigoServicio());
        json.addProperty("NombreReferencia", lista.get(0).getNombreReferencia());
        json.addProperty("Gestion", lista.get(0).getGestion());
        json.addProperty("AbreviaturaCriterioBusqueda", lista.get(0).getAbreviaturaCriterioBusqueda());
        jsonDetalle.addProperty("CodigoAplicacion", lista.get(0).getCodigoAplicacion());
        jsonDetalle.addProperty("IdentificadorLog", lista.get(0).getIdentificador());
        jsonDetalle.addProperty("NroPersona", lista.get(0).getNroPersona());
        jsonDetalle.addProperty("Sesion", lista.get(0).getSesion());
        jsonDetalle.addProperty("Usuario", lista.get(0).getUsuario());
        jsonLista.addProperty("Codigo", lista.get(0).getCodigo());
        jsonLista.addProperty("Valor", lista.get(0).getCodigovalor());
        jsonArray.add(jsonLista);
        json.add("Detalle", jsonDetalle);
        json.add("Lista", jsonArray);
        return json.toString();
    }
}
