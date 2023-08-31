package bo.com.bga.certificacion.ganamovil.tasks.qr;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.interactions.utils.EsperaExplicita;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.qr.UiHistorico.BTN_HISTORICO;

public class Historico implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Tap.on(BTN_HISTORICO),
                    EsperaExplicita.empleada(10000)
            );
        }catch (RuntimeException ex){
            throw new Excepciones(Excepciones.error(Interaccion.TASK_HISTORICO), ex);
        }

    }
    public static Historico seleccionar(){
        return Tasks.instrumented(Historico.class);
    }
}
