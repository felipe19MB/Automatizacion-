package com.bg.gmv.pageobjects.solicitudTC;

import com.bg.gmv.pageobjects.BasePage;
import com.bg.gmv.pageobjects.solicitudCreditos.SolicitudConsumaxPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SolicitudTCPage extends BasePage {
    private final int waitTime = 15;
    private final String especificacionesRequisitosTextToAssert = "Especificaciones y Requisitos";

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement ganaSueldoOption;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.EditText")
    private WebElement ingresosTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.EditText")
    private WebElement gastosFamiliaresTextBox;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Calcular']")
    private WebElement calcularButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Aceptar']")
    private WebElement aceptarButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement estadoCivilSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement residenciaSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement agenciaSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement sueldoLiquidoTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText")
    private WebElement telefonoTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.EditText")
    private WebElement correoElectronicoTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.EditText")
    private WebElement montoASolicitarTexBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[8]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement direccionCorrespondenciaSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout")
    private WebElement nivelEducacionSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")
    private WebElement profesionTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement cargoSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement nivelIngresoSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement tipoViviendaSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement cantidadHijosSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.EditText")
    private WebElement nombreEmpresaTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")
    private WebElement barrioTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")
    private WebElement calleTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement zonaSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")
    private WebElement numeroTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement manzanaTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText")
    private WebElement referenciaTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement departamentoLaboralSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[1]")
    private WebElement barrioLaboralTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[2]")
    private WebElement calleLaboralTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement zonaLaboralSelect;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement numeroLaboralTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText")
    private WebElement manzanaLaboralTextBox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button[2]")
    private WebElement incrementoInmuebleButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText")
    private WebElement valorInmueblesTextBox;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Cancelar']")
    private WebElement cancelarButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Si']")
    private WebElement siButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Cancelar Solicitud']")
    private WebElement cancelarSolicitudButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Iniciar una Solicitud']")
    private WebElement iniciarSolicitudButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Especificaciones y Requisitos']")
    private WebElement especificacionesRequisitosText;

    public String getEspecificacionesRequisitosToAssert(){
        return especificacionesRequisitosTextToAssert;
    }

    public void seleccionarSituacionLaboral() {
        waitForElement(ganaSueldoOption, waitTime).click();
    }
    public void confirmarDatos() {
        waitForElement(confirmarButton, waitTime).click();
    }
    public void ingresarIngresos(String ingresos) {
        waitForElement(ingresosTextBox, waitTime).sendKeys(ingresos);
    }
    public void ingresarGastosFamiliares(String gastosFamiliares) {
        waitForElement(gastosFamiliaresTextBox, waitTime).sendKeys(gastosFamiliares);
    }
    public void calcular() {
        waitForElement(calcularButton, waitTime).click();
    }
    public void aceptar() {
        waitForElement(aceptarButton, waitTime).click();
    }
    public void seleccionarEstadoCivil(String estadoCivil){
        selectOptionFromDropDownByText(estadoCivilSelect, estadoCivil, waitTime);
    }
    public void seleccionarResidencia(String localidadResidencia){
        selectOptionFromDropDownByText(residenciaSelect, localidadResidencia, waitTime);
    }
    public boolean textExists(List<String> texts){
        return findByTextScrollingDown(texts);
    }
    public void seleccionarAgencia(String agencia){
        selectOptionFromDropDownByText(agenciaSelect, agencia, waitTime);
    }
    public void ingresarSueldoLiquido(String sueldoLiquido){
        waitForElement(sueldoLiquidoTextBox, waitTime).sendKeys(sueldoLiquido);
    }
    public void ingresarTelefono(String telefono){
        waitForElement(telefonoTextBox, waitTime).sendKeys(telefono);
    }
    public void ingresarCorreoElectronico(String correoElectronico){
        waitForElement(correoElectronicoTextBox, waitTime).sendKeys(correoElectronico);
    }
    public void ingresarMontoASolicitar(String montoSolicitar){
        waitForElement(montoASolicitarTexBox, waitTime).sendKeys(montoSolicitar);
    }
    public void seleccionarDireccionCorrespondencia(String direccionCorrespondencia){
        selectOptionFromDropDownByText(direccionCorrespondenciaSelect, direccionCorrespondencia, waitTime);
    }
    public void seleccionarNivelEducacion(String nivelEducacion){
        selectOptionFromDropDownByText(nivelEducacionSelect, nivelEducacion, waitTime);
    }
    public void ingresarProfesion(String profesion){
        waitForElement(profesionTextBox, waitTime).sendKeys(profesion);
    }
    public void seleccionarCargo(String cargo){
        selectOptionFromDropDownByText(cargoSelect, cargo, waitTime);
    }
    public void seleccionarNivelIngreso(String nivelIngreso){
        selectOptionFromDropDownByText(nivelIngresoSelect, nivelIngreso, waitTime);
    }
    public void seleccionarTipoVivienda(String tipoVivienda){
        selectOptionFromDropDownByText(tipoViviendaSelect, tipoVivienda, waitTime);
    }
    public void seleccionarCantidadHijos(String cantidadhijos){
        selectOptionFromDropDownByText(cantidadHijosSelect, cantidadhijos, waitTime);
    }
    public void ingresarNombreEmpresa(String nombreEmpresa){
        waitForElement(nombreEmpresaTextBox, waitTime).sendKeys(nombreEmpresa);
    }
    public void ingresarMueblesEnseres(String valorMueblesEnseres){
        waitForElement(nombreEmpresaTextBox, waitTime).sendKeys(valorMueblesEnseres);
    }
    public void ingresarBarrio(String barrio){
        waitForElement(barrioTextBox, waitTime).sendKeys(barrio);
    }
    public void ingresarCalle(String calle){
        waitForElement(calleTextBox, waitTime).sendKeys(calle);
    }
    public void seleccionarZona(String zona){
        selectOptionFromDropDownByText(zonaSelect, zona, waitTime);
    }
    public void ingresarNumero(String numero){
        waitForElement(numeroTextBox, waitTime).sendKeys(numero);
    }
    public void ingresarManzana(String manzana){
        waitForElement(manzanaTextBox, waitTime).sendKeys(manzana);
    }
    public void ingresarReferencia(String referencia){
        waitForElement(referenciaTextBox, waitTime).sendKeys(referencia);
    }
    public void seleccionarDepartamentoLaboral(String departamento){
        selectOptionFromDropDownByText(departamentoLaboralSelect, departamento, waitTime);
    }
    public void ingresarBarrioLaboral(String barrio){
        waitForElement(barrioLaboralTextBox, waitTime).sendKeys(barrio);
    }
    public void ingresarCalleLaboral(String calle){
        waitForElement(calleLaboralTextBox, waitTime).sendKeys(calle);
    }
    public void seleccionarZonaLaboral(String zona){
        selectOptionFromDropDownByText(zonaLaboralSelect, zona, waitTime);
    }
    public void ingresarNumeroLaboral(String numero){
        waitForElement(numeroLaboralTextBox, waitTime).sendKeys(numero);
    }
    public void ingresarManzanaLaboral(String manzana){
        waitForElement(manzanaLaboralTextBox, waitTime).sendKeys(manzana);
    }
    public void seleccionarCantidadInmueble(){
        waitForElement(incrementoInmuebleButton,waitTime).click();
    }
    public void llenarValorInmueble(String valorInmueble){
        waitForElement(valorInmueblesTextBox, waitTime).sendKeys(valorInmueble);
    }
    public void cancelar(){
        waitForElement(cancelarButton,waitTime).click();
    }
    public void confirmarConSi(){
        waitForElement(siButton,waitTime).click();
    }
    public void cancelarSolicitud(){
        waitForElement(cancelarSolicitudButton,waitTime).click();
    }
    public boolean existeIniciarSolicitud(){
        return isPresent("//*[@class='android.widget.TextView'][@text='Iniciar una Solicitud']");
    }
    public void iniciarSolicitud(){
        waitForElement(iniciarSolicitudButton,waitTime).click();
    }
    public String getTextEspecificacionesRequisitosActual(){
        return waitForElement(especificacionesRequisitosText,waitTime).getText();
    }
    public void populateCampo(List<String> pLstOpciones, String textToPopulate) {

        int cantidadOpciones = pLstOpciones.size();

        for (int posicion = 0; posicion < cantidadOpciones; posicion++) {
            String opcion = pLstOpciones.get(posicion);
            waitFor(3).seconds();
            String opcionXpath = "//*[@class='android.widget.EditText'][@text='" + opcion + "']";

            if (isPresent(opcionXpath)) {
                WebElement lWelOption = findElement(opcionXpath);
                waitForElement(lWelOption, 5).sendKeys(textToPopulate);
            } else {
                scrollDown();
                posicion--;
            }
            waitFor(3).seconds();
        }
    }

}
