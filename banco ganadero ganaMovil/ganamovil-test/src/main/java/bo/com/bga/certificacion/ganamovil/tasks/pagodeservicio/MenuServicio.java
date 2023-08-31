package bo.com.bga.certificacion.ganamovil.tasks.pagodeservicio;

import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import java.util.List;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.pagodeservicio.UiAfiliar.*;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class MenuServicio implements Task {

    private List<String> menu;
    private String item;

    public MenuServicio(List<String> menu, String item){
        this.menu = menu;
        this.item = item;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(isiOS(actor))
                        .andIfSo(Tap.on(BTN_AFILIAR_IOS.of(item)))
                                .otherwise(Tap.on(BTN_AFILIAR.of(item)))

        );
        for (String item : menu) {
            actor.attemptsTo(
                    Check.whether(isiOS(actor))
                            .andIfSo(Tap.on(BTN_MENU_IOS.of(item)))
                                    .otherwise(Tap.on(BTN_MENU.of(item)))
            );
        }
    }

    public static MenuServicio menu(List<String> menu, String item){
        return Tasks.instrumented(MenuServicio.class, menu, item);
    }
}
