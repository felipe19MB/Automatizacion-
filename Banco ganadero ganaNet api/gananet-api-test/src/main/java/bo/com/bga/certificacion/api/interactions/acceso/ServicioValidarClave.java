package bo.com.bga.certificacion.api.interactions.acceso;

import bo.com.bga.certificacion.api.exceptions.AssertionsServices;
import bo.com.bga.certificacion.api.exceptions.ErrorServicesException;
import bo.com.bga.certificacion.api.utils.constants.Constantes;
import bo.com.bga.certificacion.api.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import static io.restassured.http.ContentType.JSON;

public class ServicioValidarClave implements Interaction {
    private EnvironmentVariables environmentVariables;

    private final String data;

    public ServicioValidarClave(String data){
        this.data = data;
    }

    @Title("Ejecuta el servicio, validar clave")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MTDOBTENERSESION9)
                            .with(
                                    resource ->
                                       resource.header(
                                                            "Authorization", environmentVariables.optionalProperty("KEY").get()
                                                    ).contentType(JSON)
                                                    .body(data)
                                                    .relaxedHTTPSValidation()
                            )
            );
            if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
                throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
            }else {
                String response = SerenityRest.lastResponse().path("mensaje");
                actor.remember("ValidarClaveStrMensaje", response);
                String sesion = SerenityRest.lastResponse().path("datos[0].SESION");
                actor.remember("sesionPagina", sesion);
                System.out.println(sesion);

            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_EJECUTARVALIDARCLAVE), ex);
        }
    }

    public static ServicioValidarClave service(String data){
        return Instrumented.instanceOf(ServicioValidarClave.class).withProperties(data);
    }
}
