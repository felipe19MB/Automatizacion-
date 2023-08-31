package bo.com.bga.certificacion.gananet.stepdefinitions.administracion;

import bo.com.bga.certificacion.gananet.models.administracion.DatosAlertaMovimientos;
import bo.com.bga.certificacion.gananet.tasks.administracion.LlenarInformacionAlerta;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresaGanaPin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.administracion.AlertaMovimientosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class AlertaMovimientosStepDefinition {

    @When("Ingresa los campos para agregar el correo de alertas")
    public void ingresaLosCamposParaAgregarElCorreoDeAlertas(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo( EjecutaBaseDeDatos.QueryPersonalizado("UPDATE AUTOSRV.AUT_AFIL_CTAS_MVTO_CREDEB SET CORREO_MVTO = 'ELIMINADODANY4DS@GMAIL.COM' WHERE CORREO_MVTO = 'DANY4DS@GMAIL.COM'", "updateCorreo","AUTOSRV") );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarInformacionAlerta.go(DatosAlertaMovimientos.setData(dataTable).get(0)),
                IngresaGanaPin.paraConfirmarTransaccion()
        );
    }

    @Then("Deberia mostrar el correo registrado para alertas")
    public void deberiaMostrarElCorreoRegistradoParaAlertas(DataTable dataTable) {
        DatosAlertaMovimientos datosAlertaMovimientos = DatosAlertaMovimientos.setData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de cuenta agregado",
                        WebElementQuestion.the(ASSERT_NUMERO_DE_CUENTA.of(datosAlertaMovimientos.getCorreo())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el correo agregado",
                        WebElementQuestion.the(ASSERT_CORREO.of(datosAlertaMovimientos.getCorreo())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el tipo de movimiento",
                        WebElementQuestion.the(ASSERT_TIPO_DE_MOVIMIENTO.of(datosAlertaMovimientos.getCorreo())), isCurrentlyVisible()
                )
        );

    }
}


