package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;


import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BloquearODesbloquearCuenta implements Task {

    private String cuenta;
    private String valor;

    public BloquearODesbloquearCuenta(String cuenta, String valor){
        this.cuenta = cuenta;
        this.valor = valor;
    }

    @Title("Se bloquea o desbloquea la cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {

        String query = "SELECT JTS_OID FROM SALDOS WHERE CUENTA IN ( '"+cuenta+"')";
        theActorInTheSpotlight().attemptsTo(EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query,"idcuenta", "GANADERO"));
        List<Map<String, Object>> result = theActorInTheSpotlight().recall("idcuenta");
        String id = result.get(0).get("JTS_OID").toString();
        Map<String, Object> condiciones = new HashMap<>();
        condiciones.put("JTS_OID", id);
        condiciones.put("TZ_LOCK", "0");
        Map<String, Object> valores = new HashMap<>();
        valores.put("C1679", valor);
        theActorInTheSpotlight().attemptsTo(EjecutarBaseDeDatos.Actualizar("SALDOS",condiciones,valores,"GANADERO"));
    }

    public static BloquearODesbloquearCuenta bloquearODesbloquearCuenta(String cuenta, String valor){
        return Tasks.instrumented(BloquearODesbloquearCuenta.class, cuenta, valor);
    }

}
