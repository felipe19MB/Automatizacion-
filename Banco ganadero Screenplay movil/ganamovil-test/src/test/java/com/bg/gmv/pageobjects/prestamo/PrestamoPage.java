package com.bg.gmv.pageobjects.prestamo;

import com.bg.gmv.pageobjects.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.synth.Region;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.aspectj.bridge.Version.getText;

public class PrestamoPage extends BasePage  {
    private final int waitTime=20;
    @FindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.LinearLayout[6]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement txtDescripcionResumen;


    public void  seleccionarCuenta(String nroCuenta){
        clickOption(nroCuenta,waitTime);
    }
    public void  seleccionarAccion(String Option){
        clickOption(Option,waitTime);
    }

    public Boolean ExistePrestamo(String xpath) {
         return isPresent(xpath);
    }

    public void clickOption(String opcion,int waitTime) {
        String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + opcion + "']";
        WebElement lWelOption = findElement(opcionXpath);
        waitForElement(lWelOption,waitTime).click();
    }




    public WebElement GetRow(int Rowposition)
    {
        String RowXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout["+Rowposition+"]";
        WebElement WebRow = findElement(RowXpath);
        return WebRow;

    }

    public WebElement GetColumn (WebElement PagoRow, int ColumnPosition)
    {
        String ColumnXpath= PagoRow.getText() + "/android.widget.LinearLayout["+ColumnPosition+"]";
        WebElement WebColumn = findElement(ColumnXpath);
        return WebColumn;

    }

    /*----- COLUMNA NRO1: FECHA/MES/AÑO ----
    * @author: Vivian Ferrufino
    * @fecha: 30/03/2022                  */

    //Obtiene la fecha de la columna 1
    public String getDate(int PagoRow){
        WebElement WebRow = GetRow(PagoRow);
        WebElement WebColumn= GetColumn(WebRow,1);
        String DateXpath= WebColumn.getText()+"/android.widget.LinearLayout[1]/android.widget.TextView";
        return DateXpath;

    }
    //Obtiene el mes de la columna 1
    public String getMonth(int PagoRow){
            WebElement WebRow = GetRow(PagoRow);
            WebElement WebColumn= GetColumn(WebRow,1);
            String MonthXpath= WebColumn.getText()+"/android.widget.LinearLayout[2]/android.widget.TextView";
            return MonthXpath;

    }
    //Obtiene el año de la columna 1
    public String getYear(int PagoRow){
        WebElement WebRow = GetRow(PagoRow);
        WebElement WebColumn= GetColumn(WebRow,1);
        String YearXpath= WebColumn.getText()+"/android.widget.LinearLayout[3]/android.widget.TextView";
        return YearXpath;

    }


    /*----- COLUMNA NRO3: MONTO PAGADO/TEXT SALDO CAPITAL/ VALOR SALDO CAPITAL ----
     * @author: Vivian Ferrufino
     * @fecha: 30/03/2022                  */

    //Obtiene la cuota pagada  de la columna 3
    public String getMontoPagado(int PagoRow){
        WebElement WebRow = GetRow(PagoRow);
        WebElement WebColumn= GetColumn(WebRow,3);
        String MontoPagadoXpath= WebColumn.getText()+"/android.widget.LinearLayout[1]/android.widget.TextView";
        return MontoPagadoXpath;

    }




    // Verifica Mes, Año y monto pagado de la cuota si existe en la lista
    public String getMontoDelPago(String mesDelPago){

        String montoDelPagoLista = "";
        Boolean bandera= true;
        Integer cantidaScrolls=1;
        Integer divisor=2;





        for(int i=1; i<=2;i++){
            String listaCamposXpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout";

            List<WebElement> lWelListaCampos= findElements(listaCamposXpath);
            Integer cantidadCampos = lWelListaCampos.size();

            for (int posicion = 1; posicion <= cantidadCampos/divisor; posicion ++) {


                String mesDelPagoXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[" + posicion + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView";
                List<WebElement> lWelMesDelPagoLista = findElements(mesDelPagoXpath);
                Integer elementos=lWelMesDelPagoLista.size();
                if(elementos!=0){
                    WebElement lWelMesDelPago = findElement(mesDelPagoXpath);
                    String mesDelPagoLista = lWelMesDelPago.getText();


                    if (mesDelPagoLista.equals(mesDelPago)) {

                        String montoDelPagoXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[" + posicion + "]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView";
                        WebElement lWelMontoDelPago = findElement(montoDelPagoXpath);
                        montoDelPagoLista = lWelMontoDelPago.getText();
                        posicion = cantidadCampos + 1;
                    }
                }



            }

                scrollDown();
                scrollDown();
                divisor=1;
        }
        return montoDelPagoLista;
    }

}
