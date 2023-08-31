package bo.com.bga.certificacion.gananet.userinterfaces.administracion;

import net.serenitybdd.screenplay.targets.Target;

public class AlertaMovimientosPage {

    public static final Target BOTON_AGREGAR_NUEVO_CORREO = Target.the(" Agregar nuevo correo")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/alerta-movimientos-listado[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-box[1]/div[1]/div[1]/button[1]");

    public static final Target SELECT_NRO_DE_CUENTA = Target.the("Nro. de Cuenta ")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/alerta-movimientos-crear[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-box[1]/div[1]/div[2]/form[1]/control-combobox[1]/div[1]/select[1]");

    public static final Target TXT_CORREO = Target.the("Correo ")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/alerta-movimientos-crear[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-box[1]/div[1]/div[2]/form[1]/control-input-text[1]/div[1]/input[1]");

    public static final Target SELECT_TIPO_DE_MOVIMIENTO = Target.the("Tipo de Movimiento ")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/alerta-movimientos-crear[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-box[1]/div[1]/div[2]/form[1]/control-combobox[2]/div[1]/select[1]");

    public static final Target BOTON_GUARDAR = Target.the(" Guardar")
            .locatedBy("//button[contains(text(),'Guardar')]");

    public static final Target ASSERT_NUMERO_DE_CUENTA= Target.the("Validacion numero de cuenta")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div/preceding-sibling::div[1]/h4");

    public static final Target ASSERT_CORREO= Target.the("Validacion correo")
            .locatedBy("//h4[contains(text(),'{0}')]");

    public static final Target ASSERT_TIPO_DE_MOVIMIENTO= Target.the("Validacion tipo de movimiento")
            .locatedBy("//h4[contains(text(),'{0}')]/parent::div/following-sibling::div[1]/h4");

    public static final Target BOTON_ELIMINAR = Target.the(" Eliminar")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/alerta-movimientos-listado[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-box[1]/div[1]/div[2]/control-tabla-v2[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/a[2]/i[1]");

}
