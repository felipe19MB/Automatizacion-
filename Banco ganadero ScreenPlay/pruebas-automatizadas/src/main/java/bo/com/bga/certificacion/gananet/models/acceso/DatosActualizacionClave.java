package bo.com.bga.certificacion.gananet.models.acceso;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosActualizacionClave {

    private String nuevaClave;

    private String nuevaClaveTransaccional;
    private String claveActual;

    private  String contrasena;

    private String claveTransCifrada;

    public String getClaveTransCifrada() {
        return claveTransCifrada;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNuevaClaveTransaccional() {
        return nuevaClaveTransaccional;
    }

    public void setNuevaClaveTransaccional(String nuevaClaveTransaccional) {
        this.nuevaClaveTransaccional = nuevaClaveTransaccional;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public String getClaveActual() {
        return claveActual;
    }

    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    public static List<DatosActualizacionClave> setData(DataTable dataTable) {
        List<DatosActualizacionClave> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,DatosActualizacionClave.class));
        }
        return dates;
    }

}
