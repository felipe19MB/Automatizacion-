package com.bg.gmv.definitions.prestamos;

import com.bg.gmv.steps.prestamos.PagosRecientesPrestamoStep;
import com.bg.gmv.steps.transferencia.TransferenciaStep;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class PagosRecientesPrestamosDefinition {
    @Steps
    PagosRecientesPrestamoStep prestamoStep;

    @When("^Genero listado de pagos reciente de prestamo$")
    public void genero_listado_de_pago_reciente_de_prestamo(List<String> datosPrestamo) {
        prestamoStep.seleccionarCuentaOrigen(datosPrestamo);
        prestamoStep.seleccionarPagosRecientesPrestamo();

    }
    @When("^Verifico los datos del prestamo$")
    public void verifico_los_datos_del_prestamo(List<String> datosPrestamo) {
        prestamoStep.verificarPagosRecientesPrestamo(datosPrestamo);
    }




}
