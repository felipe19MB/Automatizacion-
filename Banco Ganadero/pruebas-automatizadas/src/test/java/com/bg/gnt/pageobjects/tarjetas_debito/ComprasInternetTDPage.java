package com.bg.gnt.pageobjects.tarjetas_debito;

import com.bg.gnt.pageobjects.NewBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComprasInternetTDPage extends NewBasePage {
    public ComprasInternetTDPage(WebDriver driver) {
        super(driver);
    }
    By siguienteBtnBy = By.xpath("//button[contains(text(),'Siguiente')]");
    By selectorHoyRdoBy = By.xpath("//label[contains(text(),'Hoy')]");
    By selectorTemporalRdoBy = By.xpath("//label[contains(text(),'Temporal por rango de fechas')]");
    By procesarBtnBy = By.xpath("//control-box[1]//button[contains(text(),'Procesar')]");
    By fechaDesdeTxtBy = By.xpath("//label[contains(text(),'Desde')]/following-sibling::input");
    By fechaHastaTxtBy = By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input");
    By importeTxtBy = By.xpath("//app-compras-internet[1]//app-habilitar-tarjeta-debito[1]//control-box[1]//input[@type='number']");
    public ComprasInternetTDPage habilitarComprasHoy(String importe) {
        clickJs(siguienteBtnBy);
        clickJs(selectorHoyRdoBy);
        writeText(importeTxtBy, importe);
        clickJs(procesarBtnBy);
        return this;
    }
    public ComprasInternetTDPage habilitarComprasRangos(String importe, String fechaDesde, String fechaHasta){
        clickJs(siguienteBtnBy);
        clickJs(selectorTemporalRdoBy);
        fechaDesde=sumarDiasAFecha(getToday(),Integer.parseInt(fechaDesde));
        writeText(fechaDesdeTxtBy, fechaDesde);
        fechaHasta = sumarDiasAFecha(fechaDesde,Integer.parseInt(fechaHasta));
        writeText(fechaHastaTxtBy,fechaHasta);
        writeText(importeTxtBy, importe);
        clickJs(procesarBtnBy);
        return this;

    }
}
