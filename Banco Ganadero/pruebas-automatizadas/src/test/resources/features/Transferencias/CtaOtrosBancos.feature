@transferenciasOtrosBancos
Feature: Transferencias a cuentas de otros bancos

  @test-T1382 @transferencias @smokeTest @smokeTestTransferenciasOtrosBancos
  Scenario Outline: Transferir a cuentas de otros bancos misma moneda

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Otros Bancos|
    And Realizo una transferencia a cuentas de otros bancos
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|<usuario>|<ganapin>|
    Then Obtengo un comprobante de transferencia a otros bancos
      |<ctaOrigen>|<monto>|
      
    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|
      ##@externaldata@./src/test/resources/data/transferencia/datosTransOtrosBancos.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |10535519   |1234   |1310322272   |1061679690   |10   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234|
