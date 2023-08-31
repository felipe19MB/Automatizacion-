package bo.com.bga.certificacion.gananet.interactions.shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaActual {

    public static String obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaActual.format(formato);
    }
}