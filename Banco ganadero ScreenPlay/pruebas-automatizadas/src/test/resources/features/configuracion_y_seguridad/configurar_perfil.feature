@configurarPerfil
Feature: Como cliente de ganaNet quiero realizar la configuracion de mi perfil para tener mis datos actualizados

  @smokeTest @configuracionYSeguridad @smokeTestConfigurarPerfil @auto-342 @TestCaseKey=TEST-T2140
  Scenario Outline: configurar mi perfil
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Configura el perfil
      | usuario   | alias   | correo   | preferido   |
      | <usuario> | <alias> | <correo> | <preferido> |
    Then Deberia poder ver "<mensaje>" de cambio exitoso de los datos y el "<texto>" de alias disponible


    Examples:
      | usuario | contrasena | perfil          | modulo                    | funcionalidad       | alias      | correo               | preferido | mensaje                                                       | texto                                         |
      ##@externaldata@src/test/resources/data/configuracion_y_seguridad/configurar_perfil_data.xlsx@happyPath
   |521   |1234   | Persona Natural   |Configuración y Seguridad   |Configura tu perfil   |FELIPE1417   |felipe1417@gmail.com   |318546434   |Estimado cliente: Los datos han sido actualizado exitosamente   |El nombre de usuario se encuentra disponible.|


