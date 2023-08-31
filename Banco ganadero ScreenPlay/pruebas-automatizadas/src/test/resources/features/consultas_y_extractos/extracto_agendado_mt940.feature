@extractoAgendadoMT940
Feature: Yo como usuario deseo agregar la cuenta MT940 para mi extracto agendado

  @smokeTest @consultasYExtractos @smokeTestExtractoAgendadoMT940 @auto-389 @TestCaseKey=TEST-T2768
  Scenario Outline: agregar cuenta MT940
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When agrega la cuenta MT940
      | usuario | nroCuenta   | banco   | codigoSwift   |
      | <usuario> | <nroCuenta> | <banco> | <codigoSwift> |
    Then Deberia poder el "<mensaje>" de cuenta agregada correctamente
      | codigoSwift   |
      | <codigoSwift> |

    Examples:
      | usuario | contrasena | perfil           | modulo                | funcionalidad           | nroCuenta                                      | banco               | codigoSwift | mensaje                       |
      ##@externaldata@src/test/resources/data/consultas_y_extractos/extracto_agendado_mt940_data.xlsx@happyPath
   |157466   |1234   | Persona Juridica    |Consultas y Extractos   |Extracto Agendado MT940   |Bs 1041098474 CUENTAS DE EMPRESAS M/N - FASSIL     |BANCO GANADERO S.A.   |GNDRBO22XXX   |Cuenta Agregada Correctamente|
