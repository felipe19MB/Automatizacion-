package bo.com.bga.certificacion.ganamovil.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioModel {
    private String usuario;
    private String contrasena;
    private String interaccion;

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

    public String getInteraccion() {
        return interaccion;
    }

    public void setInteraccion(String interaccion) {
        this.interaccion = interaccion;
    }

    public static List<UsuarioModel> setData(DataTable dataTable) {
        List<UsuarioModel> datos = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            datos.add(new ObjectMapper().convertValue(map, UsuarioModel.class));
        }
        return datos;
    }
}
