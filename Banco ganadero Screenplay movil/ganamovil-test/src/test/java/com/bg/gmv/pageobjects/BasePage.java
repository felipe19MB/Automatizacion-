package com.bg.gmv.pageobjects;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage extends PageObject {


    //general
    public WebElement waitForElement(WebElement element) {
        return waitForElement(element, 5);
    }

    public WebElement waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement findElement(String xpath) {
        if (isPresent(xpath) != true) {
            waitFor(5).seconds();
        }
        WebElement element = getDriver().findElement(By.xpath(xpath));
        return element;
    }

    public List<WebElement> findElements(String xpath) {
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        return elements;
    }

    /**
     * Este metodo permite saber si un elemento esta presente
     *
     * @return Retorna true si un elemento esta presente y false si no esta presente
     * @String xpath
     */
    public Boolean isPresent(String xpath) {
        Boolean isPresent = findElements(xpath).size() > 0;
        return isPresent;
    }

    /**
     * Este metodo permite simular la accion de presionar un punto inicial y deslizarse hacia otro punto final en la pantalla
     *
     * @param int startX
     * @param int startY
     * @param int endX
     * @param int endX
     */
    public void moveTo(int startX, int startY, int endX, int endY) {
        TouchAction tapCoordinates = new TouchAction(((AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()));

        tapCoordinates.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY)).release().perform();
    }

    /**
     * Este metodo permite hacer scroll hacia arriba simulando que se presiona la pantalla y se desliza el dedo hacia abajo
     */
    public void scrollUp() {
        Dimension dimension = getDriver().manage().window().getSize();
        // We cast the result
        int startX = (int) (dimension.width * 0.5);
        int startY = (int) (dimension.height * 0.1);
        int endX = (int) (dimension.width * 0.5);
        int endY = (int) (dimension.height * 0.6);

        moveTo(startX, startY, endX, endY);
    }

    /**
     * Este metodo permite hacer scroll hacia abajo simulando que se presiona la pantalla y se desliza el dedo hacia arriba
     */
    public void scrollDown() {
        Dimension dimension = getDriver().manage().window().getSize();
        // We cast the result
        int startX = (int) (dimension.width * 0.5);
        int startY = (int) (dimension.height * 0.9);
        int endX = (int) (dimension.width * 0.5);
        int endY = (int) (dimension.height * 0.6);

        moveTo(startX, startY, endX, endY);
    }

    public void selectOptionFromDropDownByText(WebElement dropDown, String option, int waitTime){
        waitForElement(dropDown, waitTime).click();
        WebElement optionWebElement = getDriver().findElement(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='"+option+"']"));
        waitForElement(optionWebElement, waitTime).click();
    }

    public boolean findByTextScrollingDown(List<String> textToTap){
        int cantidadOpciones = textToTap.size();

        for (int posicion = 0; posicion < cantidadOpciones; posicion++) {
            String text = textToTap.get(posicion);
            waitFor(3).seconds();
            String opcionXpath = "//*[@class='android.widget.TextView'][@text='" + text + "']";

            if (isPresent(opcionXpath)) {
                return true;
            } else {
                scrollDown();
                posicion--;
            }
            waitFor(3).seconds();
        }
        return false;
    }

    public void clickCheckedTextViewElementByText(String option, int waitTime){
        WebElement optionWebElement = getDriver().findElement(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='"+option+"']"));
        waitForElement(optionWebElement, waitTime).click();
    }
}
