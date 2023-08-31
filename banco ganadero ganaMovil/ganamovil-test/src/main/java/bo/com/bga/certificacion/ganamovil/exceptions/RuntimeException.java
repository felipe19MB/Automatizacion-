package bo.com.bga.certificacion.ganamovil.exceptions;

public class RuntimeException extends java.lang.RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String ERROR_CREDENCIALES = "Error ingresando las credenciales de acceso";
    public RuntimeException(String mensaje, Throwable razon) {
        super(mensaje, razon);
    }
    public static String errorCredenciales() {
        return ERROR_CREDENCIALES;
    }


}
