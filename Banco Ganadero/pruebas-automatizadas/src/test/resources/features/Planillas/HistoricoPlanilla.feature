@HistoricoPlanilla
Feature: Historico pago de planillas

  @TST-0001 @Planillas @HistoricoPlanilla @SmokeTest @SmokeTestHistoricoPlanilla
  Scenario Outline: Filtrar por codigo unico

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Pago de Planillas|Historico pago de planillas|
    And Busco la planilla
      |<convenio>|<fechaInicio>|<fechaFin>|<nroPlanilla>|
    And Filtro por codigo unico
      |<codigoUnico>|
    Then Ontengo el registro del pago realizado
      |<codigo>|<nombre>|<formaPago>|<fechaPago>|<nroCuenta>|<monto>|<estado>|

    Examples:
      |ID|tipoUsuario|usuario|password|convenio|fechaInicio|fechaFin|nroPlanilla|codigoUnico|codigo|nombre|formaPago|fechaPago|nroCuenta|monto|estado|
      |2 |CODIGO_PERSONA  |812   |1234|701 - 1042094528 - GANASUELDOS - HERRACRUZ S.A.|03/11/2022|03/11/2022|3137268|001|12345|PAUL AYALA PEREZ|TRANSFERENCIA BG|03/11/2022|1052502511|4,000.00|PROCESADO|
