package com.bg.gmv.pageobjects.girosRemesas;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class CobroGirosSinSessionPage extends BasePage{

    private final int WAIT_TIME=10;

    // Variables para documento de identificacion
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    private WebElement numeroDocumentoEditText;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement extensionTextView;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarButton;

    // Variables para Datos de Cobro Remesas
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    private WebElement claveReferenciaEditText;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    private WebElement montoEnvioEditText;

    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Seleccionar']")
    private WebElement monedaTextView;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")
    private WebElement nombreApellidoRemitenteEditText;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText")
    private WebElement nroCuentaEditText;
    // Confirmar Boton y confirmar Resumen
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarDatosButton;

    // Finalizamos comprobante
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Finalizar']")
    private WebElement finalizarButton;

    // Para Aserciones
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private WebElement montoRecibidoText;


    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView[2]")
    private WebElement nroCuentaText;

    //  Aserciones de ultima pantalla comprobante
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[3]/android.widget.TextView[2]")
    private WebElement montoMonedaFinalizar;

    public String obtenerMontoRecibidoText(){
        waitForElement(montoRecibidoText,WAIT_TIME);
        return montoRecibidoText.getText();
    }


    public String obtenerNroCuentaText(){
        waitForElement(nroCuentaText,WAIT_TIME);
        return nroCuentaText.getText();
    }

    public String obtenerMontoMonedaFinalizar(){
        waitForElement(montoMonedaFinalizar,WAIT_TIME);
        return montoMonedaFinalizar.getText();
    }


    public void ingresarDocumentoIdentidadPage(String nroDocumento, String extension){
        waitForElement(numeroDocumentoEditText,WAIT_TIME).sendKeys(nroDocumento);
        waitForElement(extensionTextView,WAIT_TIME).click();
        String opcionXpath = "//*[@class='android.widget.CheckedTextView'][@text='" + extension + "']";
        WebElement seleccionCheckedTextView = findElement(opcionXpath);
        waitForElement(seleccionCheckedTextView, WAIT_TIME).click();
    }
    public void confirmarIdentidad(){
        waitForElement(confirmarButton, WAIT_TIME).click();

    }
    public void ingresarDatosCobroRemesasPage(String claveReferencia,String montoEnvio,String moneda,String nombreApellidoRemitente, String nroCuenta){
        waitForElement(claveReferenciaEditText,WAIT_TIME).sendKeys(claveReferencia);
        waitForElement(montoEnvioEditText,WAIT_TIME).sendKeys(montoEnvio);

        waitForElement(monedaTextView,WAIT_TIME).click();
        String opcionMonedaXpath="//*[@class='android.widget.CheckedTextView'][@text='" + moneda + "']";
        WebElement seleccionMonedaCheckedTextView=findElement(opcionMonedaXpath);
        waitForElement(seleccionMonedaCheckedTextView,WAIT_TIME).click();

        waitForElement(nombreApellidoRemitenteEditText,WAIT_TIME).sendKeys(nombreApellidoRemitente);
        waitForElement(nroCuentaEditText,WAIT_TIME).sendKeys(nroCuenta);
    }

    public void confirmarDatosRemesaPage(){
        waitForElement(confirmarDatosButton,WAIT_TIME).click();

    }

    public void confirmarResumnenGiroRemesaPage(){
        waitForElement(confirmarDatosButton,WAIT_TIME).click();

    }

    public void finalizamosComprobanteGiroRemesaPage(){
        waitForElement(finalizarButton,WAIT_TIME).click();

    }
}
