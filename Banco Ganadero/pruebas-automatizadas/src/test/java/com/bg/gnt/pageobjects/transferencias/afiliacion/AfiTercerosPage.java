package com.bg.gnt.pageobjects.transferencias.afiliacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.bg.gnt.pageobjects.BasePage;
import com.bg.gnt.util.Log;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class AfiTercerosPage extends BasePage {

	//Time :82 min
	
	/*	Formulario afiliacion cuentas de terceros*/
	
	
	@FindBy (xpath="//button/strong[text()='Agregar +']")
	private WebElementFacade gBtnAgregar;
	
	@FindBy (xpath="//div[@class='box-body  doc-dropdown']/div/div/div[@class='callout callout-success borderfirst']")
	private List<WebElementFacade> gLstCuentas;
	
	/*	Formulario ganapin Afiliar	*/
	
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElementFacade gWefTxtGanapin;
	
	@FindBy (xpath="(//button[text()='Procesar'])[1]")
	private WebElementFacade gWefBtnProcesar;
	
	/*	Formulario ganapin Eliminar	*/
	
	@FindBy (xpath="(//input[@type='password'])[2]")
	private WebElementFacade gWefTxtGanapin2;
	
	@FindBy (xpath="(//button[text()='Procesar'])[2]")
	private WebElementFacade gWefBtnProcesar2;
	
	/*	Alerta	*/
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElementFacade gWefBtnAceptar;
	
	@FindBy(xpath="//div[@id='swal2-content']")
	private WebElementFacade gWefLblMensaje;
	
	/*	Formulario de afiliacion	*/
	
	@FindBy(xpath="//control-input-text[@formcontrolname='referencia']/div/div/input")
	private WebElementFacade gWefTxtReferencia;
	
	@FindBy(xpath="//control-input-text[@formcontrolname='nroCuenta']/div/div/input")
	private WebElementFacade gWefTxtNroCuenta;
	
	@FindBy(xpath="//input[@formcontrolname='titular']")
	private WebElementFacade gWefTxtTitular;
	
	@FindBy(xpath="//div[@class='input-group-prepend']/button")
	private WebElementFacade gWefBtnBuscar;
	
	@FindBy(xpath="//control-checkbox[@formcontrolname='esFavorito']")
	private WebElementFacade gWefCbxEsFavorito;
	
	@FindBy(xpath="//button[text()='Guardar']")
	private WebElementFacade gWefBtnGuardar;
	
	@FindBy(xpath="//button[text()='Cerrar']")
	private WebElementFacade gWefBtnCerrar;
	
	public void clicAgregar() {
		
		//	Registro de log inicio			
		Log.startTestCase("Afiliar cuenta de tercero");
		
		waitFor(5).seconds();
		String xpath="//button/strong[contains(text(),'Agregar')]";
		clickByXpath(xpath);
		
		waitFor(5).seconds();
	}
	
	public void eliminarCuenta(List<String> pListDatosCuenta) {
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		
		String lStrCtaDestino	= pListDatosCuenta.get(0);
		//String lStrAlias		= pListDatosCuenta.get(1);
		//String lStrTitular		= pListDatosCuenta.get(0); 
		for(int i=0; i<(gLstCuentas.size());i++) {
			String auxCuenta= gLstCuentas.get(i).getText();
			if(auxCuenta.contains(lStrCtaDestino)) {
				i++;
				String xCta	= "(//div[@class='box-body  doc-dropdown']/div/div/div[@class='callout callout-success borderfirst']/div)["+ i +"]/div[7]/a";
				clickByXpath(xCta);

			}
		
		}
		waitFor(15).seconds();
	}
	
	public void ingresarSegundoFactor(String pIntGanapin) {
		gWefTxtGanapin.sendKeys(pIntGanapin);
		waitFor(5).seconds();
	}
	
	/*
	 * Metodo para ingresar el segundo factor al eliminar afiliado
	 * */
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
	/**
	 * Metodos para interactuar con el mensaje de alerta
	 *
	 * */
	public String getMensaje(){
		String mensajeAlerta= gWefLblMensaje.getText();
		return mensajeAlerta;
	}
	public void cerrarMensaje() {
		String xBtnOk = "//button[text()='OK']";
		clickByXpath(xBtnOk);
		waitFor(5).seconds();
		//	Registro de log fin
		Log.endTestCase("Afiliar cuenta de tercero");
	}

	/**
	 * Metodos para obtener los datos del registro afiliado
	 * */

	public String getAliasRegistrado(){
		String alias = "";
		String aliasXpath = "//app-terceros/control-contenedor-paginas/section/div/div/div/div[2]/div/div[3]/div/div/div[2]/small";
		WebElement welAlias = findElement(aliasXpath);
		alias = welAlias.getText();
		return alias;
	}

	public String getNroCuentaRegistrado(){
		String nroCuenta = "";
		String nroCuentaXpath = "//app-terceros/control-contenedor-paginas/section/div/div/div/div[2]/div/div[3]/div/div/div[3]/small";
		WebElement nroCuentaElement = findElement(nroCuentaXpath);
		nroCuenta = nroCuentaElement.getText();
		return nroCuenta;
	}

	public String getTitularRegistrado(){
		String titular = "";
		String titularXpath = "//app-terceros/control-contenedor-paginas/section/div/div/div/div[2]/div/div[3]/div/div/div[1]/h6";
		WebElement titularElement = findElement(titularXpath);
		titular = titularElement.getText();
		return titular;
	}




	

	
	public void regDatosBenef(List<String> pLstDatosBenef) {
		
		String lStrNroCuenta 	= pLstDatosBenef.get(0);
		String lStrTitular 		= pLstDatosBenef.get(1);
		String lStrFavorito 	= pLstDatosBenef.get(2);
		String lStrReferencia 	= pLstDatosBenef.get(3);
		
		gWefTxtReferencia.sendKeys(lStrReferencia);
		gWefTxtNroCuenta.sendKeys(lStrNroCuenta);
		gWefTxtTitular.sendKeys(lStrTitular);
		
		String xBtnBuscar ="//*[@id=\"modal-right\"]/div/div/div[2]/div/div/form/div/div/div/button";
		clickByXpath(xBtnBuscar);
		
		waitFor(5).seconds();
		if(lStrFavorito.contains("SI")) {
			String xCbxFavorito = "//control-checkbox[@formcontrolname='esFavorito']/div/div/div/input";
			checkByXpath(xCbxFavorito);
			
			waitFor(5).seconds();
		}
		
		String xBtnGuardar = "//button[contains(text(),'Guardar')]";
		clickByXpath(xBtnGuardar);
		
		waitFor(6).seconds();
	}



	public void buscarCuenta(String alias){
		String buscarXpath = "//input[@placeholder='Buscar por Alias']";
		WebElement welBuscar = findElement(buscarXpath);
		welBuscar.sendKeys(alias);
	}
}
