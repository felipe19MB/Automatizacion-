#Autor: Daniel Amaya Marín

@transferenciaATerceros
Feature: Flujo Transferencia a terceros

  Como cliente del Banco
  quiero transferir a terceros
  para gestionar las cuentas

  @smokeTest @transferencia @auto-949 @smokTestTransferenciaATerceros @TestCaseKey=TEST-T2222
  Scenario Outline: Usuario transfiere a un tercero con cuenta no afiliada
    Given Que "Felipe" inicio sesión en GanaNet Api
      | strUsuario   | strClave   | strTipoUsuario   | intCodAplicacion   | intCodIdioma   |
      | <strUsuario> | <strClave> | <strTipoUsuario> | <intCodAplicacion> | <intCodIdioma> |
    When Llama al endpoint realizar transacción a tercero con cuenta no afiliada
      | intJtsOidOrigen   | intJtsOidDestino   | dblImporteTransaccion   | intMonedaTran   | strDescripcion   | strGlosaDestino   | strNroCuentaOrigen   | strNroCuentaDestino   | strTokenSegundoFactor   | intCodIdioma   | intPersonaRol   | intNroMenu   | strConsolidado   |
      | <intJtsOidOrigen> | <intJtsOidDestino> | <dblImporteTransaccion> | <intMonedaTran> | <strDescripcion> | <strGlosaDestino> | <strNroCuentaOrigen> | <strNroCuentaDestino> | <strTokenSegundoFactor> | <intCodIdioma> | <intPersonaRol> | <intNroMenu> | <strConsolidado> |

    Then Debería ver la respuesta del endpoint "<Response>"
    And Debería ver el estado del endpoint al realizar transacción 200

    Examples:
      | strUsuario | strClave | strTipoUsuario | intCodAplicacion | intCodIdioma | intJtsOidOrigen | intJtsOidDestino | dblImporteTransaccion | intMonedaTran | strDescripcion      | strGlosaDestino     | strNroCuentaOrigen | strNroCuentaDestino | strTokenSegundoFactor | intCodIdioma | intPersonaRol | intNroMenu | strConsolidado | Response                                                                                                 |
      ##@externaldata@./src/test/resources/datadriven/transferencia/a_terceros_data.xlsx@cuentaNoAfiliada
   |812   |1234   |CODIGO_PERSONA   |1   |1   |1875725   |1581613   |1.00   |2225   |ESTO ES UNA PRUEBA1   |ESTO ES UNA PRUEBA2   |1310087007   |234546423   |1234   |1   |135   |4   |N   |No existe mis afiliado.|

