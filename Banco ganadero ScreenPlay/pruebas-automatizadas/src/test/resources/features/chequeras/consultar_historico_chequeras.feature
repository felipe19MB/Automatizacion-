@historicoChequeras
Feature: Como usuario deseo realizar la solicitud de la chequera para mis diferentes cuentas

  @smokeTest @chequeras @smokeTestHistoricoChequeras @auto-592 @TestCaseKey=TEST-T2159
  Scenario Outline: consultar el historico de las solicitudes de chequera
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When ingresa la cuenta y el periodo para el historico
      | cuentaOrigen    | periodoInicio  | periodoFin  |
      | <cuenta origen> | <fecha inicio> | <fecha fin> |
    Then Deberia poder ver el historico según el periodo seleccionado
      | cuentaOrigen    |
      | <cuenta origen> |

    Examples:
      | usuario | contrasena | perfil           | modulo    | funcionalidad       | cuenta origen | fecha inicio | fecha fin  |
      ##@externaldata@src/test/resources/data/chequeras/historico_chequeras_data.xlsx@happyPath
   |812   |1234   |Persona Juridica   |Chequeras   |Historial Solicitud   |1041094533   |11/07/2023   |11/07/2023|
