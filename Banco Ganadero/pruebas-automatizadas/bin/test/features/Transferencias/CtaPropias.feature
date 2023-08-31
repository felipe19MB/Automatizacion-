@CtaPropias
Feature: Transferencias a cuentas propias

  
  Scenario Outline: Como usuario logueado, quiero realizar una transferencia a cuentas propias para saber si puedo realizar transferencias.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Cuentas Propias|
    And Ingreso los datos para la transferencia
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|
    And Finalizo la transferencia	<ganapin>
    Then Verifico los datos de la transferencia en el comprobante
      |<ctaOrigen>|<monto>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|
   |1   |CODIGO_PERSONA   |521   |1234   |1051364223|1310321745|10   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234|
