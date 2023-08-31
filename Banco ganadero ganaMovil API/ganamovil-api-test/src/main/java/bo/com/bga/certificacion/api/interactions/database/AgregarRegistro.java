package bo.com.bga.certificacion.api.interactions.database;

import bo.com.bga.certificacion.api.utils.database.ApiDAO;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.Map;

public class AgregarRegistro implements Interaction {
    private String tabla;
    private Map<String, Object> valores;
    private String schema;

    public AgregarRegistro(String tabla, Map<String, Object> valores, String schema) {
        this.tabla = tabla;
        this.valores = valores;
        this.schema = schema;
    }

    public static AgregarRegistro enTabla(String tabla, Map<String, Object> valores, String schema) {
        return Instrumented.instanceOf(AgregarRegistro.class).withProperties(tabla, valores,schema);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            ApiDAO dao = new ApiDAO(schema);
            dao.agregar(tabla, valores);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
