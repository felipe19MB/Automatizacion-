#Autor: Daniel Amaya Marín

@ordenDeCobro
Feature: Flujo Cobro QR

  Como cliente del Banco
  quiero generar un cobro
  para cobrar

  @smokeTest @QR @auto-1109 @smokTestOrdenDeCobro @TestCaseKey=TEST-T2242
  Scenario Outline: Usuario genera una orden de cobro por código QR
    Given Que "Daniel" inicio sesión en GanaMóvil Api
      | pStrNombreUsuario   | pStrImei   | pStrModelo   | pStrSistemaOperativo   | pStrClave   | pStrCanal   | did   | rsid   | version   | didbga   | pStrKsBga   |
      | <pStrNombreUsuario> | <pStrImei> | <pStrModelo> | <pStrSistemaOperativo> | <pStrClave> | <pStrCanal> | <did> | <rsid> | <version> | <didbga> | <pStrKsBga> |
    When Llama al endpoint realizar transacción cobro qr
      | pStrRazonSocial   | pStrNroCuentaP   | pStrMoneda   | pIntMonto   | pStrReferencia   | pStrFechaVcto   | pIntUnicoUso   | pIntCodigoServicio   | pStrCampoLibre   | pStrNroSerie   | pStrCodigoPersona   | pStrCanal   | pStrUsuarioRegistrado   | pNroSesion   |
      | <pStrRazonSocial> | <pStrNroCuentaP> | <pStrMoneda> | <pIntMonto> | <pStrReferencia> | <pStrFechaVcto> | <pIntUnicoUso> | <pIntCodigoServicio> | <pStrCampoLibre> | <pStrNroSerie> | <pStrCodigoPersona> | <pStrCanal> | <pStrUsuarioRegistrado> | <pNroSesion> |
    Then Debería ver la respuesta del endpoint realizar cobro qr "<pStrCodigoPersona>"
    Examples:
      | pStrNombreUsuario | pStrImei         | pStrModelo                | pStrSistemaOperativo | pStrClave | pStrCanal | did              | rsid             | version | didbga           | pStrKsBga        | pStrRazonSocial  | pStrNroCuentaP | pStrMoneda | pIntMonto | pStrReferencia      | pStrFechaVcto | pIntUnicoUso | pIntCodigoServicio | pStrCampoLibre | pStrNroSerie | pStrCodigoPersona | pStrUsuarioRegistrado |
     ##@externaldata@./src/test/resources/datadriven/qr/orden_de_cobro_data.xlsx@Cobro@1
   |44970   |82db39b08d109ee1   |Android SDK built for x86   |ANDROID   |1234   |1   |59806c2249cef7a3   |59806c2249cef7a3   |v2.4.52   |59806c2249cef7a3   |59806c2249cef7a3   |PAUL AYALA PEREZ   |1051075307   |0   |100   |Prueba Automatizada   |3   |1   |0   |Campo libre   |0   |44970   |BKM|


