#Autor: Daniel Amaya Marín

@habilitarMovil
Feature: Flujo Habilitar Movíl

  Como cliente del Banco
  quiero habilitar mi dispositivo
  para interactuar con el sistema

  @smokeTest @habilitarMovil @auto-652 @smokTestHabilitarMovil @TestCaseKey=TEST-T2130
  Scenario Outline: Usuario inicia solicitud de habilitación del dispositivo móvil
    When Llama al endpoint iniciar solicitud Enrolamiento
      |pStrNombreUsuario|	pStrImei|	pStrModelo|	pStrSistemaOperativo|
      |<pStrNombreUsuario>|	<pStrImei>|	<pStrModelo>|	<pStrSistemaOperativo>|
    Then Debería ver la respuesta del endpoint Iniciar Solicitud Enrolamiento "Para concluir la habilitación en este dispositivo puedes hacerlo por \"Gananet\" con tu Ganapin, \"Kioscos de atención digital\", o en nuestras oficinas. También puedes ingresar a la opción \"Habilitación de Ganamóvil\" de la aplicación, donde recibirás una nueva clave. Teléfono para ayuda Contact Center 800103999."
    And Debería ser igual el esquema al de la respuesta "mtdIniciarSolicitudEnrolamientoJsonSchema"

    Examples: Datos
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo |
      ##@externaldata@./src/test/resources/datadriven/habilitarDispositivo/habilitar_dispositivo_data.xlsx@HabilitarMovil@1
   |148963   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID|


  @smokeTest @habilitarMovil @auto-663 @smokTestHabilitarMovilUsuarioInvalido @TestCaseKey=TEST-T2127
  Scenario Outline: Usuario inicia solicitud de habilitación del dispositivo móvil inválido
    When Llama al endpoint iniciar solicitud Enrolamiento
      |pStrNombreUsuario|	pStrImei|	pStrModelo|	pStrSistemaOperativo|
      |<pStrNombreUsuario>|	<pStrImei>|	<pStrModelo>|	<pStrSistemaOperativo>|
    Then Debería ver la respuesta del endpoint Iniciar Solicitud Enrolamiento "El servicio de Ganamóvil solo está disponible para Personas Naturales"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo |
      ##@externaldata@./src/test/resources/datadriven/habilitarDispositivo/habilitar_dispositivo_data.xlsx@HabilitarMovilUsuarioInvalido@1
   |132   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID|






