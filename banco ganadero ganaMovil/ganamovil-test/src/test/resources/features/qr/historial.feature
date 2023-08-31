#Autor: Daniel Amaya Marín

@qrHistorico
Feature: Flujo historico QR

  Como tester del Banco
  Deseo ver el historico QR
  Para verificar los códigos que he generado

  @smokeTest @auto-988 @RQ @smokeTestHistoricoQR @TestCaseKey=TEST-T2166
  Scenario Outline: Usuario visualiza el histórico QR
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    When navega hasta el módulo
      | QR Pagos y Cobros |
    And selecciona el módulo histórico
    Then válida que el sistema genera un histórico <cuentaOrigen>

    Examples: Tabla
      | usuario | contrasena |cuentaOrigen|
 ##@externaldata@./src/test/resources/datadriven/qr/qr_data.xlsx@Historico@1
   |152843   |1234   |1041108334|







