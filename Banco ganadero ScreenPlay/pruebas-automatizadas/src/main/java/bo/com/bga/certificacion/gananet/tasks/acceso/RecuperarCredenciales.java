package bo.com.bga.certificacion.gananet.tasks.acceso;

import bo.com.bga.certificacion.gananet.models.acceso.DatosIngresoAcceso;
import bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;

import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.IFRAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class RecuperarCredenciales implements Task {
    DatosIngresoAcceso datosIngresoAcceso;

    public RecuperarCredenciales(DatosIngresoAcceso datosDeUsuario) {
        this.datosIngresoAcceso = datosDeUsuario;
    }
    @Title("Recupera credenciales")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(IFRAME.resolveFor(actor)),
                WaitUntil.the(InicioSesionPage.BUTTON_OLVIDE_USUARIO, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                JavaScriptClick.on(InicioSesionPage.BUTTON_OLVIDE_USUARIO),
                Enter.theValue(datosIngresoAcceso.getEmail()).into(InicioSesionPage.EMAIL),
                Enter.theValue(datosIngresoAcceso.getGanapin()).into(InicioSesionPage.GANAPIN),
                JavaScriptClick.on(InicioSesionPage.BUTTON_ENVIAR)
        );
    }
    public static RecuperarCredenciales credentials(DatosIngresoAcceso datosDeUsuario){
        return Tasks.instrumented(RecuperarCredenciales.class,datosDeUsuario);
    }
}
