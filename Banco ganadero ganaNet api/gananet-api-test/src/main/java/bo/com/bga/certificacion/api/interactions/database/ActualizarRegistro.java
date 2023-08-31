package bo.com.bga.certificacion.api.interactions.database;


import bo.com.bga.certificacion.api.utils.database.ApiDAO;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Title;

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
    @Title("Ejecuta la actualización de los datos")
    @Override
    public <T extends Actor> void performAs(T t) {
        try {
            ApiDAO dao = new ApiDAO(schema);
            dao.actualizar(tabla, condiciones, valores);
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar registro", e);
        }

    }

    public static ActualizarRegistro enTabla(String tabla,Map<String, Object> condiciones, Map<String, Object> valores,String schema){
        return Instrumented.instanceOf(ActualizarRegistro.class).withProperties(tabla,condiciones, valores,schema);
    }
}

