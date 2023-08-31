package bo.com.bga.certificacion.gananet.interactions.shared;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    public static int extraerNumero(String texto) {
        Pattern patron = Pattern.compile("\\d+");
        Matcher matcher = patron.matcher(texto);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return -1;
    }
    public static String removeNumericValues(String input) {
        String pattern = "\\d+";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.replaceAll("");
    }
    public static String adicionarDiasAFechaActual(int dias){
        String fechaFormateada = "";
        System.out.println(dias);
        try {
            Calendar calendario = Calendar.getInstance();
            // Sumar la cantidad de días especificada
            calendario.add(Calendar.DAY_OF_YEAR, dias);
            // Obtener la fecha resultante y formatearla en el formato deseado
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaResultante = calendario.getTime();
            fechaFormateada = formato.format(fechaResultante);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return fechaFormateada;
    }
    public static String sumarDosStrings(String num1, String num2) {
        double costoTotal = Double.parseDouble(num1) + Double.parseDouble(num2);
        return(String.format(Locale.US,"%.2f", costoTotal));
    }

    public static String quitarUltimoEspacio(String frase) {
        int lastIndex = frase.lastIndexOf(" ");
        if (lastIndex != -1) {
            frase = frase.substring(0, lastIndex) + frase.substring(lastIndex + 1);
        }
        return frase;
    }

    public static String extraerFecha(String fechaHora) {
        // Definir el patrón regex para la fecha
        String patron = "(\\d{4})-(\\d{2})-(\\d{2})";

        // Compilar el patrón regex
        Pattern pattern = Pattern.compile(patron);

        // Buscar la coincidencia en la cadena de fecha y hora
        Matcher matcher = pattern.matcher(fechaHora);

        // Verificar si se encontró una coincidencia
        if (matcher.find()) {
            // Obtener los grupos de la coincidencia
            String año = matcher.group(1);
            String mes = matcher.group(2);
            String día = matcher.group(3);

            // Construir la fecha en el formato deseado
            String fechaFormateada = día + "/" + mes + "/" + año;

            // Retornar la fecha formateada
            return fechaFormateada;
        }

        // Si no se encuentra una coincidencia, retornar una cadena vacía o null según convenga
        return "";
    }
}
