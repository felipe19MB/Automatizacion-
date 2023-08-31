package bo.com.bga.certificacion.api.questions.qr;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarCobro implements Question<Boolean> {
    private String pStrCodigoPersona;

    public VerificarCobro(String pStrCodigoPersona){
        this.pStrCodigoPersona = pStrCodigoPersona;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado = false;
        String query = "SELECT * FROM CAS_QR_MAESTRO WHERE ID_QR IN ( '"+actor.recall("idqr")+"')";
        theActorInTheSpotlight().attemptsTo(EjecutarBaseDeDatos.QueryObtenerTodoPersonalizado(query,"QR_MAESTRO", "GANADERO"));
        List<Map<String, Object>> result = theActorInTheSpotlight().recall("QR_MAESTRO");
        String codigoPersona = result.get(0).get("CODIGO_PERSONA").toString();
        String nroIdentificacion = result.get(0).get("NRO_IDENTIFICACION").toString();
        resultado = nroIdentificacion.equals(actor.recall("pStrCodigoPersona")) && codigoPersona.equals(pStrCodigoPersona);
        if (!resultado){
            throw new AssertionError("No se encontraron datos en la base de datos.\n" +
                    "N° ID_QR: " + actor.recall("idqr"));
        }
        return resultado;
    }

    public static VerificarCobro cobroQR(String pStrCodigoPersona){
        return new VerificarCobro(pStrCodigoPersona);
    }
}
