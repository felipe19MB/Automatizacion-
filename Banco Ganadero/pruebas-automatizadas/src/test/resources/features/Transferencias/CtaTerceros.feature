@transTerceros
Feature: Transferencias a cuentas de terceros

  @test-T1384 @transferencias @smokeTest @smokeTestTransTerceros
  Scenario Outline: transferir a cuenta de tercero con misma moneda

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Cuentas de Terceros|
    And Ingreso los datos para la transferencia
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|<usuario>|
    And Finalizo la transferencia	<ganapin>
    Then Verifico los datos de la transferencia en el comprobante
      |<ctaOrigen>|<monto>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|
      ##@externaldata@./src/test/resources/data/transferencia/datosTransTerceros.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |39073   |1234   |1051229049   |1051262259   |5   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234|


  Scenario Outline: transferir a cuenta de tercero con glosa UIF

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Cuentas de Terceros|
    And Ingreso los datos para la transferencia
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|
    And Ingreso datos UIF
      |<origenUIF>|<destinoUIF>|<motivoUIF>|
    And Finalizo la transferencia	<ganapin>
    Then Verifico los datos de la transferencia en el comprobante
      |<ctaOrigen>|<monto>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|origenUIF|destinoUIF|motivoUIF|
      ##@externaldata@./src/test/resources/data/transferencia/datosTransTerceros.xlsx@NaturalesUIF
   |1   |CODIGO_PERSONA   |114182   |1234   |1051975280   |1051368209   |68600   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |ORIGEN HONESTO UIF   |DESTINO HONESTO UIF   |MOTIVO HONESTO UIF|
   |2   |CODIGO_PERSONA   |126779   |1234   |1051368209   |1051975280   |68600   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |ORIGEN HONESTO UIF   |DESTINO HONESTO UIF   |MOTIVO HONESTO UIF|





  Scenario Outline: transferir a cuenta de tercero con usuario operador

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    And Ingrese con el perfil
      |<nombrePerfil>|
    When Selecciono el menu
      |Transferencias|A Cuentas de Terceros|
    And Ingreso los datos para la transferencia
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|
    And Finalizo la transferencia	<ganapin>
    Then Verifico el mensaje de solicitud de supervision
      |<mensaje>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|nombrePerfil|mensaje|
      ##@externaldata@./src/test/resources/data/transferencia/datosTransTerceros.xlsx@Operadores
   |1   |CODIGO_PERSONA   |8860   |1234   |1310272540   |1051364223   |70   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |TELECEL   |solicitud|
