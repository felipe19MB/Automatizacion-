@Acceso
Feature: Inicio de sesion
  I want to use this template for my feature file

  @IniciarSesion
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
    ##@externaldata@./src/test/resources/data/acceso/DatosUsuarios.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |10944652   |1234   |MARIO   |Marroquin Young Mario Moises|



