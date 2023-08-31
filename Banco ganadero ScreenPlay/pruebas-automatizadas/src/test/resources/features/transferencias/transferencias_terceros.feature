@transferenciasTerceros
Feature: Como usuario de GanaNet
  Quiero realizar la transferencia de fondos
  Para enviar y recibir dinero entre cuentas de terceros afiliadas

  @smokeTest @transferencias @auto-495 @smokeTestTransferenciasTerceros @TestCaseKey=TEST-T2091
  Scenario Outline: Transferir fondos de mi cuenta a cuentas de terceros como persona natural con misma moneda
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When realiza la transferencia "<funcionalidad>" desde su cuenta de origen "<cuenta origen>" por el importe de "<monto>" a su cuenta destino "<cuenta destino>" en "<tipo importe>"
      | tipoTransferencia | glosaDebito    | glosaCredito    | montoSufijoComprobante     |
      | <funcionalidad>   | <glosa debito> | <glosa credito> | <monto sufijo comprobante> |
    Then debería confirmar la transferencia de fondos "<funcionalidad>"
      | cuentaOrigen    | cuentaDestino    | glosaDebito    | glosaCredito    |
      | <cuenta origen> | <cuenta destino> | <glosa debito> | <glosa credito> |
    Examples:
      | usuario | contrasena | perfil          | modulo         | funcionalidad         | cuenta origen | cuenta destino | monto | tipo importe | glosa debito | glosa credito | monto sufijo comprobante |
      ##@externaldata@src/test/resources/data/transferencias/transferencias_terceros_data.xlsx@HappyPath
   |803105   |1234   |Persona Natural   |Transferencias   |A Cuentas de Terceros   |1310260007   |1310376827   |1.00   |BOLIVIANOS   |GLOSA DEBITO   |GLOSA CREDITO   |Bs|
