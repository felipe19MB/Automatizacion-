package bo.com.bga.certificacion.api.interactions.qr;

import bo.com.bga.certificacion.api.exceptions.AssertionsServices;
import bo.com.bga.certificacion.api.exceptions.ErrorServicesException;
import bo.com.bga.certificacion.api.utils.constants.Constantes;
import bo.com.bga.certificacion.api.utils.constants.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;

public class OrdenDeCobro implements Interaction {

    private EnvironmentVariables environmentVariables;

    private String jsonBody;

    public OrdenDeCobro(String jsonBody){
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MTDSERVREGISTRARCOBROQR)
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
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(SerenityRest.lastResponse().asString());
                String strMensaje = jsonNode.get("mtdServRegistrarCobroQrResponse").get(1).get("strMensaje").asText();
                String[] partes = strMensaje.split("\\|");
                actor.remember("pStrCodigoPersona", partes[0]);
                actor.remember("idqr", partes[1]);
                actor.remember("pStrFechaVcto", partes[3]);
            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_SERVICIOORDENDECOBRO), ex);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static OrdenDeCobro servicio(String jsonBody){
        return Instrumented.instanceOf(OrdenDeCobro.class).withProperties(jsonBody);
    }
}
