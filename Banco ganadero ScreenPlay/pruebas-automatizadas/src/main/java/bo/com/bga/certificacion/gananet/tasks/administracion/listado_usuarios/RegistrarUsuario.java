package bo.com.bga.certificacion.gananet.tasks.administracion.listado_usuarios;

import bo.com.bga.certificacion.gananet.models.administracion.DatosListadoUsuarios;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.administracion.ListadoUsuariosPage;
import bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class RegistrarUsuario implements Task {
    DatosListadoUsuarios datosListadoUsuarios;
    String tipoCliente;
    public RegistrarUsuario(String tipoCliente, DatosListadoUsuarios datosListadoUsuarios) {
        this.datosListadoUsuarios = datosListadoUsuarios;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipoCliente) {
            case "cliente del Banco":
                actor.attemptsTo(
                        JavaScriptClick.on(ListadoUsuariosPage.BOTON_AGREGAR),
                        JavaScriptClick.on(ListadoUsuariosPage.BOTON_ACEPTAR_CONTRATO),
                        WaitUntil.the(ListadoUsuariosPage.SELECT_TIPO_DOCUMENTO, isClickable()).forNoMoreThan(10).seconds(),
                        Select.option(datosListadoUsuarios.getTipoDocumento()).from(ListadoUsuariosPage.SELECT_TIPO_DOCUMENTO),
                        Enter.theValue(datosListadoUsuarios.getDocumentoIdentidad()).into(ListadoUsuariosPage.TXT_DOCUMENTO_IDENTIDAD),
                        Select.option(datosListadoUsuarios.getExtension()).from(ListadoUsuariosPage.SELECT_EXTENSION_DOCUMENTO),
                        JavaScriptClick.on(ListadoUsuariosPage.BOTON_SIGUIENTE),
                        WaitUntil.the(ListadoUsuariosPage.SELECT_TIPO_USUARIO, isClickable()).forNoMoreThan(10).seconds(),
                        Select.option(datosListadoUsuarios.getTipoUsuario()).from(ListadoUsuariosPage.SELECT_TIPO_USUARIO),
                        Select.option(datosListadoUsuarios.getperfilUsuario()).from(ListadoUsuariosPage.SELECT_PERFIL),
                        Select.option(datosListadoUsuarios.getEstado()).from(ListadoUsuariosPage.SELECT_ESTADO),
                        JavaScriptClick.on(ListadoUsuariosPage.BOTON_SIGUIENTE),
                        JavaScriptClick.on(ListadoUsuariosPage.BOTON_CONFIRMAR),
                        IngresaGanaPin.paraConfirmarTransaccion()
                );
                WaitUntil.the(AfiliacionesPage.BOTON_OK, isClickable()).forNoMoreThan(10).seconds();
                break;
        }
    }
    public static RegistrarUsuario go(String tipoCliente, DatosListadoUsuarios datosListadoUsuarios) {
        return Tasks.instrumented(RegistrarUsuario.class, tipoCliente, datosListadoUsuarios);
    }
}
