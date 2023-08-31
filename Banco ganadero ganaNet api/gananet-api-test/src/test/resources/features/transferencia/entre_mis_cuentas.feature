#Autor: Daniel Amaya Marín

@transferenciaEntreMisCuentas
Feature: Flujo Transferencia entre mis cuentas

  Como cliente del Banco
  quiero transferir entre mis cuentas
  para gestionar las cuentas

  @smokeTest @transferencia @auto-595 @smokTestTransferenciaConTipoDeCambio @TestCaseKey=TEST-T2134
  Scenario Outline: Usuario transfiere a cuentas propias con tipo de cambio
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción a cuentas cuentas con tipo de cambio
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"
    And Debería existir los datos de la transacción en la base de datos
    And Debería los datos de la respuesta
      | strTipoCambioDeb   | strMontoEquivDeb   | strImporteDeb   |
      | <strTipoCambioDeb> | <strMontoEquivDeb> | <strImporteDeb> |

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | strTipoCambioDeb | strMontoEquivDeb | strImporteDeb |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@TipoCambio@1
   |13824654   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |1310862916   |1310858248   |3   |0   |Transacción automatizada   |false   |false   |6.85000   |0.44   |3.00|



  @smokeTest @transferencia @auto-805 @smokTestTransferenciaConCuentaOrigenBloqueada @TestCaseKey=TEST-T2131
  Scenario Outline: Usuario transfiere a cuentas propias con cuenta de origen bloqueada
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción con la cuenta origen bloqueada
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@CuentaBloqueadaOrigen@1
   |3127471   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |71319856   |1310128964   |3   |0   |Transacción automatizada   |false   |false   |Cuenta Destino no Permite Debito|



  @smokeTest @transferencia @auto-945 @smokTestTransferenciaACuentaDestinoBloqueada @TestCaseKey=TEST-T2137
  Scenario Outline: Usuario transfiere a cuentas propias con cuenta destino bloqueada
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción con la cuenta destino bloqueadas
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@CuentaBloqueadaDestino@1
   |5637757   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |1310763091   |1310294823   |3   |0   |Transacción automatizada   |false   |false   |Error al Solicitar Transferencia|



  @smokeTest @transferencia @auto-799 @smokTestTransferenciaSaldoOrigenInsuficiente @TestCaseKey=TEST-T2132
  Scenario Outline: Usuario transfiere a cuentas propias con saldo insuficiente en la cuenta origen
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción con cuenta sin saldo suficiente
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta "<Response>" y "Cuenta Origen no tiene Saldo Disponible"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@SaldoInsuficiente@1
   |1396546   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |74641866   |1310500682   |234   |0   |Transacción automatizada   |false   |false   |Saldo insuficiente|



  @smokeTest @transferencia @auto-601 @smokTestTransferenciaConTransaccionesMaximasPermitidas @TestCaseKey=TEST-T2133
  Scenario Outline: Usuario transfiere a cuentas propias con cantidad de transacciones maximas permitidas
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción con transacciones maximas permitidas
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@MaximasPermitidas@1
   |1396546   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |74641866   |1310500682   |234   |0   |Transacción automatizada   |false   |false   |Limites no Permitidos|



  @smokeTest @transferencia  @auto-839 @smokTestTransferenciaLimiteImporteDiario @TestCaseKey=TEST-T2136
  Scenario Outline: Usuario transfiere a cuentas propias con monto mayor al límite de importe diario
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacciones con límite de importe
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@MontoMaximoDiario@1
   |92883   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |1310146752   |6051189946   |234   |0   |Transacción automatizada   |false   |false   |Limites no Permitidos|



  @smokeTest @transferencia  @auto-851 @smokTestTransferenciaLimiteImporteParaLaFirma @TestCaseKey=TEST-T2135
  Scenario Outline: Usuario transfiere a cuentas propias con monto mayor al límite de importe para la firma
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacciones con límite de importe por firma
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@MontoMaximoFirma@1
   |409366   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |1310348497   |75525613   |8000   |0   |Transacción automatizada   |false   |false   |Limites no Permitidos|



  @smokeTest @transferencia  @auto-833 @smokTestTransferenciaRequiriendoDosPersonas @TestCaseKey=TEST-T2139
  Scenario Outline: Usuario transfiere a cuentas propias con cuenta origen requiriendo dos personas para la firma
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacciones con la cuenta que requiere dos personas para la firma
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@PersonaParaLaFirma@1
   |165431   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |1310465407   |79881396   |8000   |0   |Transacción automatizada   |false   |false   |Limites no Permitidos|


  @smokeTest @transferencia  @auto-845 @smokTestTransferenciaConLimiteImporteDiarioPermitido @TestCaseKey=TEST-T2138
  Scenario Outline: Usuario transfiere a cuentas propias con monto mayor al límite de importe diario por periodo permitido para la cuenta origen
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción con límite de importe diario por periodo permitido para la cuenta origen
      | pIntJtsOidOrigen   | pIntJtsOidDestino   | pDblImporte   | pIntMoneda   | pStrGlosa   | pBlnTerceros   | pBoolControlUIF   | pStrCanal   |
      | <pIntJtsOidOrigen> | <pIntJtsOidDestino> | <pDblImporte> | <pIntMoneda> | <pStrGlosa> | <pBlnTerceros> | <pBoolControlUIF> | <pStrCanal> |
    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200
    And Debería ser igual el esquema al de la respuesta "mtdRealizarTransaccionCuentas2JsonSchema"

    Examples:
      | pStrNombreUsuario | pStrImei | pStrModelo | pStrSistemaOperativo | pStrClave | pStrCanal | did | rsid | version | didbga | pStrKsBga | pIntJtsOidOrigen | pIntJtsOidDestino | pDblImporte | pIntMoneda | pStrGlosa | pBlnTerceros | pBoolControlUIF | Response |
      ##@externaldata@./src/test/resources/datadriven/transferencia/entre_mis_cuentas_data.xlsx@PeriodoPermitido@1
   |211686   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |72662095   |1051106065   |8000   |0   |Transacción automatizada   |false   |false   |Limites no Permitidos|
