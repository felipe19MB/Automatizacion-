package bo.com.bga.certificacion.gananet.stepdefinitions.consultas_y_extractos;

import bo.com.bga.certificacion.gananet.models.consultas_y_extractos.ExtractoAgendadoMT940Model;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionString;
import bo.com.bga.certificacion.gananet.tasks.consultas_y_extractos.extracto_agendado_mt940.AgregarCuentaMT940;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ExtractoAgendadoMT940StepDefinition {

    @When("agrega la cuenta MT940")
    public void agregarLaCuentaMT940(DataTable dataTable) {
        ExtractoAgendadoMT940Model extractoAgendadoMT940Model=ExtractoAgendadoMT940Model.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarCuentaMT940.go(ExtractoAgendadoMT940Model.setData(dataTable).get(0),"HappyPath")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CONSULTAR_CUENTA_MT940+extractoAgendadoMT940Model.getUsuario()+" AND HABILITADO='S'","resultadoCuentaMT940Agregada","GANADERO").
                        Comentario("Se ejecuta el query para optener el limite de transacciones permitidas"),
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZAR__CUENTA_MT940+extractoAgendadoMT940Model.getUsuario()+" AND HABILITADO='S' AND COD_SWIFT_BCO_DESTINO = "+ "'"+extractoAgendadoMT940Model.getCodigoSwift()+"'","resultadoUpdateCuentaMT940Agregada","GANADERO").
                        Comentario("Se ejecuta el query para optener el limite de transacciones permitidas")
        );


    }

    @Then("Deberia poder el {string} de cuenta agregada correctamente")
    public void deberiaPoderElDeCuentaAgregadaCorrectamente(String mensaje,DataTable dataTable) {
        ExtractoAgendadoMT940Model extractoAgendadoMT940Model=ExtractoAgendadoMT940Model.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(
                seeThat("Se verifica el mensaje de la cuenta mt940 creada", ValidacionString.esCorrecta(mensaje,"mensajeCuentaCreada")
                ),
                seeThat("Se verifica el estado de la cuenta en base de datos", ValidacionBaseDeDatos.esCorrecta("S","HABILITADO","resultadoCuentaMT940Agregada")
                ),
                seeThat("Se verifica el codigoSwift en base de datos", ValidacionBaseDeDatos.esCorrecta(extractoAgendadoMT940Model.getCodigoSwift(),"COD_SWIFT_BCO_DESTINO","resultadoCuentaMT940Agregada")
                )


        );
    }
}
