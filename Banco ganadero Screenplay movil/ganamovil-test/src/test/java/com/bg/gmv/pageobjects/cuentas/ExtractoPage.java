package com.bg.gmv.pageobjects.cuentas;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtractoPage extends BasePage {

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.ImageView")
    private WebElement btnPeriodo;

    public void seleccionarCuenta(String nroCuenta){
        String nroCuentaXpath = "//*[@class='android.widget.TextView'][@text='"+nroCuenta+"']";
        WebElement lWebNroCuenta = findElement(nroCuentaXpath);
        waitForElement(lWebNroCuenta,50).click();
    }

    public void seleccionarOpcion(String opcion){
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='"+opcion+"']";
        WebElement lWebOpcion = findElement(opcionXpath);
        waitForElement(lWebOpcion,50).click();
    }
    public void clicBotonPeriodo(){
        waitForElement(btnPeriodo,50).click();
    }
    public void seleccionarPeriodoOtrosMeses(String periodo){
            String periodoXpath = "//*[@class='android.widget.TextView'][@text='" + periodo + "']";
            if (isPresent(periodoXpath)) {
                WebElement lWelOption = findElement(periodoXpath);
                waitForElement(lWelOption, 50).click();
            } else {
                scrollDown();
            }

            waitFor(20).seconds();
    }

    /**
     * Metodo que retorna el importe del extracto en base a la descripcion envidada por parametro
     * */
    public String obtenerImporteExtracto(String descripcion){
        String importe = "";
        String listaExtractosXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView";
        List<WebElement> lWelListaExtractos= findElements(listaExtractosXpath);
        Integer cantidadExtractos = lWelListaExtractos.size();

        for(int posicion =1;posicion<=cantidadExtractos;posicion=posicion+2){
            Boolean encontradoFlag=false;
            String descripcionXpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout["+posicion+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView";
            WebElement lWelDescripcion= findElement(descripcionXpath);
            String descripcionExtracto=lWelDescripcion.getText();
            if(descripcionExtracto.equals(descripcion)){
                encontradoFlag=true;
            }
            if(encontradoFlag==true){
                String importeXpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout["+posicion+"]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView";
                WebElement lWelImporte= findElement(importeXpath);
                importe = waitForElement(lWelImporte,50).getText();
                posicion = cantidadExtractos;
            }
        }
        return importe;
    }
}
