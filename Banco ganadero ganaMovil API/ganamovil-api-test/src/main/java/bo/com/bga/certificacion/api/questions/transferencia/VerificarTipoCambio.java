package bo.com.bga.certificacion.api.questions.transferencia;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarTipoCambio implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean response = false;
        Map<String, Object> condiciones = new HashMap<>();
        condiciones.put("ASIENTO", theActorInTheSpotlight().recall("strAsiento"));
        actor.attemptsTo(
                EjecutarBaseDeDatos.ObtenerPorId("MOVIMIENTOS_CONTABLES", condiciones, "GANADERO")
        );
        Map<String, Object> recall = theActorInTheSpotlight().recall("resultadosObtenidos");
        if (recall != null && !recall.isEmpty()){
            Double tipoCambio = Double.parseDouble(theActorInTheSpotlight().recall("strTipoCambioDeb"));
            Double strMontoEquivDeb = Double.parseDouble(theActorInTheSpotlight().recall("strMontoEquivDeb"));
            Double importeDebitado = Double.parseDouble(theActorInTheSpotlight().recall("strImporteDeb"));
            Double Saldo = Double.parseDouble(theActorInTheSpotlight().recall("strImporteCred"));
            double importe = strMontoEquivDeb * tipoCambio;
            double redondeado = Math.floor(importe * 10) / 10;
            response = redondeado == Saldo;

        }else {
            response = recall != null && !recall.isEmpty();
        }
        return response;
    }

    public static VerificarTipoCambio verificar(){
        return new VerificarTipoCambio();
    }
}
