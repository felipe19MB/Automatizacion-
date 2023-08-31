package bo.com.bga.certificacion.ganamovil.interactions.transacciones;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;
import bo.com.bga.certificacion.ganamovil.interactions.utils.EsperaExplicita;
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
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferenciaEntreMisCuentas.TXT_SALDO;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferencia.*;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiTransferencia.LBL_TRANSFERENCIA_OTROS_BANCOS;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class DiligenciarYolo implements Interaction {

    private TransferenciaModel transferenciaModel;

    public DiligenciarYolo(TransferenciaModel transferenciaModel) {
        this.transferenciaModel = transferenciaModel;
    }

    @Title("Se diligencia la transacción a terceros")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    EsperaExplicita.empleada(10000),
                    WaitUntil.the(TXT_BUSCAR_CONTACTO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Enter.theValue(transferenciaModel.getNombredestinatario()).into(TXT_BUSCAR_CONTACTO),
                    Tap.on(IMG_BUSCAR),
                    EsperaExplicita.empleada(10000),
                    Tap.on(BTN_CONTACTO_YOLO),
                    Enter.theValue(transferenciaModel.getSaldo()).into(TXT_SALDO),
                    Check.whether(isiOS(actor)).andIfSo(
                            Tap.on(370, 486)
                    ),
                    Enter.theValue(transferenciaModel.getDescripcion()).into(TXT_DESCRIPCION_OTROS_BANCOS),
                    Check.whether(isiOS(actor)).andIfSo(
                            Tap.on(370, 486)
                    ),
                    Tap.on(BNT_CUENTA_ORIGEN_OTROS_BANCOS),
                    Check.whether(isiOS(actor)).andIfSo(Tap.on(ITEM_CUENTA_IOS_OTROS_BANCOS.of(transferenciaModel.getCuentaorigen()))
                    ).otherwise(Tap.on(ITEM_CUENTA_ANDROID_OTROS_BANCOS.of(transferenciaModel.getCuentaorigen()))),
                    Tap.on(BTN_CONTINUAR_OTROS_BANCOS),
                    Tap.on(BTN_TRANSFERIR_OTROS_BANCOS),
                    WaitUntil.the(LBL_TRANSFERENCIA_OTROS_BANCOS, WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds()
            );
            Logger.getAnonymousLogger().info("Formulario billetera completado");
        } catch (RuntimeException ex) {
            throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_FORMULARIO_BILLETERA), ex);
        }

    }

    public static DiligenciarYolo diligenciar(TransferenciaModel transferenciaModel) {
        return Instrumented.instanceOf(DiligenciarYolo.class).withProperties(transferenciaModel);
    }
}
