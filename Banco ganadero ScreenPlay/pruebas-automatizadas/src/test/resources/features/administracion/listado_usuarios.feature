@listadoUsuarios
Feature: Como usuario quiero agregar un nuevo usuario a mi empresa para que pueda ingresar y realizar transacciones

  @smokeTest @administracion @smokeTestListadoUsuarios @auto-185 @TestCaseKey=TEST-T2107
  Scenario Outline: Registrar Usuario que es cliente del banco
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Registra un usuario que es "cliente del Banco"
      | tipoDocumento      | documentoIdentidad   | extension   | tipoUsuario      | perfilUsuario   | estado   | usuario   | codigo   |
      | <tipoDocumento>    | <documentoIdentidad> | <extension> | <tipoUsuario>    | <perfilUsuario> | <estado> | <usuario> | <codigo> |
    Then Deberia ver un mensaje de usuario agregado correctamente
      | mensaje   | codigo   | nombre   | tipoUsuario      | perfilUsuario   | estado   |
      | <mensaje> | <codigo> | <nombre> | <tipoUsuario>    | <perfilUsuario> | <estado> |

    Examples:
      | usuario | contrasena | perfil | modulo | funcionalidad |tipoDocumento| documentoIdentidad | extension | tipoUsuario | perfilUsuario | estado | codigo | nombre |mensaje|
      ##@externaldata@src/test/resources/data/administracion/listado_usuarios_data.xlsx@happy_path
   |452004   |1234   |Persona Natural   |Administración   |Listado de usuarios   |CARNET DE IDENTIDAD   |6732452   |LP   |OPERADOR   |ADMIN   |ACTIVO   |12244104   |EMPLEADO BANCO   |El usuario: 12244104 ha sido registrado dentro de la empresa exitosamente, las claves fueron enviadas al e-mail registrado del usuario.|
