@planPagoPrestamo
Feature: Plan de Pago

  @TST-0001 @prestamos @planPagoPrestamo @smokeTest @smokeTestPlanPago
  Scenario Outline: Consultar plan de pago de prestamo

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Préstamos|Plan de Pagos|
    And Consulto una cuota del plan de pago de un préstamo
      |<nroPrestamo>|<tipoPrestamo>|<capitalDesembolsado>|
    Then Obtengo los datos de una cuota del plan de pago de prestamo
      |<nroCuota>|<fecha>|<capital>|<interes>|<cargos>|<totalCuota>|<saldo>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroPrestamo|tipoPrestamo|capitalDesembolsado|nroCuota|fecha|capital|interes|cargos|totalCuota|saldo|
      ##@externaldata@./src/test/resources/data/prestamo/datosPlanPago.xlsx@HappyPath