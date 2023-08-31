package com.bg.gnt.definitions.atencionCliente;


import com.bg.gnt.steps.atencionCliente.SugerenciasStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class SugerenciasDefinition {
    @Steps
    SugerenciasStep sugerenciasStep;

    @And("^Envio la sugerencia con los datos requeridos$")
    public void envio_la_sugerencia_con_los_datos_requeridos(DataTable datosSugerencia) {
        List<String> lDatosSugerencia = datosSugerencia.row(0);
        String correo = lDatosSugerencia.get(0);
        String descripcion = lDatosSugerencia.get(1);
        sugerenciasStep.registrarCorreo(correo);
        sugerenciasStep.registrarDescripcion(descripcion);
        sugerenciasStep.clicAceptar();
    }

    @Then("^Obtengo un mensaje de confirmacion de registro$")
    public void obtengo_un_mensaje_de_confirmacion_de_registro(DataTable datosSugerencia){
        List<String> ldatosSugerencia = datosSugerencia.row(0);
        String mensaje = ldatosSugerencia.get(0);
        sugerenciasStep.verificarMensajeConfirmacion(mensaje);
    }




}
