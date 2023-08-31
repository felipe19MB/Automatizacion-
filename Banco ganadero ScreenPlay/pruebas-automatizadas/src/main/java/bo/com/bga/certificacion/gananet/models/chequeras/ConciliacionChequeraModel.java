package bo.com.bga.certificacion.gananet.models.chequeras;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

 public class ConciliacionChequeraModel {

    private  String cuentaOrigen;

    private String periodo;

    private String desde;

    private  String hasta;

    private  String nroCheque;

    private  String monto;

    private  String estado;

    private String  confirmacion;

     public String getNroCheque() {
         return nroCheque;
     }

     public String getMonto() {
         return monto;
     }

     public String getEstado() {
         return estado;
     }

     public String getConfirmacion() {
         return confirmacion;
     }

     public String getCuentaOrigen() {
         return cuentaOrigen;
     }

     public String getPeriodo() {
         return periodo;
     }

     public String getDesde() {
         return desde;
     }

     public String getHasta() {
         return hasta;
     }

     public static List<ConciliacionChequeraModel> setData(DataTable dataTable) {
        List<ConciliacionChequeraModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, ConciliacionChequeraModel.class));
        }
        return dates;
    }
}