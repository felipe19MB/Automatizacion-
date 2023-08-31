package bo.com.bga.certificacion.gananet.questions.shared;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosHistoricos;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ACHyChequesPage;
import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.Collection;



public class ValidacionVariosCampos implements Question<Boolean> {
    private Collection<String> parametrosData;
    private Target target;



    public ValidacionVariosCampos(Collection<String> parametrosData, Target target) {
        this.parametrosData = parametrosData;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Espera.aTime(4000);
        Collection<String> parametros = actor.asksFor(Text.ofEach(target));
        System.out.println(parametros);
        return parametros.equals(parametrosData);
    }
    public static ValidacionVariosCampos go(Collection<String> parametrosData,Target target){return new ValidacionVariosCampos(parametrosData,target);}


}
