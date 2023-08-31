package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.HashMap;
import java.util.Map;

public class TransaccionesLimiteImporteDiario implements Task {

    private String cuenta;

    public TransaccionesLimiteImporteDiario(String cuenta){
        this.cuenta = cuenta;
    }

    @Title("Se limita el importe diario permitido para la cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> condiciones = new HashMap<>();
        condiciones.put("SWCTANCTA", cuenta );
        Map<String, Object> valores = new HashMap<>();
        valores.put("SWCTAIMPD", 1);
        valores.put("SWCTAIMRD", 2);
        actor.attemptsTo(
                EjecutarBaseDeDatos.Actualizar("GANANET.GNT_CUENTAS",condiciones,valores,"GANADERO")
        );
    }

    public static TransaccionesLimiteImporteDiario transaccionesLimiteImporteDiario(String cuenta){
        return Tasks.instrumented(TransaccionesLimiteImporteDiario.class, cuenta);
    }
}
