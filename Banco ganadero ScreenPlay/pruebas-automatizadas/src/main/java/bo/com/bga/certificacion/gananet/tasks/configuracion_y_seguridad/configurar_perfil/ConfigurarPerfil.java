package bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.configurar_perfil;

import bo.com.bga.certificacion.gananet.interactions.shared.*;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ActualizacionDeDatosModel;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ConfigurarPerfilModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.*;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.CambioLimiteTransaccionesPage.LABEL_NRO_TRANSACCIONES;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ConfigurarPerfilPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class ConfigurarPerfil implements Task {

    String scenario;
    ConfigurarPerfilModel configurarPerfilModel;

    public ConfigurarPerfil( ConfigurarPerfilModel configurarPerfilModel,String scenario) {
        this.scenario = scenario;
        this.configurarPerfilModel = configurarPerfilModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        WaitUntil.the(LABEL_ALIAS, isCurrentlyVisible()).forNoMoreThan(35).seconds(),
                        Clear.field(LABEL_ALIAS),
                        Enter.theValue(configurarPerfilModel.getAlias()).into(LABEL_ALIAS),
                        JavaScriptClick.on(BOTON_BUSCAR),
                        Espera.aTime(1000),
                        Enter.theValue(configurarPerfilModel.getCorreo()).into(LABEL_CORREO),
                        Enter.theValue(configurarPerfilModel.getPreferido()).into(LABEL_NRO_PREFERIDO),
                        JavaScriptClick.on(BOTON_CAMBIAR_IMAGEN),
                        JavaScriptClick.on(IMAGEN),
                        JavaScriptClick.on(BOTON_CAMBIAR_I)
                        );
                String mensaje_alias = actor.asksFor(Text.of(TEXTO_USUARIO_DISPONIBLE));
                actor.remember("mensajeAlias",mensaje_alias);
                actor.remember("alias",configurarPerfilModel.getAlias());
                actor.attemptsTo(
                       JavaScriptClick.on(BOTON_ACTUALIZAR),
                       Espera.aTime(1000),
                       IngresaGanaPin2.paraConfirmarProceso()
                );
                String mensaje = actor.asksFor(Text.of(MENSAJE_CAMBIO_DE_DATOS));
                actor.remember("mensajeCambioDatos",mensaje);
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_OK)
                );

                break;
        }

    }
    public static ConfigurarPerfil go(ConfigurarPerfilModel configurarPerfilModel, String scenario){
        return Tasks.instrumented(ConfigurarPerfil.class,configurarPerfilModel,scenario);

    }

}
