package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.HashMap;
import java.util.Map;

public class TransaccionesMaximasPorDia implements Task {

    private String cuenta;

    public TransaccionesMaximasPorDia(String cuenta){
        this.cuenta = cuenta;
    }

    @Title("Se limita las transacciones máximas por día para la cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> condicionesUpdateMontoXDia = new HashMap<>();
        condicionesUpdateMontoXDia.put("SWCTANCTA", cuenta );
        Map<String, Object> valoresUpdateMontoXDia = new HashMap<>();
        valoresUpdateMontoXDia.put("SWCTAIMPD", 1);
        valoresUpdateMontoXDia.put("SWCTAIMRD", 2);
        actor.attemptsTo(
                EjecutarBaseDeDatos.Actualizar("GANANET.GNT_CUENTAS",condicionesUpdateMontoXDia,valoresUpdateMontoXDia,"GANADERO")
        );
    }

    public static TransaccionesMaximasPorDia transaccionesMaximasPorDia(String cuenta){
        return Tasks.instrumented(TransaccionesMaximasPorDia.class, cuenta);
    }
}
