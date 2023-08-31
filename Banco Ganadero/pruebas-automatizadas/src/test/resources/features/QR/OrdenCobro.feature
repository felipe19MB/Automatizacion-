@OrdenCobroSimple
Feature: Generar Orden de Cobro QR

  @TEST-T1388 @QR @OrdenCobro @SmokeTest @SmokeTestOrdenCobro
  Scenario Outline: Como usuario quiero generar una orden de cobro QR para poder contar con el QR.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Orden de Cobro $imple|Orden de cobro|
    And Genero orden de cobro
      |<ctaOrigen>|<tipoCobro>|<fechaVencimiento>|<moneda>|<monto>|<descripcion>|<ganapin>|
    Then Se genera un QR con los datos del cobro.
      |<monto>|

    Examples:
      |ID|tipoUsuario|usuario|password|ctaOrigen|tipoCobro|fechaVencimiento|moneda|monto|descripcion|ganapin|
      ##@externaldata@./src/test/resources/data/qr/DatosOrdenCobro.xlsx@Naturales@1
      |1   |CODIGO_PERSONA   |39073   |1234   |1051229049   |Más de un uso   |1 semana   |Bolivianos   |50.00   |PRUEBA ORDEN DE COBRO   |1234|
