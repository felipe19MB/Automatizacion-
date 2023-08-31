package com.bg.gnt.pageobjects.configuracionSeguridad;

import com.bg.gnt.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class ActualizacionDatosResumenPage extends BasePage {
	private final int waitTime = 60;

	@FindBy (xpath="//input[@placeholder='Ingresa una UV']")
	private WebElementFacade uvTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa la MZA']")
	private WebElementFacade manzanaTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa el Nombre del Barrio en el que vives']")
	private WebElementFacade barrioTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa el Nombre de la Calle o Avenida en el que vives']")
	private WebElementFacade calleTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa el Numero de Casa o Puerta']")
	private WebElementFacade nroPuertaTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa el Numero de piso en el que vives']")
	private WebElementFacade pisoTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa el Numero de tu Apartamento']")
	private WebElementFacade apartamentoTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa tu Correo Electronico']")
	private WebElementFacade emailTextBox;
	private String continuarButton = "Continuar";
	@FindBy (xpath="//input[@placeholder='Ingresa tu Teléfono de domicilio']")
	private WebElementFacade telefonoResumenTextBox;
	@FindBy (xpath="//input[@placeholder='Ingresa tu Número de Celular']")
	private WebElementFacade celularResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-telefono-adicional/div/div/div/control-combobox/div/select")
	private WebElementFacade direccionPreferidaCorrespondenciaResumenSelect;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[1]/control-input-text[1]/div/input")
	private WebElementFacade nombresPrimeraReferenciaResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[1]/control-input-text[2]/div/input")
	private WebElementFacade telefonoPrimeraReferenciaResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[1]/control-combobox/div/select")
	private WebElementFacade relacionPrimeraReferenciaResumenSelect;
	@FindBy (sclocator="body > app-root > app-paginas > div > div > actualizacion-datos > control-contenedor-paginas > section > div > div > control-wizard-step > control-wizard-container:nth-child(5) > control-box > div > div.box-body.bg-box-body > wizard-resumen > wizard-referencia-comercial > div > div > div:nth-child(3) > control-input-text.col-md-4.col-sm-12.ng-untouched.ng-dirty.ng-valid > div > input")
	private WebElementFacade nombresSegundaReferenciaResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[2]/control-input-text[2]/div/input")
	private WebElementFacade telefonoSegundaReferenciaResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[2]/control-combobox/div/select")
	private WebElementFacade relacionSegundaReferenciaResumenSelect;
	@FindBy (xpath="//*[@id=\"modal-segundo-factor\"]/div/div/div[2]/form/div/div[3]/div/div/input")
	private WebElementFacade tokenTextBox;
	@FindBy (xpath="//*[@id=\"modal-segundo-factor\"]/div/div/div[2]/form/div/div[4]/button")
	private WebElementFacade procesarButton;
	@FindBy (xpath="//div[@id='swal2-content']")
	private WebElementFacade mensajeExitoText;

	public String getUvText(){
		return waitForElement(uvTextBox, waitTime).getAttribute("value");
	}
	public String getManzanaText(){
		return waitForElement(manzanaTextBox, waitTime).getAttribute("value");
	}
	public String getBarrioText(){
		return waitForElement(barrioTextBox, waitTime).getAttribute("value");
	}
	public String getCalleText(){
		return waitForElement(calleTextBox, waitTime).getAttribute("value");
	}
	public String getNroPuertaText(){
		return waitForElement(nroPuertaTextBox, waitTime).getAttribute("value");
	}
	public String getPisoText(){
		return waitForElement(pisoTextBox, waitTime).getAttribute("value");
	}
	public String getApartamentoText(){
		return waitForElement(apartamentoTextBox, waitTime).getAttribute("value");
	}
	public String getEmailText(){
		return waitForElement(emailTextBox, waitTime).getAttribute("value");
	}
	public String getTelefonoDomicilioText(){
		return waitForElement(telefonoResumenTextBox, waitTime).getAttribute("value");
	}
	public String getCelularText(){
		return waitForElement(celularResumenTextBox, waitTime).getAttribute("value");
	}
	public String getDireccionPreferidaText(){
		waitForElement(direccionPreferidaCorrespondenciaResumenSelect, waitTime).isDisplayed();
		return getSelectedLabelFrom(direccionPreferidaCorrespondenciaResumenSelect);
	}
	public String getNombresPrimeraReferenciaResumen(){
		return waitForElement(nombresPrimeraReferenciaResumenTextBox, waitTime).getAttribute("value");
	}
	public String getTelefonoPrimeraReferenciaResumen(){
		return waitForElement(telefonoPrimeraReferenciaResumenTextBox, waitTime).getAttribute("value");
	}
	public String getRelacionPrimeraReferenciaResumen(){
		waitForElement(relacionPrimeraReferenciaResumenSelect, waitTime).isDisplayed();
		return getSelectedLabelFrom(relacionPrimeraReferenciaResumenSelect);
	}
	public String getRelacionSegundaReferenciaResumen(){
		waitForElement(relacionSegundaReferenciaResumenSelect, waitTime);
		return getSelectedLabelFrom(relacionSegundaReferenciaResumenSelect);
	}
	public void continuarResumen(){
		String click = "" +
				"document.querySelector(\"body > app-root > app-paginas > div > div > actualizacion-datos > control-contenedor-paginas > section > div > div > control-wizard-step > control-wizard-container:nth-child(5) > div > button.btn.btn-success.pull-right\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}
	public void ingresarToken(String token){
		/*
		/*Por alguna razón no funciona la implementción comentada más abajo.
		 */
		//waitForElement(tokenTextBox, waitTime).sendKeys(token);
		waitFor(5).seconds();
		tokenTextBox.sendKeys(token);
		waitFor(2).seconds();
	}
	public void procesarToken(){
		String click = "" +
				"document.querySelector(\"#modal-segundo-factor > div > div > div.modal-body.mt-4 > form > div > div.col-12.text-center > button\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}
	public String obtenerMensajeExitoText(){
		return waitForElement(mensajeExitoText, waitTime).getText();
	}
	public void confirmar(){
		String click = "" +
				"document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}
}
