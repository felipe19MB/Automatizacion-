package bo.com.bga.certificacion.gananet.interactions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;

public class ArrastrarYSoltar implements Interaction {

    private Target fromTarget;
    private Target toTarget;

    public ArrastrarYSoltar(Target fromTarget, Target toTarget) {
        this.fromTarget = fromTarget;
        this.toTarget = toTarget;
    }


    public static ArrastrarYSoltar conLosElemntos(Target fromTarget, Target toTarget) {
        return Tasks.instrumented(ArrastrarYSoltar.class, fromTarget, toTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Esperar hasta 10 segundos
        WebElement from = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fromTarget.getCssOrXPathSelector())));
        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(toTarget.getCssOrXPathSelector())));

        // Obtener las coordenadas del elemento fuente
        int sourceX = from.getLocation().getX() + (from.getSize().getWidth() / 2);
        int sourceY = from.getLocation().getY() + (from.getSize().getHeight() / 2);
        sourceY += 80;
        // Obtener las coordenadas del elemento objetivo
        double targetX = to.getLocation().getX() + (to.getSize().getWidth() / 2);
        double targetY = to.getLocation().getY() + (to.getSize().getHeight() / 2);
        targetY += 40;
        // Crear una instancia de Robot
        Robot robot;

        try {
            robot = new Robot();
            // Mover el cursor del mouse al elemento fuente y presionar el botón izquierdo del mouse
            robot.mouseMove(sourceX, sourceY);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

            // Esperar un corto tiempo antes de soltar el botón del mouse
            Thread.sleep(500);

            int currentX = sourceX;
            int currentY = sourceY;

            // Define el tamaño del paso (puede ser ajustado según las necesidades)
            double stepX = (targetX - sourceX) / 30;
            double stepY = (targetY - sourceY) / 30;
            if (stepY == 0) {
                stepY = 4;
            }
            for (int i = 0; i < 10; i++) {
                currentX += stepX;
                currentY += stepY;
                robot.mouseMove(currentX, currentY);
                // Esperar un breve período antes interactuar con la página
                Thread.sleep(100);
            }
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
