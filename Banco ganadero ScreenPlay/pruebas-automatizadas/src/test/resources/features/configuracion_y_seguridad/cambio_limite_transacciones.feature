@cambioLimiteTransacciones
Feature: Como usuario deseo la cambiar el limite de mis transacciones para poder realizar mas

  @smokeTest @configuracionYSeguridad @smokeTestCambioLimiteTransacciones @auto-348 @TestCaseKey=TEST-T2162
  Scenario Outline: cambiar el limite de transacciones
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When cambia el limite de transacciones
      | usuario   | nroTransacciones   |
      | <usuario> | <nroTransacciones> |
    Then Deberia poder ver "<mensaje>" de cambio de limite exitoso y los datos actualizados en base de datos
      | nroTransacciones   |
      | <nroTransacciones> |

    Examples:
      | usuario | contrasena | perfil          | modulo                    | funcionalidad       | nroTransacciones | mensaje                                            |
      ##@externaldata@src/test/resources/data/configuracion_y_seguridad/cambio_limite_transacciones_data.xlsx@happyPath
   |5238528   |1234   | Persona Natural   |Configuración y Seguridad   |Configura tu perfil   |21   |Límite de transacciones actualizado correctamente.|

