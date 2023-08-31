package bo.com.bga.certificacion.gananet.models.atencion_al_cliente;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegistroSugerenciaModel {
    private String correoElectronico;
    private String descripcion;
    private String mensajeInformativo;
    private String mensajeConfirmacion;

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public String getMensajeInformativo() {
        return mensajeInformativo;
    }

    public void setMensajeInformativo(String mensajeInformativo) {
        this.mensajeInformativo = mensajeInformativo;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajeConfirmacion() {
        return mensajeConfirmacion;
    }

    public void setMensajeConfirmacion(String mensajeConfirmacion) {
        this.mensajeConfirmacion = mensajeConfirmacion;
    }
    public static List<RegistroSugerenciaModel> setData(DataTable dataTable) {
        List<RegistroSugerenciaModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,RegistroSugerenciaModel.class));
        }
        return dates;
    }
}
