package com.bg.gnt.steps.transferencias.afiliacion;

import java.util.List;

import com.bg.gnt.pageobjects.transferencias.afiliacion.AfiOtrosBancosPage;

import net.thucydides.core.annotations.Step;

public class AfiOtrosBancosStep {

	AfiOtrosBancosPage afiOtrosBancosPage;
	
	@Step
	public void eliminarCtaAfiliada(List<String> pListDatosCuenta) {
		afiOtrosBancosPage.eliminarCuenta(pListDatosCuenta);
	}
	
	@Step
	public void regDatosBeneficario(List<String> pListDatosBenef) {
		
		String lStrAlias = pListDatosBenef.get(0);
		String lStrBanco = pListDatosBenef.get(1);
		String lStrSucursal = pListDatosBenef.get(2);
		String lStrTitular = pListDatosBenef.get(3);
		String lStrNit = pListDatosBenef.get(4);
		String lStrTipoCta = pListDatosBenef.get(5);
		String lStrCta = pListDatosBenef.get(6);
		String lStrEmail = pListDatosBenef.get(7);
		String lStrFavorito = pListDatosBenef.get(8);
		
		
		afiOtrosBancosPage.alias(lStrAlias);
		afiOtrosBancosPage.banco(lStrBanco);
		afiOtrosBancosPage.sucursal(lStrSucursal);
		afiOtrosBancosPage.titular(lStrTitular);
		afiOtrosBancosPage.nit(lStrNit);
		afiOtrosBancosPage.tipoCuenta(lStrTipoCta);
		afiOtrosBancosPage.cuenta(lStrCta);
		afiOtrosBancosPage.email(lStrEmail);
		afiOtrosBancosPage.favorito(lStrFavorito);
		afiOtrosBancosPage.guardar();
		
	}
}
