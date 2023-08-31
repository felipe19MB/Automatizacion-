package bo.com.bga.certificacion.gananet.tasks.atencion_al_cliente.estado_reclamo;

import bo.com.bga.certificacion.gananet.interactions.shared.FechaActual;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;

import static bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente.RegistrarReclamoPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_REGISTRAR_RECLAMO;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class RevisarEstadoReclamo implements Task {

    private String tipo;
    String scenario;

    public RevisarEstadoReclamo(String tipo, String scenario) {
        this.tipo = tipo;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(

                        byVisibleText(tipo).from(SELECT_TIPO),
                        JavaScriptClick.on(CHECK_POR_FECHA),
                        Enter.theValue(FechaActual.obtenerFechaActual()).into(LABEL_DESDE),
                        Enter.theValue(FechaActual.obtenerFechaActual()).into(LABEL_HASTA),
                        JavaScriptClick.on(BOTON_BUSCAR)
                       // Espera.aTime(2000)
                        );
                String estado = actor.asksFor(Text.of(VALIDACION_ESTADO));
                String numeroReclamo = actor.asksFor(Text.of(VALIDACION_NUMERO_RECLAMO));
                System.out.println(estado);
                System.out.println(numeroReclamo);
                actor.remember("numeroReclamo",numeroReclamo);
                actor.remember("estado",estado);
                actor.attemptsTo(
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_REGISTRAR_RECLAMO,"resultadoBDRegistrarReclamo","GANADERO")

                );

                break;
        }

    }
    public static RevisarEstadoReclamo go(String tipo, String scenario){
        return Tasks.instrumented(RevisarEstadoReclamo.class,tipo,scenario);

    }

}
