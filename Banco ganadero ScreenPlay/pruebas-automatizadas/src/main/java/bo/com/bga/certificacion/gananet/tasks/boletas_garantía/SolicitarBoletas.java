package bo.com.bga.certificacion.gananet.tasks.boletas_garantía;

import bo.com.bga.certificacion.gananet.interactions.shared.LimpiaCampos;
import bo.com.bga.certificacion.gananet.models.boletas_garantía.BoletasGarantíaModel;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.LOADER_TRANSVERSAL;
import static bo.com.bga.certificacion.gananet.userinterfaces.HomePage.NEXT_BUTTONS;
import static bo.com.bga.certificacion.gananet.userinterfaces.boletas_garantía.SolicitudBoletasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SolicitarBoletas implements Task {

    private BoletasGarantíaModel boletasGarantíaModel;
    private String escenario;

    public SolicitarBoletas(BoletasGarantíaModel boletasGarantíaModel, String escenario) {
        this.boletasGarantíaModel = boletasGarantíaModel;
        this.escenario = escenario;
    }

    public static SolicitarBoletas deGarantía(BoletasGarantíaModel boletasGarantíaModel, String escenario) {
        return Tasks.instrumented(SolicitarBoletas.class, boletasGarantíaModel, escenario);
    }

    @Title("Solicita Boletas de garantía prepagadas")
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (escenario) {
            case ("HappyPath"):
                actor.remember("MODAL INICIO SOLICITUD", Text.of(CONTENIDO_ALERTA_MODAL).answeredBy(actor));
                actor.attemptsTo(
                        JavaScriptClick.on(AfiliacionesPage.BOTON_OK),
                        JavaScriptClick.on(TIPO_SOLICITUD.of(boletasGarantíaModel.getTipoSolicitud())),
                        //Aca hay un error::::::
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguente")),
                        WaitUntil.the(CUENTA_DE_DEBITO.of(boletasGarantíaModel.getCuentaOrigen()),isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(CUENTA_DE_DEBITO.of(boletasGarantíaModel.getCuentaOrigen())),
                        JavaScriptClick.on(TIPO_IMPORTE.of(boletasGarantíaModel.getTipoImporte())),
                        Enter.theValue(boletasGarantíaModel.getMonto()).into(MONTO),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguente")),
                        WaitUntil.the(NRO_TESTIMONIO,isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                        Select.option(boletasGarantíaModel.getNroTestimonio()).from(NRO_TESTIMONIO),
                        JavaScriptClick.on(CHECK_TODOS_REPRESENTANTES),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguente")),
                        WaitUntil.the(INPUT_EN_GARANTIA_DE,isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                        Select.option(boletasGarantíaModel.getTipoBoleta() + " ").from(TIPO_BOLETA),
                        Enter.theValue(boletasGarantíaModel.getOrdenDe()).into(INPUT_A_LA_ORDEN_DE),
                        Enter.theValue(boletasGarantíaModel.getPlazo()).into(PLAZO),
                        LimpiaCampos.paraEscribir(INPUT_EN_GARANTIA_DE),
                        Enter.theValue(boletasGarantíaModel.getEnGarantiaDe()).into(INPUT_EN_GARANTIA_DE),
                        Select.option(boletasGarantíaModel.getCiudad()).from(CIUDAD),
                        Select.option(boletasGarantíaModel.getOficina()).from(OFICINA),
                        Enter.theValue(boletasGarantíaModel.getEmailNotificacion()).into(EMAIL_NOTIFICACION),
                        Enter.theValue(boletasGarantíaModel.getNombre()).into(NOMBRE),
                        Enter.theValue(boletasGarantíaModel.getDocumento()).into(DOCUMENTO_DE_IDENTIDAD),
                        WaitUntil.the(NEXT_BUTTONS.of("Siguente"), isClickable()).forNoMoreThan(25).seconds(),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguente")),
                        WaitUntil.the(NEXT_BUTTONS.of("Siguente"), isClickable()).forNoMoreThan(10).seconds()
                );
                actor.remember("TOTAL CARGOS CALCULADOS", Value.of(EQUIVALENTE_CARGOS).answeredBy(actor));
                actor.attemptsTo(
                        Enter.theValue(boletasGarantíaModel.getNombreFacturacion()).into(NOMBRE_FACTURACION),
                        Enter.theValue(boletasGarantíaModel.getNit()).into(NIT_FACTURACION),
                        WaitUntil.the(NEXT_BUTTONS.of("Siguente"), isClickable()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguente"))
                );
                actor.remember("FECHA VENCIMIENTO CACULADA", Value.of(FECHA_VENCIMIENTO).answeredBy(actor));
                actor.attemptsTo(
                        WaitUntil.the(NEXT_BUTTONS.of("Siguente"), isClickable()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Siguente"))
                );
                actor.remember("DECLARACIÓN Y ACEPTACIÓN", Text.of(DECLARACION_Y_ACEPTACION_COPY).answeredBy(actor));
                actor.attemptsTo(
                        WaitUntil.the(NEXT_BUTTONS.of("Confirmar"), isClickable()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(NEXT_BUTTONS.of("Confirmar")));
                actor.remember("MODAL FINALIZACIÓN SOLICITUD", Text.of(CONTENIDO_ALERTA_MODAL).answeredBy(actor));
                actor.attemptsTo(
                        JavaScriptClick.on(AfiliacionesPage.BOTON_OK),
                        IngresaGanaPin.paraConfirmarTransaccion(),
                        WaitUntil.the(LOADER_TRANSVERSAL, isNotCurrentlyVisible()).forNoMoreThan(35).seconds(),
                        WaitUntil.the(ICONO_EXITOSO_MODAL, isCurrentlyVisible()).forNoMoreThan(15).seconds()
                );
                actor.remember("MODAL SOLICITUD EXITOSA", Text.of(CONTENIDO_ALERTA_MODAL).answeredBy(actor));
                actor.attemptsTo(JavaScriptClick.on(AfiliacionesPage.BOTON_OK),
                        WaitUntil.the(ICONO_EXITOSO_MODAL, isNotCurrentlyVisible()).forNoMoreThan(15).seconds(),
                        WaitUntil.the(ID_COMPROBANTE_BOLETAS, isPresent()).forNoMoreThan(10).seconds()
                        );
                String comprobante = BrowseTheWeb.as(actor).findFirst(ID_COMPROBANTE_BOLETAS.getCssOrXPathSelector()).get().getAttribute("innerText").substring(3);
                actor.remember("ID COMPROBANTE", comprobante);
                actor.remember("FECHA COMPROBANTE", Text.of(FECHA_COMPROBANTE_BOLETAS).answeredBy(actor));
                actor.remember("HORA COMPROBANTE", Text.of(HORA_COMPROBANTE_BOLETAS).answeredBy(actor));
        }
    }
}
