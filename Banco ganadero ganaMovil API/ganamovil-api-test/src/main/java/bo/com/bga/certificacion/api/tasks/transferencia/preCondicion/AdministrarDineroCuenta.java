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

public class AdministrarDineroCuenta implements Task {

    private String cuenta;
    private String saldo;

    public AdministrarDineroCuenta(String cuenta, String saldo){
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    @Title("Se administra el dinero de la cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {

        String querySinSaldo = "SELECT JTS_OID FROM SALDOS WHERE CUENTA IN ( '"+cuenta+"')";
        theActorInTheSpotlight().attemptsTo(EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(querySinSaldo,"pIntJtsOid", "GANADERO"));
        List<Map<String, Object>> result = theActorInTheSpotlight().recall("pIntJtsOid");
        String idSaldoOrigen = result.get(0).get("JTS_OID").toString();

        Map<String, Object> condicionesCuentaSinSaldo = new HashMap<>();
        condicionesCuentaSinSaldo.put("JTS_OID", idSaldoOrigen);
        condicionesCuentaSinSaldo.put("TZ_LOCK", "0");
        Map<String, Object> valoresCuentaSinSaldo = new HashMap<>();
        valoresCuentaSinSaldo.put("C1604", saldo);
        theActorInTheSpotlight().attemptsTo(EjecutarBaseDeDatos.Actualizar("SALDOS",condicionesCuentaSinSaldo,valoresCuentaSinSaldo,"GANADERO"));
    }

    public static AdministrarDineroCuenta administrarDineroCuenta(String cuenta, String saldo){
        return Tasks.instrumented(AdministrarDineroCuenta.class, cuenta, saldo);
    }
}
