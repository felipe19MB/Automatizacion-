package com.bg.gnt.pageobjects.pago_servicios;

import com.bg.gnt.pageobjects.NewBasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AfiliacionPage extends NewBasePage {
    public AfiliacionPage(WebDriver driver) {
        super(driver);
    }
    By afiliarBtnBy = By.xpath("//app-listado-afiliacion[1]/control-contenedor-paginas[1]//control-box[1]//button[1]");
    By tipoSelectBy = By.xpath("//label[contains(text(),'Tipo')]/following-sibling::select");
    By subTipoSelectBy = By.xpath("//label[contains(text(),'Sub tipo')]/following-sibling::select");
    By ciudadSelectBy = By.xpath("//label[contains(text(),'Ciudad')]/following-sibling::select");
    By servicioSelectBy = By.xpath("//label[contains(text(),'Servicio')]/following-sibling::select");
    By criterioBusquedaSelectBy = By.xpath("//label[contains(text(),'Criterio de busqueda')]/following-sibling::select");
    By referenciaTextBy = By.xpath("//label[contains(text(),'Referencia')]/following-sibling::div[@class='input-group']/input");
    By verificarBtnBy = By.xpath("//button[contains(text(),'Verificar')]");
    //DELAPAZ
    By nroConsumidorTxtBy = By.xpath("//label[contains(text(),'Nro. Consumidor')]/following-sibling::div[@class='input-group']/input");
    By digitoAutoverificadorTxtBy = By.xpath("//label[contains(text(),'Dígito Autoverificador')]/following-sibling::div[@class='input-group']/input");
    By guardarBtnBy = By.xpath("//button[contains(text(),'Guardar')]");
    By cerrarBtnBy = By.xpath("//app-listado-afiliacion[1]/dialog-afiliar[1]/control-modal-right[1]//button[3]");
    By subMenuAfiliacionBtn = By.xpath("//a[contains(@href,'pago-servicios/afiliaciones')and @class='nav-link']");
    By ganaPintxt = By.xpath("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-listado-afiliacion[1]/dialog-afiliar[1]/control-modal-segundo-factor[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/input[1]");
    By procesarBtnBy = By.xpath("//body[1]/app-root[1]/app-paginas[1]/div[1]/div[1]/app-listado-afiliacion[1]/dialog-afiliar[1]/control-modal-segundo-factor[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/button[1]");
    public AfiliacionPage afiliarServicio(String opcionTipo, String opcionSubTipo, String opcionCiudad, String opcionServicio) {
        clickJs(subMenuAfiliacionBtn);
        clickJs(afiliarBtnBy);
        selectOption(tipoSelectBy, opcionTipo);
        selectOption(subTipoSelectBy, opcionSubTipo);
        selectOption(ciudadSelectBy, opcionCiudad);
        selectOption(servicioSelectBy, opcionServicio);
        return this;
    }
    public AfiliacionPage llenarDatosCriterioBusqueda(String servicio, String criterioBusqueda, String criterioBusqueda1, String criterioBusqueda2, String referencia) {
        switch (servicio) {
            case "DELAPAZ":
                waitFor(2).seconds();
                writeText(nroConsumidorTxtBy,criterioBusqueda1);
                writeText(digitoAutoverificadorTxtBy, criterioBusqueda2);
                break;
            case "EPSAS":

                break;
            default:

                break;
        }
        writeText(referenciaTextBy, referencia);
        clickJs(verificarBtnBy);
        waitForElementEnabled(guardarBtnBy);
        clickJs(guardarBtnBy);
        return this;
    }

    public AfiliacionPage ingresarGanaPin(String ganapin) {
        writeText(ganaPintxt,ganapin);
        clickJs(procesarBtnBy);
        return this;
    }
}
