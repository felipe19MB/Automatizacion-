package com.bg.gmv.definitions.sugerencias;

import com.bg.gmv.pageobjects.sugerencias.FormularioSugerencias;
import com.bg.gmv.steps.sugerencias.SugerenciasStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SugerenciasDefinition {

    FormularioSugerencias formularioSugerencias;

    @Steps
    SugerenciasStep sugerenciasSteps;

    @And("^Selecciono la opcion \"(.*)\"$")
    public void seleccionoLaOpcionAtencionAlClienteUsuario(String tipoSugerencia) {
        sugerenciasSteps.llenarFormularioSugerencia(tipoSugerencia);
    }

    @And("^lleno la descripcion de la sugerencia que voy a enviar \"(.*)\"$")
    public void llenoLaDescripcionDeLaSugerenciaQueVoyAEnviar(String textoSugerencia) {
        sugerenciasSteps.llenarTextoSugerencia(textoSugerencia);
    }

    @When("^realizo un click en el boton enviar$")
    public void realizoUnClickEnElBotonEnviar() {
        sugerenciasSteps.enviarSugerencia();
    }

    @Then("^muestra un mensaje de confirmacion que dice Sugerencias y comentarios$")
    public void muestraUnMensajeDeConfirmacionQueDiceSugerenciasYComentarios() {
        assertThat(formularioSugerencias.obtenerTextoSugerenciasComentarios(), containsString("Sugerencias y comentarios"));
    }

    @Then("^realizo click en el boton aceptar buzon de sugerencia$")
    public void realizoClickEnElBotonAceptarBuzonDeSugerencia() {
        sugerenciasSteps.aceptarSugerenciaYComentario();
    }
}
