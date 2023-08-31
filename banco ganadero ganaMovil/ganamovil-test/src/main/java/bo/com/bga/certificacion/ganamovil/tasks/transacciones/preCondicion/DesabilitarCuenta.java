package bo.com.bga.certificacion.ganamovil.tasks.transacciones.preCondicion;

import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DesabilitarCuenta implements Task {

    private String tipo;
    private String persona;

    public DesabilitarCuenta(String tipo, String persona){
        this.tipo = tipo;
        this.persona = persona;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo){
            case "yolo":
                Map<String, Object> condicionesUpdate = new HashMap<>();
                Map<String, Object> valoresUpdate1 = new HashMap<>();
                condicionesUpdate.put("NRO_PERSONA", persona );
                condicionesUpdate.put("HABILITADO", "S" );
                condicionesUpdate.put("REFERENCIA", "PERSONA NATURAL" );
                valoresUpdate1.put("HABILITADO", "N");
                theActorInTheSpotlight().attemptsTo(
                        EjecutarBaseDeDatos.Actualizar("AUTOSRV.AUT_AFILIACION_CUENTAS",condicionesUpdate,valoresUpdate1,"GANADERO")
                );
                break;
            case "a terceros":
                Map<String, Object> condicionesDelete = new HashMap<>();
                condicionesDelete.put("EBCTECPER", persona );
                theActorInTheSpotlight().attemptsTo(
                        EjecutarBaseDeDatos.Eliminar("GNT_CUENTASDETERCEROS", condicionesDelete, "GANANET")
                );
                break;
            case "otros bancos":
                Map<String, Object> condicionesterceros = new HashMap<>();
                Map<String, Object> valoresterceros = new HashMap<>();
                condicionesterceros.put("CODCLIENTE", persona );
                condicionesterceros.put("NOMBRETITULAR", "Prueba Automatizada");
                condicionesterceros.put("MARCABAJA", 0);
                condicionesterceros.put("NROCUENTA", "123400456" );
                valoresterceros.put("MARCABAJA", 9);
                theActorInTheSpotlight().attemptsTo(
                        EjecutarBaseDeDatos.Actualizar("GANANET.GNT_LISTATRXOTROSBANCOS",condicionesterceros,valoresterceros,"AUTOSRV")
                );
                break;
            default:
                break;
        }
    }

    public static DesabilitarCuenta yolo(String persona){
        return Tasks.instrumented(DesabilitarCuenta.class, "yolo", persona);
    }

    public static DesabilitarCuenta terceros(String persona){
        return Tasks.instrumented(DesabilitarCuenta.class, "a terceros", persona);
    }

    public static DesabilitarCuenta otrosBancos(String persona){
        return Tasks.instrumented(DesabilitarCuenta.class, "otros bancos", persona);
    }
}
