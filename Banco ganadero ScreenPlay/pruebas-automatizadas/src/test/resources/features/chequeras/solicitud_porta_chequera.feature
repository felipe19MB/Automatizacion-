@solicitudPortaChequera
Feature: Como usuario
  deseo realizar la solicitud de la porta chequera de mi cuenta corriente
  para poder tenerla en fisico

  @smokeTest @chequeras @smokeTestSolicitudPortaChequera @auto-594 @TestCaseKey=TEST-T2141
  Scenario Outline: realizar la solicitud de la porta chequera para la cuenta corriente del cliente - Retiro en domicilio
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When diligencia los campos de solicitud de porta chequera
      | cuentaOrigen    | tipoPortaChequera        | tipoRetiro   | oficinaEntrega      | comentarios   |
      | <cuenta origen> | <tipo de porta chequera> | <tipo retiro> | <oficina entrega> | <comentarios> |
    Then Deberia poder ver el comprobante de la solicitud generado con exito
      | cuentaOrigen     |monedaCuenta   |costoSolicitud      |mensajeComprobante   |tipoPortaChequera|oficinaEntrega|
      | <cuenta origen>  |<moneda cuenta>|<costo de solicitud>|<mensaje comprobante>|<tipo de porta chequera>|<oficina entrega>|
    Examples:
      | usuario | contrasena | perfil           | modulo    | funcionalidad       | cuenta origen | moneda cuenta                      | tipo de porta chequera  | costo de solicitud | tipo retiro | oficina entrega | comentarios | mensaje comprobante |
      ##@externaldata@src/test/resources/data/chequeras/solicitud_porta_chequera_data.xlsx@HappyPath
   |521   |1234   |Persona Natural   |Chequeras   |Solicitud de Porta Chequera   |1310331157   |Bs   |PERSONAL - TALONARIO PEQUEÑO   |75.00   |Entrega en Domicilio   |EL ALTO (LP)    |PRUEBA AUTOMATIZADA   |NO VALIDO PARA CREDITO FISCAL. La chequera, portachequera y factura podran ser retiradas en oficina seleccionada luego de 3 dias habiles.|
