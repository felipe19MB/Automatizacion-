package bo.com.bga.certificacion.gananet.tasks.administracion.listado_perfiles;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.models.administracion.ListadoPerfilesModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.userinterfaces.administracion.ListadoPerfilesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_CONSULTAR_PERFILES_CREADOS;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class RegistrarPerfil implements Task {
    ListadoPerfilesModel listadoPerfilesModel;

    public RegistrarPerfil(ListadoPerfilesModel listadoPerfilesModel) {
        this.listadoPerfilesModel = listadoPerfilesModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_AGREGAR_PERFIL),
                Enter.theValue(listadoPerfilesModel.getNombrePerfil()).into(ListadoPerfilesPage.TXT_NOMBRE_PERFIL),
                byVisibleText(listadoPerfilesModel.getPerfilBase()).from(ListadoPerfilesPage.SELECT_PERFIL_BASE),
                WaitUntil.the(ListadoPerfilesPage.BOTON_SIGUIENTE, isClickable()).forNoMoreThan(5).seconds(),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_SIGUIENTE),
                WaitUntil.the(ListadoPerfilesPage.SELECT_SELECCIONAR_TODOS, isPresent()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_SELECCIONAR_TODOS),
                WaitUntil.the(ListadoPerfilesPage.BOTON_SIGUIENTE, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_SIGUIENTE),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_SELECCIONAR_TODOS),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_PUEDE_VER_SALDOS),
                JavaScriptClick.on(ListadoPerfilesPage.SELECT_PUEDE_VER_PLANILLAS),
                WaitUntil.the(ListadoPerfilesPage.BOTON_SIGUIENTE, isClickable()).forNoMoreThan(5).seconds(),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_SIGUIENTE),
                WaitUntil.the(ListadoPerfilesPage.BOTON_CONFIRMAR, isClickable()).forNoMoreThan(5).seconds(),
                JavaScriptClick.on(ListadoPerfilesPage.BOTON_CONFIRMAR),
                IngresaGanaPin.paraConfirmarTransaccion()
        );
        OnStage.theActorInTheSpotlight().remember("mensajeConfirmacionRegistroPefil", Text.of(MODAL_CONFIRMACION).answeredBy(actor));
        actor.attemptsTo(
                           CerrarModal.go(),
                           EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_PERFILES_CREADOS+" NOMBRE = '"+listadoPerfilesModel.getNombrePerfil() +"'"+ "AND MARCA_BAJA = '0'", "validarRegistroPerfil","GANADERO"),
                           EliminarPerfil.go(listadoPerfilesModel),
                           CerrarModal.go()
        );

    }
    public static RegistrarPerfil go(ListadoPerfilesModel listadoPerfilesModel){
        return Tasks.instrumented(RegistrarPerfil.class, listadoPerfilesModel);

    }

}
