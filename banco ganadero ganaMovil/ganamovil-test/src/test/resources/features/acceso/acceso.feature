#Autor: Daniel Amaya Marín

@accesoIniciarSesion
Feature: Flujo inicio de sesión

  Como tester del Banco
  Deseo iniciar sesión en GanaMóvil
  Para verificar que ingrese a la pantalla de inicio, el saldo de la cuenta y la alerta de datos inválidos


  Background:
    Given el usuario abre la app GanaMovil

  @smokeTest @auto-433 @acceso @smokeTestIniciarSesion @TestCaseKey=TEST-T2120
  Scenario Outline: Usuario inicia sesión exitosamente
    When realiza el login con sus credenciales
      | usuario   | contrasena    |
      | <usuario> | <constrasena> |
    And se habilita el dispositivo internamente <usuario>
    And realiza nuevamente el login con sus credenciales
      | usuario   | contrasena    |
      | <usuario> | <constrasena> |
    Then debería ver el nombre de usuario <validacion>
    And debería ver la cantidad del saldo <Saldo>

    Examples: Datos
      | usuario | constrasena | validacion      |Saldo|
    ##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@InicioSesion@1
   |169525   |1234   |Persona Natural   |1000|


  @smokeTest @auto-467 @acceso @smokeTestContraseñaInvalida @TestCaseKey=TEST-T2164
  Scenario Outline: Usuario ingresa las credenciales erróneas
    And se desbloquea el usuario <usuario>
    When realiza el login con sus credenciales
      | usuario   | contrasena    |
      | <usuario> | <constrasena> |
    Then debería ver el mensaje de error <validacion>

    Examples: Datos
      | usuario | constrasena |validacion|
     ##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@DatosInvalidos@1
   |139326   |12834   |Datos Inválidos|




















 
