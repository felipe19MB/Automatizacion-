package bo.com.bga.certificacion.gananet.models.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosIngreso {
    private String usuario;
    private String contrasena;

    private  String nuevaClave;


    public String getNuevaClave() {
        return nuevaClave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static List<DatosIngreso> setData(DataTable dataTable) {
        List<DatosIngreso> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, DatosIngreso.class));
        }
        return dates;
    }
}
