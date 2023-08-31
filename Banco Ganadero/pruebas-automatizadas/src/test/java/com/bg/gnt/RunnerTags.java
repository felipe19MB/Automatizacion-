package com.bg.gnt;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.bg.gnt.util.BeforeSuite;
import com.bg.gnt.util.DataToFeature;





@CucumberOptions(
features = "src/test/resources/features/",
tags = "@smokeTest",
glue="com.bg.gnt.definitions",
snippets= CucumberOptions.SnippetType.CAMELCASE)
@RunWith(RunnerPersonalizado.class)
public class RunnerTags {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/acceso/iniciarSesion.feature"); //Ok
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/transferencias/afiliacion/afiTerceros.feature"); //Ok
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/transferencias/ctaTerceros.feature"); //Ok
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/transferencias/ctaPropias.feature"); //OK
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/transferencias/ctaOtrosBancos.feature"); //OK
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/tarjetasDebito/bloqueoTD.feature"); //Ok
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/tarjetasDebito/comprasInternetTD.feature"); //No
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/tarjetasDebito/limitesDeControl.feature"); //Ok
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/transferencias/ctaExterior.feature"); //Ok
			DataToFeature.overrideFeatureFiles("./src/test/resources/features/atencionCliente/sugerencias.feature"); //Ok
	}
}
