#Autor: Daniel Amaya Marín

@accesoHabilitarDispositivo
Feature: Flujo Habilitar Movíl

  Como tester del Banco
  Deseo solicitar la habilitación del dispositivo móvil
  Para verificar que se genere el registro de la solicitud


  Background:
    Given el usuario abre la app GanaMovil

  @smokeTest @auto-432 @acceso @smokeTestHabilitarDispositivo @TestCaseKey=TEST-T2121
  Scenario Outline: Usuario solicita la habilitación del dispositivo móvil
    When realiza el login con sus credenciales
      | usuario   | contrasena    |
      | <usuario> | <constrasena> |
    And acepta solicitud de habilitación
    Then debería ver la alerta de confirmación <validacion>

    Examples: Datos
      | usuario | constrasena | validacion       |
##@externaldata@./src/test/resources/datadriven/acceso/acceso_data.xlsx@HabilitarMovil@1
   |94190   |1234   |Registro Exitoso|














