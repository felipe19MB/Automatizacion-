package com.bg.gmv.pageobjects.transferencia;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TransferenciaPage extends BasePage {

    // Elementos para Comrpobante

    @FindBy(xpath ="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtNroCuentaOrigenComprobante;

    @FindBy(xpath ="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtImporteDebitoComprobante;

    @FindBy(xpath ="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtNroCuentaDestinoComprobante;

    @FindBy(xpath ="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtImporteCreditoComprobante;

    @FindBy(xpath ="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtDescripcionComprobante;

    // Elementos para Resumen

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtNroCuentaOrigenResumen;

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtNroCuentaDestinoResumen;

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtImporteResumen;

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.LinearLayout[6]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtDescripcionResumen;


    public void seleccionarCuenta(String nroCuenta){
        clicOpcion("Cuenta Origen");
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + nroCuenta + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();

    }

    public void seleccionarTipoTransferencia(String tipoTransferencia) {
        clicOpcion("Tipo de Transferencia");
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + tipoTransferencia + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void seleccionarCuentaDestino(String nroCuenta) {
        clicOpcion("Cuenta Destino");
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + nroCuenta + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void seleccionarMoneda(String moneda) {
        clicOpcion("Moneda");
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + moneda + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void ingresarMonto(String monto) {
        String opcionXpath = "//*[@class='android.widget.EditText'][@text='Ingresa el monto']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).sendKeys(monto);
    }

    public void ingresarDescripcion(String descripcion) {
        String opcionXpath = "//*[@class='android.widget.EditText'][@text='Ingresar la descripción']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).sendKeys(descripcion);
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

    /*
        Metodos para Comprobante
     */

    public String getNroCuentaOrigenComprobante(){

        String nroCuentaOrigen= waitForElement(txtNroCuentaOrigenComprobante, 60).getText();
        return nroCuentaOrigen;
    }

    public String getNroCuentaDestinoComprobante(){
        String nroCuentaDestino= txtNroCuentaDestinoComprobante.getText();
        return nroCuentaDestino;
    }

    public String getImporteDebitoComprobante(){
        String importe= waitForElement(txtImporteDebitoComprobante,60).getText().split(" ")[0];
        return importe;
    }

    public String getImporteCreditoComprobante(){
        String importe= waitForElement(txtImporteCreditoComprobante,60).getText().split(" ")[0];
        return importe;
    }

    public String getDescripcionComprobante(){
        String descripcion= waitForElement(txtDescripcionComprobante,60).getText();
        return descripcion;
    }

    /*
        Metodos para Resumen
     */

    public String getNroCuentaOrigenResumen(){
        String nroCuentaOrigen = waitForElement(txtNroCuentaOrigenResumen,60).getText();
        return nroCuentaOrigen;
    }

    public String getNroCuentaDestinoResumen(){
        String nroCuentaDestino = txtNroCuentaDestinoResumen.getText();
        return nroCuentaDestino;
    }

    public String getImporteResumen(){
        String importe = waitForElement(txtImporteResumen,60).getText();
        return importe;
    }

    public String getDescripcionResumen(){
        String descripcion = waitForElement(txtDescripcionResumen,60).getText();
        return descripcion;
    }


    public String getValorComprobante(String pNombreCampo){


        String valor = "";
        String listaCamposXpath = "//android.widget.LinearLayout[1]/android.widget.TextView";
        List<WebElement> lWelListaCampos= findElements(listaCamposXpath);
        Integer cantidadCampos = lWelListaCampos.size();

        for(int posicion =1;posicion<=cantidadCampos;posicion++){
            Boolean encontradoFlag=false;
            String campoXpath="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+posicion+"]/android.widget.LinearLayout[2]/android.widget.TextView";
            WebElement lWelCampo= findElement(campoXpath);
            String nombreCampo=lWelCampo.getText();
            if(nombreCampo.equals(pNombreCampo)){
                encontradoFlag=true;
            }
            if(encontradoFlag==true){
                String valorCampoXpath="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+posicion+"]/android.widget.LinearLayout[2]/android.widget.TextView";
                WebElement lWelTextValorCampo= findElement(valorCampoXpath);
                valor = waitForElement(lWelTextValorCampo,50).getText();
                posicion = cantidadCampos;
            }
        }
        return valor;

    }


}