package bo.com.bga.certificacion.gananet.stepdefinitions.acceso;

import bo.com.bga.certificacion.gananet.models.acceso.DatosActualizacionClave;
import bo.com.bga.certificacion.gananet.models.shared.DatosIngreso;
import bo.com.bga.certificacion.gananet.questions.shared.ValidacionBaseDeDatos;
import bo.com.bga.certificacion.gananet.questions.shared.VerificarConfirmaciones;
import bo.com.bga.certificacion.gananet.tasks.acceso.CambiarClaves;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.tasks.shared.IngresarAGananet;
import bo.com.bga.certificacion.gananet.tasks.acceso.RecuperarCredenciales;
import bo.com.bga.certificacion.gananet.tasks.acceso.RecuperarCredencialesPassword;
import bo.com.bga.certificacion.gananet.userinterfaces.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static bo.com.bga.certificacion.gananet.models.acceso.DatosIngresoAcceso.setData;
import static bo.com.bga.certificacion.gananet.userinterfaces.InicioSesionPage.MODAL_CONFIRMACION;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AccesoStepDefinitions {
    @Managed
    private WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cliente");
    }

    @Given("Ingresa a la pagina de Gananet")
    public void ingresoALaPaginaDeGananet(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://devganamovil.bg.com.bo/apps/GanaNet/#_Site")
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado("UPDATE CLI_PERSONASFISICAS SET EMAIL = 'macontreras@bg.com.bo' WHERE NUMEROPERSONAFISICA = " + dataTable.cell(0, 0) + "","resultadosObtenidos", "GANADERO")
        );
    }

    @Given("El cliente quiere recuperar su contraseña por olvido")
    public void ingresoPaginaDeGananet() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://devganamovil.bg.com.bo/apps/GanaNet/#_Site")

        );
    }

    @When("Ingreso email y Ganapin")
    public void ingresSuEmailGanapin(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RecuperarCredenciales.credentials(setData(dataTable).get(0)));
    }

    @When("Ingresa su usuario y Ganapin")
    public void ingresoSuUsuario(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RecuperarCredencialesPassword.credentials(setData(dataTable).get(0)));
    }

    @Then("Deberia ver un mensaje de confirmacion")
    public void verificaMensaje(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("Verificar Mensaje de Confirmacion", VerificarConfirmaciones.go(dataTable.cell(0, 0),MODAL_CONFIRMACION)));
        if (dataTable.cells().size() > 1) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    EjecutaBaseDeDatos.QueryPersonalizado("UPDATE AUTOSRV.AUT_USUARIOS SET REQ_CAMBIO_CLAVE = 'N' WHERE NRO_PERSONA = " + dataTable.cell(0, 1) + "","resultadosObtenidos", "GANADERO"),
                    EjecutaBaseDeDatos.QueryPersonalizado("UPDATE AUTOSRV.AUT_USUARIOS SET CLAVE_ACCESO='D44559F602EAB6FD62AC7680DACBFAADD13630335E951F97AF390E9DE176B6DB28512F2E0B9D4FBA5133E8B1C6E8DF59DB3A8AB9D60BE4B97CC9E81DB' WHERE NRO_PERSONA=" + dataTable.cell(0, 1) + "","resultadosObtenidos", "GANADERO")
            );
        }
    }

    @Given("El cliente actualiza la DB para que permita hacer el cambio de clave")
    public void elClienteActualizaLaDBParaQuePermitaHacerElCambioDeClave() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZACION_CLAVE,"resultadosObtenidos","GANADERO")
        );
    }
    @When("ingresa los campos de actualizacion de la clave")
    public void ingresaLosCamposDeActualizacionDeLaClave(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CambiarClaves.go(DatosActualizacionClave.setData(dataTable).get(0))
        );
    }
    @When("ingresa a la pagina de gananet con las nuevas credenciales")
    public void  ingresaALaPaginaDeGananetConLasNuevasCredenciales(DataTable dataTable1) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAGananet.withCredentials(DatosIngreso.setData(dataTable1).get(0))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_CLAVE_TRANSSACIONAL_SELECT,"resultadosObtenidos","GANADERO")
        );

    }
    @Then("^Deberia poder ver el (.*) del usuario y la (.*) actualizada en bd$")
    public void DeberiaPoderVerElNombreDelUsuarioYLaCalveTransaccionalActualizadaEnbd(String nombre,String claveTransaccional) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("valido que si se inicio sesion con mi nombre",VerificarConfirmaciones.go(nombre,HomePage.NOMBRE_USUARIO), Matchers.is(true)));

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("valido la clave transaccional en base de datos", ValidacionBaseDeDatos.esCorrecta(claveTransaccional,"CLAVE_TRANSACCIONAL","resultadosObtenidos"), Matchers.is(true)));

        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado(QUERY_ACTUALIZACION_CLAVE_RESET,"resultadosObtenidos","GANADERO")
        );
    }


}
