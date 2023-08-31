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
import net.thucydides.core.annotations.Title;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import static io.restassured.http.ContentType.JSON;

public class ServicioTransferenciaEntreMisCuentas implements Interaction {

    private EnvironmentVariables environmentVariables;

    private String jsonBody;

    public ServicioTransferenciaEntreMisCuentas(String jsonBody){
        this.jsonBody = jsonBody;
    }

    @Title("Servicio de transferencia entre mis cuentas")
    @Override
    public <T extends Actor> void performAs(T actor) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MTDREALIZARTRANSFERENCIACUANTASTERCEROS)
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
                int codeResponse = SerenityRest.lastResponse().path("httpStatusCode");
                String strMensaje = SerenityRest.lastResponse().path("mensaje");
                actor.remember("TransaccionStatusCode", codeResponse);
                actor.remember("mensajeCuentaNoDisponible",strMensaje);


            }

        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_SERVICIOTRANSACCIONENTREMISCUENTAS), ex);
        }
    }

    public static ServicioTransferenciaEntreMisCuentas servicio(String jsonBody){
        return Instrumented.instanceOf(ServicioTransferenciaEntreMisCuentas.class).withProperties(jsonBody);
    }
}
