#Autor: Daniel Amaya Marin

@transferenciaBilletera
Feature: Flujo Transferencia

  Como tester del Banco
  Deseo transferir a una billetera yolo
  Para verificar la transacción

  @smokeTest @auto-668 @transferencias @smokeTestTransferenciaBilleteras @TestCaseKey=TEST-T2167
  Scenario Outline: Usuario realiza una transferencia a una billetera yolo
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias |
    When realiza la transferencia a la billetera
      | nombredestinatario   | cuentaorigen   | descripcion   | saldo   |
      | <nombredestinatario> | <cuentaorigen> | <descripcion> | <saldo> |
    Then deberia ver un comprobante de transferencia a la billetera <response> <saldo>

    Examples: Tabla
      | usuario | contrasena | nombredestinatario | cuentaorigen | descripcion | saldo | response |
    ##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@Billetera@1
   |350752   |1234   |71044936   |1310668667   |Prueba de descripción   |10   |¡Transferencia Exitosa!|
