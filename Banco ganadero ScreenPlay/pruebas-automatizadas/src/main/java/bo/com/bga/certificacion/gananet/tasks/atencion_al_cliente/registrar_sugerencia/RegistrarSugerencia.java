package bo.com.bga.certificacion.gananet.tasks.atencion_al_cliente.registrar_sugerencia;


import bo.com.bga.certificacion.gananet.interactions.shared.LimpiaCampos;
import bo.com.bga.certificacion.gananet.models.atencion_al_cliente.RegistrarReclamoModel;
import bo.com.bga.certificacion.gananet.models.atencion_al_cliente.RegistroSugerenciaModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.NEXT_BUTTONS;
import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;
import static bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente.RegistrarSugerenciaPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_REGISTRO_SUGERENCIAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class RegistrarSugerencia implements Task {
    RegistroSugerenciaModel registroSugerenciaModel;

    String scenario;

    public RegistrarSugerencia(RegistroSugerenciaModel registroSugerenciaModel, String scenario) {
        this.registroSugerenciaModel = registroSugerenciaModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                actor.attemptsTo(
                        LimpiaCampos.paraEscribir(INPUT_CORREO_SUGERENCIAS),
                        Scroll.to(INPUT_CORREO_SUGERENCIAS),
                        Enter.theValue(registroSugerenciaModel.getCorreoElectronico()).into(INPUT_CORREO_SUGERENCIAS),
                        Enter.theValue(registroSugerenciaModel.getDescripcion()+" "+ uuid.substring(0, 5)).into(INPUT_DESCRIPCION_SUGERENCIAS),
                        WaitUntil.the(NEXT_BUTTONS.of("Enviar"), isClickable()).forNoMoreThan(10).seconds()
                        );
                actor.remember("IDENTIFICADOR DE SUGERENCIAS", registroSugerenciaModel.getDescripcion()+" "+ uuid.substring(0, 5));
                actor.remember("MENSAJE INFORMATIVO - SUGERENCIAS",actor.asksFor(Text.of(MESSAGE_SUGERENCIAS)));
                actor.attemptsTo(
                        JavaScriptClick.on(NEXT_BUTTONS.of("Enviar")),
                        //Se construye el query que permite validar si se registró con éxito en base de datos
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_REGISTRO_SUGERENCIAS+"('%"+registroSugerenciaModel.getDescripcion()+" "+ uuid.substring(0, 5)+"%')","REGISTROS_SUGERENCIAS","AUTOSRV")
                );
                actor.remember("MENSAJE CONFIRMACIÓN - SUGERENCIAS",actor.asksFor(Text.of(MODAL_CONFIRMACION)));
                break;
        }


    }
    public static RegistrarSugerencia go(RegistroSugerenciaModel registroSugerenciaModel, String scenario){
        return Tasks.instrumented(RegistrarSugerencia.class,registroSugerenciaModel,scenario);

    }

}
