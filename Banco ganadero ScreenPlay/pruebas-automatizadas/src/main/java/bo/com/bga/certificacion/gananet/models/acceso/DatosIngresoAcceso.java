package bo.com.bga.certificacion.gananet.models.acceso;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosIngresoAcceso {
    private String email;
    private String ganapin;
    private String usuario;
    private String mensaje;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public String getMensaje(){
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGanapin() {
        return ganapin;
    }

    public void setGanapin(String ganapin) {
        this.ganapin = ganapin;
    }

    public static List<DatosIngresoAcceso> setData(DataTable dataTable) {
        List<DatosIngresoAcceso> datos = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            datos.add(new ObjectMapper().convertValue(map, DatosIngresoAcceso.class));
        }
        return datos;
    }
}
