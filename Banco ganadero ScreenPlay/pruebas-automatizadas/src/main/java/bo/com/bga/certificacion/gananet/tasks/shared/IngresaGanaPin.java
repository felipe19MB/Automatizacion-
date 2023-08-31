package bo.com.bga.certificacion.gananet.tasks.shared;


import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.INPUT_GANAPIN;


public class IngresaGanaPin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("1234").into(INPUT_GANAPIN),
                JavaScriptClick.on(HomePage.BUTTON_PROCESAR)
        );
    }

    public static IngresaGanaPin paraConfirmarTransaccion() {
        return Tasks.instrumented(IngresaGanaPin.class);
    }
}
