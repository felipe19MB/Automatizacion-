package bo.com.bga.certificacion.gananet.models.orden_cobro_simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrdenDeCobroModel {
     private  String nroCuenta;
     private  String tipoCobro;
     private String fechaVencimiento;
     private String moneda;
     private  String monto;
     private String descripcion;

     private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public String getTipoCobro() {
        return tipoCobro;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static List<OrdenDeCobroModel> setData(DataTable dataTable) {
        List<OrdenDeCobroModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, OrdenDeCobroModel.class));
        }
        return dates;
    }
}
