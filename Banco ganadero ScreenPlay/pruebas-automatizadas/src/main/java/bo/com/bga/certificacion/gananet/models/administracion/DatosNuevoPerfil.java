package bo.com.bga.certificacion.gananet.models.administracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosNuevoPerfil {

    private String nombrePerfil;
    private String perfilBase;
    private String mensaje;
    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getPerfilBase() {
        return perfilBase;
    }

    public void setPerfilBase(String perfilBase) {
        this.perfilBase = perfilBase;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public static List<DatosNuevoPerfil> setData(DataTable dataTable) {
        List<DatosNuevoPerfil> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,DatosNuevoPerfil.class));
        }
        return dates;
    }





}
