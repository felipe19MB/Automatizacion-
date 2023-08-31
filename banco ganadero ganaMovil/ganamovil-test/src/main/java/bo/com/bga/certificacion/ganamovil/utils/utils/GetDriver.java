package bo.com.bga.certificacion.ganamovil.utils.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.util.logging.Logger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class GetDriver {
    private final Actor actor;
    private final Logger logger = Logger.getLogger(GetDriver.class.getName());

    public Logger getLogger() {
        return this.logger;
    }

    public GetDriver(Actor actor) {
        this.actor = actor;
    }

    public static GetDriver as(Actor actor) {
        return new GetDriver(actor);
    }

    public AppiumDriver appiumDriver() {
        return (AppiumDriver)this.webDriver();
    }

    public AndroidDriver androidDriver() {
        return (AndroidDriver)this.webDriver();
    }

    public IOSDriver iosDriver() {
        return (IOSDriver)this.webDriver();
    }

    public WebDriver webDriver() {
        return ((WebDriverFacade)BrowseTheWeb.as(this.actor).getDriver()).getProxiedDriver();
    }
}