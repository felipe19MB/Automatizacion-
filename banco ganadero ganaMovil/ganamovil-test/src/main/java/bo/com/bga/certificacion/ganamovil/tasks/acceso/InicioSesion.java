package bo.com.bga.certificacion.ganamovil.tasks.acceso;

import bo.com.bga.certificacion.ganamovil.exceptions.RuntimeException;
import bo.com.bga.certificacion.ganamovil.interactions.acceso.FormularioInicioSesion;
import bo.com.bga.certificacion.ganamovil.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.ganamovil.interactions.shared.CerrarNotificacines;
import bo.com.bga.certificacion.ganamovil.models.UsuarioModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

public class InicioSesion implements Task {

    private UsuarioModel usuarioModel;

    public InicioSesion(UsuarioModel usuarioModel){
        this.usuarioModel = usuarioModel;
    }

    @Title("Se inicia sesión")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    CerrarModal.go(),
                    FormularioInicioSesion.go(usuarioModel),
                    CerrarNotificacines.iOS()
            );
        }catch (java.lang.RuntimeException ex){
            throw new RuntimeException(RuntimeException.errorCredenciales(), ex);
        }

    }

    public static InicioSesion go(UsuarioModel usuarios){
        return Tasks.instrumented(InicioSesion.class, usuarios);
    }
}
