package bo.com.bga.certificacion.ganamovil.exceptions;

public class Excepciones extends AssertionError{
    private static final String ERROR = "Error desde la ";
    public Excepciones(String message, Throwable cause){
        super(message, cause);
    }
    public static String error(String donde) {
        return ERROR + donde;
    }
}
