package com.bg.gnt.pageobjects.tarjetas_debito;

import com.bg.gnt.pageobjects.NewBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LimitesDeControlPage extends NewBasePage {
    public LimitesDeControlPage(WebDriver driver) {
        super(driver);
    }
    By siguienteBtnBy = By.xpath("//button[contains(text(),'Siguiente')]");
    By importeTxtBy = By.xpath("//label[contains(text(),'Importe')]/following-sibling::input");
    By cantidadTxtBy = By.xpath("//label[contains(text(),'Cantidad')]/following-sibling::input");
    By fechaVencimientoTxtBy = By.xpath("//app-habilitar-limite-control[1]//control-box[1]//input[@type='date']");
    By procesarBtnBy = By.xpath("//control-box[1]//button[contains(text(),'Procesar')]");
    public LimitesDeControlPage cambiarLimiteControl(String importe, String cantidad, String fechaVencimiento) {
        clickJs(siguienteBtnBy);
        writeTextWithKeys(importeTxtBy, importe);
        writeText(cantidadTxtBy, cantidad);
        fechaVencimiento = sumarDiasAFecha(getToday(),Integer.parseInt(fechaVencimiento));
        writeText(fechaVencimientoTxtBy, fechaVencimiento);
        clickJs(procesarBtnBy);
        return this;
    }
}
