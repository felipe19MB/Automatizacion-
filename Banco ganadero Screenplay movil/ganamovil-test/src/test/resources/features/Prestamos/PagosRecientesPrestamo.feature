@PagosRecientesPrestamo
Feature: Pagos Recientes de Prestamo
  Quiero visualizar un reporte de los pagos recientes del prestamo

  @TEST-TVivian @SmokeTest
  Scenario Outline: como usuario quiero visualizar mis ultimos pagos de prestamo que tengo en el banco.
    Given Cliente abre aplicacion
    And Ingreso mi usuario
      |<usuario>|
    And Ingreso mi password
      |<password>|
    And Ingreso a la opcion
      |Préstamos|
    When Genero listado de pagos reciente de prestamo
      |<nroCuentaOrigen>|
    Then Verifico los datos del prestamo
      |<mesDelPago>|<montoDelPago>|





    Examples:
      |ID|usuario|password|nroCuentaOrigen|mesDelPago|montoDelPago|
       ##@externaldata@./src/test/resources/data/Prestamos/PagosRecientes.xlsx@HappyPath
   |1   |5279020   |1234   |101104243   |Abr   |367.43 Bs|
   |2   |5279020   |1234   |101104243   |Mar   |380.09 Bs|
   |3   |5279020   |1234   |101104243   |Jul   |374.11 Bs|
