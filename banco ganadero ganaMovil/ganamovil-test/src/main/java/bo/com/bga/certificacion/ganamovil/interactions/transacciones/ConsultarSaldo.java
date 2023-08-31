package bo.com.bga.certificacion.ganamovil.interactions.transacciones;

import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarSaldo implements Interaction {

    private String name;
    private String cuenta;

    public ConsultarSaldo(String name, String cuenta){
        this.name = name;
        this.cuenta = cuenta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String query = "SELECT C1604 FROM SALDOS WHERE CUENTA = "+cuenta+"";
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query, name ,"GANADERO")
        );
    }

    public static ConsultarSaldo consultar(String name, String cuenta){
        return Instrumented.instanceOf(ConsultarSaldo.class).withProperties(name, cuenta);
    }
}
