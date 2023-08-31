package com.bg.gmv.pageobjects.puntosAtencion;

import com.bg.gmv.pageobjects.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.webdriver.driverproviders.AppiumDriverCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;

import java.util.List;
import java.util.Set;

public class PuntosAtencionPage extends BasePage {
    private final String autoservicioText = "Autoservicio";
    private final String agenciasText = "Agencias";
    private final String masCercanoText = "Más cercanos";
    private final String ciudadesText = "Ciudades";
    private final String agenciaBlacuttText = "Agencia Blacutt";
    private final String agenciaViedmaText = "Agencia Viedma";
    private final String agenciaElCristoText = "Agencia El Cristo";
    private final String kioskoSmartOficinaCentralText = "Kiosco Smart Oficina Central";
    private final int TIME_SECONDS = 50;

    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Puntos de Atención']")
    private WebElement puntosAtencionButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Autoservicio']")
    private WebElement autoservicioTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Agencias']")
    private WebElement agenciasTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Más cercanos']")
    private WebElement masCercanosTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Ciudades']")
    private WebElement ciudadesTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Agencia Blacutt']")
    private WebElement agenciaBlacuttTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Agencia Viedma']")
    private WebElement agenciaViedmaTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Agencia El Cristo']")
    private WebElement agenciaElCristoTextElement;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Kiosco Smart Oficina Central']")
    private WebElement autoservicioKioscoSmartOficinaCentralTextElement;


    public String getAgenciaText() {
        return agenciasText;
    }

    public String getAutoServicioText() {
        return autoservicioText;
    }

    public String getMasCercanosText() {
        return masCercanoText;
    }

    public String getAutoCiudadesText() {
        return ciudadesText;
    }

    public String getAgenciaBlacuttText() {
        return agenciaBlacuttText;
    }

    public String getAgenciaViedmaText() {
        return agenciaViedmaText;
    }

    public String getAgenciaElCristoText() {
        return agenciaElCristoText;
    }

    public String getAutoservicioKioskoSmartOficinaCentralText() {
        return kioskoSmartOficinaCentralText;
    }

    public String obtenerTextoAgencia() {
        waitFor(2).seconds();
        return agenciasTextElement.getText();
    }


    public String obtenerTextoAutoServicio() {
        return autoservicioTextElement.getText();
    }

    public String obtenerTextoMasCercanos() {
        return masCercanosTextElement.getText();
    }

    public String obtenerTextoCiudades() {
        return ciudadesTextElement.getText();
    }

    public void clickPuntosDeAtencion() {
        waitForElement(puntosAtencionButton,TIME_SECONDS).click();
    }

    public void clickAgencias() {
        waitFor(10).seconds();
        agenciasTextElement.click();
    }

    public void clickAutoservicio() {
        waitFor(10).seconds();
        autoservicioTextElement.click();
    }

    public void clickMasCercanos() {
        waitForElement(masCercanosTextElement, TIME_SECONDS);
        masCercanosTextElement.click();
    }

    public String obtenerTextoAgenciaBlaccut() {
        waitForElement(agenciaBlacuttTextElement, TIME_SECONDS);
        return agenciaBlacuttTextElement.getText();
    }

    public String obtenerTextoAgenciaViedma() {
        waitForElement(agenciaViedmaTextElement, TIME_SECONDS);
        return agenciaViedmaTextElement.getText();
    }

    public String obtenerTextoAgenciaElCristo() {
        waitForElement(agenciaElCristoTextElement, TIME_SECONDS);
        return agenciaElCristoTextElement.getText();
    }

    public String obtenerTextoAutoservicioKioskoSmartOficinaCentral() {
        waitForElement(autoservicioKioscoSmartOficinaCentralTextElement, TIME_SECONDS);
        return autoservicioKioscoSmartOficinaCentralTextElement.getText();
    }
}
