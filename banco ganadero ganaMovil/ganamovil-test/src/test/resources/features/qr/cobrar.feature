#Autor: Daniel Amaya Marín

@qrCodrar
Feature: Flujo Generación de códigos QR

  Como tester del Banco
  Deseo generar el código QR
  Para cobrar y verificar que se genere correctamente

  @smokeTest @auto-707 @RQ @smokeTestGenerarCódigoQR @TestCaseKey=TEST-T2126
  Scenario Outline: Usuario genera un código QR para cobrar
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | QR Pagos y Cobros |
    When selecciona la información necesaria para generar el código QR
      | cuentaorigen   | tipomoneda   | tiempoduracion   | descripcion   | saldo   | usounico   |
      | <cuentaorigen> | <tipomoneda> | <tiempoduracion> | <descripcion> | <saldo> | <usounico> |
    Then válida que el sistema genera un código QR válido

    Examples: Tabla
      | usuario | contrasena | cuentaorigen | tipomoneda | tiempoduracion | descripcion | saldo | usounico |
##@externaldata@./src/test/resources/datadriven/qr/qr_data.xlsx@Pagar@1
   |152843   |1234   |1051709746   |Bolivianos   |Válido por un Mes   |Prueba Automatizada   |100   |false|
