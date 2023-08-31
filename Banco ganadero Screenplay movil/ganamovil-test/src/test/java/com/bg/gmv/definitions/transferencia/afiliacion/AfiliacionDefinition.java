package com.bg.gmv.definitions.transferencia.afiliacion;

import com.bg.gmv.steps.transferencia.afiliacion.AfiliacionStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class AfiliacionDefinition {
    @Steps
    AfiliacionStep afiliacionStep;

    @And("^Selecciono adiciona cuentas$")
    public void selecciono_adiciona_cuentas() {
        afiliacionStep.SeleccionarAdicionaCuentas();
    }
    @And("^Ingreso el Numero de Cuenta Nombre y Referencia$")
    public void ingreso_el_numero_de_cuenta_nombre_y_referencia(List<String> datosAfiliacion) {
        afiliacionStep.ingresarDatosAfiliacion(datosAfiliacion);
    }
    @And("^Finalizo el registro$")
    public void finalizo_el_registro() {
        afiliacionStep.finalizarRegistro();
    }

    @Then("^Obtengo una alerta de registro exitoso$")
    public void obtengo_una_alerta_de_registro_exitoso(List<String> datosAfiliacion) {
        afiliacionStep.verificarMensaje(datosAfiliacion);
    }
    @Then("^Elimino el afiliado$")
    public void elimino_el_afiliado(List<String> datosAfiliacion){
        afiliacionStep.eliminarCuentaAfiliada(datosAfiliacion);
    }
    @Then("^Reseteo los datos$")
    public void reseteo_los_datos(List<String> datosAfiliacion) {
        String schemaDB = "GANADERO";
        //Query para dar de baja el registro afiliado
        String	query	=	"DELETE FROM GANANET.GNT_CUENTASDETERCEROS WHERE EBCTECTAD='1310322272' AND EBCTECPER=8860 AND EBCTEREFE='EMPLEADO'";
        afiliacionStep.deleteQuery(query,schemaDB);
    }
}
