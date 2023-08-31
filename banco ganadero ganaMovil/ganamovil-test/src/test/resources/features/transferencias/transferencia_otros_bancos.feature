#Autor: Daniel Amaya Marín

@transferenciaOtrosBancos
Feature: Flujo Transferencia

  Como tester del Banco
  Deseo transferir a una cuenta de otro banco
  Para verificar la transacción


  @smokeTest @auto-664 @transferencias @smokeTestTransferenciaOtrosBancos @TestCaseKey=TEST-T2122
  Scenario Outline: Usuario realiza una transferencia a otro banco
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias |
    When realiza la transferencia a otros bancos
      | nombredestinatario   | cuentaorigen   | descripcion   | saldo   |
      | <nombredestinatario> | <cuentaorigen> | <descripcion> | <saldo> |
    Then deberia ver un comprobante de transferencia a otros bancos <response>


    Examples: Tabla
      | usuario | contrasena | nombredestinatario | cuentaorigen | descripcion           | saldo | response            |
    ##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@AOtrosBancos@1
   |350752   |1234   |Rodrigo castillo   |1310668667   |Prueba de descripción   |10   |¡Transferencia Exitosa!|

  


