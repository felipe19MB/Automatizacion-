package bo.com.bga.certificacion.ganamovil.tasks.pagodeservicio.PreCondicion;

import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DesactivarServicio implements Task {

    private String codigo;

    public DesactivarServicio(String codigo){
        this.codigo = codigo;
    }

    @Title("Se desactiva el servicio registrado")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> condicionesUpdate = new HashMap<>();
        Map<String, Object> valoresUpdate1 = new HashMap<>();
        condicionesUpdate.put("COD_PERSONAFISICA", codigo );
        condicionesUpdate.put("COD_SERVICIO", 42 );
        condicionesUpdate.put("COD_ESTADO_AFILIACION", 1 );
        valoresUpdate1.put("COD_ESTADO_AFILIACION", 4);
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.Actualizar("SRV_AFILIACIONES",condicionesUpdate,valoresUpdate1,"GANADERO")
        );
    }

    public static DesactivarServicio desactivar(String codigo){
        return Tasks.instrumented(DesactivarServicio.class, codigo);
    }
}
