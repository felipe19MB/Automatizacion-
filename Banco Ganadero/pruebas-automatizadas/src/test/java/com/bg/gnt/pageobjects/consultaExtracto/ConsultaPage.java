package com.bg.gnt.pageobjects.consultaExtracto;

import com.bg.gnt.pageobjects.NewBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ConsultaPage extends NewBasePage {
    public ConsultaPage(WebDriver driver){
        super(driver);
    }
    By numeroCuentaTxt=By.xpath("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-saldo[1]/app-consulta-detalle-saldo[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[1]");
    By tipoCuentaTxt=By.xpath("/html[1]/body[1]/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-saldo[1]/app-consulta-detalle-saldo[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[2]");
    By productoTxt=By.xpath("/html[1]/body[1]/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-saldo[1]/app-consulta-detalle-saldo[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[3]");
    By monedaTxt=By.xpath("/html[1]/body[1]/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-saldo[1]/app-consulta-detalle-saldo[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/p[4]");
    By cerrarBtnBy=By.xpath("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-saldo[1]/app-consulta-detalle-saldo[1]/div[1]/div[1]/div[1]/div[3]/button[1]");
    public ConsultaPage seleccionarDetalleCuenta (String numeroCuenta){
        String xBtnDetalle= "//h3[contains(text(),'"+numeroCuenta+"')]//parent::td/following-sibling::td/a[@title='Detalle de cuenta']/i";
        By detalleConsultaBY=By.xpath(xBtnDetalle);
        clickJs(detalleConsultaBY);
        return this;
    }
    public ConsultaPage verificaDetalleCuentaPage (String numeroCuenta,String tipoCuenta, String producto, String moneda){

        assertThat(readText(numeroCuentaTxt),containsString(numeroCuenta));
        assertThat(readText(tipoCuentaTxt),containsString(tipoCuenta));
        assertThat(readText(productoTxt),containsString(producto));
        assertThat(readText(monedaTxt),containsString(moneda));

        clickJs(cerrarBtnBy);
        return this;
    }


}
