@PagoServicios
Feature: Pago de Servicios
  Quiero realizar el pago de un servicio

  @PagoServicio @SmokeTest
  Scenario Outline: Como usuario quiero realizar un pago de servicio para obtener un comprobante de pago.
    Given Cliente abre aplicacion
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Pago de Servicios|Realizar Pago|
    When Ingreso los datos para pago del servicio
      |<nroCuentaOrigen>|<compania>|<servicioAfiliado>|<deuda>|<codigo>|<nroDeuda>|<convenio>|<gestion>|
    And Proceso el pago del servicio
    Then Obtengo un comprobante de pago del servicio
      |<nroCuentaOrigen>|<compania>|<servicioAfiliado>|<deuda>|<importe>|<descripcion>|



    Examples:
      |ID|usuario|password|nroCuentaOrigen|compania|servicioAfiliado|deuda|importe|descripcion|codigo|nroDeuda|convenio|gestion|
      ##@externaldata@./src/test/resources/data/PagoServicios/DatosPagoServicio.xlsx@HappyPath@1
   |1   |44970   |1234   |CA 1051075307   |COLEGIO - SAINT GEORGE   |PEREZ CHACON CASTEDO CAMILA   |MEN 4/2022   |2,303.00   |MEN 2/2022   |46836   |2   |48   |2022|

