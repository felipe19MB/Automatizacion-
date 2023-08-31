@TransDependientes
Feature: Transacciones dependientes

  @TST-0001 @Instituciones @TransDependientes @SmokeTest @SmokeTestTransDependientes
  Scenario Outline: Generar reporte libro iva

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Instituciones|Reporte de Instituciones|Transacciones dependientes|
    And Genero reporte de transacciones por dependientes
      |<institucion>|<codigoDependiente>|<gestion>|
    Then Obtengo un reporte con el detalle de transacciones por dependiente
      |<institucion>|<codigoDependiente>|<gestion>|<nombreDependiente>|<moneda>|

    Examples:
      |ID|tipoUsuario|usuario|password|institucion|codigoDependiente|gestion|nombreDependiente|moneda|
      ##@externaldata@./src/test/resources/data/instituciones/DatosReporteTransDependientes.xlsx@Naturales@1
      |2 |CODIGO_PERSONA  |157466   |1234|EDUCRUZ SRL. COLEGIO.SAINT GEORGE|48155|2021|AGUILERA BEZERRA ERICK JOAO|BOLIVIANOS|
