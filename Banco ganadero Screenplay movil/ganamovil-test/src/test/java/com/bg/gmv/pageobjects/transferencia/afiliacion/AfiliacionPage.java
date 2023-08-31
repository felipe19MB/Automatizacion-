package com.bg.gmv.pageobjects.transferencia.afiliacion;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AfiliacionPage extends BasePage {

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
    private WebElement btnAdicionoCuenta;

    @FindBy(xpath ="//*[@class='android.widget.EditText'][@text='Ingresar el número de cuenta']")
    private WebElement txtNroCuenta;

    @FindBy(xpath ="//*[@class='android.widget.EditText'][@text='Ingresar el nombre y apellido']")
    private WebElement txtNombre;

    @FindBy(xpath ="//*[@class='android.widget.EditText'][@text='Ingresar la referencia']")
    private WebElement txtReferencia;

    @FindBy(xpath ="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement lblMensaje;



    public void ingresarNroCuenta(String nroCuenta) {
        waitForElement(txtNroCuenta, 50).sendKeys(nroCuenta);
    }

    public void ingresarNombre(String nombre) {
        waitForElement(txtNombre, 50).sendKeys(nombre);
    }

    public void ingresarReferencia(String referencia) {
        waitForElement(txtReferencia, 50).sendKeys(referencia);
    }

    public String getMensaje(){
        String mensaje= waitForElement(lblMensaje, 60).getText();
        return mensaje;
    }

    public void clicButton(String nombreBoton) {
        String opcionXpath = "//*[@class='android.widget.Button'][@text='" + nombreBoton + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();

    }
    public void clicAdicionaCuentas() {
        clicOpcion("Cuenta Destino");
        waitForElement(btnAdicionoCuenta, 50).click();
    }

    public void clicOpcion(String opcion) {
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + opcion + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption, 50).click();
    }
    /**
     * Este metodo permite seleccionar un boton que no tiene un texto o alguna forma de localizarlo
     *
     * @String cuenta "Se envia el numero de cuenta del afiliado que usamos para poder localizar el boton de eliminar"
     */
    public void eliminarAfiliado(String cuenta){

        String listaAfiliadosXpath = "//*[@class='ny0k.kq']";
        List<WebElement> lWelListaAfiliados= findElements(listaAfiliadosXpath);
        Integer cantidadAfiliados = lWelListaAfiliados.size();

        for(int posicion =1;posicion<=cantidadAfiliados;posicion++){
            Boolean encontradoFlag=false;
            String afiliadoXpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/ny0k.kq["+posicion+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView";
            WebElement lWelAfiliado= findElement(afiliadoXpath);
            String cuenta2=lWelAfiliado.getText();
            if(cuenta2.equals(cuenta)){
                encontradoFlag=true;
            }
            if(encontradoFlag==true){
                String btnEliminarXpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/ny0k.kq["+posicion+"]/android.widget.LinearLayout[2]";
                WebElement lWelBtnEliminar= findElement(btnEliminarXpath);
                waitForElement(lWelBtnEliminar,50).click();
                posicion = cantidadAfiliados;
            }

        }

    }
}
