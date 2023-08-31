package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;


import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Title;

import java.util.HashMap;
import java.util.Map;

public class RequiereDosPersonasParaLaFirma implements Task {

    private String persona;
    private String cuenta;

    public RequiereDosPersonasParaLaFirma(String persona, String cuenta){
        this.persona = persona;
        this.cuenta = cuenta;
    }

    @Title("Se configura la cuenta para requerir dos personas para la firma")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> condiciones = new HashMap<>();
        condiciones.put("CUENTA", cuenta);
        condiciones.put("CODPERSONA", persona);
        Map<String, Object> valores = new HashMap<>();
        valores.put("COMBINACION", "2");
        valores.put("IMPORTE", "0");
        actor.attemptsTo(EjecutarBaseDeDatos.Actualizar("GNT_FIRMAS",condiciones,valores,"GANADERO"));
    }

    public static RequiereDosPersonasParaLaFirma requiereDosPersonasParaLaFirma(String persona, String cuenta){
        return Tasks.instrumented(RequiereDosPersonasParaLaFirma.class, persona, cuenta);
    }
}
