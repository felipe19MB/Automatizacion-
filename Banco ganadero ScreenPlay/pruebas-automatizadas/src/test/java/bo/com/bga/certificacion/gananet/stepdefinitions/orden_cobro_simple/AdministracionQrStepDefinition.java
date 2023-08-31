package bo.com.bga.certificacion.gananet.stepdefinitions.orden_cobro_simple;

import bo.com.bga.certificacion.gananet.interactions.shared.CerrarModal;
import bo.com.bga.certificacion.gananet.models.orden_cobro_simple.DatosAdministracionQr;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.orden_cobro_simple.administracion_qr.EliminarCuenta;
import bo.com.bga.certificacion.gananet.tasks.orden_cobro_simple.administracion_qr.HabilitarCuenta;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;
import static bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr.AdministracionQrPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.QUERY_AFILIACION_CUENTA_QR;

public class AdministracionQrStepDefinition {
    @When("Habilita una cuenta propia para app cobros qr")
    public void habilitaUnaCuentaPropiaParaAppCobrosQr(DataTable dataTable) {
        DatosAdministracionQr datosAdministracionQr = DatosAdministracionQr.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_AFILIACION_CUENTA_QR+datosAdministracionQr.getUsuario()+" AND REFERENCIA_CUENTA = '"+datosAdministracionQr.getReferencia()+"'","resultadosObtenidos", "GANADERO")
                        .Comentario("Se ejecuta el query para desafiliar una cuenta para cobro qr")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                HabilitarCuenta.go(DatosAdministracionQr.setData(dataTable).get(0),"HappyPath")
        );
    }
    @Then("Deberia ver un mensaje de registro exitoso")
    public void deberiaVerUnMensajeDeRegistroExitoso(DataTable dataTable) {
        DatosAdministracionQr datosAdministracionQr = DatosAdministracionQr.setData(dataTable).get(0);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(datosAdministracionQr.getMensaje(), MODAL_CONFIRMACION)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarModal.go()
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Debería ver el numero de cuenta agregado",
                        VerificarConfirmaciones.go(datosAdministracionQr.getNroCuenta(),ASSERT_CUENTA.of(datosAdministracionQr.getNroCuenta()))
                ),
                GivenWhenThen.seeThat("Debería ver el estado de la habilitacion",
                        VerificarConfirmaciones.go("Activo",ASSERT_ESTADO.of(datosAdministracionQr.getNroCuenta()))
                ),
                GivenWhenThen.seeThat("Debería ver la fecha de expiracion seleccionada",
                        VerificarConfirmaciones.go("Vence en "+datosAdministracionQr.getFechaVencimiento(),ASSERT_EXPIRACION.of(datosAdministracionQr.getNroCuenta()))
                ),
                GivenWhenThen.seeThat("Debería ver el nombre de referencia agregado",
                        VerificarConfirmaciones.go(datosAdministracionQr.getReferencia(),ASSERT_REFERENCIA.of(datosAdministracionQr.getNroCuenta()))
                ),
                GivenWhenThen.seeThat("Debería ver el tipo de uso seleccionado",
                        VerificarConfirmaciones.go(datosAdministracionQr.getUso(),ASSERT_USO.of(datosAdministracionQr.getNroCuenta()))
                ),
                GivenWhenThen.seeThat("Debería ver la actualización exitosa en tabla CAS_QR_CUENTA en base de datos",
                        ValidacionBaseDeDatos.esCorrecta(datosAdministracionQr.getReferencia(),"REFERENCIA_CUENTA","CONSULTADBQRCUENTA")
                        )
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarCuenta.go(DatosAdministracionQr.setData(dataTable).get(0))
        );
    }
}
