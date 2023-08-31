@AfiliacionTerceros
Feature: Afiliacion de cuentas de terceros
  Quiero afiliar una cuenta de terceros

  @TEST-T1317 @SmokeTest @Afiliacion
  Scenario Outline: Como usuario quiero afiliar una cuenta de tercero para tenerla en mi lista
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
    When Selecciono el tipo de transferencia
      |<tipoTransferencia>|
    And Selecciono adiciona cuentas
    And Ingreso el Numero de Cuenta Nombre y Referencia
      |<nroCuentaDestino>|<nombre>|<referencia>|
    And Finalizo el registro
    Then Obtengo una alerta de registro exitoso
      |<mensajeRegistro>|
    And Elimino el afiliado
      |<nroCuentaDestino>|


    Examples:
      |ID|usuario|password|tipoTransferencia|nroCuentaDestino|nombre|referencia|mensajeRegistro|
      ##@externaldata@./src/test/resources/data/Transferencias/Afiliacion/DatosAfiliacionTerceros.xlsx@HappyPath@1
   |1   |8860   |1234   |a cuentas de terceros   |1051368683   |PAUL AYALA   |PAUL   |Registro realizado con éxito. Tu primer transacción no quedará pignorada|
