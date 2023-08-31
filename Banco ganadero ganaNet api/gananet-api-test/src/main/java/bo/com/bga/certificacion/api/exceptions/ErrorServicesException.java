package bo.com.bga.certificacion.api.exceptions;

public class ErrorServicesException extends RuntimeException{
    public ErrorServicesException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
