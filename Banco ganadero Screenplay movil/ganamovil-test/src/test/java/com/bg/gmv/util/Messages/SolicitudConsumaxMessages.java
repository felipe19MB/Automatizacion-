package com.bg.gmv.util.Messages;

/**
 * Esta clase es para el manejo de mensajes de solicitudes.
 */
public class SolicitudConsumaxMessages {
    private static final String SOLICITUD_DESESTIMADA_MESSAGE = "Estimado Cliente, se desestimo la solicitud.";
    private static final String SOLICITUD_EXITOSA_MESSAGE = "Estimado cliente su solicitud ha sido enviada de manera exitosa, en los próximos días recibirá una respuesta por parte del Banco Ganadero S.A. Su número de solicitud es el";
    /**
     * Retorna el mensaje  de solicitud desestimada.
     * @return el mensaje.
     */
    public static String getSolicitudDesestimadaMessage() {
        return SOLICITUD_DESESTIMADA_MESSAGE;
    }
    /**
     * Retorna el mensaje  de solicitud ingresada exitosamente.
     * @return el mensaje.
     */
    public static String getSolicitudExitosa() {
        return SOLICITUD_EXITOSA_MESSAGE;
    }
}
