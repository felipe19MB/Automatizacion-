package bo.com.bga.certificacion.gananet.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarTarget implements Question<Boolean> {
    private String mensaje;
    private Target target;

    public ValidarTarget(String mensaje, Target target) {
        this.mensaje = mensaje;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println("mensaje:"+mensaje);
        String comparacion=actor.asksFor((Text.of(target)));
        System.out.println("target:"+comparacion);
        return
               mensaje.equalsIgnoreCase(comparacion);

    }

    public static ValidarTarget go(String mensaje, Target target) {
        return new ValidarTarget(mensaje, target);
    }
}
