package bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad;

import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.GenerarExtractoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActualizacionDeDatosModel {

    private String departamento;
    private String ciudad;
    private String zona;
    private String uv;
    private String mza;
    private String barrio;
    private String calle;
    private String nroPuerta;
    private String piso;
    private String apartamento;
    private String email;
    private String telefono;
    private String celular;

    private String domicilio;

    private String nombreRef1;

    private String nombreRef2;

    private String telefonoRef1;

    private String telefonoRef2;

    private String relacionRef1;

    private String relacionRef2;

    public String getNombreRef1() {
        return nombreRef1;
    }

    public String getNombreRef2() {
        return nombreRef2;
    }

    public String getTelefonoRef1() {
        return telefonoRef1;
    }

    public String getTelefonoRef2() {
        return telefonoRef2;
    }

    public String getRelacionRef1() {
        return relacionRef1;
    }

    public String getRelacionRef2() {
        return relacionRef2;
    }

    public String getDomicilio() {
        return domicilio;
    }



    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getZona() {
        return zona;
    }

    public String getUv() {
        return uv;
    }

    public String getMza() {
        return mza;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCalle() {
        return calle;
    }

    public String getNroPuerta() {
        return nroPuerta;
    }

    public String getPiso() {
        return piso;
    }

    public String getApartamento() {
        return apartamento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public static List<ActualizacionDeDatosModel> setData(DataTable dataTable) {
        List<ActualizacionDeDatosModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,ActualizacionDeDatosModel.class));
        }
        return dates;
    }
}
