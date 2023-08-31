package bo.com.bga.certificacion.ganamovil.errors;

public class Errors extends AssertionError {
    private static final long serialVersionUID = 1L;
    private static final String SIN_VERIFICAR_TRANSACCION = "No fue posible verificar la transacción";
    private static final String SIN_VERIFICAR_LOS_DATOS_EN_LA_BASE_DE_DATOS = "No fue posible verificar la base de datos";

    private static final String SIN_VERIFICAR_INGRESO = "No fue posible verificar el ingreso exitoso a la app";
    private static final String SIN_VERIFICAR_SALDO= "No fue posible verificar el saldo de la cuenta";
    private static final String SIN_VERIFICAR_HABILITACION = "No fue posible realizar la habilitación de dispositivo móvil";
    private static final String SIN_VERIFICAR_MODAL_DE_ERROR = "No fue posible validar el modal de error";
    public Errors(String mensaje, Throwable razon) {
        super(mensaje, razon);
    }

    public static String sinVerificarIngreso() {
        return SIN_VERIFICAR_INGRESO;
    }
    public static String sinVerificarHabilitacion() {
        return SIN_VERIFICAR_HABILITACION;
    }
    public static String sinVerificarError(){
        return SIN_VERIFICAR_MODAL_DE_ERROR;
    }

    public static String sinVerificarSaldo(){
        return SIN_VERIFICAR_SALDO;
    }

    public static String sinVerificarTransaccion() {
        return SIN_VERIFICAR_TRANSACCION;
    }

    public static String sinVerificarBaseDatos() {
        return SIN_VERIFICAR_LOS_DATOS_EN_LA_BASE_DE_DATOS;
    }


}
