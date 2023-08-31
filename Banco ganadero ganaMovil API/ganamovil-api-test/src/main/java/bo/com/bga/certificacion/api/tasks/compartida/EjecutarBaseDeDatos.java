package bo.com.bga.certificacion.api.tasks.compartida;

import bo.com.bga.certificacion.api.interactions.database.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.Map;

import static bo.com.bga.certificacion.api.utils.constants.Constantes.*;

public class EjecutarBaseDeDatos implements Task {


    private String tabla;
    private Map<String, Object> valores;
    private Map<String, Object> condiciones;
    private String metodo;
    private String query;
    private String schema;
    private String key;

    public EjecutarBaseDeDatos(String tabla, Map<String, Object> condiciones, Map<String, Object> valores, String schema, String metodo) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.valores = valores;
        this.metodo = metodo;
        this.schema = schema;
    }
    public EjecutarBaseDeDatos(String tabla, Map<String, Object> valores, String schema, String metodo) {
        this.tabla = tabla;
        this.valores = valores;
        this.metodo = metodo;
        this.schema = schema;
    }
    public EjecutarBaseDeDatos(String tabla, Map<String, Object> condiciones, String schema, String metodo, int diff) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.metodo = metodo;
        this.schema = schema;
    }
    public EjecutarBaseDeDatos(String tabla, String schema, String metodo) {
        this.tabla = tabla;
        this.metodo = metodo;
        this.schema = schema;
    }
    public EjecutarBaseDeDatos(String query, String key,String schema, String metodo, int diff) {
        this.query = query;
        this.metodo = metodo;
        this.key = key;
        this.schema = schema;
    }
    public static EjecutarBaseDeDatos Actualizar (String tabla, Map<String, Object> condiciones, Map<String, Object> valores, String schema){
        return Tasks.instrumented(EjecutarBaseDeDatos.class, tabla,condiciones,valores,schema, ACTUALIZAR);
    }
    public static EjecutarBaseDeDatos Eliminar (String tabla, Map<String, Object> condiciones, String schema){
        return Tasks.instrumented(EjecutarBaseDeDatos.class, tabla,condiciones,schema, ELIMINAR,1);
    }
    public static EjecutarBaseDeDatos ObtenerPorId (String tabla, Map<String, Object> condiciones, String schema){
        return Tasks.instrumented(EjecutarBaseDeDatos.class, tabla,condiciones,schema, OBTENER_POR_ID,1);
    }
    public static EjecutarBaseDeDatos QueryObtenerTodoPersonalizado (String query,String key, String schema){
        return Tasks.instrumented(EjecutarBaseDeDatos.class, query,key,schema, OBTENERTODOPERSONALIZADO,1);
    }
    public static EjecutarBaseDeDatos Agregar(String tabla, Map<String, Object> valores, String schema) {
        return Tasks.instrumented(EjecutarBaseDeDatos.class, tabla, valores, schema, AGREGAR);
    }

    public static EjecutarBaseDeDatos QueryPersonalizado(String query, String key, String schema) {
        return Tasks.instrumented(EjecutarBaseDeDatos.class, query, key, schema, PERSONALIZADO, 1);
    }

    @Title("Ejecuta la conexión a la base de datos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (metodo){
            case OBTENER_POR_ID:
                actor.attemptsTo(
                        ObtenerPorId.enTabla(tabla,condiciones,schema)
                );
                break;
            case ELIMINAR:
                actor.attemptsTo(
                        EliminarRegistro.deTabla(tabla,condiciones,schema)
                );
                break;
            case ACTUALIZAR:
                actor.attemptsTo(
                        ActualizarRegistro.enTabla(tabla,condiciones,valores,schema)
                );
                break;
            case OBTENERTODOPERSONALIZADO:
                actor.attemptsTo(
                        EjecutarObtenerTodoPersonalizado.conQuery(query,key,schema)
                );
                break;
            case AGREGAR:
                actor.attemptsTo(
                        AgregarRegistro.enTabla(tabla, valores, schema)
                );
                break;
            case PERSONALIZADO:
                actor.attemptsTo(
                        QueryPersonalizado.conQuery(query, key, schema)
                );
                break;

        }
    }
}


