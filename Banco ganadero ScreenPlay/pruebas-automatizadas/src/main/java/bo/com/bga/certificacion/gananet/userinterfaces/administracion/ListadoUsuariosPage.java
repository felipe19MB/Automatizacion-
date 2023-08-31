package bo.com.bga.certificacion.gananet.userinterfaces.administracion;

import net.serenitybdd.screenplay.targets.Target;

public class ListadoUsuariosPage {
    public static final Target TIPO_CUENTA_HISTORICO= Target.the("ingresa a sub funcionalidad de historico")
            .locatedBy("//a[@class='nav-link'][normalize-space()='{0}']");
    /**
     * Documentos del usuario.
     */
    public static final Target BOTON_AGREGAR= Target.the("agregar nueva cuenta")
            .locatedBy("//app-usuario-listado//control-box//button");
    public static final Target BOTON_ACEPTAR_CONTRATO= Target.the("aceptar contrato")
            .locatedBy("//button[contains(text(),'Acepto')]");
    public static final Target SELECT_TIPO_DOCUMENTO= Target.the("selecciona tipo de documento")
            .locatedBy("//label[contains(text(),'Tipo de documento')]/following-sibling::select");
    public static final Target TXT_DOCUMENTO_IDENTIDAD= Target.the("ingresa documento de identidad")
            .locatedBy("//label[contains(text(),'Documento identidad')]/following-sibling::input");
    public static final Target SELECT_EXTENSION_DOCUMENTO= Target.the("selecciona extension")
            .locatedBy("//label[contains(text(),'Seleccione la extensión')]/following-sibling::select");
    public static final Target TXT_FECHA_VENCIMIENTO_CI= Target.the("ingresa fecha de vencimiento de documento de identidad")
            .locatedBy("//label[contains(text(),'Documento identidad')]/following-sibling::input");
    /**
     * Formulario de registro.
     */
    public static final Target TXT_PRIMER_NOMBRE= Target.the("ingresa primer nombre")
            .locatedBy("//label[contains(text(),'Primer nombre')]/following-sibling::input");
    public static final Target TXT_SEGUNDO_NOMBRE= Target.the("ingresa segundo nombre")
            .locatedBy("//label[contains(text(),'Segundo nombre')]/following-sibling::input");
    public static final Target TXT_APELLIDO_PATERNO= Target.the("ingresa apellido paterno")
            .locatedBy("//label[contains(text(),'Apellido Paterno')]/following-sibling::input");
    public static final Target TXT_APELLIDO_MATERNO= Target.the("ingresa apellido materno")
            .locatedBy("//label[contains(text(),'Apellido Materno')]/following-sibling::input");
    public static final Target TXT_EMAIL= Target.the("ingresa E-mail")
            .locatedBy("//label[contains(text(),'E-mail')]/following-sibling::input");
    public static final Target TXT_FECHA_NACIMIENTO= Target.the("ingresa fecha nacimiento")
            .locatedBy("//label[contains(text(),'Fecha Nacimiento')]/following-sibling::div/input");
    public static final Target SELECT_PAIS_NACIMIENTO= Target.the("selecciona pais de nacimiento")
            .locatedBy("//label[contains(text(),'Seleccione país de nacimiento')]/following-sibling::select");
    public static final Target SELECT_SEXO= Target.the("selecciona sexo")
            .locatedBy("//label[contains(text(),'Seleccione sexo')]/following-sibling::select");
    public static final Target SELECT_ESTADO_CIVIL= Target.the("selecciona estado civil")
            .locatedBy("//label[contains(text(),'Seleccione estado civil')]/following-sibling::select");
    public static final Target SELECT_PROFESION= Target.the("selecciona profesion")
            .locatedBy("//label[contains(text(),'Seleccione profesión')]/following-sibling::select");
    public static final Target SELECT_USA_APELLIDO_ESPOSO= Target.the("selecciona usa apellido del esposo")
            .locatedBy("//label[contains(text(),'Usa apellido de esposo')]/following-sibling::select");
    public static final Target TXT_NOMBRE_REFERENCIA_1= Target.the("ingresa nombre de referencia 1")
            .locatedBy("//label[contains(text(),'Nombre de la referencia 1')]/following-sibling::input");
    public static final Target TXT_NUMERO_TELEFONO_REFERENCIA_1= Target.the("ingresa telefono referencia 1")
            .locatedBy("//label[contains(text(),'Fecha Nacimiento')]/following-sibling::div/input");
    public static final Target SELECT_RELACION_REFERENCIA_1= Target.the("selecciona relacion")
            .locatedBy("//control-combobox[@formcontrolname='refTipoRelacion1']//select");
    public static final Target TXT_NOMBRE_REFERENCIA_2= Target.the("ingresa nombre de referencia 2")
            .locatedBy("//label[contains(text(),'Nombre de la referencia 2')]/following-sibling::input");
    public static final Target TXT_NUMERO_TELEFONO_REFERENCIA_2= Target.the("ingresa telefono referencia 2")
            .locatedBy("//label[contains(text(),'Numero de teléfono de la referencia 2')]/following-sibling::input");
    public static final Target SELECT_RELACION_REFERENCIA_2= Target.the("selecciona pais de nacimiento")
            .locatedBy("//control-combobox[@formcontrolname='refTipoRelacion2']//select");
    public static final Target SELECT_DEPARTAMENTO_DOMICILIO= Target.the("selecciona departamento")
            .locatedBy("//control-combobox[@formcontrolname='codDepartamento']//select");
    public static final Target SELECT_CIUDAD_DOMICILIO= Target.the("selecciona ciudad")
            .locatedBy("//control-combobox[@formcontrolname='codCiudad']//select");
    public static final Target TXT_DESCRIPCION_BARRIO_DOMICILIO= Target.the("ingresa descripcion barrio")
            .locatedBy("//control-input-text[@formcontrolname='desBarrio']//input");
    public static final Target SELECT_ZONA_DOMICILIO= Target.the("selecciona zona")
            .locatedBy("//control-combobox[@formcontrolname='codZona']//select");
    public static final Target TXT_DESCRIPCION_CALLE_DOMICILIO= Target.the("ingresa calle")
            .locatedBy("//label[contains(text(),'Descripción de la calle')]/following-sibling::input");
    /**
     * Selección de permisos.
     */
    public static final Target SELECT_TIPO_USUARIO= Target.the("selecciona tipo de usuario")
            .locatedBy("//label[contains(text(),'Tipo usuario')]/following-sibling::select");
    public static final Target SELECT_PERFIL= Target.the("selecciona zona")
            .locatedBy("//label[contains(text(),'Perfil')]/following-sibling::select");
    public static final Target SELECT_ESTADO= Target.the("selecciona zona")
            .locatedBy("//label[contains(text(),'Estado')]/following-sibling::select");
    public static final Target BOTON_SIGUIENTE= Target.the("boton siguiente")
            .locatedBy("//button[contains(text(),'Siguiente')]");
    public static final Target BOTON_CONFIRMAR= Target.the("confirmar")
            .locatedBy("//button[contains(text(),'Confirmar')]");
    public static final Target ASSERT_CODIGO= Target.the("validacion codigo")
            .locatedBy("//h4[contains(text(),'{0}')]");
    public static final Target ASSERT_NOMBRE= Target.the("validacion nombre")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[1]//h4");
    public static final Target ASSERT_TIPO_USUARIO= Target.the("validacion tipo usuario")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[2]//h4");
    public static final Target ASSERT_PERFIL= Target.the("validacion perfil")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[3]//h4");
    public static final Target ASSERT_ESTADO= Target.the("validacion estado")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[4]//h4");
}
