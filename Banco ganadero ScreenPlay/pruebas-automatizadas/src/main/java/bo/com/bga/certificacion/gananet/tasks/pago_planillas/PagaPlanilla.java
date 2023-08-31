package bo.com.bga.certificacion.gananet.tasks.pago_planillas;

import bo.com.bga.certificacion.gananet.interactions.shared.AlertasInteraciones;
import bo.com.bga.certificacion.gananet.interactions.shared.LimpiaCampos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ImportarYPagarPlanillaPage;
import bo.com.bga.certificacion.gananet.interactions.shared.ActualizarFecha;
import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Paths;
import java.util.UUID;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.BUTTON_TOP_HEADER;
import static bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.ImportarYPagarPlanillaPage.NOMBRE_PLANILLA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class PagaPlanilla implements Task {
    private String formaPago;
    private String tipoPago;
    private String tipoAutorizacion;

    public PagaPlanilla(String formaPago, String tipoPago, String tipoAutorizacion) {
        this.formaPago = formaPago;
        this.tipoPago = tipoPago;
        this.tipoAutorizacion = tipoAutorizacion;
    }
    public static PagaPlanilla conDatos(String formaPago, String tipoPago, String tipoAutorizacion) {
        return Tasks.instrumented(PagaPlanilla.class,formaPago,tipoPago,tipoAutorizacion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (tipoPago.equals("empleados")) {
            tipoPago = "Pago Sueldo";
        } else if (tipoPago.equals("proovedores")) {
            tipoPago = "Pago Proovedores";
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        actor.attemptsTo(
                ActualizarFecha.enExcel("src/test/resources/data/pago_planillas/planillaSueldo.xlsx", "Hoja1"),
                WaitUntil.the(ImportarYPagarPlanillaPage.SELECT_PAGO.of(formaPago), isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(ImportarYPagarPlanillaPage.SELECT_PAGO.of(formaPago)),
                JavaScriptClick.on(HomePage.NEXT_BUTTONS.of("Siguiente")),
                JavaScriptClick.on(ImportarYPagarPlanillaPage.SELECT_PAGO.of(tipoPago)),
                JavaScriptClick.on(HomePage.NEXT_BUTTONS.of("Siguiente")),
                Scroll.to(ImportarYPagarPlanillaPage.UPLOAD_FILE),
                Upload.theFile(Paths.get("src/test/resources/data/pago_planillas/planillaSueldo.xlsx")).to(ImportarYPagarPlanillaPage.UPLOAD_FILE),
                Espera.aTime(3000)
                );
        boolean isEnabled = actor.asksFor(Enabled.of(ImportarYPagarPlanillaPage.SELECT_AUTORIZACION));
        if(isEnabled){
            actor.attemptsTo(
                Select.option(tipoAutorizacion).from(ImportarYPagarPlanillaPage.SELECT_AUTORIZACION)
            );
        }
        actor.attemptsTo(
                Select.optionNumber(1).from(ImportarYPagarPlanillaPage.SELECT_CONVENIO),
                Scroll.to(BUTTON_TOP_HEADER),
                Scroll.to(NOMBRE_PLANILLA),
                Clear.field(NOMBRE_PLANILLA),
                LimpiaCampos.paraEscribir(NOMBRE_PLANILLA),
                SendKeys.of("PLANILLA " + uuid.substring(0, 5)).into(NOMBRE_PLANILLA),
                SendKeys.of(uuid).into(ImportarYPagarPlanillaPage.GLOSA_ADICIONAL),
                JavaScriptClick.on(HomePage.NEXT_BUTTONS.of("Validar")),
                WaitUntil.the(ImportarYPagarPlanillaPage.ESTADO_TRANSACCION,isVisible()).forNoMoreThan(15).seconds()
        );
        OnStage.theActorInTheSpotlight().remember("Concepto Planilla","PLANILLA " + (uuid.substring(0, 5)).toUpperCase());
        OnStage.theActorInTheSpotlight().remember("Estado Transacción", Text.of(ImportarYPagarPlanillaPage.ESTADO_TRANSACCION).answeredBy(actor).toString());
        actor.attemptsTo(
                JavaScriptClick.on(HomePage.NEXT_BUTTONS.of("Procesar pago")),
                IngresaGanaPin.paraConfirmarTransaccion(),
                WaitUntil.the(HomePage.LOADER_TRANSVERSAL,isNotCurrentlyVisible()).forNoMoreThan(30).seconds(),
                AlertasInteraciones.aceptar(),
                Espera.aTime(9000)

        );
    }
}
