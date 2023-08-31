@configuraPerfil
Feature: Configura tu perfil

  @TST-0001 @configuracionSeguridad @configuraPerfil @SmokeTest @smokeTestConfiguraPerfil
  Scenario Outline: Actualizar Imagen, Alias, Email y Nro. Preferido.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Configuracion y seguridad|Configura tu perfil|
    And Actualizo los datos del perfil
      |<alias>|<email>|<nroPreferido>|<codigoImagen>|
    Then Obtengo un mensaje de confirmacion
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|alias|email|nroPreferido|codigoImagen|mensaje|
      ##@externaldata@./src/test/resources/data/configuracion/datosConfiguraPerfil.xlsx@HappyPath

  @TST-0001 @configuracionSeguridad @configuraPerfil @SmokeTest @smokeTestConfiguraPerfil
  Scenario Outline: Cambiar limite de transacciones por dia.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Configuracion y seguridad|Configura tu perfil|
    And Cambio el limite de transacciones por dia
      |<cantidadTransacciones>|
    Then Obtengo un mensaje de confirmacion
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|cantidadTransacciones|mensaje|
      ##@externaldata@./src/test/resources/data/configuracion/datosConfiguraPerfil.xlsx@LimiteTransacciones