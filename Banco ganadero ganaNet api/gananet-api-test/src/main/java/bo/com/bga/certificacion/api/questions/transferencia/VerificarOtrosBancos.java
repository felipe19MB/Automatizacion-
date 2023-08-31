package bo.com.bga.certificacion.api.questions.transferencia;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarOtrosBancos implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String codigoOrden = theActorInTheSpotlight().recall("intCodigoOrden");
        boolean resultado = false;

        if (codigoOrden != null){
            String query = "SELECT * FROM VTA_RESERVAS WHERE  TIPO_RESERVA = 4 AND \n" +
                    "FECHA_ALTA = TRUNC(SYSDATE) AND USUARIO_ALTA = 'CORE55' AND SALDO_JTS_OID="+theActorInTheSpotlight().recall("idOrigen")+" AND ESTADO=1";
            theActorInTheSpotlight().attemptsTo(
                    EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query, "datos" ,"GANADERO")
            );
            List<Map<String, Object>> result = theActorInTheSpotlight().recall("datos");
            resultado = result.size() != 0;
            if (!resultado){
                throw new AssertionError("No se encontraron datos de la transacción en la base de datos.\n" +
                        "N° de orden: " + codigoOrden);
            }
        }
        return resultado;
    }

    public static VerificarOtrosBancos verificar(){
        return new VerificarOtrosBancos();
    }
}
