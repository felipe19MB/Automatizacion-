package com.bg.gmv.pageobjects.dashboard;


import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashBoardPage extends BasePage {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement gWelTxtNombre;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.ImageView")
    private WebElement gWelBtnCerrarSesion;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='No']")
    private WebElement gWelBtnNo;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Si']")
    private WebElement gWelBtnSi;

    @FindBy(xpath = "/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement gWelTxtMensaje;

    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Cancelar']")
    private WebElement cancelarButton;


    /**
     * Este metodo permite seleccionar las opciones del menu
     *
     * @List<String> opciones "Se envia la lista de opciones a las cuales se quiere acceder Ejemplo: |Transferencias|A Terceros|"
     */
    public void ingresarOpcion(List<String> pLstOpciones) {


        int cantidadOpciones = pLstOpciones.size();

        for (int posicion = 0; posicion < cantidadOpciones; posicion++) {

            String opcion = pLstOpciones.get(posicion);
            waitFor(10).seconds();
            String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + opcion + "']";

            if (isPresent(opcionXpath)) {
                WebElement lWelOption = findElement(opcionXpath);
                waitForElement(lWelOption, 50).click();
            } else {
                scrollDown();
                posicion--;
            }

            waitFor(10).seconds();
        }


    }

    public String getNombre() {
        waitFor(4).seconds();
        return gWelTxtNombre.getText();
    }

    public String getMensaje() {
        return gWelTxtMensaje.getText();
    }

    public void clicCerrarSesion() {
        waitForElement(gWelBtnCerrarSesion, 20).click();
    }

    public void clicSi() {
        waitForElement(gWelBtnSi, 20).click();
        waitFor(4).seconds();
    }

    public void clicNo() {
        waitForElement(gWelBtnNo, 20).click();
    }

    public void cancelarPromociones(){
        //consultar hasta 10 segundos si aparece otra promocion, verificar por la existencia del boton Cancelar

        boolean promos = true;
        do{
            try{
                waitForElement(cancelarButton, 10).click();
            }catch (Exception ex){
                System.out.println("Exception: " + ex);
                promos = false;
            }
        }
        while(promos);

    }


}
