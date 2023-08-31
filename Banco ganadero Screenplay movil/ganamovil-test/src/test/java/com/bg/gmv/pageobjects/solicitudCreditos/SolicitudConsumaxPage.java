package com.bg.gmv.pageobjects.solicitudCreditos;

import com.bg.gmv.pageobjects.BasePage;
import com.bg.gmv.util.Constants.SolicitudConsumaxConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SolicitudConsumaxPage extends BasePage {

    private final int waitTime = 15;
    private final String emailTitular = "asvaldivia12@gmail.com";
    private final String noEsAsalariadoText = "No soy Asalariado";
    private final String dia = "1";
    private final String mes = "8";
    private final String anho = "2014";
    private final String noIntegro = "No Integro (integramos) ningún grupo económico.";
    private final String iniciarUnaSolicitud = "Iniciar una Solicitud";
    private final String iniciarUnaSolicitudTitle = "Consumax GanaMóvil";
    private final String especificacionesRequisitos = "Especificaciones y Requisitos";
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement title;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement iniciarSolicitudOpcion;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='No soy Asalariado']")
    private WebElement noSoyAsalariadoButton;
    @FindBy(xpath = "/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement noSoyAsalariadoErrorMessage;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[2]")
    private WebElement confirmarSolicitudCreditoButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[2]")
    private WebElement confirmarTerminosCondicionesButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement estadoCivilDropDown;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    private WebElement solteroOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement residenciaDropDown;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[12]")
    private WebElement santaCruzOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    private WebElement beniOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.EditText")
    private WebElement sueldoLiquidoTitularUsdTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText")
    private WebElement telefonoTitularTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.EditText")
    private WebElement correoElectronicoTitularTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[2]")
    private WebElement confirmarDatosSolicitadosButton;
    @FindBy(xpath = "//*[@class='android.widget.EditText'][@text='']")
    private WebElement montoASolicitarTextBox;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Seleccionar']")
    private WebElement diaParaPagarDropDown;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarDatosDelMontoASolicitarButton;
    //Cancelar solicitud
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Cancelar']")
    private WebElement cancelarButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Si']")
    private WebElement siButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Cancelar Solicitud']")
    private WebElement cancelarSolicitudButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Estimado Cliente, se desestimo la solicitud.']")
    private WebElement solicitudDesestimadaMessage;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement nivelEducacionDropDown;
    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='PROFESIONAL']")
    private WebElement profesionalOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")
    private WebElement profesionTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement cargoDropDown;
    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='JEFE']")
    private WebElement jefeOption;

    //Actividad economica
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement nivelIngresoDropDown;
    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='$1201 - $2000']")
    private WebElement thirdOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement tipoViviendaDropDown;
    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='VIVIENDA FAMILIAR']")
    private WebElement viviendaFamiliarOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement cantidadHijosDropDown;
    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='0']")
    private WebElement zeroHijosOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.EditText")
    private WebElement nombreEmpresaTextBox;
    @FindBy(xpath = "//*[@class='android.widget.EditText'][@text='Mes']")
    private WebElement mesTextBox;
    @FindBy(xpath = "//*[@class='android.widget.EditText'][@text='Año']")
    private WebElement anhoTextBox;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Confirmar']")
    private WebElement confirmarButton;
    @FindBy(xpath = "//*[@class='android.widget.Button'][@text='Aceptar']")
    private WebElement aceptarButton;
    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement permitirUbicacionButton;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")
    private WebElement barrioTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")
    private WebElement calleTextBox;
    @FindBy(xpath = "//*[@class='android.widget.TextView'][@text='Seleccionar']")
    private WebElement zonaSelectBox;
    @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='CENTRO']")
    private WebElement centroOption;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")
    private WebElement numeroTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement manzanaTextBox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText")
    private WebElement referenciaTextBox;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement departamentoDropDown;
    @FindBy(xpath="//*[@class='android.widget.CheckedTextView'][@text='CHUQUISACA-SUCRE']")
    private WebElement chuquisacaOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement zonaLaboralDropDown;
    @FindBy(xpath="//*[@class='android.widget.CheckedTextView'][@text='NORTE']")
    private WebElement norteOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[1]")
    private WebElement barrioLaboralTextBox;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText[2]")
    private WebElement calleLaboralTextBox;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText")
    private WebElement numeroLaboralTextBox;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText")
    private WebElement manzanaLaboralTextBox;
    @FindBy(xpath="//*[@class='android.widget.CheckedTextView'][@text='No Integro (integramos) ningún grupo económico.']")
    private WebElement noIntegroText;
    @FindBy(xpath="//*[@class='android.widget.EditText']")
    private WebElement valorMueblesEnseresTextBox;
    @FindBy(xpath="//*[@class='android.widget.TextView'][@text='Consumax GanaMóvil']")
    private WebElement iniciarSolicitudTitleText;
    @FindBy(xpath="//*[@class='android.widget.TextView'][@text='Iniciar una Solicitud']")
    private WebElement iniciarSolicitudButtonText;
    @FindBy(xpath="//*[@class='android.widget.TextView'][@text='Especificaciones y Requisitos']")
    private WebElement especificacionesRequisitosText;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")
    private WebElement pesoTextBox;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")
    private WebElement alturaTextBox;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement seEncuentraSanoYesOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement enfermedadDiagnosticadaNoOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement hivNoOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement deporteRiesgoNoOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement tratamientoMedicoNoOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement medicamentosNoOption;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement intervencionesQuirurgicasNoOption;
    @FindBy(xpath="/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement solicitudExitosaText;


    public String getEmailTitular() {
        return emailTitular;
    }

    public String getNoEsAsalariadoText() {
        return noEsAsalariadoText;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAnho() {
        return anho;
    }

    public String getNoIntegro() { return noIntegro; }

    public String getIniciarUnaSolicitud() { return iniciarUnaSolicitud; }

    public String getIniciarUnaSolicitudTitle() { return iniciarUnaSolicitudTitle; }

    public String getEspecificacionesRequisitos() { return especificacionesRequisitos; }

    public String title() {
        waitFor(2).seconds();
        return title.getText();
    }

    public void clickIniciarSolicitud() {
        waitForElement(iniciarSolicitudOpcion, waitTime).click();
    }

    public void clickNoSoyAsalariado() {
        waitFor(2).seconds();
        noSoyAsalariadoButton.click();
    }

    public String getTextIniciarSolicitud() {
        waitFor(2).seconds();
        return iniciarSolicitudOpcion.getText();
    }

    public String getMensajeNoEsAsalariado() {
        return waitForElement(noSoyAsalariadoButton, waitTime).getText();
    }

    public String getNoSoyAsalariadoErrorMessage() {
        waitFor(2).seconds();
        return noSoyAsalariadoErrorMessage.getText();
    }

    public void clickConfirmarSolicitudCredito() {
        waitFor(2).seconds();
        confirmarSolicitudCreditoButton.click();
    }

    public void clickConfirmarTerminosCondiciones() {
        waitForElement(confirmarTerminosCondicionesButton, waitTime).click();
    }

    public void clickEstadoCivilDropDown() {
        waitFor(10).seconds();
        estadoCivilDropDown.click();
    }

    public void selectSolteroOption() {
        waitFor(2).seconds();
        solteroOption.click();
    }

    public void clickResidenciaDropDown() {
        waitFor(2).seconds();
        residenciaDropDown.click();
    }

    public void selectSantaCruzOption() {
        waitFor(2).seconds();
        santaCruzOption.click();
    }

    public void selectBeniOption() {
        waitFor(2).seconds();
        beniOption.click();
    }

    public void populateSueldoLiquidoTitularUSD(String sueldo) {
        waitFor(2).seconds();
        sueldoLiquidoTitularUsdTextBox.sendKeys(sueldo);
    }

    public void populateCorreoElectronicoTitular() {
        waitFor(2).seconds();
        correoElectronicoTitularTextBox.sendKeys(emailTitular);
    }

    public void populateTelefonoTitular(String telefono) {
        waitFor(2).seconds();
        telefonoTitularTextBox.sendKeys(telefono);
    }

    public void clickConfirmarDatosSolicitados() {
        waitFor(2).seconds();
        confirmarDatosSolicitadosButton.click();
    }

    public void populateMontoASolicitar(String montoASolicitar) {
        waitFor(10).seconds();
        montoASolicitarTextBox.sendKeys(montoASolicitar);
    }

    public void clickSeleccionaDiaDropDown() {
        waitFor(2).seconds();
        diaParaPagarDropDown.click();
    }

    public void clickDiaOption(int dia) {
        String optionXpath = "//*[@class='android.widget.CheckedTextView'][@text='" + dia + "']";
        WebElement diaOption = findElement(optionXpath);
        waitForElement(diaOption, 5).click();
    }

    public void clickConfirmarMonto() {
        waitFor(2).seconds();
        confirmarDatosDelMontoASolicitarButton.click();
    }

    //Actividad Economica

    public void clickNivelEducacionDropDown() {
        waitFor(10).seconds();
        nivelEducacionDropDown.click();
    }

    public void clickProfesionalOption() {
        waitFor(2).seconds();
        profesionalOption.click();
    }

    public void populateProfesion(String profesion) {
        waitFor(2).seconds();
        profesionTextBox.sendKeys(profesion);
    }

    public void clickCargoDropDown() {
        waitFor(2).seconds();
        cargoDropDown.click();
    }

    public void clickJefeOption() {
        waitFor(2).seconds();
        jefeOption.click();
    }

    public void clickNivelIngresoDropDown() {
        waitFor(2).seconds();
        nivelIngresoDropDown.click();
    }

    public void clickThirdOption() {
        waitFor(2).seconds();
        thirdOption.click();
    }

    public void clickTipoViviendaDropDown() {
        waitFor(2).seconds();
        tipoViviendaDropDown.click();
    }

    public void clickFamiliarOption() {
        waitFor(2).seconds();
        viviendaFamiliarOption.click();
    }

    public void clicCantidadHijosDropDown() {
        waitFor(2).seconds();
        cantidadHijosDropDown.click();
    }

    public void clickZeroHijosOption() {
        waitFor(2).seconds();
        zeroHijosOption.click();
    }

    public void populateNombreEmpresa(String empresa) {
        waitFor(2).seconds();
        nombreEmpresaTextBox.sendKeys(empresa);
    }

    public void populateMes(String mes) {
        waitFor(2).seconds();
        mesTextBox.sendKeys(mes);
    }

    public void populateAnho(String anho) {
        waitFor(2).seconds();
        anhoTextBox.sendKeys(anho);
    }

    public void clickCancelar() {
        waitFor(2).seconds();
        cancelarButton.click();
    }

    public void clickSi() {
        waitFor(2).seconds();
        siButton.click();
    }

    public void clickCancelarSolicitud() {
        waitFor(2).seconds();
        cancelarSolicitudButton.click();
    }

    public String getSolicitudDesestimadaSuccessMessage() {
        waitFor(2).seconds();
        return solicitudDesestimadaMessage.getText();
    }

    public void clickConfirmar() {
        waitFor(10).seconds();
        confirmarButton.click();
    }

    public void clickAceptar() {
        waitFor(2).seconds();
        aceptarButton.click();
    }

    public void clickPermitirUbicacion() {

        try {
            waitFor(10).seconds();
            permitirUbicacionButton.click();
        } catch (Exception ex) {
            System.out.println("Permisos de ubicación permitidos.");
        }

    }

    public void populateBarrio(String barrio) {
        waitFor(2).seconds();
        barrioTextBox.sendKeys(barrio);
    }

    public void populateCalle(String calle) {
        waitFor(2).seconds();
        calleTextBox.sendKeys(calle);
    }

    public void clickZonaDropDown() {
        waitFor(2).seconds();
        zonaSelectBox.click();
    }

    public void clickCentroOption() {
        waitFor(2).seconds();
        centroOption.click();
    }

    public void populateNumero(String numero) {
        waitFor(2).seconds();
        numeroTextBox.sendKeys(numero);
    }

    public void populateManzana(String manzana) {
        waitFor(2).seconds();
        manzanaTextBox.sendKeys(manzana);
    }

    public void populateReferencia(String referencia) {
        waitFor(2).seconds();
        referenciaTextBox.sendKeys(referencia);
    }

    public void clickDepartamentoDropDown(){
        waitFor(5).seconds();
        departamentoDropDown.click();
    }

    public void clickChuquisacaOption(){
        waitFor(SolicitudConsumaxConstants.getTinyWaitTime()).seconds();
        chuquisacaOption.click();
    }

    public void clickZonaLaboralDropDown(){
        waitFor(SolicitudConsumaxConstants.getTinyWaitTime()).seconds();
        zonaLaboralDropDown.click();
    }

    public void clickNorteOption(){
        waitFor(SolicitudConsumaxConstants.getTinyWaitTime()).seconds();
        norteOption.click();
    }

    public void populateBarrioLaboral(String barrio){
        barrioLaboralTextBox.sendKeys(barrio);
    }

    public void populateCalleLaboral(String calle){
        calleLaboralTextBox.sendKeys(calle);
    }

    public void populateNumeroLaboral(String numero){
        numeroLaboralTextBox.sendKeys(numero);
    }

    public void populateManzanaLaboral(String manzana){
        manzanaLaboralTextBox.sendKeys(manzana);
    }

    public String textNoIntegro(){
        waitFor(SolicitudConsumaxConstants.getBigWaitTime()).seconds();
        return noIntegroText.getText();
    }

    public void populateValorMueblesEnseres(String valorMueblesEnseres){
        waitFor(SolicitudConsumaxConstants.getBigWaitTime()).seconds();
        valorMueblesEnseresTextBox.sendKeys(valorMueblesEnseres);
    }

    public String textSolicitudConsumaxTitle(){
        return iniciarSolicitudTitleText.getText();
    }

    public String textIniciarSolicitudButton(){
        waitFor(SolicitudConsumaxConstants.getBigWaitTime()).seconds();
        return iniciarSolicitudButtonText.getText();
    }

    public String textEspecificacionesYRequisitos(){
        waitFor(SolicitudConsumaxConstants.getTinyWaitTime()).seconds();
        return especificacionesRequisitosText.getText();
    }

    public void escribirFirma(){
        Dimension dimension = getDriver().manage().window().getSize();

        int startX = (int) (dimension.width * 0.5);
        int startY = (int) (dimension.height * 0.6);
        int endX = (int) (dimension.width * 0.5);
        int endY = (int) (dimension.height * 0.45);

        moveTo(startX, startY, endX, endY);
    }

    public void populatePeso(String peso){
        waitFor(50);
        pesoTextBox.sendKeys(peso);
    }

    public void populateAltura(String altura){
        alturaTextBox.sendKeys(altura);
    }

    public void clickSeEncuentraSanoYesOption(){
        seEncuentraSanoYesOption.click();
    }

    public void clickEnfermedadDiagnosticadaNoOption(){
        enfermedadDiagnosticadaNoOption.click();
    }

    public void clickHivNoOption(){
        hivNoOption.click();
    }

    public void clickDeporteRiesgoNoOption(){
        deporteRiesgoNoOption.click();
    }

    public void clickTratamientoMedicoNoOption(){
        waitFor(SolicitudConsumaxConstants.getBigWaitTime());
        String tratamientoMedicoNoOptionXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup";
        clickElement(tratamientoMedicoNoOptionXpath);
    }

    public void clickMedicamentosNoOption(){
        medicamentosNoOption.click();
    }

    public void clickIntervencionesQuirurgicasNoOption(){
        intervencionesQuirurgicasNoOption.click();
    }

    public String textSolicitudExitosa(){
        waitFor(SolicitudConsumaxConstants.getBigWaitTime()).seconds();
        return solicitudExitosaText.getText();
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
    public void clickElement(String xpath) {

        int cantidadCiclos = 1;

        for (int posicion = 0; posicion < cantidadCiclos; posicion++) {
            waitFor(3).seconds();
            if (isPresent(xpath)) {
                WebElement lWelOption = findElement(xpath);
                waitForElement(lWelOption, 5).click();
            } else {
                scrollDown();
                posicion--;
            }
            waitFor(3).seconds();
        }
    }
}