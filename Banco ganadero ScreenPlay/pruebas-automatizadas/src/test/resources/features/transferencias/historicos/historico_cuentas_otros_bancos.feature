@historicoOtrosBancos
Feature: Yo como usuario deseo realizar las consultas  de los historicos  generedos por las tranferencias
  a cuentas de otros bancos

  @smokeTest @transferencias @smokeTestHistoricoOtrosBancos @auto-307 @TestCaseKey=TEST-T2102
  Scenario Outline: consultar historico de las transferencias a cuentas del otros bancos para todas las opciones
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Ingresa los campos para generar el historico de cuentas de otros bancos
      | subFuncionalidad   | bancoDestino   | cuentaDestino   | tipoTransferencia   | estado   | desde   | hasta   |
      | <subFuncionalidad> | <bancoDestino> | <cuentaDestino> | <tipoTransferencia> | <estado> | <desde> | <hasta> |
    Then Deberia ver el registro generado por la consulta del historico para el siguiente numero de transaccion: "<numeroTransaccion>"
      | Fecha   | Hora   | numeroTransaccion   | nroOrden   | Nombre usuario   | Cuenta origen   | bancodeDestino   | Cuenta Destino   | beneficiario   | Importe   | Moneda   | Firmantes   | estadoConsulta   |
      | <Fecha> | <Hora> | <numeroTransaccion> | <nroOrden> | <Nombre usuario> | <Cuenta origen> | <bancodeDestino> | <Cuenta Destino> | <beneficiario> | <Importe> | <Moneda> | <Firmantes> | <estadoConsulta> |

    Examples:
      | usuario | contrasena | perfil          | modulo         | funcionalidad | subFuncionalidad        | bancoDestino | cuentaDestino | tipoTransferencia | estado | desde      | hasta      | Fecha      | Hora     | numeroTransaccion | nroOrden            | Nombre usuario  | Cuenta origen | bancodeDestino | Cuenta Destino | beneficiario                            | Importe   | Moneda | Firmantes | estadoConsulta   |
     ##@externaldata@src/test/resources/data/transferencias/historicos/historicos_data.xlsx@cuentasOtrosBancos@1
   |521   |1234   | Persona Natural    |Transferencias   |Históricos   |Cuentas de otros bancos   |TODOS   |TODOS   |TODOS   |TODOS   |19/03/2023   |26/03/2023   |25/03/2023   |08:34:13   |56262310   |1018725032356262310   |PERSONA NATURAL   |1051364223   |BANCO FIE   |40008537031   |CESPEDES SAUCEDO PABLO ANDRES, FOLADORI   |10,000.00   |BS.   |-   |ENVIADA ACEPTADA|



