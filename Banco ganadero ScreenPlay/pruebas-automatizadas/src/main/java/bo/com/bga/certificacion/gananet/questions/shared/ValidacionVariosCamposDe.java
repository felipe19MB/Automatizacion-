package bo.com.bga.certificacion.gananet.questions.shared;

import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.models.transferencias.DatosHistoricos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Collection;


public class ValidacionVariosCamposDe implements Question<Boolean> {
    private Collection<String> parametrosData;
    private Target target;

    private String numeroTransaccion;


    public ValidacionVariosCamposDe(Collection<String> parametrosData, Target target, String numeroTransaccion) {
        this.parametrosData = parametrosData;
        this.target = target;
        this.numeroTransaccion = numeroTransaccion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Collection<String> parametros = actor.asksFor(Text.ofEach(target.of(numeroTransaccion)));
        System.out.println(parametros);
        return parametros.equals(parametrosData);

    }
    public static ValidacionVariosCamposDe go(Collection<String> parametrosData, Target target,String numeroTransaccion){return new ValidacionVariosCamposDe(parametrosData,target,numeroTransaccion);}


}
