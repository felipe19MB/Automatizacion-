@afiliacionCuentasTerceros
Feature: Yo como usuario quiero realizar la afiliacion de cuentas nuevas para que pueda realizar transferencias

  @smokeTest @trasnferencias @smokeTestAfiliacionCuentasTerceros @auto-477 @TestCaseKey=TEST-T2092
  Scenario Outline: Afiliar cuentas de terceros
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Registra la nueva cuenta de terceros
      | subFuncionalidad   | alias   | nroCuenta   | titularCuenta   | usuario   |
      | <subFuncionalidad> | <alias> | <nroCuenta> | <titularCuenta> | <usuario> |
    Then Deberia ver un mensaje de guardado satisfactoriamente
      | mensaje   | nroCuenta   | alias   | titularCuenta   | tipo   | subFuncionalidad   |
      | <mensaje> | <nroCuenta> | <alias> | <titularCuenta> | <tipo> | <subFuncionalidad> |

    Examples:
      | usuario | contrasena | perfil          | modulo         | funcionalidad | subFuncionalidad    | alias      | nroCuenta  | titularCuenta   | tipo            | mensaje                                      |
      ##@externaldata@src/test/resources/data/transferencias/afiliaciones/afiliacion_cuentas_terceros_data.xlsx@happy_path
      | 803105  | 1234       | Persona Natural | Transferencias | Afiliación    | Cuentas de terceros | AUTOMATION | 1310412499 | Persona Natural | Caja de Ahorros | La cuenta se ha guardado satisfactoriamente. |
