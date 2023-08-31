#Autor: Daniel Amaya Marín

@acceso
Feature: Flujo inicio de sesión

  Como cliente del Banco
  Quiero ejecutar las rutas alternas
  Para validar su respuesta

  @smokeTest @acceso @auto-556 @smokeTestUsuarioInválido @TestCaseKey=TEST-T2130
  Scenario Outline: Usuario inicia sesión con usuario inválidos
    When Llama al endpoint Obtener Sesión
      | serviceID | pStrNombreUsuario |rsid|did|pStrKsBga|version|pStrModelo|pStrSistemaOperativo|
      | <serviceID> | <pStrNombreUsuario> |<rsid>|<did>|<pStrKsBga>|<version>|<pStrModelo>|<pStrSistemaOperativo>|
    Then Debería ver la respuesta del endpoint obtener sesión "<Response>"
    And Debería ser igual el esquema al de la respuesta "mtdObtenerSesion9JsonSchema"

    Examples: Data Table Obtener Sesión
      | serviceID | pStrNombreUsuario | rsid | did | pStrKsBga | version | pStrModelo | pStrSistemaOperativo | Response |
      ##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@UsuarioInválido@1
   |GanaMovilWS$mtdObtenerSesion9   |16289716   |null   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.56   |Android SDK built for x86   |ANDROID   |Datos Inválidos|


  @smokeTest @acceso @auto-561 @smokeTestContraseñaInválida @TestCaseKey=TEST-T2129
  Scenario Outline: Usuario inicia sesión con contraseña inválidos
    When Llama al endpoint Validar Clave
      | pStrNombreUsuario | pStrClave | pStrCanal | pStrImei         | pStrModelo             | pStrSistemaOperativo |did|rsid|version|didbga|pStrKsBga|
      | <pStrNombreUsuario> | <pStrClave> | <pStrCanal> | <pStrImei>        | <pStrModelo>             | <pStrSistemaOperativo> |<did>|<rsid>|<version>|<didbga>|<pStrKsBga>|
    Then Debería ver la respuesta del endpoint validar clave "<Response>"
    And Debería ser igual el esquema al de la respuesta "mtdValidarClave4_NJsonSchema"

    Examples: Data Table Validar Clave
      | pStrNombreUsuario | pStrClave | pStrCanal | pStrImei | pStrModelo | pStrSistemaOperativo | did | rsid | version | didbga | pStrKsBga | Response |
      ##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@ContraseñaInválida@1
   |312972   |12345   |1   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |Error al obtener datos del usuario|






