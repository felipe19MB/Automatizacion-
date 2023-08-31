#Autor: Daniel Amaya Marín

@transferenciasEntreMisCuentas
Feature: Flujo Transferencia

  Como tester del Banco
  Deseo transferir entre mis cuentas
  Para distribuir el dinero de las cuentas

  @smokeTest @auto-452 @transferencias @smokeTestTransferenciasEntreMisCuentas @TestCaseKey=TEST-T2082
  Scenario Outline: Usuario realiza una transferencia entre sus cuentas
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias | Entre mis cuentas |
    When selecciona los datos de transferencia Entre mis cuentas
      | cuentaorigen   | cuentadestino   | descripcion   | saldo   |
      | <cuentaorigen> | <cuentadestino> | <descripcion> | <saldo> |
    Then válida la transferencia <response> <saldo>

    Examples: Tabla Datos
      | usuario | contrasena | cuentaorigen | cuentadestino | descripcion         | saldo |response|
    ##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@EntreMisCuentas@1
   |152843   |1234   |1051709746   |1051736646   |Prueba automatizada   |10   |¡Transferencia Exitosa!|
