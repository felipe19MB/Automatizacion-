package com.bg.gnt.pageobjects.transferencias.afiliacion;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import com.bg.gnt.pageobjects.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AfiOtrosBancosPage extends BasePage {
	
	
	
	@FindBy (xpath="//div[@class='box-body  doc-dropdown']/div/div/div[@class='callout callout-success borderfirst']")
	private List<WebElementFacade> gLstCuentas;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-combobox[1]/div/div/select")
	private WebElementFacade gWefCmbBanco;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-combobox[2]/div/div/select")
	private WebElementFacade gWefCmbSucursal;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-combobox[3]/div/select")
	private WebElementFacade gWefCmbTipoCta;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-input-text[1]/div/div/input")
	private WebElementFacade gWefTxtAlias;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-input-text[2]/div/div/input")
	private WebElementFacade gWefTxtTitular;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-input-text[3]/div/input")
	private WebElementFacade gWefTxtNit;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-input-text[4]/div/div/input")
	private WebElementFacade gWefTxtNroCta;
	
	@FindBy (xpath="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/div/form/control-input-text[5]/div/div/input")
	private WebElementFacade gWefTxtEmail;
	
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElementFacade gWefTxtGanapin1;
	
	
	@FindBy (xpath="(//input[@type='password'])[2]")
	private WebElementFacade gWefTxtGanapin2;
	
	public void eliminarCuenta(List<String> pListDatosCuenta) {
		String lStrCtaDestino	= pListDatosCuenta.get(0);
		for(int i=0; i<(gLstCuentas.size());i++) {
			String auxCuenta= gLstCuentas.get(i).getText();
			if(auxCuenta.contains(lStrCtaDestino)) {
				i++;
				String xCta	= "(//div[@class='box-body  doc-dropdown']/div/div/div[@class='callout callout-success borderfirst']/div)["+ i +"]/div[6]/a";
				clickByXpath(xCta);
			}
		}
		waitFor(15).seconds();
	}

	public void banco(String pStrBanco) {
		gWefCmbBanco.selectByValue(pStrBanco);
		waitFor(2).seconds();
	}
	
	public void sucursal(String pStrSucursal) {
		gWefCmbSucursal.selectByValue(pStrSucursal);
		waitFor(2).seconds();
	}
	
	public void tipoCuenta(String pStrTipoCta) {
		gWefCmbTipoCta.selectByValue(pStrTipoCta);
		waitFor(2).seconds();
	}
	
	public void alias(String pStrAlias) {
		gWefTxtAlias.sendKeys(pStrAlias);
		waitFor(2).seconds();
	}
	
	public void titular(String pStrTitular) {
		gWefTxtTitular.sendKeys(pStrTitular);
		waitFor(2).seconds();
	}
	
	public void nit(String pStrNit) {
		gWefTxtNit.sendKeys(pStrNit);
		waitFor(2).seconds();
	}
	
	public void cuenta(String pStrCta) {
		gWefTxtNroCta.sendKeys(pStrCta);
		waitFor(2).seconds();
	}
	
	public void email(String pStrEmail) {
		gWefTxtEmail.sendKeys(pStrEmail);
		waitFor(2).seconds();
	}
	
	public void favorito(String pStrFavorito) {
		if(pStrFavorito.contains("SI")) {
			String xCbxFavorito = "//control-checkbox[@formcontrolname='esFavorito']/div/div/div/input";
			checkByXpath(xCbxFavorito);
			waitFor(5).seconds();
		}
	}
	
	public void guardar() {
		String xBtnGuardar = "//button[contains(text(),'Guardar')]";
		clickByXpath(xBtnGuardar);
		waitFor(2).seconds();
	}
	
	public void ingresarSegundoFactor1(int pIntGanapin) {
		gWefTxtGanapin1.sendKeys(Integer.toString(pIntGanapin));
		waitFor(5).seconds();
	}	
	
	public void ingresarSegundoFactor2(int pIntGanapin) {
		gWefTxtGanapin2.sendKeys(Integer.toString(pIntGanapin));
		waitFor(5).seconds();
	}
	
	public void procesar() {
		String xBtnProcesar = "(//button[contains(text(),'Procesar')])[1]";
		clickByXpath(xBtnProcesar);
		waitFor(5).seconds();
	}

	public void procesar2() {
		String xBtnProcesar = "(//button[contains(text(),'Procesar')])[2]";
		clickByXpath(xBtnProcesar);
		waitFor(5).seconds();
	}
}
