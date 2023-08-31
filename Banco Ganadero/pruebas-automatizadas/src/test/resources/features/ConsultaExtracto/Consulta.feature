@Consulta
Feature: Consulta de Saldos de las cuentas

  @TEST-T1777 @Consulta @ConsultaSaldo @SmokeTest
  Scenario Outline: Como usuario quiero realizar una consulta de saldo

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Consultas y Extractos|Consulta de Saldo|
    And Selecciono detalle de cuenta
      |<cuenta>|
    Then Verifico detalle de cuenta
      |<cuenta>|<tipoCuenta>|<producto>|<moneda>|
    Examples:
      |ID|tipoUsuario|usuario|password|cuenta|tipoCuenta|producto|moneda|
      |1 |CODIGO_PERSONA |9951821 |1234 |1310572856|Caja de Ahorros|CAJA DE AHORRO GANADOBLE|Bs|
      |2 |CODIGO_PERSONA |3059896 |1234 |1310126649|Caja de Ahorros|GANAMAS M/E| $us|