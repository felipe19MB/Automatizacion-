package bo.com.bga.certificacion.api.interactions.database;

import bo.com.bga.certificacion.api.utils.database.ApiDAO;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Title;

import java.sql.SQLException;
import java.util.List;
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
    @Title("Ejecuta la obtención de datos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            ApiDAO dao = new ApiDAO(schema);
            resultado = dao.obtenerPorId(tabla,condiciones);
            actor.remember("resultadosObtenidos", resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el registro", e);
        }
    }

    public static ObtenerPorId enTabla(String tabla, Map<String, Object> condiciones,String schema){
        return Instrumented.instanceOf(ObtenerPorId.class).withProperties(tabla,condiciones,schema);
    }
}


