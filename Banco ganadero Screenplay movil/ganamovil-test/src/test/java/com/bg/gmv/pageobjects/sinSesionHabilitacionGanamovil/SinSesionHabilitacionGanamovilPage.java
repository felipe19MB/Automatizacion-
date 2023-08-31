package com.bg.gmv.pageobjects.sinSesionHabilitacionGanamovil;


import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;


public class SinSesionHabilitacionGanamovilPage extends BasePage {
    private final int TIME_SECONDS = 50;
    private final String correoElectronicoResultadoEsperado= "Correo Electrónico (Envío de contrato)";

    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Habilitación de GanaMóvil']")
    private WebElement habilitacionGanamovilButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText")
    private WebElement ciTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")
    private WebElement extensionTextView;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText[1]")
    private WebElement diaNacimientoTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText[2]")
    private WebElement mesNacimientoTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText[3]")
    private WebElement anoNacimientoTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")
    private WebElement celularTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
    private WebElement nroTarjeta1TextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
    private WebElement nroTarjeta2TextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]")
    private WebElement nroTarjeta3TextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]")
    private WebElement nroTarjeta4TextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
    private WebElement mesExpiracionTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
    private WebElement anoExpiracionTextBox;

    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Correo Electrónico (Envío de contrato)']")
    private WebElement correoElectronicoTextView;

    public String getCorreoElectronicoResultadoEsperado(){
        return correoElectronicoResultadoEsperado;
    }

    public void ingresarHabilitacionGanamovil(){
        waitForElement(habilitacionGanamovilButton, TIME_SECONDS).click();
    }

    public void escribirCI(String ci){
        waitForElement(ciTextBox, TIME_SECONDS).sendKeys(ci);
    }

    public void seleccionarExtension(String extension){
        clicOpcion("Seleccionar");
        String opcionXpath = "//*[@class='android.widget.CheckedTextView'][@text='" + extension + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void escribirDiaNacimiento(String diaNacimiento){
        waitForElement(diaNacimientoTextBox, TIME_SECONDS);
        diaNacimientoTextBox.sendKeys(diaNacimiento);
    }

    public void escribirMesNacimiento(String mesNacimiento){
        waitForElement(mesNacimientoTextBox, TIME_SECONDS);
        mesNacimientoTextBox.sendKeys(mesNacimiento);
    }

    public void escribirAnoNacimiento(String anoNacimiento){
        waitForElement(anoNacimientoTextBox, TIME_SECONDS).sendKeys(anoNacimiento);
    }

    public void escribirCelular(String celular){
        waitForElement(celularTextBox, TIME_SECONDS).sendKeys(celular);
    }

    public void escribirNroTarjeta1(String nroTarjeta1){
        waitForElement(nroTarjeta1TextBox, TIME_SECONDS).sendKeys(nroTarjeta1);
    }

    public void escribirNroTarjeta2(String nroTarjeta2){
        waitForElement(nroTarjeta2TextBox, TIME_SECONDS).sendKeys(nroTarjeta2);
    }

    public void escribirNroTarjeta3(String nroTarjeta3){
        waitForElement(nroTarjeta3TextBox, TIME_SECONDS).sendKeys(nroTarjeta3);
    }

    public void escribirNroTarjeta4(String nroTarjeta4){
        waitForElement(nroTarjeta4TextBox, TIME_SECONDS).sendKeys(nroTarjeta4);
    }

    public void escribirNroTarjeta(String nroTarjeta){

        String nro1= nroTarjeta.substring(0,4);
        String nro2= nroTarjeta.substring(4,8);
        String nro3= nroTarjeta.substring(8,12);
        String nro4= nroTarjeta.substring(12,16);

        escribirNroTarjeta1(nro1);
        escribirNroTarjeta2(nro2);
        escribirNroTarjeta3(nro3);
        escribirNroTarjeta4(nro4);
    }

    public void escribirMesExpiracion(String mesExpiracion){
        waitForElement(mesExpiracionTextBox, TIME_SECONDS).sendKeys(mesExpiracion);
    }

    public void escribirAnoExpiracion(String anoExpiracion){
        waitForElement(anoExpiracionTextBox, TIME_SECONDS).sendKeys(anoExpiracion);
    }

    public void clicButton(String nombreBoton) {
        String opcionXpath = "//*[@class='android.widget.Button'][@text='" + nombreBoton + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void clicOpcion(String opcion) {
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + opcion + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void navegarAtras(){
        getDriver().navigate().back();
        }

    public String getTextCorreoElectronico(){
        return waitForElement(correoElectronicoTextView, TIME_SECONDS).getText();
    }
}
