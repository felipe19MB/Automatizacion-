package bo.com.bga.certificacion.gananet.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class ValidacionString implements Question<Boolean> {
    public String mensaje;
    public String key;

    public ValidacionString(String mensaje, String key) {
        this.mensaje = mensaje;
        this.key = key;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String comparacion = actor.recall(key);
        System.out.println("El mensaje esperado es: "+mensaje);
        System.out.println("El mensaje recibido es: "+comparacion);
        boolean resultado = comparacion.equalsIgnoreCase(mensaje);
        if (!resultado) {
            throw new AssertionError("El mensaje recibido no coincide con el esperado.\n" +
                    "Mensaje esperado: " + mensaje + "\n" +
                    "Mensaje recibido: " + comparacion);
        }
        return resultado;
    }
    public static ValidacionString esCorrecta(String mensaje ,String key){
        return new ValidacionString(mensaje,key);
    }
}

