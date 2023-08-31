@iniciarSesion
Feature: Inicio de sesion
  I want to use this template for my feature file

  @test-000 @acceso @smokeTest @smokeTestIniciarSesion
  Scenario Outline: Como usuario existente y habilitado, quiero iniciar sesion para poder saber si puedo ingresar a la aplicacion.
    Given Me autentique con un usuario habilitado 
    |<tipoUsuario>|<usuario>|<password>|
    And Ingrese con el perfil
    |<nombrePerfil>|
    Then El sistema debe mostrarme mis datos
    |<nombre>|
    And Finalizo la sesion

    Examples: 
    |ID|tipoUsuario|usuario|password|nombre|nombrePerfil|
    ##@externaldata@./src/test/resources/data/acceso/datosUsuarios.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |521   |1234   |F   |Persona Natural|



