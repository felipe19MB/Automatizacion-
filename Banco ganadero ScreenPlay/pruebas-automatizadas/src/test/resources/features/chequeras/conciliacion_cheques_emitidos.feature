@conciliacionChquesEmitidos
Feature: Como usuario deseo revisar la conciliacion de mis cheques emitidos

  @smokeTest @chequeras @smokeTestConciliacionChquesEmitidos @auto-590 @TestCaseKey=TEST-T2770
  Scenario Outline: consultar la conciliacion de los cheques emitidos
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When ingresa la cuenta y el periodo de la conciliacion
      | cuentaOrigen    | periodo   | desde   | hasta   |
      | <cuenta origen> | <periodo> | <desde> | <hasta> |
    Then Deberia poder ver la conciliaciones de las chequeras
      | cuentaOrigen    | nroCheque   | monto   | estado   | confirmacion   |
      | <cuenta origen> | <nroCheque> | <monto> | <estado> | <confirmacion> |
    Examples:
      | usuario | contrasena | perfil           | modulo    | funcionalidad                 | cuenta origen | periodo      | desde      | hasta      | nroCheque | monto | estado | confirmacion |
      ##@externaldata@src/test/resources/data/chequeras/conciliacion_chequeras_data.xlsx@happyPath
   |157466   |1234   | Persona Juridica    |Chequeras   |Conciliación Cheques Emitidos   |1041098474   |Rango fechas   |01/03/2023   |01/03/2023   |11294   |518   |P   |NO|
