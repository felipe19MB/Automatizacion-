package bo.com.bga.certificacion.gananet.interactions.shared;


import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.INPUT_CLAVE;
import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.INPUT_GANAPIN;


public class IngresaClaveTransaccional implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Espera.aTime(2000),
                Enter.theValue("1234").into(INPUT_CLAVE),
                JavaScriptClick.on(HomePage.BUTTON_PROCESAR)
        );
    }

    public static IngresaClaveTransaccional paraConfirmarProceso() {
        return Tasks.instrumented(IngresaClaveTransaccional.class);
    }
}
