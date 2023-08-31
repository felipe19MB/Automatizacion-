package bo.com.bga.certificacion.ganamovil.tasks.pagodeservicio;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.interactions.utils.Hide;
import bo.com.bga.certificacion.ganamovil.models.ServicioModel;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.logging.Logger;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.pagodeservicio.UiAfiliar.*;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class DiligencioServicio implements Task {

    private ServicioModel servicioModel;

    public DiligencioServicio(ServicioModel servicioModel){
        this.servicioModel = servicioModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Check.whether(isiOS(actor))
                            .andIfSo(Tap.on(BTN_TIPO_IOS.of(servicioModel.getTipo())))
                                    .otherwise(Tap.on(BTN_TIPO.of(servicioModel.getTipo()))),
                    Tap.on(BTN_CODIGO),
                    Check.whether(isiOS(actor))
                            .andIfSo(Tap.on(BTN_TIPO_IOS.of(servicioModel.getCodigo())))
                            .otherwise(Tap.on(BTN_TIPO.of(servicioModel.getCodigo()))),
                    Enter.theValue(servicioModel.getCuenta()).into(TXT_CUENTA),
                    Hide.keyboard(),
                    Enter.theValue(servicioModel.getReferencia()).into(TXT_REFERENCIA),
                    Hide.keyboard(),
                    Tap.on(BTN_BUSCAR),
                    Tap.on(BTN_GUARDAR),
                    WaitUntil.the(LBL_ALERTA_RESPONSE, WebElementStateMatchers.isVisible()).forNoMoreThan(360).seconds()
            );
            Logger.getAnonymousLogger().info("Formulario registro de servicio completado");
        }catch (RuntimeException ex){
            throw new Excepciones(Excepciones.error(Interaccion.TASK_DILIGENCIAR_SERVICIO), ex);
        }
    }

    public static DiligencioServicio afiliar(ServicioModel servicioModel){
        return Tasks.instrumented(DiligencioServicio.class, servicioModel);
    }
}
