package bo.com.bga.certificacion.gananet.tasks.chequeras.historico_chequeras;


import bo.com.bga.certificacion.gananet.models.chequeras.HistoricoChequeraModel;
import bo.com.bga.certificacion.gananet.userinterfaces.pago_planillas.HistoricoPagoPlanillas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

import static bo.com.bga.certificacion.gananet.userinterfaces.chequeras.HistoricoChequeraPage.*;

import static net.serenitybdd.core.Serenity.getDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultarHistoricoChequeras implements Task {
    HistoricoChequeraModel historicoChequeraModel;
    String scenario;


    public ConsultarHistoricoChequeras(HistoricoChequeraModel historicoChequeraModel, String scenario) {
        this.historicoChequeraModel = historicoChequeraModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(30).seconds(),
                        Select.option(historicoChequeraModel.getCuentaOrigen()).from(CUENTAS_SELECTOR),
                        Enter.theValue(historicoChequeraModel.getPeriodoInicio()).into(FECHA_INICIO_HISTORICO_CHEQUERAS),
                        Enter.theValue(historicoChequeraModel.getPeriodoFin()).into(FECHA_FIN_HISTORICO_CHEQUERAS),
                        JavaScriptClick.on(BOTON_BUSCAR_HISTORICO_CHEQUERAS),
                        WaitUntil.the(CAMPO_CUENTA_HISTORICO_CHEQUERA, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        Scroll.to(BOTON_DETALLE_HISTORICO_CHEQUERA)
                );
                WebDriver driver = getDriver();
                String xpath = "/html/body/app-root/app-paginas/div/div/app-historico-solicitud/control-contenedor-paginas/section/div/div/div/control-box/div/div/div/table/tbody/tr[2]/td[6]/div/a";
                WebElement button = driver.findElement(By.xpath(xpath));
                // Crea una instancia del JavascriptExecutor
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

                // Ejecuta el script de JavaScript para hacer clic en el elemento utilizando el xpath
                String script = "var element = document.evaluate('" + xpath + "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; if(element) element.click();";
                jsExecutor.executeScript(script);

                System.out.println("----------------------------------------------");

                // Desplázate hasta el elemento para asegurarte de que esté visible en la ventana actual
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

// Espera un breve período de tiempo para asegurarte de que el elemento esté completamente cargado y sea interactuable
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

// Ejecuta el script de JavaScript para hacer clic en el botón
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

                System.out.println("----------------------------------------------");
                // Deshabilita el atributo 'disabled' del botón utilizando JavaScript
                jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", button);

// Haz clic en el botón utilizando JavaScript
                jsExecutor.executeScript("arguments[0].click()", button);

                System.out.println("----------------------------------------------");
// Desplázate hasta el elemento
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", button);

// Espera un breve momento para asegurarte de que el elemento esté completamente cargado y sea interactuable
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

// Realiza una acción específica en el elemento utilizando JavaScript
                jsExecutor.executeScript("arguments[0].click();", button);
                System.out.println("----------------------------------------------");

                jsExecutor.executeScript("var event = new MouseEvent('click', {bubbles: true, cancelable: true}); arguments[0].dispatchEvent(event);", button);
                System.out.println("----------------------------------------------");
                // Ejecuta el script de JavaScript para obtener las coordenadas del elemento
                String script2 = "var rect = arguments[0].getBoundingClientRect();"
                        + "return {"
                        + "  x: rect.left + window.pageXOffset,"
                        + "  y: rect.top + window.pageYOffset"
                        + "};";
                Map<String, Long> coordinates = (Map<String, Long>) jsExecutor.executeScript(script2, button);

// Extrae las coordenadas X e Y
                long xCoord = coordinates.get("x");
                long yCoord = coordinates.get("y");

// Imprime las coordenadas
                System.out.println("Coordenada X: " + xCoord);
                System.out.println("Coordenada Y: " + yCoord);

// Haz clic en el elemento utilizando las coordenadas
                String clickScript = "window.scrollTo(" + xCoord + ", " + yCoord + ");"
                        + "arguments[0].click();";
                jsExecutor.executeScript(clickScript, button);
                System.out.println("----------------------------------------------");








                JavaScriptClick.on(BOTON_DETALLE_HISTORICO_CHEQUERA);
                BrowseTheWeb.as(actor).findFirst(BOTON_DETALLE_HISTORICO_CHEQUERA.getCssOrXPathSelector()).get().click();
                actor.remember("CuentaHistoricoChequeras", actor.asksFor(Text.of(CAMPO_CUENTA_HISTORICO_CHEQUERA)));
                actor.remember("MontoHistoricoChequeras", actor.asksFor(Text.of(CAMPO_MONTO_HISTORICO_CHEQUERA)));
                actor.remember("CantidadChequesHistorico", actor.asksFor(Text.of(CAMPO_CHEQUES_HISTORICO_CHEQUERA)));
                actor.attemptsTo(
                        JavaScriptClick.on(BOTON_DETALLE_HISTORICO_CHEQUERA),
                        WaitUntil.the(HistoricoPagoPlanillas.CIRCULO_CARGA, isNotVisible()).forNoMoreThan(60).seconds()
                        );
                actor.remember("NotaHistoricoChequeras" ,actor.asksFor(Text.of(NOTA_HISTORICO_SOLICITUD_CHEQUERA)));
                break;
        }


    }
    public static ConsultarHistoricoChequeras go(HistoricoChequeraModel historicoChequeraModel, String scenario){
        return Tasks.instrumented(ConsultarHistoricoChequeras.class,historicoChequeraModel,scenario);
    }

}
