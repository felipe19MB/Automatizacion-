package bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class FormularioCuentaBilletera implements Interaction {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public FormularioCuentaBilletera(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(AfiliacionesPage.TIPO_CUENTA_HISTORICO.of(datosAfiliacionCuentas.getSubFuncionalidad())),
                JavaScriptClick.on(AfiliacionesPage.BOTON_AGREGAR),
                Enter.theValue(datosAfiliacionCuentas.getAlias()).into(AfiliacionesPage.TXT_ALIAS),
                Enter.theValue(datosAfiliacionCuentas.getTelefono()).into(AfiliacionesPage.TXT_NRO_CUENTA_BILLETERA),
                JavaScriptClick.on(AfiliacionesPage.BOTON_VERIFICAR_TELEFONO),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.BOTON_GUARDAR)
        );
    }
    public static FormularioCuentaBilletera go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Instrumented.instanceOf(FormularioCuentaBilletera.class).withProperties(datosAfiliacionCuentas);
    }
}
