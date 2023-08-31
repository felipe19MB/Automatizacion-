package bo.com.bga.certificacion.api.questions.transferencia;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarMovimientos implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String codigoOrden = theActorInTheSpotlight().recall("codigoOrden");
        String fecha = theActorInTheSpotlight().recall("fechaTransaccion");
        String cuenta = theActorInTheSpotlight().recall("nroCuentaDes");
        String entidad = theActorInTheSpotlight().recall("entidadDes");
        String importe = theActorInTheSpotlight().recall("importe");
        boolean resultado = false;
        LocalDateTime originalDateTime = LocalDateTime.parse(fecha.replace("\"", ""), DateTimeFormatter.ISO_DATE_TIME);
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String newDateString = originalDateTime.format(newDateTimeFormatter);
        if (codigoOrden != null){
            String query = "SELECT * FROM ACH_ORDENES WHERE FECHA_TRANSACCION = TO_DATE ('"+newDateString+"', 'MM/DD/YYYY') AND NRO_CUENTA_DES='"+cuenta.replace("\"", "")+"' AND ENTIDAD_DES="+entidad.replace("\"", "")+" AND IMPORTE = "+importe.replace("\"", "")+"";
            theActorInTheSpotlight().attemptsTo(
                    EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query, "resultado" ,"GANANET")
            );
            List<Map<String, Object>> result = theActorInTheSpotlight().recall("resultado");
            resultado = result.size() != 0;
            if (!resultado){
                throw new AssertionError("No se encontraron datos de consulta\n" +
                        "N° de orden: " + codigoOrden);
            }
        }
        return resultado;
    }

    public static VerificarMovimientos verificar(){
        return new VerificarMovimientos();
    }
}
