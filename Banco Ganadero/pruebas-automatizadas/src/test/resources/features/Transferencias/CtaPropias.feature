@transferenciasCtasPropias
Feature: Transferencias a cuentas propias

  @test-T1383 @transferencias @smokeTest @smokeTestTransCtasPropias
  Scenario Outline: Transferir a cuentas propias con misma moneda

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Cuentas Propias|
    And Realizo una transferencia a cuentas propias
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|<usuario>|<ganapin>|
    Then Obtengo un comprobante de transferencia a cuentas propias
      |<ctaOrigenComprobante>|<monto>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|ctaOrigenComprobante|
      ##@externaldata@./src/test/resources/data/transferencia/datosTransPropias.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |521   |1234   |1051364223   |1310331157   |5   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |CA 1051364223|
