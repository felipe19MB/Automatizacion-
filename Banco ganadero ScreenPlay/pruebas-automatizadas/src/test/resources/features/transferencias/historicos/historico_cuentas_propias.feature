@historicoCuentasPropias
Feature: Yo como usuario deseo realizar las consultas  de los historicos  generedos por las tranferencias
  a cuentas propias

  @smokeTest @transferencias @smokeTestHistoricoCuentasPropias @auto-295 @TestCaseKey=TEST-T2104
  Scenario Outline: consultar historico de las transferencias a cuentas propias para todas las opciones
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Ingresa los campos para generar el historico de cuentas propias
      | subFuncionalidad   | cuentaPropia   | estadoTransferencia   | desde   | hasta   |
      | <subFuncionalidad> | <cuentaPropia> | <estadoTransferencia> | <desde> | <hasta> |
    Then Deberia ver el registro generado por la consulta del historico para el siguiente numero de transaccion: "<numeroTransaccion>"
      | Fecha  proceso   | Hora proceso   | numeroTransaccion   | Nombre usuario   | Cuenta origen   | Cuenta Destino   | Importe   | Moneda   | Firmantes   | estadoConsulta   |
      | <Fecha  proceso> | <Hora proceso> | <numeroTransaccion> | <Nombre usuario> | <Cuenta origen> | <Cuenta Destino> | <Importe> | <Moneda> | <Firmantes> | <estadoConsulta> |

    Examples:
      | usuario | contrasena | perfil          | modulo         | funcionalidad | subFuncionalidad | cuentaPropia      | estadoTransferencia | desde      | hasta      | Fecha  proceso | Hora proceso | numeroTransaccion | Nombre usuario  | Cuenta origen | Cuenta Destino | Importe   | Moneda | Firmantes | estadoConsulta     |
      ##@externaldata@src/test/resources/data/transferencias/historicos/historicos_data.xlsx@cuentasPropias@1
   |521   |1234   | Persona Natural    |Transferencias   |Históricos   |Cuentas propias   |TODAS LAS CUENTAS   |TODOS   |04/03/2023   |22/03/2023   |22/03/2023   |15:41:12   |11030904   |PERSONA NATURAL   |1051364223   |1310592411   |10,000.00   |Bs   |   |AUTORIZADO|


