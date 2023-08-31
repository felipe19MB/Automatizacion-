package bo.com.bga.certificacion.gananet.interactions.database;

import bo.com.bga.certificacion.gananet.utils.database.GanaNetDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EjecutarProcedimientoAlmacenado implements Interaction {
    private String query;
    private String key;
    private List<Object> parametrosEntrada;
    private List<Object> valoresSalida;
    private String schema;

    public EjecutarProcedimientoAlmacenado(String query,List<Object>parametrosEntrada, List<Object> valoresSalida,String key, String schema) {
        this.query=query;
        this.parametrosEntrada = parametrosEntrada;
        this.valoresSalida = valoresSalida;
        this.schema =schema;
        this.key = key;
    }

    public static EjecutarProcedimientoAlmacenado con(String query,List<Object>parametrosEntrada, List<Object> valoresSalida,String key, String schema) {
        return new EjecutarProcedimientoAlmacenado(query,parametrosEntrada, valoresSalida,key,schema);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GanaNetDao dao = new GanaNetDao(schema);
            List<Map<String, Object>> resultado = dao.procedimientoAlmacenado(query,parametrosEntrada, valoresSalida);
            actor.remember(key, resultado);
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar registro", e);
        }
    }
}