package bo.com.bga.certificacion.ganamovil.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Title;

public class ElementoVisible implements Question<Boolean> {

    private Target target;

    public ElementoVisible(Target target){
        this.target = target;
    }

    @Title("Válido la existencia de QR generado")
    @Override
    public Boolean answeredBy(Actor actor) {

        boolean resultado;

        resultado = Visibility.of(target).answeredBy(actor).booleanValue();

        if (!resultado) {
            throw new AssertionError("El elemento no se encuentra, no es visible.");
        }

        return resultado;
    }

    public static ElementoVisible validar(Target target){
        return new ElementoVisible(target);
    }
}
