package com.bg.gnt.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class TarjetasCreditoPage extends BasePage {

	//Time :93min
	
	/*	Formulario Bloqueo/Desbloqueo	*/
	
	@FindBy (xpath="//app-tabla-tarjeta/div/table/tbody/tr")
	private List<WebElementFacade> gTblSelTarjeta;
	
	@FindBy (xpath="//tc-tabla-tarjetas-credito-plastico/table/tbody/tr")
	private List<WebElementFacade> gTblSelPlasticos;
	
	@FindBy (xpath="//select")
	private WebElementFacade gWefCmbTipoBloqueo;
	
	@FindBy (xpath="(//button[text()='Procesar'])[1]")
	private WebElementFacade gWefBtnFinalizar;
	

	
	/*	Formulario Ganapin	*/
	
	@FindBy (xpath="//input[@type='password']")
	private WebElementFacade gWefTxtGanapin;
	
	@FindBy (xpath="(//button[text()='Procesar'])[2]")
	private WebElementFacade gWefBtnProcesar;
	
	/*	Alerta	*/
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElementFacade gWefBtnAceptar;
	
	@FindBy(xpath="//div[@id='swal2-content']")
	private WebElementFacade gWefLblMensaje;
	
	
	public void seleccionarTarjeta(String pStrNroTarjeta) {
		
		
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		for(int i=0; i < (gTblSelTarjeta.size()); i++){
			String auxCuenta = gTblSelTarjeta.get(i).getText();
			if(auxCuenta.contains(pStrNroTarjeta)) {
				i++;	//Se aumenta 1 para que se pueda encontrar el elemento correcto de la fila ya que estos empiezan desde 1
				//Expresion xpath para capturar saldo disponible de una fila especifica dentro del a tabla.
				String xpathExpression = "//app-tabla-tarjeta/div/table/tbody/tr/td[12]/a/div/label";	//[8]= Columna de la tabla
				js.executeScript("arguments[0].scrollIntoView();",getDriver().findElement(By.xpath(xpathExpression)));
				getDriver().findElement(By.xpath(xpathExpression)).click();
			}
		}
		waitFor(10).seconds();
	}
	
	public void seleccionarPlastico(String pStrNroPlastico) {
		
		JavascriptExecutor js =(JavascriptExecutor)getDriver();

		for(int i=0; i < (gTblSelPlasticos.size()); i++){
			String auxCuenta = gTblSelPlasticos.get(i).getText();
			if(auxCuenta.contains(pStrNroPlastico)) {
				i++;	//Se aumenta 1 para que se pueda encontrar el elemento correcto de la fila ya que estos empiezan desde 1
				//Expresion xpath para capturar saldo disponible de una fila especifica dentro del a tabla.
				String xpathExpression = "//tc-tabla-tarjetas-credito-plastico/table/tbody/tr/td[7]";	//[8]= Columna de la tabla
				js.executeScript("arguments[0].scrollIntoView()",getDriver().findElement(By.xpath(xpathExpression)));
				getDriver().findElement(By.xpath(xpathExpression)).click();

			}
		}
		waitFor(10).seconds();	}
	
	public void seleccionarTipoBloq(String pStrTipoBloqueo) {
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView()",gWefCmbTipoBloqueo);
		gWefCmbTipoBloqueo.selectByValue(pStrTipoBloqueo);
		waitFor(5).seconds();
	}
	
	public void ingresarGanapin(int pStrGanapin) {
		gWefTxtGanapin.sendKeys(Integer.toString(pStrGanapin));
		waitFor(3).seconds();
	}
	
	public void finalizarBloq() {
		gWefBtnFinalizar.click();
		waitFor(3).seconds();
	}
	
	public void procesarBloq() {
		gWefBtnProcesar.click();
		waitFor(3).seconds();
	}
	
	public void verificarMensaje(List<String> pLstDatosMensaje) {
		String lStrNroTarjeta 	= pLstDatosMensaje.get(0);
		String lStrMensaje		= pLstDatosMensaje.get(1);
		System.out.println("Obteniendo texto");
		String mens= gWefLblMensaje.getText();
		System.out.println("Texto obtenido");
		//assertThat(gWefLblMensaje.getText(), containsString(" "+lStrNroTarjeta+" "));
		System.out.println("Entrando al Assert");
		assertThat(gWefLblMensaje.getText(),containsString(lStrNroTarjeta));
		System.out.println("Saliendo del Assert");
		String xWefBtnAceptar = "//button[text()='OK']";
		clickByXpath(xWefBtnAceptar);
		//gWefBtnAceptar.click();
		waitFor(3).seconds();
	}
}
