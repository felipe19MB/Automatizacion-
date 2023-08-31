@OrdenDeCobro
Feature: Como usuario quiero generar una orden de cobro para realizar cobros

  @smokeTest @ordenCobroSimple @smokeTestOrdenDeCobro @auto-145 @TestCaseKey=TEST-T2161
  Scenario Outline: Generar orden de cobro
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When genera la orden de cobro
      | nroCuenta   | usuario   | tipoCobro   | fechaVencimiento   | moneda   | monto   | descripcion   |
      | <nroCuenta> | <usuario> | <tipoCobro> | <fechaVencimiento> | <moneda> | <monto> | <descripcion> |
    Then Deberia ver el codigo qr generado correctamente
      | nroCuenta   | monto   |
      | <nroCuenta> | <monto> |
    Examples:
      | usuario  | contrasena | perfil          | modulo         | funcionalidad  | nroCuenta  | tipoCobro | fechaVencimiento | moneda     | monto | descripcion        |
      ##@externaldata@src/test/resources/data/orden_cobro_simple/orden_de_cobro_data.xlsx@happy_path
   |12230440   |1234   |Persona Natural   |Orden de Cobro   |Orden de cobro   |1310533276   |Único uso    |1 mes    |Bolivianos    |10   |esto es una prueba|
