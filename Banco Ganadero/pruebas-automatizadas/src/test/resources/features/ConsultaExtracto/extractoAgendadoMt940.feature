@extractoAgendadoMt940
Feature: Extracto Agendado MT940

  @TST-001 @consultasExtractos @extractoAgendadoMt940 @smokeTest @smokeTestExtractoAgendadoMt940
  Scenario Outline: Consultar extracto agendado MT940

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Consultas y Extractos|extracto Agendado MT940|
    And Agrego una cuenta para extracto MT940
      |<nroCuenta>|<codigoSwift>|
    Then Obtengo un mensaje de confirmacion
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|nroCuenta|codigoSwift|mensaje|
      ##@externaldata@./src/test/resources/data/consultaExtracto/datosExtractoMT940.xlsx@HappyPath
      |2 |CODIGO_PERSONA  |812   |1234|1041094533|BANCO GANADERO S.A.|Cuenta Agregada Correctamente|