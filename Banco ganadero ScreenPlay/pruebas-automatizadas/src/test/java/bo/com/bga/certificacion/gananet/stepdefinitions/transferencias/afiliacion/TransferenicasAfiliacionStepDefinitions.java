package bo.com.bga.certificacion.gananet.stepdefinitions.transferencias.afiliacion;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.interactions.transferencias.afiliaciones.*;
import bo.com.bga.certificacion.gananet.models.transferencias.DatosAfiliacionCuentas;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.transferencias.afiliaciones.EliminarCuentasAfiliaciones;
import bo.com.bga.certificacion.gananet.tasks.transferencias.afiliaciones.LlenarCamposCuentasAfiliaciones;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;
import static bo.com.bga.certificacion.gananet.userinterfaces.transferencias.AfiliacionesPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_AFILIACION_CUENTA;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_PLANILLA_ESTADO_RECHAZADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TransferenicasAfiliacionStepDefinitions {
    @When("Registra la nueva cuenta de otro banco")
    public void registraLaNuevaCuentaDeOtroBanco(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_AFILIACION_CUENTA+datosAfiliacionCuentas.getUsuario()+" AND NRO_CUENTA_DESTINO = "+datosAfiliacionCuentas.getNroCuenta()+"","resultadosObtenidos", "AUTOSRV")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarCamposCuentasAfiliaciones.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @Then("Deberia ver un mensaje de afiliacion exitosa")
    public void deberiaVerUnMensajeDeAfiliacionExitosa(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(datosAfiliacionCuentas.getMensaje(), MODAL_CONFIRMACION)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarModal.go()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de cuenta agregado",
                        WebElementQuestion.the(ASSERT_NUMERO_CUENTA.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre de la entidad agregado",
                        WebElementQuestion.the(ASSERT_ENTIDAD.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el alias agregado",
                        WebElementQuestion.the(ASSERT_ALIAS.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre del titular agregado",
                        WebElementQuestion.the(ASSERT_TITULAR.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarCuentasAfiliadas.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @When("Registra la nueva cuenta de terceros")
    public void registraLaCuentaDeTerceros(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_AFILIACION_CUENTA+datosAfiliacionCuentas.getUsuario()+" AND NRO_CUENTA_DESTINO = "+datosAfiliacionCuentas.getNroCuenta()+"","resultadosObtenidos", "AUTOSRV")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarCamposCuentasAfiliaciones.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @When("Registra la nueva cuenta de billetera")
    public void registraLaNuevaCuentaDeBilletera(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_AFILIACION_CUENTA+datosAfiliacionCuentas.getUsuario()+" AND NRO_CUENTA_DESTINO = "+datosAfiliacionCuentas.getTelefono()+"","resultadosObtenidos", "AUTOSRV")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarCamposCuentasAfiliaciones.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @Then("Deberia ver un mensaje de guardado satisfactoriamente")
    public void deberiaVerUnMensajeDeGuardadoSatisfactoriamente(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(datosAfiliacionCuentas.getMensaje(), MODAL_CONFIRMACION)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarModal.go()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de cuenta agregado",
                        WebElementQuestion.the(ASSERT_NUMERO_CUENTA.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el alias agregado",
                        WebElementQuestion.the(ASSERT_ALIAS.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre del titular agregado",
                        WebElementQuestion.the(ASSERT_TITULAR_TERCEROS.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el tipo de caja de cuenta",
                        WebElementQuestion.the(ASSERT_TIPO_CUENTA.of(datosAfiliacionCuentas.getNroCuenta())), isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarCuentasAfiliaciones.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @Then("Deberia ver un mensaje de cuenta adicionado satisfactoriamente")
    public void deberiaVerUnMensajeDeCuentaAdicionadoSatisfactoriamente(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(datosAfiliacionCuentas.getMensaje(), MODAL_CONFIRMACION)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarModal.go()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de cuenta agregado",
                        WebElementQuestion.the(ASSERT_NUMERO_CUENTA.of(datosAfiliacionCuentas.getTelefono())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el alias agregado",
                        WebElementQuestion.the(ASSERT_ALIAS.of(datosAfiliacionCuentas.getTelefono())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el nombre del titular agregado",
                        WebElementQuestion.the(ASSERT_TITULAR_TERCEROS.of(datosAfiliacionCuentas.getTelefono())), isCurrentlyVisible()
                ),
                GivenWhenThen.seeThat("Debería ver el tipo de caja de cuenta",
                        WebElementQuestion.the(ASSERT_TIPO_CUENTA.of(datosAfiliacionCuentas.getTelefono())), isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarCuentasAfiliadas.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @When("Registra la nueva cuenta del exterior")
    public void registraLaNuevaCuentaDelExterior(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_AFILIACION_CUENTA+datosAfiliacionCuentas.getUsuario()+" AND NRO_CUENTA_DESTINO = '"+datosAfiliacionCuentas.getCuentaIBAN()+"'","resultadosObtenidos", "AUTOSRV")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarCamposCuentasAfiliaciones.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
    @Then("Deberia ver un mensaje de guardado satisfactoriamente de cuenta del exterior")
    public void deberiaVerUnMensajeDeGuardadoSatisfactoriamenteCuentaExterna(DataTable dataTable) {
        DatosAfiliacionCuentas datosAfiliacionCuentas = DatosAfiliacionCuentas.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(datosAfiliacionCuentas.getMensaje(), MODAL_CONFIRMACION)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarModal.go()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de cuenta agregado",
                        WebElementQuestion.the(ASSERT_NUMERO_CUENTA.of(datosAfiliacionCuentas.getNombreAfiliado())), isCurrentlyVisible()
                )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarCuentasAfiliadas.go(DatosAfiliacionCuentas.setData(dataTable).get(0))
        );
    }
}

