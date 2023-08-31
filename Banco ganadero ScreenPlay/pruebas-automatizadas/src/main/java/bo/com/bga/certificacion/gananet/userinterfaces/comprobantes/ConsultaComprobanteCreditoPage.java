package bo.com.bga.certificacion.gananet.userinterfaces.comprobantes;

import net.serenitybdd.screenplay.targets.Target;

public class ConsultaComprobanteCreditoPage {

    public static final Target SELECT_TIPO_MOVIMIENTO = Target.the("Tipo Movimiento")
            .locatedBy("//label[contains(text(),'Tipo Movimiento ')]/following-sibling::select");

    public static final Target SELECT_CUENTA = Target.the("Cuenta")
            .locatedBy("//label[contains(text(),'Cuenta')]/following-sibling::select");

    public static final Target SELECT_DESDE = Target.the("Desde")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-comprobante[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/div[1]/control-box[1]/div[1]/div[1]/div[2]/control-datebox[1]/div[1]/div[1]/input[1]");

    public static final Target SELECT_HASTA = Target.the("Hasta")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-comprobante[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/div[1]/control-box[1]/div[1]/div[1]/div[2]/control-datebox[2]/div[1]/div[1]/input[1]");
    public static final Target BOTON_CONSULTAR = Target.the("Consultar")
            .locatedBy("//button[contains(text(),'Consultar')]");

    public static final Target BOTON_VER = Target.the("Opciones")
            .locatedBy("//tbody/tr[2]/td[8]/a[1]/i[1]");

    public static final Target ASSERT_FECHA= Target.the("Validacion Fecha")
            .locatedBy("//div[@class='ribbon-wrapper']//div[@class='row']//div[@class='col-5']/text()");

    public static final Target ASSERT_HORA= Target.the("Validacion Hora")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-comprobante[1]/app-comprobante-general[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]");

    public static final Target ASSERT_NUMERO_DE_ASIENTO= Target.the("Validacion Numero de Asiento")
            .locatedBy("//strong[@class='pull-right']");

    public static final Target ASSERT_CUENTA_DESTINO= Target.the("Validacion cuenta destino")
            .locatedBy("//div[strong[contains(., 'Cuenta Destino:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target ASSERT_NOMBRE_CLIENTE= Target.the("Validacion nombre del cliente")
            .locatedBy("//div[contains(text(),'PERSONA NATURAL')]");

    public static final Target ASSERT_IMPORTE= Target.the("Validacion importe")
            .locatedBy("//div[strong[contains(., 'Importe:')]]/following-sibling::div[contains(., '{0}')]");

    public static final Target ASSERT_CUENTA_ORIGEN= Target.the("Validacion cuenta origen")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-comprobante[1]/app-comprobante-general[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[10]");

    public static final Target ASSERT_IMPORTE_DEBITADO= Target.the("Validacion importe debitado")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-consulta-comprobante[1]/app-comprobante-general[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[12]");

    public static final Target ASSERT_GLOSA= Target.the("Validacion Glosa")
            .locatedBy("//div[strong[contains(., 'Glosa:')]]/following-sibling::div[contains(., '{0}')]");
}
