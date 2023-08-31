package bo.com.bga.certificacion.gananet.tasks.acceso;

import bo.com.bga.certificacion.gananet.userinterfaces.ActualizacionClavePage;
import bo.com.bga.certificacion.gananet.models.acceso.DatosActualizacionClave;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CambiarClaves implements Task {
    DatosActualizacionClave datosDeUsuario;

    public CambiarClaves(DatosActualizacionClave datosDeUsuario) {
        this.datosDeUsuario = datosDeUsuario;
    }
    @Title("Cambia claves")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ActualizacionClavePage.TXT_CLAVE_ACTUAL,isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                Enter.theValue(datosDeUsuario.getContrasena()).into(ActualizacionClavePage.TXT_CLAVE_ACTUAL),
                Enter.theValue(datosDeUsuario.getNuevaClave()).into(ActualizacionClavePage.TXT_NUEVA_CLAVE),
                Enter.theValue(datosDeUsuario.getNuevaClave()).into(ActualizacionClavePage.TXT_CONFIRMAR_CLAVE),
                JavaScriptClick.on(ActualizacionClavePage.BUTON_CONTINUAR),
                JavaScriptClick.on(ActualizacionClavePage.BOTON_OK),
                WaitUntil.the(ActualizacionClavePage.TXT_CLAVE_ACTUAL,isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                Enter.theValue(datosDeUsuario.getContrasena()).into(ActualizacionClavePage.TXT_CLAVE_ACTUAL),
                Enter.theValue(datosDeUsuario.getNuevaClaveTransaccional()).into(ActualizacionClavePage.TXT_NUEVA_CLAVE),
                Enter.theValue(datosDeUsuario.getNuevaClaveTransaccional()).into(ActualizacionClavePage.TXT_CONFIRMAR_CLAVE),
                JavaScriptClick.on(ActualizacionClavePage.BUTON_CONTINUAR),
                JavaScriptClick.on(ActualizacionClavePage.BOTON_OK)
        );
        WebDriver driver= getDriver();
        driver.navigate().refresh();
    }
    public static CambiarClaves go(DatosActualizacionClave datosDeUsuario){
        return Tasks.instrumented(CambiarClaves.class,datosDeUsuario);

    }
}
