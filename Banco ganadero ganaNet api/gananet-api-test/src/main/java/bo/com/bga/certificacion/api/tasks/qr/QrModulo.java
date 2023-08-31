package bo.com.bga.certificacion.api.tasks.qr;

import bo.com.bga.certificacion.api.interactions.qr.OrdenDeCobro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class QrModulo implements Task {

    private String tipo;
    private String jsonBody;

    public QrModulo(String tipo, String jsonBody){
        this.tipo = tipo;
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo){
            case "ORDEN DE COBRO":
                actor.attemptsTo(
                        OrdenDeCobro.servicio(jsonBody)
                );
                break;
            default:
                break;
        }
    }

    public static QrModulo ordenDeCobro(String jsonBody){
        return Tasks.instrumented(QrModulo.class, "ORDEN DE COBRO", jsonBody);
    }
}
