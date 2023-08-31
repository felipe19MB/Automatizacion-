package bo.com.bga.certificacion.gananet.tasks.administracion;

import bo.com.bga.certificacion.gananet.models.administracion.DatosAlertaMovimientos;
import bo.com.bga.certificacion.gananet.userinterfaces.administracion.AlertaMovimientosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class LlenarInformacionAlerta implements Task {
    DatosAlertaMovimientos datosAlertaMovimientos;

    public LlenarInformacionAlerta(DatosAlertaMovimientos datosAlertaMovimientos) {
        this.datosAlertaMovimientos = datosAlertaMovimientos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                JavaScriptClick.on(AlertaMovimientosPage.BOTON_AGREGAR_NUEVO_CORREO),
                byVisibleText(datosAlertaMovimientos.getNroDeCuenta()).from(AlertaMovimientosPage.SELECT_NRO_DE_CUENTA),
                Enter.theValue(datosAlertaMovimientos.getCorreo()).into(AlertaMovimientosPage.TXT_CORREO),
                byVisibleText(datosAlertaMovimientos.getTipoDeMovimiento()).from(AlertaMovimientosPage.SELECT_TIPO_DE_MOVIMIENTO),
                JavaScriptClick.on(AlertaMovimientosPage.BOTON_GUARDAR)
        );
    }
    public static LlenarInformacionAlerta go(DatosAlertaMovimientos datosAlertaMovimientos){
        return Tasks.instrumented(LlenarInformacionAlerta.class, datosAlertaMovimientos);

    }

}
