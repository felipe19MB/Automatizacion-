package com.bg.gmv.pageobjects.cuentas;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class ConsultasPage extends BasePage {
// Elementos para Comrpobante

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement txtNroCuenta;

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement txtEstado;

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement txtSaldo;

    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtTipoCuenta;




    public void seleccionarCuenta(String nroCuenta){
        String nroCuentaXpath = "//*[@class='android.widget.TextView'][@text='"+nroCuenta+"']";
        WebElement lWebNroCuenta = findElement(nroCuentaXpath);
        waitForElement(lWebNroCuenta,50).click();
        waitFor(20).seconds();
    }
    public String getCuentaConsulta (){
        String nroCuenta = txtNroCuenta.getText();
        return nroCuenta;
    }
    public String getEstado(){
        String estado = txtEstado.getText();
        return estado;
    }
    public String getSaldo(){
        String saldo = txtSaldo.getText();
        return saldo;
    }
    public String getTipoCuenta(){
        String tipoCuenta = txtTipoCuenta.getText();
        return tipoCuenta;
    }

}
