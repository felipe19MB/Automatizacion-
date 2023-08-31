@registroSugerencias
Feature: Como usuario
  deseo realizar el registro de una sugerencia
  para poder mejorar la aplicación desde el punto de vista del usuario

  @smokeTest @atencionAlCliente @smokeTestRegistroSugerencias @auto-717 @TestCaseKey=TEST-T2117
  Scenario Outline: Realizar el registro de una sugerencia de manera exitosa
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When registra una sugerencia
      | correoElectronico    | descripcion   |
      | <correo electronico> | <descripcion> |
    Then Debería visualizar el mensaje de confirmación de recibida y su correcto almacenamiento en base de datos
      |mensajeInformativo| mensajeConfirmacion       |
      |<mensaje informativo>| <mensaje de confirmacion> |

    Examples:
      | usuario | contrasena | perfil          | modulo              | funcionalidad | correo electronico | descripcion                                                     |mensaje informativo| mensaje de confirmacion                                                  |
      ##@externaldata@src/test/resources/data/atencion_al_cliente/registro_sugerencias_data.xlsx@happyPath
   |78802   |1234   | Persona Natural   |Atención al Cliente   |Sugerencias   |testAutomation@bg.com.bo   |Esto es una prueba automatizada para el registro de sugerencias   |Gracias por su sugerencia, su opinión nos interesa y nos ayuda a mejorar.   |Gracias por su sugerencia, la sugerencia fue enviada satisfactoriamente.|
