package bo.com.bga.certificacion.gananet.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.targets.Target;

public class VerificarConfirmaciones implements Question<Boolean> {
    private String mensaje;
    private Target target;

    public VerificarConfirmaciones(String mensaje, Target target) {
        this.mensaje = mensaje;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String print=Text.of(target).answeredBy(actor);
        System.out.println(print);
       boolean resultado = mensaje.equalsIgnoreCase(Text.of(target).answeredBy(actor));
        if (!resultado) {
            throw new AssertionError("El mensaje recibido no coincide con el esperado.\n" +
                    "Mensaje esperado: " + mensaje + "\n" +
                    "Mensaje recibido: " + Text.of(target).answeredBy(actor));
        }
        return resultado;

    }

    public static VerificarConfirmaciones go(String mensaje, Target target) {
        return new VerificarConfirmaciones(mensaje, target);
    }
}
