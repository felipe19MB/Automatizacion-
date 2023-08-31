package bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CambioLimiteTransaccionesModel {

   private String  nroTransacciones;
   private  String usuario;

    public String getUsuario() {
        return usuario;
    }

    public String getNroTransacciones() {
        return nroTransacciones;
    }

    public static List<CambioLimiteTransaccionesModel> setData(DataTable dataTable) {
        List<CambioLimiteTransaccionesModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map,CambioLimiteTransaccionesModel.class));
        }
        return dates;
    }
}
