package com.bg.gnt.steps.atencionCliente;

import com.bg.gnt.pageobjects.atencionCliente.SugerenciasPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import net.thucydides.core.annotations.Step;

public class SugerenciasStep {

    SugerenciasPage sugerenciasPage;
    @Step
    public void registrarCorreo(String correo){
        sugerenciasPage.registrarCorreo(correo);
    }
    @Step
    public void registrarDescripcion(String descripcion){
        sugerenciasPage.registrarDescripcion(descripcion);
    }
    @Step
    public void clicAceptar(){
        sugerenciasPage.clicAceptar();
    }
    @Step
    public void verificarMensajeConfirmacion(String mensaje){
        String mensajeAlerta = sugerenciasPage.obtenerMensaje();
        assertThat(mensajeAlerta, containsString(mensaje));
    }



}
