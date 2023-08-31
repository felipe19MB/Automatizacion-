package bo.com.bga.certificacion.ganamovil.questions.transferencia;

import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarTransferencia implements Question<Boolean> {

    private String tipo;
    private Target target;

    public ValidarTransferencia(String tipo, Target target){
        this.tipo = tipo;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean resultado;
        String numero = Text.of(target).answeredBy(actor).toString();
        numero = numero.replace("Nro. ", "");
        switch (tipo){
            case "MovimientoContable":
                String movimientos = "SELECT * FROM MOVIMIENTOS_CONTABLES WHERE ASIENTO="+numero+" AND FECHAPROCESO=TRUNC(SYSDATE)";
                theActorInTheSpotlight().attemptsTo(
                        EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(movimientos, "transacción" ,"GANADERO")
                );
                Logger.getAnonymousLogger().info("Busqueda finalizada en la base de datos tabla Movimientos_Contables");
                break;
            case "ACH":
                String ach = "SELECT * FROM ACH_ORDENES WHERE CODIGORDEN = "+numero+"";
                theActorInTheSpotlight().attemptsTo(
                        EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(ach, "transacción" ,"GANADERO")
                );
                Logger.getAnonymousLogger().info("Busqueda finalizada en la base de datos tabla ACH_Ordenes");
                break;
            default:
                break;
        }

        List<Map<String, Object>> result = theActorInTheSpotlight().recall("transacción");
        resultado = result.size() != 0;
        if (!resultado) {
            throw new AssertionError("No se encontraron datos de la transacción en la base de datos.\n" +
                    "N° de transacción: " + numero + "\n" +
                    "Resultado de la busqueda: " + result.size());
        }
        return resultado;
    }

    public static ValidarTransferencia validarMovimientoInterno(Target target){
        return new ValidarTransferencia( "MovimientoContable", target);
    }
    public static ValidarTransferencia validarACH(Target target){
        return new ValidarTransferencia("ACH", target);
    }

}
