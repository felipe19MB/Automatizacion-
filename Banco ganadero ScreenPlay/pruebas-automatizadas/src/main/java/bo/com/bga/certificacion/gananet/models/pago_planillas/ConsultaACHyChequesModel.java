package bo.com.bga.certificacion.gananet.models.pago_planillas;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsultaACHyChequesModel {

    private String  servicio;
    private String tipoDeReporte;
    private  String numeroPlanilla;
    private String busqueda;
    private String  convenio;
    private String lote;
    private String nroIdentificacion;
    private String importe;
    private String nroPlanilla;

    private String  fechaProceso;

    private String fechaDeVigencia;

    private String beneficiario;

    private  String moneda;

    private  String bancoDestinatario;

    private  String  motivoRechazo;

    public String getFechaProceso() {
        return fechaProceso;
    }

    public String getFechaDeVigencia() {
        return fechaDeVigencia;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getBancoDestinatario() {
        return bancoDestinatario;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public String getNroPlanilla() {
        return nroPlanilla;
    }

    public String getConvenio() {
        return convenio;
    }

    public String getLote() {
        return lote;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public String getImporte() {
        return importe;
    }

    public String getNumeroPlanilla() {
        return numeroPlanilla;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getTipoDeReporte() {
        return tipoDeReporte;
    }

    public void setTipoDeReporte(String tipoDeReporte) {
        this.tipoDeReporte = tipoDeReporte;
    }
    public static List<ConsultaACHyChequesModel> setData(DataTable dataTable) {
        List<ConsultaACHyChequesModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, ConsultaACHyChequesModel.class));
        }
        return dates;
    }



}
