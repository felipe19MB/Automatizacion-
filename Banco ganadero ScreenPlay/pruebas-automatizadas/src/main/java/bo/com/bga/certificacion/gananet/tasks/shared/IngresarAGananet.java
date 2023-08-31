package bo.com.bga.certificacion.gananet.tasks.shared;

import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.models.shared.DatosIngreso;
import bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.IFRAME;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class IngresarAGananet implements Task {
    DatosIngreso datosDeUsuario;


    public IngresarAGananet(DatosIngreso datosDeUsuario) {
        this.datosDeUsuario = datosDeUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(IFRAME.resolveFor(actor)),
                WaitUntil.the(InicioSesionPage.USUARIO, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                Enter.theValue(datosDeUsuario.getUsuario()).into(InicioSesionPage.USUARIO),
                JavaScriptClick.on(InicioSesionPage.BUTTON_INGRESAR),
                WaitUntil.the(InicioSesionPage.BUTTON_INGRESAR, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                Enter.theValue(datosDeUsuario.getContrasena()).into(InicioSesionPage.PASSWORD),
                Enter.theValue(datosDeUsuario.getNuevaClave()).into(InicioSesionPage.PASSWORD),
                JavaScriptClick.on(InicioSesionPage.BUTTON_INGRESAR)
        );
    }

    public static IngresarAGananet withCredentials(DatosIngreso datosDeUsuario){
        return Tasks.instrumented(IngresarAGananet.class,datosDeUsuario);

    }

}
