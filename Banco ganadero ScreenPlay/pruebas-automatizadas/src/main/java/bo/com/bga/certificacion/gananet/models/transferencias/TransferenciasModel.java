package bo.com.bga.certificacion.gananet.models.transferencias;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransferenciasModel {

    private String cuentaOrigen;
    private String cuentaDestino;
    private String tipoCuenta;
    private String monto;
    private String glosaDebito;
    private String glosaCredito;
    private String montoSufijoComprobante;
    private String tipoImporte;
    private String tipoTransferencia;

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public String getTipoImporte() {
        return tipoImporte;
    }

    public void setTipoImporte(String tipoImporte) {
        this.tipoImporte = tipoImporte;
    }

    public String getMontoSufijoComprobante() {
        return montoSufijoComprobante;
    }

    public void setMontoSufijoComprobante(String montoSufijoComprobante) {
        this.montoSufijoComprobante = montoSufijoComprobante;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getGlosaDebito() {
        return glosaDebito;
    }

    public void setGlosaDebito(String glosaDebito) {
        this.glosaDebito = glosaDebito;
    }

    public String getGlosaCredito() {
        return glosaCredito;
    }

    public void setGlosaCredito(String glosaCredito) {
        this.glosaCredito = glosaCredito;
    }

    public static List<TransferenciasModel> setData(DataTable dataTable) {
        List<TransferenciasModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, TransferenciasModel.class));
        }
        return dates;
    }
}
