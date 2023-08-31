package bo.com.bga.certificacion.ganamovil.models;

public class MenuModel {
    private String modulo;
    private String submodulo = null;

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getSubmodulo() {
        return submodulo;
    }

    public void setSubmodulo(String submodulo) {
        this.submodulo = submodulo;
    }
}
