package bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.cambio_limite_transacciones;

import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.interactions.shared.IngresaClaveTransaccional;
import bo.com.bga.certificacion.gananet.interactions.shared.IngresaGanaPin2;
import bo.com.bga.certificacion.gananet.interactions.shared.LimpiaCampos;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.CambioLimiteTransaccionesModel;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ConfigurarPerfilModel;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.BOTON_OK;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.MENSAJE_CAMBIO_DE_DATOS;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.CambioLimiteTransaccionesPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ConfigurarPerfilPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CambiarLimiteTransacciones implements Task {

    String scenario;
  CambioLimiteTransaccionesModel cambioLimiteTransaccionesModel;

    public CambiarLimiteTransacciones( CambioLimiteTransaccionesModel cambioLimiteTransaccionesModel,String scenario) {
        this.scenario = scenario;
        this.cambioLimiteTransaccionesModel = cambioLimiteTransaccionesModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                    WaitUntil.the(LABEL_NRO_TRANSACCIONES, isVisible()).forNoMoreThan(35).seconds(),
                    Clear.field(LABEL_NRO_TRANSACCIONES),
                    Enter.theValue(cambioLimiteTransaccionesModel.getNroTransacciones()).into(LABEL_NRO_TRANSACCIONES),
                    JavaScriptClick.on(BOTON_ACTUALIZAR_LIMITE),
                    IngresaClaveTransaccional.paraConfirmarProceso()
                );
                String mensaje = actor.asksFor(Text.of(VALIDACION_MENSAJE));
                actor.remember("mensajeCambioLimite",mensaje);
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_OK)
                );


                break;
        }

    }
    public static CambiarLimiteTransacciones go(CambioLimiteTransaccionesModel cambioLimiteTransaccionesModel, String scenario){
        return Tasks.instrumented(CambiarLimiteTransacciones.class,cambioLimiteTransaccionesModel,scenario);

    }

}
