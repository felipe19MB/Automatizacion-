#Autor: Daniel Amaya Marín

@transferenciaATerceros
Feature: Flujo Transferencia a terceros

  Como cliente del Banco
  quiero transferir a terceros
  para gestionar las cuentas

  @smokeTest @transferencia @auto-949 @smokTestTransferenciaATerceros @TestCaseKey=TEST-T2222
  Scenario Outline: Usuario transfiere a un tercero con cuenta no afiliada
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción a tercero con cuenta no afiliada
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200

    Examples:
      | pStrNombreUsuario | pStrImei         | pStrModelo                | pStrSistemaOperativo | pStrClave | pStrCanal | did              | rsid             | version | didbga           | pStrKsBga        | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa                | pBlnTerceros | pBoolControlUIF | Response              |
      ##@externaldata@./src/test/resources/datadriven/transferencia/a_terceros_data.xlsx@CuentaNoAfiliada@1
   |7850863   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |5099429   |74055918   |10   |0   |Transacción automatizada   |false   |false   |ERROR DE COMUNICACIÓN|


  @smokeTest @transferencia @auto-1120 @smokTestEliminarCuentaTercero @TestCaseKey=TEST-T2252
  Scenario Outline: Usuario elimina la cuenta de un tercero afiliada
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint eliminar cuenta de tercero con un numero de cuenta que ya esta registrado
      | pstrIdioma   | pStrCper   | pStrNroCuenta   |
      | <pstrIdioma> | <pStrCper> | <pStrNroCuenta> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200

    Examples:
      | pStrNombreUsuario | pStrImei         | pStrModelo                | pStrSistemaOperativo | pStrClave | pStrCanal | did              | rsid             | version | didbga           | pStrKsBga        | pstrIdioma | pStrCper | pStrNroCuenta | Response |
     ##@externaldata@./src/test/resources/datadriven/transferencia/a_terceros_data.xlsx@EliminarTercero@1
   |172628   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |es   |172628   |1051185944   |Se eliminó exitosamente|

