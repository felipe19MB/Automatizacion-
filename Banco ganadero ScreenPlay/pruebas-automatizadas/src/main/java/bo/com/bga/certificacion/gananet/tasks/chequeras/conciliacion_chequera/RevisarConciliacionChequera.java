package bo.com.bga.certificacion.gananet.tasks.chequeras.conciliacion_chequera;


import bo.com.bga.certificacion.gananet.models.chequeras.ConciliacionChequeraModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.ConciliacionChequeraPage.*;


public class RevisarConciliacionChequera implements Task {

    String scenario;

   ConciliacionChequeraModel conciliacionChequeraModel;

    public RevisarConciliacionChequera(ConciliacionChequeraModel conciliacionChequeraModel,String scenario) {
        this.scenario = scenario;
        this.conciliacionChequeraModel = conciliacionChequeraModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        JavaScriptClick.on(CUENTA_DE_ORIGEN_CHECK.of(conciliacionChequeraModel.getCuentaOrigen())),
                        JavaScriptClick.on(BOTON_SIGUIENTE),
                        JavaScriptClick.on(PERIODO.of(conciliacionChequeraModel.getPeriodo())),
                        Enter.theValue(conciliacionChequeraModel.getDesde()).into(LABEL_FECHA_DESDE),
                        Enter.theValue(conciliacionChequeraModel.getHasta()).into(LABEL_FECHA_HASTA),
                        JavaScriptClick.on(BOTON_BUSCAR)

                        );


                break;
        }


    }
    public static RevisarConciliacionChequera go(ConciliacionChequeraModel conciliacionChequeraModel, String scenario){
        return Tasks.instrumented(RevisarConciliacionChequera.class,conciliacionChequeraModel,scenario);

    }

}
