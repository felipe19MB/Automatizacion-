@TransferenciaOtrosBancos
Feature: Transferencia a Otros Bancos
  Quiero iniciar una transferencia a otros bancos usando una cuenta de origen y de destino

  @TEST-T514 @SmokeTest @Transferencia @TransOtrosBancos
  Scenario Outline: Como usuario quiero realizar una transferencia a otros bancos para obtener un comprobante de transferencia.
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
    Then Obtengo un comprobante de transferencia a otros bancos con los datos de la transferencia
      |<nroCuentaOrigen>|<nroCuentaDestino>|<importe>|<moneda>|<descripcion>|



    Examples:
      |ID|usuario|password|tipoTransferencia|nroCuentaOrigen|nroCuentaDestino|importe|moneda|descripcion|
      ##@externaldata@./src/test/resources/data/Transferencias/DatosTransOtrosBancos.xlsx@HappyPath@1
   |1   |44970   |1234   |a cuentas de otros bancos   |CA 1051075307   |1871904011   |20.00    |Bolivianos (Bs)   |Pago Mensual|


