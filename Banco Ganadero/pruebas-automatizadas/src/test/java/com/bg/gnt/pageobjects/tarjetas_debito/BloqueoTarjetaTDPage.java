package com.bg.gnt.pageobjects.tarjetas_debito;

import com.bg.gnt.pageobjects.NewBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class BloqueoTarjetaTDPage extends NewBasePage {
    public BloqueoTarjetaTDPage(WebDriver driver) {
        super(driver);
    }
    By ingresaMotivoTextBoxBy = By.xpath("//app-bloqueo-tarjetas-debito[1]//control-input-textarea[1]//textarea[1]");
    By bloquearBtnBy = By.xpath("//button[contains(text(),'Bloquear')]");
    public BloqueoTarjetaTDPage bloquearTarjetaTD() {
        waitForElementToBeClickable(ingresaMotivoTextBoxBy);
        writeText(ingresaMotivoTextBoxBy, "Prueba Automatizada");
        clickJs(bloquearBtnBy);
        return this;
    }
}
