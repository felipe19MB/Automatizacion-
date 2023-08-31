package bo.com.bga.certificacion.gananet.models.transferencias;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosAfiliacionCuentas {
    public String getSubFuncionalidad() {
        return subFuncionalidad;
    }

    public void setSubFuncionalidad(String subFuncionalidad) {
        this.subFuncionalidad = subFuncionalidad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCiNit() {
        return ciNit;
    }

    public void setCiNit(String ciNit) {
        this.ciNit = ciNit;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    private String subFuncionalidad;
    private String alias;
    private String banco;
    private String sucursal;
    private String nombreTitular;
    private String ciNit;
    private String tipoCuenta;
    private String nroCuenta;
    private String email;
    private String mensaje;
    private String telefono;
    private String moneda;
    private String titularCuenta;
    private String tipo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String usuario;

    public String getCuentaIBAN() {
        return cuentaIBAN;
    }

    public void setCuentaIBAN(String cuentaIBAN) {
        this.cuentaIBAN = cuentaIBAN;
    }

    public String getNombreAfiliado() {
        return nombreAfiliado;
    }

    public void setNombreAfiliado(String nombreAfiliado) {
        this.nombreAfiliado = nombreAfiliado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getPaisBanco() {
        return paisBanco;
    }

    public void setPaisBanco(String paisBanco) {
        this.paisBanco = paisBanco;
    }

    public String getCiudadBanco() {
        return ciudadBanco;
    }

    public void setCiudadBanco(String ciudadBanco) {
        this.ciudadBanco = ciudadBanco;
    }

    private String cuentaIBAN;
    private String nombreAfiliado;
    private String numeroDocumento;
    private String tipoPersona;
    private String direccion;
    private String pais;
    private String ciudad;
    private String tipoCodigo;
    private String codigoBanco;
    private String nombreBanco;
    private String paisBanco;
    private String ciudadBanco;

    public String getSubFuncionalidad1() {
        return subFuncionalidad1;
    }

    public void setSubFuncionalidad1(String subFuncionalidad1) {
        this.subFuncionalidad1 = subFuncionalidad1;
    }

    private String subFuncionalidad1;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public String getTitularCuenta() {
        return titularCuenta;
    }

    public void setTitularCuenta(String titularCuenta) {
        this.titularCuenta = titularCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public static List<DatosAfiliacionCuentas> setData(DataTable dataTable) {
        List<DatosAfiliacionCuentas> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,DatosAfiliacionCuentas.class));
        }
        return dates;
    }
}
