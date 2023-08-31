package bo.com.bga.certificacion.ganamovil.tasks.qr;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.models.QrModel;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import bo.com.bga.certificacion.ganamovil.utils.utils.Scroll;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import java.util.logging.Logger;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.qr.UiCobrar.*;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class Cobrar implements Task {

    private QrModel qrModel;

    public Cobrar(QrModel qrModel){
        this.qrModel = qrModel;
    }

    @Title("Selecciona los datos para generar el QR")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Tap.on(BTN_COBRAR),
                    Enter.theValue(qrModel.getSaldo()).into(TXT_SALDO),
                    Tap.on(BTN_CUENTA_ORIGEN),
                    Check.whether(isiOS(actor)).andIfSo(
                            Tap.on(ITEM_CUENTA_IOS.of(qrModel.getCuentaorigen()))
                    ).otherwise(
                            Tap.on(ITEM_CUENTA_ANDROID.of(qrModel.getCuentaorigen()))
                    ),
                    Check.whether(isiOS(actor)).andIfSo(
                            Tap.on(ITEM_CUENTA_IOS.of(qrModel.getTipomoneda()))
                    ).otherwise(
                            Tap.on(BTN_MONEDA.of(qrModel.getTipomoneda()))
                    ),
                    Scroll.on(TXT_DESCRIPCION),
                    Enter.theValue(qrModel.getDescripcion()).into(TXT_DESCRIPCION),
                    Tap.on(BTN_TIEMPO_DE_DURACION),
                    Check.whether(isiOS(actor)).andIfSo(
                            Tap.on(ITEM_CUENTA_IOS.of(qrModel.getTiempoduracion()))
                    ).otherwise(
                            Tap.on(ITEM_CUENTA_ANDROID.of(qrModel.getTiempoduracion()))
                    ),
                    Tap.on(BTN_GENERAR),
                    Tap.on(BTN_NOTIFICACION),
                    WaitUntil.the(LBL_QR, WebElementStateMatchers.isVisible()).forNoMoreThan(160).seconds()
            );
            Logger.getAnonymousLogger().info("Formulario cobrar QR");
        }catch (RuntimeException ex){
            throw new Excepciones(Excepciones.error(Interaccion.TASK_COBRAR_QR), ex);
        }

    }

    public static Cobrar cobrar(QrModel qrModel){
        return Tasks.instrumented(Cobrar.class, qrModel);
    }
}
