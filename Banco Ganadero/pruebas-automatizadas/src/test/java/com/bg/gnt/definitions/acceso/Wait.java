package com.bg.gnt.definitions.acceso;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

public class Wait implements Interaction {

    private int tiempo;

    public Wait(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Awaitility.await().forever().pollInterval(tiempo, TimeUnit.SECONDS).until(() -> true);

    }

    public static Wait unMomento(int tiempo) {
        return Tasks.instrumented(Wait.class, tiempo);
    }
}
