package bo.com.bga.certificacion.gananet.interactions.shared;


import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.INPUT_GANAPIN;
import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.INPUT_GANAPIN2;


public class IngresaGanaPin2 implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("1234").into(INPUT_GANAPIN2),
                JavaScriptClick.on(HomePage.BUTTON_PROCESAR2)
        );
    }

    public static IngresaGanaPin2 paraConfirmarProceso() {
        return Tasks.instrumented(IngresaGanaPin2.class);
    }
}
