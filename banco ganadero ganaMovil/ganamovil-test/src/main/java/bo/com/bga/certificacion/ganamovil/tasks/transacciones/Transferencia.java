package bo.com.bga.certificacion.ganamovil.tasks.transacciones;

import bo.com.bga.certificacion.ganamovil.interactions.transacciones.*;
import bo.com.bga.certificacion.ganamovil.models.TransferenciaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

public class Transferencia implements Task {

    private String transferenciaItem;
    private TransferenciaModel transferenciaModel;

    public Transferencia(String transferenciaItem, TransferenciaModel transferenciaModel) {
        this.transferenciaItem = transferenciaItem;
        this.transferenciaModel = transferenciaModel;
    }

    @Title("Se realiza la transferencia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ConsultarSaldo.consultar("saldoBefore",transferenciaModel.getCuentaorigen()));
        switch (transferenciaItem) {
            case "Transferencia Entre Mis Cuentas":
                actor.attemptsTo(
                        DiligenciarEntreMisCuentas.diligenciar(transferenciaModel)
                );
                break;
            case "Transferencia Otros Bancos":
                actor.attemptsTo(
                        DiligenciarOtrosBancos.diligenciar(transferenciaModel)
                );
                break;
            case "Transferencia a Terceros":
                actor.attemptsTo(
                        DiligenciarTerceros.diligenciar(transferenciaModel)
                );
                break;
            case "Billetera Yolo":
                actor.attemptsTo(
                        DiligenciarYolo.diligenciar(transferenciaModel)
                );
                break;
            case "Nuevo destinatario":
                actor.attemptsTo(
                        DiligenciarNDestinatario.diligenciar(transferenciaModel)
                );
                break;
            default:
                break;
        }
        actor.attemptsTo(ConsultarSaldo.consultar("saldoAfter",transferenciaModel.getCuentaorigen()));
    }

    public static Transferencia diligenciarEntreMisCuentas(TransferenciaModel transferenciaModel) {
        return Tasks.instrumented(Transferencia.class, "Transferencia Entre Mis Cuentas", transferenciaModel);
    }

    public static Transferencia diligenciarOtrosBancos(TransferenciaModel transferenciaModel) {
        return Tasks.instrumented(Transferencia.class, "Transferencia Otros Bancos", transferenciaModel);
    }

    public static Transferencia diligenciarTerceros(TransferenciaModel transferenciaModel) {
        return Tasks.instrumented(Transferencia.class, "Transferencia a Terceros", transferenciaModel);
    }
    public static Transferencia nuevoDestinatario(TransferenciaModel transferenciaModel){
        return Tasks.instrumented(Transferencia.class, "Nuevo destinatario", transferenciaModel);
    }

    public static Transferencia diligenciarBilletera(TransferenciaModel transferenciaModel){
        return Tasks.instrumented(Transferencia.class, "Billetera Yolo", transferenciaModel);
    }
}
