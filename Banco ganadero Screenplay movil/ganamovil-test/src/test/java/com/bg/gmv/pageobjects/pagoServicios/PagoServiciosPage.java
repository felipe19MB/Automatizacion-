package com.bg.gmv.pageobjects.pagoServicios;

import com.bg.gmv.pageobjects.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PagoServiciosPage extends BasePage {

    public void clicOpcion(String opcion){
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + opcion + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }
    public void seleccionarCuenta(String nroCuenta){
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + nroCuenta + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }
    public void seleccionarCompania(String compania){
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + compania + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }
    public void seleccionarAfiliado(String afiliado){
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + afiliado + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }
    public void seleccionarDeuda(String deuda){
        // Este xpath siempre selecciona la primera deuda.
        String opcionXpath = "//*[@class='ny0k.kq'][1]";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    public void clicButton(String button){
        String opcionXpath = "//*[@class='android.widget.Button'][@text='" + button + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }

    /**
     * Funciones para retornar datos del comprobante
     * */

    public String getImporteComprobante(){
        String xpath = "//*[@class='android.widget.TextView'][@text='']";
        WebElement lWelImporteComprobante = findElement(xpath);
        String importeComprobante = lWelImporteComprobante.getText();

        return importeComprobante;
    }


    public String getValorComprobante(String pNombreCampo){


        String valor = "";
        String listaCamposXpath = "//android.widget.LinearLayout[1]/android.widget.TextView";
        List<WebElement> lWelListaCampos= findElements(listaCamposXpath);
        Integer cantidadCampos = lWelListaCampos.size();

        for(int posicion =1;posicion<=cantidadCampos;posicion++){
            Boolean encontradoFlag=false;
            String campoXpath="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+posicion+"]/android.widget.LinearLayout[1]/android.widget.TextView";
            WebElement lWelCampo= findElement(campoXpath);
            String nombreCampo=lWelCampo.getText();
            if(nombreCampo.equals(pNombreCampo)){
                encontradoFlag=true;
            }
            if(encontradoFlag==true){
                String valorCampoXpath="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+posicion+"]/android.widget.LinearLayout[2]/android.widget.TextView";
                WebElement lWelTextValorCampo= findElement(valorCampoXpath);
                valor = waitForElement(lWelTextValorCampo,50).getText();
                posicion = cantidadCampos;
            }
        }
        return valor;

    }
}
