@listadoPerfiles
Feature: Como usuario quiero registrar un perfil en el modulo de administracion

  @smokeTest @administracion @smokeTestListadoPerfiles @auto-184 @TestCaseKey=TEST-T2108
  Scenario Outline: Registrar perfil
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Registra un nuevo perfil
      | nombrePerfil   | perfilBase   |
      | <nombrePerfil> | <perfilBase> |
    Then Deberia ver un mensaje de confirmacion de creacion de perfil
      | mensaje   | nombrePerfil   |
      | <mensaje> | <nombrePerfil> |

    Examples:
      | usuario | contrasena | perfil          | modulo         | funcionalidad       | nombrePerfil      | perfilBase  | mensaje                    |
    ##@externaldata@src/test/resources/data/administracion/registrar_perfil_data.xlsx@HappyPath
   |78802   |1234   |Persona Natural   |Administración   |Listado de perfiles   |PRUEBAS PERFIL AT   |PERFIL TODO   |Perfil creado exitosamente|



