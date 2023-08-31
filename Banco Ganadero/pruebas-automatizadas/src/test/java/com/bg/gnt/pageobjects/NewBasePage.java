package com.bg.gnt.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class NewBasePage extends PageObject {
    public WebDriver driver;
    public WebDriverWait wait;

    public NewBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitForElementToBeClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    public void waitForElementEnabled(By elementBy) {
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(elementBy).isEnabled());
        } catch (Exception e) {
            System.out.println("Elemento Desabilitado: " + elementBy);
        }
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        waitForElementToBeClickable(elementBy);
        driver.findElement(elementBy).click();
    }
    public void clickJs(By elementBy) {
        WebElement lWelBtn = getDriver().findElement(elementBy);
        JavascriptExecutor js =(JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", lWelBtn);
    }

    public void clear(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
    }

    public boolean isDisplayed(By elementBy) {
        return driver.findElement(elementBy).isDisplayed();
    }

    public boolean isEnabled(By elementBy) {
        return driver.findElement(elementBy).isEnabled();
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    public void writeTextWithKeys(By elementBy, String text) {
        String b = Keys.BACK_SPACE.toString();
        driver.findElement(elementBy).sendKeys(Keys.BACK_SPACE);
        writeText(elementBy, b+b+b+b+b+b+b+b+b+b);
        writeText(elementBy,text);
    }
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void selectOption(By elementBy, String selectOption) {
        waitVisibility(elementBy);
        new Select(driver.findElement(elementBy)).selectByVisibleText(selectOption);
    }

    public void switchTabs() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void waitForElementToFadeIn(final By elementBy, final String cssValue, final String equals) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(elementBy).getCssValue(cssValue).equals(equals);
            }
        });
    }

    public String getElementColor(By elementBy, String cssValue) {
        return Color.fromString(driver.findElement(elementBy).getCssValue(cssValue)).asHex();
    }

    protected static String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    public String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //get current date time with Date()
        Date date = new Date();
        String date1= dateFormat.format(date);
        return date1;
        }
    public String sumarDiasAFecha(String fecha, int dias) {
        if(dias == 0){
            return fecha;
        }

        String[] f = fecha.split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(f[2]), Integer.parseInt(f[1])-1, Integer.parseInt(f[0]));

        calendar.add(Calendar.DAY_OF_MONTH, dias);
        SimpleDateFormat fe = new SimpleDateFormat("dd/MM/YYYY");
        return fe.format(calendar.getTime());

    }

    public void refreshPage() {
        driver.navigate().refresh();

    }

    public void quitTestCase(String message){
        System.out.println(message);
        driver.quit();
    }
}
