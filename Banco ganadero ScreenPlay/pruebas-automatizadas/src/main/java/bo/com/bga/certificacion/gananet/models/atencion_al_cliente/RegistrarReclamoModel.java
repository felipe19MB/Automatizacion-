package bo.com.bga.certificacion.gananet.models.atencion_al_cliente;

import bo.com.bga.certificacion.gananet.models.chequeras.SolicitudChequeraModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegistrarReclamoModel {

     private String celular;
     private String telefonoTrabajo;
     private String barrio;
     private String calle;
     private String numeroCasa;
     private String correoElectronico;
     private String tipoReclamo;
     private  String reclamo;
     private String monto;
     private String moneda;
     private String descripcion;

     private String tipo;

     private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCelular() {
        return celular;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTipoReclamo() {
        return tipoReclamo;
    }

    public String getReclamo() {
        return reclamo;
    }

    public String getMonto() {
        return monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static List<RegistrarReclamoModel> setData(DataTable dataTable) {
        List<RegistrarReclamoModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,RegistrarReclamoModel.class));
        }
        return dates;
    }
}
