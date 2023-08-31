package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.Map;

public class ActualizarRegistro implements Interaction {
    private String tabla;
    private Map<String, Object> valores;
    private Map<String, Object> condiciones;
    private String schema;

    public ActualizarRegistro(String tabla,Map<String, Object> condiciones, Map<String, Object> valores,String schema) {
        this.tabla = tabla;
        this.valores = valores;
        this.condiciones = condiciones;
        this.schema =schema;
    }

    public static ActualizarRegistro enTabla(String tabla,Map<String, Object> condiciones, Map<String, Object> valores,String schema) {
        return new ActualizarRegistro(tabla,condiciones, valores,schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            dao.actualizar(tabla, condiciones, valores);
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar registro", e);
        }
    }
}