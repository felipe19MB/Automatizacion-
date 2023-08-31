package bo.com.bga.certificacion.api.questions.compartida;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class VerificarCampos implements Question<Boolean> {

    private List<String> feature;
    private List<String> response;

    public VerificarCampos(List<String> feature, List<String> response){
        this.feature = feature;
        this.response = response;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado = false;

        if (feature.size() != response.size()) {
            resultado = false;
            throw new AssertionError("No se obtuvo datos de la respuesta");
        }
        for (int i = 0; i < feature.size(); i++) {
            if (!feature.get(i).equals(response.get(i))) {
                resultado = false;
                throw new AssertionError("Los datos no son iguales a los proporcionados");
            }
        }
        resultado = true;
        return resultado;
    }

    public static VerificarCampos items(List<String> feature, List<String> response){
        return new VerificarCampos(feature, response);
    }
}
