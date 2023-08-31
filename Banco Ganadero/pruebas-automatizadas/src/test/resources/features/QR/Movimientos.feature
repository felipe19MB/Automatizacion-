@movimientosQR
Feature: Movimientos QR

  @TST-0001 @qr @movimientosQR @smokeTest @SmokeTestmovimientosQR
  Scenario Outline: Consultar orden de cobro

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Orden de Cobro $imple|Movimientos|
    And Consulto orden de cobro
      |<fechaInicio>|<fechaFin>|<tipoMovimiento>|
    Then Obtengo los datos de la orden de cobro
      |<fechaRegistro>|<identificardorQR>|<cuenta>|<tipoCobro>|<vencimiento>|<importe>|<moneda>|<descripcion>|

    Examples:
      |ID|tipoUsuario|usuario|password|fechaInicio|fechaFin|tipoMovimiento|fechaRegistro|identificardorQR|cuenta|tipoCobro|vencimiento|importe|moneda|descripcion|
      ##@externaldata@./src/test/resources/data/qr/datosMovimientosQr.xlsx@HappyPath
