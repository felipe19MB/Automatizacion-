@afiBilletera
Feature: Afiliacion a cuentas de billetera

  @TST-0001 @transferencia @afiBilletera @smokeTest @smokeTestAfiBilletera
  Scenario Outline: Afiliar cuenta de billetera

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de billetera|
    And Afilio una cuenta de billetera
      |<alias>|<telefono>|<favorito>|
    Then Obtengo un mensaje de confirmacion
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|alias|telefono|favorito|mensaje|
      ##@externaldata@./src/test/resources/data/transferencia/datosAfiBilleteras.xlsx@HappyPath