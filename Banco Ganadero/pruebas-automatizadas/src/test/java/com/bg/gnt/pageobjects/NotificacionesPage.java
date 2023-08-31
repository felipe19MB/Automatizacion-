package com.bg.gnt.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
public class NotificacionesPage extends NewBasePage{
    public NotificacionesPage(WebDriver driver) {
        super(driver);
    }
    By gWefLblMensaje = By.xpath("//div[@id='swal2-content']");
    By gWefBtnAceptar = By.xpath("//button[text()='OK']");

    public NotificacionesPage verificarMensaje(String pLstDatosMensaje) {
        assertThat(readText(gWefLblMensaje), containsString(pLstDatosMensaje));
        clickJs(gWefBtnAceptar);
        return this;
    }
}
