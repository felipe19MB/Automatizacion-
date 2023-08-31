package bo.com.bga.certificacion.api.questions.compartida;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarMensajeRespuesta implements Question<Boolean> {

    private String mensaje;
    private String responce;
    private String mensaje2;

    public ValidarMensajeRespuesta(String mensaje, String responce){
        this.mensaje = mensaje;
        this.responce = responce;
    }

    public ValidarMensajeRespuesta(String mensaje,String mensaj2, String responce){
        this.mensaje = mensaje;
        this.responce = responce;
        this.mensaje2 = mensaj2;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado;
        if (mensaje2 != null){
            resultado = responce.equals(mensaje)||responce.equals(mensaje2);
            if (!resultado) {
                throw new AssertionError("El mensaje recibido no coincide con el esperado.\n" +
                        "Mensaje esperado: " + mensaje + " o " + mensaje2 + "\n" +
                        "Mensaje recibido: " + responce);
            }
        }else {
            resultado =  responce.contains(mensaje);
            if (!resultado) {
                throw new AssertionError("El mensaje recibido no coincide con el esperado.\n" +
                        "Mensaje esperado: " + mensaje + "\n" +
                        "Mensaje recibido: " + responce);
            }

        }
        return resultado;
    }

    public static ValidarMensajeRespuesta expected(String mensaje, String responce) {
        return new ValidarMensajeRespuesta(mensaje, responce);
    }

    public static ValidarMensajeRespuesta expecteddos(String mensaje,String mensaje2, String responce) {
        return new ValidarMensajeRespuesta(mensaje,mensaje2, responce);
    }
}
