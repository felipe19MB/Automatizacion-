package bo.com.bga.certificacion.api.tasks.transferencia.movimientos;

import bo.com.bga.certificacion.api.exceptions.AssertionsServices;
import bo.com.bga.certificacion.api.exceptions.ErrorServicesException;
import bo.com.bga.certificacion.api.utils.constants.Constantes;
import bo.com.bga.certificacion.api.utils.constants.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;

public class MovimientosTransaccionales implements Task {

    private EnvironmentVariables environmentVariables;

    private String jsonBody;

    public MovimientosTransaccionales(String jsonBody){
        this.jsonBody = jsonBody;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MTDLISTARACHENVIADAS1)
                            .with(
                                    resource -> resource.header(
                                                    "Authorization", environmentVariables.optionalProperty("KEY").get()
                                            ).contentType(JSON)
                                            .body(jsonBody)
                                            .relaxedHTTPSValidation()
                            )
            );

            if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
                throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
            }else{
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree((String) SerenityRest.lastResponse().path("mtdListarAchEnviadas1Result"));
                actor.remember("nroCuentaDes", jsonNode.get("pResultado").get(0).get("NRO_CUENTA_DES").toString());
                actor.remember("fechaTransaccion", jsonNode.get("pResultado").get(0).get("FECHA_TRANSACCION").toString());
                actor.remember("entidadDes", jsonNode.get("pResultado").get(0).get("ENTIDAD_DES").toString());
                actor.remember("importe", jsonNode.get("pResultado").get(0).get("IMPORTE").toString());
                actor.remember("codigoOrden", jsonNode.get("pResultado").get(0).get("CODIGO_ORDEN").toString());
            }



        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.TASK_MOVIMIENTOS), ex);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static MovimientosTransaccionales movimientos(String jsonBody){
        return Tasks.instrumented(MovimientosTransaccionales.class, jsonBody);
    }
}
