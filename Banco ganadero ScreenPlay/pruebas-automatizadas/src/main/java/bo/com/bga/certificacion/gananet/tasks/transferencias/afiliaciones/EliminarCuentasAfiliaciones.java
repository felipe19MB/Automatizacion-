package bo.com.bga.certificacion.gananet.tasks.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones.EliminarCuentasAfiliadas;
import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class EliminarCuentasAfiliaciones implements Task {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public EliminarCuentasAfiliaciones(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EliminarCuentasAfiliadas.go(datosAfiliacionCuentas),
                CerrarModal.go()
        );
    }
    public static EliminarCuentasAfiliaciones go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Tasks.instrumented(EliminarCuentasAfiliaciones.class,datosAfiliacionCuentas);
    }
}
