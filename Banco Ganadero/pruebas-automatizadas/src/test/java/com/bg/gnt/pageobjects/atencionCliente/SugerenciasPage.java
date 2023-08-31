package com.bg.gnt.pageobjects.atencionCliente;

import com.bg.gnt.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class SugerenciasPage extends BasePage {


    @FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-sugerencias/control-contenedor-paginas/section/div/div/div/control-box/div/div[2]/form/div[1]/div/control-input-text/div/input")
    private WebElementFacade txtCorreo;

    @FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-sugerencias/control-contenedor-paginas/section/div/div/div/control-box/div/div[2]/form/div[2]/div/control-input-textarea/div/textarea")
    private WebElementFacade txtDescripcion;

    @FindBy(xpath="/html/body/app-root/app-paginas/div/div/app-sugerencias/control-contenedor-paginas/section/div/div/div/control-box/div/div[2]/form/div[3]/div/button")
    private WebElementFacade btnAceptar;

    @FindBy(xpath="//*[@id=\"swal2-content\"]")
    private WebElementFacade lblMensaje;

    public void clicAceptar(){
        //waitFor(2).seconds();
        String click = "document.querySelector(\"body > app-root > app-paginas > div > div > app-sugerencias > control-contenedor-paginas > section > div > div > div > control-box > div > div.box-body.bg-box-body > form > div:nth-child(3) > div > button\")" +".click()";
        JavascriptExecutor js =(JavascriptExecutor)getDriver();
        js.executeScript(click);
    }

    public void registrarCorreo(String correo){
        txtCorreo.clear();
        txtCorreo.sendKeys(correo);
        //waitFor(2).seconds();
    }
    public void registrarDescripcion(String descripcion){
        txtDescripcion.sendKeys(descripcion);
        //waitFor(2).seconds();
    }

    public String obtenerMensaje(){
        return lblMensaje.getText();
    }
}
