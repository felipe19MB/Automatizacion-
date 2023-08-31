package com.bg.gmv.steps.sugerencias;

import com.bg.gmv.pageobjects.sugerencias.FormularioSugerencias;
import net.thucydides.core.annotations.Step;

public class SugerenciasStep {

    FormularioSugerencias formularioSugerencias;

    @Step
    public void llenarFormularioSugerencia(String nombreSugerencia) {
        formularioSugerencias.seleccionaTipoSugerencia(nombreSugerencia);
    }

    @Step
    public void llenarTextoSugerencia(String textoSugerencias) {
        formularioSugerencias.llenarFormularioSugerencia(textoSugerencias);
    }

    @Step
    public void enviarSugerencia() {
        formularioSugerencias.enviarSugerencia();
    }

    @Step
    public void aceptarSugerenciaYComentario(){
        formularioSugerencias.aceptarSugerencia();
    }
}
