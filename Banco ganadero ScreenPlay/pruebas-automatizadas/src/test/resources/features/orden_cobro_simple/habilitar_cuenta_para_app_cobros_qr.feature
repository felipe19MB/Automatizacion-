@administracionQr
Feature: Como usuario quiero habilitar una cuenta para que pueda utilizarla para cobros QR por la app

  @smokeTest @ordenCobroSimple @smokeTestAdministracionQr @auto-820 @TestCaseKey=TEST-T2085
  Scenario Outline: Habilitar cuenta propia
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Habilita una cuenta propia para app cobros qr
      | nroCuenta   | referencia   | fechaVencimiento   | uso   | usuario   |
      | <nroCuenta> | <referencia> | <fechaVencimiento> | <uso> | <usuario> |
    Then Deberia ver un mensaje de registro exitoso
      | mensaje   | nroCuenta   | referencia   | fechaVencimiento   | uso   |
      | <mensaje> | <nroCuenta> | <referencia> | <fechaVencimiento> | <uso> |

    Examples:
      | usuario  | contrasena | perfil          | modulo         | funcionalidad     | nroCuenta  | referencia | fechaVencimiento | uso           | mensaje                 |
      ##@externaldata@src/test/resources/data/orden_cobro_simple/habilitar_cuenta_para_app_cobros_data.xlsx@happy_path
   |12230440   |1234   |Persona Natural   |Orden de Cobro   |Administración QR   |1310538338   |AUTOMATION TEST   |1 Año   |Más de un uso   |Registrado exitosamente|
