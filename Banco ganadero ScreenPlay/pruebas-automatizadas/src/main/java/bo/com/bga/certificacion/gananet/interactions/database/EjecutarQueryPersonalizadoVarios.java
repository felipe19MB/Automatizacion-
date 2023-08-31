package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EjecutarQueryPersonalizadoVarios implements Interaction {
    private final String query;
    private final String schema;
    private List<Map<String, Object>> resultado;
    private final String key;
    public EjecutarQueryPersonalizadoVarios(String query,String key, String schema) {
        this.query = query;
        this.key = key;
        this.schema = schema;
    }

    public static EjecutarQueryPersonalizadoVarios conQuery(String query,String key, String schema) {
        return new EjecutarQueryPersonalizadoVarios(query,key,schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            resultado = dao.obtenerTodosPersonalizado(query);
            actor.remember(key, resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro", e);
        }
    }
}