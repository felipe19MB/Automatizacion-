package com.bg.gnt.pageobjects.transferencias;


import com.bg.gnt.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CtaPropiasPage extends BasePage{

    @FindBy(xpath="//div[@class=\"col-md-3\"]/control-table-cuenta/div/div/div/div")
    private List<WebElementFacade> tblSelCtaOrigen;

    @FindBy (xpath="(//div[@class=\"form-group\"]/textarea)[1]")
    private WebElementFacade txtGlosaOrigen;

    @FindBy (xpath="(//div[@class=\"form-group\"]/textarea)[2]")
    private WebElementFacade txtGlosaDestino;


    @FindBy (xpath="//control-input-monto/div/input")
    private WebElementFacade txtMonto;


    @FindBy (xpath="//input[@name='token']")
    private WebElementFacade txtGanapin;



    /* WebElements del comprobante	*/

    @FindBy(xpath="//div[@class='ribbon-wrapper']/div[2]/div[3]")
    private WebElementFacade lblCtaOrigen;


    @FindBy(xpath="//div[@class='ribbon-wrapper']/div[2]/div[7]")
    private WebElementFacade lblImpDebito;


    public void seleccionarCtaOrigen(String nroCuenta) {
        for(int i=0; i<(tblSelCtaOrigen.size());i++) {
            String nroCtaAuxiliar= tblSelCtaOrigen.get(i).getText();
            if(nroCtaAuxiliar.contains(nroCuenta)) {
                tblSelCtaOrigen.get(i).click();
            }
        }
    }
    public void seleccionarCtaDestino(String nroCuenta) {
        String xRbtCtaDestino = "(//small[text()='"+nroCuenta+"'])[1]";
        //WebElement ctaDestinoElement = findElement(xRbtCtaDestino);
        //ctaDestinoElement.click();
        clickByXpath(xRbtCtaDestino);

    }

    public void continuarTransferencia() {

        String xBtnSiguiente = "//button[text()='Siguiente']";
        clickByXpath(xBtnSiguiente);
    }

    public void ingresarMonto(String monto) {
        String xTxtMonto = "//control-input-monto/div/input";
        clickByXpath(xTxtMonto);
        txtMonto.clear();
        txtMonto.sendKeys(monto);
        waitFor(10).seconds();
    }

    public void seleccionarMoneda(String moneda) {

        String xCbxMoneda = "//a[text()='"+" "+moneda+"']";
        clickByXpath(xCbxMoneda);
    }

    public void ingresarGlosas(String glosaOrigen, String glosaDestino) {
        txtGlosaOrigen.sendKeys(glosaOrigen);
        txtGlosaDestino.clear();
        txtGlosaDestino.sendKeys(glosaDestino);
    }

    public void finalizarTransferencia() {
        String xBtnFinalizar = "//button[text()='Finalizar']";
        clickByXpath(xBtnFinalizar);

        waitFor(15).seconds();
    }

    public void ingresarGanapin(String ganapin) {
        txtGanapin.sendKeys(ganapin);
    }
    public void procesarTransferencia() {
        String xBtnProcesar = "//button[@type='submit']";
        clickByXpath(xBtnProcesar);
        waitFor(40).seconds();
    }

    public String getCuentaOrigenComprobante(){
        String cuentaOrigen = "";
        String cuentaOrigenXpath = "/html/body/app-root/app-paginas/div/div/transferencia-propia/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div[3]";
        WebElement cuentaOrigenElement = findElement(cuentaOrigenXpath);
        cuentaOrigen = cuentaOrigenElement.getText();

        return cuentaOrigen;
    }

    public String getImporteDebitoComprobante(){
        String importeDebito="";
        String importeDebitoXpath = "/html/body/app-root/app-paginas/div/div/transferencia-propia/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div[7]";
        WebElement importeDebitoElement = findElement(importeDebitoXpath);
        importeDebito = importeDebitoElement.getText();
        return importeDebito;
    }
}
