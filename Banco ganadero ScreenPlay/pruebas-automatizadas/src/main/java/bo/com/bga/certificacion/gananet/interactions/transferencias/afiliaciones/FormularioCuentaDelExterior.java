package bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class FormularioCuentaDelExterior implements Interaction {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public FormularioCuentaDelExterior(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(AfiliacionesPage.TIPO_CUENTA_HISTORICO.of(datosAfiliacionCuentas.getSubFuncionalidad())),
                JavaScriptClick.on(AfiliacionesPage.BOTON_AGREGAR_EXTERIOR),
                Enter.theValue(datosAfiliacionCuentas.getAlias()).into(AfiliacionesPage.TXT_ALIAS_EXTERIOR),
                Enter.theValue(datosAfiliacionCuentas.getCuentaIBAN()).into(AfiliacionesPage.TXT_CUENTA_IBAN),
                Enter.theValue(datosAfiliacionCuentas.getNombreAfiliado()).into(AfiliacionesPage.TXT_NOMBRE),
                Enter.theValue(datosAfiliacionCuentas.getNumeroDocumento()).into(AfiliacionesPage.TXT_NUMERO_DOCUMENTO),
                byVisibleText(datosAfiliacionCuentas.getTipoPersona()).from(AfiliacionesPage.SELECT_TIPO_PERSONA),
                Enter.theValue(datosAfiliacionCuentas.getDireccion()).into(AfiliacionesPage.TXT_DIRECCION),
                byVisibleText(datosAfiliacionCuentas.getPais()).from(AfiliacionesPage.SELECT_PAIS),
                Enter.theValue(datosAfiliacionCuentas.getCiudad()).into(AfiliacionesPage.TXT_CIUDAD)
        );
    }
    public static FormularioCuentaDelExterior go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Instrumented.instanceOf(FormularioCuentaDelExterior.class).withProperties(datosAfiliacionCuentas);
    }
}
