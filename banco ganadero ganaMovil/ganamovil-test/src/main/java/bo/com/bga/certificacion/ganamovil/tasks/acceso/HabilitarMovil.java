package bo.com.bga.certificacion.ganamovil.tasks.acceso;

import bo.com.bga.certificacion.ganamovil.userinterfaces.acceso.UiIniciarSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;

public class HabilitarMovil implements Task {

    private boolean tipo;

    public HabilitarMovil(boolean tipo){
        this.tipo = tipo;
    }

    @Title("Se habilita el dispositivo móvil")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UiIniciarSesion.BTN_ACEPTAR_HABILITACION, WebElementStateMatchers.isClickable()).forNoMoreThan(30).seconds(),
                Click.on(UiIniciarSesion.BTN_ACEPTAR_HABILITACION),
                Check.whether(tipo).andIfSo(
                        Click.on(UiIniciarSesion.BTN_MODAL_ENTENDIDO)
                )
        );
    }

    public static HabilitarMovil go(){

        return Tasks.instrumented(HabilitarMovil.class, false);
    }
    public static HabilitarMovil happy(){
        return Tasks.instrumented(HabilitarMovil.class, true);
    }
}
