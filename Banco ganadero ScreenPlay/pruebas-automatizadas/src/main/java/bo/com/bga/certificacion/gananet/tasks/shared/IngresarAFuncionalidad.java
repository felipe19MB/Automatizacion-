package bo.com.bga.certificacion.gananet.tasks.shared;


import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.models.shared.DatosRutaFuncionalidad;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class IngresarAFuncionalidad implements Task {

      DatosRutaFuncionalidad datosFuncionalidad;

    public IngresarAFuncionalidad(DatosRutaFuncionalidad datosFuncionalidad) {
        this.datosFuncionalidad = datosFuncionalidad;
    }

    public <T extends Actor> void performAs(T actor) {

     actor.attemptsTo(
             JavaScriptClick.on(HomePage.PERFIL_LISTA),
             JavaScriptClick.on(HomePage.PERFIL_CHOOSE.of(datosFuncionalidad.getPerfil())),
             WaitUntil.the(HomePage.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(35).seconds(),
             JavaScriptClick.on(HomePage.MODULO.of(datosFuncionalidad.getModulo())),
             Espera.aTime(1000),
             JavaScriptClick.on(HomePage.FUNCIONALIDAD.of(datosFuncionalidad.getFuncionalidad()))
     );


    }
    public static IngresarAFuncionalidad go(DatosRutaFuncionalidad datosFuncionalidad){
        return Tasks.instrumented(IngresarAFuncionalidad.class,datosFuncionalidad);

    }
}
