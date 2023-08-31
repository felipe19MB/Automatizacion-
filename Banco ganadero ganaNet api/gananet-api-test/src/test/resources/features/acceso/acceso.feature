@acceso
Feature: Flujo inicio de sesión

  Como cliente del Banco
  Quiero ejecutar las rutas alternas
  Para validar su respuesta

  @smokeTest @acceso @auto-556 @smokeTestUsuarioInválido @TestCaseKey=TEST-T2764
  Scenario Outline: Usuario inicia sesión con usuario inválidos
    When Llama al endpoint Obtener Sesión
      | strUsuario   | strClave   | strTipoUsuario   | intCodAplicacion   | intCodIdioma   |
      | <strUsuario> | <strClave> | <strTipoUsuario> | <intCodAplicacion> | <intCodIdioma> |
    Then Debería ver la respuesta del endpoint obtener sesión "<Response>"
    And Debería ser igual el esquema al de la respuesta "mtdObtenerSesion9JsonSchema"

    Examples: Data Table Obtener Sesión
      | strUsuario | strClave | strTipoUsuario | intCodAplicacion | intCodIdioma | Response                                                                                       |
      ##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@UsuarioInválido@1
   |3434   |1234   |CODIGO_PERSONA   |1   |1   |Su usuario no se encuentra habilitado para el Servicio. Por favor contáctese con su Ejecutivo.|


  @smokeTest @acceso @auto-561 @smokeTestContraseñaInválida @TestCaseKey=TEST-T2765
  Scenario Outline: Usuario inicia sesión con contraseña inválidos
    When Llama al endpoint Validar Clave
      | strUsuario   | strClave   | strTipoUsuario   | intCodAplicacion   | intCodIdioma   |
      | <strUsuario> | <strClave> | <strTipoUsuario> | <intCodAplicacion> | <intCodIdioma> |
    Then Debería ver la respuesta del endpoint validar clave "<Response>"
    And Debería ser igual el esquema al de la respuesta "mtdObtenerSesion9JsonSchema"

    Examples: Data Table Validar Clave
      | strUsuario | strClave | strTipoUsuario | intCodAplicacion | intCodIdioma | Response                                             |
      ##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@ContraseñaInválida@1
   |312972   |12345   |CODIGO_PERSONA   |1   |1   |Error en los datos registrados. Registre nuevamente.|






