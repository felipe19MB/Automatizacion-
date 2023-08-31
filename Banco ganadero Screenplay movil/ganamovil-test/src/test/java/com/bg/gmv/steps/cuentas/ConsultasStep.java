package com.bg.gmv.steps.cuentas;

import com.bg.gmv.integrations.cuentas.ConsultasIntegration;
import com.bg.gmv.integrations.transferencia.TransferenciaIntegration;
import com.bg.gmv.pageobjects.cuentas.ConsultasPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class ConsultasStep {
    ConsultasPage consultasPage;
    ConsultasIntegration ConsultasIntegration = new ConsultasIntegration();

    @Step
    public void seleccionarCuenta(String nroCuenta){
        consultasPage.seleccionarCuenta(nroCuenta);
    }

    @Step
    public void actualizarSaldoCuenta(String nroCuenta, String saldo, String schemaDB){
        String cuenta = nroCuenta.split(" ")[1];
        String query="UPDATE GANADERO.SALDOS SET C1604 = "+saldo+" WHERE CUENTA = '"+cuenta+"'";
        updateQuery(query,schemaDB);
    }

    @Step
    public void updateQuery(String query,String schemaDB) {
        int result = 0;
        result = ConsultasIntegration.updateQuery(query,schemaDB);
        assertThat(result, greaterThan(0));

    }
    @Step
    public void verificarSaldoEstadoCuenta(List<String> datosCuentas){
        String nroCuenta = datosCuentas.get(0);
        String estado = datosCuentas.get(1);
        String saldo = datosCuentas.get(2);
        String tipoCuenta = datosCuentas.get(3);
        assertThat(consultasPage.getCuentaConsulta(),containsString(nroCuenta));
        assertThat(consultasPage.getEstado(),containsString(estado));
        assertThat(consultasPage.getSaldo(),containsString(saldo));
        assertThat(consultasPage.getTipoCuenta(),containsString(tipoCuenta));
    }
}
