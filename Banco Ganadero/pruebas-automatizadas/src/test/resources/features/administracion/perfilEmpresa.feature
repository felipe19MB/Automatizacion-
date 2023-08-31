@perfilEmpresa
Feature: Perfil Empresa

  @TST-001 @administracion @perfilEmpresa @smokeTest @smokeTestPerfilEmpresa
  Scenario Outline: Modificar perfil con transacciones pendientes

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Administración|Perfil Empresa|
    And Modifico el perfil teniendo transacciones pendientes
      |<perfil>|
    Then Obtengo un mensaje restrictivo
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|perfil|mensaje|
      ##@externaldata@./src/test/resources/data/administracion/datosPerfilEmpresa.xlsx@HappyPath
