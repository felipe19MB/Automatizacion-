@CtaTerceros
Feature: Transferencias a cuentas del exterior

  @TEXT01	
  Scenario Outline: Como usuario existente y habilitado, quiero realizar una transferencia al exterior para saber si me permite.
  	Given Me autentique con un usuario habilitado 
    |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
    |Transferencias|Al exterior|
    And Acepto los terminos y condiciones
    And Ingreso los cargos
    |<ctaOrigen>|<monto>|<moneda>|<tipoCargo>|<nombreFactura>|<nit>|
    And Ingreso el ordenante
    |<mail1>|<mail2>|<telefono>|
    And Selecciono el beneficiario
    |<beneficiario>|
    And Ingreso la descripcion
    |<codigoASFI>|<tipoDocumento>|<archivo>|<motivo>|<agencia>|
    And Verifico el resumen
    |<nombreFactura>|<nit>|<ctaOrigen>|<monto>|
    And Ingreso segundo factor
    |<ganapin>|
    Then Se genera un comprobante de transferencia
    |<ordenante>|<ctaOrigen>|<beneficiario>|<montoBs>|<montoUSD>|<montoCargo>|<comisionITF>|<capitalITF>|<equivalente>|
    
    Examples:
    |ID|tipoUsuario|usuario|password|ctaOrigen|monto|montoBs|montoUSD|moneda|tipoCargo|montoCargo|mail1|mail2|telefono|ordenante|beneficiario|codigoASFI|tipoDocumento|archivo|motivo|agencia|nombreFactura|nit|ganapin|comisionITF|capitalITF|
    ##@externaldata@./src/test/resources/data/transferencia/DatosTransExterior.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |110177   |1234   |1052767989   |1   |6.97   |1   |DOLARES AMERICANOS   |Cargo Ordenante   |72.89   |HHODINZ@BG.COM.BO   |HHODINZ@BG.COM.BO   |755681823   |TABORA SAUCEDO RICARDO LEONEL   |LUISA   |10   |3   |   |REMESA FAMILIAR PARA MIS HERMANOS EN ITALIA   |AGENCIA CENTRAL PARK   |TABORA SAUCEDO RICARDO LEONEL   |2920504   |1234   |0.37   |0|


	 
