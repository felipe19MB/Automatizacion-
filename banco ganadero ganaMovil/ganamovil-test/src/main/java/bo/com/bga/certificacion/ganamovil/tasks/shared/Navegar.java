package bo.com.bga.certificacion.ganamovil.tasks.shared;

import bo.com.bga.certificacion.ganamovil.userinterfaces.shared.UiMenu;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import java.util.List;

import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class Navegar implements Task {

    private List<String> menu;

    public Navegar(List<String> menu) {
        this.menu = menu;
    }

    @Title("Se navega por el menú")
    @Override
    public <T extends Actor> void performAs(T actor) {
        int contador = 0;
        for (String item : menu) {
            contador++;
            actor.attemptsTo(
                    Check.whether(isiOS(actor))
                            .andIfSo(
                                    WaitUntil.the(UiMenu.BTN_MENU_IOS.of(item), WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                                    Tap.on(UiMenu.BTN_MENU_IOS.of(item))
                            )
                            .otherwise(
                                    WaitUntil.the(UiMenu.BTN_MENU_ANDROID.of(item), WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                                    Tap.on(UiMenu.BTN_MENU_ANDROID.of(item))
                            )
            );
        }
    }

    public static Navegar menu(List<String> menu) {
        return Tasks.instrumented(Navegar.class, menu);
    }
}
