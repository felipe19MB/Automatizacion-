@solicitudChequeras
Feature: Como usuario deseo realizar la solicitud de la chequera para mis diferentes cuentas

  @smokeTest @chequeras @smokeTestSolicitudChequeras @auto-181 @TestCaseKey=TEST-T2111
  Scenario Outline: realizar la solicitud de la chequera
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When ingresa los campos para la solicitud de la chequera
      | cuentaOrigen   | formato   | talonario   | cantidadTalonarios   | portaChequera   | sello   | retiroChequera   | oficinaEntrega   |
      | <cuentaOrigen> | <formato> | <talonario> | <cantidadTalonarios> | <portaChequera> | <sello> | <retiroChequera> | <oficinaEntrega> |
    Then Deberia poder ver el "<mensaje>" de la solicitud creada con su respectivo numero de transaccion

    Examples:
      | usuario | contrasena | perfil           | modulo    | funcionalidad       | cuentaOrigen | formato                      | talonario  | cantidadTalonarios | portaChequera | sello | retiroChequera | oficinaEntrega | mensaje                                                                                                                                         |
      ##@externaldata@src/test/resources/data/chequeras/solicitud_chequera_data.xlsx@happyPath
   |812   |1234   | Persona Juridica   |Chequeras   |Solicitud chequeras   |1041094533   |Personal - Talonario Pequeño   |25 Cheques   |2   |NO   |NO   |Retira Cliente    |LA PAZ (LP)   |CUENTA CONJUNTA: Se generó la solicitud de autorización para la transacción N° . Para concluir ingrese a la opción Autorización de solicitudes.|

