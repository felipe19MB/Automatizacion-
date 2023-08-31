package bo.com.bga.certificacion.gananet.userinterfaces.boletas_garantía;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SolicitudBoletasPage {
    public static final Target TIPO_SOLICITUD = Target.the("Selecciona el tipo de solicitud: {0}").
            locatedBy("//label[text()='{0}']");
    public static final Target CUENTA_DE_DEBITO = Target.the("Selecciona la cuenta: {0} para realizar el débito").
            locatedBy("//div[h4[contains(text(),'{0}')]]/div/label");
    public static final Target TIPO_IMPORTE = Target.the("Selecciona el importe en: {0}").
            locatedBy("//div/a[contains(text(),'{0}')]");
    public static final Target MONTO = Target.the("Digita el monto en el input").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[2]/wizard-datos-cuenta/section/div/div[2]/box-moneda-y-monto/control-box/div/div[2]/form/div/div[2]/div/control-input-monto/div/input");
    public static final Target NRO_TESTIMONIO = Target.the("Selecciona el número de testimonio poder").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/wizard-solicitante/section/form/div/div[1]/control-box/div/div[2]/control-combobox/div/select");
    public static final Target CHECK_TODOS_REPRESENTANTES = Target.the("Check para seleccionar todos los representantes").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[3]/wizard-solicitante/section/form/div/div[2]/control-box/div/div[2]/div[1]/div/label");
    public static final Target NUEVA_O_RENOVACIO = Target.the("Select para seleccionar el tipo de solicitud (Nueva o Renovación)").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/div/control-combobox/div/select");
    public static final Target TIPO_BOLETA = Target.the("Escoge el tipo de boleta").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[1]/control-combobox/div/select");
    public static final Target INPUT_A_LA_ORDEN_DE = Target.the("Diligencia el nombre para el campo de a la orden de").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[1]/control-input-text/div/input");
    public static final Target PLAZO = Target.the("Diligencia el plazo en días").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[2]/control-input-text/div/input");
    public static final Target INPUT_EN_GARANTIA_DE = Target.the("Diligencia el valor para el campo de en garantía de").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[3]/control-input-textarea/div/textarea");
    public static final Target CIUDAD = Target.the("Selecciona la ciudad").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[4]/control-combobox/div/select");
    public static final Target OFICINA = Target.the("Selecciona la oficina de impresión").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[4]/div[2]/control-combobox/div/select");
    public static final Target EMAIL_NOTIFICACION = Target.the("Digita el email de notificación").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[4]/control-input-text/div/input");
    public static final Target NOMBRE = Target.the("Digita el nombre para la entrega de la boleta").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[5]/control-input-text[1]/div/input");
    public static final Target DOCUMENTO_DE_IDENTIDAD = Target.the("Digita el documento de identidad para la entrega de la boleta").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[4]/wizard-solicitud/section/div/div/control-box/div/div[2]/form/div[5]/control-input-text[2]/div/input");
    public static final Target EQUIVALENTE_CARGOS = Target.the("Monto calculado según comisión y monto").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[5]/wizard-cargos/section/form/div/div[1]/control-box/div/div[2]/div/div[2]/control-input-number[1]/div/input");
    public static final Target NOMBRE_FACTURACION = Target.the("Input para diligenciar el nombre impreso en la factura").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[5]/wizard-cargos/section/form/div/div[2]/control-box/div/div[2]/control-input-text[1]/div/input");
    public static final Target NIT_FACTURACION = Target.the("Input para diligenciar el NIT impreso en la factura").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[5]/wizard-cargos/section/form/div/div[2]/control-box/div/div[2]/control-input-text[2]/div/input");
    public static final Target FECHA_VENCIMIENTO = Target.the("Fecha de vencimiento de la boleta").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[6]/wizard-detalle/section/div/div/control-box/div/div[2]/div[2]/div[2]/div/input");
    public static final Target DECLARACION_Y_ACEPTACION_COPY = Target.the("Mensaje para la declaración y aceptación").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/control-contenedor-paginas/section/div/div/control-wizard-step/control-wizard-container[7]/wizard-declaracion-y-aceptacion/section/div/div/control-box/div/div[2]/p");
    public static final Target CONTENIDO_ALERTA_MODAL = Target.the("Mensaje que contiene el mensaje de la transacción").
            located(By.xpath("/html/body/div[3]/div/div[2]/div[1]"));
    public static final Target ICONO_EXITOSO_MODAL = Target.the("Mensaje que contiene el mensaje de la transacción").
            located(By.className("swal2-success-ring"));
    public static final Target TITULO_COMPROBANTE_BOLETAS = Target.the("Titulo que contiene el mensaje de la transacción").
            located(By.xpath("/html/body/app-root/app-paginas/div/div/app-prepagada/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/h3"));
    public static final Target HORA_COMPROBANTE_BOLETAS = Target.the("Hora en la que se generó el comprobante de la boleta de garantía").
            located(By.xpath("/html/body/app-root/app-paginas/div/div/app-prepagada/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]"));
    public static final Target FECHA_COMPROBANTE_BOLETAS = Target.the("Fecha en la que se generó el comprobante de la boleta de garantía").
            located(By.xpath("/html/body/app-root/app-paginas/div/div/app-prepagada/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div[1]"));
    public static final Target ID_COMPROBANTE_BOLETAS = Target.the("Fecha en la que se generó el comprobante de la boleta de garantía").
            locatedBy("/html/body/app-root/app-paginas/div/div/app-prepagada/app-dialog-comprobante/div/div/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div[3]/strong");
}
