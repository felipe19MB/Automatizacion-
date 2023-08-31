package bo.com.bga.certificacion.ganamovil.interactions.utils.scroll;

import bo.com.bga.certificacion.ganamovil.exceptions.ObjetosException;
import bo.com.bga.certificacion.ganamovil.utils.utils.enums.ConfiguracionInteracciones;
import bo.com.bga.certificacion.ganamovil.utils.utils.swipe.Swipe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.WebElement;

public class ScrollElement implements Interaction {
    private final WebElement element;
    private int cant = 0;

    public ScrollElement(WebElement element) {
        this.element = element;
    }

    public <T extends Actor> void performAs(T actor) {
        while(true) {
            if (!this.element.isDisplayed() && this.cant <= ConfiguracionInteracciones.CANTIDAD_INTERACCIONES.getOpcionInt()) {
                actor.attemptsTo(new Performable[]{Swipe.as(actor).fromBottom().toTop()});
                ++this.cant;
                if (this.cant != ConfiguracionInteracciones.CANTIDAD_INTERACCIONES.getOpcionInt()) {
                    continue;
                }

                String var10002 = ObjetosException.errorBuscandoObjeto();
                throw new ObjetosException(var10002 + this.element);
            }

            return;
        }
    }
}
