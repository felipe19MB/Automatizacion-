package bo.com.bga.certificacion.gananet.userinterfaces.orden_cobro_simple.administracion_qr;

import net.serenitybdd.screenplay.targets.Target;

public class AdministracionQrPage {
    public static final Target DRAG_CUENTA= Target.the("arrastrar cuenta")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div");
    public static final Target DROP_CUENTA= Target.the("soltar cuenta")
            .locatedBy("//div[contains(text(),'Arrastra hasta Aquí para agregar una nueva cuenta!')]/parent::div");
    public static final Target TXT_REFERENCIA= Target.the("ingresa referencia")
            .locatedBy("//label[contains(text(),'Referencia')]/following-sibling::input");
    public static final Target RDO_FECHA_VENCIMIENTO= Target.the("selecionar de fecha vencimiento")
            .locatedBy("//label[contains(text(),'{0}')]");
    public static final Target RDO_USO= Target.the("selecionar uso")
            .locatedBy("//label[contains(text(),'{0}')]");
    public static final Target BOTON_PROCESAR= Target.the("boton para procesar")
            .locatedBy("//app-dialog-formulario//button[contains(text(),'Procesar')]");
    public static final Target ASSERT_CUENTA= Target.the("cuenta encontrada")
            .locatedBy("//control-tabla-v2//h4[contains(text(),'{0}')]");
    public static final Target ASSERT_REFERENCIA= Target.the("referencia encontrada")
            .locatedBy("//control-tabla-v2//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[1]/h4");
    public static final Target ASSERT_EXPIRACION= Target.the("expiracion encontrada")
            .locatedBy("//control-tabla-v2//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[2]/h4");
    public static final Target ASSERT_USO= Target.the("uso encontrada")
            .locatedBy("//control-tabla-v2//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[3]/h4");
    public static final Target ASSERT_ESTADO= Target.the("estado encontrada")
            .locatedBy("//control-tabla-v2//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[4]/h4");
    public static final Target BOTON_ELIMINAR= Target.the("boton para eliminar")
            .locatedBy("//control-tabla-v2//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[5]//a[@title='Eliminar']/i");
    public static final Target PERFIL_LISTA = Target.the("elemento para desplegar la lista de productos asociados al cliente")
            .locatedBy("(//i[contains(@class,'fa fa-caret-down')])[1]");

    public static final Target CIRCULO_CARGA= Target.the("circulo de carga")
            .locatedBy("//div[contains(@class,'col-12')]//grafico-cuenta//div[contains(@class,'box')]//ngx-loading//div//div//div[contains(@class,'spinner-circle-swish')]");


}