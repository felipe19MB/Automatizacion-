#Autor: Daniel Amaya Marin

@transferenciasTerceros
Feature: Flujo Transferencia

  Como tester del Banco
  Deseo transferir a una cuenta del mismo banco (a terceros)
  Para verificar la transacción

  @smokeTest @auto-453 @transferencias @smokeTestTransferenciaTerceros @TestCaseKey=TEST-T2168
  Scenario Outline: Usuario realiza una transferencia a un tercero
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias |
    When realiza la transferencia a terceros
      | nombredestinatario   | cuentaorigen   | descripcion   | saldo   |
      | <nombredestinatario> | <cuentaorigen> | <descripcion> | <saldo> |
    Then deberia ver un comprobante de transferencia a terceros "<response>" <saldo>

    Examples: Tabla
      | usuario | contrasena | nombredestinatario | cuentaorigen | descripcion | saldo | response |
    ##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@ATerceros@1
   |350752   |1234   |PERSONA NATURAL   |1310668667   |Prueba de descripción   |10   |¡Transferencia Exitosa!|
