@consulta
Feature: Consulta de Comprobantes de movimientos

  @TST-0001 @comprobantes @consultaComprobantes @smokeTest @smokeTestConsultaComprobantes
  Scenario Outline: Consulta

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Comprobantes|Consulta|
    And Consulto comprobantes de movimientos
      |<tipoMovimiento>|<cuenta>|<fechaDesde>|<fechaHasta>|<nroAsiente>|
    Then Obtengo un comprobante de debito
      |<cuentaOrigen>|<nombre>|<importeDebitado>|<cuentaDestino>|<importe>|<glosa>|

    Examples:
      |ID|tipoUsuario|usuario|password|tipoMovimiento|cuenta|fechaDesde|fechaHasta|nroAsiente|cuentaOrigen|nombre|importeDebitado|cuentaDestino|importe|glosa|
      ##@externaldata@./src/test/resources/data/comprobantes/datosConsulta.xlsx@HappyPath
      |2 |CODIGO_PERSONA  |812   |1234|TODA          |1051075307 Bs - EMPLEADOS - CLASICA Bs|11/11/2022|11/11/2022|999001834|1051075307|PAUL AYALA PEREZ|1.00 Bs|1051368683|1.00 Bs|Transferencia a 1051368683. PAUL AYALA PEREZ pruebas de transferencai propias|