package com.bg.gnt.pageobjects.transferencias;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.bg.gnt.pageobjects.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CtaTercerosPage extends BasePage {

	@FindBy (xpath="//div[@class=\"col-md-3\"]/control-table-cuenta/div/div/div/div")
	private List<WebElementFacade> tblSelCtaOrigen;
	
	@FindBy (xpath="//button[text()='Siguiente']")
	private WebElementFacade btnSiguiente;
	
	@FindBy (xpath="//span[@class=\"dropdown-toggle\"]")
	private WebElementFacade cmbMoneda;
	
	@FindBy (xpath="//control-input-monto/div/input")
	private WebElementFacade txtMonto;
	
	@FindBy (xpath="(//div[@class=\"form-group\"]/textarea)[1]")
	private WebElementFacade txtGlosaOrigen;
	
	@FindBy (xpath="(//div[@class=\"form-group\"]/textarea)[2]")
	private WebElementFacade txtGlosaDestino;
	
	@FindBy (xpath="(//textarea[@_ngcontent-c26])[5]")
	private WebElementFacade txtMotivo;
	
	@FindBy (xpath="(//textarea[@_ngcontent-c26])[3]")
	private WebElementFacade txtOrigen;
	
	@FindBy (xpath="(//textarea[@_ngcontent-c26])[4]")
	private WebElementFacade txtDestino;
	
	@FindBy (xpath="//button[text()='Finalizar']")
	private WebElementFacade btnFinalizar;
	
	@FindBy (xpath="//input[@name='token']")
	private WebElementFacade txtGanapin;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElementFacade btnProcesar;//*[@id="contentPDFComprobante"]/div/div[2]/div[2]/div[3]
	
	/* WebElements del comprobante	*/
	
	@FindBy(xpath="//div[@class='ribbon-wrapper']/div[2]/div[3]")
	private WebElementFacade lblCtaOrigen;
	
	@FindBy(xpath="//div[@class='ribbon-wrapper']/div[2]/div[12]")
	private WebElementFacade lblCtaDestino;
	
	@FindBy(xpath="//div[@class='ribbon-wrapper']/div[2]/div[7]")
	private WebElementFacade lblImpDebito;
	
	
	@FindBy (xpath="//div[@id='swal2-content']")
	private WebElementFacade gWefMensajeAlert;
	
	@FindBy(xpath="//button[text()='Aceptar']")
	private WebElementFacade gWefBtnAceptar;
	
	@FindBy(xpath="//div[@class='ribbon-wrapper']/div[1]/div[3]/strong[1]",timeoutInSeconds="60")
	private WebElementFacade gWefLblNroAsiento;
	

	public String getTextNroAsiento() {
		
		String lTextNroAsiento= "document.querySelector(\"#contentPDFComprobante > div > div.ribbon-wrapper > div:nth-child(1) > div.col-3 > strong\")" +".innerTEXT";
		String[] lstringArray=lTextNroAsiento.split(" ");
		String lTextNroAsientoAux = lstringArray[1];
		return lTextNroAsientoAux;
	}
	public String getTextImpDebito(){
		String[] lstringArray =lblImpDebito.getText().replace(",", "").split(" ");
		String lTextImpDebito =lstringArray[0];
		return lTextImpDebito;
	}

	
	public void seleccionarCtaOrigen(String nroCuenta) {


		waitFor(15).seconds();
		for(int i=0; i<(tblSelCtaOrigen.size());i++) {
			String nroCtaAuxiliar= tblSelCtaOrigen.get(i).getText();
			if(nroCtaAuxiliar.contains(nroCuenta)) {
				String xRbtCtaDebito = "//control-table-cuenta/div/div[2]/div/div["+(i+1)+"]/div/div";
				clickByXpath(xRbtCtaDebito);
			}
		}
		

	}
	
	public void seleccionarCtaDestino(String nroCuenta) {
		String xRbtCtaDestino = "(//small[text()='"+nroCuenta+"'])[1]";
		clickByXpath(xRbtCtaDestino);

	}
	
	public void continuarTransferencia() {
		
		String xBtnSiguiente = "//button[text()='Siguiente']";
		clickByXpath(xBtnSiguiente);
	}
	
	public void seleccionarMoneda(String moneda) {
		
		String xCbxMoneda = "//a[text()='"+" "+moneda+"']";
		clickByXpath(xCbxMoneda);
	}
	
	public void ingresarMonto(String monto) {
		String xTxtMonto = "//control-input-monto/div/input";
		clickByXpath(xTxtMonto);
		txtMonto.clear();
		txtMonto.sendKeys(monto);
		waitFor(5).seconds();
	}
	
	public void ingresarGlosas(String glosaOrigen, String glosaDestino) {
		txtGlosaOrigen.waitUntilEnabled();
		txtGlosaOrigen.sendKeys(glosaOrigen);
		txtGlosaDestino.clear();
		txtGlosaDestino.sendKeys(glosaDestino);
	}
	
	public void ingresarUIF(String origenUIF, String destinoUIF, String motivoUIF) {
		txtOrigen.sendKeys(origenUIF);
		txtDestino.sendKeys(destinoUIF);
		txtMotivo.sendKeys(motivoUIF);
		waitFor(5).seconds();
	}
	
	public void finalizarTransferencia() {
		String xBtnFinalizar = "//button[text()='Finalizar']";
		clickByXpath(xBtnFinalizar);
		
		//waitFor(15).seconds();
	}
	
	public void ingresarGanapin(String ganapin) {
		txtGanapin.waitUntilEnabled();
		txtGanapin.sendKeys(ganapin);
	}
	
	public void procesarTransferencia() {
		String xBtnProcesar = "//button[@type='submit']";
		clickByXpath(xBtnProcesar);
		//waitFor(40).seconds();
	}
	
	public void verificarComprobante(List<String> datosTrans) {

		assertThat(lblCtaOrigen.getText(),containsString(datosTrans.get(0)));
		String lStrImpDebito = lblImpDebito.getText().replace(",", "");
		assertThat(lStrImpDebito,containsString(datosTrans.get(1)));
		
		//assertThat(lblCtaDestino.getText(),containsString(datosTrans.get(1)));	
	}
	

	
	public void verificarMensaje(List<String> datosMensaje) {
		String lStrMensaje=datosMensaje.get(0).toString();
		assertThat(gWefMensajeAlert.getText(),containsString(lStrMensaje));
		String xBtnOk = "//button[text()='Aceptar']";
		clickByXpath(xBtnOk);
	}

}
