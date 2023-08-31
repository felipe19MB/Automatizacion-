package bo.com.bga.certificacion.api.tasks.transferencia;

import bo.com.bga.certificacion.api.interactions.transferencia.ServicioTransferenciaAOtrosBancos;
import bo.com.bga.certificacion.api.interactions.transferencia.ServicioTransferenciaEntreMisCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

public class EjecuarTransferencia implements Task {

    private String transferencia;
    private String jsonBody;
    private String tipo;

    public EjecuarTransferencia(String transferencia, String jsonBody, String tipo){
        this.transferencia = transferencia;
        this.jsonBody = jsonBody;
        this.tipo = tipo;
    }
    public EjecuarTransferencia(String transferencia, String jsonBody){
        this.transferencia = transferencia;
        this.jsonBody = jsonBody;
        this.tipo = tipo;
    }

    @Title("Se ejecuta la transferencia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(jsonBody);
        switch (transferencia){
            case "TRANSFERENCIA":
                actor.attemptsTo(
                        ServicioTransferenciaEntreMisCuentas.servicio(jsonBody)
                );
                break;
            case "OTROS BANCOS":
                actor.attemptsTo(
                        ServicioTransferenciaAOtrosBancos.servicio(jsonBody,tipo)
                );
                break;
            default:
                break;
        }

    }
    public static EjecuarTransferencia transferencia(String jsonBody){
        return Tasks.instrumented(EjecuarTransferencia.class, "TRANSFERENCIA", jsonBody);
    }

    public static EjecuarTransferencia otrosBancos(String jsonBody, String tipo){
        return Tasks.instrumented(EjecuarTransferencia.class, "OTROS BANCOS", jsonBody, tipo);
    }
}
