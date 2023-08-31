@recuperarCredenciales
Feature: El cliente quiere recuperar sus credenciales de inicio de sesion
  debido al olvido de su usuario o contrasena
  para que pueda ingresar al sistema Gananet y realizar transacciones

  @smokeTest @acceso @smokeTestRecuperarCredenciales @auto-408 @TestCaseKey=TEST-T2097
  Scenario Outline: El cliente desea recuperar sus credenciales por olvido de su usuario

    Given Ingresa a la pagina de Gananet
      | <usuario> |
    When Ingreso email y Ganapin
      | email   | ganapin   |
      | <email> | <ganapin> |
    Then Deberia ver un mensaje de confirmacion
      | <mensaje> |
    Examples:
      | email                 | ganapin | mensaje                                                                    | usuario  |
      ##@externaldata@src/test/resources/data/acceso/accesos_data.xlsx@HappyPath
   |macontreras@bg.com.bo   |1234   |Si los datos registrados son correctos recibira el proceso de recuperación   |12244104|

  @smokeTest @acceso @smokeTestOlvideMiContrasena @auto-407 @TestCaseKey=TEST-T2098
  Scenario Outline: El cliente desea recuperar sus credenciales por olvido de su contrasena

    Given Ingresa a la pagina de Gananet
      | <usuario> |
    When Ingresa su usuario y Ganapin
      | usuario   | ganapin   |
      | <usuario> | <ganapin> |
    Then Deberia ver un mensaje de confirmacion
      | <mensaje> | <usuario> |
    Examples:
      | usuario  | ganapin | mensaje                                                                       |
      ##@externaldata@src/test/resources/data/acceso/accesos_data.xlsx@HappyPath2
   |12244104   |1234   |Se generó una nueva clave de acceso. enviada al correo: ma******ras@bg.com.bo|
