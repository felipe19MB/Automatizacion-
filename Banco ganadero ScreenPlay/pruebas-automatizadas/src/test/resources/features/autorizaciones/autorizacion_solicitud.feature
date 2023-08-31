@autorizacionSolicitudChequera
Feature: Como usuario deseo realizar la autorizacion de las difententes solicitudes

  @smokeTest @autorizaciones @smokeTestAutorizacionSolicitudChequera @test-575 @TestCaseKey=TEST-T2088
  Scenario Outline: autorizar la solicitud de chequera
    Given empresa genera una solicitud de chequera pendiente de autorización
      | usuario   | contrasena   | perfil   | modulo   | funcionalidad   | cuentaOrigen   | formato   | talonario   | cantidadTalonarios   | portaChequera   | sello   | retiroChequera   | oficinaEntrega   |
      | <usuario> | <contrasena> | <perfil> | <modulo> | <funcionalidad> | <cuentaOrigen> | <formato> | <talonario> | <cantidadTalonarios> | <portaChequera> | <sello> | <retiroChequera> | <oficinaEntrega> |
    And El cliente ingresa a la pagina de gananet
      | usuario           | contrasena   |
      | <usuarioFirmante> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo           | funcionalidad           |
      | <perfil> | <moduloFirmante> | <funcionalidadFirmante> |
    When autoriza la solicitud de chequera
    Then deberia ver un comprobante de pago de chequera
      | mensaje   | tipoAutorizacion   | cuentaOrigen   | formato   | talonario   | cantidadTalonarios   |
      | <mensaje> | <tipoAutorizacion> | <cuentaOrigen> | <formato> | <talonario> | <cantidadTalonarios> |
    Examples:
      | usuario | contrasena | perfil           | modulo    | funcionalidad       | cuentaOrigen | formato                      | talonario  | cantidadTalonarios | portaChequera | sello | retiroChequera | oficinaEntrega | usuarioFirmante | moduloFirmante | funcionalidadFirmante       | mensaje                                | tipoAutorizacion                     |
      ##@externaldata@src/test/resources/data/autorizaciones/autorizacion_solicitud_data.xlsx@chequera
   |42090   |1234   | Persona Juridica   |Chequeras   |Solicitud chequeras   |1041151549   |Personal - Talonario Pequeño   |25 Cheques   |2   |NO   |NO   |Retira Cliente    |LA PAZ (LP)   |42055   |Autorizaciones   |Autorización de solicitudes   |La transacción se proceso exitosamente   |COMPROBANTE DE SOLICITUD DE CHEQUERA|
