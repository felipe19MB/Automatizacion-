package bo.com.bga.certificacion.gananet.questions.pago_planillas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Collection;

public class ValidacionHistoricoPagos implements Question<Boolean> {
    private Collection<String> parametrosData;
    private Target target;

    public ValidacionHistoricoPagos(Collection<String> parametrosData, Target target) {
        this.parametrosData = parametrosData;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Collection<String> parametros = actor.asksFor(Text.ofEach(target));
        System.out.println(parametros);
        return parametros.equals(parametrosData);
    }
    public static ValidacionHistoricoPagos go(Collection<String> parametrosData, Target target){return new ValidacionHistoricoPagos(parametrosData, target);}
}
