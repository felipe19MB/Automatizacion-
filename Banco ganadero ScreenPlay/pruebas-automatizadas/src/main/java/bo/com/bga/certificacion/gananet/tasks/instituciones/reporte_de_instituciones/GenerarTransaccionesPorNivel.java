package bo.com.bga.certificacion.gananet.tasks.instituciones.reporte_de_instituciones;


import bo.com.bga.certificacion.gananet.models.instituciones.TransaccionesPorNivelModel;
import bo.com.bga.certificacion.gananet.userinterfaces.instituciones.TransaccionesPorNivelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class GenerarTransaccionesPorNivel implements Task {

    String scenario;

   TransaccionesPorNivelModel transaccionesPorNivelModel;

    public GenerarTransaccionesPorNivel(TransaccionesPorNivelModel transaccionesPorNivelModel,String scenario) {
        this.scenario = scenario;
        this.transaccionesPorNivelModel = transaccionesPorNivelModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        JavaScriptClick.on(TransaccionesPorNivelPage.TIPO_TRANSACION_INSTITUCION.of(transaccionesPorNivelModel.getSubFuncionalidad())),
                        byVisibleText(transaccionesPorNivelModel.getInstitucion()).from(TransaccionesPorNivelPage.LABEL_INSTITUCIONES),
                        byVisibleText(transaccionesPorNivelModel.getGestion()).from(TransaccionesPorNivelPage. LABEL_AÑO_GESTION),
                        byVisibleText(transaccionesPorNivelModel.getNivel()).from(TransaccionesPorNivelPage.LABEL_NIVEL),
                        JavaScriptClick.on(TransaccionesPorNivelPage.BUTTON_GENERAR)

                );

                break;
        }

    }
    public static GenerarTransaccionesPorNivel go(TransaccionesPorNivelModel transaccionesPorNivelModel, String scenario){
        return Tasks.instrumented(GenerarTransaccionesPorNivel.class,transaccionesPorNivelModel,scenario);

    }

}
