package bo.com.bga.certificacion.ganamovil.questions.qr;

import bo.com.bga.certificacion.ganamovil.tasks.shared.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarHistorico implements Question<Boolean> {

    private String cuentaOrigen;

    public VerificarHistorico(String cuentaOrigen){
        this.cuentaOrigen = cuentaOrigen;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean resultado;
        String usuario = theActorInTheSpotlight().recall("usuario");
        String query = "SELECT NRO_CUENTA, MONTO, REFERENCIA, FECHA_VCTO FROM (SELECT NRO_CUENTA, MONTO, REFERENCIA, FECHA_VCTO, ROW_NUMBER() OVER (ORDER BY FECHA_REGISTRO DESC, HORA_REGISTRO DESC) AS rn FROM GANADERO.CAS_QR_MAESTRO WHERE NRO_CUENTA = '"+cuentaOrigen+"' AND CODIGO_PERSONA = '"+usuario+"' AND ESTADO = '2') subquery WHERE rn = 1;";
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query, "historico" ,"GANADERO")
        );
        List<Map<String, Object>> result = theActorInTheSpotlight().recall("historico");

        resultado = result.size() != 0;
        if (!resultado) {
            throw new AssertionError("No se encontraron datos de la transacción en la base de datos.\n" +
                    "Resultado de la busqueda: " + result.size());
        }
        return resultado;
    }

    public static VerificarHistorico verificar(String cuentaOrigen){
        return new VerificarHistorico(cuentaOrigen);
    }
}
