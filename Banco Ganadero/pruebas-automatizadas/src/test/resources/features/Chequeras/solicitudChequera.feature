@solicitudChequera
Feature: Solicitud de Chequera

  @TST-001 @chequeras @solicitudChequera @smokeTest @smokeTestSolicitudChequera
  Scenario Outline: Solicitar chequera

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Chequeras|Solicitud chequeras|
    And Solicito una chequera
      |<nroCuenta>|<formato>|<talonarios>|<cantidadTalonarios>|<conSello>|<portaChequera>|<retiraChequera>|<oficinaEntrega>|<comentario>|
    Then Obtengo un comprobante con los datos de la chequera
      |<nroCuenta>|<importe>|<recogera>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroCuenta|formato|talonarios|cantidadTalonarios|conSello|portaChequeras|retiraChequera|oficinaEntrega|comentario|importe|recogera|
      ##@externaldata@./src/test/resources/data/chequeras/datosSolicitudChequeras.xlsx@HappyPath
