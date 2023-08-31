package bo.com.bga.certificacion.ganamovil.interactions.transacciones;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.models.TransferenciaModel;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
import bo.com.bga.certificacion.ganamovil.utils.utils.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import java.util.logging.Logger;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.*;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.LBL_TRANSFERENCIA;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class DiligenciarEntreMisCuentas implements Interaction {

    private TransferenciaModel transferenciaModel;

    public DiligenciarEntreMisCuentas(TransferenciaModel transferenciaModel){
        this.transferenciaModel = transferenciaModel;
    }

    @Title("Se diligencia la transacción entre mis cuentas")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {

            actor.attemptsTo(
                    WaitUntil.the(BNT_CUENTA_ORIGEN, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Enter.theValue(transferenciaModel.getSaldo()).into(TXT_SALDO),
                    Tap.on(BNT_CUENTA_ORIGEN),
                    Check.whether(isiOS(actor)).andIfSo(Tap.on(ITEM_CUENTA_IOS.of(transferenciaModel.getCuentaorigen()))
                    ).otherwise(Tap.on(ITEM_CUENTA_ANDROID.of(transferenciaModel.getCuentaorigen()))),
                    Enter.theValue(transferenciaModel.getDescripcion()).into(TXT_DESCRIPCION),
                    Tap.on(BNT_CUENTA_DESTINO),
                    Check.whether(isiOS(actor)).andIfSo(Tap.on(ITEM_CUENTA_IOS.of(transferenciaModel.getCuentadestino()))
                    ).otherwise(Tap.on(ITEM_CUENTA_ANDROID.of(transferenciaModel.getCuentadestino()))),
                    Tap.on(BTN_CONTINUAR),
                    Tap.on(BTN_TRANSFERIR),
                    WaitUntil.the(LBL_TRANSFERENCIA, WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds()
            );
            Logger.getAnonymousLogger().info("Formulario entre mis cuentas completado");
        } catch (RuntimeException ex) {
            throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_FORMULARIO_ENTRE_MIS_CUENTAS), ex);
        }
    }

    public static DiligenciarEntreMisCuentas diligenciar(TransferenciaModel transferenciaModel){
        return Instrumented.instanceOf(DiligenciarEntreMisCuentas.class).withProperties(transferenciaModel);
    }
}
