@consultaTd
Feature: Consulta

  @TST-0001 @td @consultaTd @smokeTest @smokeTestConsultaTd
  Scenario Outline: Consultar movimientos de tarjeta de debito

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Tarjetas de Débito|Consulta|
    And Consulto movimientos de tarjeta de debito
      |<nroTd>|<periodo>|<fechaInicio>|<fechaFin>|
    Then Obtengo los datos del movimiento de tarjeta de debito
      |<nro>|<transaccion>|<fecha>|<hora>|<estado>|<tipo>|<aceptante>|<cuenta>|<moneda>|<importe>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroTd|periodo|fechaInicio|fechaFin|nro|transaccion|fecha|hora|estado|tipo|aceptante|cuenta|moneda|importe|
      ##@externaldata@./src/test/resources/data/td/datosConsulta.xlsx@HappyPath