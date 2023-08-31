package com.bg.gnt.pageobjects.ganaMovil;
import com.bg.gnt.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HabilitacionGanaMovilPage extends BasePage {
	private final int waitTime = 60;
	private final String habilitacionDispositivoTextToAssert = "Habilitación de Dispositivo";
	private String _imeiMac = "";
	private String _rowNumber = "";

	@FindBy (xpath="/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[1]/h3")
	private WebElementFacade habilitacionDispositivoText;
	@FindBy (xpath = "//input[@type='number']")
	private WebElementFacade telefonoTextBox;
	@FindBy (xpath = "//button[@class='btn btn-info btn-lg btn-block'][text()='Continuar']")
	private WebElementFacade continuarButton;
	@FindBy (xpath="//*[@class='input-group mb-3']//child::input[1]")
	private WebElementFacade tokenTextBox;
	@FindBy (xpath="//*[@id=\"modal-segundo-factor\"]/div/div/div[2]/form/div/div[4]/button")
	private WebElementFacade procesarButton;
	@FindBy (xpath = "//*[@id='swal2-content']")
	private WebElementFacade mensajeExitoText;
	@FindBy (xpath = "/html/body/div[2]/div/div[3]/button[1]")
	private WebElementFacade okButton;

	public String getHabilitacionDispositivoTextToAssert(){
		return habilitacionDispositivoTextToAssert;
	}

	public String getHabilitacionDispositivoText(){
		return waitForElement(habilitacionDispositivoText, waitTime).getText();
	}
	public String getImeiMac(){
		return _imeiMac;
	}
	public String getRowNumber(){
		return _rowNumber;
	}
	public void setImeiMac(String imei){
		_imeiMac = imei;
	}
	public void setRowNumber(String rowNumber){
		_rowNumber = rowNumber;
	}

	public void seleccionarDispositivo(String estado){
		estado = retornarEstadoDispositivo(estado);
		int cantidadColumnas = 0;
		int cantidadFilas = 0;
		List<WebElement> rows = getDriver().findElements(By.xpath("/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[2]/app-tabla-dispositivos/div[1]/table/tbody/tr"));
		cantidadFilas = rows.size();
		List<WebElement> columns = getDriver().findElements(By.xpath("/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[2]/app-tabla-dispositivos/div[1]/table/tbody/tr[1]/th"));
		cantidadColumnas = columns.size();
		System.out.println("size of rows: " + cantidadFilas);
		System.out.println("size of columns: " + cantidadColumnas);

		try{
			for (int i = 2 ; i <= cantidadFilas ; i++ ) {
				WebElement textElement = getDriver().findElement(By.xpath("/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[2]/app-tabla-dispositivos/div[1]/table/tbody/tr[" + i + "]/td[4]/p/b"));
				String textoDelElemento = waitForElement(textElement, waitTime).getText();
				if (textoDelElemento.equals(estado)) {
					String buttonXpath = "/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[2]/app-tabla-dispositivos/div[1]/table/tbody/tr[" + i + "]/td[7]/a/i";
					WebElement imeiTextElement = getDriver().findElement(By.xpath("/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[2]/app-tabla-dispositivos/div[1]/table/tbody/tr[" + i + "]/td[2]/span"));
					setImeiMac(imeiTextElement.getText());
					setRowNumber(Integer.toString(i));
					clickByXpath(buttonXpath);
					break;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
	}

	public String obtenerEstadoDispositivo(){
		WebElement textElement = getDriver().findElement(By.xpath("/html/body/app-root/app-paginas/div/div/app-habilitacion/control-contenedor-paginas/section/div/div/div[2]/control-box/div/div[2]/app-tabla-dispositivos/div[1]/table/tbody/tr["+getRowNumber()+"]/td[4]/p"));
		return waitForElement(textElement,waitTime).getText();
	}

	public String retornarEstadoDispositivo(String estado){

		if (estado.equals("P")){
			estado = "Pendiente";
			return estado;
		}
		if (estado.equals("B")){
			estado = "Bloqueado";
			return estado;
		} else {
			return estado = "Habilitado";
		}
	}

	public void ingresarNumeroTelefono(String telefono){
		waitForElement(telefonoTextBox, waitTime).sendKeys(telefono);
	}
	public void continuar(){
		waitForElement(continuarButton, waitTime).click();
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
