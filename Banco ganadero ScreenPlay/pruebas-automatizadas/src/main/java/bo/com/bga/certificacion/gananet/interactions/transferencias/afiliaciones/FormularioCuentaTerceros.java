package bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
public class FormularioCuentaTerceros implements Interaction {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public FormularioCuentaTerceros(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(AfiliacionesPage.TIPO_CUENTA_HISTORICO.of(datosAfiliacionCuentas.getSubFuncionalidad())),
                JavaScriptClick.on(AfiliacionesPage.BOTON_AGREGAR),
                Enter.theValue(datosAfiliacionCuentas.getAlias()).into(AfiliacionesPage.TXT_ALIAS),
                Enter.theValue(datosAfiliacionCuentas.getNroCuenta()).into(AfiliacionesPage.TXT_NRO_CUENTA_TERCEROS),
                Enter.theValue(datosAfiliacionCuentas.getTitularCuenta()).into(AfiliacionesPage.TXT_NOMBRE_TITULAR_TERCEROS),
                JavaScriptClick.on(AfiliacionesPage.BOTON_VERIFICAR),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.LBL_FAVORITO),
                JavaScriptClick.on(AfiliacionesPage.BOTON_GUARDAR)
        );
        System.out.printf("Hizo clic en guardar");
    }
    public static FormularioCuentaTerceros go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Instrumented.instanceOf(FormularioCuentaTerceros.class).withProperties(datosAfiliacionCuentas);
    }
}
