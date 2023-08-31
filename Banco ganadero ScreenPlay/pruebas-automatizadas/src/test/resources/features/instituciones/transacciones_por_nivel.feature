@instituciones
Feature: Yo como usuario deseo realizar las consultasde las transacciones de las instituciones agrupadas
  por nivel para tener un registro mas entendible

  @smokeTest @instituciones @smokeTestTransaccionesPorNivel @auto-579 @TestCaseKey=TEST-T2766
  Scenario Outline: Generar las transacciones de las instituciones agrupadas por nivel
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Genera las transacciones agrupadas por nivel
      | subFuncionalidad   | institucion   | gestion   | nivel   |
      | <subFuncionalidad> | <institucion> | <gestion> | <nivel> |
    Then Deberia ver el registro generado para el nivel seleccionado
      | institucion   | gestion   | nivel   | codigo   | nombre   | importeTotal   |
      | <institucion> | <gestion> | <nivel> | <codigo> | <nombre> | <importeTotal> |
    Examples:
      | usuario | contrasena | perfil           | modulo        | funcionalidad            | subFuncionalidad    | institucion                       | gestion | nivel    | codigo | nombre                | importeTotal |
      ##@externaldata@src/test/resources/data/instituciones/transacciones_por_nivel_data.xlsx@happyPath
   |157466   |1234   | Persona Juridica    |Instituciones   |Reporte de Instituciones   |Transacciones nivel   |EDUCRUZ SRL. COLEGIO.SAINT GEORGE   |2022   |NIDITO A   |48657   |AGUILERA TOLEDO AMARA   |	13,818.00|


