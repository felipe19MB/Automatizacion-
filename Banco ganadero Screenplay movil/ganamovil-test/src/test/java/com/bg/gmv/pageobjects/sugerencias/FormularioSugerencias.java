package com.bg.gmv.pageobjects.sugerencias;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class FormularioSugerencias extends BasePage {

    private String tipoSugerenciaLocator = "//*[@class='android.widget.CheckedTextView'][@text='%s']";

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/" +
            "android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView")
    private WebElement sugerenciasDropdownList;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/" +
            "android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/" +
            "android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    private WebElement comentarioSugerenciaTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/" +
            "android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/" +
            "android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[2]")
    private WebElement enviarButton;

    @FindBy(xpath = "/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/" +
            "android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement sugerenciaComentarioTexto;

    @FindBy(xpath = "/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/" +
            "android.widget.LinearLayout[3]/android.widget.Button")
    private WebElement sugerenciaComentarioAceptarbutton;

    public void llenarFormularioSugerencia(String nombreSugerencia) {
        comentarioSugerenciaTextBox.sendKeys(nombreSugerencia);

    }

    public String obtenerTextoSugerenciasComentarios(){
        return sugerenciaComentarioTexto.getText();
    }

    public void seleccionaTipoSugerencia(String nombreSugerencia) {
        sugerenciasDropdownList.click();
        WebElement sugerenciaWebElement =  findElement(String.format(tipoSugerenciaLocator, nombreSugerencia));
        waitForElement(sugerenciaWebElement, 2).click();
    }

    public void enviarSugerencia() {
        enviarButton.click();
    }

    public void aceptarSugerencia(){
        sugerenciaComentarioAceptarbutton.click();
    }
}
