package com.bg.gnt.pageobjects.tarjetas_debito;

import com.bg.gnt.pageobjects.NewBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CuentasRelacionadas extends NewBasePage {
    public CuentasRelacionadas(WebDriver driver) {
        super(driver);
    }

    By siguienteBtnBy = By.xpath("//button[contains(text(),'Siguiente')]");
    By cuenta1OpcionSelector = By.xpath("//tbody/tr[2]/td[2]/p[1]/select[1]");
    By procesarBtnBy = By.xpath("//app-cuentas-relacionadas[1]/control-contenedor-paginas[1]//control-wizard-container[2]/tarjeta-debito-cuentas-relacionadas[1]//control-box[1]/div[1]/div[1]/div[2]/div[1]/button[1]");
    By eliminarCuentaBy = By.xpath("//tbody/tr[2]/td[3]/a[1]/i[1]");
    public CuentasRelacionadas relacionarCuenta(String cuenta) {
        clickJs(siguienteBtnBy);
        clickJs(eliminarCuentaBy);
        selectOption(cuenta1OpcionSelector,cuenta);
        clickJs(procesarBtnBy);

        return this;
    }
}
