package bo.com.bga.certificacion.gananet.tasks.transferencias.afiliaciones;

import bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones.*;
import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class LlenarCamposCuentasAfiliaciones implements Task {
    DatosAfiliacionCuentas datosAfiliacionCuentas;
    public LlenarCamposCuentasAfiliaciones(DatosAfiliacionCuentas datosAfiliacionCuentas) {
        this.datosAfiliacionCuentas = datosAfiliacionCuentas;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String submodulo = datosAfiliacionCuentas.getSubFuncionalidad();
        switch (submodulo) {
            case "Cuentas de terceros":
                actor.attemptsTo(
                        FormularioCuentaTerceros.go(datosAfiliacionCuentas),
                        IngresaGanaPin.paraConfirmarTransaccion()
                );
                break;
            case "Cuentas de billetera":
                actor.attemptsTo(
                        FormularioCuentaBilletera.go(datosAfiliacionCuentas),
                        IngresaGanaPin.paraConfirmarTransaccion()
                );
                break;
            case "Cuentas del exterior":
                actor.attemptsTo(
                        FormularioCuentaDelExterior.go(datosAfiliacionCuentas),
                        FormularioCuentaBancoBeneficiario.go(datosAfiliacionCuentas),
                        IngresaGanaPin.paraConfirmarTransaccion()
                );
                break;
            case "Cuentas de otros bancos":
                actor.attemptsTo(
                        FormularioCuentaOtrosBancos.go(datosAfiliacionCuentas),
                        IngresaGanaPin.paraConfirmarTransaccion()
                );
                break;
            default:
                break;
        }
        WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(10).seconds();
    }
    public static LlenarCamposCuentasAfiliaciones go(DatosAfiliacionCuentas datosAfiliacionCuentas){
        return Tasks.instrumented(LlenarCamposCuentasAfiliaciones.class,datosAfiliacionCuentas);
    }
}
