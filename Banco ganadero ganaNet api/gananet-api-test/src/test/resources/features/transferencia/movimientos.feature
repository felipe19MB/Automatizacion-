#Autor: Daniel Amaya Marín

@movimientos
Feature: Flujo Movimientos

  Como cliente del Banco
  quiero visualizar los movimientos
  para validar las transacciones realizadas

  @smokeTest @movimientos @auto-1127 @smokTestUltimasTransferencias @TestCaseKey=TEST-T2253
  Scenario Outline: Usuario visualiza las últimas transferencias realizadas
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint historial de transferencias con una fecha que solo tiene un registro
      | pIntNroPersona   |  pIntCodUsuarioXcanal   | pFechaInicial   | pFechaFinal   |
      | <pIntNroPersona> |  <pIntCodUsuarioXcanal> | <pFechaInicial> | <pFechaFinal> |
    Then Debería validar la respuesta del endpoint

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntNroPersona | pIntCodUsuarioXcanal | pFechaInicial | pFechaFinal |
      ##@externaldata@./src/test/resources/datadriven/transferencia/movimientos_data.xlsx@Movimientos@1
   |165431   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |165431   |1   |11/07/2023   |11/07/2023|
