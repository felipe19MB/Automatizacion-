package com.bg.gnt.pageobjects;

import static org.hamcrest.Matchers.containsString;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.text.ParseException;

import com.ibm.icu.text.NumberFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import com.bg.gnt.pageobjects.BasePage;


public class HomePage extends BasePage{
	
	@FindBy (xpath="//app-tabla-cuenta/div/table/tbody/tr")
	private List<WebElementFacade> gTblCuentas;
	
	@FindBy (xpath="//nav[@class=\"navbar navbar-static-top\"]/seccion-seleccion-sesion")
	private WebElementFacade gWefTipoPerfil;
	
	@FindBy (xpath="//seccion-seleccion-sesion/div/div/li/ul/li[2]/div/ul/li/a")
	private List<WebElementFacade> gLstPerfiles;
	
	@FindBy (xpath="//li[@class=\"user-profile treeview\"]/a/div/span/strong")
	private WebElementFacade gWefTxtNombre;
	
	@FindBy (xpath="//li[@class=\"notifications-menu\"]")
	private WebElementFacade gWefBtnSalir;

	/*
	 * 	Modal actualizacion
	 * 
	 * */
	
	@FindBy (xpath="//dialog-actualizacion-datos-usuario/div/div/div/div/button[text()='Cerrar']")
	private WebElementFacade gWefBtnCerrarActualizacion;
	
	@FindBy (xpath="//dialog-actualizacion-datos-usuario/div/div/div/div/button[text()='Ir']")
	private WebElementFacade gWefBtnIrActualizacion;
	
	
	/*
	 * 	Modal personalizacion
	 * 
	 * */
	@FindBy (xpath="//app-dialog-personalizar-usuario/div/div/div/div/button[text()='cerrar']")
	private WebElementFacade BtnCerrarPersonalizacionElement;
	
	@FindBy (xpath="//app-dialog-personalizar-usuario/div/div/div/div/button[text()='ir']")
	private WebElementFacade gWefBtnIrPersonalizacion;
	
	
	@FindBy	(xpath="//control-checkbox/div/div/div")
	private WebElementFacade gWefCbxNoSugerir;

	@FindBy (xpath="//input[@name='token']")
	private WebElementFacade txtGanapin;  //input[@name='token']
//input[contains(@class, 'ng-touched') and @name='token']

	public void cerrarMsjActualizacion() {
		waitFor(4).seconds();
		gWefBtnCerrarActualizacion.click();
	}
	
	
	public void cerrarMsjPersonalizar() {
		waitFor(10).seconds();
		BtnCerrarPersonalizacionElement.click();
	}
	

	public void seleccionarMenu(List<String> menuList) {
			
		String xpathNombreUsuario = "/html/body/app-root/app-paginas/div/seccion-menu-izquierda/aside/section/ul/li[1]/a/div[2]/span[1]/strong";
		waitUntilElementIsAvailable(xpathNombreUsuario,30);

			JavascriptExecutor js =(JavascriptExecutor)getDriver();
		   waitFor(2).seconds();
		   String xpathExpression = "//SPAN[text()='" + menuList.get(0) + "']";
		   /*
		    *	Otros metodos usados para que la ventana sea mas grande y se pueda hacer clic sobre el metodo 
		    */
		   //getDriver().findElement(By.xpath(xpathExpression))
		   //getDriver().manage().window().fullscreen();
		   // waitFor(2).seconds();
		   //getDriver().manage().window().setSize(new Dimension(3000, 3000));
		   //getDriver().findElement(By.xpath(xpathExpression)).click();
		   js.executeScript("arguments[0].click();",getDriver().findElement(By.xpath(xpathExpression)));

		   
		   for(int i=1;i<menuList.size();i++) {
			   waitFor(2).seconds();
			   /*
			    * Se esta usando JavaScriptExecutor por que usando WebDriver no se puede hacer click 
			    * sobre un elemento que esta visible pero no se puede ver en la ventana.
			    */
			   js.executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//A[text()='"+menuList.get(i)+"']")));
			   /*
			    *	Todos los otros metodos usados para tratar de hacer clic sobre el elemento pero no funcionaron 
			    */
			   //actions.moveToElement(getDriver().findElement(By.xpath("//span[@_ngcontent-c10=''][text()='Informe consolidado']"))).perform();
			   //actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			   //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			   //js.executeScript("window.scrollBy(0,250)", "");
			   //js.executeScript("window.scrollBy(5,622)");
			   //String location1= getDriver().findElement(By.xpath("//A[@_ngcontent-c10=''][text()='"+menuList.get(i)+"']")).getLocation().toString();
			   //getDriver().findElement(By.xpath("//A[@_ngcontent-c10=''][text()='"+menuList.get(i)+"']")).click();
			   //actions.moveToElement(getDriver().findElement(By.xpath("//A[@_ngcontent-c10=''][text()='"+menuList.get(i)+"']")));
			   //actions.click().build().perform();
			   
			   waitFor(2).seconds();
		   }

		   //waitFor(30).seconds();
		   
	}

	public void verificarDatos(List<String> pLstUserData) {
		
		String lStrNombre = pLstUserData.get(0);
		assertThat(gWefTxtNombre.getText(), containsString(lStrNombre));
		waitFor(10).seconds();
	}
	
	public void finalizarSesion() {

		String click = "document.querySelector(\"body > app-root > app-paginas > div > seccion-header > seccion-navbar > header > nav > div > ul > li\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		//gWefBtnSalir.click();
		waitFor(3).seconds();
	}
	
	public void verificarSaldoDisponible(List<String> ArrDatosCuenta ) {
		String lStrNroCuenta = ArrDatosCuenta.get(0);
		Double lNumMonto = Double.parseDouble(ArrDatosCuenta.get(1));		
		Double lNumSaldoDisponible = null;
		for(int i=0; i < (gTblCuentas.size()); i++){
			String auxCuenta = gTblCuentas.get(i).getText();
			if(auxCuenta.contains(lStrNroCuenta)) {
				i++;	//Se aumenta 1 para que se pueda encontrar el elemento correcto de la fila ya que estos empiezan desde 1
				//Expresion xpath para capturar saldo disponible de una fila especifica dentro del a tabla.
				String xpathExpression = "//app-tabla-cuenta/div/table/tbody/tr["+i+"]/td[8]";	//[8]= Columna de la tabla
				String lStrSaldoDisponible = getDriver().findElement(By.xpath(xpathExpression)).getText().split(" ")[0];

				lNumSaldoDisponible = Double.parseDouble(lStrSaldoDisponible.replace(",", ""));

				assertThat(lNumSaldoDisponible, is(greaterThanOrEqualTo(lNumMonto)));

			}
		}
	}
	
	public void cambiarPerfil(List<String> pLstDatosEmpresa) {
		String lStrNombre = pLstDatosEmpresa.get(0).toString();
		waitFor(5).seconds();
		
		String click = "document.querySelector(\"body > app-root > app-paginas > div > seccion-header > seccion-navbar > header > nav > seccion-seleccion-sesion > div > div > li > a > i.fa.fa-caret-down\")" +".click()";
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript(click);
		waitFor(5).seconds();

		//gWefTipoPerfil.click();
		
		int lIntListPerfil = gLstPerfiles.size();
		
		
		for(int i=0; i<lIntListPerfil;i++) {
			String lStrAuxPerfil = gLstPerfiles.get(i).getText();

			if(lStrAuxPerfil.toUpperCase().contains(lStrNombre)) {
								
				WebElement element = getDriver().findElement(By.xpath("//seccion-seleccion-sesion/div/div/li/ul/li[2]/div/ul/li["+i+"]/a"));
				JavascriptExecutor js2 =(JavascriptExecutor)getDriver();
				js2.executeScript("arguments[0].click();", element);
				
				
				//Actions actions = new Actions(getDriver());
				//actions.moveToElement(element).click().perform();
				//actions.moveToElement(element).doubleClick().perform();
				//gLstPerfiles.get(i).click();
				//String click5 = "document.querySelector(\"body > app-root > app-paginas > div > seccion-header > seccion-navbar > header > nav > seccion-seleccion-sesion > div > div > li > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a\")" +".click()";
				//WebElement element1 = gLstPerfiles.get(1);
				//element.click();
				//js2.executeScript(click5);
				i=lIntListPerfil+1;
			}
		}
		
		waitFor(10).seconds();
		
	}

	public void cerrarModalesEmergentes(){
		String xpathTituloActualizacionDatos = "/html/body/app-root/app-paginas/div/div/app-consolidado/dialog-actualizacion-datos-usuario/div/div/div/div[1]/h4";
		String xpathTituloPersonalizacion = "/html/body/app-root/app-paginas/div/div/app-consolidado/app-dialog-personalizar-usuario/div/div/div/div[1]/h4";
		String btnCerrarPersonalizado = "document.querySelector(\"#personalizacion-usuario > div > div > div.modal-footer > button.btn.btn-secondary\")" +".click()";
		String btnCerrarActualizacionDatos = "document.querySelector(\"#actualizacion-datos-usuario > div > div > div.modal-footer > button.btn.btn-secondary\")"+".click()";

		Boolean tituloActualizacionDatosPresente = isPresent(xpathTituloActualizacionDatos) ;
		if(tituloActualizacionDatosPresente == true){
			JavascriptExecutor js =(JavascriptExecutor)getDriver();
			js.executeScript(btnCerrarActualizacionDatos);
		}
		Boolean tituloPersonalizacionPresente = isPresent(xpathTituloPersonalizacion);
		if(tituloPersonalizacionPresente == true){
			JavascriptExecutor js =(JavascriptExecutor)getDriver();
			js.executeScript(btnCerrarPersonalizado);
		}

	}

	public void confirmarOperacionGanapin(int ganapin){
		waitForElement(txtGanapin);
		txtGanapin.sendKeys(Integer.toString(ganapin));
		String xBtnProcesar = "//button[@type='submit']";
		clickByXpath(xBtnProcesar);
	}
}
