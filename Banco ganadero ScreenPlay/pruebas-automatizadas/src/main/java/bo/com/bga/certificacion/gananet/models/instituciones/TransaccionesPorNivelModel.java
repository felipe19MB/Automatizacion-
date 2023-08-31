package bo.com.bga.certificacion.gananet.models.instituciones;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransaccionesPorNivelModel {
    private String institucion;
    private String gestion;
    private String fechaInicial;
    private String fechaFinal;

    private String  importeTotal;

    private String nivel;
    private String agrupacion;

    private String subFuncionalidad;

    private String numeroTransaccion;

    private String usr;
    private String curso;
    private String concepto;
    private String codigo;
    private String nombre;
    private String cuota;
    private String monto;

    public String getImporteTotal() {
        return importeTotal;
    }

    public String getNivel() {
        return nivel;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public String getUsr() {
        return usr;
    }

    public String getCurso() {
        return curso;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuota() {
        return cuota;
    }

    public String getMonto() {
        return monto;
    }

    public String getSubFuncionalidad() {
        return subFuncionalidad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getGestion() {
        return gestion;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public String getAgrupacion() {
        return agrupacion;
    }

    public static List<TransaccionesPorNivelModel> setData(DataTable dataTable) {
        List<TransaccionesPorNivelModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, TransaccionesPorNivelModel.class));
        }
        return dates;
    }
}
