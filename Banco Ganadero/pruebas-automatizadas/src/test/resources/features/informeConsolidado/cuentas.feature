@cuentas
Feature: Cuentas

  @TST-0001 @informeConsolidado @cuentas @smokeTest @smokeTestCuentas
  Scenario Outline: Consultar cuentas

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Informe consolidado|
    Then Obtengo una lista con los datos de la cuenta a consultar
      |<cuenta>|<tipo>|<manejo>|<estado>|

    Examples:
      |ID|tipoUsuario|usuario|password|cuenta|tipo|manejo|estado|
      ##@externaldata@./src/test/resources/data/informeConsolidado/datosCuentas.xlsx@HappyPath