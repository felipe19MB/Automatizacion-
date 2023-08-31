@historicoCuentasTerceros
Feature: Yo como usuario deseo realizar las consultas  de los historicos generedos por las tranferencias
  a cuentas de terceros

  @smokeTest @transferencias @smokeTestHistoricoCuentasTerceros @auto-236 @TestCaseKey=TEST-T2106
  Scenario Outline: consultar historico de las transferencias a cuentas de terceros para todas las opciones
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Ingresa los campos para generar el historico de cuentas para terceros
      | subFuncionalidad   | cuentaTercero   | estadoTransferencia   | tipoTransferencia   | desde   | hasta   |
      | <subFuncionalidad> | <cuentaTercero> | <estadoTransferencia> | <tipoTransferencia> | <desde> | <hasta> |
    Then Deberia ver el registro generado por la consulta del historico para el siguiente numero de transaccion: "<numeroTransaccion>"
      | Fecha  proceso   | Hora proceso   | numeroTransaccion   | Nombre usuario   | Cuenta origen   | Cuenta Destino   | titularDestino   | Importe   | Moneda   | Firmantes   | estadoConsulta   |
      | <Fecha  proceso> | <Hora proceso> | <numeroTransaccion> | <Nombre usuario> | <Cuenta origen> | <Cuenta Destino> | <titularDestino> | <Importe> | <Moneda> | <Firmantes> | <estadoConsulta> |

    Examples:
      | usuario | contrasena | perfil          | modulo         | funcionalidad | subFuncionalidad    | cuentaTercero    | estadoTransferencia | tipoTransferencia | desde      | hasta      | Fecha  proceso | Hora proceso | numeroTransaccion | Nombre usuario  | Cuenta origen | Cuenta Destino | titularDestino  | Importe  | Moneda | Firmantes | estadoConsulta |
      ##@externaldata@src/test/resources/data/transferencias/historicos/historicos_data.xlsx@cuentasTerceros@1
   |521   |1234   | Persona Natural    |Transferencias   |Históricos   |Cuentas de terceros   |TODAS LA CUENTAS   |TODOS   |TODOS   |01/03/2023   |07/03/2023   |07/03/2023   |09:34:43   |10719102   |PERSONA NATURAL   |1051364223   |1310612016   |PERSONA NATURAL   |2,000.00   |Bs   |   |AUTORIZADO|


