package bo.com.bga.certificacion.api.interactions.database;

import bo.com.bga.certificacion.api.utils.database.ApiDAO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.Map;

public class QueryPersonalizado implements Interaction {
    private final String query;
    private final String schema;
    private final String key;
    public QueryPersonalizado(String query,String key, String schema) {
        this.query = query;
        this.key = key;
        this.schema = schema;
    }

    public static QueryPersonalizado conQuery(String query,String key, String schema) {
        return new QueryPersonalizado(query,key,schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            ApiDAO dao = new ApiDAO(schema);
            Map<String, Object> resultado = dao.personalizado(query);
            actor.remember(key, resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error ejecutando el query personalizado", e);
        }
    }
}
