@historicoCuentasExterior
Feature: Yo como usuario deseo realizar las consultas  de los historicos  generedos por las tranferencias
  a cuentas del exterior

  @smokeTest @transferencias @smokeTestHistoricoCuentasExterior @auto-301 @TestCaseKey=TEST-T2103
  Scenario Outline: consultar historico de las transferencias a cuentas del exterior para todas las opciones
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Ingresa los campos para generar el historico de cuentas del exterior
      | subFuncionalidad   | numeroTranferencia   | aliasBeneficiario   | paisBeneficiario   | desde   | hasta   |
      | <subFuncionalidad> | <numeroTranferencia> | <aliasBeneficiario> | <paisBeneficiario> | <desde> | <hasta> |
    Then Deberia ver el registro generado por la consulta del historico para el siguiente numero de transaccion: "<numeroTransaccion>"
      | Fecha  proceso   | Hora proceso   | numeroTransaccion   | Nombre usuario   | Cuenta origen   | beneficiario   | bancoBeneficiario   | pais   | Importe   | Moneda   | estadoConsulta   |
      | <Fecha  proceso> | <Hora proceso> | <numeroTransaccion> | <Nombre usuario> | <Cuenta origen> | <beneficiario> | <bancoBeneficiario> | <pais> | <Importe> | <Moneda> | <estadoConsulta> |

    Examples:

      | usuario | contrasena | perfil           | modulo         | funcionalidad | subFuncionalidad     | numeroTranferencia | aliasBeneficiario | paisBeneficiario | desde      | hasta      | Fecha  proceso | Hora proceso | numeroTransaccion | Nombre usuario   | Cuenta origen | beneficiario        | bancoBeneficiario     | pais      | Importe   | Moneda | estadoConsulta     |
     ##@externaldata@src/test/resources/data/transferencias/historicos/historicos_data.xlsx@cuentasExterior@1
   |146977   |1234   |Persona Juridica   |Transferencias   |Históricos   |Cuentas del exterior   |422632   |Todos   |Todos   |10/10/2022   |10/10/2022   |10/10/2022   |11:15:43   |422632   |PERSONA JURIDICA   |1042094528   |VILLAR HERMANOS S A   |BANCO SANTANDER CHILE   |152 CHILE   |20,910.00   |$us   |Confirmado|


