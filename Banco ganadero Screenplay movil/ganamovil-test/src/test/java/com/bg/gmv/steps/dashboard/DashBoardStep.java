package com.bg.gmv.steps.dashboard;

import com.bg.gmv.pageobjects.dashboard.DashBoardPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DashBoardStep {

    DashBoardPage DashBoardPage;
    @Step
    public void ingresarOpcion(List<String> pLstOpciones) {
        DashBoardPage.cancelarPromociones();
        DashBoardPage.ingresarOpcion(pLstOpciones);
    }
    @Step
    public void verificarUsuario(List<String> pListNombre) {
        String lStrNombre = DashBoardPage.getNombre();
        assertThat(lStrNombre, containsString(pListNombre.get(0)));

    }
    @Step
    public void cerrarSesion(List<String> pLstMensaje){
        String lStrTexto = pLstMensaje.get(0);
        DashBoardPage.clicCerrarSesion();
        String lStrMensaje = DashBoardPage.getMensaje();
        assertThat(lStrMensaje,containsString(lStrTexto));
        DashBoardPage.clicSi();
    }
}
