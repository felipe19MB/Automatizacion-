@consultaACHYCheques
Feature: Yo como usuario deseo realizar una Consulta ACH Y cheques para ver mi historial de
  rechazos,cancelaciones

  @smokeTest @planillas @smokeTestConsultaACHYCheques @auto-413 @TestCaseKey=TEST-T2094
  Scenario Outline:  consultar mis ACH y cheques para todos los tipos de reporte por nro de planilla
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Ingresa los campos para la consulta ACH y cheques
      | servicio   | tipoDeReporte   | busqueda   | numeroPlanilla   |
      | <servicio> | <tipoDeReporte> | <busqueda> | <numeroPlanilla> |
    Then Deberia ver el registro generado de la consulta
      | convenio   | lote   | nroPlanilla   | fechaProceso   | fechaDeVigencia   | beneficiario   | nroIdentificacion   | importe   | moneda   | bancoDestinatario   | motivoRechazo   |
      | <convenio> | <lote> | <nroPlanilla> | <fechaProceso> | <fechaDeVigencia> | <beneficiario> | <nroIdentificacion> | <importe> | <moneda> | <bancoDestinatario> | <motivoRechazo> |

    Examples:
      | usuario | contrasena | perfil           | modulo            | funcionalidad             | servicio                                      | tipoDeReporte | busqueda         | numeroPlanilla | convenio | lote    | nroPlanilla | fechaProceso | fechaDeVigencia | beneficiario                     | nroIdentificacion | importe  | moneda     | bancoDestinatario | motivoRechazo         |
      ##@externaldata@src/test/resources/data/pago_planillas/pago_planilla_data.xlsx@planilla@1
   |452004   |1234   | Persona Juridica    |Pago de Planillas   |Consulta de ACH y Cheques   |93249 - 1310638257 - PAGO A PROVEEDORES EMBOL   |TODOS   |NRO. DE PLANILLA   |2954891   |93249   |5552983   |2954891   |09/04/2022   |01/05/2022   |CIMAR FERNANDO ESPINOZA SANDOVAL   |5686715018   |7,880.32   |BOLIVIANOS   |BANCO DE CREDITO   |CUENTA NO EXISTE PAGO|








