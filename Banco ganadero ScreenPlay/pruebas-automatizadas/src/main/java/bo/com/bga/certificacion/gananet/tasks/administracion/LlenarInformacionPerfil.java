package bo.com.bga.certificacion.gananet.tasks.administracion;

import bo.com.bga.certificacion.gananet.models.administracion.DatosNuevoPerfil;
import bo.com.bga.certificacion.gananet.userinterfaces.administracion.ListadoPerfilesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class LlenarInformacionPerfil implements Task {
    DatosNuevoPerfil datosNuevoPerfil;

    public LlenarInformacionPerfil(DatosNuevoPerfil datosNuevoPerfil) {
        this.datosNuevoPerfil = datosNuevoPerfil;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_AGREGAR_PERFIL),
                Enter.theValue(datosNuevoPerfil.getNombrePerfil()).into(ListadoPerfilesPage.TXT_NOMBRE_PERFIL),
                byVisibleText(datosNuevoPerfil.getPerfilBase()).from(ListadoPerfilesPage.SELECT_PERFIL_BASE),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_SIGUIENTE),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_SELECCIONAR_TODOS),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_SIGUIENTE),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_SELECCIONAR_TODOS),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_PUEDE_VER_SALDOS),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_PUEDE_VER_PLANILLAS),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_SIGUIENTE),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_CONFIRMAR)
        );

    }
    public static LlenarInformacionPerfil go(DatosNuevoPerfil datosNuevoPerfil){
        return Tasks.instrumented(LlenarInformacionPerfil.class,datosNuevoPerfil);

    }

}
