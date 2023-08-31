package bo.com.bga.certificacion.gananet.models.administracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosAlertaMovimientos {

    private String nroDeCuenta;
    private String correo;

    public String getNroDeCuenta() {
        return nroDeCuenta;
    }

    public void setNroDeCuenta(String nroDeCuenta) {
        this.nroDeCuenta = nroDeCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    private String tipoDeMovimiento;

    public static List<DatosAlertaMovimientos> setData(DataTable dataTable) {
        List<DatosAlertaMovimientos> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, DatosAlertaMovimientos.class));
        }
        return dates;
    }





}
