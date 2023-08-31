package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LimiteDeImportePorFirma implements Task {

    private String cuenta;

    public LimiteDeImportePorFirma(String cuenta){
        this.cuenta = cuenta;
    }

    @Title("Se limita la cuenta para el importe por firma")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> condiciones = new HashMap<>();
        String pStrNombreUsuario = theActorInTheSpotlight().recall("pStrNombreUsuario");
        condiciones.put("COMBINACION", 1 );
        condiciones.put("CUENTA", cuenta );
        condiciones.put("CODPERSONA", pStrNombreUsuario );
        Map<String, Object> valores = new HashMap<>();
        valores.put("IMPORTE", 5);
        actor.attemptsTo(
                EjecutarBaseDeDatos.Actualizar("GANANET.GNT_FIRMAS",condiciones,valores,"GANADERO")
        );
    }

    public static LimiteDeImportePorFirma limiteDeImportePorFirma(String cuenta){
        return Tasks.instrumented(LimiteDeImportePorFirma.class, cuenta);
    }
}
