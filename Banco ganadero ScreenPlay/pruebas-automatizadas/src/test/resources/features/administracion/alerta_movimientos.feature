@alertaMovimientos
Feature: Yo como usuario quiero agreagar un nuevo correo de alerta de movimientos

  @smokeTest @administracion @smokeTestAlertaMovimientos @auto-328 @TestCaseKey=TEST-T2099
  Scenario Outline: Registrar correo para alerta de movimientos
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Ingresa los campos para agregar el correo de alertas
      | nroDeCuenta     | correo   | tipoDeMovimiento |
      | <nroDeCuenta>   | <correo> | <tipoDeMovimiento>|
    Then Deberia mostrar el correo registrado para alertas
      | nroDeCuenta     | correo   | tipoDeMovimiento |
      | <nroDeCuenta>   | <correo> | <tipoDeMovimiento>|

    Examples:
      | usuario | contrasena | perfil | modulo | funcionalidad | nroDeCuenta | correo | tipoDeMovimiento|
      ##@externaldata@src/test/resources/data/administracion/alerta_movimientos_data.xlsx@HappyPath
   |78802   |1234   |Persona Natural   |Administración   |Alerta de Movimientos en CA/CC   |1310781190   |DANY4DS@GMAIL.COM   |TODOS|
