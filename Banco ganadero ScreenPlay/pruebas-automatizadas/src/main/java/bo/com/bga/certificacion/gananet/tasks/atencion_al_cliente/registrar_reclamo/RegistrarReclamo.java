package bo.com.bga.certificacion.gananet.tasks.atencion_al_cliente.registrar_reclamo;

import bo.com.bga.certificacion.gananet.interactions.shared.FechaActual;
import bo.com.bga.certificacion.gananet.models.atencion_al_cliente.RegistrarReclamoModel;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.UUID;

import static bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente.RegistrarReclamoPage.*;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class RegistrarReclamo implements Task {
    RegistrarReclamoModel registrarReclamoModel;

    String scenario;

    public RegistrarReclamo(RegistrarReclamoModel registrarReclamoModel, String scenario) {
        this.registrarReclamoModel = registrarReclamoModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                actor.attemptsTo(
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds(),
                        Scroll.to(SCROLL),
                        Enter.theValue(registrarReclamoModel.getCelular()).into(LABEL_TELEFONO_CELULAR),
                        Enter.theValue(registrarReclamoModel.getTelefonoTrabajo()).into(LABEL_TELEFONO_TRABAJO),
                        Enter.theValue(registrarReclamoModel.getBarrio()).into(BARRIO_URBANIZACION),
                        Scroll.to(BARRIO_URBANIZACION),
                        Enter.theValue(registrarReclamoModel.getCalle()).into(LABEL_CALLE),
                        Enter.theValue(registrarReclamoModel.getNumeroCasa()).into(LABEL_NUMERO_CASA),
                        Enter.theValue(registrarReclamoModel.getCorreoElectronico()).into(LABEL_CORREO_ELECTRONICO),
                        byVisibleText(registrarReclamoModel.getTipoReclamo()).from(SELECT_TIPO_RECLAMO),
                        byVisibleText(registrarReclamoModel.getReclamo()).from(SELECT_RECLAMO),
                        byVisibleText(registrarReclamoModel.getMoneda()).from(SELECT_MONEDA),
                        Enter.theValue(registrarReclamoModel.getMonto()).into(LABEL_MONTO),
                        Enter.theValue(FechaActual.obtenerFechaActual()).into(LABEL_FECHA_HECHO),
                        Enter.theValue(registrarReclamoModel.getDescripcion()+uuid).into(DESCRIPCION_RECLAMO),
                        JavaScriptClick.on(BOTON_ENVIAR)

                        );
                actor.remember("claveUnica",uuid);
                System.out.println(uuid);
                String mensaje = actor.asksFor(Text.of(MENSAJE_RECLAMO_CREADO));
                actor.remember("mensajeReclamo",mensaje);
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_OK)
                );
                break;
        }


    }
    public static RegistrarReclamo go(RegistrarReclamoModel registrarReclamoModel, String scenario){
        return Tasks.instrumented(RegistrarReclamo.class,registrarReclamoModel,scenario);

    }

}
