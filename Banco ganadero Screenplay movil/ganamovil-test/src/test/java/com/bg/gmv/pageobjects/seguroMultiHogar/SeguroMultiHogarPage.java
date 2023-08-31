package com.bg.gmv.pageobjects.seguroMultiHogar;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class SeguroMultiHogarPage extends BasePage {
    private final int waitTime = 60;
    private final String seleccionaTuPlanTextToAssert = "Selecciona tu plan";
    private final String seleccionaElNumeroDeCuentaTipoDePagoTextToAssert = "Seleccionar el número de cuenta y el tipo de pago";
    private final String datosDelTomadorTextToAssert = "Datos del Tomador";
    private final String direccionDomicilioTextToAssert = "Dirección del Domicilio";
    private final String declaracionJuradaTextToAssert = "Declaración Jurada";
    private final String resumenInformacionTextToAssert = "Resumen de la información";
    private final String mensajeExitoTextToAssert = "EXCELENTE, ya cuentas con el seguro de MULTIHOGAR";
    private final String detalleMensajeExitoTextToAssert = "Hemos enviado a tu correo electrónico la póliza del seguro y tu declaración jurada.";
    private final String pantallaPrincipalTextToAssert = "Bienvenido(a)";

    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Selecciona tu plan']")
    private WebElement seleccionaTuPlanText;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Solicitar']")
    private WebElement solicitarButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Continuar']")
    private WebElement continuarButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Seleccionar el número de cuenta y el tipo de pago']")
    private WebElement seleccionaNumeroCuentaTipoPagoText;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")
    private WebElement numeroCuentaSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
    private WebElement tipoPagoAnualRadioButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Datos del Tomador']")
    private WebElement datosDelTomadorText;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement correoElectronicoParaEnviarPolizaTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText")
    private WebElement confirmarCorreoElectronicoTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.EditText")
    private WebElement telefonoDomicilioTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[12]/android.widget.EditText")
    private WebElement celularTextBox;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Dirección del Domicilio']")
    private WebElement direccionDomicilioText;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement departamentoSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement ciudadSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[1]")
    private WebElement barrioTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[2]")
    private WebElement calleTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement numeroTextBox;
    @FindBy(xpath = "//*[@class='android.widget.EditText'][@text='Ej. Color de barda, porton, etc.']")
    private WebElement referenciaTextBox;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Declaración Jurada']")
    private WebElement declaracionJuradaText;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Si, Declaro']")
    private WebElement declaracionButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Resumen de la información']")
    private WebElement resumenInformacionText;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Finalizar']")
    private WebElement finalizarButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement mensajeExitoText;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    private WebElement detalleMensajeExitoText;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Bienvenido(a)']")
    private WebElement pantallaPrincipalText;

    public String getSeleccionaTuPlanTextToAssert(){
        return seleccionaTuPlanTextToAssert;
    }
    public String getSeleccionaElNumeroDeCuentaTipoDePagoTextToAssert(){
        return seleccionaElNumeroDeCuentaTipoDePagoTextToAssert;
    }
    public String getDatosDelTomadorTextToAssert(){
        return datosDelTomadorTextToAssert;
    }
    public String getDireccionDomicilioTextToAssert(){
        return direccionDomicilioTextToAssert;
    }
    public String getDeclaracionJuradaTextToAssert(){
        return declaracionJuradaTextToAssert;
    }
    public String getResumenInformacionTextToAssert(){
        return resumenInformacionTextToAssert;
    }
    public String getMensajeExitoTextToAssert(){
        return mensajeExitoTextToAssert;
    }
    public String getDetalleMensajeExitoTextToAssert(){
        return detalleMensajeExitoTextToAssert;
    }
    public String getPantallaPrincipalTextToAssert(){
        return pantallaPrincipalTextToAssert;
    }
    public String getSeleccionaTuPlan(){
        return waitForElement(seleccionaTuPlanText,waitTime).getText();
    }
    public void solicitar(){
        waitForElement(solicitarButton, waitTime).click();
    }
    public String getSeleccionaElNumeroDeCuentaTipoDePago(){
        return waitForElement(seleccionaNumeroCuentaTipoPagoText,waitTime).getText();
    }
    public void seleccionarCuenta(String numeroCuenta){
        selectOptionFromDropDownByText(numeroCuentaSelect, numeroCuenta, waitTime);
    }
    public void continuar(){
        waitForElement(continuarButton, waitTime).click();
    }
    public void seleccionarTipoPagoAnual(){
        waitForElement(tipoPagoAnualRadioButton, waitTime).click();
    }
    public String getDatosDelTomador(){
        return waitForElement(datosDelTomadorText, waitTime).getText();
    }
    public void ingresarCorreoElectronicoParaEnviarPoliza(String correo){
        waitForElement(correoElectronicoParaEnviarPolizaTextBox, waitTime).sendKeys(correo);
    }
    public void ingresarConfirmacionCorreoElectronico(String correo){
        waitForElement(confirmarCorreoElectronicoTextBox, waitTime).sendKeys(correo);
    }
    public void ingresarTelefonoDomicilio(String telefono) {
        waitForElement(telefonoDomicilioTextBox, waitTime).sendKeys(telefono);
    }
    public void ingresarCelular(String celular) {
        waitForElement(celularTextBox, waitTime).sendKeys(celular);
    }
    public String getDireccionDomicilio(){
        return waitForElement(direccionDomicilioText, waitTime).getText();
    }
    public void seleccionarDepartamento(String departamento){
        selectOptionFromDropDownByText(departamentoSelect, departamento, waitTime);
    }
    public void seleccionarCiudad(String ciudad){
        selectOptionFromDropDownByText(ciudadSelect, ciudad, waitTime);
    }
    public void ingresarBarrio(String barrio) {
        waitForElement(barrioTextBox, waitTime).sendKeys(barrio);
    }
    public void ingresarCalle(String calle) {
        waitForElement(calleTextBox, waitTime).sendKeys(calle);
    }
    public void ingresarNumero(String numero) {
        waitForElement(numeroTextBox, waitTime).sendKeys(numero);
    }
    public void ingresarReferencia(String referencia) {
        waitForElement(referenciaTextBox, waitTime).sendKeys(referencia);
    }
    public String getDeclaracionJurada(){
        return waitForElement(declaracionJuradaText, waitTime).getText();
    }
    public void aceptarDeclaracion(){
        waitForElement(declaracionButton, waitTime).click();
    }
    public String getResumenInformacion(){
        return waitForElement(resumenInformacionText, waitTime).getText();
    }
    public void confirmar(){
        waitForElement(confirmarButton, waitTime).click();
    }
    public void finalizar(){
        waitForElement(finalizarButton, waitTime).click();
    }
    public String getMensajeExito(){
        return waitForElement(mensajeExitoText, waitTime).getText();
    }
    public String getDetalleMensajeExito(){
        return waitForElement(detalleMensajeExitoText, waitTime).getText();
    }
    public String getPantallaPrincipal(){
        return waitForElement(pantallaPrincipalText, waitTime).getText();
    }
}
