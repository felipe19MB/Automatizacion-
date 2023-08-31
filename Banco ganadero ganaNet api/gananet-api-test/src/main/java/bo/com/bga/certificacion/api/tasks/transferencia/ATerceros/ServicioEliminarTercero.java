package bo.com.bga.certificacion.api.tasks.transferencia.ATerceros;

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


public class ServicioEliminarTercero implements Task {

    private EnvironmentVariables environmentVariables;
    private String jsonBody;

    public ServicioEliminarTercero(String jsonBody){
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(jsonBody);
        ObjectMapper mapper = new ObjectMapper();
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_ELIMINARCUENTATERFAV)
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
            }else {
                int httpStatusCode = SerenityRest.lastResponse().path("httpStatusCode");
                if (httpStatusCode == HttpStatus.SC_OK){
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode jsonNode = objectMapper.readTree(SerenityRest.lastResponse().asString());
                    String intCodError = jsonNode.get("EliminarCuentaTerFavResponse").get(0).get("intCodError").asText();
                    if (intCodError != "1"){
                        String strMensaje = jsonNode.get("EliminarCuentaTerFavResponse").get(6).get("strMensaje").asText();
                        actor.remember("strMensaje", strMensaje);
                        actor.remember("TransaccionStatusCode", httpStatusCode);
                    }else {
                        throw new AssertionError("No se eliminó la cuenta correctamente.");
                    }
                }
            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_SERVICIOTRANSACCIONOTROSBANCOS), ex);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static ServicioEliminarTercero service(String jsonBody){
        return Tasks.instrumented(ServicioEliminarTercero.class, jsonBody);
    }
}
