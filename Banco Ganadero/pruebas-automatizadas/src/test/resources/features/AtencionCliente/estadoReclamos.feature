@estadoReclamos
Feature: Estado de Reclamos

  @TST-001 @atencionCliente @estadoReclamos @smokeTest @smokeTestEstadoReclamos
  Scenario Outline: Modificar perfil con transacciones pendientes

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Atención al Cliente|Estado de reclamos|
    And Consulto reclamo por fecha
      |<tipo>|<criterioBusqueda>|<fechaInicio>|<fechaFin>|
    Then Obtengo los datos del reclamo
      |<nroReclamo>|<tipoReclamo>|<reclamo>|<importeComprometido>|<moneda>|<estado>|

    Examples:
      |ID|tipoUsuario|usuario|password|tipo|criterioBusqueda|fechaInicio|fechaFin|nroReclamo|tipoReclamo|reclamo|importeComprometido|moneda|estado|
      ##@externaldata@./src/test/resources/data/cliente/datosEstadoReclamos.xlsx@HappyPath
