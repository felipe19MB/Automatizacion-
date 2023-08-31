package bo.com.bga.certificacion.api.tasks.acceso;

import bo.com.bga.certificacion.api.interactions.acceso.ServicioObtenerSesion;
import bo.com.bga.certificacion.api.interactions.acceso.ServicioValidarClave;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;


public class EjecutarAcceso implements Task {

    private final String servicio;
    private final String data;

    public EjecutarAcceso(String servicio, String data){

        this.servicio = servicio;
        this.data = data;
    }

    @Title("Ejecuta el acceso")
    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (servicio){
            case "Obtener Sesion":
                actor.attemptsTo(
                      ServicioObtenerSesion.service(data)
                );
                break;
            case "Validar Clave":
                actor.attemptsTo(
                        ServicioValidarClave.service(data)
                );
                break;
            default:
                break;
        }
    }

    public static EjecutarAcceso obtenerSesion(String data){
        return Tasks.instrumented(EjecutarAcceso.class, "Obtener Sesion",  data);
    }

    public static EjecutarAcceso validarClave(String data){
        return Tasks.instrumented(EjecutarAcceso.class, "Validar Clave", data);
    }

}
