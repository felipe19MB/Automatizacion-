package bo.com.bga.certificacion.ganamovil.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransferenciaModel {
    private String institucion;
    private String cuentaorigen;
    private String cuentadestino;
    private String descripcion;
    private String saldo;
    private String nombretitular;
    private String telefono;
    private String nombresucursal;
    private String tipocuenta;
    private String nombredestinatario;
    public String guardarcomo;

    public String getGuardarcomo() {
        return guardarcomo;
    }

    public String getCuentaorigen() {
        return cuentaorigen;
    }

    public void setCuentaorigen(String cuentaorigen) {
        this.cuentaorigen = cuentaorigen;
    }

    public String getCuentadestino() {
        return cuentadestino;
    }

    public void setCuentadestino(String cuentadestino) {
        this.cuentadestino = cuentadestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNombretitular() {
        return nombretitular;
    }

    public void setNombretitular(String nombretitular) {
        this.nombretitular = nombretitular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombresucursal() {
        return nombresucursal;
    }

    public void setNombresucursal(String nombresucursal) {
        this.nombresucursal = nombresucursal;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getNombredestinatario() {
        return nombredestinatario;
    }

    public void setNombredestinatario(String nombredestinatario) {
        this.nombredestinatario = nombredestinatario;
    }

    public static List<TransferenciaModel> setData(DataTable dataTable) {
        List<TransferenciaModel> datos = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            datos.add(new ObjectMapper().convertValue(map, TransferenciaModel.class));
        }
        return datos;
    }
}
