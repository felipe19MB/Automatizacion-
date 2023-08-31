package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.Map;


public class ObtenerPorId implements Interaction {
    private String tabla;
    private Map<String, Object> condiciones;
    private Map<String, Object> resultado;
    private String schema;

    public ObtenerPorId(String tabla, Map<String, Object> condiciones,String schema) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.schema = schema;
    }
    public static ObtenerPorId enTabla(String tabla, Map<String, Object> condiciones,String schema) {
        return new ObtenerPorId(tabla,condiciones,schema);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            resultado = dao.obtenerPorId(tabla,condiciones);
            actor.remember("resultadosObtenidos", resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el registro", e);
        }
    }
}
