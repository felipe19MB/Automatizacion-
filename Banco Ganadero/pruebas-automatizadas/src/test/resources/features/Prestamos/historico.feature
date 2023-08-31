@historicoPrestamo
Feature: Historico

  @TST-0001 @prestamos @historicoPrestamo @smokeTest @SmokeTestHistoricoPrestamo
  Scenario Outline: Consultar histórico de desembolso

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Préstamos|Histórico|
    And Consulto el histórico de desembolso del prestamo
      |<nroPrestamo>|<tipoPrestamo>|<capitalDesembolsado>|
    Then Obtengo los datos del desembolso del prestamo
      |<nroCuota>|<transaccion>|<fecha>|<capital>|<interes>|<cargos>|<totalCuota>|<saldoCapital>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroPrestamo|tipoPrestamo|capitalDesembolsado|nroCuota|transaccion|fecha|capital|interes|cargos|totalCuota|saldoCapital|
      ##@externaldata@./src/test/resources/data/prestamo/datosHistorico.xlsx@HappyPath