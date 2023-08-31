@generarComprobanteServiciosBasicos
Feature: Como usuario quiero generar un comprobante por el pago de un servicio para que pueda tener control de mis pagos

  @smokeTest @comprobantes @smokeTestGenerarComprobanteServiciosBasicos @auto-577 @TestCaseKey=TEST-T2086
  Scenario Outline: Generar comprobante de servicios básicos
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Consulta un comprobante de servicio basico
      | fechaDesde      | fechaHasta   |
      | <fechaDesde>    | <fechaHasta> |
    Then Deberia ver un comprobante con los datos del servicio pagado
      | nroTransaccion   | tipo   | nombreServicio   | nroCuenta      | importe   | moneda   | hora   | nombreCliente   | nombreCompletoCliente   | descripcion   | nota   |
      | <nroTransaccion> | <tipo> | <nombreServicio> | <nroCuenta>    | <importe> | <moneda> | <hora> | <nombreCliente> | <nombreCompletoCliente> | <descripcion> | <nota> |

    Examples:
      | usuario | contrasena | perfil | modulo | funcionalidad |fechaDesde| fechaHasta | nroTransaccion | tipo | nombreServicio | nroCuenta | importe | moneda |hora|nombreCliente|nombreCompletoCliente|descripcion|nota|
      ##@externaldata@src/test/resources/data/comprobantes/generar_comprobante_servicios_basicos_data.xlsx@happy_path
   |803105   |1234   |Persona Natural   |Comprobantes   |Servicios Básicos   |06/03/2023   |06/03/2023   |3980578   |PAGO DE SERVICIOS   |VIVA   |1310260007   |50.00   |BOLIVIANOS   |14:57:55   |PERSONA NATURAL   |75346419-ALFREDO DERLIN TORRICO QUINTELA   |Pago Compra credito [De 5.00 a 1500.00 Bs.]   |*Comprobante No válido para Crédito Fiscal.|
