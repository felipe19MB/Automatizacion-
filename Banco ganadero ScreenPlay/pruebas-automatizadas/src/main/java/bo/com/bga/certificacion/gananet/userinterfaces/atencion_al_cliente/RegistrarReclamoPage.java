package bo.com.bga.certificacion.gananet.userinterfaces.atencion_al_cliente;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrarReclamoPage {

    public static final Target LABEL_TELEFONO_CELULAR= Target.the("el campo telefono")
            .locatedBy("//label[contains(text(),'Teléf. Domicilio / Celular ')]/following-sibling::input");

    public static final Target LABEL_TELEFONO_TRABAJO= Target.the("el campo telefono trabajo")
            .locatedBy("//label[contains(text(),'Teléf. Trabajo ')]/following-sibling::input");

    public static final Target BARRIO_URBANIZACION= Target.the("el campo barrio")
            .locatedBy("//label[contains(text(),'Barrio / Urbanización ')]/following-sibling::input");

    public static final Target LABEL_CALLE= Target.the("el campo calle")
            .locatedBy("//label[contains(text(),'Calle ')]/following-sibling::input");

    public static final Target LABEL_NUMERO_CASA= Target.the("el campo numero de casa")
            .locatedBy("//label[contains(text(),'Nro de Casa ')]/following-sibling::input");

    public static final Target LABEL_CORREO_ELECTRONICO= Target.the("el campo correo electronico")
            .locatedBy("//label[contains(text(),'Correo Electrónico ')]/following-sibling::input");

    public static final Target SELECT_TIPO_RECLAMO= Target.the("el tipo de reclamo")
            .locatedBy("//label[contains(text(),'Tipo de Reclamo ')]/following-sibling::select");

    public static final Target SELECT_RECLAMO= Target.the("el reclamo")
            .locatedBy("(//label[contains(text(),'Reclamo ')]/following-sibling::select)[2]");

    public static final Target LABEL_MONTO= Target.the("el campo monto")
            .locatedBy("//label[contains(text(),'Monto comprometido ')]/following-sibling::input");

    public static final Target SELECT_MONEDA= Target.the("la moneda")
            .locatedBy("//label[contains(text(),'Moneda ')]/following-sibling::select");

    public static final Target LABEL_FECHA_HECHO= Target.the("el campo fecha del hecho")
            .locatedBy("//label[contains(text(),'Fecha del hecho ')]/following-sibling::div/input");

    public static final Target DESCRIPCION_RECLAMO= Target.the("el campo de la descripcion")
            .locatedBy("//label[contains(text(),'Descripción del Reclamo ')]/following-sibling::textarea");

    public static final Target BOTON_ENVIAR= Target.the("el boton enviar")
            .locatedBy("//button[@class='btn btn-success mr-2']");

    public static final Target MENSAJE_RECLAMO_CREADO= Target.the("el mensaje de reclamo creado")
            .locatedBy("//div[@id='swal2-content']");

    public static final Target SELECT_TIPO= Target.the("el tipo  de proceso")
            .locatedBy("//label[contains(text(),'Tipo ')]/following-sibling::select");

    public static final Target CHECK_POR_FECHA= Target.the("check por fecha")
            .locatedBy("(//label[contains(text(),'Por Fecha')])[1]");

    public static final Target LABEL_DESDE= Target.the("el campo desde")
            .locatedBy("//label[contains(text(),'Desde ')]/following-sibling::div/input");

    public static final Target LABEL_HASTA= Target.the("el campo hasta")
            .locatedBy("//label[contains(text(),'Hasta ')]/following-sibling::div/input");

    public static final Target BOTON_BUSCAR= Target.the("boton buscar")
            .locatedBy("//button[normalize-space()='Buscar']");

    public static final Target BOTON_OK= Target.the("el boton ok")
            .locatedBy("//button[normalize-space()='OK']");

    public static final Target SCROLL= Target.the("el scroll")
            .locatedBy("//label[normalize-space()='Cédula de Identidad o NIT']");

    public static final Target VALIDACIONES= Target.the("las verificaciones")
            .locatedBy("(//p[contains(text(),'{0}')])[1]");

    public static final Target VALIDACION_DESCRIPCION= Target.the("las verificaciones")
            .locatedBy("(//td[@class='bt-0 small text-left ng-star-inserted'])[4]");

    public static final Target VALIDACION_MONTO= Target.the("las verificaciON del monto")
            .locatedBy("(//td[@class='bt-0 small text-left ng-star-inserted'])[6]");

    public static final Target VALIDACION_MONEDA= Target.the("las verificacion de la moneda")
            .locatedBy("(//td[@class='bt-0 small text-left ng-star-inserted'])[7]");

    public static final Target VALIDACION_NUMERO_RECLAMO= Target.the("las verificacion del numero de reclamo")
            .locatedBy("(//td[@class='bt-0 small text-left ng-star-inserted']/p)[2]");

    public static final Target VALIDACION_ESTADO= Target.the("las verificacion deL estado")
            .locatedBy("(//td[@class='bt-0 small text-left ng-star-inserted']/p)[8]");
}
