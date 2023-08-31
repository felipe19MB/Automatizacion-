package bo.com.bga.certificacion.gananet.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import java.util.Map;

public class ValidacionBaseDeDatosInterfaz implements Question<Boolean> {
    public String consultaBD;
    public Target target;
    public String key;

    public ValidacionBaseDeDatosInterfaz(Target target,String consultaBD, String key) {
        this.consultaBD = consultaBD;
        this.target = target;
        this.key = key;
    }

    public Boolean answeredBy(Actor actor) {
        Map<String, Object> recall = actor.recall(key);
        if (recall == null) {
            throw new AssertionError("El registro no se almacenó en base de datos");
        }
        String consulta =  recall.get(consultaBD).toString();
        System.out.println(consulta);
        String consultaInterfase = Text.of(target.of(consulta)).answeredBy(actor);
        System.out.println(consultaInterfase);
        boolean resultado =consulta.equalsIgnoreCase(consultaInterfase);
        
        if (!resultado) {
            throw new AssertionError("Ocurrió un error validando en base de dato:s el mensaje recibido no coincide con el esperado.\n" +
                    "Mensaje esperado: " + String.valueOf(target.of(consulta)) + "\n" +
                    "Mensaje recibido: " + consulta);
        }
        return resultado;
    }
    public static ValidacionBaseDeDatosInterfaz esCorrecta(Target target, String consultaBD, String key){
        return new ValidacionBaseDeDatosInterfaz(target,consultaBD,key);
    }
}

