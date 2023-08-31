@alertaMovimientos
Feature: Alerta de Movimientos en CA/CC

  @TST-001 @administracion @alertaMovimientos @smokeTest @smokeTestAlertaMovimientos
  Scenario Outline: Agregar nuevo correo de alerta de movimientos

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Administración|Alerta de Movimientos en CA/CC|
    And Agrego nuevo correo de alerta de movimientos
      |<nroCuenta>|<correo>|<tipoMovimiento>|
    Then Obtengo los datos del correo agregado
      |<nroCuenta>|<correo>|<tipoMovimiento>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroCuenta|correo|tipoMovimiento|
      ##@externaldata@./src/test/resources/data/administracion/datosAlertaMovimientos.xlsx@HappyPath
