package bo.com.bga.certificacion.gananet.userinterfaces.transferencias;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AfiliacionesPage {
    public static final Target TIPO_CUENTA_HISTORICO= Target.the("ingresa a sub funcionalidad de historico")
            .locatedBy("//a[@class='nav-link'][normalize-space()='{0}']");
    public static final Target BOTON_AGREGAR= Target.the("agregar nueva cuenta")
            .locatedBy("//strong[contains(text(),'Agregar +')]");
    public static final Target BOTON_AGREGAR_EXTERIOR= Target.the("agregar nueva cuenta")
            .locatedBy("//a[contains(text(),'Agregar +')]");
    public static final Target TXT_ALIAS= Target.the("ingresa alias")
            .locatedBy("//label[contains(text(),'Alias')]/following-sibling::div//input");
    public static final Target SELECT_BANCO= Target.the("selecciona banco")
            .locatedBy("//label[contains(text(),'Banco')]/following-sibling::div//select");
    public static final Target SELECT_SUCURSAL= Target.the("selecciona sucursal")
            .locatedBy("//label[contains(text(),'Sucursal')]/following-sibling::div//select");
    public static final Target TXT_NOMBRE_TITULAR= Target.the("ingresa nombre titular")
            .locatedBy("//label[contains(text(),'Nombre titular')]/following-sibling::div//input");
    public static final Target TXT_NOMBRE_TITULAR_TERCEROS= Target.the("ingresa nombre titular")
            .locatedBy("//label[contains(text(),'Titular de cuenta')]/following-sibling::div//input");
    public static final Target TXT_CI_NIT= Target.the("ingresa CI / NIT")
            .locatedBy("//label[contains(text(),'CI/NIT')]/following-sibling::input");
    public static final Target SELECT_TIPO_CUENTA= Target.the("selecciona tipo cuenta")
            .locatedBy("//label[contains(text(),'Tipo de cuenta')]/following-sibling::select");
    public static final Target TXT_NRO_CUENTA= Target.the("ingresa cuenta")
            .locatedBy("//label[contains(text(),'Nro cuenta')]/following-sibling::div//input");
    public static final Target TXT_NRO_CUENTA_TERCEROS= Target.the("ingresa cuenta")
            .locatedBy("//label[contains(text(),'Nro. de cuenta')]/following-sibling::div//input");
    public static final Target TXT_NRO_CUENTA_BILLETERA= Target.the("ingresa cuenta billetera")
            .locatedBy("//label[contains(text(),'Teléfono')]/following-sibling::div//input");
    public static final Target BOTON_VERIFICAR= Target.the("verifica cuenta")
            .locatedBy("//label[contains(text(),'Titular de cuenta')]/following-sibling::div//button");
    public static final Target BOTON_VERIFICAR_TELEFONO= Target.the("verifica numero telefono")
            .locatedBy("//label[contains(text(),'Teléfono')]/following-sibling::div//button");
    public static final Target TXT_EMAIL= Target.the("ingresa email")
            .locatedBy("//label[contains(text(),'E-mail del beneficiario')]/following-sibling::div//input");
    public static final Target LBL_FAVORITO= Target.the("selecciona favorito")
            .locatedBy("//label[contains(text(),'Favorito')]");
    public static final Target BOTON_GUARDAR= Target.the("guarda cuenta")
            .locatedBy("//button[contains(text(),'Guardar')]");
    public static final Target BOTON_OK= Target.the("cierra mensaje")
            .locatedBy("//button[contains(text(),'OK')]");
    public static final Target BOTON_ELIMINAR_CUENTA= Target.the("elimina cuenta agregada")
            .locatedBy("//small[contains(text(),'{0}')]/parent::div/following-sibling::div[3]/a");

    public static final Target ASSERT_NUMERO_CUENTA= Target.the("validacion numero de cuenta")
            .locatedBy("//small[contains(text(),'{0}')]");
    public static final Target ASSERT_ENTIDAD= Target.the("validacion entidad")
            .locatedBy("//small[contains(text(),'{0}')]/parent::div/following-sibling::div[1]/h6");
    public static final Target ASSERT_ALIAS= Target.the("validacion alias")
            .locatedBy("//small[contains(text(),'{0}')]/parent::div/preceding-sibling::div[1]/small");
    public static final Target ASSERT_TITULAR= Target.the("validacion titular")
            .locatedBy("//small[contains(text(),'{0}')]/parent::div/preceding-sibling::div[2]/small");
    public static final Target ASSERT_TITULAR_TERCEROS= Target.the("validacion titular")
            .locatedBy("//small[contains(text(),'{0}')]/parent::div/preceding-sibling::div[2]/h6");
    public static final Target ASSERT_TIPO_CUENTA= Target.the("validacion tipo cuenta")
            .locatedBy("//small[contains(text(),'{0}')]/parent::div/following-sibling::div[1]/small");
    public static final Target MODAL= Target.the("ve modal")
            .locatedBy("//body[1]/app-root[1]/app-paginas[1]/div[1]/div[1]/app-otros-bancos[1]/control-modal-segundo-factor[1]/div[1]/div[1]/div[1]/div[1]/h5[1]");
    public static final Target BUTTON_PROCESAR= Target.the("Botón para procesar GanaPin")
            .located(By.xpath("(//form[contains(@class, 'ng-valid')]//button[@type='submit'])[2]"));
    public static final Target TXT_ALIAS_EXTERIOR= Target.the("ingresa alias")
            .locatedBy("//label[contains(text(),'Alias')]/following-sibling::input");
    public static final Target TXT_CUENTA_IBAN= Target.the("ingresa cuenta IBAN")
            .locatedBy("//label[contains(text(),'Cuenta/IBAN')]/following-sibling::input");
    public static final Target TXT_NOMBRE= Target.the("ingresa nombre cliente")
            .locatedBy("//label[contains(text(),'Nombre')]/following-sibling::input[@maxlength='66']");
    public static final Target TXT_NUMERO_DOCUMENTO= Target.the("ingresa numero de documento")
            .locatedBy("//label[contains(text(),'Nro Documento')]/following-sibling::input");
    public static final Target SELECT_TIPO_PERSONA= Target.the("selecciona tipo persona")
            .locatedBy("//label[contains(text(),'Tipo Persona')]/following-sibling::div/select");
    public static final Target TXT_DIRECCION= Target.the("ingresa direccion")
            .locatedBy("//label[contains(text(),'Dirección')]/following-sibling::input");
    public static final Target SELECT_PAIS= Target.the("selecciona pais")
            .locatedBy("//label[contains(text(),'Pais')]/following-sibling::div/select");
    public static final Target TXT_CIUDAD= Target.the("ingresa ciudad")
            .locatedBy("//label[contains(text(),'Cuidad')]/following-sibling::input");
    public static final Target BUTTON_GUARDAR_1= Target.the("Botón para guardar datos")
            .located(By.xpath("//button[@_ngcontent-c25=''][contains(text(),'Guardar')]"));
    public static final Target BUTTON_GUARDAR_2= Target.the("Botón para guardar datos")
            .located(By.xpath("//*[@id='modal-banco-beneficiario']//button[contains(text(),'Guardar')]"));

    public static final Target SELECT_TIPO_CODIGO= Target.the("selecciona tipo de codigo")
            .locatedBy("//*[@id='modal-banco-beneficiario']//label[contains(text(),'Tipo de Codigo')]/following-sibling::div/select");
    public static final Target TXT_CODIGO_BANCO= Target.the("ingresa codigo banco")
            .locatedBy("//*[@id='modal-banco-beneficiario']//label[contains(text(),'Codigo Banco')]/following-sibling::input");
    public static final Target TXT_NOMBRE_BANCO= Target.the("ingresa nombre banco")
            .locatedBy("//*[@id='modal-banco-beneficiario']//label[contains(text(),'Nombre')]/following-sibling::input");
    public static final Target SELECT_PAIS_BANCO= Target.the("selecciona pais del banco")
            .locatedBy("//*[@id='modal-banco-beneficiario']//label[contains(text(),'País')]/following-sibling::div/select");
    public static final Target TXT_CIUDAD_BANCO= Target.the("ingresa ciudad banco")
            .locatedBy("//*[@id='modal-banco-beneficiario']//label[contains(text(),'Ciudad')]/following-sibling::input");
    public static final Target BUTTON_BANCO_BENEFICIARIO= Target.the("Botón para agregar datos banco beneficiario")
            .located(By.xpath("//button[@href='#modal-banco-beneficiario']"));
    public static final Target ASSERT_NOMBRE_AFILIADO= Target.the("validacion nombre afiliado")
            .locatedBy("//small[contains(text(),'{0}')]");
}
