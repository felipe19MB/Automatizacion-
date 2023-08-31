package bo.com.bga.certificacion.gananet.tasks.shared;

import bo.com.bga.certificacion.gananet.interactions.database.*;
import bo.com.bga.certificacion.gananet.utils.GeneralConstants;
import bo.com.bga.certificacion.gananet.interactions.database.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

public class EjecutaBaseDeDatos implements Task {

    private String tabla;
    private Map<String, Object> valores;
    private Map<String, Object> condiciones;
    private List<Object> datosEntrada;
    private List<Object> datosSalida;
    private String metodo;
    private String query;
    private String schema;
    private String key;

    public EjecutaBaseDeDatos(String tabla, Map<String, Object> condiciones, Map<String, Object> valores, String schema, String metodo) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.valores = valores;
        this.metodo = metodo;
        this.schema = schema;
    }

    public EjecutaBaseDeDatos(String tabla, Map<String, Object> valores, String schema, String metodo) {
        this.tabla = tabla;
        this.valores = valores;
        this.metodo = metodo;
        this.schema = schema;
    }

    public EjecutaBaseDeDatos(String tabla, Map<String, Object> condiciones, String schema, String metodo, int diff) {
        this.tabla = tabla;
        this.condiciones = condiciones;
        this.metodo = metodo;
        this.schema = schema;
    }

    public EjecutaBaseDeDatos(String tabla, String schema, String metodo) {
        this.tabla = tabla;
        this.metodo = metodo;
        this.schema = schema;
    }

    public EjecutaBaseDeDatos(String query, String key, String schema, String metodo, int diff) {
        this.query = query;
        this.metodo = metodo;
        this.key = key;
        this.schema = schema;
    }

    public EjecutaBaseDeDatos(String query,List<Object> datosEntrada, List<Object> datosSalida, String key, String schema, String metodo) {
        this.query = query;
        this.datosEntrada = datosEntrada;
        this.datosSalida = datosSalida;
        this.key = key;
        this.schema = schema;
        this.metodo = metodo;
    }

    public static EjecutaBaseDeDatos Actualizar(String tabla, Map<String, Object> condiciones, Map<String, Object> valores, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, tabla, condiciones, valores, schema, GeneralConstants.ACTUALIZAR);
    }

    public static EjecutaBaseDeDatos Eliminar(String tabla, Map<String, Object> condiciones, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, tabla, condiciones, schema, GeneralConstants.ELIMINAR, 1);
    }

    public static EjecutaBaseDeDatos ObtenerPorId(String tabla, Map<String, Object> condiciones, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, tabla, condiciones, schema, GeneralConstants.OBTENER_POR_ID, 1);
    }

    public static EjecutaBaseDeDatos ObtenerTodos(String tabla, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, tabla, schema, GeneralConstants.OBTENER_TODOS);
    }

    public static EjecutaBaseDeDatos Agregar(String tabla, Map<String, Object> valores, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, tabla, valores, schema, GeneralConstants.AGREGAR);
    }

    public static EjecutaBaseDeDatos QueryPersonalizado(String query, String key, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, query, key, schema, GeneralConstants.PERSONALIZADO, 1);
    }

    public static EjecutaBaseDeDatos QueryPersonalizadoObtenerVarios(String query, String key, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, query, key, schema, GeneralConstants.PERSONALIZADO_VARIOS, 1);
    }

    public static EjecutaBaseDeDatos ConProcedimientosAlmacenados(String query, List<Object> datosEntrada, List<Object> datosSalida, String key, String schema) {
        return Tasks.instrumented(EjecutaBaseDeDatos.class, query, datosEntrada, datosSalida, key, schema, GeneralConstants.PROCEDIMIENTOS_ALMACENADOS);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (metodo) {
            case GeneralConstants.AGREGAR:
                actor.attemptsTo(
                        AgregarRegistro.enTabla(tabla, valores, schema)
                );
                break;
            case GeneralConstants.ACTUALIZAR:
                actor.attemptsTo(
                        ActualizarRegistro.enTabla(tabla, condiciones, valores, schema)
                );
                break;
            case GeneralConstants.ELIMINAR:
                actor.attemptsTo(
                        EliminarRegistro.deTabla(tabla, condiciones, schema)
                );
                break;
            case GeneralConstants.OBTENER_POR_ID:
                actor.attemptsTo(
                        ObtenerPorId.enTabla(tabla, condiciones, schema)
                );
                //Ejemplo de cómo acceder al resultado obtenido en la consulta:
                //Map<String, Object> recall = actor.recall("resultadosObtenidos");
                //System.out.println(recall);
                //System.out.println(recall.get("NRO_PERSONA"));
                break;
            case GeneralConstants.OBTENER_TODOS:
                actor.attemptsTo(
                        ObtenerTodos.deTabla(tabla, schema)
                );
                //Ejemplo de cómo acceder al resultado obtenido en la consulta:
            /*List<Map<String, Object>> recall = actor.recall("resultadosObtenidos");
              System.out.println(recall);
              System.out.println(recall.get(0).get("EBPRFNOMB"));*/
                break;
            case GeneralConstants.PERSONALIZADO:
                actor.attemptsTo(
                        EjecutarQueryPersonalizado.conQuery(query, key, schema)
                );
                break;
            case GeneralConstants.PERSONALIZADO_VARIOS:
                actor.attemptsTo(
                        EjecutarQueryPersonalizadoVarios.conQuery(query, key, schema)
                );
                break;
            case GeneralConstants.PROCEDIMIENTOS_ALMACENADOS:
                actor.attemptsTo(
                        EjecutarProcedimientoAlmacenado.con(query,datosEntrada, datosSalida,key, schema)
                );
                break;
        }
    }

    @Step("{0}")
    public EjecutaBaseDeDatos Comentario(String comentario) {
        return this;
    }
}
