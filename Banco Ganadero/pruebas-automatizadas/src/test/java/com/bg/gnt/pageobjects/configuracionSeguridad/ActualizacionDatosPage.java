package com.bg.gnt.pageobjects.configuracionSeguridad;

import com.bg.gnt.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ActualizacionDatosPage extends BasePage {
	private final int waitTime = 60;
	private final String actualizacionDatosTextToAssert = "Actualización de datos";
	private final String direccionPreferenciaCorrespondenciaTextToAssert = "Dirección preferida para correspondencia";
	private final String referenciasTextToAssert = "Referencias";

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
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[1]/control-box/div/div[2]/wizard-datos-persona/div[1]/div[1]/div[5]/control-input-text[2]/div/input")
	private WebElementFacade telefonoTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[1]/control-box/div/div[2]/wizard-datos-persona/div[1]/div[1]/div[5]/control-input-text[3]/div/input")
	private WebElementFacade celularTextBox;
	private String continuarButton = "Continuar";
	@FindBy (xpath="//div[text()=' Actualización de datos ']")
	private WebElementFacade actualizacionDeDatosText;
	@FindBy (xpath="//label[text()='Dirección preferida para correspondencia ']")
	private WebElementFacade direccionPreferidaCorrespondenciaText;
	@FindBy (xpath="//select[@class='form-control ng-untouched ng-pristine ng-valid']")
	private WebElementFacade direccionPreferidaCorrespondenciaSelect;
	@FindBy (xpath="//h3[text()='Referencias']")
	private WebElementFacade referenciasText;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/control-box/div/div[2]/wizard-referencia-comercial/div/div/div[1]/control-input-text[1]/div/input")
	private WebElementFacade nombresPrimeraReferenciaTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/control-box/div/div[2]/wizard-referencia-comercial/div/div/div[1]/control-input-text[2]/div/input")
	private WebElementFacade telefonoPrimeraReferenciaTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/control-box/div/div[2]/wizard-referencia-comercial/div/div/div[1]/control-combobox/div/select")
	private WebElementFacade relacionPrimeraReferenciaSelect;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/control-box/div/div[2]/wizard-referencia-comercial/div/div/div[2]/control-input-text[1]/div/input")
	private WebElementFacade nombresSegundaReferenciaTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/control-box/div/div[2]/wizard-referencia-comercial/div/div/div[2]/control-input-text[2]/div/input")
	private WebElementFacade telefonoSegundaReferenciaTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/control-box/div/div[2]/wizard-referencia-comercial/div/div/div[2]/control-combobox/div/select")
	private WebElementFacade relacionSegundaReferenciaSelect;
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
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[2]/control-input-text[1]/div/input")
	private WebElementFacade nombresSegundaReferenciaResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[2]/control-input-text[2]/div/input")
	private WebElementFacade telefonoSegundaReferenciaResumenTextBox;
	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/actualizacion-datos/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/control-box/div/div[2]/wizard-resumen/wizard-referencia-comercial/div/div/div[2]/control-combobox/div/select")
	private WebElementFacade relacionSegundaReferenciaResumenSelect;

	public String getActualizacionDatosTextToAssert(){
		return actualizacionDatosTextToAssert;
	}
	public String getDireccionPreferenciaCorrespondenciaTextToAssert(){
		return direccionPreferenciaCorrespondenciaTextToAssert;
	}
	public String getReferenciasTextToAssert(){
		return referenciasTextToAssert;
	}

	public void ingresarUV(String uv){
		waitForElement(uvTextBox,waitTime).clear();
		uvTextBox.sendKeys(uv);
	}
	public void ingresarManzana(String manzana){
		waitForElement(manzanaTextBox,waitTime).clear();
		manzanaTextBox.sendKeys(manzana);
	}
	public void ingresarBarrio(String barrio){
		waitForElement(barrioTextBox,waitTime).clear();
		barrioTextBox.sendKeys(barrio);
	}
	public void ingresarCalle(String calle){
		waitForElement(calleTextBox,waitTime).clear();
		calleTextBox.sendKeys(calle);
	}
	public void ingresarNroPuerta(String nroPuerta){
		waitForElement(nroPuertaTextBox,waitTime).clear();
		nroPuertaTextBox.sendKeys(nroPuerta);
	}
	public void ingresarPiso(String piso){
		waitForElement(pisoTextBox,waitTime).clear();
		pisoTextBox.sendKeys(piso);
	}
	public void ingresarApartamento(String apartamento){
		waitForElement(apartamentoTextBox,waitTime).clear();
		apartamentoTextBox.sendKeys(apartamento);
	}
	public void ingresarEmail(String email){
		waitForElement(emailTextBox,waitTime).clear();
		emailTextBox.sendKeys(email);
	}
	public void ingresarTelefono(String telefono){
		waitForElement(telefonoTextBox,waitTime).clear();
		telefonoTextBox.sendKeys(telefono);
	}
	public void ingresarCelular(String celular){
		waitForElement(celularTextBox,waitTime).clear();
		celularTextBox.sendKeys(celular);
	}
	public void continuar(){
		String click = "document.querySelector(\"body > app-root > app-paginas > div > div > actualizacion-datos > control-contenedor-paginas > section > div > div > control-wizard-step > control-wizard-container:nth-child(2) > div > button.btn.btn-success.pull-right\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}
	public String getActualizacionDeDatosText(){
		return waitForElement(actualizacionDeDatosText, waitTime).getText();
	}
	public String getDireccionPreferenciaCorrespondenciaText(){
		return waitForElement(direccionPreferidaCorrespondenciaText, waitTime).getText();
	}
	public void seleccionarDireccionPreferidaCorrespondencia(String direccion){
		waitForElement(direccionPreferidaCorrespondenciaSelect, waitTime).isDisplayed();
		selectFromDropdown(direccionPreferidaCorrespondenciaSelect, direccion);
	}
	public void continuarDireccionCorrespondencia(){
		String click = "" +
				"document.querySelector(\"body > app-root > app-paginas > div > div > actualizacion-datos > control-contenedor-paginas > section > div > div > control-wizard-step > control-wizard-container:nth-child(3) > div > button.btn.btn-success.pull-right\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}
	public String getReferenciasText(){
		return waitForElement(referenciasText, waitTime).getText();
	}
	public void ingresarNombresPrimeraReferencia(String nombres){
		waitForElement(nombresPrimeraReferenciaTextBox,waitTime).clear();
		nombresPrimeraReferenciaTextBox.sendKeys(nombres);
	}
	public void ingresarTelefonoPrimeraReferencia(String telefono){
		waitForElement(telefonoPrimeraReferenciaTextBox,waitTime).clear();
		telefonoPrimeraReferenciaTextBox.sendKeys(telefono);
	}
	public void seleccionarRelacionPrimeraReferencia(String relacion){
		waitForElement(relacionPrimeraReferenciaSelect, waitTime).isDisplayed();
		selectFromDropdown(relacionPrimeraReferenciaSelect, relacion);
	}
	public void ingresarNombresSegundaReferencia(String nombres){
		waitForElement(nombresSegundaReferenciaTextBox,waitTime).clear();
		nombresSegundaReferenciaTextBox.sendKeys(nombres);
	}
	public void ingresarTelefonoSegundaReferencia(String telefono){
		waitForElement(telefonoSegundaReferenciaTextBox,waitTime).clear();
		telefonoSegundaReferenciaTextBox.sendKeys(telefono);
	}
	public void seleccionarRelacionSegundaReferencia(String relacion){
		waitForElement(relacionSegundaReferenciaSelect, waitTime).isDisplayed();
		selectFromDropdown(relacionSegundaReferenciaSelect, relacion);
	}
	public void continuarReferenciasPersonales(){
		String click = "" +
				"document.querySelector(\"body > app-root > app-paginas > div > div > actualizacion-datos > control-contenedor-paginas > section > div > div > control-wizard-step > control-wizard-container:nth-child(4) > div > button.btn.btn-success.pull-right\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}
	public String getUvText(){
		return waitForElement(uvTextBox, waitTime).getText();
	}
	public String getManzanaText(){
		return waitForElement(manzanaTextBox, waitTime).getText();
	}
	public String getBarrioText(){
		return waitForElement(barrioTextBox, waitTime).getText();
	}
	public String getCalleText(){
		return waitForElement(calleTextBox, waitTime).getText();
	}
	public String getNroPuertaText(){
		return waitForElement(nroPuertaTextBox, waitTime).getText();
	}
	public String getPisoText(){
		return waitForElement(pisoTextBox, waitTime).getText();
	}
	public String getApartamentoText(){
		return waitForElement(apartamentoTextBox, waitTime).getText();
	}
	public String getEmailText(){
		return waitForElement(emailTextBox, waitTime).getText();
	}
	public String getTelefonoDomicilioText(){
		return waitForElement(telefonoResumenTextBox, waitTime).getText();
	}
	public String getCelularText(){
		return waitForElement(celularResumenTextBox, waitTime).getText();
	}
	public String getDireccionPreferidaText(){
		return waitForElement(direccionPreferidaCorrespondenciaResumenSelect, waitTime).getText();
	}
	public String getNombresPrimeraReferenciaResumen(){
		return waitForElement(nombresPrimeraReferenciaResumenTextBox, waitTime).getText();
	}
	public String getTelefonoPrimeraReferenciaResumen(){
		return waitForElement(telefonoPrimeraReferenciaResumenTextBox, waitTime).getText();
	}
	public String getRelacionPrimeraReferenciaResumen(){
		return waitForElement(relacionPrimeraReferenciaResumenSelect, waitTime).getText();
	}
	public String getNombresSegundaReferenciaResumen(){
		return waitForElement(nombresSegundaReferenciaResumenTextBox, waitTime).getText();
	}
	public String getTelefonoSegundaReferenciaResumen(){
		return waitForElement(telefonoSegundaReferenciaResumenTextBox, waitTime).getText();
	}
	public String getRelacionSegundaReferenciaResumen(){
		return waitForElement(relacionSegundaReferenciaResumenSelect, waitTime).getText();
	}
	public void continuarResumen(){
		String click = "" +
				"document.querySelector(\"body > app-root > app-paginas > div > div > actualizacion-datos > control-contenedor-paginas > section > div > div > control-wizard-step > control-wizard-container:nth-child(5) > div > button.btn.btn-success.pull-right\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();
	}

}
