package bo.com.bga.certificacion.gananet.tasks.instituciones.reporte_de_instituciones;

import bo.com.bga.certificacion.gananet.interactions.shared.IngresaClaveTransaccional;
import bo.com.bga.certificacion.gananet.models.instituciones.TransaccionesPorFechaModel;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.OrdenDeCobroModel;
import bo.com.bga.certificacion.gananet.models.transferencias.TransferenciasModel;
import bo.com.bga.certificacion.gananet.userinterfaces.instituciones.TransaccionesPorFechaPage;
import bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.OrdenDeCobroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.util.UUID;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class GenerarTransaccionesPorFecha implements Task {

    String scenario;

   TransaccionesPorFechaModel transaccionesPorFechaModel;

    public GenerarTransaccionesPorFecha(TransaccionesPorFechaModel transaccionesPorFechaModel,String scenario) {
        this.scenario = scenario;
        this.transaccionesPorFechaModel = transaccionesPorFechaModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        JavaScriptClick.on(TransaccionesPorFechaPage.TIPO_TRANSACION_INSTITUCION.of(transaccionesPorFechaModel.getSubFuncionalidad())),
                        byVisibleText(transaccionesPorFechaModel.getInstitucion()).from(TransaccionesPorFechaPage.LABEL_INSTITUCIONES),
                        byVisibleText(transaccionesPorFechaModel.getGestion()).from(TransaccionesPorFechaPage.LABEL_AÑO_GESTION),
                        Enter.theValue(transaccionesPorFechaModel.getFechaInicial()).into(TransaccionesPorFechaPage.LABEL_FECHA_INICIAL),
                        Enter.theValue(transaccionesPorFechaModel.getFechaFinal()).into(TransaccionesPorFechaPage.LABEL_FECHA_FINAL),
                        JavaScriptClick.on(TransaccionesPorFechaPage.CHECK_BOX_AGRUPACION.of(transaccionesPorFechaModel.getAgrupacion())),
                        JavaScriptClick.on(TransaccionesPorFechaPage.BUTTON_GENERAR)


                );

                break;
        }

    }
    public static GenerarTransaccionesPorFecha go(TransaccionesPorFechaModel transaccionesPorFechaModel, String scenario){
        return Tasks.instrumented(GenerarTransaccionesPorFecha.class,transaccionesPorFechaModel,scenario);

    }

}
