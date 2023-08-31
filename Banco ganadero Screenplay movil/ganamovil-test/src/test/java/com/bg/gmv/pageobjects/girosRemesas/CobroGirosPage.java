package com.bg.gmv.pageobjects.girosRemesas;

import com.bg.gmv.pageobjects.BasePage;
import com.bg.gmv.util.Constants.SolicitudConsumaxConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class CobroGirosPage extends BasePage {

    private final int WAIT_TIME = 10;

    @FindBy(className = "android.widget.EditText")
    private WebElement referenciaRemesaTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button[2]")
    private WebElement buscarButton;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarButton;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Finalizar']")
    private WebElement finalizarComprobanteButton;

    // Para Aserciones
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]")
    private WebElement importeRecibidoP1Text;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private WebElement importeRecibidoP2Text;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[3]/android.widget.TextView[2]")
    private WebElement importeRecibidoP3Text;

    public String importeRecibidoP1Text() {
        //waitFor(SolicitudConsumaxConstants.getTinyWaitTime()).seconds();
        waitForElement(importeRecibidoP1Text,WAIT_TIME);
        return importeRecibidoP1Text.getText();
    }

    public String importeRecibidoP2Text() {
        waitForElement(importeRecibidoP2Text,WAIT_TIME);
        return importeRecibidoP2Text.getText();
    }

    public String importeRecibidoP3Text() {
        waitForElement(importeRecibidoP3Text,WAIT_TIME);
        return importeRecibidoP3Text.getText();
    }

    public void ingresarReferenciaRemesa(String referenciaRemesa) {
        waitForElement(referenciaRemesaTextBox,WAIT_TIME).sendKeys(referenciaRemesa);
    }

    public void buscarReferencia(){
        waitForElement(buscarButton, WAIT_TIME).click();
    }

    public void confirmar(){
        waitForElement(confirmarButton, WAIT_TIME).click();
    }

    public void finalizarComprobanteDeposito(){waitForElement(finalizarComprobanteButton,WAIT_TIME).click();}

}
