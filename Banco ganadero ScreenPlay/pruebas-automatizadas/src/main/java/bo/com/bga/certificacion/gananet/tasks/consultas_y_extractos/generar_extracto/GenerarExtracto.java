package bo.com.bga.certificacion.gananet.tasks.consultas_y_extractos.generar_extracto;

import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.GenerarExtractoModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.GenerarExtractosPage;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.GenerarExtractosPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_GENERACION_EXTRACTOS_NUMERO_TRANSACCION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class GenerarExtracto implements Task {
    GenerarExtractoModel generarExtractoModel;
    String scenario;

    public GenerarExtracto(GenerarExtractoModel generarExtractoModel, String scenario) {
        this.generarExtractoModel = generarExtractoModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        JavaScriptClick.on(GenerarExtractosPage.CHECK_BOX_CUENTA.of(generarExtractoModel.getCuenta())),
                        JavaScriptClick.on(GenerarExtractosPage.BOTON_SIGUIENTE),
                        JavaScriptClick.on(GenerarExtractosPage.CHECK_FILTRO.of(generarExtractoModel.getPeriodoFiltro())),
                        Enter.theValue(generarExtractoModel.getDesde()).into(FECHA_DESDE),
                        Enter.theValue(generarExtractoModel.getHasta()).into(FECHA_HASTA),
                        JavaScriptClick.on(GenerarExtractosPage.BOTON_BUSCAR),
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds()


                        );
                Integer numeroTransaccion = Integer.parseInt(VALIDAR_NUMERO_TRANSACCION.resolveFor(actor).getTextContent().toString());
                String l_p_nombre = "l_p_nombre";
                int l_p_numero = 2225;
                String query = "DECLARE\n" +
                        "    l_p_numero NUMBER := " + l_p_numero + ";\n" +
                        "BEGIN\n" +
                        "    SP_NOMBRE_MONEDA (l_p_numero, :" + l_p_nombre + ");\n" +
                        "END;";
                actor.attemptsTo(
                    EjecutaBaseDeDatos.QueryPersonalizado(query,"resultadoBDExtracto","GANADERO").
                            Comentario("Se ejecuta el query para obtener el numero de transaccion del extracto")


                        );

                break;
        }

    }
    public static GenerarExtracto go(GenerarExtractoModel generarExtractoModel,String scenario){
        return Tasks.instrumented(GenerarExtracto.class,generarExtractoModel,scenario);

    }

}
