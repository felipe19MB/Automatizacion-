package bo.com.bga.certificacion.ganamovil.questions.home;

import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import bo.com.bga.certificacion.ganamovil.userinterfaces.acceso.UiIniciarSesion;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarSaldo implements Question<Boolean> {
    private String saldo;

    public ValidarSaldo(String saldo){
        this.saldo = saldo;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado;
        String saldo = Text.of(UiIniciarSesion.LBL_SALDO_CUENTA).answeredBy(actor).toString();
        String cuenta = Text.of(UiIniciarSesion.LBL_NUMERO_CUENTA).answeredBy(actor).toString();
        String query = "SELECT C1604 FROM SALDOS WHERE CUENTA = "+cuenta+"";
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query, "saldo" ,"GANADERO")
        );
        List<Map<String, Object>> result = theActorInTheSpotlight().recall("saldo");
        String saldodb = result.get(0).get("C1604").toString();
        saldo = saldo.replace(",", "");
        saldo = saldo.replaceAll("\\.0*$", "");
        resultado = saldodb.equals(saldo);
        if (!resultado) {
            throw new AssertionError("El mensaje recibido no coincide con el esperado.\n" +
                    "Saldo esperado: " + saldo + "\n" +
                    "Saldo recibido: " + saldo);
        }
        return resultado;
    }
    public static ValidarSaldo enBaseDeDatos(String saldo){
        return new ValidarSaldo(saldo);
    }
}
