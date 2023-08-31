package bo.com.bga.certificacion.gananet.tasks.orden_cobro_simple.orden_de_cobro;

import bo.com.bga.certificacion.gananet.interactions.shared.IngresaClaveTransaccional;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.CambioLimiteTransaccionesModel;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.OrdenDeCobroModel;
import bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.OrdenDeCobroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.UUID;

import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.BOTON_OK;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.LABEL_RELACION_1;
import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.CambioLimiteTransaccionesPage.*;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GenerarOrdenDeCobro implements Task {

    String scenario;

     OrdenDeCobroModel ordenDeCobroModel;

    public GenerarOrdenDeCobro(OrdenDeCobroModel ordenDeCobroModel,String scenario) {
        this.scenario = scenario;
        this.ordenDeCobroModel = ordenDeCobroModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                actor.attemptsTo(
                        JavaScriptClick.on(OrdenDeCobroPage.CUENTA_ORIGEN.of(ordenDeCobroModel.getNroCuenta())),
                        byVisibleText(ordenDeCobroModel.getTipoCobro()).from(OrdenDeCobroPage.LABEL_TIPO_COBRO),
                        byVisibleText(ordenDeCobroModel.getFechaVencimiento()).from(OrdenDeCobroPage.LABEL_FECHA_VENCIMIENTO),
                        byVisibleText(ordenDeCobroModel.getMoneda()).from(OrdenDeCobroPage.LABEL_MONEDA),
                        Enter.theValue(ordenDeCobroModel.getMonto()).into(OrdenDeCobroPage.LABEL_MONTO),
                        Enter.theValue(uuid).into(OrdenDeCobroPage.LABEL_DESCRIPCION),
                        JavaScriptClick.on(OrdenDeCobroPage.BOTON_GENERAR),
                        IngresaClaveTransaccional.paraConfirmarProceso()

                );
                actor.remember("claveUnicaOrdenDeCobro",uuid);



                break;
        }

    }
    public static GenerarOrdenDeCobro go(OrdenDeCobroModel ordenDeCobroModel, String scenario){
        return Tasks.instrumented(GenerarOrdenDeCobro.class,ordenDeCobroModel,scenario);

    }

}
