package com.bg.gnt.pageobjects.acceso;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import com.bg.gnt.pageobjects.BasePage;
import com.bg.gnt.util.Log;
import com.bg.gnt.util.database.UtilsDB;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://devganamovil.bg.com.bo/apps/GanaNet/#_Site")
public class IniciarSesionPage extends BasePage {
	
	
	@FindBy(xpath="//div[@class='form-group']/select", timeoutInSeconds="60")
	private WebElementFacade cmbTipoUsuario;
	
	@FindBy(xpath="//div[@class='form-group']/div/input[@type='text']", timeoutInSeconds="60")
	private WebElementFacade txtUsuario;
	
	@FindBy(xpath="//BUTTON[@_ngcontent-c1=''][text()='Verificar']")
	private WebElementFacade btnVerificar;
	
	@FindBy(xpath="//div[@class='form-group mb-0']/div/input[@type='password']")
	private WebElementFacade txtPassword;
	
	@FindBy(xpath="//BUTTON[@_ngcontent-c1=''][text()='Ingresar']")
	private WebElementFacade btnIngresar;
	
	@FindBy(xpath="//li[@class=\"notifications-menu\"]/a/i")
	private WebElementFacade btnSalir;
	
	
	/*
	 * Modal Contrato
	 * */
	@FindBy(xpath="//contenido-contrato/div/div/div/label")
	private WebElementFacade gWefCbxAcepto;
	
	
	@FindBy(xpath="//button[text()='Continuar']")
	private WebElementFacade gWefBtnAcepto;
	
	
	@FindBy(xpath="//button[text()='Cerrar']")
	private WebElementFacade gWefBtnCerrar;
	
	/*
	 * 	Modal seleccion de imagenes
	 * */
	
	@FindBy(xpath="//contenido-cambio-imagen/div/div/img")
	private List<WebElementFacade> gLstImagenes;
	
	
	
	/*
	 * 	Modal cambio de clave de acceso
	 * */
	
	@FindBy(xpath="//input[@formcontrolname='claveActual']")
	private WebElementFacade gWefTxtClaveActual;
	
	
	@FindBy(xpath="//input[@formcontrolname='claveNueva']")
	private WebElementFacade gWefTxtClaveNueva;
	
	@FindBy(xpath="//input[@formcontrolname='claveConfirmacion']")
	private WebElementFacade gWefTxtConfirmarClave;
	
	@FindBy(xpath="//button[text()='Continuar']")
	private WebElementFacade gWefBtnContinuar;
	
	@FindBy(xpath="//button[text()=' Cerrar']")		//Este xpath se debe quitar el espacio entre el texto Cerrar, una vez se haya corregido en el frontend
	private WebElementFacade gWefBtnCerrar2;		
	
	@FindBy(xpath="//div[@id='swal2-content']")
	private WebElementFacade gWefLblMensaje;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElementFacade gWefBtnOK;



	
	public void aceptarContrato() {
		waitFor(4).seconds();
		gWefCbxAcepto.click();
		waitFor(3).milliseconds();
		gWefBtnAcepto.click();
	}
	
	public void seleccionarImagen() {
		
		//	Hacer un metodo para seleccionar de forma dinamica una imagen de la lista
		waitFor(4).seconds();
		gLstImagenes.get(0).click();
		
		waitFor(7).seconds();
		gWefBtnAcepto.click();
		
		waitFor(45).seconds();
	}


	
	public void autenticar(List<String> userTable) {
		
		//	Inicializando el ambiente Log4j 
		DOMConfigurator.configure("log4j.xml");
		//	Registro del log inicio
		Log.startTestCase("Iniciar sesion");

    	waitFor(20).seconds();
		getDriver().switchTo().frame(0);
		//getDriver().manage().window().setSize(new Dimension(1280,960));
		getDriver().manage().window().maximize();
		//getDriver().manage().window().fullscreen();
		txtUsuario.waitUntilClickable();
		String xpathUsuario = "/html/body/app-root/seguridad-login/div[2]/div/div[2]/div/div[3]/form/control-input-text/div/div/input";
		waitUntilElementIsAvailable(xpathUsuario,20);
		cmbTipoUsuario.selectByValue(userTable.get(0));
		txtUsuario.sendKeys(userTable.get(1));
		//waitFor(15).seconds();
		String click = "document.querySelector(\"body > app-root > seguridad-login > div.contents.h-p100 > div > div.col-lg-4.col-md-8.col-12 > div > div.loading > form > div.form-group.mb-0 > div > button\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		//waitFor(15).seconds();
		//btnVerificar.click();
		//btnVerificar.click();
		String xpathPassword = "/html/body/app-root/seguridad-login/div[2]/div/div[2]/div/div[3]/form/div[2]/div/input";
		waitUntilElementIsAvailable(xpathPassword,20);
		txtPassword.sendKeys(userTable.get(2));
		//waitFor(3).seconds();
		String clic2 = "document.querySelector(\"body > app-root > seguridad-login > div.contents.h-p100 > div > div.col-lg-4.col-md-8.col-12 > div > div.loading.pb-3 > form > div.row.mt-10 > div.col-9.text-center > button\")" +".click()";
		js.executeScript(clic2);
		//btnIngresar.click();
		//waitFor(30).seconds();
		
		//	Registro del log fin
		Log.endTestCase("Iniciar sesion");
	}
	
	
	public void ingresarClaveActual(String pStrClaveActual) {
		gWefTxtClaveActual.sendKeys(pStrClaveActual);
		waitFor(3).seconds();
	}
	
	public void ingresarClaveNueva(String pStrClaveNueva) {
		gWefTxtClaveNueva.sendKeys(pStrClaveNueva);
		waitFor(3).seconds();
	}
	
	public void confirmarClave(String pStrClaveNueva) {
		gWefTxtConfirmarClave.sendKeys(pStrClaveNueva);
		waitFor(3).seconds();
	}
	
	public void continuar() {
		gWefBtnContinuar.click();
		waitFor(8).seconds();
	}
	
	public void verificarMensaje(String pStrMensaje) {
		assertThat(gWefLblMensaje.getText(),containsString(pStrMensaje));
		gWefBtnOK.click();
		waitFor(3).seconds();
	}

	public void aceptarContratoSiAparece(){
		String xpathTituloContrato = "/html/body/app-root/seguridad-login/seguridad-dialog-configuracion/div/div/div/div/control-wizard-step/control-wizard-container[1]/div/div/contenido-contrato/div/div[1]/h5";
		String checkAceptarContrato = "document.querySelector(\"#dialog-configuracion-seguridad > div > div > div > control-wizard-step > control-wizard-container:nth-child(2) > div > div > contenido-contrato > div > div:nth-child(2) > div > label\")"+".click()";
		String btnContinuarContrato = "document.querySelector(\"#dialog-configuracion-seguridad > div > div > div > control-wizard-step > control-wizard-container:nth-child(2) > div > div > div > button.btn.btn-success.pull-right\")"+".click()";

		//Cerrar modal de contrato
		if(isPresent(xpathTituloContrato)){
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript(checkAceptarContrato);
			js.executeScript(btnContinuarContrato);
		}
	}
	public void cerrarModalesEmergentes(){
		String xpathTituloContrato = "/html/body/app-root/seguridad-login/seguridad-dialog-configuracion/div/div/div/div/control-wizard-step/control-wizard-container[1]/div/div/contenido-contrato/div/div[1]/h5";
		String checkAceptarContrato = "document.querySelector(\"#dialog-configuracion-seguridad > div > div > div > control-wizard-step > control-wizard-container:nth-child(2) > div > div > contenido-contrato > div > div:nth-child(2) > div > label\")"+".click()";
		String btnContinuarContrato = "document.querySelector(\"#dialog-configuracion-seguridad > div > div > div > control-wizard-step > control-wizard-container:nth-child(2) > div > div > div > button.btn.btn-success.pull-right\")"+".click()";

		//Cerrar modal de contrato
		if(isPresent(xpathTituloContrato)){
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript(checkAceptarContrato);
			js.executeScript(btnContinuarContrato);
		}
		//Cerrar modal de clave de acceso
		String xpathTituloClaveAcceso = "/html/body/app-root/seguridad-login/seguridad-dialog-configuracion/div/div/div/div/control-wizard-step/control-wizard-container[2]/div/div/contenido-cambio-clave/div[1]/div/h3/strong";
		String btnContinuarClave = "document.querySelector(\"#dialog-configuracion-seguridad > div > div > div > control-wizard-step > control-wizard-container:nth-child(3) > div > div > div > button.btn.btn-success.pull-right\")"+".click()";
		String btnCambioClaveOk ="document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\")"+".click()";
		if(isPresent(xpathTituloClaveAcceso)){
			gWefTxtClaveActual.sendKeys("1234");
			gWefTxtClaveNueva.sendKeys("0000");
			gWefTxtConfirmarClave.sendKeys("0000");
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript(btnContinuarClave);
			js.executeScript(btnCambioClaveOk);
		}

		//Cerrar modal de clave transaccional
		String xpathTituloClaveTransaccional = "/html/body/app-root/seguridad-login/seguridad-dialog-configuracion/div/div/div/div/control-wizard-step/control-wizard-container[3]/div/div/contenido-cambio-clave-transaccional/div[1]/div/h3/strong";
		String btnContinuarClaveTrans = "document.querySelector(\"#dialog-configuracion-seguridad > div > div > div > control-wizard-step > control-wizard-container:nth-child(4) > div > div > div > button.btn.btn-success.pull-right\")"+".click()";
		String btnCambioClaveTransOk ="document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\")"+".click()";
		if(isPresent(xpathTituloClaveTransaccional)){
			gWefTxtClaveActual.sendKeys("1234");
			gWefTxtClaveNueva.sendKeys("12345678");
			gWefTxtConfirmarClave.sendKeys("12345678");
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript(btnContinuarClaveTrans);
			js.executeScript(btnCambioClaveTransOk);
		}



	}


}