package com.bg.gnt.pageobjects.transferencias;

import java.util.List;

import com.bg.gnt.pageobjects.BasePage;
import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CtaExteriorPage extends BasePage {

	/*	Paso Terminos	*/
	@FindBy(xpath="//app-seccion-terminos/div/div/div/div")
	private WebElementFacade gWefCbxAcepto;
	
	@FindBy(xpath="//button[text()='Siguiente']")
	private WebElementFacade gWefBtnSiguiente;
	
	
	/*	Paso Cargos	*/
	@FindBy(xpath="//div[@class=\"col-md-4\"]/control-table-cuenta/div/div/div/div")
	private List <WebElementFacade> gWefLstCtaOrigen;
	
	@FindBy (xpath="//span[@class=\"dropdown-toggle\"]")
	private WebElementFacade gWefCmbMoneda;
	
	@FindBy (xpath="//control-input-monto/div/input")
	private WebElementFacade gWefTxtMonto;
	
	@FindBy (xpath="//div[@class='radio']")
	private List<WebElementFacade> gWefLstCargos;
	
	@FindBy(xpath="(//control-input-text)[1]/div/input")
	private WebElementFacade gWefTxtNombreFactura;
	
	
	@FindBy(xpath="(//control-input-text)[2]/div/input")
	private WebElementFacade gWefTxtNroFactura;
	
	
	//xpression =//div[@class='radio']/label[text()='Cargo Compartido']
	
	@FindBy (xpath="//a[text()='Ver detalle']")
	private WebElementFacade gWefBtnVerDetalle;
	
	@FindBy (xpath="//button[text()='Atras']")
	private WebElementFacade gWefBtnAtras;
	
	/*	Paso Ordenante	*/
	
	@FindBy(xpath="(//control-input-text/div/input)[7]")
	private WebElementFacade gWefTxtMail;
	
	
	@FindBy(xpath="(//control-input-text/div/input)[8]")
	private WebElementFacade gWefTxtTelefono;
	

	/*	Paso Beneficiario	*/
	
	@FindBy(xpath="//app-seccion-beneficios/div/div/div/table/tbody/tr")
	private List<WebElementFacade> gWefLstBeneficiarios;
	
	
	
	/*	Paso Descripcion	*/
	
	@FindBy(xpath="//select")
	private WebElement gWefCmbCodigoASFI;
	
	@FindBy(xpath="//control-combobox[@ng-reflect-label='Nro. Factura/Recibo']/div/select")
	private WebElementFacade gWefCmbTipoDocumento;
	
	@FindBy(xpath="//textarea")
	private WebElementFacade gWefTxtMotivoTrans;
	
	@FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-exterior/control-wizard-step/control-wizard-container[5]/app-seccion-descripcion/div/div[2]/control-box/div/div[2]/div/div[2]/control-input-text/div/input")
	private WebElementFacade gWefTxtAgencia;
	
	@FindBy(xpath="//button[text()='Adjuntar..']")
	private WebElementFacade gWefBtnAdjuntar;
	
	
	/*	Paso Resumen	*/
		
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[1]")
	private WebElementFacade gWefLblCuentaR;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[2]")
	private WebElementFacade gWefLblImporteR;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[3]")
	private WebElementFacade gWefLblComiciones;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[4]")
	private WebElementFacade gWefLblBancoIntermediario;
	
	//Banco del Beneficiario
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[5]")
	private WebElementFacade gWefLblTipoBancoBB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[6]")
	private WebElementFacade gWefLblCtaCodigoBB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[7]")
	private WebElementFacade gWefLblNombreBB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[8]")
	private WebElementFacade gWefLblPaisBB;
	
	//Datos del beneficiario
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[9]")
	private WebElementFacade gWefLblCtaIBANDB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[10]")
	private WebElementFacade gWefLblNombreDB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[11]")
	private WebElementFacade gWefLblDireccionDB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[12]")
	private WebElementFacade gWefLblPaisDB;
	
	//Informacion de la transferencia
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[13]")
	private WebElementFacade gWefLblMotivoTransDB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[14]")
	private WebElementFacade gWefLblAgenciaDB;

	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[15]")
	private WebElementFacade gWefLblCodigoASFIDB;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[16]")
	private WebElementFacade gWefLblNombreFactura;
	
	@FindBy(xpath="//app-seccion-resumen/section/div/div/control-box/div/div/div/div/div/h6[17]")
	private WebElementFacade gWefLblNIT;
	
	@FindBy(xpath="//button[text()='Finalizar']")
	private WebElementFacade gWefBtnFinalizar;
	
	
	
	
	/*		Paso Ganapin	*/
	
	@FindBy (xpath="//input[@type='password']")
	private WebElementFacade gWefTxtGanapin;
	
	@FindBy (xpath="//button[text()='Procesar']")
	private WebElementFacade gWefBtnProcesar;
	
	
	/*	Comprobante	*/
	
	@FindBy(xpath="//button[text()='Imprimir']")
	private WebElementFacade gWefBtnImprimir;
	
	@FindBy(xpath="//button[text()='Cerrar']")
	private WebElementFacade gWefBtnCerrar;
	
	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div/div/h6[contains(text(),'Ord.:')]")
	private WebElementFacade gWefLblOrdenante;
	
	
	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div/div/h6[contains(text(),'Cuenta')]")
	private WebElementFacade gWefLblCuenta;
	
	
	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div/div/h6[contains(text(),'Benef.:')]")
	private WebElementFacade gWefLblBeneficiario;

	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div[5]")
	private WebElementFacade gWefLblCargoOUR;
	
	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div[6]")
	private WebElementFacade gWefLblComisionITF;
	
	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div[7]")
	private WebElementFacade gWefLblCapitalITF;
	
	@FindBy(xpath="//div[@id='contentPDFComprobante']/div/div/div/div/div/div[contains(text(),'Equivalentes a')]")
	private WebElementFacade gWefLblEquivalente;
	
	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro del paso terminos y condiciones
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	public void aceptarTerminos() {
		String xpathAceptarTermino = "//app-seccion-terminos/div/div/div/div";
		clickByXpath(xpathAceptarTermino);
	}
	public void siguiente() {
		clickButton("Siguiente");
	}
	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro del paso Cargos
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	
	public void  seleccionarCtaOrigen(String pStrNroCuenta) {

		for(int i=0;i<(gWefLstCtaOrigen.size());i++) {
			String nroCtaAuxiliar= gWefLstCtaOrigen.get(i).getText();
			if(nroCtaAuxiliar.contains(pStrNroCuenta)) {
				gWefLstCtaOrigen.get(i).click();
			}
		}
	}
	
	public void seleccionarMoneda(String pStrMoneda) {
		String xCbxMoneda = "//a[text()='"+" "+pStrMoneda+"']";
		clickByXpath(xCbxMoneda);

	}
	
	
	public void ingresarMonto(String pStrMonto) {
		String xTxtMonto = "//control-input-monto/div/input";
		clickByXpath(xTxtMonto);
		gWefTxtMonto.clear();
		gWefTxtMonto.sendKeys(pStrMonto);


	}
	
	public void seleccionarCargo(String pStrTipoCargo) {
		String xLblCargo="//div/label[contains(text(),'"+pStrTipoCargo+"')]";
		clickByXpath(xLblCargo);

	}
	
	public void ingresarNombreFact(String pStrNombreFact) {
		gWefTxtNombreFactura.clear();
		gWefTxtNombreFactura.sendKeys(pStrNombreFact);

		
	}
	
	public void ingresarNroFact(String pStrNroFactura) {
		gWefTxtNroFactura.clear();
		gWefTxtNroFactura.sendKeys(pStrNroFactura);

	}
	
	
	public void atras() {
		gWefBtnAtras.click();
	}

	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro paso Ordenante
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	public void ingresarMail(String pStrMail1) {
		gWefTxtMail.clear();
		gWefTxtMail.sendKeys(pStrMail1);
	}

	public void ingresarTelefono(String pStrTelefono) {
		gWefTxtTelefono.clear();
		gWefTxtTelefono.sendKeys(pStrTelefono);
	}
	
	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro paso Beneficiario
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	
	
	public void seleccionarBeneficiario(String pStrBeneficiario) {
		Integer cantidadBeneficiarios = gWefLstBeneficiarios.size();
		for(int i=0;i<(cantidadBeneficiarios);i++) {
			String lStrAuxBeneficiario=gWefLstBeneficiarios.get(i).getText();
			if(lStrAuxBeneficiario.contains(pStrBeneficiario)) {
				String posicion = Integer.toString(i+1);
				String lStrXpression = "/html/body/app-root/app-paginas/div/div/app-exterior/control-wizard-step/control-wizard-container[4]/app-seccion-beneficios/div/div[2]/div/table/tbody/tr["+posicion+"]/td[1]/div";
				//String lStrXpression = "//app-seccion-beneficios/div/div/div/table/tbody/tr['"+i+"']/td/div/label";
				clickByXpath(lStrXpression);
				i=cantidadBeneficiarios+1;

			}
		}
		scrollToBottom();
	}

	
	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro del paso Descripcion
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	
	public void ingresarCodASFI(String pStrCodASFI) {
		selectByText(gWefCmbCodigoASFI, pStrCodASFI);
		waitFor(3).seconds();
	}

	public void ingresarTipoDoc(String pStrTipoDocumento) {
		gWefCmbTipoDocumento.deselectByValue(pStrTipoDocumento);
		waitFor(3).seconds();
	}
	
	public void ingresarMotivo(String pStrMotivo) {
		gWefTxtMotivoTrans.sendKeys(pStrMotivo);
		waitFor(3).milliseconds();
	}
	
	public void ingresarAgencia(String pStrAgencia) {
		gWefTxtAgencia.sendKeys(pStrAgencia);
		waitFor(3).seconds();
	}
	
	public void seleccionarArchivo(String pStrArchivo) {
		
	}
	

	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro del paso resumen
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	
	public void verificarResumen(List<String> pLstDatosResumen) {
		assertThat(gWefLblCuentaR.getText(),containsString(pLstDatosResumen.get(0)));
		assertThat(gWefLblImporteR.getText(),containsString(pLstDatosResumen.get(1)));
		assertThat(gWefLblComiciones.getText(),containsString(pLstDatosResumen.get(2)));
		assertThat(gWefLblBancoIntermediario.getText(),containsString(pLstDatosResumen.get(3)));
		assertThat(gWefLblTipoBancoBB.getText(),containsString(pLstDatosResumen.get(4)));
		assertThat(gWefLblCtaCodigoBB.getText(),containsString(pLstDatosResumen.get(5)));
		assertThat(gWefLblNombreBB.getText(),containsString(pLstDatosResumen.get(6)));
		assertThat(gWefLblPaisBB.getText(),containsString(pLstDatosResumen.get(7)));
		assertThat(gWefLblCtaIBANDB.getText(),containsString(pLstDatosResumen.get(8)));
		assertThat(gWefLblNombreDB.getText(),containsString(pLstDatosResumen.get(9)));
		assertThat(gWefLblDireccionDB.getText(),containsString(pLstDatosResumen.get(10)));
		assertThat(gWefLblPaisDB.getText(),containsString(pLstDatosResumen.get(11)));
		assertThat(gWefLblMotivoTransDB.getText(),containsString(pLstDatosResumen.get(12)));
		assertThat(gWefLblAgenciaDB.getText(),containsString(pLstDatosResumen.get(13)));
		assertThat(gWefLblCodigoASFIDB.getText(),containsString(pLstDatosResumen.get(14)));
		assertThat(gWefLblNombreFactura.getText(),containsString(pLstDatosResumen.get(15)));
		assertThat(gWefLblNIT.getText(),containsString(pLstDatosResumen.get(16)));
	
		
	
	}
	
	public void finalizar() 
	{
		scrollToBottom();
		clickButton("Finalizar");
	}
	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro del formulario Segundo factor
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	public void ingresarSegFactor(String pStrSegFactor)
	{
		gWefTxtGanapin.sendKeys(pStrSegFactor);
		waitFor(2).seconds();
	}
	
	public void procesar()
	{
		gWefBtnProcesar.click();
		waitFor(6).seconds();
	}
	
	
	/*========================================================================================
    Autor      : Helmut Hodin Z
    Fecha      : 11/03/2020
    Descripcion: Metodos usados dentro del comprobante de transferencias al exterior
    Referencia : 
    ========================================================================================
    --
    --Historico de Modificaciones
    ========================================================================================
    Autor      : 
    Fecha      : 
    Descripcion: 
    Referencia : 
    ========================================================================================*/
    
	
	public void imprimirComprobante() {
		gWefBtnImprimir.click();
		waitFor(5).seconds();
	}

	public String getValor(String etiqueta){
		String xEtiquetas = "//app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/div/div/div[1]";
		List<WebElement> listEtiquetas = findElements(xEtiquetas);
		Integer cantidadEtiquetas = listEtiquetas.size();
		String valor = "0";
		for(int i = 5; i <= cantidadEtiquetas; i++){
			String xEtiqueta = "//app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/div/div["+i+"]/div[1]";
			WebElement elementEtiqueta = findElement(xEtiqueta);
			String text = elementEtiqueta.getText();
			if(text.contains(etiqueta)){
				String xValor = "//app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/div/div["+i+"]/div[2]/div/div[1]";
				WebElement elementValor = findElement(xValor);
				valor = elementValor.getText();
				i = cantidadEtiquetas+1;
			}
		}
		return valor;
	}
	
	public void verificarComprobanteOUR(List <String> pLstDatosComprobante) {
		
		assertThat(gWefLblOrdenante.getText(),containsString(pLstDatosComprobante.get(0)));
		assertThat(gWefLblCuenta.getText(),containsString(pLstDatosComprobante.get(1)));
		assertThat(gWefLblBeneficiario.getText(),containsString(pLstDatosComprobante.get(2)));
		assertThat(gWefLblCargoOUR.getText(),containsString(pLstDatosComprobante.get(4)));
		assertThat(gWefLblComisionITF.getText(),containsString(pLstDatosComprobante.get(5)));
		assertThat(gWefLblCapitalITF.getText(),containsString(pLstDatosComprobante.get(6)));
		assertThat(gWefLblEquivalente.getText(),containsString(pLstDatosComprobante.get(7)));
		
	}
	
	
	
	
	
	
}
