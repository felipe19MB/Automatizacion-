package bo.com.bga.certificacion.api.interactions.database;

import bo.com.bga.certificacion.api.utils.database.ApiDAO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EjecutarObtenerTodoPersonalizado implements Interaction {
    private final String query;
    private final String schema;
    private final String key;
    public EjecutarObtenerTodoPersonalizado(String query, String key, String schema) {
        this.query = query;
        this.key = key;
        this.schema = schema;
    }

    public static EjecutarObtenerTodoPersonalizado conQuery(String query, String key, String schema) {
        return new EjecutarObtenerTodoPersonalizado(query,key,schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            ApiDAO dao = new ApiDAO(schema);
            List<Map<String, Object>> resultado = dao.obtenerTodosPersonalizado(query);
            actor.remember(key, resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error ejecutando el query personalizado", e);
        }
    }
}

