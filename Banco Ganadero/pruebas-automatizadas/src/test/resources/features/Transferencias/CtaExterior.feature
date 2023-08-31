@giroExterior
Feature: Transferencias a cuentas del exterior

  @test-T2065 @transferencias @SmokeTest @SmokeTestGiroExterior
  Scenario Outline: Como usuario existente y habilitado, quiero realizar una transferencia al exterior para saber si me permite.
  	Given Me autentique con un usuario habilitado 
    |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
    |Transferencias|Al exterior|
    And Acepto los terminos y condiciones
    And Ingreso los cargos
    |<ctaOrigen>|<monto>|<moneda>|<tipoCargo>|<nombreFactura>|<nit>|
    And Ingreso el ordenante
    |<mail>|<telefono>|
    And Selecciono el beneficiario
    |<beneficiario>|
    And Ingreso la descripcion
    |<codigoASFI>|<tipoDocumento>|<archivo>|<motivo>|<agencia>|
    And Finalizo la transferencia <ganapin>
    Then Obtengo un comprobante de giro al exterior
    |<ordenante>|<ctaOrigen>|<beneficiario>|<montoBs>|<montoUSD>|<montoCargo>|<comisionITF>|<capitalITF>|<cargoCorresponsal>|<total>|
    
    Examples:
    |ID|tipoUsuario|usuario|password|ctaOrigen|monto|montoBs|montoUSD|moneda|tipoCargo|montoCargo|cargoCorresponsal|mail|telefono|ordenante|beneficiario|codigoASFI|tipoDocumento|archivo|motivo|agencia|nombreFactura|nit|ganapin|comisionITF|capitalITF|total|
    ##@externaldata@./src/test/resources/data/transferencia/datosTransExterior.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |44970   |1234   |1051075307   |1.00   |6.97   |1.00   |DOLARES AMERICANOS   |Ordenante   |72.89   |20.00   |HHODINZ@BG.COM.BO   |755681823   |TABORA SAUCEDO RICARDO LEONEL   |OBS   |10   |3   |   |REMESA FAMILIAR PARA MIS HERMANOS EN ITALIA   |AGENCIA CENTRAL PARK   |TABORA SAUCEDO RICARDO LEONEL   |2920504   |1234   |0.28   |0.00   |94.17|


	 
