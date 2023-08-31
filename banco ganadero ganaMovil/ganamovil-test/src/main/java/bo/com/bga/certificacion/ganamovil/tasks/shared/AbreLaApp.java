package bo.com.bga.certificacion.ganamovil.tasks.shared;

import bo.com.bga.certificacion.ganamovil.interactions.utils.TakeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class AbreLaApp implements Task {

    public AbreLaApp() {
    }

    public static AbreLaApp exitosamente() {
        return Tasks.instrumented(AbreLaApp.class);
    }

    @Override
    @Step("App abierta")
    public <T extends Actor> void performAs(T actor) {
        Logger.getAnonymousLogger().info("Se abre la app GanaMóvil");
        actor.attemptsTo(TakeScreenshot.asEvidence());
    }
}
