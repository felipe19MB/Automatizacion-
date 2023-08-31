package bo.com.bga.certificacion.gananet.stepdefinitions.consultas_y_extractos;

import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.GenerarExtractoModel;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.consultas_y_extractos.generar_extracto.GenerarExtracto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.userinterfaces.consultas_y_extractos.GenerarExtractosPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GenerarExtractoStepDefinition {


    @When("ingresa los campos para generar el extracto")
    public void ingresaLosCamposParaGenerarElExtracto(DataTable dataTable) {
       OnStage.theActorInTheSpotlight().attemptsTo(
               GenerarExtracto.go(GenerarExtractoModel.setData(dataTable).get(0),"HappyPath")
       );

    }
    @Then("Deberia poder ver el extracto generado para el numero de transaccion{string}")
    public void deberiaPoderVerElExtractoGeneradoParaNumeroDeTransaccion(String numeroTransaccion,DataTable dataTable) {
        GenerarExtractoModel generarExtractoModel = GenerarExtractoModel.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "se verifica la descripcion del extracto", VerificarConfirmaciones.go(generarExtractoModel.getDescripcion(),VALIDAR_DESCRIPCION)
                ),
                seeThat(
                        "se verifica el debito del extracto", VerificarConfirmaciones.go(generarExtractoModel.getImporteDebitado(),VALIDAR_DEBITO)
                ),
                seeThat(
                        "se verifica el saldo disponible del extracto", VerificarConfirmaciones.go(generarExtractoModel.getSaldoDisponible(),VALIDAR_SALDO_DISPONIBLE)

                )
                );

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "Se verifica que el numero de transaccion esté en base de datos", ValidacionBaseDeDatos.esCorrecta(numeroTransaccion,"ASIENTO","resultadoBDExtracto")
                )
        );

    }



}



