package bo.com.bga.certificacion.ganamovil.utils.utils.enums;

public enum ConfiguracionInteracciones {
    CANTIDAD_INTERACCIONES(7);

    String opcionString;
    int opcionInt;

    private ConfiguracionInteracciones(String opcionString) {
        this.opcionString = opcionString;
    }

    private ConfiguracionInteracciones(int opcionInt) {
        this.opcionInt = opcionInt;
    }

    public String getOpcionString() {
        return this.opcionString;
    }

    public int getOpcionInt() {
        return this.opcionInt;
    }
}
