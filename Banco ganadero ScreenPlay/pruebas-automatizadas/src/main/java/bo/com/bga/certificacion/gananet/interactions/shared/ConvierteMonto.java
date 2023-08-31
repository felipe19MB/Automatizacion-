package bo.com.bga.certificacion.gananet.interactions.shared;


public class ConvierteMonto {

    public static double enDecimalOEntero(String monto) {
        if (monto.matches("\\d+(\\.\\d{1,2})?")) {
            // Si la cadena es un número de punto flotante válido
            double valor = Double.parseDouble(monto);
            if (valor == (int) valor) {
                return (int) valor;
            } else {
                return valor;
            }
        } else {
            // Si la cadena no es un número de punto flotante válido
            return Integer.parseInt(monto);
        }
    }
}
