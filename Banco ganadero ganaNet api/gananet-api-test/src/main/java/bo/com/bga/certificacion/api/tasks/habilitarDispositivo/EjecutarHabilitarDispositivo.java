package bo.com.bga.certificacion.api.tasks.habilitarDispositivo;

import bo.com.bga.certificacion.api.exceptions.AssertionsServices;
import bo.com.bga.certificacion.api.exceptions.ErrorServicesException;
import bo.com.bga.certificacion.api.utils.constants.Constantes;
import bo.com.bga.certificacion.api.utils.constants.Endpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;

public class EjecutarHabilitarDispositivo implements Task {

    private EnvironmentVariables environmentVariables;
    private String data;

    public EjecutarHabilitarDispositivo(String data){
        this.data = data;
    }

    @Title("Ejecuta la habilitación del dispositivo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MTDINICIARSOLICITUDENROLAMIENTO)
                            .with(
                                    resource -> resource.header(
                                                    "Authorization", environmentVariables.optionalProperty("KEY").get()
                                            ).contentType(JSON)
                                            .body(data)
                                            .relaxedHTTPSValidation()
                            )

            );
            if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
                throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
            }else {
                String response = SerenityRest.lastResponse().path("mtdIniciarSolicitudEnrolamientoResponse[0].strMensaje");
                actor.remember("IniciarSolicitudEnrolamientostrMensaje", response);
            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_SERVICIOHABILITARDISPOSITIVO), ex);
        }
    }

    public static EjecutarHabilitarDispositivo habilitar(String data){
        return Tasks.instrumented(EjecutarHabilitarDispositivo.class, data);
    }
}
