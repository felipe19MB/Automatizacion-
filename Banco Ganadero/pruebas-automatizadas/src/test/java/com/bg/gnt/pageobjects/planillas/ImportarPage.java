package com.bg.gnt.pageobjects.planillas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.bg.gnt.pageobjects.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ImportarPage extends BasePage{
	
	@FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[2]/app-cargar-archivo/control-box/div/div[2]/div/div[2]/div/control-combobox/div/select", timeoutInSeconds="60")
	private WebElementFacade gWebCmbConvenio;
	
	@FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[2]/app-cargar-archivo/control-box/div/div[2]/div/div[3]/div[1]/control-input-text/div/input")
	private WebElementFacade gWebTxtNombre;
	
	@FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-pago-planilla/control-wizard-step/control-wizard-container[2]/app-cargar-archivo/control-box/div/div[2]/div/div[2]/div/control-combobox/div/select")
	private WebElementFacade gWebCmbConvenios;
	
	public void seleccionarFormaPago(String pStrFormaPago) {
		
		WebElement gWelChkFormaPago = getDriver().findElement(By.xpath("//div[@class='c-inputs-stacked']/div/label[contains(text(),'"+pStrFormaPago+"')]"));
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", gWelChkFormaPago);
	}
	
	public void seleccionarTipoServicio(String pStrConvenio) {
			//String lStrConvenio = gWebCmbConvenios.toString();
			//assertThat(lStrConvenio, not(containsText(pStrConvenio)));
			//gWebCmbConvenios.selectByValue(pStrConvenio);
			boolean prueba= gWebCmbConvenios.containsSelectOption(pStrConvenio);
			assertFalse(gWebCmbConvenios.containsSelectOption(pStrConvenio));
	}
	
	
}
