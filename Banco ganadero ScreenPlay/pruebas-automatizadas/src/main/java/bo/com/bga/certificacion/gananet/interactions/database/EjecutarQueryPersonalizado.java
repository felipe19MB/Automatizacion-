package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.Map;

public class EjecutarQueryPersonalizado implements Interaction {
    private final String query;
    private final String schema;
    private final String key;
    public EjecutarQueryPersonalizado(String query,String key, String schema) {
        this.query = query;
        this.key = key;
        this.schema = schema;
    }

    public static EjecutarQueryPersonalizado conQuery(String query,String key, String schema) {
        return new EjecutarQueryPersonalizado(query,key,schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            Map<String, Object> resultado = dao.personalizado(query);
            actor.remember(key, resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error ejecutando el query personalizado", e);
        }
    }
}