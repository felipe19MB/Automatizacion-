@autorizacionSolicitudChequera
Feature: Como usuario deseo realizar la supervision de las diferentes solicitudes

  @smokeTest @autorizaciones @smokeTestAutorizacionSolicitudChequera @test-576 @TestCaseKey=TEST-T2119
  Scenario Outline: supervisar la solicitud de chequera
    Given empresa genera una solicitud de chequera pendiente de autorización
      | usuario   | contrasena   | perfil   | modulo   | funcionalidad   | cuentaOrigen   | formato   | talonario   | cantidadTalonarios   | portaChequera   | sello   | retiroChequera   | oficinaEntrega   |
      | <usuario> | <contrasena> | <perfil> | <modulo> | <funcionalidad> | <cuentaOrigen> | <formato> | <talonario> | <cantidadTalonarios> | <portaChequera> | <sello> | <retiroChequera> | <oficinaEntrega> |
    And El cliente ingresa a la pagina de gananet
      | usuario           | contrasena   |
      | <usuarioFirmante> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo           | funcionalidad           |
      | <perfil> | <moduloFirmante> | <funcionalidadFirmante> |
    When supervisar la solicitud de chequera
    Then deberia ver mensaje para la supervision aprobada
      | mensaje   | mensajeSupervision   |
      | <mensaje> | <mensajeSupervision> |
    Examples:
      | usuario | contrasena | perfil           | modulo    | funcionalidad       | cuentaOrigen | formato                      | talonario  | cantidadTalonarios | portaChequera | sello | retiroChequera | oficinaEntrega | usuarioFirmante | moduloFirmante | funcionalidadFirmante | mensaje                                          | mensajeSupervision                                            |
      ##@externaldata@src/test/resources/data/autorizaciones/supervisar_solicitud_data.xlsx@chequera
   |5238528   |1234   | Persona Juridica   |Chequeras   |Solicitud chequeras   |1041073369   |Personal - Talonario Pequeño   |25 Cheques   |2   |NO   |NO   |Retira Cliente    |LA PAZ (LP)   |45117   |Autorizaciones   |Supervisión   |Se generó la solicitud Nro  para su supervisión.   |Se generó la solicitud de autorización para la transacción N° |
