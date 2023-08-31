package bo.com.bga.certificacion.api.questions.compartida;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarCodigo implements Question<Boolean> {

    private final int estado;
    private final String key;

    public VerificarCodigo(int estado, String key){
        this.estado = estado;
        this.key = key;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado;
        int codigoResponce = actor.recall(key);
        resultado = codigoResponce == estado;
        if (!resultado) {
            throw new AssertionError("El estado recibido no coincide con el esperado.\n" +
                    "Mensaje esperado: " + estado + "\n" +
                    "Mensaje recibido: " + codigoResponce);
        }
        return resultado;
    }

    public static VerificarCodigo esperado(int estado, String key){
        return new VerificarCodigo(estado, key);
    }
}
