@CtaTerceros
Feature: Transferencias a cuentas de terceros

  @SmokeTest	@TransTerceros
  Scenario Outline: Como usuario logueado, quiero realizar una transferencia a terceros para saber si puedo realizar transferencias.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Cuentas de Terceros|
    And Ingreso los datos para la transferencia
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|
    And Finalizo la transferencia	<ganapin>
    Then Verifico los datos de la transferencia en el comprobante
      |<ctaOrigen>|<monto>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|
      ##@externaldata@./src/test/resources/data/transferencia/DatosTransTerceros.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |39073   |1234   |1051229049   |1310296212   |5   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234|


	@TransTercerosUIF
  Scenario Outline: Como usuario logeado, quiero realizar una transferencia a terceros con un monto que supere los 10000$ para saber si solicita UIF.

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
      ##@externaldata@./src/test/resources/data/transferencia/DatosTransTerceros.xlsx@NaturalesUIF
   |1   |CODIGO_PERSONA   |114182   |1234   |1051975280   |1051368209   |68600   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |ORIGEN HONESTO UIF   |DESTINO HONESTO UIF   |MOTIVO HONESTO UIF|
   |2   |CODIGO_PERSONA   |126779   |1234   |1051368209   |1051975280   |68600   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |ORIGEN HONESTO UIF   |DESTINO HONESTO UIF   |MOTIVO HONESTO UIF|




  @Caso003
  Scenario Outline: Como operador logeado, quiero iniciar una transferencia a terceros para saber si queda pendiente de supervision.

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
      ##@externaldata@./src/test/resources/data/transferencia/DatosTransTerceros.xlsx@Operadores
   |1   |CODIGO_PERSONA   |8860   |1234   |1310272540   |1051364223   |70   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234   |TELECEL   |solicitud|
