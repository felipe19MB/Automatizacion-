#Autor: Daniel Amaya Marín

@transferenciaAOtrosBancos
Feature: Flujo Transferencia a otros bancos

  Como cliente del Banco
  quiero transferir a otro banco
  para gestionar las cuentas

  @smokeTest @transferencia @auto-950 @smokTestTransferenciaAOtroBancoConImportePígnorado @TestCaseKey=TEST-T2220
  Scenario Outline: Usuario transfiere a otros bancos con cuenta registra e importe pignorado
    Given Que "felipe" inicio sesión en GanaNet Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción a otros bancos
      | pIntJtsOidOrigen   | pIntLstOtrosBancos   | pBlnControlUIF   | pDblImporte   | pIntMoneda   | pStrDescripcionTrans   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntLstOtrosBancos> | <pBlnControlUIF> | <pDblImporte> | <pIntMoneda> | <pStrDescripcionTrans> | <pStrCanal> |
    Then Debería ver la respuesta del saldo pignorado en la base de datos

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntLstOtrosBancos | pBlnControlUIF | pDblImporte | pIntMoneda | pStrDescripcionTrans |
     ##@externaldata@./src/test/resources/datadriven/transferencia/a_otros_bancos_data.xlsx@CuentaPignorada@1
   |3127471   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |2075780   |2833952   |false   |5   |0   |Transacción Automatizada|


  @smokeTest @transferencia @auto-1098 @smokTestTransferenciaAOtroBancoConCuentaNoAfiliada @TestCaseKey=TEST-T2221
  Scenario Outline: Usuario transfiere a otros bancos con cuenta destino no afiliada
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción a otros bancos no afiliados
      | pIntJtsOidOrigen   | pIntLstOtrosBancos   | pBlnControlUIF   | pDblImporte   | pIntMoneda   | pStrDescripcionTrans   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntLstOtrosBancos> | <pBlnControlUIF> | <pDblImporte> | <pIntMoneda> | <pStrDescripcionTrans> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntLstOtrosBancos | pBlnControlUIF | pDblImporte | pIntMoneda | pStrDescripcionTrans |Response|
     ##@externaldata@./src/test/resources/datadriven/transferencia/a_otros_bancos_data.xlsx@CuentaNoAfiliada@1
   |3127471   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |2075780   |283345   |false   |5   |0   |Transacción Automatizada   |Error al Obtener Lista Otros Bancos|

