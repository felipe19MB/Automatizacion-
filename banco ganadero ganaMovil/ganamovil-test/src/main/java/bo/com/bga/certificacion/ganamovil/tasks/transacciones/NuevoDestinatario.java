package bo.com.bga.certificacion.ganamovil.tasks.transacciones;

import bo.com.bga.certificacion.ganamovil.exceptions.Excepciones;

import bo.com.bga.certificacion.ganamovil.interactions.utils.Hide;
import bo.com.bga.certificacion.ganamovil.models.TransferenciaModel;
import bo.com.bga.certificacion.ganamovil.utils.constantes.Interaccion;
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
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiNDestinatarioMismoBanco.*;
import static bo.com.bga.certificacion.ganamovil.userinterfaces.transferencia.UiNDestinatarioMismoBanco.BTN_GUARDAR_CONTACTO;
import static bo.com.bga.certificacion.ganamovil.utils.utils.ComandosCapabilities.isiOS;

public class NuevoDestinatario implements Task {

    private String nuevoDestinatarioItem;
    private TransferenciaModel transferenciaModel;

    public NuevoDestinatario(String nuevoDestinatarioItem, TransferenciaModel transferenciaModel) {
        this.nuevoDestinatarioItem = nuevoDestinatarioItem;
        this.transferenciaModel = transferenciaModel;
    }

    @Title("Se registra el nuevo destinatario")
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (nuevoDestinatarioItem) {
            case "Nuevo destinatario Mismo Banco":
                try {
                    actor.attemptsTo(
                            WaitUntil.the(BTN_SELECCIONA_INSTITUCION, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_SELECCIONA_INSTITUCION),
                            Enter.theValue(transferenciaModel.getInstitucion()).into(TXT_INSTITUCIÓN),
                            Tap.on(IMG_BUSCAR),
                            Check.whether(isiOS(actor)).andIfSo(Tap.on(BTN_ITEM_INSTITUCION_IOS.of(transferenciaModel.getInstitucion()))
                            ).otherwise(Tap.on(BTN_ITEM_INSTITUCION.of(transferenciaModel.getInstitucion()))),
                            Enter.theValue(transferenciaModel.getCuentadestino()).into(TXT_NUMERO_CUENTA),
                            Hide.keyboard(),
                            Enter.theValue(transferenciaModel.getNombretitular()).into(TXT_NOMBRE_TITULAR),
                            Hide.keyboard(),
                            Enter.theValue(transferenciaModel.getGuardarcomo()).into(TXT_NOMBRE_CONTACTO),
                            Hide.keyboard(),
                            Tap.on(BTN_BUSCAR),
                            WaitUntil.the(BTN_GUARDAR_CONTACTO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_GUARDAR_CONTACTO),
                            WaitUntil.the(BTN_TRANSFERIR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_TRANSFERIR)
                    );
                    Logger.getAnonymousLogger().info("Formulario nuevo registro, destinatario mismo banco completado");
                }catch (RuntimeException ex){
                    throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_FORMULARIO_NUEVO_DESTINATARIO_MISMO_BANCO), ex);
                }

                break;

            case "Nuevo destinatario Banco Yolo":
                try {
                    actor.attemptsTo(
                            WaitUntil.the(BTN_SELECCIONA_INSTITUCION, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_SELECCIONA_INSTITUCION),
                            Enter.theValue(transferenciaModel.getInstitucion()).into(TXT_INSTITUCIÓN),
                            Tap.on(IMG_BUSCAR),
                            Check.whether(isiOS(actor)).andIfSo(Tap.on(BTN_ITEM_INSTITUCION_IOS.of(transferenciaModel.getInstitucion()))
                            ).otherwise(Tap.on(BTN_ITEM_INSTITUCION.of(transferenciaModel.getInstitucion()))),
                            Enter.theValue(transferenciaModel.getTelefono()).into(TXT_NUMERO_TELEFONO),
                            Hide.keyboard(),
                            Enter.theValue(transferenciaModel.getGuardarcomo()).into(TXT_NOMBRE_CONTACTO),
                            Hide.keyboard(),
                            Tap.on(BTN_BUSCAR),
                            Enter.theValue(transferenciaModel.getGuardarcomo()).into(TXT_NOMBRE_CONTACTO_BUG), // Error bug
                            Hide.keyboard(),// Error bug detectado
                            Tap.on(BTN_GUARDAR_CONTACTO),
                            WaitUntil.the(BTN_TRANSFERIR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_TRANSFERIR)
                    );
                    Logger.getAnonymousLogger().info("Formulario nuevo registro, destinatario banco yolo");
                }catch (RuntimeException ex){
                    throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_FORMULARIO_NUEVO_DESTINATARIO_BANCO_YOLO), ex);
                }

                break;

            case "Nuevo destinatario Banco Externo":
                try {
                    actor.attemptsTo(
                            WaitUntil.the(BTN_SELECCIONA_INSTITUCION, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_SELECCIONA_INSTITUCION),
                            Enter.theValue(transferenciaModel.getInstitucion()).into(TXT_INSTITUCIÓN),
                            Tap.on(IMG_BUSCAR),
                            Check.whether(isiOS(actor)).andIfSo(Tap.on(BTN_ITEM_INSTITUCION_IOS.of(transferenciaModel.getInstitucion()))
                            ).otherwise(Tap.on(BTN_ITEM_INSTITUCION.of(transferenciaModel.getInstitucion()))),
                            Tap.on(BTN_SUCURSAL),
                            Check.whether(isiOS(actor)).andIfSo(Tap.on(BTN_ITEM_INSTITUCION_IOS.of(transferenciaModel.getNombresucursal()))
                            ).otherwise(Tap.on(BTN_ITEM_INSTITUCION.of(transferenciaModel.getNombresucursal()))),
                            Tap.on(BTN_TIPO_CUENTA),
                            Check.whether(isiOS(actor)).andIfSo(Tap.on(BTN_ITEM_INSTITUCION_IOS.of(transferenciaModel.getTipocuenta()))
                            ).otherwise(Tap.on(BTN_ITEM_INSTITUCION.of(transferenciaModel.getTipocuenta()))),
                            Enter.theValue(transferenciaModel.getCuentadestino()).into(TXT_NUMERO_CUENTA),
                            Hide.keyboard(),
                            Enter.theValue(transferenciaModel.getNombretitular()).into(TXT_NOMBRE_TITULAR),
                            Hide.keyboard(),
                            Tap.on(BTN_GUARDAR_CONTACTO),
                            WaitUntil.the(BTN_TRANSFERIR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(BTN_TRANSFERIR)
                    );
                }catch (RuntimeException ex){
                    throw new Excepciones(Excepciones.error(Interaccion.INTERACTION_FORMULARIO_NUEVO_DESTINATARIO_BANCO_EXTERNO), ex);
                }

                break;
            default:
                break;

        }
    }

    public static NuevoDestinatario mismoBanco(TransferenciaModel transferenciaModel) {
        return Tasks.instrumented(NuevoDestinatario.class, "Nuevo destinatario Mismo Banco", transferenciaModel);
    }

    public static NuevoDestinatario bancoYolo(TransferenciaModel transferenciaModel) {
        return Tasks.instrumented(NuevoDestinatario.class, "Nuevo destinatario Banco Yolo", transferenciaModel);
    }

    public static NuevoDestinatario bancoExterno(TransferenciaModel transferenciaModel) {
        return Tasks.instrumented(NuevoDestinatario.class, "Nuevo destinatario Banco Externo", transferenciaModel);
    }
}
