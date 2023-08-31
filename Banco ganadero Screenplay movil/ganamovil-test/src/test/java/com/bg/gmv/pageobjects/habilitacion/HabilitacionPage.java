package com.bg.gmv.pageobjects.habilitacion;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.locators.WaitForWebElementCollection;
import org.openqa.selenium.WebElement;

public class HabilitacionPage extends BasePage {
    private final String registroExitosoText = "Registro Exitoso";

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Si']")
    private WebElement siButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Registro Exitoso']")
    private WebElement registroExitosoTextElement;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Aceptar']")
    private WebElement aceptarButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Bienvenido(a)']")
    private WebElement bienvenidoTextElement;

    public String getRegistroExitosoText() {
        return registroExitosoText;
    }


    public void clickSi() {
        waitForElement(siButton, 10);
        siButton.click();
    }

    public void clickAceptar() {
        waitForElement(aceptarButton, 10);
        aceptarButton.click();
    }

    public String obtenerTextoRegistroExitoso() {
        waitForElement(registroExitosoTextElement, 10);
        return registroExitosoTextElement.getText();
    }

    public String obtenerTextoBienvenido() {
        waitForElement(bienvenidoTextElement, 10);
        return bienvenidoTextElement.getText();
    }

}
