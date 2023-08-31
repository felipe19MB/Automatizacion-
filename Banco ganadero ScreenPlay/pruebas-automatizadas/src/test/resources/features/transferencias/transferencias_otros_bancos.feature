@transferenciasOtrosBancos
Feature: Como usuario de GanaNet
  Quiero realizar la transferencia de fondos
  Para enviar y recibir dinero entre cuentas afiliadas de otros bancos

  @smokeTest @transferencias @auto-492 @smokeTestTransferenciasOtrosBancos @TestCaseKey=TEST-T2090
  Scenario Outline: Transferir fondos de mi cuenta a cuenta de otros bancos como persona natural con misma moneda
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
      | usuario | contrasena | perfil          | modulo         | funcionalidad  | cuenta origen | cuenta destino | monto | tipo importe | glosa debito | glosa credito | monto sufijo comprobante |
      ##@externaldata@src/test/resources/data/transferencias/transferencias_otros_bancos_data.xlsx@HappyPath
   |803105   |1234   |Persona Natural   |Transferencias   |A Otros Bancos   |1310260007   |407197153   |4.00   |BOLIVIANOS   |GLOSA DEBITO AUTOMATION 4   |GLOSA CREDITO AUTOMATIZACION 4   |Bs|
