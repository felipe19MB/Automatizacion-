package bo.com.bga.certificacion.api.tasks.transferencia.preCondicion;

import bo.com.bga.certificacion.api.tasks.compartida.EjecutarBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InsertarCuenta implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
       Map<String, Object> valores = new HashMap<>();
        valores.put("EBCTENITM", 81285);
        valores.put("EBCTEFREG", "01-06-2023");
        valores.put("EBCTECPER", 172628);
        valores.put("EBCTECUSR", "172628");
        valores.put("EBCTECPED", 222740);
        valores.put("EBCTECTAD", "1051185944");
        valores.put("EBCTEREFE", "caja bancaria");
        valores.put("EBCTEMRCB", 0);
        valores.put("EBCTERIDE", 37945548);
        valores.put("TZ_LOCK", 0);
        String PRUEBASQL = "INSERT INTO GANANET.GNT_CUENTASDETERCEROS VALUES (81285, SYSDATE, 172628, '172628', 222740, '1051185944', 'caja bancaria', 0, 37945548, 0)";
        theActorInTheSpotlight().attemptsTo(
                EjecutarBaseDeDatos.QueryPersonalizado(PRUEBASQL, "InsertTercero", "GANANET")
        );
    }

    public static InsertarCuenta cuentaTercero(){
        return Tasks.instrumented(InsertarCuenta.class);
    }
}
