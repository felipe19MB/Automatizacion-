package bo.com.bga.certificacion.ganamovil.interactions.database;

import bo.com.bga.certificacion.ganamovil.utils.database.GanaMovilDAO;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Title;

import java.sql.SQLException;
import java.util.Map;

public class EliminarRegistro implements Interaction {
    private String tabla;
    private Map<String, Object> condiciones;
    private String schema;

    public EliminarRegistro(String tabla, Map<String, Object> condiciones, String schema) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.schema = schema;
    }
    @Title("Se ejecuta la eliminación")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaMovilDAO dao = new GanaMovilDAO(schema);
            dao.eliminar(tabla,condiciones);
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro", e);
        }
    }


    public static EliminarRegistro deTabla(String tabla,Map<String, Object> condiciones,String schema){
        return Instrumented.instanceOf(EliminarRegistro.class).withProperties(tabla,condiciones,schema);
    }
}