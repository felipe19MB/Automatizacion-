package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;


import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarIdCuentas implements Task {

    private String cuentaOrigen;
    private String cuentaDestino;

    public ConsultarIdCuentas(String cuentaOrigen, String cuentaDestino){
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    @Title("Se consulta él id de la cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String query = "SELECT JTS_OID FROM SALDOS WHERE CUENTA IN ( '"+cuentaOrigen+"', '"+cuentaDestino+"') ORDER BY CASE WHEN CUENTA = '"+cuentaOrigen+"' THEN 1 WHEN CUENTA = '"+cuentaDestino+"' THEN 2 ELSE 3 END";
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query,"pIntJtsOid", "GANADERO")
        );
    }

    public static ConsultarIdCuentas consultarIdCuentas(String cuentaOrigen, String cuentaDestino){
        return Tasks.instrumented(ConsultarIdCuentas.class, cuentaOrigen, cuentaDestino);
    }
}
