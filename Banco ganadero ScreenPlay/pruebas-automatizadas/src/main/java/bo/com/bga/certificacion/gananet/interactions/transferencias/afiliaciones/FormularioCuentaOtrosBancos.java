package bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
public class FormularioCuentaOtrosBancos implements Interaction {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public FormularioCuentaOtrosBancos(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(AfiliacionesPage.TIPO_CUENTA_HISTORICO.of(datosAfiliacionCuentas.getSubFuncionalidad())),
                JavaScriptClick.on(AfiliacionesPage.BOTON_AGREGAR),
                Enter.theValue(datosAfiliacionCuentas.getAlias()).into(AfiliacionesPage.TXT_ALIAS),
                byVisibleText(datosAfiliacionCuentas.getBanco()).from(AfiliacionesPage.SELECT_BANCO),
                byVisibleText(datosAfiliacionCuentas.getSucursal()).from(AfiliacionesPage.SELECT_SUCURSAL),
                Enter.theValue(datosAfiliacionCuentas.getNombreTitular()).into(AfiliacionesPage.TXT_NOMBRE_TITULAR),
                Enter.theValue(datosAfiliacionCuentas.getCiNit()).into(AfiliacionesPage.TXT_CI_NIT),
                byVisibleText(datosAfiliacionCuentas.getTipoCuenta()).from(AfiliacionesPage.SELECT_TIPO_CUENTA),
                Enter.theValue(datosAfiliacionCuentas.getNroCuenta()).into(AfiliacionesPage.TXT_NRO_CUENTA),
                Enter.theValue(datosAfiliacionCuentas.getEmail()).into(AfiliacionesPage.TXT_EMAIL),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.BOTON_GUARDAR)
        );
    }
    public static FormularioCuentaOtrosBancos go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Instrumented.instanceOf(FormularioCuentaOtrosBancos.class).withProperties(datosAfiliacionCuentas);
    }
}
