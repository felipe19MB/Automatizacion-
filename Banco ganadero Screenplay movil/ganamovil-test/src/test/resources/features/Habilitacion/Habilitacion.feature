@Habilitacion
Feature: Habilitacion ganamovil
  Como persona quiero habilitar mi dispositivo para ingresar a ganamovil

  Background:
    Given Cliente abre aplicacion

  @TEST-T1155 @BVT @Habilitacion @SmokeTest
  Scenario Outline: Como cliente quiero habilitarme para ingresar a ganamovil
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Ingresa su usuario
      |<usuario>|
    And Ingreso mi password
      |<password>|
    And Indica que quiero registrar ganamovil
    And Verifica registro exitoso
    And Acepta registro exitoso
    And Habilitar dispositivo para el usuario internamente
      |<usuario>|
    When Ingresa su usuario
      |<usuario>|
    And Ingreso mi password
      |<password>|
    Then Deberia mostrarse el menu principal
      |<mensaje>|
    Examples:
      |ID|usuario|password|mensaje|
      |1   |802901   |1234   |Bienvenido(a)|
