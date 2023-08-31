package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.Map;

public class EliminarRegistro implements Interaction {
    private String tabla;
    private Map<String, Object> condiciones;
    private String schema;

    public EliminarRegistro(String tabla, Map<String, Object> condiciones, String schema) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.schema = schema;
    }

    public static EliminarRegistro deTabla(String tabla,Map<String, Object> condiciones,String schema) {
        return new EliminarRegistro(tabla,condiciones,schema);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            dao.eliminar(tabla,condiciones);
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro", e);
        }
    }
}