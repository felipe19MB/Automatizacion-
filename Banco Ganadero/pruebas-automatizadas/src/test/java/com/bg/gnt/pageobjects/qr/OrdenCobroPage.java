package com.bg.gnt.pageobjects.qr;

import com.bg.gnt.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrdenCobroPage extends BasePage {

    @FindBy(xpath="//div/control-table-cuenta/div/div/div/div/div")
    private List<WebElementFacade> tblSelCtaOrigen;

    public void seleccionarCtaOrigen(String nroCuenta){
        for(int i=0; i<(tblSelCtaOrigen.size());i++) {
            String nroCtaAuxiliar= tblSelCtaOrigen.get(i).getText();
            if(nroCtaAuxiliar.contains(nroCuenta)) {
                String xRbtCtaDebito = "//control-table-cuenta/div/div[2]/div/div["+(i+1)+"]/div/div";
                clickByXpath(xRbtCtaDebito);
            }
        }
    }
    public void seleccionarTipoCobro(String tipoCobro){
        String tipoCobroXpath = "/html/body/app-root/app-paginas/div/div/app-generar-cobro/control-contenedor-paginas/section/div/div/div/div[2]/control-box/div/div[2]/div/div[1]/control-combobox/div/select";
        Select tipoCobroSelect = new Select(findElement(tipoCobroXpath));
        tipoCobroSelect.selectByVisibleText(tipoCobro);
    }
    public void seleccionarFechaVencimiento(String fechaVencimiento){
        String fechaVencimientoXpath = "/html/body/app-root/app-paginas/div/div/app-generar-cobro/control-contenedor-paginas/section/div/div/div/div[2]/control-box/div/div[2]/div/div[2]/control-combobox/div/select";
        Select fechaVencimientoSelect = new Select(findElement(fechaVencimientoXpath));
        fechaVencimientoSelect.selectByVisibleText(fechaVencimiento);
    }

    public void seleccionarMoneda(String moneda){
        String monedaXpath = "/html/body/app-root/app-paginas/div/div/app-generar-cobro/control-contenedor-paginas/section/div/div/div/div[2]/control-box/div/div[2]/div/div[3]/control-combobox/div/select";
        Select monedaSelect = new Select(findElement(monedaXpath));
        monedaSelect.selectByVisibleText(moneda);
    }

    public void ingresarMonto(String monto){
        String montoXpath = "/html/body/app-root/app-paginas/div/div/app-generar-cobro/control-contenedor-paginas/section/div/div/div/div[2]/control-box/div/div[2]/div/div[4]/div/control-input-monto/div/input";
        WebElement montoElement = findElement(montoXpath);
        montoElement.sendKeys(monto);
    }

    public void ingresarDescripcion(String descripcion){
        String descripcionXpath = "/html/body/app-root/app-paginas/div/div/app-generar-cobro/control-contenedor-paginas/section/div/div/div/div[2]/control-box/div/div[2]/div/div[5]/control-input-text/div/input";
        WebElement descripcionElement = findElement(descripcionXpath);
        descripcionElement.sendKeys(descripcion);
    }

    public void clicGenerar(){
        clickButton("Generar");
    }

    public void ingresarSegundoFactor(String ganapin){
        String ganapinXpath= "//*[@id=\"modal-segundo-factor\"]/div/div/div[2]/form/div/div[3]/div/div/input";
        WebElement ganapinElement = findElement(ganapinXpath);
        ganapinElement.sendKeys(ganapin);
    }

    public void clicProcesar(){
        clickButton("Procesar");
    }


    public void cerrarQR(){
        clickButton("Cerrar");
    }
}
