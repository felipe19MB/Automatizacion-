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

public class RecuperarCredencialesPassword implements Task {
    DatosIngresoAcceso datosIngresoAcceso;

    public RecuperarCredencialesPassword(DatosIngresoAcceso datosDeUsuario) {
        this.datosIngresoAcceso = datosDeUsuario;
    }
    @Title("Recupera credenciales - Contraseña")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(IFRAME.resolveFor(actor)),
                WaitUntil.the(InicioSesionPage.USUARIO, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                Enter.theValue(datosIngresoAcceso.getUsuario()).into(InicioSesionPage.USUARIO),
                JavaScriptClick.on(InicioSesionPage.BUTTON_INGRESAR),
                WaitUntil.the(InicioSesionPage.BUTTON_OLVIDE_CONTRASENA, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                JavaScriptClick.on(InicioSesionPage.BUTTON_OLVIDE_CONTRASENA),
                Enter.theValue(datosIngresoAcceso.getGanapin()).into(InicioSesionPage.GANAPIN_CONTRASEÑA),
                JavaScriptClick.on(InicioSesionPage.BUTTON_ENVIAR_PASSWORD),
                WaitUntil.the(InicioSesionPage.MODAL_CONFIRMACION, isCurrentlyVisible()).forNoMoreThan(35).seconds()
        );
    }
    public static RecuperarCredencialesPassword credentials(DatosIngresoAcceso datosDeUsuario){
        return Tasks.instrumented(RecuperarCredencialesPassword.class,datosDeUsuario);
    }
}
