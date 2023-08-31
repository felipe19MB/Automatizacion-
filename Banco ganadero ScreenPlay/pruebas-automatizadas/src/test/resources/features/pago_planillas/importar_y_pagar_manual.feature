@pagoPlanillas
Feature: Como firmante de la empresa
  Quiero realizar el pago de planillas de manera manual para las planillas de sueldo o de proovedores
  Y autorizar la transacción por los diferentes tipos de aprobación permitidos
  Para transferir los fondos desde mi convenio a las cuentas de nuestros empleados o proovedores

  @smokeTest @planillas @auto-954 @smokeTestPagoPlanillas @TestCaseKey=TEST-T2116
  Scenario Outline: Importar y pagar la planilla de manera manual para el sueldo aprobando por el monto total
    Given El cliente ingresa a la pagina de gananet
      | usuario     | contrasena   |
      | <usuario>   | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When importa la planilla de manera "Manual" para pagar a los "empleados" aprobando el "Monto Total"
    Then debería confirmar el comprobante del pago de la planilla y la descarga de los archivos correspondientes
    Examples:
      | usuario | contrasena | perfil           | modulo            | funcionalidad             |importe|cuenta|
       ##@externaldata@src/test/resources/data/pago_planillas/pago_planilla_data.xlsx@pagoPlanilla
   |812   |1234   |Persona Juridica   |Pago de Planillas   |Importar y pagar planilla   |1   |1051368683|
