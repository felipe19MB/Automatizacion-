package com.bg.gnt.steps.tarjetas_debito;

import com.bg.gnt.pageobjects.HomePage;
import com.bg.gnt.pageobjects.NotificacionesPage;
import com.bg.gnt.pageobjects.tarjetas_debito.LimitesDeControlPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
public class LimitesDeControlStep {
    LimitesDeControlPage limitesDeControlPage;
    HomePage homePage;
    NotificacionesPage notificacionesPage;

    @Step
    public void cambiarLimiteControl(String importe, String cantidad, String fechaVencimiento){
        limitesDeControlPage.cambiarLimiteControl(importe, cantidad, fechaVencimiento);
    }
    @Step
    public void ingresarGanapin(int ganapin){
        homePage.confirmarOperacionGanapin(ganapin);
    }

    @Step
    public void verificarMensaje(List<String> pLstDatosMensaje) {
        String mensajeExitoso 		= pLstDatosMensaje.get(0);
        notificacionesPage.verificarMensaje(mensajeExitoso);
    }
}
