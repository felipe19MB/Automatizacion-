package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ObtenerTodos implements Interaction {
    private final String tabla;
    private List<Map<String, Object>> resultado;
    private String schema;

    public ObtenerTodos(String tabla, String database) {
        this.tabla = tabla;
        this.schema = schema;
    }

    public static ObtenerTodos deTabla(String tabla,String schema) {
        return new ObtenerTodos(tabla, schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            dao.obtenerTodos(tabla);
            resultado = dao.obtenerTodos(tabla);
            actor.remember("resultadosObtenidos", resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro", e);
        }
    }
}
