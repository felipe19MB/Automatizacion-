package bo.com.bga.certificacion.gananet.interactions.shared;

import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class CerrarModal implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(3).seconds(),
                JavaScriptClick.on(AfiliacionesPage.BOTON_OK),
                WaitUntil.the(AfiliacionesPage.BOTON_OK, isNotVisible()).forNoMoreThan(3).seconds()
        );
    }
    public static CerrarModal go(){
        return Tasks.instrumented(CerrarModal.class);
    }
}
