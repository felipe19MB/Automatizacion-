package bo.com.bga.certificacion.gananet.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarComprobante implements Question<Boolean> {
    private String fecha;
    private String hora;
    private final String idComprobante;

    private static final long TIEMPO_MAXIMO_PERMITIDO_EN_MILISEGUNDOS = 4200000; // 70 minutos
    private static final long TIEMPO_MINIMO_PERMITIDO_EN_MILISEGUNDOS = 600000; // 10 minutos
    public ValidarComprobante(String fecha, String hora, String idComprobante) {
        this.fecha = fecha;
        this.hora = hora;
        this.idComprobante = idComprobante;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String regexFecha = "\\d{2}/\\d{2}/\\d{4}";
        Pattern patternFecha = Pattern.compile(regexFecha);
        Matcher matcherFecha = patternFecha.matcher(fecha);
        if (matcherFecha.find()) {
            fecha = matcherFecha.group();
        } else {
            fecha = "";
        }
        String regexHora = "\\d{2}:\\d{2}:\\d{2}";
        Pattern patternHora = Pattern.compile(regexHora);
        Matcher matcherHora = patternHora.matcher(hora);
        if (matcherHora.find()) {
            hora = matcherHora.group();
        } else {
            hora = null;
        }
        // Obtener la fecha y hora actual
        Date fechaActual = new Date();
        // Validar que la fecha sea igual a la actual
        if (!fecha.equals(new SimpleDateFormat("dd/MM/yyyy").format(fechaActual))) {
            throw new AssertionError("La fecha es diferente a la actual " +
                    "Fecha esperada: " + new SimpleDateFormat("dd/MM/yyyy").format(fechaActual) + "\n" +
                    "Fecha recibida: " + fecha);
        }
        // Validar que la hora se acerque a la actual con una diferencia máxima de 5 minutos
        try {
            // Obtener la hora actual de Bolivia
            Date horaActual = Calendar.getInstance(TimeZone.getTimeZone("America/La_Paz")).getTime();
            // Establecer el formato de hora
            String fechaActualComprobante = new SimpleDateFormat("yyyy-MM-dd").format(horaActual);
            String horaComprobanteConFechaActual = fechaActualComprobante + " " + hora;
            // Parsear la hora del comprobante y establecer los límites de tiempo
            SimpleDateFormat formatoHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Parsear la hora del comprobante y establecer los límites de tiemp
            Date horaComprobante = formatoHora.parse(horaComprobanteConFechaActual);
            Date horaActualConMargen = new Date(horaActual.getTime() + TIEMPO_MAXIMO_PERMITIDO_EN_MILISEGUNDOS);
            Date horaActualSinMargen = new Date(horaActual.getTime() - TIEMPO_MINIMO_PERMITIDO_EN_MILISEGUNDOS);
            if (horaComprobante.before(horaActualSinMargen) || horaComprobante.after(horaActualConMargen)) {
                throw new AssertionError("La hora del comprobante está fuera del margen " +
                        "Hora esperada: " + formatoHora.format(horaActualConMargen) + " o " + formatoHora.format(horaActualSinMargen) + "\n" +
                        "Hora recibida: " + formatoHora.format(horaComprobante));
            }
        } catch (Exception e) {
            return false;
        }
        if (idComprobante == null || idComprobante.isEmpty()) {
            throw new AssertionError("El comprobante está vacío");
        }
        return true;
    }

    public static ValidarComprobante conDatos(String fecha, String hora, String idComprobante) {
        return new ValidarComprobante(fecha, hora, idComprobante);
    }
}
