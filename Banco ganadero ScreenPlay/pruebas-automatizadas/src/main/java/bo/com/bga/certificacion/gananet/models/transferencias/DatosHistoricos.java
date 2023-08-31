package bo.com.bga.certificacion.gananet.models.transferencias;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosHistoricos {

    private String cuentaPropia;
    private String estadoTransferencia;
    private String desde;
    private String hasta;
    private String subFuncionalidad;
    private String numeroTransaccion;

    private String cuentaTercero;

    private String tipoTransferencia;

    private String bancoDestino;
    private String cuentaDestino;
    private String estado;

    private String numeroTranferencia;
    private String aliasBeneficiario;

    private String paisBeneficiario;

    private String estadoConsulta;

    public String getEstadoConsulta() {
        return estadoConsulta;
    }

    public String getNumeroTranferencia() {
        return numeroTranferencia;
    }

    public String getAliasBeneficiario() {
        return aliasBeneficiario;
    }

    public String getPaisBeneficiario() {
        return paisBeneficiario;
    }

    public String getBancoDestino() {
        return bancoDestino;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public String getEstado() {
        return estado;
    }

    public String getCuentaTercero() {
        return cuentaTercero;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public String getSubFuncionalidad() {
        return subFuncionalidad;
    }

    public String getCuentaPropia() {
        return cuentaPropia;
    }

    public String getEstadoTransferencia() {
        return estadoTransferencia;
    }

    public String getDesde() {
        return desde;
    }

    public String getHasta() {
        return hasta;
    }

    public static List<DatosHistoricos> setData(DataTable dataTable) {
        List<DatosHistoricos> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,DatosHistoricos.class));
        }
        return dates;
    }
}
