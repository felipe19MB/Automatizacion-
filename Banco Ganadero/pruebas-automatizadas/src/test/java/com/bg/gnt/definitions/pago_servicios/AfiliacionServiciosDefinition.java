package com.bg.gnt.definitions.pago_servicios;

import com.bg.gnt.steps.pago_servicios.AfiliacionStep;
import com.bg.gnt.steps.tarjetas_debito.ComprasPorInternetStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class AfiliacionServiciosDefinition {
    @Steps
    AfiliacionStep afiliacionStep;
    @And("^Selecciono un servicio a afiliar$")
    public void selecciono_un_servicio_a_afiliar(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        String opcionTipo = lUserTable.get(0);
        String opcionSubTipo = lUserTable.get(1);
        String opcionCiudad = lUserTable.get(2);
        String opcionServicio = lUserTable.get(3);
        afiliacionStep.afiliarServicio(opcionTipo, opcionSubTipo, opcionCiudad, opcionServicio);
    }
    @And("^Lleno los datos de busqueda$")
    public void lleno_los_datos_de_busqueda(DataTable userTable) {
        List<String> lUserTable = userTable.row(0);
        String servicio = lUserTable.get(0);
        String criterioBusqueda = lUserTable.get(1);
        String criterioBusqueda1 = lUserTable.get(2);
        String criterioBusqueda2 = lUserTable.get(3);
        String referencia = lUserTable.get(4);
        afiliacionStep.llenarDatos(servicio, criterioBusqueda, criterioBusqueda1, criterioBusqueda2, referencia);
    }
    @When("^Finalizo la afiliacion ingresando GanaPin (\\d+)$$")
    public void finalizo_el_bloqueo_TD(String pIntGanapin) {
        afiliacionStep.ingresarGanapin(pIntGanapin);
    }

    @Then("^Verifico si la afiliacion fue exitoso$")
    public void verificarMensaje(DataTable userTable) {
        String schemaDB = "GANADERO";
        List<String> lUserTable = userTable.row(0);
        String nroPersona = lUserTable.get(1);
        afiliacionStep.verificarMensaje(lUserTable);
        afiliacionStep.eliminarAfiliacion(nroPersona,schemaDB);
    }

}
