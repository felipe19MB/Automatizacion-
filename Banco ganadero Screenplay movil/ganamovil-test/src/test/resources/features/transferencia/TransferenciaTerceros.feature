@TransferenciaTerceros
Feature: Transferencia a Terceros
  Quiero iniciar una transferencia a terceros usando una cuenta de origen y de destino

  @TEST-T514 @SmokeTest @TransferenciaTerceros @Transferencia
  Scenario Outline: Como usuario quiero realizar una transferencia a terceros para obtener un comprobante de transferencia.
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
      |Transferencias|
    When Selecciono la cuenta origen
      |<nroCuentaOrigen>|<usuario>|
    And Selecciono el tipo de transferencia
      |<tipoTransferencia>|
    And Selecciono la cuenta destino
      |<nroCuentaDestino>|
    And Selecciono la moneda
      |<moneda>|
    And Ingreso el importe y descripcion
      |<importe>|<descripcion>|
    And Verifico los datos del Resumen
      |<nroCuentaOrigen>|<nroCuentaDestino>|<importe>|<moneda>|<descripcion>|
    And Finalizo la transferencia
    Then Obtengo un comprobante de transferencia a terceros con los datos de la transferencia
      |<nroCuentaOrigen>|<nroCuentaDestino>|<importe>|<moneda>|<descripcion>|



    Examples:
      |ID|usuario|password|tipoTransferencia|nroCuentaOrigen|nroCuentaDestino|importe|moneda|descripcion|
      ##@externaldata@./src/test/resources/data/Transferencias/DatosTransTerceros.xlsx@HappyPath@1
   |1   |44970   |1234   |a cuentas de terceros   |CA 1051953816   |1310160616   |20.00    |Bolivianos (Bs)   |Pago Mensual|
