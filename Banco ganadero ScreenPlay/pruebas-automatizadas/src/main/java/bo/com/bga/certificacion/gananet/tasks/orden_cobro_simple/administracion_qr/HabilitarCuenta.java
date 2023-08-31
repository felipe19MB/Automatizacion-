package bo.com.bga.certificacion.gananet.tasks.orden_cobro_simple.administracion_qr;

import bo.com.bga.certificacion.gananet.interactions.shared.ArrastrarYSoltar;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.DatosAdministracionQr;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.AdministracionQrPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_COMPROBAR_AFILIACION_CUENTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class HabilitarCuenta implements Task {
    private DatosAdministracionQr datosAdministracionQr;
    private final String scenario;

    public HabilitarCuenta(DatosAdministracionQr datosAdministracionQr, String scenario) {
        this.datosAdministracionQr = datosAdministracionQr;
        this.scenario = scenario;
    }
    public static HabilitarCuenta go(DatosAdministracionQr datosAdministracionQr, String scenario) {
        return Tasks.instrumented(HabilitarCuenta.class,datosAdministracionQr, scenario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
               actor.attemptsTo(
                        WaitUntil.the(AdministracionQrPage.DRAG_CUENTA.of(datosAdministracionQr.getNroCuenta()), isClickable()).forNoMoreThan(10).seconds(),
                        ArrastrarYSoltar.conLosElemntos(AdministracionQrPage.DRAG_CUENTA.of(datosAdministracionQr.getNroCuenta()), AdministracionQrPage.DROP_CUENTA),
                        Enter.theValue(datosAdministracionQr.getReferencia()).into(AdministracionQrPage.TXT_REFERENCIA),
                        JavaScriptClick.on(AdministracionQrPage.RDO_FECHA_VENCIMIENTO.of(datosAdministracionQr.getFechaVencimiento().toLowerCase())),
                        JavaScriptClick.on(AdministracionQrPage.RDO_USO.of(datosAdministracionQr.getUso())),
                        JavaScriptClick.on(AdministracionQrPage.BOTON_PROCESAR),
                        IngresaGanaPin.paraConfirmarTransaccion(),
                       EjecutaBaseDeDatos.QueryPersonalizado(QUERY_COMPROBAR_AFILIACION_CUENTA+datosAdministracionQr.getUsuario(),"CONSULTADBQRCUENTA","AUTOSRV")
                );
                break;
        }
    }
}
