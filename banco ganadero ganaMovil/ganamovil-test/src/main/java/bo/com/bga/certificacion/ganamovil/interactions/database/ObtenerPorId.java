package bo.com.bga.certificacion.ganamovil.interactions.database;

import bo.com.bga.certificacion.ganamovil.utils.database.GanaMovilDAO;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Title;

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
    @Title("Se ejecuta la obtención de datos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaMovilDAO dao = new GanaMovilDAO(schema);
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

