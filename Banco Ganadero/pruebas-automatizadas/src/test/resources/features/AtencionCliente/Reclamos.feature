@Reclamos
Feature: Reclamos

  @TST-0001 @AtencionCliente @Reclamos @SmokeTest @SmokeTestReclamos
  Scenario Outline: Enviar Reclamo

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Atencion al Cliente|Reclamos|
    And Envio un reclamo
      |<celular>|<telefono>|<barrio>|<nroCasa>|<correo>|<tipoReclamo>|<reclamo>|<monto>|<moneda>|<fechaHecho>|<descripcion>|
    Then Obtengo un mensaje de reclamo enviado
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|celular|telefono|barrio|nroCasa|correo|tipoReclamo|reclamo|monto|moneda|fechaHecho|descripcion|

