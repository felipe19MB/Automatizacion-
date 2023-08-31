package bo.com.bga.certificacion.gananet.interactions.shared;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Espera implements Interaction {

    private int time;

    public Espera(int time) {
        this.time = time;
    }

    public static Espera aTime(int time) {
        return Tasks.instrumented(Espera.class, time);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        InternalSystemClock clock = new InternalSystemClock();
        clock.pauseFor(time);
    }
}
