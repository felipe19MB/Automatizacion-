package com.bg.gmv.pageobjects.acceso;


import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;


public class AccesoPage extends BasePage {

    private final int TIME_SECONDS = 50;

    @FindBy(xpath = "//*[@class='android.widget.EditText'][@text='Ingresa tu código de persona']")
    private WebElement welTxtCodigo;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView[@class='android.widget.ImageView'][@index='0']")
    private WebElement welBtnVerificar;

    @FindBy(xpath = "//*[@class='android.widget.EditText'][@text='Ingresa tu clave de acceso']")
    private WebElement welTxtClave;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
    private WebElement welBtnIngresar;

    @FindBy(xpath = "/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.Button")
    private WebElement welBtnNo;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement welTxtNombre;


    @FindBy(xpath = "/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button")
    private WebElement welBtnAceptar;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='CANCEL']")
    private WebElement cancelDebuggerKonyButton;

    public void ingresarCodigo(String pStrUsuario) {

        waitFor(20).seconds();
        waitForElement(welTxtCodigo, TIME_SECONDS).sendKeys(pStrUsuario);

    }

    public void clicVerificar() {
        waitForElement(welBtnVerificar, TIME_SECONDS).click();

    }

    public void ingresarClave(String pStrClave) {
        waitForElement(welTxtClave, 500);
        if(welTxtClave.isDisplayed()){
            welTxtClave.sendKeys(pStrClave);
        }






    }

    public void clicIngresar() {
        waitForElement(welBtnIngresar, TIME_SECONDS).click();

    }

    public void clicNo() {
        waitForElement(welBtnNo, TIME_SECONDS).click();
        waitFor(4).seconds();
    }


    public void clicAceptar() {
        waitForElement(welBtnAceptar, TIME_SECONDS).click();

    }

    public void clickCancelDebugMode() {
        try {
            waitForElement(cancelDebuggerKonyButton, TIME_SECONDS).click();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

}


