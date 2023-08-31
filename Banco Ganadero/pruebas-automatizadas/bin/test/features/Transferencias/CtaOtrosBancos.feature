@CtaOtrosBancos
Feature: Transferencias a cuentas de otros bancos ACH

  
  Scenario Outline: Como usuario logueado, quiero realizar una transferencia a otros bancos para saber si puedo realizar transferencias.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|A Otros Bancos|
    And Ingreso los datos para la transferencia
      |<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|
    And Finalizo la transferencia	<ganapin>
    Then Verifico los datos de la transferencia en el comprobante
      |<ctaOrigen>|<monto>|
      
    Examples: 
      |ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|
   |1   |CODIGO_PERSONA   |521   |1234   |1051364223   |123456789   |10   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234|
