@Preliquidacion
Feature: Preliquidacion de prestamo

  @TST-0001 @Prestamo @Preliquidacion @SmokeTest @SmokeTestPreliquidacion
  Scenario Outline: Calcular preliquidacion de prestamo

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Prestamos|Preliquidacion|
    And Calculo la preliquidacion
      |<nroPrestamo>|<fechaProximoPago>|
    Then Obtengo los datos de la siguiente cuota a pagar
      |<capital>|<interes>|<cargos>|<formulario>|<desgraven>|<total>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroPrestamo|fechaProximoPago|capital|interes|cargos|formulario|desgraven|total|
      |2 |CODIGO_PERSONA  |812   |1234|101145973|11/11/2022        |10.00  |10.00  |10.00 |10.00     |10.00    |50.00|
