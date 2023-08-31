package bo.com.bga.certificacion.ganamovil.questions.shared;

import bo.com.bga.certificacion.ganamovil.interactions.utils.EsperaExplicita;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
public class ValidarTextos implements Question<Boolean> {

    private Target target;
    private String text;

    public ValidarTextos(Target target, String text){
        this.target = target;
        this.text = text;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado;
        EsperaExplicita.empleada(1000);
        WaitUntil.the(target, WebElementStateMatchers.isVisible()).forNoMoreThan(260).seconds();
        String texto = Text.of(target).answeredBy(actor).toString();
        resultado = texto.contains(text);
        if (!resultado) {
            throw new AssertionError("El mensaje recibido no coincide con el esperado.\n" +
                    "Mensaje esperado: " + text + "\n" +
                    "Mensaje recibido: " + texto);
        }
        return resultado;
    }

    public static ValidarTextos textosDelFrontEnd(Target target, String text){
        return new ValidarTextos(target, text);
    }
}
