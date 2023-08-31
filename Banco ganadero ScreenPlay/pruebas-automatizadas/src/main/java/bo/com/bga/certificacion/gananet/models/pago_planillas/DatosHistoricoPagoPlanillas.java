package bo.com.bga.certificacion.gananet.models.pago_planillas;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosHistoricoPagoPlanillas {
    private String  convenio;
    private String periodoDel;
    private String periodoAl;
    private String lote;
    private String nroPlanilla;
    private String fechaProceso;
    private String fechaDeVigencia;
    private String beneficiario;
    private String nroIdentificación;
    private String importe;
    private String moneda;
    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getPeriodoDel() {
        return periodoDel;
    }

    public void setPeriodoDel(String periodoDel) {
        this.periodoDel = periodoDel;
    }

    public String getPeriodoAl() {
        return periodoAl;
    }

    public void setPeriodoAl(String periodoAl) {
        this.periodoAl = periodoAl;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNroPlanilla() {
        return nroPlanilla;
    }

    public void setNroPlanilla(String nroPlanilla) {
        this.nroPlanilla = nroPlanilla;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getFechaDeVigencia() {
        return fechaDeVigencia;
    }

    public void setFechaDeVigencia(String fechaDeVigencia) {
        this.fechaDeVigencia = fechaDeVigencia;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getNroIdentificación() {
        return nroIdentificación;
    }

    public void setNroIdentificación(String nroIdentificación) {
        this.nroIdentificación = nroIdentificación;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public static List<DatosHistoricoPagoPlanillas> setData(DataTable dataTable) {
        List<DatosHistoricoPagoPlanillas> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,DatosHistoricoPagoPlanillas.class));
        }
        return dates;
    }
}
