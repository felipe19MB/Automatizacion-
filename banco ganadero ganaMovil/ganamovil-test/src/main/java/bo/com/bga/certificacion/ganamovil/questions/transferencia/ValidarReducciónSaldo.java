package bo.com.bga.certificacion.ganamovil.questions.transferencia;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarReducciónSaldo implements Question<Boolean> {

    private int devitado;

    public ValidarReducciónSaldo(int devitado){
        this.devitado = devitado;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado;
        List<Map<String, Object>> resultBefore = theActorInTheSpotlight().recall("saldoBefore");
        List<Map<String, Object>> resultAfter = theActorInTheSpotlight().recall("saldoAfter");
        String saldoBefore = resultBefore.get(0).get("C1604").toString();
        String saldoAfter = resultAfter.get(0).get("C1604").toString();
        int result = Integer.parseInt(saldoBefore)  - Integer.parseInt(saldoAfter);
        resultado = devitado == result;
        if (!resultado) {
            throw new AssertionError("Los saldos no son iguales.\n" +
                    "Saldo Before " + saldoBefore + "\n" +
                    "Saldo debitado " + devitado + "\n" +
                    "Saldo obtenido " + result + "\n" +
                    "Saldo After " + saldoAfter);
        }
        return resultado;
    }

    public static ValidarReducciónSaldo saldo(int devitado){
        return new ValidarReducciónSaldo(devitado);
    }
}
