package com.bg.gnt.steps;

import java.util.List;

import com.bg.gnt.pageobjects.TarjetasCreditoPage;

import net.thucydides.core.annotations.Step;

public class TarjetasCreditoStep {

	TarjetasCreditoPage tarjetasCreditoPage;
	
	@Step
	public void ingresoDatosBloqueo(List<String> datosBloqueo) {
		String lStrNroTarjeta 	= datosBloqueo.get(0);
		String lStrNroPlastico 	= datosBloqueo.get(1);
		String lStrTipoBloqueo 	= datosBloqueo.get(2);
		
		tarjetasCreditoPage.seleccionarTarjeta(lStrNroTarjeta);
		tarjetasCreditoPage.seleccionarPlastico(lStrNroPlastico);
		tarjetasCreditoPage.seleccionarTipoBloq(lStrTipoBloqueo);
	}
	
	@Step
	public void finalizarBloqueo(int ganapin) {
		tarjetasCreditoPage.finalizarBloq();
		tarjetasCreditoPage.ingresarGanapin(ganapin);
		tarjetasCreditoPage.procesarBloq();
	}
	
	@Step
	public void verificarMensaje(List<String> pLstDatosMensaje) {
		tarjetasCreditoPage.verificarMensaje(pLstDatosMensaje);
	}
	
	
}
