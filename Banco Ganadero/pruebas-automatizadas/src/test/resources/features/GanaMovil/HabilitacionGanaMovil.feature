@GanaMovil
Feature: Habilitacion de GanaMovil


  @TEST-T1393 @GanaMovil @HabilitacionGanaMovil @SmokeTest @SmokeTestHabilitacionGanaMovil
  Scenario Outline: Como usuario de gananet, quiero habilitar mi dispositivo ganamovil para que pueda hacer uso de la banca movil

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    And Registro mi dispositivo desde ganamovil
      |<usuario>|<estadoDispositivo>|
    When Selecciono el menu
      |GanaMóvil|Habilitación de dispositivo|
    And Selecciono el dispositivo a habilitar
      |<estadoDispositivo>|
    When Confirmo la habilitacion del dispositivo
      |<numeroTelefono>|<ganapin>|
    Then Mi dispositivo se habilita correctamente
      |<mensajeDeExito>|<estadoEsperado>|
    Examples: 
      |ID|tipoUsuario|usuario|password|ganapin|numeroTelefono|mensajeDeExito|estadoDispositivo|estadoEsperado|
      |1   |CODIGO_PERSONA   |521   |1234   |1234|75330974|Se procedió a cambiar de estado al dispositivo|P|Habilitado|


  @GanaMovil @HabilitacionGanaMovil @SmokeTest @TEST-T1394
  Scenario Outline: Como usuario de gananet, quiero bloquear mi dispositivo ganamovil para que pueda pueda estar seguro que no usen mi ganamovil en el dispositivo bloqueado

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    And Registro mi dispositivo desde ganamovil
      |<usuario>|<estadoDispositivo>|
    When Selecciono el menu
      |GanaMóvil|Habilitación de dispositivo|
    And Selecciono el dispositivo a bloquear
    When Confirmo que mi dispositivo se bloquee
      |<ganapin>|
    Then Mi dispositivo fue bloqueado correctamente
      |<mensajeDeExito>|
    Examples:
      |ID|tipoUsuario|usuario|password|ganapin|mensajeDeExito|estadoDispositivo|
      |1   |CODIGO_PERSONA   |521   |1234   |1234|Se procedió a cambiar de estado al dispositivo|A|