package bo.com.bga.certificacion.api.interactions.transferencia;

import bo.com.bga.certificacion.api.exceptions.AssertionsServices;
import bo.com.bga.certificacion.api.exceptions.ErrorServicesException;
import bo.com.bga.certificacion.api.utils.constants.Constantes;
import bo.com.bga.certificacion.api.utils.constants.Endpoints;
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

public class ServicioTransferenciaAOtrosBancos implements Interaction {

    private EnvironmentVariables environmentVariables;

    private String jsonBody;
    private String tipo;

    public ServicioTransferenciaAOtrosBancos(String jsonBody, String tipo){
        this.jsonBody = jsonBody;
        this.tipo = tipo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MTDREALIZARTRANSACCIONOTROSBANCOS2)
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
                String strMensaje;
                switch (tipo){
                    case "IMPORTEPÍGNORADO":
                        String intCodError = SerenityRest.lastResponse().path("mtdRealizarTransaccionOtrosBancosResponse[0].httpStatusCode");
                        strMensaje = SerenityRest.lastResponse().path("mtdRealizarTransaccionOtrosBancosResponse[0].strMensaje");
                        if (intCodError != "400"){
                            try {
                                JsonNode jsonNode = mapper.readTree(strMensaje);
                                actor.remember("intCodigoOrden", jsonNode.get("intCodigoOrden").asText());
                                System.out.println((String) actor.recall("intCodigoOrden"));
                            } catch (Exception e) {
                                throw new RuntimeException("Error al procesar la respuesta JSON", e);
                            }
                        }
                        break;
                    case "CUENTANOAFILIADA":
                        strMensaje = SerenityRest.lastResponse().path("mtdRealizarTransaccionOtrosBancosResponse[0].strMensaje");
                        actor.remember("strMensaje", strMensaje);
                        break;
                    default:
                        break;
                }

            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_SERVICIOTRANSACCIONOTROSBANCOS), ex);
        }
    }

    public static ServicioTransferenciaAOtrosBancos servicio(String jsonBody, String tipo){
        return Instrumented.instanceOf(ServicioTransferenciaAOtrosBancos.class).withProperties(jsonBody, tipo );
    }
}
