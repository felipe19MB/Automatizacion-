@afiliacionCuentasBillereteras
Feature: Yo como usuario quiero realizar la afiliacion de cuentas nuevas para que pueda realizar transferencias

  @smokeTest @transferencias @transferenciasAfiliacion @auto-899 @TestCaseKey=TEST-T2100
  Scenario Outline: Afiliar cuentas de billetera
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Registra la nueva cuenta de billetera
      | subFuncionalidad   | alias   | telefono   | usuario |
      | <subFuncionalidad>    | <alias> | <telefono> | <usuario> |
    Then Deberia ver un mensaje de cuenta adicionado satisfactoriamente
      | mensaje   | telefono   | alias   | titularCuenta   | moneda   |  subFuncionalidad   |
      | <mensaje> | <telefono> | <alias> | <titularCuenta> | <moneda> | <subFuncionalidad>  |

    Examples:
      | usuario | contrasena | perfil | modulo | funcionalidad |subFuncionalidad| alias | telefono | titularCuenta | moneda | mensaje |
      ##@externaldata@src/test/resources/data/transferencias/afiliaciones/afiliacion_cuentas_billeteras_data.xlsx@happy_path
   |803105   |1234   |Persona Natural   |Transferencias   |Afiliación   |Cuentas de billetera   |AUTOMATION   |76497309   |PERSONA NATURAL   |Bs   |La cuenta se ha adicionado satisfactoriamente|
